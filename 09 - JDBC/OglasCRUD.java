package oglascrud;

public class OglasCRUD {

    public static void main(String[] args) {
        DB db = new DB();
        db.initConnection_MySQL();
        if (db.isConnected()) {
            System.out.println("SPOJENO NA BAZU!");
        } else {
            System.out.println("Spajanje na bazu nije uspjelo...");
        }
        
        OglasService oglasService = new OglasService(db.conn);

        // Dodavanje oglasa
        Oglas oglas = new Oglas();
        oglas.setId(1);
        oglas.setNaslov("Prodaja stana");
        oglas.setDatum("2025-01-08");
        oglas.setTekst("Stan u centru grada. Pogledajte ponudu.");
        oglasService.dodajOglas(oglas);

        // Dohvat oglasa
        Oglas dohvatOglas = oglasService.dohvatOglasa(1);
        System.out.println("Dohvaćen oglas: " + dohvatOglas.getNaslov());
    }
    
}
