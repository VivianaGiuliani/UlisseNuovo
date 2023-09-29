package Classi;
import java.sql.*;

public class Database {
	
	public static Connection connect() {
		Connection con = null;
	    try {
	    	System.out.println("Loaded driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=administrator&password=giuliani");
            System.out.println("Connected to MySQL");
	        if (con == null) {
	            System.out.println("Connection cannot be established");
	        }
	        return con;
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}
}
