package com.gizemaydin.kelimeoyunu.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.handler.HighScoreHandler;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.inputhander.HighScoresInput;

public class HighScoresState extends State{

    private StateManager stateManager;

    public HighScoresState(StateManager stateManager) {
        super(stateManager);
        Gdx.input.setInputProcessor(new HighScoresInput(this));
        this.stateManager=stateManager;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        int satir=0;
        for(int i=1; i<=3;i++){
            for (int j=1; j<=6; j++){
                int indeks=i*10+j;

                ImageLoader.font2.draw(spriteBatch, i+"."+j+" -> "+HighScoreHandler.getHighScoreIsim(indeks).toLowerCase()+" ~ "+HighScoreHandler.getHighScore(indeks), (float)(Gdx.graphics.getWidth()/10.8),(float)(Gdx.graphics.getHeight()/12+Gdx.graphics.getHeight()/21.333*satir));
                satir++;
            }
        }

        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

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
