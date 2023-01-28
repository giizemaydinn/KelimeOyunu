package com.gizemaydin.kelimeoyunu.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class HighScoreHandler {

    public static int highScoreLevel[][];
    public static Preferences preferences;
    public static void load(){

        String isim;
        String puan;
        boolean hata=false;
        preferences= Gdx.app.getPreferences("Kelime Oyunu");
        int index;
        String key;
        for(int i=1; i<=3; i++){

            if(hata){
                break;
            }
            for(int j=1; j<=6; j++){
                int id=i*10+j;
                HttpURLConnection connection=null;
                BufferedReader bufferedReader=null;
                try{
                    URL url=new URL("http://192.168.1.20:8080/sorgula?id="+id); //..../listele
                    connection=(HttpURLConnection) url.openConnection();
                    //connection.setReadTimeout(3000);
                    connection.setConnectTimeout(250);
                    connection.connect();

                    InputStream inputStream=connection.getInputStream();
                    bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                    String line;
                    String dosya="";
                    while ((line=bufferedReader.readLine())!=null){
                        dosya+=line;
                    }

                    dosya=dosya.substring(9);
                    int indeks=dosya.indexOf("\"");
                    isim=dosya.substring(0,indeks);
                    dosya=dosya.substring(indeks+9);
                    System.out.println(dosya);
                    indeks=dosya.indexOf("}");
                    puan=dosya.substring(1,indeks);
                    indeks=puan.indexOf("\"");
                    puan=puan.substring(0,indeks);

                    //System.out.println("isim--> "+isim);
                    //System.out.println("puan--> "+puan);
                    preferences.putString("highScoreIsim"+id,isim);
                    preferences.flush();
                    preferences.putInteger("highScore"+id, Integer.parseInt(puan));
                    preferences.flush();


                }catch (Exception e){
                    e.printStackTrace();
                    connection.disconnect();
                    break;
                }
            }


        }
        for(int i=0; i<3; i++){
            for(int j=0; j<6; j++){
                index=(i+1);
                key="highScoreIsim"+index;
                index=j+1;
                key=key+index;
                if(!preferences.contains(key)){
                    preferences.putString(key,"isimsiz");
                }
                key="highScore"+index;
                if(!preferences.contains(key)){
                    preferences.putInteger(key,0);
                }
            }
        }

    }

    public static void setHighScore(int indeks,int highScore){
        String key="highScore"+indeks;
        preferences.putInteger(key,highScore);
        preferences.flush();
        guncelle(indeks,preferences.getString("highScoreIsim"+indeks).toLowerCase(),preferences.getInteger("highScore"+indeks));

    }

    public static int getHighScore(int indeks){
        String key="highScore"+indeks;
        return preferences.getInteger(key);
    }

    public static String getHighScoreIsim(int indeks) {
        String key="highScoreIsim"+indeks;
        return preferences.getString(key);
    }

    public static void setHighScoreIsim(int indeks,String isim) {
        String key="highScoreIsim"+indeks;
        preferences.putString(key,isim);
        preferences.flush();
        guncelle(indeks,preferences.getString("highScoreIsim"+indeks).toLowerCase(),preferences.getInteger("highScore"+indeks));
    }

    public static void guncelle(int indeks, String isim, int puan) {
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://192.168.1.20:8080/guncelle?id=" + indeks + "&isim=" + isim + "&puan=" + puan); //..../listele
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(250);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String dosya = "";
            while ((line = bufferedReader.readLine()) != null) {
                dosya += line;
            }
        } catch (Exception e) {

        }
    }
}
