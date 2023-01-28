package com.gizemaydin.kelimeoyunu.inputhander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.gizemaydin.kelimeoyunu.gameobject.Crossword;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.states.FinishState;
import com.gizemaydin.kelimeoyunu.states.MenuState;
import com.gizemaydin.kelimeoyunu.states.PlayState;


public class FinishInput implements InputProcessor {
    private FinishState finishState;
    private Crossword crossword;
    private int level, altLevel;

    public FinishInput(FinishState finishState, int level, int altLevel) {
        this.finishState = finishState;
        this.level=level;
        this.altLevel=altLevel;

    }

    @Override
    public boolean keyDown(int keycode) {

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
        crossword=new Crossword(level,altLevel);
        finishState.getStateManager().pushState(new PlayState(finishState.getStateManager(),crossword,level,altLevel));
        //finishState.getStateManager().pushState(new MenuState(finishState.getStateManager()));
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
