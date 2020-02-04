/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

/**
 *
 * @author s1900014
 */
public class Kortti {
    private String maa;
    private int arvo;
    
    //konstruktori
    public Kortti(String maa, int arvo){
        this.maa=maa;
        this.arvo=arvo;  
    }

    public String getMaa() {
        return maa;
    }

    public int getArvo() {
        return this.arvo;
    }

    @Override
    public String toString() {
        return maa + " " + arvo;
    }
         
}
