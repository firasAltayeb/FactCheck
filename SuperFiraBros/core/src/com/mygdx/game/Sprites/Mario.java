package com.mygdx.game.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MarioBros;
import com.mygdx.game.Screens.Screen_Abstract;
import com.mygdx.game.Sprites.Enemies.Enemy;
import com.mygdx.game.Sprites.Enemies.Turtle;

import static com.mygdx.game.Sprites.Mario.State.JUMPING;

/**
 * Created by firas on 01/12/2016.
 */
public class Mario extends Sprite {
    public enum State {FALLING, JUMPING, STANDING, RUNNING, GROWING, DEAD};
    public State currentState;
    public State previousState;

    public World world;
    public Body b2body;

    private TextureRegion marioStand;
    private TextureRegion marioJump;
    private TextureRegion marioDead;
    private TextureRegion bigMarioStand;
    private TextureRegion bigMarioJump;
    private Animation marioRun;
    private Animation bigMarioRun;
    private Animation growMario;

    private float stateTimer;
    public boolean marioIsBig;
    private boolean runningRight;
    private boolean runGrowAnimation;
    private boolean timeToDefineBigMario;
    private boolean timeToRedefineMario;
    private boolean marioIsDead;

    public Mario(Screen_Abstract screen){
        this.world = screen.getWorld();
        currentState = State.STANDING;
        previousState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        //Normal animations.
        Array<TextureRegion> frames = new Array<TextureRegion>();

        //create texture region for mario standing
        marioStand = new TextureRegion(screen.getAtlas().findRegion("little_mario"), 0, 0, 16, 16);
        bigMarioStand = new TextureRegion(screen.getAtlas().findRegion("big_mario"), 0, 0, 16, 32);

        //get run animation frames and add them to marioRun Animation
        for(int i = 1; i < 4; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("little_mario"), i * 16, 0, 16, 16));
        //change every 0.1 second
        marioRun = new Animation(0.1f, frames);

        frames.clear();

