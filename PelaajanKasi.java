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
public class PelaajanKasi {

    //luokka PelaajanKasi, jolla on ArrayList<Kortti>-tyyppinen atribuutti kortit
    private ArrayList<Kortti> kortit;

    //konstruktori, joka luo listan korteille
    public PelaajanKasi() {
        kortit = new ArrayList<>();
    }

    //metodi otaKortti, joka lisää kortit-listaan parametrina saamansa kortin.
    public void otaKortti(Kortti uusi) {
        this.kortit.add(uusi);
    }

    //metodi, joka selvittää pelaajan käden summan annetuin säännöin
    //kortin arvo 2-10:	käden summaan lisätään kortin numeroa vastaava arvo
    //kortin arvo 11-13 kuvakortit: käden summaan lisätään 10 
    //kortin arvo 1 ässä: käden summaan lisätään 11 
    //jos alussa kaksi ässää niin toisen arvo 1
    public int selvitaSumma() {
        int summa = 0;
        for (Kortti kortti : kortit) {
            if (kortti.getArvo() == 1) {
                summa = summa + 11;
            } else if (kortti.getArvo() > 10) {
                summa = summa + 10;
            } else {
                summa = summa + kortti.getArvo();
            }
        }
        if (summa > 21 && kortit.size() == 2) {
            summa = summa - 10;
        }
        return summa;
    }

    public boolean onkoPelaajallaBlackJack() {
        if (this.selvitaSumma() == 21 && this.kortit.size() == 2) {
            //System.out.println("Blackjack-testi");
            return true;
        }
        return false;
    }

}
