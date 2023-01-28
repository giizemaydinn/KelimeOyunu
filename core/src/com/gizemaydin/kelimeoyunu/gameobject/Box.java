package com.gizemaydin.kelimeoyunu.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;

public class Box implements GameObject {

    private float xKord,yKord,width,height, xKordFont, yKordFont;
    private char harf;
    private boolean harfAc;
    private int yerX;
    private int yerY;
    private float fontWidth=17;
    private float fontHeight=17;
    private float scale;

    public Box(float xKord, float yKord, float width, float height, char harf, int yerX, int yerY) {
        xKordFont=xKord;
        yKordFont=yKord;
        this.xKord = xKord;
        this.yKord = yKord;
        this.width = width;
        this.height = height;
        this.harf=harf;
        harfAc=false;
        this.yerX=yerX;
        this.yerY=yerY;
        scale=0.5f;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();

        spriteBatch.draw(ImageLoader.boxTRegion, xKord, yKord, width, height);
        if(harfAc){

            float oran=fontHeight/height;
            if(oran<0.5){
                scale+=0.05;
            }
            ImageLoader.font2.getData().setScale(scale);
            ImageLoader.font2.setColor(Color.BLACK);
            fontWidth=ImageLoader.font2.draw(spriteBatch,harf+"",xKordFont,yKordFont).width;
            fontHeight=ImageLoader.font2.draw(spriteBatch,harf+"",xKordFont,yKordFont).height;

        }

        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

        xKordFont=xKord+(width-fontWidth)/2;
        yKordFont=yKord+(height-fontHeight)/2;

    }

    public float getxKord() {
        return xKord;
    }

    public void setxKord(float xKord) {
        this.xKord = xKord;
    }

    public float getyKord() {
        return yKord;
    }

    public void setyKord(float yKord) {
        this.yKord = yKord;
    }

    public char getHarf() {
        return harf;
    }

    public void setHarf(char harf) {
        this.harf = harf;
    }

    public int getYerX() {
        return yerX;
    }

    public void setYerX(int yerX) {
        this.yerX = yerX;
    }

    public int getYerY() {
        return yerY;
    }

    public void setYerY(int yerY) {
        this.yerY = yerY;
    }

    public boolean isHarfAc() {
        return harfAc;
    }

    public void setHarfAc(boolean harfAc) {
        this.harfAc = harfAc;
    }
}
