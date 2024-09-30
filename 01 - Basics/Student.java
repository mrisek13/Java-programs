package vjezba_01;

public class Student extends Osoba{
    
    private int MBS;
    private String nazivStudija;
    private int godinaStudija;

    public Student() {
    }
    
    @Override
    public void ispis() {
        super.ispis();
        System.out.println("JMBAG: " + this.getMBS());
        System.out.println("Naziv studija: " + this.getNazivStudija());
        System.out.println("Godina studija: " + this.getGodinaStudija());
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
}
