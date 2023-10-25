import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
    public CostiPulitura() {
    	JFrame window = new JFrame();
		window.setSize(1250, 700);
		window.setTitle("Costi Pulitura e Trattamento");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);

        JLabel listinoCostoPulituraLabel = new JLabel("Listino Costo Pulitura e Trattamento");
        listinoCostoPulituraLabel.setFont(new Font("", Font.BOLD, 20));
        listinoCostoPulituraLabel.setBounds(10, 10, 400, 30);
        listinoCostoPulituraLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(listinoCostoPulituraLabel);

        JLabel descrizione_label = new JLabel("Descrizione");
        descrizione_label.setFont(new Font("", Font.PLAIN, 15));
        descrizione_label.setBounds(10, 50, 100, 20);
        descrizione_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(descrizione_label);

        JTextField descrizione_textbox = new JTextField();
        descrizione_textbox.setBounds(10, 70, 150, 40);
        descrizione_textbox.setFont(new Font("", Font.PLAIN, 20));
        descrizione_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(descrizione_textbox);
        
        JLabel pulitura_label = new JLabel("Pulitura");
        pulitura_label.setFont(new Font("", Font.PLAIN, 15));
        pulitura_label.setBounds(170, 50, 50, 20);
        pulitura_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(pulitura_label);

        JTextField pulitura_textbox = new JTextField();
        pulitura_textbox.setBounds(170, 70, 150, 40);
        pulitura_textbox.setFont(new Font("", Font.PLAIN, 20));
        pulitura_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(pulitura_textbox);
        
        JLabel trattamento_label = new JLabel("Trattamento");
        trattamento_label.setFont(new Font("", Font.PLAIN, 15));
        trattamento_label.setBounds(330, 50, 100, 20);
        trattamento_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(trattamento_label);

        JTextField trattamento_textbox = new JTextField();
        trattamento_textbox.setBounds(330, 70, 150, 40);
        trattamento_textbox.setFont(new Font("", Font.PLAIN, 20));
        trattamento_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(trattamento_textbox);
        
        JButton inserisci_costo_button = new JButton("Inserisci costo");
        inserisci_costo_button.setBounds(490, 70, 130, 40);
        inserisci_costo_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(inserisci_costo_button);

        JButton elimina_costo_button = new JButton("Elimina costo");
        elimina_costo_button.setBounds(630, 70, 130, 40);
        elimina_costo_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(elimina_costo_button);

        JTextField aumento_pulitura_textbox = new JTextField();
        aumento_pulitura_textbox.setBounds(10, 120, 150, 40);
        aumento_pulitura_textbox.setFont(new Font("", Font.PLAIN, 20));
        aumento_pulitura_textbox.setBackground(new java.awt.Color(156, 191, 171));
        labelSfondo.add(aumento_pulitura_textbox);
        
        JButton aumento_pulitura_button = new JButton("Aumento pulitura");
        aumento_pulitura_button.setBounds(170, 120, 150, 40);
        aumento_pulitura_button.setBackground(new java.awt.Color(0, 255, 255));
        labelSfondo.add(aumento_pulitura_button);
        
        JTextField aumento_trattamento_textbox = new JTextField();
        aumento_trattamento_textbox.setBounds(330, 120, 150, 40);
        aumento_trattamento_textbox.setFont(new Font("", Font.PLAIN, 20));
        aumento_trattamento_textbox.setBackground(new java.awt.Color(156, 191, 171));
        labelSfondo.add(aumento_trattamento_textbox);
        
        JButton aumento_trattamento_button = new JButton("Aumento trattamento");
        aumento_trattamento_button.setBounds(490, 120, 170, 40);
        aumento_trattamento_button.setBackground(new java.awt.Color(0, 255, 255));
        labelSfondo.add(aumento_trattamento_button);
        
        JButton ordine_codice_button = new JButton("Ordine per codice");
        ordine_codice_button.setBounds(1000, 10, 150, 40);
        ordine_codice_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(ordine_codice_button);
        
        JButton ordine_naturale_button = new JButton("Ordine naturale");
        ordine_naturale_button.setBounds(1000, 60, 150, 40);
        ordine_naturale_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(ordine_naturale_button);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(1000, 110, 150, 40);
        stampa_button.setBackground(new java.awt.Color(46, 255, 171));
        labelSfondo.add(stampa_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 170, 1140, 450);

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
    	
    	aumento_pulitura_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int aumento = Integer.parseInt(aumento_pulitura_textbox.getText());
            	
            	
            	modificaPulituraDb(costiPulitura, aumento);
               	
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
            	
            	
            	modificaTrattamentoDb(costiPulitura, aumento);
               	
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
    
    public static void modificaPulituraDb(ArrayList<CostoPulitura> costiPulitura, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	try {
	    	 for(int i = 0; i < costiPulitura.size(); i++) {
	 			
	 			double vendita = costiPulitura.get(i).getPulitura();
	 	    	double perc = vendita;
	 	    	double oper = (((perc/100)* aumento )+perc);
	 	    	oper = Math.ceil(oper);
	 			st = con.prepareStatement("UPDATE sys.costi_pulitura SET pulitura = ? WHERE codice = ?;");
	             st.setDouble(1, oper);
	             st.setString(2, costiPulitura.get(i).getCodice());
	             st.executeUpdate();
	 		}
 		
         
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
    
    public static void modificaTrattamentoDb(ArrayList<CostoPulitura> costiPulitura, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	try {
            for(int i = 0; i < costiPulitura.size(); i++) {
    			
    			double vendita = costiPulitura.get(i).getTrattamento();
    	    	double perc = vendita;
    	    	double oper = (((perc/100)* aumento )+perc);
    	    	oper = Math.ceil(oper);
    			st = con.prepareStatement("UPDATE sys.costi_pulitura SET trattamento = ? WHERE codice = ?;");
                st.setDouble(1, oper);
                st.setString(2, costiPulitura.get(i).getCodice());
                st.executeUpdate();
    		}
    		
            
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