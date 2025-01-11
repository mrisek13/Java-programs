/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oglasTest;

/**
 *
 * @author Mrisek
 */
import oglas.OglasService;
import oglas.Oglas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import static org.junit.Assert.*;

public class OglasServiceTest {

    private OglasService oglasService;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oglasi", "root", "");
        oglasService = new OglasService(connection);
        oglasService.obrisiSveOglase();
    }

    @After
    public void tearDown() throws Exception {
        oglasService.obrisiSveOglase();
        connection.close();
    }

    @Test
    public void testDodajOglas() {
        Oglas oglas = new Oglas();
        oglas.setNaslov("Test Oglas");
        oglas.setDatum("2025-01-08");
        oglas.setTekst("Ovo je testni oglas.");

        boolean rezultat = oglasService.dodajOglas(oglas);
        assertTrue("Dodavanje oglasa nije uspjelo", rezultat);

        Oglas dohvatOglas = oglasService.dohvatiOglas(oglas.getNaslov());
        assertNotNull("Oglas nije pronađen", dohvatOglas);
        assertEquals("Naslov oglasa nije ispravan", "Test Oglas", dohvatOglas.getNaslov());
    }

    @Test
    public void testDohvatOglasa() {
        Oglas oglas = new Oglas();
        oglas.setNaslov("Dohvat Test");
        oglas.setDatum("2025-01-08");
        oglas.setTekst("Ovo je testni dohvat.");
        oglasService.dodajOglas(oglas);

        Oglas dohvatOglas = oglasService.dohvatiOglas(oglas.getNaslov());
        assertNotNull("Oglas nije pronađen", dohvatOglas);
        assertEquals("Naslov nije isti", "Dohvat Test", dohvatOglas.getNaslov());
        assertEquals("Tekst nije isti", "Ovo je testni dohvat.", dohvatOglas.getTekst());
    }

    @Test
    public void testAzurirajOglas() {
        Oglas oglas = new Oglas();
        oglas.setNaslov("Oglas za Ažuriranje");
        oglas.setDatum("2025-01-08");
        oglas.setTekst("Prije ažuriranja.");
        oglasService.dodajOglas(oglas);

        oglas.setTekst("Poslije ažuriranja.");
        boolean rezultat = oglasService.azurirajOglas(oglas);
        assertTrue("Ažuriranje oglasa nije uspjelo", rezultat);

        Oglas azuriraniOglas = oglasService.dohvatiOglas(oglas.getNaslov());
        assertEquals("Tekst oglasa nije ažuriran", "Poslije ažuriranja.", azuriraniOglas.getTekst());
    }

    @Test
    public void testObrisiOglas() {
        Oglas oglas = new Oglas();
        oglas.setNaslov("Obrisani Oglas");
        oglas.setDatum("2025-01-08");
        oglas.setTekst("Ovo će biti obrisano.");
        oglasService.dodajOglas(oglas);

        boolean rezultat = oglasService.obrisiOglas("Obrisani Oglas");
        assertTrue("Brisanje oglasa nije uspjelo", rezultat);

        Oglas obrisiProvjera = oglasService.dohvatiOglas(oglas.getNaslov());
        assertNull("Oglas nije obrisan", obrisiProvjera);
    }

    @Test
    public void testSviOglasi() throws SQLException {
        Oglas oglas1 = new Oglas();
        oglas1.setNaslov("Prvi Oglas");
        oglas1.setDatum("2025-01-08");
        oglas1.setTekst("Tekst prvog oglasa.");
        oglasService.dodajOglas(oglas1);

        Oglas oglas2 = new Oglas();
        oglas2.setNaslov("Drugi Oglas");
        oglas2.setDatum("2025-01-09");
        oglas2.setTekst("Tekst drugog oglasa.");
        oglasService.dodajOglas(oglas2);

        Vector sviOglasi = oglasService.sviOglasi();
        assertEquals("Broj oglasa nije ispravan", 2, sviOglasi.size());
    }
}

