package com.gizemaydin.kelimeoyunu.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.gizemaydin.kelimeoyunu.gameobject.GameObject;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;

public class LevelBox implements GameObject {

    private float xKord, yazKordX, yazKordy;
    private float yKord;
    private float width;
    private float height;
    private float fontHeight, fontWidth;
    private Rectangle collisionRect;
    private ShapeRenderer shapeRenderer;
    private int level;
    private boolean ilk;
    private int secilenLevel;


    public LevelBox(float xKord, float yKord, float width, float height,int level,boolean ilk, int secilenLevel) {
        this.xKord = xKord;
        this.yKord = yKord;
        this.width = width;
        this.height = height;

        this.level=level;
        shapeRenderer=new ShapeRenderer();
        collisionRect = new Rectangle(xKord, yKord, width, height);


        yazKordX=-500;
        yazKordy=-500;
        fontHeight=0;
        fontWidth=0;

        this.ilk=ilk;
        this.secilenLevel=secilenLevel;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

        spriteBatch.begin();
        if(level==1 && ilk){

            xKord= (float) (Gdx.graphics.getWidth()/3.7);
            yKord= (float) (Gdx.graphics.getHeight()/9.6);

            width= (float) (Gdx.graphics.getWidth()/2.85);
            height= (float) (width/0.98);

            spriteBatch.draw(ImageLoader.levelBoxTRegion1, xKord, yKord, width, height);
        }else if(level==2 && ilk){
            xKord= (float) (Gdx.graphics.getWidth()/4.9);
            yKord= (float) (Gdx.graphics.getHeight()/2.74);

            width= (float) (Gdx.graphics.getWidth()/2.07);
            height= (float) (width/1.36);

            spriteBatch.draw(ImageLoader.levelBoxTRegion2, xKord, yKord, width, height);
        }else if(level==3 && ilk){
            xKord= (float) (Gdx.graphics.getWidth()/4);
            yKord= (float) (Gdx.graphics.getHeight()/1.6);

            width= (float) (Gdx.graphics.getWidth()/2.33);
            height= (float) (width/1.03);

            spriteBatch.draw(ImageLoader.levelBoxTRegion3, xKord, yKord, width, height);
        }else{
            if(secilenLevel==1){
                spriteBatch.draw(ImageLoader.levelBox1TRegion, xKord, yKord, width, height);
            }else if(secilenLevel==2){
                spriteBatch.draw(ImageLoader.levelBox2TRegion, xKord, yKord, width, height);
            }else{
                spriteBatch.draw(ImageLoader.levelBox3TRegion, xKord, yKord, width, height);
            }

        }

        ImageLoader.font2.getData().setScale((float) 2.5);
        ImageLoader.font2.setColor(Color.BLACK);

        fontWidth=ImageLoader.font2.draw(spriteBatch,level+"",yazKordX,yazKordy).width;
        fontHeight=ImageLoader.font2.draw(spriteBatch,level+"",yazKordX,yazKordy).height;

        spriteBatch.end();
    }



    @Override
    public void update(float delta) {

        collisionRect.x=xKord;
        collisionRect.y=Gdx.graphics.getHeight()-yKord-height;
        collisionRect.width=width;
        collisionRect.height=height;



        yazKordX=xKord+(width-fontWidth)/2;
        yazKordy=yKord+(height-fontHeight)/2;





    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(Rectangle collisionRect) {
        this.collisionRect = collisionRect;
    }
}
