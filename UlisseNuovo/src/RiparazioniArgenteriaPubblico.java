import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Classi.ReportRiparazioniArgenteriaNegozi;
import Classi.ReportRiparazioniArgenteriaPubblico;
import Oggetti.Articolo;
import Oggetti.CostoPulitura;
import net.sf.jasperreports.engine.JRException;

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
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
    public RiparazioniArgenteriaPubblico() {
    	JFrame window = new JFrame();
		window.setSize(1220, 680);
		window.setTitle("Riparazioni Argenteria Pubblico");
		window.setResizable(false);

		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	    
        JLabel listinoCostoPulituraLabel = new JLabel("Listino Prezzi al Pubblico Riparazioni Argenteria");
        listinoCostoPulituraLabel.setFont(new Font("", Font.BOLD, 20));
        listinoCostoPulituraLabel.setBounds(10, 10, 500, 30);
        listinoCostoPulituraLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(listinoCostoPulituraLabel);
        
        JButton ordine_codice_button = new JButton("Ordine per codice");
        ordine_codice_button.setBounds(10, 50, 150, 40);
        ordine_codice_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(ordine_codice_button);
        
        JButton ordine_naturale_button = new JButton("Ordine naturale");
        ordine_naturale_button.setBounds(170, 50, 150, 40);
        ordine_naturale_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(ordine_naturale_button);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(330, 50, 150, 40);
        stampa_button.setBackground(new java.awt.Color(0, 255, 255));
        labelSfondo.add(stampa_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 110, 1140, 450);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1140, 450);

        String[] columnNames = {"Codice", "Descrizione", "Pulitura", "Trattamento"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        

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
    	
    	stampa_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ReportRiparazioniArgenteriaPubblico r = new ReportRiparazioniArgenteriaPubblico();
            	try {
					r.generaReport();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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