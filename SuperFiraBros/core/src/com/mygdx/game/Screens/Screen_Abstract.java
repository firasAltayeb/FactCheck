package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MarioBros;
import com.mygdx.game.Scenes.Hud;
import com.mygdx.game.Sprites.Enemies.Enemy;
import com.mygdx.game.Sprites.Items.Item;
import com.mygdx.game.Sprites.Items.ItemDef;
import com.mygdx.game.Sprites.Items.Mushroom;
import com.mygdx.game.Sprites.Mario;
import com.mygdx.game.Tools.B2WorldCreator;
import com.mygdx.game.Tools.Controller;
import com.mygdx.game.Tools.WorldContactListener;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by firas on 01/11/2016.
 */

public abstract class Screen_Abstract implements Screen{
    //Reference to our Game, used to set Screens. Main game.
    protected MarioBros game;

    //Asset manager.
    protected AssetManager manager;

    //Textures
    protected TextureAtlas atlas;

    //Camera, viewport
    protected OrthographicCamera camera;
    protected Viewport viewport;
    protected float cameraBorderLeft;
    protected float cameraBorderRight;

    //HUD
    protected Hud hud;

    //tiled map variables
    protected TmxMapLoader mapLoader;
    protected TiledMap map;
    protected OrthogonalTiledMapRenderer mapRenderer;

    //box2d variables
    protected World world;
    protected Box2DDebugRenderer b2dr;
    protected WorldContactListener worldContactListener;
    protected B2WorldCreator worldCreator;

    //Player and enemies
    protected Mario mario;
    protected float speed;

    //Items
    protected Array<Item> items;
    //This queue orders elements FIFO (first-in-first-out)
    protected LinkedBlockingQueue<ItemDef> itemToSpawn;

    //Joypad-like controller.
    protected boolean controllerOn;
    protected Controller controller;


    public Screen_Abstract(final MarioBros game, final AssetManager manager){
        this.game = game;
        this.manager = manager;

        //Textures
        atlas = new TextureAtlas("graphic/Mario_and_Enemies.pack");

        //Camera to follow Mario, Viewport.
        camera = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH / MarioBros.PPM, MarioBros.V_HEIGHT / MarioBros.PPM, camera);

        //HUD
        hud = new Hud(game.batch);

        //Parameters for tiled texture rendering. Change Nearest to Linear for filtering.
        TmxMapLoader.Parameters params = new TmxMapLoader.Parameters();
        params.textureMinFilter = Texture.TextureFilter.Nearest;
        params.textureMagFilter = Texture.TextureFilter.Nearest;

        //Load our map and setup our map renderer
        mapLoader = new TmxMapLoader();
        map = mapLoader.load(mapName(), params);
        mapRenderer = new OrthogonalTiledMapRenderer(map, 1 / MarioBros.PPM);

