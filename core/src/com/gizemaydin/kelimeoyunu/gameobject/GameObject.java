package com.gizemaydin.kelimeoyunu.gameobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject  {

    public void render(SpriteBatch spriteBatch);
    public void update(float delta);
}
