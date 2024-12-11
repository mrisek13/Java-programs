/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mrisek
 */
class OsobnaIskaznica {
    private String ime;
    private String prezime;
    private String adresa;
    private String OIB;
    private String spol;

    // Konstruktor
    public OsobnaIskaznica(String ime, String prezime, String adresa, String OIB, String spol) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.OIB = OIB;
        this.spol = spol;
    }

    // Get i set metode
    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getOIB() { return OIB; }
    public void setOIB(String OIB) { this.OIB = OIB; }

    public String getSpol() { return spol; }
    public void setSpol(String spol) { this.spol = spol; }

    @Override
    public String toString() {
        return ime + ";" + prezime + ";" + adresa + ";" + OIB + ";" + spol;
    }
}