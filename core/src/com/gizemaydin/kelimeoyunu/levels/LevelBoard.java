package com.gizemaydin.kelimeoyunu.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.gameobject.GameObject;

public class LevelBoard implements GameObject {

    private int row,col;

    private LevelBox[][] levels;

    private boolean ilk;


    private float xKord,yKord,width,height;
    private int secilenLevel;

    public LevelBoard(int row, int col, boolean ilk, int secilenLevel) {
        this.row = row;
        this.col = col;
        this.ilk=ilk;

        xKord=Gdx.graphics.getWidth()/(col*2+1);
        yKord=Gdx.graphics.getHeight()/(row*2+1);

        if(xKord<yKord){
            width =xKord;
        }else{
            width =yKord;

        }
        height=yKord;
        this.secilenLevel=secilenLevel;
        levels = new LevelBox[row][col];
        initLevelBox();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
                levels[i][j].render(spriteBatch);
            }
        }
    }

    @Override
    public void update(float delta) {
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col;j++)
            {
                levels[i][j].update(delta);
            }
        }
    }

    public void initLevelBox()
    {
        int level=0;
        for(int i=0;i<row;i++)
        {

            for(int j=0; j<col;j++)
            {
                level++;
                levels[i][j] = new LevelBox(xKord, yKord, width, height,level,ilk,secilenLevel);
                xKord+=(width*2);

            }
            xKord=Gdx.graphics.getWidth()/(col*2+1);
            yKord+=height*2;
        }


    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public LevelBox[][] getLevels() {
        return levels;
    }

    public void setLevels(LevelBox[][] levels) {
        this.levels = levels;
    }


}
