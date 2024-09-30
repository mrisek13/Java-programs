package vjezba_01;

public class Radnik extends Osoba{
    
    private String nazivPoduzeca;
    private String radnoMjesto;
    private int godinaRadnogStaza;

    @Override
    public void ispis() {
        super.ispis();
        System.out.println("Naziv poduzeca: " + this.getNazivPoduzeca());
        System.out.println("Radno mjesto: " + this.getRadnoMjesto());
        System.out.println("Godina radnog staza: " + this.getGodinaRadnogStaza());
    }

    
    
    public Radnik(String nazivPoduzeca, String radnoMjesto, int godinaRadnogStaza, String ime, String prezime, int godina, char spol) {
        super(ime, prezime, godina, spol);
        this.nazivPoduzeca = nazivPoduzeca;
        this.radnoMjesto = radnoMjesto;
        this.godinaRadnogStaza = godinaRadnogStaza;
    }

    public Radnik() {
    }

    public Radnik(String nazivPoduzeca, String radnoMjesto, int godinaRadnogStaza) {
        this.nazivPoduzeca = nazivPoduzeca;
        this.radnoMjesto = radnoMjesto;
        this.godinaRadnogStaza = godinaRadnogStaza;
    }
    

    public Radnik(String ime, String prezime, int godina, char spol) {
        super(ime, prezime, godina, spol);
    }
    
    public String getNazivPoduzeca() {
        return nazivPoduzeca;
    }

    public void setNazivPoduzeca(String nazivPoduzeca) {
        this.nazivPoduzeca = nazivPoduzeca;
    }

    public String getRadnoMjesto() {
        return radnoMjesto;
    }

    public void setRadnoMjesto(String radnoMjesto) {
        this.radnoMjesto = radnoMjesto;
    }

    public int getGodinaRadnogStaza() {
        return godinaRadnogStaza;
    }

    public void setGodinaRadnogStaza(int godinaRadnogStaza) {
        this.godinaRadnogStaza = godinaRadnogStaza;
    }
    
}
