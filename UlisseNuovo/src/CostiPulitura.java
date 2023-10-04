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

public class CostiPulitura {
    public static void main (String [] args) {
    	JFrame window = new JFrame();
		window.setSize(1250, 700);
		window.setTitle("Costi Pulitura e Trattamento");
		window.setResizable(false);

        JLabel listinoCostoPulituraLabel = new JLabel("Listino Costo Pulitura");
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
        
        JLabel pulitura_label = new JLabel("Pulitura");
        pulitura_label.setFont(new Font("Courier", Font.PLAIN, 10));
        pulitura_label.setBounds(170, 50, 50, 20);
        window.add(pulitura_label);

        JTextArea pulitura_textbox = new JTextArea();
        pulitura_textbox.setBounds(170, 70, 150, 40);
        window.add(pulitura_textbox);
        
        JLabel trattamento_label = new JLabel("Trattamento");
        trattamento_label.setFont(new Font("Courier", Font.PLAIN, 10));
        trattamento_label.setBounds(330, 50, 100, 20);
        window.add(trattamento_label);

        JTextArea trattamento_textbox = new JTextArea();
        trattamento_textbox.setBounds(330, 70, 150, 40);
        window.add(trattamento_textbox);
        
        JButton inserisci_costo_button = new JButton("Inserisci costo");
        inserisci_costo_button.setBounds(490, 70, 130, 40);
        window.add(inserisci_costo_button);

        JButton elimina_costo_button = new JButton("Elimina costo");
        elimina_costo_button.setBounds(630, 70, 130, 40);
        window.add(elimina_costo_button);

        JTextArea aumento_pulitura_textbox = new JTextArea();
        aumento_pulitura_textbox.setBounds(10, 120, 150, 40);
        window.add(aumento_pulitura_textbox);
        
        JButton aumento_pulitura_button = new JButton("Aumento pulitura");
        aumento_pulitura_button.setBounds(170, 120, 150, 40);
        window.add(aumento_pulitura_button);
        
        JTextArea aumento_trattamento_textbox = new JTextArea();
        aumento_trattamento_textbox.setBounds(330, 120, 150, 40);
        window.add(aumento_trattamento_textbox);
        
        JButton aumento_trattamento_button = new JButton("Aumento trattamento");
        aumento_trattamento_button.setBounds(490, 120, 170, 40);
        window.add(aumento_trattamento_button);
        
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
    	
    	aumento_pulitura_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int aumento = Integer.parseInt(aumento_pulitura_textbox.getText());
            	
            	for(int i=0; i < costiPulitura.size(); i++) {
            		modificaPulituraDb(costiPulitura.get(i), aumento);
               	}
               	model.setRowCount(0);
                ArrayList<CostoPulitura> costiPulitura = costiPulituraDaDb();
                  	
                for(int j=0; j < costiPulitura.size(); j++) {
                	model.addRow(new Object[] {costiPulitura.get(j).getCodice(), costiPulitura.get(j).getDescrizione(), costiPulitura.get(j).getPulitura(), 
            				costiPulitura.get(j).getTrattamento()});
               	}
                   
                aumento_pulitura_textbox.setText(null);
            }
    	});
    	
    	aumento_trattamento_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int aumento = Integer.parseInt(aumento_trattamento_textbox.getText());
            	
            	for(int i=0; i < costiPulitura.size(); i++) {
            		modificaTrattamentoDb(costiPulitura.get(i), aumento);
               	}
               	model.setRowCount(0);
                ArrayList<CostoPulitura> costiPulitura = costiPulituraDaDb();
                  	
                for(int j=0; j < costiPulitura.size(); j++) {
                	model.addRow(new Object[] {costiPulitura.get(j).getCodice(), costiPulitura.get(j).getDescrizione(), costiPulitura.get(j).getPulitura(), 
            				costiPulitura.get(j).getTrattamento()});
               	}
                   
                aumento_trattamento_textbox.setText(null);
            }
    	});
    	
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
            	int result = costiPulituraPresente();
                System.out.println("Result: " + result);
                int codice = calcoloCodice(result);
           	
                CostoPulitura costoPulitura = new CostoPulitura(String.valueOf(codice), descrizione_textbox.getText(), Double.parseDouble(pulitura_textbox.getText()), Double.parseDouble(trattamento_textbox.getText()));
	         
	           	
	           	
	           	model.addRow(new Object[] {costoPulitura.getCodice(), costoPulitura.getDescrizione(), costoPulitura.getPulitura(), 
	           			costoPulitura.getTrattamento()});
	           	inserisciCostoPulituraDb(costoPulitura);
	           	
	           	descrizione_textbox.setText(null);
	           	pulitura_textbox.setText(null);
	           	trattamento_textbox.setText(null);
            }
    	});
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    public static int costiPulituraPresente() {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            pstmt = con.prepareStatement("SELECT * FROM sys.costi_pulitura;");
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
                rs = st.executeQuery("SELECT codice as last_codice FROM sys.costi_pulitura ORDER BY codice DESC LIMIT 1;");                 
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
    		String newCodice = "90000";
    		codice = Integer.parseInt(newCodice);
    	}
    	
		
    	
    	return codice;
    }
    
    public static void inserisciCostoPulituraDb(CostoPulitura costoPulitura) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String codice = costoPulitura.getCodice();
    	String descrizione = costoPulitura.getDescrizione() ;
    	double pulitura = costoPulitura.getPulitura();
    	double trattamento = costoPulitura.getTrattamento();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.costi_pulitura (codice, descrizione, pulitura, trattamento) VALUE (?,?,?,?)");
    		pstmt.setString(1, codice );
    		pstmt.setString(2, descrizione);
    		pstmt.setDouble(3, pulitura);
    		pstmt.setDouble(4, trattamento);
    		
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
            	costoPulitura.setPulitura(rs.getDouble("pulitura"));
            	costoPulitura.setTrattamento(rs.getDouble("trattamento")); 
            	
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
            	costoPulitura.setPulitura(rs.getDouble("pulitura"));
            	costoPulitura.setTrattamento(rs.getDouble("trattamento")); 
            	
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
    
    public static void modificaPulituraDb(CostoPulitura costoPulitura, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	double pulitura = costoPulitura.getPulitura();
    	double perc = pulitura;
    	double oper = (((perc/100)* aumento )+perc);
    	System.out.println("oper: " + oper);
    	
    	try {
            st = con.prepareStatement("UPDATE sys.costi_pulitura SET pulitura = ?;");
            st.setDouble(1, oper);
            st.executeUpdate();
            con.close();
            
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
    
    public static void modificaTrattamentoDb(CostoPulitura costoPulitura, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	double pulitura = costoPulitura.getTrattamento();
    	double perc = pulitura;
    	double oper = (((perc/100)* aumento )+perc);
    	System.out.println("oper: " + oper);
    	
    	try {
            st = con.prepareStatement("UPDATE sys.costi_pulitura SET trattamento = ?;");
            st.setDouble(1, oper);
            st.executeUpdate();
            con.close();
            
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
    
    public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.costi_pulitura WHERE codice = ? ";
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