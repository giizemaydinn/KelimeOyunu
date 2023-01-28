package com.gizemaydin.kelimeoyunu.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.handler.HighScoreHandler;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.inputhander.FinishInput;

public class FinishState extends State {

    private StateManager stateManager;
    private int score;
    private float xMax=Gdx.graphics.getWidth()/4.5f, yMax=Gdx.graphics.getHeight()/5.15f;
    private float shipX, shipY, shipW=Gdx.graphics.getWidth()/3.03f, shipH=Gdx.graphics.getHeight()/6.5f;
    private int indeks;
    float width, fontWidth, scale;

    public FinishState(StateManager stateManager, int score, int level, int altLevel, int oynananLevel, int oynananAltLevel) {
        super(stateManager);
        this.stateManager = stateManager;
        this.score=score;
        shipX=0;
        shipY=(float) (Gdx.graphics.getHeight()/3.84);
        Gdx.input.setInputProcessor(new FinishInput(this,level,altLevel));
        indeks=oynananLevel*10+oynananAltLevel;
        width=-500;
        fontWidth=-500;
        scale=0.05f;

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();

        spriteBatch.draw(ImageLoader.finishBgTRegion,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        spriteBatch.draw(ImageLoader.shipTRegion,shipX,shipY, shipW,shipH);

        ImageLoader.font2.getData().setScale(2);

        ImageLoader.font2.setColor(Color.LIGHT_GRAY);
        width=ImageLoader.font2.draw(spriteBatch, "Puan: "+score,(Gdx.graphics.getWidth()-width)/2, 150).width;
        ImageLoader.font2.getData().setScale(0.75f);
        ImageLoader.font2.setColor(Color.LIGHT_GRAY);
        float height=ImageLoader.font2.draw(spriteBatch, "En Yüksek Puan ", (float) (Gdx.graphics.getWidth()/2.9), (float) (Gdx.graphics.getHeight()/1.9)).height;
        ImageLoader.font2.getData().setScale(scale);
        fontWidth=ImageLoader.font2.draw(spriteBatch, HighScoreHandler.getHighScoreIsim(indeks).toLowerCase()+" ~ "+HighScoreHandler.getHighScore(indeks), (float) (Gdx.graphics.getWidth()/2.9+(Gdx.graphics.getWidth()/3-fontWidth)/2), 920+height*3).width;

        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

        if(shipX<xMax){
            shipX+=1.5;
        }else {
            shipX=xMax;
        }
        if(shipY>yMax){
            shipY-=0.75;
        }else{
            shipY=yMax;
        }

        float oran=fontWidth/Gdx.graphics.getWidth()/3;
        if(oran<0.1){
            scale+=0.25;
        }
    }

    @Override
    public void handleInput() {

    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }
}
