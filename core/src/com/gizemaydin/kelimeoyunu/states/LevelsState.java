package com.gizemaydin.kelimeoyunu.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.buttons.Button;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.inputhander.LevelStateInput;
import com.gizemaydin.kelimeoyunu.levels.LevelBoard;

public class LevelsState extends State{


    private StateManager stateManager;
    private LevelBoard levelBoard;
    private boolean secilmedi;
    private int level, altLevel;
    private Button backButton;



    public LevelsState(StateManager stateManager) {
        super(stateManager);
        this.stateManager=stateManager;
        levelBoard = new LevelBoard(3,1,true,0);
        secilmedi=true;

        Gdx.input.setInputProcessor(new LevelStateInput(this));
        backButton = new Button(Gdx.graphics.getWidth()/54,Gdx.graphics.getWidth()/54,(float) (Gdx.graphics.getHeight()/21.8*1.08), (float) (Gdx.graphics.getHeight()/21.8) ,ImageLoader.bacButtonTRegion);

    }

    public LevelsState(StateManager stateManager, int level) {
        super(stateManager);
        this.stateManager=stateManager;
        this.level=level;
        levelBoard = new LevelBoard(3,2,false,level);
        Gdx.input.setInputProcessor(new LevelStateInput(this));
        backButton = new Button(Gdx.graphics.getWidth()/54,Gdx.graphics.getWidth()/54,(float) (Gdx.graphics.getHeight()/21.8*1.08), (float) (Gdx.graphics.getHeight()/21.8) ,ImageLoader.bacButtonTRegion);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();

        spriteBatch.draw(ImageLoader.levelBackTRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
        levelBoard.render(spriteBatch);
        backButton.render(spriteBatch);

    }

    @Override
    public void update(float delta) {
        levelBoard.update(delta);
    }

    @Override
    public void handleInput() {

    }

    public LevelBoard getLevelBoard() {
        return levelBoard;
    }

    public void setLevelBoard(LevelBoard levelBoard) {
        this.levelBoard = levelBoard;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public boolean isSecilmedi() {
        return secilmedi;
    }

    public void setSecilmedi(boolean secilmedi) {
        this.secilmedi = secilmedi;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAltLevel() {
        return altLevel;
    }

    public void setAltLevel(int altLevel) {
        this.altLevel = altLevel;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
}
