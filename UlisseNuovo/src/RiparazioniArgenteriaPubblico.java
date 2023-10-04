import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;
import Oggetti.CostoPulitura;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RiparazioniArgenteriaPubblico {
    public static void main (String [] args) {
    	JFrame window = new JFrame();
		window.setSize(1220, 680);
		window.setTitle("Riparazioni Argenteria Pubblico");
		window.setResizable(false);

        JLabel listinoCostoPulituraLabel = new JLabel("Listino Prezzi al Pubblico Riparazioni Argenteria");
        listinoCostoPulituraLabel.setFont(new Font("Courier", Font.BOLD, 20));
        listinoCostoPulituraLabel.setBounds(30, 10, 500, 30);
        window.add(listinoCostoPulituraLabel);
        
        JButton ordine_codice_button = new JButton("Ordine per codice");
        ordine_codice_button.setBounds(10, 50, 150, 40);
        window.add(ordine_codice_button);
        
        JButton ordine_naturale_button = new JButton("Ordine naturale");
        ordine_naturale_button.setBounds(170, 50, 150, 40);
        window.add(ordine_naturale_button);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(330, 50, 150, 40);
        window.add(stampa_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 110, 1140, 450);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1140, 450);

        String[] columnNames = {"Codice", "Descrizione", "Pulitura", "Trattamento"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        

        ArrayList<CostoPulitura> costiPulitura = costiPulituraDaDb();
    	
    	for(int i=0; i < costiPulitura.size(); i++) {
    		model.addRow(new Object[] {costiPulitura.get(i).getCodice(), costiPulitura.get(i).getDescrizione(), costiPulitura.get(i).getPulitura(), 
    				costiPulitura.get(i).getTrattamento()});
    	}
    	
    	ordine_codice_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<CostoPulitura> costiPulitura = costiPulituraDaDb();
            	model.setRowCount(0);
            	for(int i=0; i < costiPulitura.size(); i++) {
            		model.addRow(new Object[] {costiPulitura.get(i).getCodice(), costiPulitura.get(i).getDescrizione(), costiPulitura.get(i).getPulitura(), 
            				costiPulitura.get(i).getTrattamento()});
            	}
            }
    	});
    	
    	ordine_naturale_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<CostoPulitura> costiPulitura = costiPulituraAlfabeticoDaDb();
            	model.setRowCount(0);
            	for(int i=0; i < costiPulitura.size(); i++) {
            		model.addRow(new Object[] {costiPulitura.get(i).getCodice(), costiPulitura.get(i).getDescrizione(), costiPulitura.get(i).getPulitura(), 
            				costiPulitura.get(i).getTrattamento()});
            	}
            }
    	});
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    public static ArrayList<CostoPulitura> costiPulituraDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<CostoPulitura> costiPulitura = new ArrayList<CostoPulitura>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.costi_pulitura ORDER BY codice ASC;");                 
            
            while (rs.next()) {
            	CostoPulitura costoPulitura = new CostoPulitura();
            	
            	costoPulitura.setCodice(rs.getString("codice"));
            	costoPulitura.setDescrizione(rs.getString("descrizione"));
            	costoPulitura.setPulitura(Math.floor((rs.getDouble("pulitura")/100)*250));
            	costoPulitura.setTrattamento(Math.floor((rs.getDouble("trattamento")/100)*250)); 
            	
            	costiPulitura.add(costoPulitura);
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
		return costiPulitura;
		
    }
    
    public static ArrayList<CostoPulitura> costiPulituraAlfabeticoDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<CostoPulitura> costiPulitura = new ArrayList<CostoPulitura>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.costi_pulitura ORDER BY descrizione ASC;");                 
            
            while (rs.next()) {
            	CostoPulitura costoPulitura = new CostoPulitura();
            	
            	costoPulitura.setCodice(rs.getString("codice"));
            	costoPulitura.setDescrizione(rs.getString("descrizione"));
            	costoPulitura.setPulitura(Math.floor((rs.getDouble("pulitura")/100)*250));
            	costoPulitura.setTrattamento(Math.floor((rs.getDouble("trattamento")/100)*250)); 
            	
            	costiPulitura.add(costoPulitura);
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
		return costiPulitura;
		
    }
    

}