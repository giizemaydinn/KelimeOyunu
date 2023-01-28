package com.gizemaydin.kelimeoyunu.gameobject;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Interpolation;

import java.util.ArrayList;
import java.util.Random;

public class Crossword {

    private static ArrayList<String> wordsArrayList;
    private static ArrayList<String> uygunArrayList;

    private static ArrayList<Character> ilkKelimedekiHarf ;
    private static ArrayList<Integer> ilkKelimedekiAdet ;

    private static ArrayList<Character> secilenKelimedekiHarf ;
    private static ArrayList<Integer> secilenKelimedekiAdet ;

    private static Random random;

    private static String secilenKelime, ilkKelime, neredenBasladim;

    private static int enUzun, neredenBaslasin,  toplamUzunluk, ilkGiris, degistir, ilkKelimeyiSec, enFazla;
    private static boolean tamamlanmadi;

    private int level, altLevel;

    private static ArrayList<String> bulmacaArrayList;
    private static ArrayList<Integer> konumXList;
    private static ArrayList<Integer> konumYList;
    private static ArrayList<Integer> yonList;

    private static char[][] yerler;
    private  static int dikey, temizlikSat, temizlikSut;
    private float time;


    public Crossword(int level, int altLevel){
        time=0;
        degistir=0;
        ilkGiris=1;
        uygunArrayList=new ArrayList<String>();

        ilkKelimedekiHarf = new ArrayList<>();
        ilkKelimedekiAdet = new ArrayList<>();

        secilenKelimedekiHarf = new ArrayList<>();
        secilenKelimedekiAdet = new ArrayList<>();

        random = new Random();

        this.level=level;
        this.altLevel=altLevel;
        enFazla=level+2;

        bulmacaArrayList=new ArrayList<String>();
        konumXList=new ArrayList<Integer>();
        konumYList=new ArrayList<Integer>();
        yonList=new ArrayList<Integer>();
        yerler= new char[10][10];

        kelimeleriCek();
    }

