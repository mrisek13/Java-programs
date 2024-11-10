/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mrisek
 */
public class Knjiga {
    private String naziv;
    private int skupina=0;
    private String autor;
    private int godina;
    

    public Knjiga() {
    }

    public Knjiga(String naziv, int skupina, String autor, int godina) {
        this.naziv = naziv;
        this.skupina = skupina;
        this.autor = autor;
        this.godina = godina;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getSkupina() {
        return skupina;
    }

    public String getAutor() {
        return autor;
    }

    public int getGodina() {
        return godina;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setSkupina(int skupina) {
        this.skupina = skupina;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

}
