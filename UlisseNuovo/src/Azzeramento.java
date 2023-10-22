import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Classi.Database;

public class Azzeramento {
	public Azzeramento() {
		eliminaVendite();
		JOptionPane.showMessageDialog(null, "Operazione eseguita", "InfoBox: Azzeramento", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void eliminaVendite() {
    	String SQL = "DELETE FROM sys.vendite";
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
