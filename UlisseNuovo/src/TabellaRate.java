import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;

public class TabellaRate {
	public TabellaRate() {
		 JFrame window = new JFrame();
	        window.setSize(400, 700);
	        window.setTitle("Tabella Rate");
	        window.setResizable(false);
	        
	        JLabel tabella_rate_label = new JLabel("Tabella Rate");
	        tabella_rate_label.setFont(new Font("Courier", Font.BOLD, 20));
	        tabella_rate_label.setBounds(10, 10, 300, 30);
	        window.add(tabella_rate_label);
	        
	        
	        JPanel tablePanel = new JPanel();
	        tablePanel.setLayout(null);
	        tablePanel.setBounds(10, 50, 300, 500);

	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(0, 0, 300, 500);

	        String[] columnNames = {"N_Rata"};

	        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	        JTable table = new JTable(model);
	        table.setAutoResizeMode(JTable.WIDTH);
	        
	        scrollPane.setViewportView(table);
	        tablePanel.add(scrollPane);
	        window.add(tablePanel);
	        
	        ArrayList<String> rate = rateNomeStr();
	        
	        for(int i = 0; i < rate.size(); i++) {
	    		model.addRow(new Object[] {rate.get(i)});
	    	}
	        
	        window.setLayout(null);
	        window.setVisible(true);
	}
	
	public static ArrayList<String> rateNomeStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> rate = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.rate ORDER BY idrate ASC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String nome = rs.getString("nome"); 
            	rate.add(nome);
                System.out.println(nome);
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
		return rate;
		
    }
}
