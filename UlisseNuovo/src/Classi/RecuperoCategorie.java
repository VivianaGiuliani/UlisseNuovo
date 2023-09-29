package Classi;

import java.sql.*;
import java.util.*;

public class RecuperoCategorie {
	public static void main(String [] args) {
		
	Statement st = null;
    ResultSet rs = null;
	Connection con  = Database.connect();
	ArrayList<Integer> pk = new ArrayList<Integer>(); 
	ArrayList<String> categorie = new ArrayList<String>(); 
	try {
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY pk DESC;");                 
        System.out.println("query eseguita");
        while (rs.next()) {
        	int id = rs.getInt("pk"); 
            pk.add(id);
            System.out.println(pk);
            String categoria = rs.getString("categoria"); 
        	categorie.add(categoria);    
        	System.out.println(categorie);
        }
        
        
    } catch (SQLException ex) {
    	ex.printStackTrace();

    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
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
