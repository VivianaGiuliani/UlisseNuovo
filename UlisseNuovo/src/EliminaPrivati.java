import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Classi.Database;

public class EliminaPrivati {
	public EliminaPrivati() {
		String data = String.valueOf(java.sql.Date.valueOf(java.time.LocalDate.now()));
		String anno = data.substring(0,4);
		int annoInt = Integer.parseInt(anno);
		int annoCanc = annoInt - 5;
		System.out.println(annoCanc);
		eliminaRigaDb(String.valueOf(annoCanc));
		JOptionPane.showMessageDialog(null, "Operazione eseguita", "InfoBox: Elimina Privati", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.clienti WHERE UltimoAcquisto LIKE CONCAT(?, '%') ";
    	PreparedStatement pstmt = null;

    	Connection con  = Database.connect();

    	
    	try {
    		pstmt = con.prepareStatement(SQL); 
			pstmt.setString(1, value);
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
