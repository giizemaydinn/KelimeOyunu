package com.gizemaydin.kelimeoyunu.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.buttons.Button;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.inputhander.MenuStateInput;


public class MenuState  extends State {

    private StateManager stateManager;
    private Button playButton, nameText, scores;


    private float buttonX;
    private float buttonY;
    private float fontWidth;
    private String name;

    public MenuState(StateManager stateManager) {
        super(stateManager);
        this.stateManager = stateManager;
        buttonX= (float) (Gdx.graphics.getWidth()/3);
        buttonY= (float) (Gdx.graphics.getHeight()/1.78);

        playButton = new Button(buttonX, buttonY,Gdx.graphics.getWidth()/3, (float) (Gdx.graphics.getWidth()/3),ImageLoader.playButtonTRegion);
        nameText = new Button(buttonX*3/4, buttonY-Gdx.graphics.getWidth()/3,(Gdx.graphics.getWidth())/2, (float) ((Gdx.graphics.getWidth()/3)*0.4),ImageLoader.nameTRegion);
        scores=new Button(Gdx.graphics.getWidth()*7/9,0,(float)(Gdx.graphics.getWidth()/5.17),(float)(Gdx.graphics.getHeight()/6.01),ImageLoader.highscoresTRegion);
        name=Player.getIsim().toLowerCase();
        fontWidth=0;
        Gdx.input.setInputProcessor(new MenuStateInput(this));

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();
        spriteBatch.draw(ImageLoader.menuBackTRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();


        nameText.render(spriteBatch);
        spriteBatch.begin();
        ImageLoader.font2.setColor(Color.GOLDENROD);
        ImageLoader.font2.getData().setScale(1);
        fontWidth=ImageLoader.font2.draw(spriteBatch,name, (float) (buttonX*0.7+((Gdx.graphics.getWidth())/2-fontWidth)/2),(float)(buttonY-Gdx.graphics.getWidth()/3.5)).width;
        spriteBatch.end();

        scores.render(spriteBatch);
        playButton.render(spriteBatch);



    }

    @Override
    public void update(float delta) {
        playButton.update(delta);
        nameText.update(delta);
        scores.update(delta);
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

    public Button getPlayButton() {
        return playButton;
    }

    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }

    public Button getNameText() {
        return nameText;
    }

    public void setNameText(Button nameText) {
        this.nameText = nameText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getScores() {
        return scores;
    }

    public void setScores(Button scores) {
        this.scores = scores;
    }
}
