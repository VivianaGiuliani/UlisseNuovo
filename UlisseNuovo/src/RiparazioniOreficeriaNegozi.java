import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;
import Oggetti.CostoPulitura;
import Oggetti.RiparazioniOreficeria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RiparazioniOreficeriaNegozi {
    public static void main (String [] args) {
    	JFrame window = new JFrame();
		window.setSize(1250, 700);
		window.setTitle("Riparazioni oreficeria negozi");
		window.setResizable(false);

        JLabel listinoCostoPulituraLabel = new JLabel("Listino Riparazioni Oreficeria Privati");
        listinoCostoPulituraLabel.setFont(new Font("Courier", Font.BOLD, 20));
        listinoCostoPulituraLabel.setBounds(30, 10, 300, 30);
        window.add(listinoCostoPulituraLabel);

        JLabel descrizione_label = new JLabel("Descrizione");
        descrizione_label.setFont(new Font("Courier", Font.PLAIN, 10));
        descrizione_label.setBounds(10, 50, 100, 20);
        window.add(descrizione_label);

        JTextArea descrizione_textbox = new JTextArea();
        descrizione_textbox.setBounds(10, 70, 150, 40);
        window.add(descrizione_textbox);
        
        JLabel prezzo_label = new JLabel("Prezzo");
        prezzo_label.setFont(new Font("Courier", Font.PLAIN, 10));
        prezzo_label.setBounds(170, 50, 50, 20);
        window.add(prezzo_label);

        JTextArea prezzo_textbox = new JTextArea();
        prezzo_textbox.setBounds(170, 70, 150, 40);
        window.add(prezzo_textbox);
        
        JButton inserisci_costo_button = new JButton("Inserisci costo");
        inserisci_costo_button.setBounds(490, 70, 130, 40);
        window.add(inserisci_costo_button);

        JButton elimina_costo_button = new JButton("Elimina costo");
        elimina_costo_button.setBounds(630, 70, 130, 40);
        window.add(elimina_costo_button);
        
        JButton ordine_codice_button = new JButton("Ordine per codice");
        ordine_codice_button.setBounds(1000, 10, 150, 40);
        window.add(ordine_codice_button);
        
        JButton ordine_naturale_button = new JButton("Ordine naturale");
        ordine_naturale_button.setBounds(1000, 60, 150, 40);
        window.add(ordine_naturale_button);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(1000, 110, 150, 40);
        window.add(stampa_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 170, 1140, 450);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1140, 450);

        String[] columnNames = {"Codice", "Descrizione", "Prezzo"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        

        ArrayList<RiparazioniOreficeria> riparazioniOreficeria = riparazioniOreficeriaDaDb();
    	
    	for(int i=0; i < riparazioniOreficeria.size(); i++) {
    		model.addRow(new Object[] {riparazioniOreficeria.get(i).getCodice(), riparazioniOreficeria.get(i).getDescrizione(), riparazioniOreficeria.get(i).getPrezzo()});
    	}
    	
    	ordine_codice_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<RiparazioniOreficeria> riparazioniOreficeria = riparazioniOreficeriaDaDb();
            	model.setRowCount(0);
            	for(int i=0; i < riparazioniOreficeria.size(); i++) {
            		model.addRow(new Object[] {riparazioniOreficeria.get(i).getCodice(), riparazioniOreficeria.get(i).getDescrizione(), riparazioniOreficeria.get(i).getPrezzo()});
            	}
            }
    	});
    	
    	ordine_naturale_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<RiparazioniOreficeria> riparazioniOreficeria = riparazioniOreficeriaAlfabeticoDaDb();
            	model.setRowCount(0);
            	for(int i=0; i < riparazioniOreficeria.size(); i++) {
            		model.addRow(new Object[] {riparazioniOreficeria.get(i).getCodice(), riparazioniOreficeria.get(i).getDescrizione(), riparazioniOreficeria.get(i).getPrezzo()});
            	}
            }
    	});
    	
    	elimina_costo_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	System.out.println("codice riga da eliminare " + value);
            	model.removeRow(row);
            	eliminaRigaDb(value);
            }
    	});
    	
    	inserisci_costo_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int result = riparazioniOreficeriaPresente();
                System.out.println("Result: " + result);
                int codice = calcoloCodice(result);
           	
                RiparazioniOreficeria riparazioneOreficeria = new RiparazioniOreficeria(String.valueOf(codice), descrizione_textbox.getText(), Double.parseDouble(prezzo_textbox.getText()));

	           	model.addRow(new Object[] {riparazioneOreficeria.getCodice(), riparazioneOreficeria.getDescrizione(), riparazioneOreficeria.getPrezzo()});
	           	inserisciRiparazioniOreficeriaDb(riparazioneOreficeria);
	           	
	           	descrizione_textbox.setText(null);
	           	prezzo_textbox.setText(null);
            }
    	});
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    public static int riparazioniOreficeriaPresente() {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            pstmt = con.prepareStatement("SELECT * FROM sys.riparazioni_oreficeria;");
            rs = pstmt.executeQuery();
            System.out.println("query eseguita ricerca codice");
            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
                result = 0;
            }else {
            	result = 1;
            }
            
            
            
        } catch (SQLException ex) {
        	ex.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
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
		
    	
    	return result;
    }
    
    
    public static int calcoloCodice(int result) {
    	Statement st = null;
        ResultSet rs = null;
        int codice=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT codice as last_codice FROM sys.riparazioni_oreficeria ORDER BY codice DESC LIMIT 1;");                 
                System.out.println("query eseguita barcode");
                while (rs.next()) {
                	codice = rs.getInt("last_codice");
                	System.out.println("Barcode arrivato: " +codice);
                	codice = codice + 1;
                	System.out.println("Barcode modificato: " +codice);
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
    	}else {
    		String newCodice = "80000";
    		codice = Integer.parseInt(newCodice);
    	}
    	
		
    	
    	return codice;
    }
    
    public static void inserisciRiparazioniOreficeriaDb(RiparazioniOreficeria riparazioneOreficeria) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String codice = riparazioneOreficeria.getCodice();
    	String descrizione = riparazioneOreficeria.getDescrizione() ;
    	double prezzo = riparazioneOreficeria.getPrezzo();
    	
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.riparazioni_oreficeria (codice, descrizione, prezzo) VALUE (?,?,?)");
    		pstmt.setString(1, codice );
    		pstmt.setString(2, descrizione);
    		pstmt.setDouble(3, prezzo);
    		
    		pstmt.executeUpdate(); 
            
            con.close(); 
        }  catch (SQLException ex) {
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
    
    public static ArrayList<RiparazioniOreficeria> riparazioniOreficeriaDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<RiparazioniOreficeria> riparazioniOreficeria = new ArrayList<RiparazioniOreficeria>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.riparazioni_oreficeria ORDER BY codice ASC;");                 
            
            while (rs.next()) {
            	RiparazioniOreficeria riparazioneOreficeria = new RiparazioniOreficeria();
            	
            	riparazioneOreficeria.setCodice(rs.getString("codice"));
            	riparazioneOreficeria.setDescrizione(rs.getString("descrizione"));
            	riparazioneOreficeria.setPrezzo(rs.getDouble("prezzo")); 
            	
            	riparazioniOreficeria.add(riparazioneOreficeria);
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
		return riparazioniOreficeria;
		
    }
    
    public static ArrayList<RiparazioniOreficeria> riparazioniOreficeriaAlfabeticoDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<RiparazioniOreficeria> riparazioniOreficeria = new ArrayList<RiparazioniOreficeria>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.riparazioni_oreficeria ORDER BY descrizione ASC;");                 
            
            while (rs.next()) {
            	RiparazioniOreficeria riparazioneOreficeria = new RiparazioniOreficeria();
            	
            	riparazioneOreficeria.setCodice(rs.getString("codice"));
            	riparazioneOreficeria.setDescrizione(rs.getString("descrizione"));
            	riparazioneOreficeria.setPrezzo(rs.getDouble("prezzo"));
            	
            	riparazioniOreficeria.add(riparazioneOreficeria);
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
		return riparazioniOreficeria;
		
    }
    
    
    
    
    public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.riparazioni_oreficeria WHERE codice = ? ";
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