package oglascrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {
    public java.sql.Connection conn;
    public Logger logger;
    public Logger logger_err;

    public DB() {
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
}
