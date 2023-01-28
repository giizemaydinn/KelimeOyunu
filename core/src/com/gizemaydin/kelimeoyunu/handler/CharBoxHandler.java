package com.gizemaydin.kelimeoyunu.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gizemaydin.kelimeoyunu.gameobject.CharBox;
import com.gizemaydin.kelimeoyunu.gameobject.Crossword;
import com.gizemaydin.kelimeoyunu.gameobject.GameObject;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.states.FinishState;
import com.gizemaydin.kelimeoyunu.states.PlayState;

import java.util.ArrayList;
import java.util.Random;


public class CharBoxHandler implements GameObject {

    private ArrayList<CharBox> charBoxArrayList;
    private PlayState playState;
    private float time;
    private boolean say;
    private static Random random;
    private float xKord[];
    private float yKord[];
    char karistir[];

    public CharBoxHandler(PlayState playState, String kelime) {

        time=0;
        say=false;
        this.playState = playState;
        charBoxArrayList=new ArrayList<>();
        float aralikX, aralikY;
        char yedek;
        random=new Random();
        karistir=new char[kelime.length()];


        for(int i=0; i<kelime.length(); i++){
            karistir[i]=kelime.charAt(i);
        }

        for (int i=0; i<kelime.length();i++){
            int harfSec1=random.nextInt(kelime.length());
            yedek=karistir[harfSec1];
            int harfSec2=random.nextInt(kelime.length());
            karistir[harfSec1]=karistir[harfSec2];
            karistir[harfSec2]=yedek;
        }


        if(kelime.length()==3){
            aralikX=(float)(Gdx.graphics.getWidth()*5/7/kelime.length());
            aralikY=(float)(Gdx.graphics.getWidth()*5/7/2);
            xKord=new float[3];
            yKord=new float[3];

            xKord[0]=(float)(Gdx.graphics.getWidth()*(0.5));
            yKord[0]=(float)(Gdx.graphics.getHeight()*0.63);
            charBoxArrayList.add(new CharBox(xKord[0],yKord[0],5,karistir[0]));

            xKord[1]=xKord[0]+aralikX;
            yKord[1]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[1],yKord[1],5,karistir[1]));