        //Set borders. Subtract one tile from each side. TMX file must have 1 tile offset (eg, pipes) on sides.
        cameraBorderLeft = (MarioBros.V_WIDTH / MarioBros.PPM / 2) + (((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth() / MarioBros.PPM);//Viewport half + tile size.
        cameraBorderRight = (((TiledMapTileLayer) map.getLayers().get(0)).getWidth() *
                ((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth() / MarioBros.PPM) - (MarioBros.V_WIDTH / MarioBros.PPM / 2) -
                (((TiledMapTileLayer) map.getLayers().get(0)).getTileWidth() / MarioBros.PPM); //Map width (in tiles) * tiles size - viewport width - tile size.

        //Set camera. Center camera in the middle of the viewport.
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);

        //Create world.
        world = new World(new Vector2(0, -10), true);//first parameter for gravity and second for sleep object at rest
        worldContactListener = new WorldContactListener();
        world.setContactListener(new WorldContactListener());
        b2dr = new Box2DDebugRenderer();
        worldCreator = new B2WorldCreator(this);

        //create mario in our game world
        mario = new Mario(this);


        //items
        items = new Array<Item>();
        itemToSpawn = new LinkedBlockingQueue<ItemDef>();

        //Controller.
        controllerOn = true;
        controller = new Controller(game.batch);

    }

    public abstract String mapName();

    @Override
    public void render(float delta) {
        update(delta);

        //Clear the game screen with Black
        Gdx.gl.glClearColor(0.39f, 0.68f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //render our game map
        mapRenderer.render();

        //render our Box2DDebugLines
        b2dr.render(world, camera.combined);

        //Draw items and enemies.
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        mario.draw(game.batch);
        for(Enemy enemy : worldCreator.getEnemies())
            enemy.draw(game.batch);
        for(Item item : items){
            item.draw(game.batch);
        }
        game.batch.end();

        //Set our batch to now draw what the Hud camera sees.
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        //Check if game is over, so draw Game Over screen.
        if(gameOver()){
            dispose();
            game.setScreen(new GameOverScreen(game, manager));
        }
    }

    public void update(float dt) {
        //Gdx.app.log("Update", worldContactListener.feetOnGround + "");

        if (controllerOn)
            handleInput(dt); //Handle user input first.

        handleSpawningItems();

        //Takes 1 step in the physics simulation (60 times per second)
        world.step(1 / 60f, 6, 2);

        mario.update(dt);
        for (Enemy enemy : worldCreator.getEnemies()){
            enemy.update(dt);
            //224 = 14 * 16 (Bricks from Mario * BrickSize).
            if (enemy.getX() < mario.getX() + 224 / MarioBros.PPM){
                //Set enemy active only if player is close (at < upper value).
                enemy.b2body.setActive(true);
            }
        }

        for(Item item : items){
            item.update(dt);
        }

        hud.update(dt);

        //Attach our camera to our players.x coordinate. Set camera boundaries.
        if(mario.currentState != Mario.State.DEAD) {
            //camera.position.x = mario.b2body.getPosition().x;
            camera.position.x = MathUtils.clamp(mario.b2body.getPosition().x, cameraBorderLeft, cameraBorderRight);
        }
        //update our camera with correct coordinates after changes
        camera.update();
        mapRenderer.setView(camera);
    }

    public void spawnItem(ItemDef idef){
        itemToSpawn.add(idef);
    }

    public void handleSpawningItems(){
        if(!itemToSpawn.isEmpty()){
            //This queue orders elements FIFO (first-in-first-out)
            ItemDef idef = itemToSpawn.poll();
            if(idef.type == Mushroom.class){
                items.add(new Mushroom(this, idef.postion.x, idef.postion.y));
            }
        }
    }

    public void handleInput(float dt){
//        if(Gdx.input.isTouched()){
//            camera.position.x += 3 * dt;
//        }

        //control our mario using immediate impules
        if(mario.currentState != Mario.State.GROWING) {
            if (mario.currentState != Mario.State.DEAD) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.UP) || controller.isUpPressed()
                        || controller.isbPressed()) //&& worldContactListener.jumpability())
                {
                    //Gdx.app.log("Up Pressed", worldContactListener.feetOnGround + "");
                    mario.jump();
                }
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && mario.b2body.getLinearVelocity().x <= speed
                        || controller.isRightPressed() && mario.b2body.getLinearVelocity().x <= speed) {
                    //Gdx.app.log("right Pressed", worldContactListener.feetOnGround + "");
                    mario.b2body.applyLinearImpulse(new Vector2(0.1f, 0), mario.b2body.getWorldCenter(), true);
                }
                if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && mario.b2body.getLinearVelocity().x >= -speed
                        || controller.isLeftPressed() && mario.b2body.getLinearVelocity().x >= -speed) {
                    mario.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), mario.b2body.getWorldCenter(), true);
                }
            }
        }

        //Run faster.
        if (controller.isaPressed())
            speed = 3;
        else
            speed = 1;
    }

    public boolean gameOver() {
        //stateTimer > 3, check if mario has been dead for 3 seconds
        if (mario.currentState == Mario.State.DEAD && mario.getStateTimer() > 3) {
            return true;
        }
        return false;
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public TiledMap getMap(){
        return map;
    }

    public World getWorld(){
        return world;
    }

    public TextureAtlas getAtlas(){
        return atlas;
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        MarioBros.musicStop(); //Stops all music before going to next screen (level).
        map.dispose();
        mapRenderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();

    }
}
