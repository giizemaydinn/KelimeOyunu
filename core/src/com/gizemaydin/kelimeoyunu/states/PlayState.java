package com.gizemaydin.kelimeoyunu.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.gizemaydin.kelimeoyunu.buttons.Button;
import com.gizemaydin.kelimeoyunu.gameobject.CharBox;
import com.gizemaydin.kelimeoyunu.gameobject.Crossword;
import com.gizemaydin.kelimeoyunu.gameobject.GameWorld;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.inputhander.PlayStateInput;

public class PlayState extends State {

    private GameWorld gameWorld;
    private StateManager stateManager;
    private OrthographicCamera cam;
    private String word="";
    private int score;
    private float time;
    private int level, altLevel;
    private Button harfEkleButton, karistirButton, backButton;

    public PlayState(StateManager stateManager, Crossword crossword,int level, int altLevel) {
        super(stateManager);
        cam = camera;
        this.stateManager = stateManager;
        gameWorld=new GameWorld(this,crossword);
        Gdx.input.setInputProcessor(new PlayStateInput(this));
        score=100;
        time=0;
        this.level=level;
        this.altLevel=altLevel;

        karistirButton = new Button((float) (Gdx.graphics.getWidth()*0.858),(float) (Gdx.graphics.getHeight()*4/7+Gdx.graphics.getWidth()*5/7/1.35), (float) (Gdx.graphics.getHeight()/12.8*0.87),(float) (Gdx.graphics.getHeight()/10),ImageLoader.karistirButtonTRegion);
        harfEkleButton=new Button((float) (Gdx.graphics.getWidth()*0.14)-(float) (Gdx.graphics.getHeight()/12.8*0.7), (float) (Gdx.graphics.getHeight()*4/7+Gdx.graphics.getWidth()*5/7/1.25), (float) (Gdx.graphics.getHeight()/12.8*1.3), (float) (Gdx.graphics.getHeight()/12.8),ImageLoader.harfEkleTRegion);
        backButton = new Button(Gdx.graphics.getWidth()/54,Gdx.graphics.getWidth()/54,(float) (Gdx.graphics.getHeight()/21.8*1.08), (float) (Gdx.graphics.getHeight()/21.8) ,ImageLoader.bacButtonTRegion);

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.playBackTRegion,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        spriteBatch.draw(ImageLoader.circleTRegion,Gdx.graphics.getWidth()/7,Gdx.graphics.getHeight()*4/7, Gdx.graphics.getWidth()*5/7,Gdx.graphics.getWidth()*5/7);
        ImageLoader.font2.getData().setScale((float) 1.5);
        ImageLoader.font2.setColor(Color.WHITE);
        ImageLoader.font2.draw(spriteBatch,word, (float) (Gdx.graphics.getWidth()/(2.25+0.16*word.length())), (float) (Gdx.graphics.getHeight()*0.58-Gdx.graphics.getHeight()*1/20));
        ImageLoader.font2.getData().setScale((float) 0.65);
        ImageLoader.font2.draw(spriteBatch,"LEVEL : "+level+" - "+ altLevel, (float) (Gdx.graphics.getWidth()/5), Gdx.graphics.getWidth()/54);
        ImageLoader.font2.draw(spriteBatch,"PUAN : "+(int)(score-time), (float) (Gdx.graphics.getWidth()/5)*3, Gdx.graphics.getWidth()/54);
        spriteBatch.end();
        gameWorld.render(spriteBatch);
        karistirButton.render(spriteBatch);
        harfEkleButton.render(spriteBatch);
        backButton.render(spriteBatch);

    }

    @Override
    public void update(float delta) {
        gameWorld.update(delta);
        time+=delta;
    }

    @Override
    public void handleInput() {


    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public void setGameWorld(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
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

    public Button getHarfEkleButton() {
        return harfEkleButton;
    }

    public void setHarfEkleButton(Button harfEkleButton) {
        this.harfEkleButton = harfEkleButton;
    }

    public Button getKaristirButton() {
        return karistirButton;
    }

    public void setKaristirButton(Button karistirButton) {
        this.karistirButton = karistirButton;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
}