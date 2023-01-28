package com.gizemaydin.kelimeoyunu.inputhander;

import com.badlogic.gdx.InputProcessor;
import com.gizemaydin.kelimeoyunu.gameobject.Crossword;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.states.LevelsState;
import com.gizemaydin.kelimeoyunu.states.MenuState;
import com.gizemaydin.kelimeoyunu.states.PlayState;

public class LevelStateInput implements InputProcessor {

    private LevelsState levelState;
    private Crossword crossword;


    public LevelStateInput(LevelsState levelState) {
        this.levelState = levelState;

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

        if(levelState.getBackButton().getButtonRect().contains(screenX,screenY)) {
            if(levelState.isSecilmedi()){
                levelState.getStateManager().pushState(new MenuState(levelState.getStateManager()));
            }else{
                if(levelState.getBackButton().getButtonRect().contains(screenX,screenY)) {
                    levelState.getStateManager().pushState(new LevelsState(levelState.getStateManager()));

                }
            }


        }
        int level=0;
        for(int i=levelState.getLevelBoard().getRow()-1;i>=0;i--)
        {

            for(int j=0; j<levelState.getLevelBoard().getCol();j++)
            {
                level++;
                if(levelState.getLevelBoard().getLevels()[i][j].getCollisionRect().contains(screenX, screenY))
                {


                    if(levelState.isSecilmedi()){
                        if(Player.getLevel()>=level){
                            levelState.setSecilmedi(false);
                            levelState.setLevel((int)level);
                            levelState.getStateManager().pushState(new LevelsState(levelState.getStateManager(),(int)level));

                        }


                    }else{
                        System.out.println("LSI oyuncunun alt leveli :"+ Player.getAltLevel());
                        if(levelState.getLevel()<Player.getLevel()){
                            levelState.setAltLevel((int)level);

                            crossword=new Crossword(levelState.getLevel(),levelState.getAltLevel());
                            levelState.getStateManager().pushState(new PlayState(levelState.getStateManager(),crossword,levelState.getLevel(),levelState.getAltLevel()));

                            System.out.println("LSI Secilen level: "+levelState.getLevel()+"--> "+levelState.getAltLevel() );
                        }else if(Player.getAltLevel()>=level){
                            levelState.setAltLevel((int)level);

                            crossword=new Crossword(levelState.getLevel(),levelState.getAltLevel());
                            levelState.getStateManager().pushState(new PlayState(levelState.getStateManager(),crossword,levelState.getLevel(),levelState.getAltLevel()));

                            System.out.println("LSI Secilen level: "+levelState.getLevel()+"--> "+levelState.getAltLevel() );
                        }

                    }

                }
            }


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