    public void bulmacaOlustur(){
        tamamlanmadi=true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                yerler[i][j]='-';

            }

        }


        String kelime=uygunArrayList.get(0);
        int uzunluk=kelime.length();
        int neresiX=random.nextInt(6)+1;
        int neresiY=random.nextInt(6)+1;
        dikey=random.nextInt(2); //0sa yatay 1se dikey
        if(dikey==1) {
            if(neresiY+uzunluk>yerler.length) {
                neresiY=2;
            }
            dikeyYerlestir(kelime, 0, neresiX, neresiY);
        }else {

            if(neresiX+uzunluk>yerler.length) {
                neresiX=2;
            }
            yatayYerlestir(kelime, 0, neresiX, neresiY);
        }

        while(tamamlanmadi) {

            /*if(bulmacaArrayList.size()==0){
                break;
            }*/
            time++;

            if(time==10000){
                System.out.println("Süre doldu"+time);
                break;
            }
            if(bulmacaArrayList.size()==altLevel){
                break;
            }

            if(uygunArrayList.size()==0) {

                break;
            }
            kelimeEkle();


        }
        System.out.println("Bulmacadaki kelimeler : ");
        for (int i=0; i<bulmacaArrayList.size(); i++){
            System.out.println(bulmacaArrayList.get(i));
        }

        int satir=0, sutun=0;
        temizlikSat=9;
        temizlikSut=9;

        for (int i = 0; i <=temizlikSat; i++) {
            for (int j = 0; j <= temizlikSut; j++) {

                if(yerler[i][j]=='-' || yerler[i][j]==' ')
                {
                    satir++;
                }else{
                    break;
                }

            }

            if(satir==temizlikSut+1){
                for (int k=i; k<temizlikSat; k++){
                    for (int j = 0; j <=temizlikSut; j++){
                        if(konumYList.indexOf(k+1)!=-1){
                            konumYList.set(konumYList.indexOf(k+1),k);
                        }

                        yerler[k][j]=yerler[k+1][j];
                    }
                }
                i--;
                temizlikSat--;
            }
            satir=0;

        }

        for (int j = 0; j <=temizlikSut; j++) {
            for (int i = 0; i <= temizlikSat; i++) {
                if(yerler[i][j]=='-' || yerler[i][j]==' ')
                {
                    sutun++;
                }else {
                    break;
                }

            }

            if(sutun==temizlikSat+1){

                for (int k=j; k<temizlikSut; k++){
                    for (int i = 0; i <=temizlikSat; i++){
                        if(konumXList.indexOf(k+1)!=-1){
                            konumXList.set(konumXList.indexOf(k+1),k);
                        }

                        yerler[i][k]=yerler[i][k+1];
                    }
                }
                j--;
                temizlikSut--;
            }
            sutun=0;

        }


    }

    public static void kelimeEkle() {

        int kelimeSec=random.nextInt(bulmacaArrayList.size());

        String kelime=bulmacaArrayList.get(kelimeSec);

        int harfSec=random.nextInt(kelime.length());


        if(yonList.get(kelimeSec)==0) {

            int konumX=konumXList.get(kelimeSec)+harfSec;
            int konumY=konumYList.get(kelimeSec);

            for (int i = 0; i < uygunArrayList.size(); i++) {
                char harf=kelime.charAt(harfSec);
                int indeks=uygunArrayList.get(i).indexOf(harf);
                if( indeks != (-1)) {
                    kelime=uygunArrayList.get(i);

                    indeks= kelime.indexOf(harf);
                    dikeyYerlestir(kelime,indeks, konumX,konumY);
                    break;
                }
            }

        }else if(yonList.get(kelimeSec)==1){

            int konumX=konumXList.get(kelimeSec);
            int konumY=konumYList.get(kelimeSec)+harfSec;

            for (int i = 0; i < uygunArrayList.size(); i++) {
                char harf=kelime.charAt(harfSec);
                int indeks=uygunArrayList.get(i).indexOf(harf);
                if( indeks != (-1)) {
                    kelime=uygunArrayList.get(i);

                    indeks= kelime.indexOf(harf);
                    yatayYerlestir(kelime,indeks, konumX,konumY);
                    break;
                }
            }
        }

    }
    public static void dikeyYerlestir(String kelime, int indeks, int konumX, int konumY) {

        int kelimeUzunlugu=kelime.length();
        int uygunY=0;

        if(konumY < indeks) {

        }else {
            konumY-=indeks;
        }



        int sinirBas=0, sinirSon=0;
        if(konumX==0) {
            sinirBas=1;
        }else if(konumX==yerler.length-1){
            sinirSon=1;
        }

        for (int i = konumY; i < 10; i++) {


            if(yerler[i][konumX]=='-'){

                if(sinirBas==1 || yerler[i][konumX-1] == '-' || yerler[i][konumX-1] == ' ') {


                    if(sinirSon==1 || yerler[i][konumX+1] == '-' || yerler[i][konumX+1] == ' ') {

                        uygunY++;

                    }else {

                        break;
                    }

                }else{

                    break;
                }
            }else if(i==konumY+indeks) {

                uygunY++;

            }else {

                break;
            }

            if(uygunY==kelimeUzunlugu) {

                if((i+1)==yerler.length || yerler[i+1][konumX]=='-' || yerler[i+1][konumX]==' ') {
                    if(konumY!=0) {
                        if(yerler[konumY-1][konumX]=='-' || yerler[konumY-1][konumX]==' ') {

                        }else {
                            uygunY=0;
                        }

                    }

                    break;
                }else {

                    uygunY=0;
                    break;
                }

            }
        }

        if(uygunY>=kelimeUzunlugu) {

            int j=0;
            for (int i = konumY; i < 10; i++) {
                if(j==kelimeUzunlugu) {
                    yerler[i][konumX]=' ';
                    break;
                }

                yerler[i][konumX]=kelime.charAt(j);
                j++;

            }

            uygunArrayList.remove(kelime);
            bulmacaArrayList.add(kelime);
            konumYList.add(konumY);
            konumXList.add(konumX);
            yonList.add(1);

        }else {


        }
    }
    public static void yatayYerlestir(String kelime, int indeks, int konumX, int konumY) {

        int kelimeUzunlugu=kelime.length();
        int uygunX=0;

        if(konumX < indeks) {
        }else {
            konumX-=indeks;
        }



        int sinirBas=0, sinirSon=0;
        if(konumY==0) {
            sinirBas=1;
        }else if(konumY==yerler.length-1){
            sinirSon=1;
        }

        for (int i = konumX; i < 10; i++) {


            if(yerler[konumY][i]=='-'){


                if(sinirBas==1 || yerler[konumY-1][i] == '-' || yerler[konumY-1][i] == ' ') {



                    if(sinirSon==1 || yerler[konumY+1][i] == '-' || yerler[konumY+1][i] == ' ') {

                        uygunX++;

                    }else {

                        break;
                    }

                }else {

                    break;
                }

            }else if(i==konumX+indeks) {

                uygunX++;

            }else {
                break;
            }

            if(uygunX==kelimeUzunlugu) {

                if((i+1)==yerler.length || yerler[konumY][i+1]=='-' || yerler[konumY][i+1]==' ' ) {
                    if(konumX!=0) {
                        if(yerler[konumY][konumX-1]=='-' || yerler[konumY][konumX-1]==' ') {

                        }else {
                            uygunX=0;
                        }
                    }

                    break;
                }else {

                    uygunX=0;
                    break;
                }

            }
        }

        if(uygunX>=kelimeUzunlugu) {

            int j=0;
            for (int i = konumX; i < 10; i++) {
                if(j==kelimeUzunlugu) {
                    yerler[konumY][i]=' ';
                    break;
                }

                yerler[konumY][i]=kelime.charAt(j);
                j++;

            }

            uygunArrayList.remove(kelime);
            bulmacaArrayList.add(kelime);
            konumYList.add(konumY);
            konumXList.add(konumX);
            yonList.add(0);

        }else {


        }
    }

    public void kelimeListesiOlustur(){

        ilkKelimeyiSec=random.nextInt(wordsArrayList.size());
        while(true) {

            if((wordsArrayList.get(ilkKelimeyiSec).length()==enFazla) || (level>=3 && (wordsArrayList.get(ilkKelimeyiSec).length()==(enFazla+2) || wordsArrayList.get(ilkKelimeyiSec).length()==(enFazla+1)))){
                uygunArrayList.add(wordsArrayList.get(ilkKelimeyiSec));
                ilkKelime=uygunArrayList.get(0);
                wordsArrayList.remove(ilkKelimeyiSec);

                break;
            }else{
                ilkKelimeyiSec++;
                if(ilkKelimeyiSec>=wordsArrayList.size()) {
                    ilkKelimeyiSec=0;

                }
            }
        }


        ilkKelimedekiHarf = new ArrayList<>();
        ilkKelimedekiAdet = new ArrayList<>();

        secilenKelimedekiHarf = new ArrayList<>();
        secilenKelimedekiAdet = new ArrayList<>();

        harfVeAdetleriBulma(ilkKelime, 1);

        neredenBaslasin=random.nextInt(wordsArrayList.size());

        if(neredenBaslasin+1>=wordsArrayList.size()) {
            neredenBasladim=wordsArrayList.get(0);
        }else {
            neredenBasladim=wordsArrayList.get(neredenBaslasin+1);
        }



        tamamlanmadi=true;

        while(tamamlanmadi) {

            listeyiDolas();

            for (int i = 0; i < ilkKelimedekiHarf.size(); i++) {

                int j=0;

                if(secilenKelimedekiHarf.size()==0){

                    break;
                }

                while(true) {

                    if(secilenKelimedekiHarf.get(j).equals(ilkKelimedekiHarf.get(i))) {

                        if(secilenKelimedekiAdet.get(j)<=ilkKelimedekiAdet.get(i)){

                            secilenKelimedekiHarf.remove(j);
                            secilenKelimedekiAdet.remove(j);

                            if(secilenKelimedekiHarf.size()==0){

                                uygunArrayList.add(secilenKelime);

                                wordsArrayList.remove(neredenBaslasin);

                                neredenBaslasin--; //


                                listeyiDolas();
                                i=-1;

                            }

                            break;
                        }else{

                            secilenKelimedekiHarf.clear();
                            secilenKelimedekiAdet.clear();
                            i=-1;
                            listeyiDolas();
                            break;

                        }
                    }else{

                        j++;
                        if(j>secilenKelimedekiHarf.size()-1 ){

                            break;
                        }

                    }
                }



            }

        }
        System.out.println("Bulmaca için uygun kelimeler : ");
        for (int k = 0; k < uygunArrayList.size(); k++) {
            System.out.println(k+". kelime : "+ uygunArrayList.get(k));
        }

        bulmacaOlustur();

    }
    public void kelimeleriCek(){ //metin belgesinden kelimeleri almak icin
        wordsArrayList=new ArrayList<String>();

        String sozluk;
        if(level==1){
            sozluk="sozluk3.txt";
        }else if(level==2){
            sozluk="sozluk4.txt";
        }else{
            sozluk="sozluk5.txt";
        }
        FileHandle file = Gdx.files.internal(sozluk);
        String text = file.readString();
        String [] word=text.split("\n");

        String ekle;
        for (int i=0; i<word.length; i++){

            ekle=word[i].substring(0,word[i].length()-1);

            if(word[i].length()>2 && wordsArrayList.indexOf(ekle)==(-1)){

                wordsArrayList.add(ekle.toUpperCase());
            }

        }

        kelimeListesiOlustur();
    }

    public static void listeyiDolas() {

        if(tamamlanmadi) {


            if(uygunArrayList.indexOf(neredenBasladim) != (-1) ) {
                degistir=1;
            }

            if(wordsArrayList.isEmpty()) {
                tamamlanmadi=false;
            }else {
                if(neredenBaslasin>=wordsArrayList.size()-1){

                    neredenBaslasin=0;

                }else{

                    neredenBaslasin++;

                }


                secilenKelime = wordsArrayList.get(neredenBaslasin);


                if(neredenBasladim.equals(secilenKelime)) {
                    if(ilkGiris==1) {
                        ilkGiris=0;
                    }else {

                        tamamlanmadi=false;
                    }

                }

                if(degistir==1) {
                    neredenBasladim=secilenKelime;
                    degistir=0;

                }

                harfVeAdetleriBulma(secilenKelime,2);
            }

        }


    }
    public static void harfVeAdetleriBulma(String kelime, int liste){

        if(liste==1){

            for (int i=0; i<kelime.length(); i++){

                int indeks=ilkKelimedekiHarf.indexOf(kelime.charAt(i));

                if(indeks==(-1)){

                    ilkKelimedekiHarf.add(kelime.charAt(i));
                    ilkKelimedekiAdet.add(1);

                }else{

                    int adet=ilkKelimedekiAdet.get(ilkKelimedekiHarf.indexOf(kelime.charAt(i)))+1;
                    ilkKelimedekiAdet.set(indeks,adet);
                }
            }



            enUzun=kelime.length();

        }else if(liste==2){


            toplamUzunluk=kelime.length();

            if(toplamUzunluk>enUzun) {

                listeyiDolas();

            }else{

                if(secilenKelimedekiAdet.isEmpty()) {

                }else {

                    secilenKelimedekiAdet.clear();
                    secilenKelimedekiHarf.clear();
                }


                for (int i=0; i<kelime.length(); i++){


                    if(secilenKelimedekiHarf.isEmpty()){

                        secilenKelimedekiHarf.add(kelime.charAt(i));
                        secilenKelimedekiAdet.add(1);
                    }else {


                        int indeks=secilenKelimedekiHarf.indexOf(kelime.charAt(i));
                        if(indeks==(-1)){

                            secilenKelimedekiHarf.add(kelime.charAt(i));
                            secilenKelimedekiAdet.add(1);
                        }else{

                            int adet=secilenKelimedekiAdet.get(secilenKelimedekiHarf.indexOf(kelime.charAt(i)))+1;
                            secilenKelimedekiAdet.set(indeks,adet);
                        }
                    }

                }



            }

        }

    }

    public static ArrayList<String> getUygunArrayList() {
        return uygunArrayList;
    }

    public static void setUygunArrayList(ArrayList<String> uygunArrayList) {
        Crossword.uygunArrayList = uygunArrayList;
    }

    public static char[][] getYerler() {
        return yerler;
    }

    public static void setYerler(char[][] yerler) {
        Crossword.yerler = yerler;
    }

    public static ArrayList<String> getWordsArrayList() {
        return wordsArrayList;
    }

    public static void setWordsArrayList(ArrayList<String> wordsArrayList) {
        Crossword.wordsArrayList = wordsArrayList;
    }

    public static int getTemizlikSat() {
        return temizlikSat;
    }

    public static void setTemizlikSat(int temizlikSat) {
        Crossword.temizlikSat = temizlikSat;
    }

    public static int getTemizlikSut() {
        return temizlikSut;
    }

    public static void setTemizlikSut(int temizlikSut) {
        Crossword.temizlikSut = temizlikSut;
    }

    public static ArrayList<String> getBulmacaArrayList() {
        return bulmacaArrayList;
    }

    public static void setBulmacaArrayList(ArrayList<String> bulmacaArrayList) {
        Crossword.bulmacaArrayList = bulmacaArrayList;
    }

    public static ArrayList<Integer> getKonumXList() {
        return konumXList;
    }

    public static void setKonumXList(ArrayList<Integer> konumXList) {
        Crossword.konumXList = konumXList;
    }

    public static ArrayList<Integer> getKonumYList() {
        return konumYList;
    }

    public static void setKonumYList(ArrayList<Integer> konumYList) {
        Crossword.konumYList = konumYList;
    }

    public static ArrayList<Integer> getYonList() {
        return yonList;
    }

    public static void setYonList(ArrayList<Integer> yonList) {
        Crossword.yonList = yonList;
    }


}
