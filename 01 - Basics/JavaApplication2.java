/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author Maja Risek
 */
public class Osoba {
    
    private String ime;
    private String prezime;
    private int godina;
    private char spol;
    
    

    public Osoba() {
    }

    public Osoba(String ime, String prezime, int godina, char spol) {
        this.ime = ime;
        this.prezime = prezime;
        this.godina = godina;
        this.spol = spol;
    }

    /**
     * Get the value of spol
     *
     * @return the value of spol
     */
    public char getSpol() {
        return spol;
    }

    /**
     * Set the value of spol
     *
     * @param spol new value of spol
     */
    public void setSpol(char spol) {
        this.spol = spol;
    }


    /**
     * Get the value of godina
     *
     * @return the value of godina
     */
    public int getGodina() {
        return godina;
    }

    /**
     * Set the value of godina
     *
     * @param godina new value of godina
     */
    public void setGodina(int godina) {
        this.godina = godina;
    }


    /**
     * Get the value of prezime
     *
     * @return the value of prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Set the value of prezime
     *
     * @param prezime new value of prezime
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }


    /**
     * Get the value of ime
     *
     * @return the value of ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * Set the value of ime
     *
     * @param ime new value of ime
     */
    public void setIme(String ime) {
        this.ime = ime;
    }
    
    public void ispis() {
        System.out.println("Ime i prezime: " + ime + " " + prezime);
        System.out.println("Godina rođenja: " + godina);
        System.out.println("Spol: " + (spol == 'Z' ? "ženski" : "muški"));
    }
     
}
