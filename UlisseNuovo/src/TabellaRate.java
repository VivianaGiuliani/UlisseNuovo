import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	public TabellaRate() {
		 	window = new JFrame();
	        window.setSize(370, 700);
	        window.setTitle("Tabella Rate");
	        window.setResizable(false);
	        
	        labelSfondo = new JLabel(imageSfondo);
			labelSfondo.setSize(1400, 800);
		        
		    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
		    Image img = imageSfondo.getImage();
		    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
		    ImageIcon scaledIcon = new ImageIcon(imgScale);
		    labelSfondo.setIcon(scaledIcon);
		       
		    window.add(labelSfondo);
	        
	        JLabel tabella_rate_label = new JLabel("Tabella Rate");
	        tabella_rate_label.setFont(new Font("", Font.BOLD, 20));
	        tabella_rate_label.setBounds(10, 10, 300, 30);
	        tabella_rate_label.setForeground(new java.awt.Color(255,255,255));
	        labelSfondo.add(tabella_rate_label);
	        
	        
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
	        labelSfondo.add(tablePanel);
	        
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
