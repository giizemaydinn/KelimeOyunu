package com.gizemaydin.kelimeoyunu.inputhander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.gizemaydin.kelimeoyunu.gameobject.Crossword;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.states.HighScoresState;
import com.gizemaydin.kelimeoyunu.states.LevelsState;
import com.gizemaydin.kelimeoyunu.states.MenuState;
import com.gizemaydin.kelimeoyunu.states.PlayState;
import com.badlogic.gdx.Input.Keys;

public class MenuStateInput implements InputProcessor {

    private MenuState menuState;
    private String name;
    private Crossword crossword;

    public MenuStateInput(MenuState menuState) {
        this.menuState = menuState;
        name=menuState.getName();
    }

    @Override
    public boolean keyDown(int keycode) {

        if(keycode==Keys.BACKSPACE){
            if(name.length()!=0){
                name=name.substring(0,name.length()-1);
            }

        }else if(keycode==Keys.I){
            if(name.length()!=8){
                name=name+'i';
            }
        }else if(keycode>=29 && keycode<=54){
            if(name.length()!=8){
                name=name+Keys.toString(keycode);
            }
        }else if(keycode>=7 && keycode<=16){
            if(name.length()!=8){
                name=name+Keys.toString(keycode);
            }
        }else if(keycode==Keys.ENTER){
            Gdx.input.setOnscreenKeyboardVisible(false);
        }

        menuState.setName(name.toLowerCase());
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(menuState.getPlayButton().getButtonRect().contains(screenX,screenY))
        {
            Gdx.input.setOnscreenKeyboardVisible(false);
            Player.setIsim(name);
            crossword=new Crossword(Player.getLevel(),Player.getAltLevel());
            menuState.getStateManager().pushState(new PlayState(menuState.getStateManager(),crossword,Player.getLevel(),Player.getAltLevel()));
            //menuState.getStateManager().pushState(new LevelsState(menuState.getStateManager()));

        }
        if(menuState.getNameText().getButtonRect().contains(screenX,screenY))
        {
            Gdx.input.setOnscreenKeyboardVisible(true);

        }

        if(menuState.getScores().getButtonRect().contains(screenX,screenY)){
            menuState.getStateManager().pushState(new HighScoresState(menuState.getStateManager()));
        }


        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
