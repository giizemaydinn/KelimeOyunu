package com.gizemaydin.kelimeoyunu.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Player {

    String isim;
    int level;
    int altLevel;

    public static Preferences preferences;
    public Player(String isim, int level, int altLevel) {
        this.isim = isim;
        this.level = level;
        this.altLevel = altLevel;
    }

    public static void load(){
        preferences= Gdx.app.getPreferences("Kelime Oyunu");
        if(!preferences.contains("isim")){
            preferences.putString("isim","");
        }
        if(!preferences.contains("level")){
            preferences.putInteger("level",1);
        }
        if(!preferences.contains("isim")){
            preferences.putInteger("altLevel",1);
        }
    }

    public static String getIsim() {
        return preferences.getString("isim");
    }

    public static void setIsim(String isim) {
        preferences.putString("isim",isim);
        preferences.flush();
    }

    public static int getLevel() {
        return preferences.getInteger("level");
    }

    public static void setLevel(int level) {
        preferences.putInteger("level",level);
        preferences.flush();
    }

    public static int getAltLevel() {
        return preferences.getInteger("altLevel");
    }

    public static void setAltLevel(int altLevel) {
        preferences.putInteger("altLevel",altLevel);
        preferences.flush();
    }
}
