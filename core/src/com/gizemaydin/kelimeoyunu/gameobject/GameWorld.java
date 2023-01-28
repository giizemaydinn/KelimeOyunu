package com.gizemaydin.kelimeoyunu.gameobject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.controller.Controller;
import com.gizemaydin.kelimeoyunu.handler.BoxHandler;
import com.gizemaydin.kelimeoyunu.handler.CharBoxHandler;
import com.gizemaydin.kelimeoyunu.states.PlayState;

public class GameWorld implements GameObject {

    private CharBoxHandler charBoxHandler;
    private BoxHandler boxHandler;
    private Controller controller;
    private Crossword crossword;



    public GameWorld(PlayState playState, Crossword crossword) {
        charBoxHandler=new CharBoxHandler(playState,crossword.getBulmacaArrayList().get(0));
        controller=new Controller();
        boxHandler=new BoxHandler(playState, crossword);
        this.crossword=crossword;

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        controller.render(spriteBatch);
        charBoxHandler.render(spriteBatch);
        boxHandler.render(spriteBatch);
    }

    @Override
    public void update(float delta) {
        charBoxHandler.update(delta);
        controller.update(delta);
        boxHandler.update(delta);

    }

    public CharBoxHandler getCharBoxHandler() {
        return charBoxHandler;
    }

    public void setCharBoxHandler(CharBoxHandler charBoxHandler) {
        this.charBoxHandler = charBoxHandler;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Crossword getCrossword() {
        return crossword;
    }

    public void setCrossword(Crossword crossword) {
        this.crossword = crossword;
    }

    public BoxHandler getBoxHandler() {
        return boxHandler;
    }

    public void setBoxHandler(BoxHandler boxHandler) {
        this.boxHandler = boxHandler;
    }
}
