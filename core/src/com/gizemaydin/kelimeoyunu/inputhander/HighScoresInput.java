package com.gizemaydin.kelimeoyunu.inputhander;

import com.badlogic.gdx.InputProcessor;
import com.gizemaydin.kelimeoyunu.states.HighScoresState;
import com.gizemaydin.kelimeoyunu.states.MenuState;

public class HighScoresInput implements InputProcessor {

    private HighScoresState highScoresState;
    public HighScoresInput(HighScoresState highScoresState) {
        this.highScoresState=highScoresState;
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
        highScoresState.getStateManager().pushState(new MenuState(highScoresState.getStateManager()));
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
