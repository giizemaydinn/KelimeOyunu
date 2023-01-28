package com.gizemaydin.kelimeoyunu.buttons;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.gizemaydin.kelimeoyunu.gameobject.GameObject;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;



public class Button implements GameObject {

    private TextureRegion buttonImage;
    private float xKord,yKord,width,height;
    private Rectangle buttonRect;

    public Button(float xKord, float yKord, float width, float height,TextureRegion buttonImage) {
        this.xKord = xKord;
        this.yKord = yKord;
        this.width = width;
        this.height = height;
        this.buttonImage =buttonImage;


        buttonRect  = new Rectangle(xKord, yKord, width, height);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        spriteBatch.draw(buttonImage, xKord, yKord, width, height);

        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

    }

    public Rectangle getButtonRect() {
        return buttonRect;
    }

    public void setButtonRect(Rectangle buttonRect) {
        this.buttonRect = buttonRect;
    }

    public TextureRegion getButtonImage() {
        return buttonImage;
    }

    public void setButtonImage(TextureRegion buttonImage) {
        this.buttonImage = buttonImage;
    }
}
