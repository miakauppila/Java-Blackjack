/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;

/**
 *
 * @author s1900014
 */
public class Testiohjelma {

    public static void main(String[] args) {
        
        //tehdään pakka
        Korttipakka eka = new Korttipakka();
        System.out.println(eka);

        //jaetaan testinä 2 korttia pakasta jota ei ole sekoitettu
        eka.jaaKortti();
        eka.jaaKortti();

        //sekoitetaan pakka
        eka.sekoitaPakka();
        //printataan pakka, jossa näkyy sekoitus
        System.out.println(eka);

        //jaetaan kortteja
        eka.jaaKortti();
        eka.jaaKortti();
        //printataan pakka, josta näkyy mitä jäljellä
        System.out.println(eka);
        
        //tehdään pelaajan käsi
        PelaajanKasi mia = new PelaajanKasi();

        //lisätään kortit manuaalisesti
        mia.otaKortti(new Kortti("risti", 13));
        mia.otaKortti(new Kortti("risti", 1));
        //summan pitaa olla 10+11=21
        System.out.println(mia.selvitaSumma());

        //lisätään kortti metodeilla joka tehty luokassa Korttipakka
        //Kortti saatu = eka.jaaKortti();
        //mia.otaKortti(saatu);
        mia.otaKortti(eka.jaaKortti());

        //summa nyt 21 + edellisen rivin antama kortti
        mia.selvitaSumma();
        System.out.println(mia.selvitaSumma());

        PelaajanKasi tietokone = new PelaajanKasi();
        
        //Kaksi ässää
        tietokone.otaKortti(new Kortti("pata", 1));
        tietokone.otaKortti(new Kortti("ruutu", 1));

        // tietokone.otaKortti(pakka.jaaKortti());
        // tietokone.otaKortti(pakka.jaaKortti());
        int koneenSumma = tietokone.selvitaSumma();
        System.out.println("Summani on: " + koneenSumma);
        if (tietokone.onkoPelaajallaBlackJack()) {
            System.out.println("Kahden kortin blackjack, hurraa!");
        }
        
        // Kahden kortin Blackjackin testaus
        PelaajanKasi pelaaja = new PelaajanKasi();
        
        //pelaaja saa Blackjackin
        pelaaja.otaKortti(new Kortti("risti", 10));
        pelaaja.otaKortti(new Kortti("risti", 1));
        System.out.println(pelaaja.selvitaSumma());
        if (pelaaja.onkoPelaajallaBlackJack()) {
            System.out.println("Kahden kortin blackjack, hurraa!");
        }
        
        PelaajanKasi toka = new PelaajanKasi();

        toka.otaKortti(new Kortti("risti", 10));
        toka.otaKortti(new Kortti("risti", 7));
        toka.otaKortti(new Kortti ("risti", 4));
        System.out.println(toka.selvitaSumma());
        if (toka.onkoPelaajallaBlackJack()) {
            System.out.println("Kahden kortin blackjack, hurraa!");
        }
        
    }
}

