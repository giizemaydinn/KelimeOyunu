package com.gizemaydin.kelimeoyunu.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;



public class CharBox implements GameObject {

    private float xKord, yKord, fontHeight=17, fontWidth;
    private float scale;
    private char ch;
    private Circle charCircle;
    private ShapeRenderer shapeRenderer;
    private boolean basildi;


    public CharBox(float xKord, float yKord, float scale, char ch) {

        this.xKord = xKord;
        this.yKord = yKord;
        //this.scale= (float) 2.5;
        this.ch = ch;

        basildi=false;
        shapeRenderer=new ShapeRenderer();
        charCircle=new Circle(xKord, Gdx.graphics.getHeight()-yKord,17*scale);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {


        if(basildi){
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.circle(charCircle.x,charCircle.y,charCircle.radius);
            shapeRenderer.end();
        }


        float oran=fontHeight/charCircle.radius;
        if(oran<1.15){
            scale+=0.05;
        }
        spriteBatch.begin();
        ImageLoader.font2.setColor(Color.BLACK);
        ImageLoader.font2.getData().setScale(scale);
        fontWidth=ImageLoader.font2.draw(spriteBatch,ch+"",xKord,yKord).width;
        fontHeight=ImageLoader.font2.draw(spriteBatch,ch+"",xKord,yKord).height;
        spriteBatch.end();



    }

    @Override
    public void update(float delta) {
        xKord = charCircle.x-charCircle.radius+(charCircle.radius*2-fontWidth)/2;
        yKord =Gdx.graphics.getHeight()-charCircle.y-charCircle.radius+(charCircle.radius*2-fontHeight)/2;

    }

    public Circle getCharCircle() {
        return charCircle;
    }

    public void setCharCircle(Circle charCircle) {
        this.charCircle = charCircle;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public boolean isBasildi() {
        return basildi;
    }

    public void setBasildi(boolean basildi) {
        this.basildi = basildi;
    }
}
