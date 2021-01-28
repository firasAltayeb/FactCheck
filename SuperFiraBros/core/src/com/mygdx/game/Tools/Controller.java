package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MarioBros;

/**
 * Created by firas on 14/12/2016.
 */

public class Controller {

    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean aPressed;
    private boolean bPressed;
    private Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    private Image buttonUp;
    private Image buttonDown;
    private Image buttonLeft;
    private Image buttonRight;
    private Image buttonA;
    private Image buttonB;
    private Table tableDirectional;
    private Table tableAB;

    //Constructor.
    public Controller(SpriteBatch spriteBatch) {
        camera = new OrthographicCamera();
        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, camera);
        stage = new Stage(viewport, spriteBatch);
        Gdx.input.setInputProcessor(stage);

        //Directional buttons with images.
        buttonUp = new Image(new Texture("graphic/buttonup.png"));
        buttonUp.setSize(25, 25);
        buttonUp.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upPressed = false;
            }
        });

        buttonDown = new Image(new Texture("graphic/buttondown.png"));
        buttonDown.setSize(25, 25);
        buttonDown.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downPressed = false;
            }
        });

        buttonLeft = new Image(new Texture("graphic/buttonleft.png"));
        buttonLeft.setSize(25, 25);
        buttonLeft.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftPressed = false;
            }
        });

        buttonRight = new Image(new Texture("graphic/buttonright.png"));
        buttonRight.setSize(25, 25);
        buttonRight.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightPressed = false;
            }
        });

        //AB buttons with images.
        buttonA = new Image(new Texture("graphic/buttona.png"));
        buttonA.setSize(25, 25);
        buttonA.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                aPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                aPressed = false;
            }
        });

        buttonB = new Image(new Texture("graphic/buttonb.png"));
        buttonB.setSize(25, 25);
        buttonB.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                bPressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                bPressed = false;
            }
        });

        //Table with directional buttons.
        tableDirectional = new Table();
        tableDirectional.setFillParent(true);
        //tableDirectional.setDebug(true); //Render debug lines.
        tableDirectional.left().bottom().pad(5, 5, 5, 5); //Align to the left bottom.
        tableDirectional.add().space(5);
        tableDirectional.add(buttonUp).size(buttonUp.getWidth(), buttonUp.getHeight()).space(5);
        tableDirectional.add().space(5);
        tableDirectional.row();
        tableDirectional.add(buttonLeft).size(buttonLeft.getWidth(), buttonLeft.getHeight()).space(5);
        tableDirectional.add().space(5);
        tableDirectional.add(buttonRight).size(buttonRight.getWidth(), buttonRight.getHeight()).space(5);
        tableDirectional.row();
        tableDirectional.add().space(5);
        tableDirectional.add(buttonDown).size(buttonDown.getWidth(), buttonDown.getHeight()).space(5);
        tableDirectional.add().space(5);

        //Table with AB buttons.
        tableAB = new Table();
        tableAB.setFillParent(true);
        //tableAB.setDebug(true);
        tableAB.bottom().right().pad(5, 5, 5, 5);
        tableAB.add().space(5);
        tableAB.add(buttonB).size(buttonB.getWidth(), buttonB.getHeight()).space(5);
        tableAB.row().space(5);
        tableAB.add(buttonA).size(buttonA.getWidth(), buttonA.getHeight()).space(5);
        tableAB.add().space(5);

        stage.addActor(tableDirectional);
        stage.addActor(tableAB);
    }

    public void draw() {
        stage.draw();
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    //Getters.
    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isaPressed() {
        return aPressed;
    }

    public boolean isbPressed() {
        return bPressed;
    }


}
