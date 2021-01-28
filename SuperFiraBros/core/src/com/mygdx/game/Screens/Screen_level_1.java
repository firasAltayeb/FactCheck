package com.mygdx.game.Screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.MarioBros;
import com.mygdx.game.Scenes.Hud;

/**
 * Created by firas on 14/12/2016.
 */

public class Screen_level_1 extends Screen_Abstract{

    //Audio.
    protected Music music;

    public Screen_level_1(MarioBros game, AssetManager manager) {
        super(game, manager);

        Hud.setPaused(false); //Unpause HUD counter.

        //Audio.
        music = manager.get("audio/music/mario_music.ogg", Music.class);
        music.setLooping(true);
        music.play();
    }

    @Override
    public String mapName() {
        return "graphic/firaslvl1.tmx";
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        //Draw controller.
        if (controllerOn)
            controller.draw();
    }

}