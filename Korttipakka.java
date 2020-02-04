/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author s1900014
 */
public class Korttipakka {
    private ArrayList<Kortti> pakka;

    //konstruktori: talletetaan uusi tyhja pakka-lista kortteja varten
    //luokan oletuskonstruktio sijoittaa pakka-atribuuttiin 52-korttia numero- ja maajärjestyksessä.
    public Korttipakka() {
        pakka = new ArrayList<>(); // lähtee ykkösestä, päättyy 13
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("ruutu", i));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("hertta", i));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("risti", i));
        }
        for (int i = 1; i < 14; i++) {
            pakka.add(new Kortti("pata", i));
        }
    }

    public void lisaaKortti(Kortti uusi) {
        this.pakka.add(uusi);
    }
    
     //Metodi sekoittaa atribuutin "pakka"-listan korttien järjestyksen.
     public void sekoitaPakka () {
    Collections.shuffle(this.pakka);   
}
     
      //Metodi jaaKortti PALAUTTAA pakan ensimmäisen kortin ja poistaa sen pakasta.
      public Kortti jaaKortti () {
          Kortti jaettu = this.pakka.get(0);
          System.out.println("Jaettu kortti on " + jaettu);
          this.pakka.remove(0);
          return jaettu;
}

    @Override
    public String toString() {
        return " " + pakka;
    }
     
   
}
