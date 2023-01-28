package com.gizemaydin.kelimeoyunu.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.gameobject.Box;
import com.gizemaydin.kelimeoyunu.gameobject.Crossword;
import com.gizemaydin.kelimeoyunu.gameobject.GameObject;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.states.PlayState;

import java.util.ArrayList;

public class BoxHandler implements GameObject {

    private ArrayList<Box> boxArrayList;
    private PlayState playState;
    private Crossword crossword;


    public BoxHandler(PlayState playState, Crossword crossword) {
        this.playState = playState;

        double altSınırY=(Gdx.graphics.getHeight()*0.58-Gdx.graphics.getHeight()*1/9);
        double ustSınırY=Gdx.graphics.getWidth()/85+(Gdx.graphics.getHeight()/21.8);
        double toplamY=altSınırY-ustSınırY;

        double toplamX=Gdx.graphics.getWidth();

        double kutuX=toplamX/(crossword.getTemizlikSut()+3);
        double kutuY=toplamY/(crossword.getTemizlikSat()+1);

        float size, bosluk=0;
        if(kutuX<kutuY){
            size=(float)kutuX;
            bosluk=size;
        }else{

            size=(float)kutuY;
            bosluk= (float) (toplamX-(crossword.getTemizlikSut()+1)*size)/2;
        }

        float xKord=bosluk;
        float yKord= (float) ustSınırY;


        boxArrayList=new ArrayList<>();
        //boxArrayList.add(new Box(,1017,,,"Ğ",5,5));
        for (int i=0; i<=crossword.getTemizlikSat(); i++){
            for (int j=0; j<=crossword.getTemizlikSut(); j++){
                if(crossword.getYerler()[i][j]!='-' && crossword.getYerler()[i][j]!=' '){
                    boxArrayList.add(new Box((xKord+j*size),(yKord+i*size),size,size,crossword.getYerler()[i][j],j,i));

                }
            }
        }

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        for (int i=0; i<boxArrayList.size();i++){
            boxArrayList.get(i).render(spriteBatch);

        }
    }

    @Override
    public void update(float delta) {
        for (int i=0; i<boxArrayList.size();i++){
            boxArrayList.get(i).update(delta);
        }
    }

    public ArrayList<Box> getBoxArrayList() {
        return boxArrayList;
    }

    public void setBoxArrayList(ArrayList<Box> boxArrayList) {
        this.boxArrayList = boxArrayList;
    }

}
