package com.mygdx.game.Sprites.Enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Screens.Screen_Abstract;
import com.mygdx.game.Sprites.Mario;

/**
 * Created by firas on 10/12/2016.
 */

public abstract class Enemy extends Sprite {
    protected World world;
    protected Screen_Abstract screen;
    public Body b2body;
    public Vector2 velocity;

    public Enemy(Screen_Abstract screen, float x, float y){
        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x, y);
        defineEnemy();
        // 1 in X-axis 0 in Y-axis
        velocity = new Vector2(-0.8f, -1.5f);
        //Sleep until woken up
        b2body.setActive(false);
    }


    protected abstract void defineEnemy();
    public abstract void update(float dt);
    public abstract void hitOnHead(Mario mario);
    public abstract void onEnemyHit(Enemy enemy);
    public void reverseVelocity(boolean x, boolean y){
        if(x)
            velocity.x = -velocity.x;
        if(y)
            velocity.y = -velocity.y;
    }
}

