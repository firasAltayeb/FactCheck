package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.mygdx.game.MarioBros;

/**
 * Created by firas on 14/12/2016.
 */

public class MenuScreen extends Screen_Abstract {

    public MenuScreen(MarioBros game, AssetManager manager) {
        super(game, manager);
    }

    @Override
    public void render(float dt) {
        super.render(dt);

        //Screen changing must go through render() method.
        if (Gdx.input.justTouched()) {
            dispose();
            game.setScreen(new Screen_level_1((MarioBros) game, manager));
        }
    }

    @Override
    public String mapName() {
        return "graphic/menu.tmx";
    }

    @Override
    public void handleInput(float dt) {}

}