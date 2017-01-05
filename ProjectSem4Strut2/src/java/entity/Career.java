/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Panda
 */
public class Career {

    private String codeCareer;
    private String nameCareer;
    private int priceCareer;

    public Career() {
    }

    public Career(String codeCareer, String nameCareer, int priceCareer) {
        this.codeCareer = codeCareer;
        this.nameCareer = nameCareer;
        this.priceCareer = priceCareer;
    }

    public String getCodeCareer() {
        return codeCareer;
    }

    public void setCodeCareer(String codeCareer) {
        this.codeCareer = codeCareer;
    }

    public String getNameCareer() {
        return nameCareer;
    }

    public void setNameCareer(String nameCareer) {
        this.nameCareer = nameCareer;
    }

    public int getPriceCareer() {
        return priceCareer;
    }

    public void setPriceCareer(int priceCareer) {
        this.priceCareer = priceCareer;
    }

}
