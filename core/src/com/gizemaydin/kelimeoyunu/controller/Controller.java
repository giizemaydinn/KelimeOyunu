package com.gizemaydin.kelimeoyunu.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.gizemaydin.kelimeoyunu.gameobject.GameObject;

import java.util.ArrayList;

public class Controller implements GameObject {


    private ArrayList<Vector2> lineCord;
    private Vector2 screenCord;

    private ShapeRenderer shapeRenderer;

    private OrthographicCamera camera;
    private boolean clicked=false;

    public Controller() {

        camera = new OrthographicCamera();
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);


        lineCord = new ArrayList<>();
    }



    private Vector2 direction;

    @Override
    public void render(SpriteBatch spriteBatch) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GOLDENROD);
        for (int i=0; i<lineCord.size();i++){

            if(i+1==lineCord.size()){
                break;
            }
            else if(lineCord.size()!=0){
                shapeRenderer.rectLine(lineCord.get(i),lineCord.get(i+1),30);

            }

        }
        if(lineCord.size()!=0){
            shapeRenderer.rectLine(lineCord.get(lineCord.size()-1),screenCord,30);
        }

        shapeRenderer.end();
    }

    @Override
    public void update(float delta) {


    }

    public ArrayList<Vector2> getLineCord() {
        return lineCord;
    }

    public void setLineCord(ArrayList<Vector2> lineCord) {
        this.lineCord = lineCord;
    }

    public ShapeRenderer getShapeRenderer() {
        return shapeRenderer;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public Vector2 getScreenCord() {
        return screenCord;
    }

    public void setScreenCord(Vector2 screenCord) {
        this.screenCord = screenCord;
    }
}
