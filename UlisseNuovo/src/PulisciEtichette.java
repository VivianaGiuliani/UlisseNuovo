import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Classi.Database;

public class PulisciEtichette {
	public PulisciEtichette() {
		eliminaEtichette();
		JOptionPane.showMessageDialog(null, "Operazione eseguita", "InfoBox: Pulisci Etichette", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void eliminaEtichette() {
    	String SQL = "DELETE FROM sys.etichette";
    	PreparedStatement pstmt = null;

    	Connection con  = Database.connect();

    	
    	try {
    		pstmt = con.prepareStatement(SQL); 
			pstmt.executeUpdate();
			con.close(); 
        }  catch (SQLException ex) {
        	ex.printStackTrace();

        } finally {
            try {
                if (pstmt != null) {
                	pstmt.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    	
    }
}
