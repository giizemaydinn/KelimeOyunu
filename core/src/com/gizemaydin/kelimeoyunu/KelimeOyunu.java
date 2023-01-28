package com.gizemaydin.kelimeoyunu;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.async.AsyncTask;
import com.gizemaydin.kelimeoyunu.gameobject.Player;
import com.gizemaydin.kelimeoyunu.handler.HighScoreHandler;
import com.gizemaydin.kelimeoyunu.imageloader.ImageLoader;
import com.gizemaydin.kelimeoyunu.states.MenuState;
import com.gizemaydin.kelimeoyunu.states.StateManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class KelimeOyunu extends ApplicationAdapter {

	private SpriteBatch spriteBatch;
	private static StateManager stateManager;

	@Override
	public void create () {
		//baglanti();
		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);
		ImageLoader.load();
		Player.load();
		HighScoreHandler.load();
		spriteBatch = new SpriteBatch();
		stateManager=new StateManager();
		stateManager.pushState(new MenuState(stateManager));


	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateManager.render(spriteBatch);
		stateManager.update(Gdx.graphics.getDeltaTime());

	}

	@Override
	public void dispose () {
		ImageLoader.dispose();
		spriteBatch.dispose();

	}

	public void baglanti (){
		HttpURLConnection connection=null;
		BufferedReader bufferedReader=null;
		try{
			URL url=new URL("localhost:8080/listele"); //..../listele
			connection=(HttpURLConnection) url.openConnection();
			connection.connect();
			System.out.println("burda");
			InputStream inputStream=connection.getInputStream();
			bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
			String line;
			String dosya="";
			while ((line=bufferedReader.readLine())!=null){
				System.out.println("satir: "+line);
				dosya+=line;
			}
			System.out.println(dosya);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("hata");
		}
	}

}