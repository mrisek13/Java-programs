package oglascrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OglasService {
    private Connection conn;

    public OglasService(Connection conn) {
        this.conn = conn;
    }

    public boolean dodajOglas(Oglas oglas) {
        String query = "INSERT INTO OGLAS (naslov, datum, tekst) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, oglas.getNaslov());
            stmt.setString(2, oglas.getDatum());
            stmt.setString(3, oglas.getTekst());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Oglas dohvatOglasa(int id) {
        String query = "SELECT * FROM OGLAS WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Oglas oglas = new Oglas();
                oglas.setId(rs.getInt("id"));
                oglas.setNaslov(rs.getString("naslov"));
                oglas.setDatum(rs.getString("datum"));
                oglas.setTekst(rs.getString("tekst"));
                return oglas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean azurirajOglas(Oglas oglas) {
        String query = "UPDATE OGLAS SET naslov = ?, datum = ?, tekst = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, oglas.getNaslov());
            stmt.setString(2, oglas.getDatum());
            stmt.setString(3, oglas.getTekst());
            stmt.setInt(4, oglas.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean obrisiOglas(int id) {
        String query = "DELETE FROM OGLAS WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Oglas> sviOglasi() {
        List<Oglas> oglasi = new ArrayList<>();
        String query = "SELECT * FROM OGLAS";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Oglas oglas = new Oglas();
                oglas.setId(rs.getInt("id"));
                oglas.setNaslov(rs.getString("naslov"));
                oglas.setDatum(rs.getString("datum"));
                oglas.setTekst(rs.getString("tekst"));
                oglasi.add(oglas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oglasi;
    }
}
