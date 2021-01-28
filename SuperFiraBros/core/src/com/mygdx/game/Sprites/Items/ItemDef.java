package com.mygdx.game.Sprites.Items;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by firas on 11/12/2016.
 */

public class ItemDef {
    public Vector2 postion;
    public Class<?> type;
    //takes a vector2 and any type of class
    public ItemDef(Vector2 postion, Class<?> type){
        this.postion = postion;
        this.type = type;
    }
}