            xKord[2]=xKord[0]-aralikX;
            yKord[2]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[2],yKord[2],5,karistir[2]));



        }

        if(kelime.length()==4){
            aralikX=(float)(Gdx.graphics.getWidth()*5/7/3);
            aralikY=(float)(Gdx.graphics.getWidth()*5/7/3);
            xKord=new float[4];
            yKord=new float[4];

            xKord[0]=(float)(Gdx.graphics.getWidth()*(0.5));
            yKord[0]=(float)(Gdx.graphics.getHeight()*0.63);
            charBoxArrayList.add(new CharBox(xKord[0],yKord[0],5,karistir[0]));

            xKord[1]=xKord[0]+aralikX;
            yKord[1]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[1],yKord[1],5,karistir[1]));

            xKord[2]=xKord[0]-aralikX;
            yKord[2]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[2],yKord[2],5,karistir[2]));

            xKord[3]=xKord[0];
            yKord[3]=(float)(yKord[2]+aralikY*1.25);
            charBoxArrayList.add(new CharBox(xKord[3],yKord[3],5,karistir[3]));
        }

        if(kelime.length()==5){
            aralikX=(float)(Gdx.graphics.getWidth()*5/7/3);
            aralikY=(float)(Gdx.graphics.getWidth()*5/7/4);
            xKord=new float[5];
            yKord=new float[5];

            xKord[0]=(float)(Gdx.graphics.getWidth()*(0.5));
            yKord[0]=(float)(Gdx.graphics.getHeight()*0.63);
            charBoxArrayList.add(new CharBox(xKord[0],yKord[0],5,karistir[0]));

            xKord[1]=xKord[0]+aralikX;
            yKord[1]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[1],yKord[1],5,karistir[1]));

            xKord[2]=xKord[0]-aralikX;
            yKord[2]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[2],yKord[2],5,karistir[2]));

            xKord[3]= (float) (xKord[0]-aralikX*0.55);
            yKord[3]=(float)(yKord[2]+aralikY*1.75);
            charBoxArrayList.add(new CharBox(xKord[3],yKord[3],5,karistir[3]));

            xKord[4]= (float) (xKord[0]+aralikX*0.55);
            yKord[4]=(float)(yKord[2]+aralikY*1.75);
            charBoxArrayList.add(new CharBox(xKord[4],yKord[4],5,karistir[4]));
        }

        if(kelime.length()==6){
            aralikX=(float)(Gdx.graphics.getWidth()*5/7/3);
            aralikY=(float)(Gdx.graphics.getWidth()*5/7/5);
            xKord=new float[6];
            yKord=new float[6];

            xKord[0]=(float)(Gdx.graphics.getWidth()*(0.5));
            yKord[0]=(float)(Gdx.graphics.getHeight()*0.63);
            charBoxArrayList.add(new CharBox(xKord[0],yKord[0],5,kelime.charAt(0)));

            xKord[1]=xKord[0]+aralikX;
            yKord[1]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[1],yKord[1],5,kelime.charAt(1)));

            xKord[2]=xKord[0]-aralikX;
            yKord[2]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[2],yKord[2],5,kelime.charAt(2)));

            xKord[3]= (float) (xKord[0]+aralikX);
            yKord[3]=(float)(yKord[2]+aralikY*1.7);
            charBoxArrayList.add(new CharBox(xKord[3],yKord[3],5,kelime.charAt(3)));

            xKord[4]= (float) (xKord[0]-aralikX);
            yKord[4]=(float)(yKord[2]+aralikY*1.7);
            charBoxArrayList.add(new CharBox(xKord[4],yKord[4],5,kelime.charAt(4)));

            xKord[5]=xKord[0];
            yKord[5]= (float) (yKord[0]+aralikY*3.7);
            charBoxArrayList.add(new CharBox(xKord[5],yKord[5],5,kelime.charAt(5)));
        }
        if(kelime.length()==7){
            aralikX=(float)(Gdx.graphics.getWidth()*5/7/3);
            aralikY=(float)(Gdx.graphics.getWidth()*5/7/6);
            xKord=new float[7];
            yKord=new float[7];

            xKord[0]=(float)(Gdx.graphics.getWidth()*(0.5));
            yKord[0]=(float)(Gdx.graphics.getHeight()*0.63);
            charBoxArrayList.add(new CharBox(xKord[0],yKord[0],5,kelime.charAt(0)));

            xKord[1]=xKord[0]+aralikX;
            yKord[1]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[1],yKord[1],5,kelime.charAt(1)));

            xKord[2]=xKord[0]-aralikX;
            yKord[2]=yKord[0]+aralikY;
            charBoxArrayList.add(new CharBox(xKord[2],yKord[2],5,kelime.charAt(2)));

            xKord[3]= (float) (xKord[0]+aralikX*1.05);
            yKord[3]=(float)(yKord[2]+aralikY*1.8);
            charBoxArrayList.add(new CharBox(xKord[3],yKord[3],5,kelime.charAt(3)));

            xKord[4]= (float) (xKord[0]-aralikX*1.05);
            yKord[4]=(float)(yKord[2]+aralikY*1.8);
            charBoxArrayList.add(new CharBox(xKord[4],yKord[4],5,kelime.charAt(4)));

            xKord[5]= (float) (xKord[0]-aralikX*0.55);
            yKord[5]= (float) (yKord[0]+aralikY*4.2);
            charBoxArrayList.add(new CharBox(xKord[5],yKord[5],5,kelime.charAt(5)));

            xKord[6]= (float) (xKord[0]+aralikX*0.55);
            yKord[6]= (float) (yKord[0]+aralikY*4.2);
            charBoxArrayList.add(new CharBox(xKord[6],yKord[6],5,kelime.charAt(6)));
        }




    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        for (int i=0; i<charBoxArrayList.size();i++){
            charBoxArrayList.get(i).render(spriteBatch);
        }

        if(playState.getGameWorld().getCrossword().getBulmacaArrayList().size()==0){
            say=true;


            if(time>=0.5){
                int level, altLevel;
                playState.setScore(playState.getScore()-(int)playState.getTime());

                if(Player.getAltLevel()==playState.getAltLevel() && Player.getLevel()==playState.getLevel()){

                    if(Player.getAltLevel()!=6){
                        int arttir=Player.getAltLevel()+1;
                        Player.setAltLevel(arttir);
                        altLevel=arttir;
                        level=Player.getLevel();

                    }else{
                        if(Player.getLevel()!=3){
                            Player.setLevel(Player.getLevel()+1);
                            Player.setAltLevel(1);
                            level=Player.getLevel();
                            altLevel=1;

                        }else{
                            System.out.println("Oyun tamamlandı");
                            level=3;
                            altLevel=6;
                        }

                    }
                }else{
                    if(playState.getAltLevel()!=6){
                        int arttir=playState.getAltLevel()+1;
                        altLevel=arttir;
                        level=playState.getLevel();

                    }else{
                        if(playState.getLevel()!=3){
                            level=playState.getLevel()+1;
                            altLevel=1;

                        }else{
                            System.out.println("Oyun tamamlandı");
                            level=3;
                            altLevel=6;
                        }

                    }
                }
                int indeks=playState.getLevel()*10+playState.getAltLevel();
                int highScore=HighScoreHandler.getHighScore(indeks);
                int score=playState.getScore();
                if(score>highScore){
                    highScore=score;
                    HighScoreHandler.setHighScore(indeks,highScore);
                    String isim=Player.getIsim();
                    HighScoreHandler.setHighScoreIsim(indeks,isim);

                }

                playState.getStateManager().pushState(new FinishState(playState.getStateManager(),score, level, altLevel,playState.getLevel(),playState.getAltLevel()));
            }

        }
    }

    @Override
    public void update(float delta) {
        for (int i=0; i<charBoxArrayList.size(); i++){
            charBoxArrayList.get(i).update(delta);
        }

        if(say){
            time+=delta;
        }
    }

    public ArrayList<CharBox> getCharBoxArrayList() {
        return charBoxArrayList;
    }

    public void setCharBoxArrayList(ArrayList<CharBox> charBoxArrayList) {
        this.charBoxArrayList = charBoxArrayList;
    }

    public float[] getxKord() {
        return xKord;
    }

    public void setxKord(float[] xKord) {
        this.xKord = xKord;
    }

    public float[] getyKord() {
        return yKord;
    }

    public void setyKord(float[] yKord) {
        this.yKord = yKord;
    }

    public char[] getKaristir() {
        return karistir;
    }

    public void setKaristir(char[] karistir) {
        this.karistir = karistir;
    }
}
