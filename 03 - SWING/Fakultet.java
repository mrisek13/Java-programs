/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrisek
 */
public class Fakultet {
    private String naziv;
    private String grad;
    private int podrucje;
    private int zupanija;
    private int brojStudenata;

    public Fakultet() {
    }

    public Fakultet(String naziv, String grad, int podrucje, int zupanija, int brojStudenata) {
        this.naziv = naziv;
        this.grad = grad;
        this.podrucje = podrucje;
        this.zupanija = zupanija;
        this.brojStudenata = brojStudenata;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the grad
     */
    public String getGrad() {
        return grad;
    }

    /**
     * @param grad the grad to set
     */
    public void setGrad(String grad) {
        this.grad = grad;
    }

    /**
     * @return the podrucje
     */
    public int getPodrucje() {
        return podrucje;
    }

    /**
     * @param podrucje the podrucje to set
     */
    public void setPodrucje(int podrucje) {
        this.podrucje = podrucje;
    }

    /**
     * @return the zupanija
     */
    public int getZupanija() {
        return zupanija;
    }

    /**
     * @param zupanija the zupanija to set
     */
    public void setZupanija(int zupanija) {
        this.zupanija = zupanija;
    }

    /**
     * @return the brojStudenata
     */
    public int getBrojStudenata() {
        return brojStudenata;
    }

    /**
     * @param brojStudenata the brojStudenata to set
     */
    public void setBrojStudenata(int brojStudenata) {
        this.brojStudenata = brojStudenata;
    }


    
}
