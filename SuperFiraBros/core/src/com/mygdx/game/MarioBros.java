package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MenuScreen;

public class MarioBros extends Game {

	public static final int V_WIDTH = 370;
	public static final int V_HEIGHT = 238;

	//Pixels per meter
	public static final float PPM = 100;

	public static final short NOTHING_BIT = 0;
	public static final short GROUND_BIT = 1;
	public static final short MARIO_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short COIN_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short OBJECT_BIT = 32;
	public static final short ENEMY_BIT = 64;
	public static final short ENEMY_HEAD_BIT = 128;
	public static final short MARIO_FEET_BIT = 256;
	public static final short MARIO_HEAD_BIT = 512;
	public static final short ITEM_BIT = 1024;
	public static final short PITFALL_BIT = 2048;

	public static AssetManager manager;
	public SpriteBatch batch;

	@Override
	public void create () {
		manager = new AssetManager(); //Must pass it to every class that needs it.
		manager.load("audio/music/mario_music.ogg", Music.class);
		manager.load("audio/sounds/coin.wav", Sound.class);
		manager.load("audio/sounds/bump.wav", Sound.class);
		manager.load("audio/sounds/breakblock.wav", Sound.class);
		manager.load("audio/sounds/powerup_spawn.wav", Sound.class);
		manager.load("audio/sounds/powerup.wav", Sound.class);
		manager.load("audio/sounds/stomp.wav", Sound.class);
		manager.load("audio/sounds/powerdown.wav", Sound.class);
		manager.load("audio/sounds/mariodie.wav", Sound.class);
		manager.finishLoading(); //Wait for everything to load.

		batch = new SpriteBatch();

		setScreen(new MenuScreen(this, manager));
	}


	@Override
	public void render () {
		super.render();
	}

	public static void musicStop() {
		manager.get("audio/music/mario_music.ogg", Music.class).stop();
	}

	
	@Override
	public void dispose () {
		super.dispose();
		manager.dispose();
		batch.dispose();
	}
}
