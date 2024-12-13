
public class Racunalo {

    private String naziv;
    private int ram;
    private boolean bit;
    private double brzina;

    public Racunalo(String naziv, int ram, boolean bit, double brzina) {
        this.naziv = naziv;
        this.ram = ram;
        this.bit = bit;
        this.brzina = brzina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public boolean isBit() {
        return bit;
    }

    public void setBit(boolean bit) {
        this.bit = bit;
    }

    public double getBrzina() {
        return brzina;
    }

    public void setBrzina(double brzina) {
        this.brzina = brzina;
    }

    public String getBit() {
        return bit ? "64 bitno" : "32 bitno";
    }
}
