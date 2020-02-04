/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.Scanner;

/**
 *
 * @author s1900014
 */
public class BlackJack {

    public static void main(String[] args) {
        System.out.println("Tervetuloa pelaamaan Blackjackia!");
        System.out.println("Pelin tarkoitus on saada 21 pistettä.\n"
                + "Korttien arvo on sama kuin niiden numero, paitsi kuvakorttien arvo on 10 ja ässien 11.\n"
                + "Jos saat alussa kaksi ässää, toisen arvoksi lasketaan 1.\n"
                + "Paras tulos on BlackJack eli 21 pistettä kahdella ensimmäisellä kortilla.\n"
                + "Jos menet yli 21:n pisteen, häviät automaattisesti.\n"
                + "Samoilla pisteillä tulee tasapeli, paitsi BlackJack voittaa pistemäärän 21.");
        System.out.println("Pelaat tietokoneavustajaa vastaan. Jaan sinulle nyt kaksi korttia.");
        System.out.println("");

        //tehdään pakka
        Korttipakka pakka = new Korttipakka();
        //sekoitetaan pakka
        pakka.sekoitaPakka();

        PelaajanKasi pelaajaPekka = new PelaajanKasi();
 
        //Jaetaan ja lisätään kortti metodeilla
        //Pekka ottaa kortin, pakka jakaa sen
        pelaajaPekka.otaKortti(pakka.jaaKortti());
        pelaajaPekka.otaKortti(pakka.jaaKortti());
        
        //Testausta varten
        // pelaajaPekka.otaKortti(new Kortti("ruutu", 1));
        // pelaajaPekka.otaKortti(new Kortti("ruutu", 3));
        
        //selvitetään summa
        int summa = pelaajaPekka.selvitaSumma();
        System.out.println("Summasi on: " + summa);
        if(pelaajaPekka.onkoPelaajallaBlackJack()){
            System.out.println("Sait kahden kortin Blackjackin, hurraa!");
        }
        System.out.println("");

        //tuodaan scanneri
        Scanner lukija = new Scanner(System.in);

        //testataan onko summa yli 21
        while (true) {
            if (summa < 21) {
                System.out.println("Haluatko ottaa uuden kortin? Joo vai Ei?");
                String vastaus = lukija.nextLine();

                if (vastaus.equalsIgnoreCase("Joo")) {
                    System.out.println("Selvä, jaan uuden kortin.");
                    pelaajaPekka.otaKortti(pakka.jaaKortti());
                    summa = pelaajaPekka.selvitaSumma();
                    System.out.println("Summasi on nyt: " + summa);
                    System.out.println("");
                }
                else if (vastaus.equalsIgnoreCase("Ei")) {
                    System.out.println("Selvä.");
                    System.out.println("");
                    break;
                }
                else {
                    System.out.println("En ymmärtänyt. Vastaa uudestaan.");
                }
                
            } else if (summa == 21) {
                System.out.println("Hienoa, summasi on paras mahdollinen: 21. Vuoro siirtyy tietokoneelle.");
                System.out.println("");
                break;
            } else {
                System.out.println("Harmin paikka, summasi meni yli 21:n! Hävisit tällä kertaa.");
                System.out.println("");
                break;
            }
        }
//If-lause että tietokone ei pelaa jos pelaajan summa yli 21
        if (summa <= 21) {
            System.out.println("Tietokone jakaa nyt kortit itselleen.");

            PelaajanKasi tietokone = new PelaajanKasi();
            
            tietokone.otaKortti(pakka.jaaKortti());
            tietokone.otaKortti(pakka.jaaKortti());

            int koneenSumma = tietokone.selvitaSumma();
            System.out.println("Tietokoneen summa on: " + koneenSumma);
            if(tietokone.onkoPelaajallaBlackJack()){
            System.out.println("Koneella kahden kortin Blackjack!");
        }
        System.out.println("");

            while (koneenSumma < 15) {
                System.out.println("Kone jatkaa ja ottaa uuden kortin.");
                tietokone.otaKortti(pakka.jaaKortti());
                koneenSumma = tietokone.selvitaSumma();
                System.out.println("Tietokoneen summa on nyt: " + koneenSumma);
                System.out.println("");
            }

            if (koneenSumma >= 15 && koneenSumma < 21 && koneenSumma < summa) {
                System.out.println("Summa on vähintään 15, tietokone ei voi nostaa lisää kortteja.");
                System.out.println("");
            }
            if (koneenSumma > 21) {
                System.out.println("Tietokoneen summa meni yli kahdenkymmenenyhden.");
                System.out.println("");
            }

            System.out.println("Sinun loppusummasi on: " + summa);
            System.out.println("Tietokoneen loppusumma on: " + koneenSumma);
            System.out.println("");
            
            if (pelaajaPekka.onkoPelaajallaBlackJack() && tietokone.onkoPelaajallaBlackJack()) {
                System.out.println("Tasapeli, koska molemmat saivat tällä kertaa Blackjackin.");
            }
            else if (pelaajaPekka.onkoPelaajallaBlackJack() && koneenSumma == 21) {
                System.out.println("Voitit pelin, koska sinulla on BlackJack");
            }
            else if(tietokone.onkoPelaajallaBlackJack() && summa == 21){
                System.out.println("Tietokone voitti pelin, koska se sai BlackJackin!");
            }   
            else if (summa == koneenSumma) {
                System.out.println("Tuli tasapeli! Molemmilla on sama summa.");
            } else if (koneenSumma <= 21 && koneenSumma > summa) {
                System.out.println("Tietokone voitti pelin!");
            } else {
                System.out.println("Onnea, voitit pelin!");
            }

        }
        System.out.println("Kiitos hyvästä pelistä!");

    }
}
