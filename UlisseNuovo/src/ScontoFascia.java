import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Classi.Database;
import Oggetti.Articolo;

public class ScontoFascia {
	public ScontoFascia() {
		JFrame window = new JFrame();
        window.setSize(700, 370);
        window.setTitle("Sconto Fascia");
        window.setResizable(false);
        
        JLabel sconto_fascia_label = new JLabel("Sconto fascia");
        sconto_fascia_label.setFont(new Font("Courier", Font.PLAIN, 20));
        sconto_fascia_label.setBounds(10, 10, 300, 20);
        window.add(sconto_fascia_label);
        
        JLabel fascia1da_label = new JLabel("Fascia 1 da: ");
        fascia1da_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia1da_label.setBounds(10, 50, 100, 20);
        window.add(fascia1da_label);

        JTextArea fascia1da_textbox = new JTextArea();
        fascia1da_textbox.setBounds(120, 50, 100, 30);
        window.add(fascia1da_textbox);
        
        JLabel fascia1a_label = new JLabel("a: ");
        fascia1a_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia1a_label.setBounds(250, 50, 30, 20);
        window.add(fascia1a_label);

        JTextArea fascia1a_textbox = new JTextArea();
        fascia1a_textbox.setBounds(290, 50, 100, 30);
        window.add(fascia1a_textbox);
        
        JLabel sconto_fascia1_label = new JLabel("Sconto:");
        sconto_fascia1_label.setFont(new Font("Courier", Font.PLAIN, 15));
        sconto_fascia1_label.setBounds(420, 50, 100, 20);
        window.add(sconto_fascia1_label);

        JTextArea sconto_fascia1_textbox = new JTextArea();
        sconto_fascia1_textbox.setBounds(480, 50, 100, 30);
        window.add(sconto_fascia1_textbox);
        
        JLabel fascia2da_label = new JLabel("Fascia 2 da: ");
        fascia2da_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia2da_label.setBounds(10, 100, 100, 20);
        window.add(fascia2da_label);

        JTextArea fascia2da_textbox = new JTextArea();
        fascia2da_textbox.setBounds(120, 100, 100, 30);
        window.add(fascia2da_textbox);
        
        JLabel fascia2a_label = new JLabel("a: ");
        fascia2a_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia2a_label.setBounds(250, 100, 30, 20);
        window.add(fascia2a_label);

        JTextArea fascia2a_textbox = new JTextArea();
        fascia2a_textbox.setBounds(290, 100, 100, 30);
        window.add(fascia2a_textbox);
        
        JLabel sconto_fascia2_label = new JLabel("Sconto:");
        sconto_fascia2_label.setFont(new Font("Courier", Font.PLAIN, 15));
        sconto_fascia2_label.setBounds(420, 100, 100, 20);
        window.add(sconto_fascia2_label);

        JTextArea sconto_fascia2_textbox = new JTextArea();
        sconto_fascia2_textbox.setBounds(480, 100, 100, 30);
        window.add(sconto_fascia2_textbox);
        
        JLabel fascia3da_label = new JLabel("Fascia 3 da: ");
        fascia3da_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia3da_label.setBounds(10, 150, 100, 20);
        window.add(fascia3da_label);

        JTextArea fascia3da_textbox = new JTextArea();
        fascia3da_textbox.setBounds(120, 150, 100, 30);
        window.add(fascia3da_textbox);
        
        JLabel fascia3a_label = new JLabel("a: ");
        fascia3a_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia3a_label.setBounds(250, 150, 30, 20);
        window.add(fascia3a_label);

        JTextArea fascia3a_textbox = new JTextArea();
        fascia3a_textbox.setBounds(290, 150, 100, 30);
        window.add(fascia3a_textbox);
        
        JLabel sconto_fascia3_label = new JLabel("Sconto:");
        sconto_fascia3_label.setFont(new Font("Courier", Font.PLAIN, 15));
        sconto_fascia3_label.setBounds(420, 150, 100, 20);
        window.add(sconto_fascia3_label);

        JTextArea sconto_fascia3_textbox = new JTextArea();
        sconto_fascia3_textbox.setBounds(480, 150, 100, 30);
        window.add(sconto_fascia3_textbox);
        
        
        JLabel fascia4da_label = new JLabel("Fascia 4 maggiore di: ");
        fascia4da_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fascia4da_label.setBounds(10, 200, 300, 20);
        window.add(fascia4da_label);

        JTextArea fascia4da_textbox = new JTextArea();
        fascia4da_textbox.setBounds(170, 200, 100, 30);
        window.add(fascia4da_textbox);
        
        JLabel sconto_fascia4_label = new JLabel("Sconto:");
        sconto_fascia4_label.setFont(new Font("Courier", Font.PLAIN, 15));
        sconto_fascia4_label.setBounds(420, 200, 100, 20);
        window.add(sconto_fascia4_label);

        JTextArea sconto_fascia4_textbox = new JTextArea();
        sconto_fascia4_textbox.setBounds(480, 200, 100, 30);
        window.add(sconto_fascia4_textbox);
        
        JButton applica_button = new JButton("Applica");
        applica_button.setBounds(10, 250, 670, 40);
        applica_button.setVisible(true);
		window.add(applica_button);
        
        window.setLayout(null);
        window.setVisible(true);
        
        
        applica_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<Articolo> articoli = articoliDaDb();
            	int pr1f1 = Integer.parseInt(fascia1da_textbox.getText());
            	int pr2f1 = Integer.parseInt(fascia1a_textbox.getText());
            	int sconto1 = Integer.parseInt(sconto_fascia1_textbox.getText());
            	updateSconti(articoli, pr1f1, pr2f1, sconto1);
            	int pr1f2 = Integer.parseInt(fascia2da_textbox.getText());
            	int pr2f2 = Integer.parseInt(fascia2a_textbox.getText());
            	int sconto2 = Integer.parseInt(sconto_fascia2_textbox.getText());
            	updateSconti(articoli, pr1f2, pr2f2, sconto2);
            	int pr1f3 = Integer.parseInt(fascia3da_textbox.getText());
            	int pr2f3 = Integer.parseInt(fascia3a_textbox.getText());
            	int sconto3 = Integer.parseInt(sconto_fascia3_textbox.getText());
            	updateSconti(articoli, pr1f3, pr2f3, sconto3);
            	int pr1f4 = Integer.parseInt(fascia4da_textbox.getText());
            	int sconto4 = Integer.parseInt(sconto_fascia4_textbox.getText());
            	updateScontiMaggiore(articoli, pr1f4, sconto4);
            }
            
		});
	}
	
	public static void updateSconti(ArrayList<Articolo> articoli, int pr1, int pr2, int sconto){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	try {
    		for(int i = 0; i < articoli.size(); i++) {
    			st = con.prepareStatement("UPDATE sys.articoli SET sc_1 = ? WHERE pr_unit BETWEEN ? AND ?;");
                st.setInt(1, sconto);
                st.setInt(2, pr1);
                st.setInt(3, pr2);
                st.executeUpdate();
    		}
    		
        } catch (SQLException ex) {
        	ex.printStackTrace();

        } finally {
            try {
               
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
 
	public static void updateScontiMaggiore(ArrayList<Articolo> articoli, int pr1, int sconto){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	try {
    		for(int i = 0; i < articoli.size(); i++) {
    			st = con.prepareStatement("UPDATE sys.articoli SET sc_1 = ? WHERE pr_unit > ?;");
                st.setInt(1, sconto);
                st.setInt(2, pr1);
                st.executeUpdate();
    		}
    		
        } catch (SQLException ex) {
        	ex.printStackTrace();

        } finally {
            try {
               
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
	public static ArrayList<Articolo> articoliDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Articolo> articoli = new ArrayList<Articolo>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.articoli ORDER BY barcode ASC;");                 
            System.out.println("query eseguita articoli da db");
            while (rs.next()) {
            	Articolo articolo = new Articolo();
            	
            	articolo.setBarcode(rs.getString("barcode"));
            	articolo.setFornitore(rs.getString("cfor"));
            	articolo.setCod_for(rs.getLong("codfor"));
            	articolo.setGiacenza(rs.getInt("giacenza")); 
            	articolo.setDescrizione(rs.getString("descrizione"));
            	articolo.setPeso(rs.getDouble("peso"));
            	articolo.setCaratura(rs.getDouble("caratura"));
            	articolo.setPr_unit(rs.getInt("pr_unit"));
            	articolo.setTot_giac(rs.getInt("tot_giacenza"));
            	articolo.setSconto1(rs.getInt("sc_1"));
            	articolo.setSconto2(rs.getInt("sc_2")); 
            	articolo.setCosto(rs.getDouble("costo")); 
            	articolo.setFv(rs.getString("fv"));
            	articoli.add(articolo);
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
		return articoli;
		
    }
}