        for(int i = 1; i < 3; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), i*16, 0, 16, 32));
        bigMarioRun = new Animation(0.1f, frames);

        frames.clear();

        //set animation frames for growing mario
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 240, 0, 16, 32));
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 0, 0, 16, 32));
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 240, 0, 16, 32));
        frames.add(new TextureRegion(screen.getAtlas().findRegion("big_mario"), 0, 0, 16, 32));
        growMario = new Animation(0.2f, frames);

        //get jump animation frames and add them to marioJump Animation
        marioJump = new TextureRegion(screen.getAtlas().findRegion("little_mario"), 80, 0, 16, 16);
        bigMarioJump = new TextureRegion(screen.getAtlas().findRegion("big_mario"), 80, 0, 16, 32);

        //create texture region for dead mario
        marioDead = new TextureRegion(screen.getAtlas().findRegion("little_mario"), 96, 0, 16, 16);

        defineMario();
        setBounds(0, 0, 16/MarioBros.PPM, 16/MarioBros.PPM);
        setRegion(marioStand);
    }

    public void update(float dt){
        //To find the bottom left hand corner
        //getPosition().x or .y gets the center in X-axises or Y-axises
        if(marioIsBig)
            setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2 - 6 / MarioBros.PPM);
        else
            setPosition(b2body.getPosition().x - getWidth()/2, b2body.getPosition().y - getHeight()/2);

        setRegion(getFrame(dt));

        //Must define and redefine Mario with boolean and update, because body can't be destroyed in world.step cycle.
        if(timeToDefineBigMario){
            defineBigMario();
            timeToDefineBigMario = false;
        }
        if(timeToRedefineMario){
            redefineMario();
            timeToRedefineMario = false;
        }
    }

    public void defineMario(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(200/MarioBros.PPM, 30/MarioBros.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;

        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        fdef.friction = 0.4f;
        CircleShape shape = new CircleShape();
        shape.setRadius(5.5f/MarioBros.PPM);
        //Set the category
        fdef.filter.categoryBits = MarioBros.MARIO_BIT;
        //What can mario collide with
        fdef.filter.maskBits = MarioBros.GROUND_BIT
                | MarioBros.COIN_BIT
                | MarioBros.BRICK_BIT
                | MarioBros.ENEMY_BIT
                | MarioBros.OBJECT_BIT
                | MarioBros.ENEMY_HEAD_BIT
                | MarioBros.ITEM_BIT
                | MarioBros.PITFALL_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        //Create Mario's head and make it a sensor for smashing objects.
        EdgeShape head = new EdgeShape();//draws a line
        //line start from -2 to 2 in X-axises and is drawn in 5 Y-axises
        head.set(new Vector2(-2/MarioBros.PPM, 6/MarioBros.PPM), new Vector2(2/MarioBros.PPM, 6/MarioBros.PPM));
        fdef.shape = head;
        fdef.filter.categoryBits = MarioBros.MARIO_HEAD_BIT;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);

        //Create Mario's feet. Problem with this fixture if sensor = false.
        EdgeShape feet = new EdgeShape();
        //debug line
        feet.set(new Vector2(-2/MarioBros.PPM, -6/MarioBros.PPM), new Vector2(2/MarioBros.PPM, -6/MarioBros.PPM));
        fdef.shape = feet;
        fdef.filter.categoryBits = MarioBros.MARIO_FEET_BIT;
        fdef.filter.maskBits = MarioBros.GROUND_BIT | MarioBros.OBJECT_BIT | MarioBros.BRICK_BIT | MarioBros.COIN_BIT;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);

    }

    public void redefineMario(){
        Vector2 position = b2body.getPosition();
        world.destroyBody(b2body);

        BodyDef bdef = new BodyDef();
        bdef.position.set(position);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        fdef.friction = 0.4f;
        CircleShape shape = new CircleShape();
        shape.setRadius(5.5f/MarioBros.PPM);
        //Set the category
        fdef.filter.categoryBits = MarioBros.MARIO_BIT;
        //What can mario collide with
        fdef.filter.maskBits = MarioBros.GROUND_BIT
                | MarioBros.COIN_BIT
                | MarioBros.BRICK_BIT
                | MarioBros.ENEMY_BIT
                | MarioBros.OBJECT_BIT
                | MarioBros.ENEMY_HEAD_BIT
                | MarioBros.ITEM_BIT
                | MarioBros.PITFALL_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        //draws a line
        EdgeShape head = new EdgeShape();
        //line start from -2 to 2 in X-axises and is drawn in 5 Y-axises
        head.set(new Vector2(-2/MarioBros.PPM, 6/MarioBros.PPM), new Vector2(2/MarioBros.PPM, 6/MarioBros.PPM));
        fdef.shape = head;
        fdef.filter.categoryBits = MarioBros.MARIO_HEAD_BIT;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);

        //Create Mario's feet. Problem with this fixture if sensor = false.
        EdgeShape feet = new EdgeShape();
        feet.set(new Vector2(-2 / MarioBros.PPM, -7 / MarioBros.PPM), new Vector2(2 / MarioBros.PPM, -7 / MarioBros.PPM));
        fdef.shape = feet;
        fdef.filter.categoryBits = MarioBros.MARIO_FEET_BIT;
        fdef.filter.maskBits = MarioBros.GROUND_BIT | MarioBros.OBJECT_BIT | MarioBros.BRICK_BIT | MarioBros.COIN_BIT;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);
    }

    public void defineBigMario(){
        Vector2 currentPosition = b2body.getPosition();
        world.destroyBody(b2body);

        BodyDef bdef = new BodyDef();
        // 10/PPM moves mario up slightly from currentPosition
        bdef.position.set(currentPosition.add(0, 10/MarioBros.PPM));
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        fdef.friction = 0.4f; //Stop Mario from iceskating! ;)
        CircleShape shape = new CircleShape();
        shape.setRadius(4f/MarioBros.PPM);
        //Set the category
        fdef.filter.categoryBits = MarioBros.MARIO_BIT;
        //What can mario collide with
        fdef.filter.maskBits =
                MarioBros.GROUND_BIT
                | MarioBros.COIN_BIT
                | MarioBros.BRICK_BIT
                | MarioBros.ENEMY_BIT
                | MarioBros.OBJECT_BIT
                | MarioBros.ENEMY_HEAD_BIT
                | MarioBros.ITEM_BIT
                | MarioBros.PITFALL_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);
        //create a second radius and place it under the current one
        shape.setRadius(5.5f/MarioBros.PPM);
        shape.setPosition(new Vector2(0,-15f/MarioBros.PPM));
        b2body.createFixture(fdef).setUserData(this);

        //draws a line
        EdgeShape head = new EdgeShape();
        //line start from -2 to 2 in X-axises and is drawn in 5 Y-axises
        head.set(new Vector2(-2/MarioBros.PPM, 6/MarioBros.PPM), new Vector2(2/MarioBros.PPM, 6/MarioBros.PPM));
        fdef.shape = head;
        fdef.filter.categoryBits = MarioBros.MARIO_HEAD_BIT;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);

        //Create Mario's feet. Problem with this fixture if sensor = false.
        EdgeShape feet = new EdgeShape();
        feet.set(new Vector2(-2 / MarioBros.PPM, -7 / MarioBros.PPM), new Vector2(2/MarioBros.PPM, -7/MarioBros.PPM));
        fdef.shape = feet;
        fdef.filter.categoryBits = MarioBros.MARIO_FEET_BIT;
        fdef.filter.maskBits = MarioBros.GROUND_BIT | MarioBros.OBJECT_BIT | MarioBros.BRICK_BIT | MarioBros.COIN_BIT;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);
    }

    public TextureRegion getFrame(float dt){
        currentState = getState();

        TextureRegion region;
        switch(currentState){
            case DEAD:
                region = marioDead;
                break;
            case GROWING:
                region = growMario.getKeyFrame(stateTimer);
               if(growMario.isAnimationFinished(stateTimer))
                    runGrowAnimation = false;
                break;
            case JUMPING:
                //StateTimer decide which frame to be rendered/pulled from animation
                region = marioIsBig ? bigMarioJump : marioJump;
                break;
            case RUNNING:
                region = marioIsBig ? bigMarioRun.getKeyFrame(stateTimer, true) :  marioRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
             default:
                 region = marioIsBig ? bigMarioStand : marioStand;
                 break;
        }

        //if mario is running left and the texture isnt facing left... flip it.
        if((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()){
            //The first parameter in flip() is for X-axises and the second is for Y-axises
            region.flip(true, false);
            runningRight = false;
        }

        //if mario is running right and the texture isnt facing right... flip it.
        else if((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()){
            //The first parameter in flip() is for X-axises and the second is for Y-axises
            region.flip(true, false);
            runningRight = true;
        }

        //If the state has transitioned then we need to reset the timer
        stateTimer = currentState == previousState ? stateTimer + dt : 0;
        //update previous state
        previousState = currentState;
        //return our final adjusted frame
        return region;
    }

    public State getState(){
        if(marioIsDead)
            return State.DEAD;
        else if(runGrowAnimation)
            return State.GROWING;
        else if(b2body.getLinearVelocity().y >0 || (b2body.getLinearVelocity().y < 0 &&
                                                    previousState == JUMPING))
            return JUMPING;
        //if negative in Y-Axis mario is falling
        else if (b2body.getLinearVelocity().y <0)
            return State.FALLING;
            //if mario is positive or negative in the X axis he is running
        else if (b2body.getLinearVelocity().x != 0)
            return State.RUNNING;
            //if none of these return then he must be standing
        else
            return State.STANDING;
    }

    public void grow(){
        if(!marioIsBig) {
            runGrowAnimation = true;
            marioIsBig = true;
            timeToDefineBigMario = true;
            setBounds(getX(), getY(), getWidth(), getHeight() * 2);
            MarioBros.manager.get("audio/sounds/powerup.wav", Sound.class).play();
        }
    }

    public void isDead(){
        MarioBros.manager.get("audio/music/mario_music.ogg", Music.class).stop();
        MarioBros.manager.get("audio/sounds/mariodie.wav", Sound.class).play();
        marioIsDead = true;
        //Set all fixture in b2body list to non_collie_able
        Filter filter = new Filter();
        filter.maskBits = MarioBros.NOTHING_BIT;
        for (Fixture fixture : b2body.getFixtureList())
            fixture.setFilterData(filter);
    }

    public float getStateTimer(){
        return stateTimer;
    }

    public boolean isBig(){
        return marioIsBig;
    }

    public void jump(){
        Gdx.app.log("State", currentState + "");
        if (currentState != State.JUMPING)// && currentState != State.GROWING)
        {
            b2body.applyLinearImpulse(new Vector2(0, 4f), b2body.getWorldCenter(), true);
            currentState = State.JUMPING;
        }
    }

    public void hit(Enemy enemy){
        if(enemy instanceof Turtle && ((Turtle) enemy).getCurrentState() == Turtle.State.STANDING_SHELL){
            //check if mario is in left to kick  right otherwise mario kicks left
            ((Turtle) enemy).kick(this.getX() <= enemy.getX() ? Turtle.KICK_RIGHT_SPEED : Turtle.KICK_LEFT_SPEED);
        }
        else {
            if (marioIsBig) {
                marioIsBig = false;
                timeToRedefineMario = true;
                setBounds(getX(), getY(), getWidth(), getHeight() / 2);
                MarioBros.manager.get("audio/sounds/powerdown.wav", Sound.class).play();
            } else {
                MarioBros.manager.get("audio/music/mario_music.ogg", Music.class).stop();
                MarioBros.manager.get("audio/sounds/mariodie.wav", Sound.class).play();
                marioIsDead = true;
                //Set all fixture in b2body list to non_collie_able
                Filter filter = new Filter();
                filter.maskBits = MarioBros.NOTHING_BIT;
                for (Fixture fixture : b2body.getFixtureList())
                    fixture.setFilterData(filter);
                //Pushes mario up
                b2body.applyLinearImpulse(new Vector2(0, 4f), b2body.getWorldCenter(), true);
            }
        }
    }

}
