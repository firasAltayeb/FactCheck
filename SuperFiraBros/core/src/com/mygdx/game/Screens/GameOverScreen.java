package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MarioBros;

/**
 * Created by firas on 12/12/2016.
 */

public class GameOverScreen implements Screen{

    //Asset manager.
    private AssetManager manager;

    //Stage, camera
    private Viewport viewport;
    private Stage stage;
    private Game game;

    //State timer.
    private float stateTime;

    public GameOverScreen(Game game, AssetManager manager) {
        this.game = game;
        this.manager = manager;

        //manager.get("audio/sounds/mariodie.wav", Sound.class).play();

        viewport = new FillViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, (((MarioBros) game).batch));

        Label.LabelStyle font = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

        stateTime = 0;

        //Labels.
        Label gameOverLabel = new Label("GAME OVER", font);
        Label playAgainLabel = new Label("Click to Play Again", font);

        //Table.
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(gameOverLabel).expandX();
        table.row(); //Added new to move label to next line
        table.add(playAgainLabel).expandX().padTop(10f);

        stage.addActor(table);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            dispose();
            game.setScreen(new Screen_level_1((MarioBros) game, manager));
        }
        else if (stateTime > 5) {
            dispose();
            game.setScreen(new MenuScreen((MarioBros) game, manager));
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        stage.dispose();
    }
}
