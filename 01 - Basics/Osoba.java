package vjezba_01;

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
  
    public void ispis() {
        System.out.println("Ime i prezime:" + ime + " " + prezime);
        System.out.println("Godina rođenja:" + godina);
        System.out.println("Spol:" + (spol == 'Z' ? "ženski" : "muški"));
    }

    public char getSpol() {
        return spol;
    }

    public void setSpol(char spol) {
        this.spol = spol;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
