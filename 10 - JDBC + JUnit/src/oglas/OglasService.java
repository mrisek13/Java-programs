package oglas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mrisek
 */
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OglasService {
    public java.sql.Connection conn;
    public Logger logger;
    public Logger logger_err;

    public OglasService() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isConnected(){
        if(this.conn!=null)
            return true;
        else
            return false;
    }

    public boolean disconnect() throws SQLException {
        boolean OK=false;
        try {
            if (conn != null) {
                conn.close();
                OK=true;
            }
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
        }
        finally{
            return OK;
        }   
    }

    public void initConnection_MySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            java.util.Properties props = new java.util.Properties();

            props.put("characterEncoding", "cp1250");
            props.put("characterSetResults", "cp1250");
            props.put("user", "root");
            props.put("password", "");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oglasi", props);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean disconnect(Connection con) throws SQLException {
        boolean OK = false;
        try {
            if (con != null) {
                con.close();
                OK = true;
            }
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
        }
        return OK;
    }   

    public OglasService(Connection conn) {
        this.conn = conn;
    }

    public boolean dodajOglas(Oglas data) {
                     
        if (this.conn == null ) {
            return false;
        }
        try {
            Statement stm;
            String input = "INSERT INTO OGLAS (naslov, datum, tekst) VALUES (?, ?, ?)";
            PreparedStatement stmt = this.conn.prepareStatement(input);

            stmt.setString(1, data.getNaslov());
            stmt.setString(2, data.getDatum());
            stmt.setString(3, data.getTekst());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return false;
        }
    }

    public boolean azurirajOglas(Oglas oglas) {        
        if (this.conn == null ) {
            return false;
        }
        try {
            Statement stmt = this.conn.createStatement();
            String query = "UPDATE OGLAS SET tekst='" + oglas.getTekst() + "' WHERE naslov = '" + oglas.getNaslov() + "'";
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        } catch (SQLException ex) {
            logger_err.log(Level.WARNING, "SQLException: " + ex.getMessage());
            return false;
        }      
    }

    public boolean obrisiOglas(String naslov) {
        String query = "DELETE FROM OGLAS WHERE naslov = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, naslov);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean obrisiSveOglase() {
        String query = "DELETE FROM OGLAS";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    

    public Vector sviOglasi() throws java.sql.SQLException { 
        
        Vector vec = new Vector();
        if (this.conn == null) {
            return vec;
        }
        
        try {
            Statement stm = this.conn.createStatement();
            String query = "SELECT * FROM OGLAS ORDER BY 1 DESC";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Oglas data = new Oglas();
                data.setId(rs.getInt(1));
                data.setNaslov(rs.getString(2)); // naslov oglasa
                data.setDatum(rs.getString(3)); // datum oglasa
                data.setTekst(rs.getString(4)); // tekt oglasa
                vec.addElement(data);
            }
            query = null;
            rs.close();
            stm.close();
            return vec;
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
            return vec;
        }
    }
    
    public Oglas dohvatiOglas(String naslov) {
        Oglas data = null;
        try {
            Statement stm = this.conn.createStatement();
            String query = "SELECT * FROM OGLAS WHERE NASLOV ='" + naslov + "'";
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                data = new Oglas();
                data.setId(rs.getInt(1));
                data.setNaslov(rs.getString(2));
                data.setDatum(rs.getString(3));
                data.setTekst(rs.getString(4));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            logger_err.log(Level.WARNING, "SQLException: " + e.getMessage());
        }
        return data;
    }

}
