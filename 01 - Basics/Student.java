package vjezba_01;

public class Student extends Osoba {
    
    private int MBS;
    private String nazivStudija;
    private int godinaStudija;
    
    @Override
    public void ispis() {
        super.ispis(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("JMBAG: " + this.getMBS());
        System.out.println("Naziv studija: " + this.getNazivStudija());
        System.out.println("Godina studija: " + this.getGodinaStudija());
    }
    
    public Student() {
    }

    public Student(String ime, String prezime, int godina, char spol) {
        super(ime, prezime, godina, spol);
    }
    
    public int getMBS() {
        return MBS;
    }

    public void setMBS(int MBS) {
        this.MBS = MBS;
    }

    public String getNazivStudija() {
        return nazivStudija;
    }

    public void setNazivStudija(String nazivStudija) {
        this.nazivStudija = nazivStudija;
    }

    public int getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(int godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public Student(int MBS, String nazivStudija, int godinaStudija, String ime, String prezime, int godina, char spol) {
        super(ime, prezime, godina, spol);
        this.MBS = MBS;
        this.nazivStudija = nazivStudija;
        this.godinaStudija = godinaStudija;
    }
}
