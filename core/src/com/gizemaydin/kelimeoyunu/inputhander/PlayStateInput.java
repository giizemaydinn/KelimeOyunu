package com.gizemaydin.kelimeoyunu.inputhander;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.states.FinishState;
import com.gizemaydin.kelimeoyunu.states.LevelsState;
import com.gizemaydin.kelimeoyunu.states.PlayState;

import java.util.Random;


public class PlayStateInput implements InputProcessor {

    private PlayState playState;

    public PlayStateInput(PlayState playState) {
        this.playState = playState;
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

        if(playState.getBackButton().getButtonRect().contains(screenX,screenY)) {
            playState.getStateManager().pushState(new LevelsState(playState.getStateManager()));

        }
        if(playState.getKaristirButton().getButtonRect().contains(screenX,screenY)) {
            playState.getKaristirButton().setButtonImage(ImageLoader.karistiriliyorTRegion);
            Random random = new Random();
            for(int i=0; i<playState.getGameWorld().getCharBoxHandler().getKaristir().length; i++){
                int harfSec1=random.nextInt(playState.getGameWorld().getCharBoxHandler().getKaristir().length);
                char yedek = playState.getGameWorld().getCharBoxHandler().getKaristir()[harfSec1];
                int harfSec2=random.nextInt(playState.getGameWorld().getCharBoxHandler().getKaristir().length);
                playState.getGameWorld().getCharBoxHandler().getKaristir()[harfSec1]=playState.getGameWorld().getCharBoxHandler().getKaristir()[harfSec2];
                playState.getGameWorld().getCharBoxHandler().getKaristir()[harfSec2]=yedek;

            }

            for (int i=0; i<playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().size(); i++){
                playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).setCharCircle(new Circle(playState.getGameWorld().getCharBoxHandler().getxKord()[i],Gdx.graphics.getHeight()-playState.getGameWorld().getCharBoxHandler().getyKord()[i],85));
                playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).setCh(playState.getGameWorld().getCharBoxHandler().getKaristir()[i]);
            }




        }

        if(playState.getHarfEkleButton().getButtonRect().contains(screenX,screenY)) {
            playState.getHarfEkleButton().setButtonImage(ImageLoader.harfEkleTRegion2);
            Random random = new Random();
            int ac, acik=0;
            while (true){
               ac=random.nextInt(playState.getGameWorld().getBoxHandler().getBoxArrayList().size());
                if(playState.getGameWorld().getBoxHandler().getBoxArrayList().get(ac).isHarfAc()){
                    ac=random.nextInt(playState.getGameWorld().getBoxHandler().getBoxArrayList().size());
                }else{
                    playState.getGameWorld().getBoxHandler().getBoxArrayList().get(ac).setHarfAc(true);
                    playState.setScore(playState.getScore()-5);
                    for (int i=0; i<playState.getGameWorld().getBoxHandler().getBoxArrayList().size(); i++){
                        if(playState.getGameWorld().getBoxHandler().getBoxArrayList().get(i).isHarfAc()){
                            acik++;
                        }
                    }
                    if(acik==playState.getGameWorld().getBoxHandler().getBoxArrayList().size()){
                        playState.getGameWorld().getCrossword().getBulmacaArrayList().clear();
                    }
                    break;
                }
            }

        }


        for (int i=0; i<playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().size();i++){
            if(playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCharCircle().contains(screenX, Gdx.graphics.getHeight()-screenY)){

                playState.getGameWorld().getController().setScreenCord(new Vector2(screenX,screenY));
                playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getShapeRenderer().setColor(Color.GOLDENROD);
                playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).setBasildi(true);
                playState.setWord(playState.getWord()+playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCh());

                playState.getGameWorld().getController().getLineCord().add(new Vector2(playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCharCircle().x,Gdx.graphics.getHeight()-playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCharCircle().y));

            }
        }



        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        playState.getKaristirButton().setButtonImage(ImageLoader.karistirButtonTRegion);
        playState.getHarfEkleButton().setButtonImage(ImageLoader.harfEkleTRegion);
        int acik=0;
        if(playState.getWord().length()>2){
            int indeks=playState.getGameWorld().getCrossword().getBulmacaArrayList().indexOf(playState.getWord());
            if(indeks!=-1){

                if(playState.getGameWorld().getCrossword().getYonList().get(indeks)==1){
                    for (int k=0; k<playState.getWord().length();k++){

                        for (int l=0; l<playState.getGameWorld().getBoxHandler().getBoxArrayList().size(); l++){

                            if(playState.getGameWorld().getCrossword().getKonumXList().get(indeks)==playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).getYerX() && (playState.getGameWorld().getCrossword().getKonumYList().get(indeks)+k)==playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).getYerY()){
                                if(playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).isHarfAc()){
                                    acik++;
                                }else{
                                    playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).setHarfAc(true);
                                }

                            }
                        }

                    }

                }else{
                    for (int k=0; k<playState.getWord().length();k++){

                        for (int l=0; l<playState.getGameWorld().getBoxHandler().getBoxArrayList().size(); l++){

                            if((playState.getGameWorld().getCrossword().getKonumXList().get(indeks)+k)==playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).getYerX() && (playState.getGameWorld().getCrossword().getKonumYList().get(indeks))==playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).getYerY()){
                                if(playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).isHarfAc()){
                                    acik++;
                                }else{
                                    playState.getGameWorld().getBoxHandler().getBoxArrayList().get(l).setHarfAc(true);
                                }
                            }
                        }

                    }
                }


                int son=0;
                if(acik!=playState.getWord().length()){
                    playState.setScore(playState.getScore()+100);
                    for (int i=0; i<playState.getGameWorld().getBoxHandler().getBoxArrayList().size(); i++){
                        if(playState.getGameWorld().getBoxHandler().getBoxArrayList().get(i).isHarfAc()){
                            son++;
                        }
                    }
                    if(son==playState.getGameWorld().getBoxHandler().getBoxArrayList().size()){
                        playState.getGameWorld().getCrossword().getBulmacaArrayList().clear();
                    }else{
                        playState.getGameWorld().getCrossword().getBulmacaArrayList().remove(indeks);
                        playState.getGameWorld().getCrossword().getKonumXList().remove(indeks);
                        playState.getGameWorld().getCrossword().getKonumYList().remove(indeks);
                        playState.getGameWorld().getCrossword().getYonList().remove(indeks);
                    }
                }else{
                    System.out.println("Kelime açık");
                    playState.getGameWorld().getCrossword().getBulmacaArrayList().remove(indeks);
                    playState.getGameWorld().getCrossword().getKonumXList().remove(indeks);
                    playState.getGameWorld().getCrossword().getKonumYList().remove(indeks);
                    playState.getGameWorld().getCrossword().getYonList().remove(indeks);
                }





            }else{
                playState.setScore(playState.getScore()-10);
            }
        }

        for (int i=0; i<playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().size();i++){
            playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).setBasildi(false);
            playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getShapeRenderer().setColor(Color.TAN);
            playState.setWord("");
            playState.getGameWorld().getController().getLineCord().clear();
            playState.getGameWorld().getController().setClicked(false);

        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        playState.getGameWorld().getController().setScreenCord(new Vector2(screenX,screenY));
        for (int i=0; i<playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().size();i++){
            if(playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCharCircle().contains(screenX, Gdx.graphics.getHeight()-screenY)){

                if(playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getShapeRenderer().getColor().equals(Color.GOLDENROD)){
                    break;

                }else{

                    playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getShapeRenderer().setColor(Color.GOLDENROD);
                    playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).setBasildi(true);
                    playState.setWord(playState.getWord()+playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCh());
                    playState.getGameWorld().getController().getLineCord().add(new Vector2(playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCharCircle().x,Gdx.graphics.getHeight()-playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().get(i).getCharCircle().y));

                }

            }
        }

        if(playState.getGameWorld().getCharBoxHandler().getCharBoxArrayList().size()== playState.getGameWorld().getController().getLineCord().size()){
            playState.getGameWorld().getController().setScreenCord(new Vector2(playState.getGameWorld().getController().getLineCord().get(playState.getGameWorld().getController().getLineCord().size()-1).x,playState.getGameWorld().getController().getLineCord().get(playState.getGameWorld().getController().getLineCord().size()-1).y));
        }
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
