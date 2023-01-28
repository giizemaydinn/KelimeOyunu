package com.gizemaydin.kelimeoyunu.imageloader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageLoader {

    public  static BitmapFont font2;
    public static Texture texture,fontTexture2;

    public static TextureRegion bacButtonTRegion,boxTRegion, circleTRegion, playButtonTRegion,levelBox3TRegion,levelBox2TRegion,levelBox1TRegion,levelBoxTRegion1, levelBoxTRegion2,levelBoxTRegion3;
    public static  TextureRegion nameTRegion, menuBackTRegion, playBackTRegion, levelBackTRegion, karistirButtonTRegion, harfEkleTRegion,  harfEkleTRegion2;
    public static  TextureRegion karistiriliyorTRegion, finishBgTRegion, shipTRegion, highscoresTRegion;

    public static void load(){

        /*font=new BitmapFont(Gdx.files.internal("font.fnt"),true);
        font.setColor(Color.BLACK);

        //font.getData().setScale((float) 5);
        fontTexture=new Texture(Gdx.files.internal("font.png"));
        fontTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);*/

        font2=new BitmapFont(Gdx.files.internal("font2.fnt"),true);
        font2.setColor(Color.BLACK);

        //font.getData().setScale((float) 5);
        fontTexture2=new Texture(Gdx.files.internal("font2.png"));
        fontTexture2.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


        texture=new Texture(Gdx.files.internal("box.png"));
        boxTRegion=new TextureRegion(texture,0,0,350,350);
        boxTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("name.png"));
        nameTRegion=new TextureRegion(texture,0,0,617,152);
        nameTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("circle.png"));
        circleTRegion=new TextureRegion(texture,0,0,548,548);
        circleTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("play.png"));
        playButtonTRegion = new TextureRegion(texture, 0, 0, 414, 412);
        playButtonTRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("backButton1.png"));
        bacButtonTRegion = new TextureRegion(texture, 0, 0, 171, 158);
        bacButtonTRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("karistirButton.png"));
        karistirButtonTRegion = new TextureRegion(texture, 0, 0, 200, 230);
        karistirButtonTRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("karistiriliyorButton.png"));
        karistiriliyorTRegion = new TextureRegion(texture, 0, 0, 200, 230);
        karistiriliyorTRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("harfButton2.png"));
        harfEkleTRegion = new TextureRegion(texture, 0, 0, 238, 140);
        harfEkleTRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("harfButton1.png"));
        harfEkleTRegion2 = new TextureRegion(texture, 0, 0, 238, 140);
        harfEkleTRegion2.flip(false, true);

        texture=new Texture(Gdx.files.internal("levelbox.png"));
        levelBox3TRegion = new TextureRegion(texture, 0, 0, 350, 350);
        levelBox3TRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("levelbox2.png"));
        levelBox2TRegion = new TextureRegion(texture, 0, 0, 350, 350);
        levelBox2TRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("levelbox1.png"));
        levelBox1TRegion = new TextureRegion(texture, 0, 0, 350, 350);
        levelBox1TRegion.flip(false, true);

        texture=new Texture(Gdx.files.internal("level1.png"));
        levelBoxTRegion1 = new TextureRegion(texture, 0, 0, 378, 385);
        levelBoxTRegion1.flip(false, true);

        texture=new Texture(Gdx.files.internal("level2.png"));
        levelBoxTRegion2 = new TextureRegion(texture, 0, 0, 520, 382);
        levelBoxTRegion2.flip(false, true);

        texture=new Texture(Gdx.files.internal("level3.png"));
        levelBoxTRegion3 = new TextureRegion(texture, 0, 0, 449, 436);
        levelBoxTRegion3.flip(false, true);

        texture=new Texture(Gdx.files.internal("menubg.png"));
        menuBackTRegion=new TextureRegion(texture, 0, 0, 1080, 1920);
        menuBackTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("playbg.png"));
        playBackTRegion=new TextureRegion(texture, 0, 0, 1600, 1920);
        playBackTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("levelbg.png"));
        levelBackTRegion=new TextureRegion(texture, 0, 0, 1080, 1920);
        levelBackTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("finishbg.png"));
        finishBgTRegion=new TextureRegion(texture, 0, 0, 1080, 1920);
        finishBgTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("finish.png"));
        shipTRegion=new TextureRegion(texture, 0, 0, 341, 282);
        shipTRegion.flip(false,true);

        texture=new Texture(Gdx.files.internal("highscores.png"));
        highscoresTRegion=new TextureRegion(texture, 0, 0, 419, 618);
        highscoresTRegion.flip(false,true);
    }

    public static void dispose(){
        texture.dispose();
        fontTexture2.dispose();

    }
}

