import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Classi.ReportArticoli;
import Classi.ReportOrdini;
import Classi.ReportScadenze;
import Oggetti.Articolo;
import Oggetti.Oralux;
import Oggetti.Ordine;
import Oggetti.Scadenza;
import net.sf.jasperreports.engine.JRException;

public class Ordini {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	double tot_peso = 0.0;
  	double tot_ordine = 0.0;
	public Ordini() {
		window = new JFrame();
		window.setSize(1250, 750);
		window.setTitle("Ordini");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	    
	    JLabel ordini_label = new JLabel("Ordini");
	    ordini_label.setFont(new Font("", Font.PLAIN, 30));
	    ordini_label.setBounds(10, 10, 400, 40);
	    ordini_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(ordini_label);
	    
	    JLabel n_ordine_label = new JLabel("N° Ordine");
	    n_ordine_label.setFont(new Font("", Font.PLAIN, 15));
	    n_ordine_label.setForeground(new java.awt.Color(255,255,255));
	    n_ordine_label.setBounds(10, 50, 100, 20);
        labelSfondo.add(n_ordine_label);

        JTextArea n_ordine_textbox = new JTextArea();
        n_ordine_textbox.setBounds(10, 70, 150, 40);
        n_ordine_textbox.setFont(new Font("", Font.PLAIN, 20));
        n_ordine_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(n_ordine_textbox);
        
        JLabel data_label = new JLabel("Data");
        data_label.setFont(new Font("", Font.PLAIN, 15));
        data_label.setForeground(new java.awt.Color(255,255,255));
        data_label.setBounds(170, 50, 100, 20);
        labelSfondo.add(data_label);

        JTextArea data_textbox = new JTextArea();
        data_textbox.setBounds(170, 70, 150, 40);
        data_textbox.setFont(new Font("", Font.PLAIN, 20));
        data_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(data_textbox);
        
        JLabel fornitore_label = new JLabel("Fornitore");
        fornitore_label.setFont(new Font("", Font.PLAIN, 15));
        fornitore_label.setForeground(new java.awt.Color(255,255,255));
        fornitore_label.setBounds(330, 50, 100, 20);
        labelSfondo.add(fornitore_label);

        JTextArea fornitore_textbox = new JTextArea();
        fornitore_textbox.setBounds(330, 70, 250, 40);
        fornitore_textbox.setFont(new Font("", Font.PLAIN, 20));
        fornitore_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(fornitore_textbox);
        
		
		JButton inserisci_riga_button = new JButton("Inserisci riga");
		inserisci_riga_button.setBounds(10, 120, 150, 40);
		inserisci_riga_button.setVisible(true);
		inserisci_riga_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(inserisci_riga_button);
		
		JButton elimina_riga_button = new JButton("Elimina riga");
		elimina_riga_button.setBounds(170, 120, 150, 40);
		elimina_riga_button.setVisible(true);
		elimina_riga_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(elimina_riga_button);
		
		JButton aggiorna_button = new JButton("Aggiorna Tabella");
		aggiorna_button.setBounds(330, 120, 150, 40);
		aggiorna_button.setVisible(true);
		aggiorna_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(aggiorna_button);
		
		JButton stampa_button = new JButton("Stampa");
		stampa_button.setBounds(600, 120, 150, 40);
		stampa_button.setVisible(true);
		stampa_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(stampa_button);
		
		JPanel tablePanel = new JPanel();
	    tablePanel.setLayout(null);
	    tablePanel.setBounds(10, 180, 1200, 500);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 0, 1200, 600);

	    String[] columnNames = {"Quantità", "Codice", "Descrizione", "G.Cad", "Tot_peso", "Pr_unit", "Tot_riga"};
	        
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
	    
	    scrollPane.setViewportView(table);
	    tablePanel.add(scrollPane);
	    labelSfondo.add(tablePanel);
	    
	    JLabel totale_peso_label = new JLabel("Totale Peso");
	    totale_peso_label.setFont(new Font("", Font.PLAIN, 15));
	    totale_peso_label.setForeground(new java.awt.Color(255,255,255));
	    totale_peso_label.setBounds(860, 100, 100, 20);
        labelSfondo.add(totale_peso_label);

        JTextArea totale_peso_textbox = new JTextArea();
        totale_peso_textbox.setBounds(860, 120, 150, 40);
        totale_peso_textbox.setFont(new Font("", Font.PLAIN, 20));
        totale_peso_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totale_peso_textbox);
        
        JLabel totale_ordine_label = new JLabel("Totale Ordine €");
        totale_ordine_label.setFont(new Font("", Font.PLAIN, 15));
        totale_ordine_label.setForeground(new java.awt.Color(255,255,255));
        totale_ordine_label.setBounds(1020, 100, 100, 20);
        labelSfondo.add(totale_ordine_label);

        JTextArea totale_ordine_textbox = new JTextArea();
        totale_ordine_textbox.setBounds(1020, 120, 150, 40);
        totale_ordine_textbox.setFont(new Font("", Font.PLAIN, 20));
        totale_ordine_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totale_ordine_textbox);
	    
	    window.setLayout(null);
        window.setVisible(true);
        
        ArrayList<Ordine> ordini = ordiniDaDb();
        model.setRowCount(0);
        for(int i=0; i < ordini.size(); i++) {
    		model.addRow(new Object[] {ordini.get(i).getQuantita(), ordini.get(i).getBarcode(), 
    				ordini.get(i).getDescrizione(), ordini.get(i).getGcad(), ordini.get(i).getTot_peso(),
    				ordini.get(i).getPr_unit(), ordini.get(i).getTot_riga()});
    
    	tot_peso = tot_peso + ordini.get(i).getTot_peso()*ordini.get(i).getQuantita();
    	tot_ordine = tot_ordine + ordini.get(i).getPr_unit()*ordini.get(i).getQuantita();
    }
        
        inserisci_riga_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	InserisciOrdine in = new InserisciOrdine();
            }
        });
        
       	aggiorna_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArrayList<Ordine> ordini = ordiniDaDb();
                model.setRowCount(0);
                for(int i=0; i < ordini.size(); i++) {
            		model.addRow(new Object[] {ordini.get(i).getQuantita(), ordini.get(i).getBarcode(), 
            				ordini.get(i).getDescrizione(), ordini.get(i).getGcad(), ordini.get(i).getTot_peso(),
            				ordini.get(i).getPr_unit(), ordini.get(i).getTot_riga()});
            
            	tot_peso = tot_peso + ordini.get(i).getTot_peso()*ordini.get(i).getQuantita();
            	tot_ordine = tot_ordine + ordini.get(i).getPr_unit()*ordini.get(i).getQuantita();
                }
            }
        });
        
        
        elimina_riga_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	System.out.println("n_ordine riga da eliminare " + value);
            	model.removeRow(row);
            	eliminaRigaDb(value);
            	
            }
        });
        
        n_ordine_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				String n_ordine = n_ordine_textbox.getText();
			  	double tot_peso = 0.0;
			  	double tot_ordine = 0.0;
			    if (evt.getKeyCode() == evt.VK_TAB) {
			    	ArrayList<Ordine> ordini = ordineDaDb(n_ordine);
				    data_textbox.setText(ordini.get(0).getData());
				    fornitore_textbox.setText(ordini.get(0).getCodice_fornitore());
				    model.setRowCount(0);
				    for(int i=0; i < ordini.size(); i++) {
				    		model.addRow(new Object[] {ordini.get(i).getQuantita(), ordini.get(i).getBarcode(), 
		            				ordini.get(i).getDescrizione(), ordini.get(i).getGcad(), ordini.get(i).getTot_peso(),
		            				ordini.get(i).getPr_unit(), ordini.get(i).getTot_riga()});
		            
				    	tot_peso = tot_peso + ordini.get(i).getTot_peso()*ordini.get(i).getQuantita();
				    	tot_ordine = tot_ordine + ordini.get(i).getPr_unit()*ordini.get(i).getQuantita();
				    }
				    totale_peso_textbox.setText(String.valueOf(tot_peso));
				    totale_ordine_textbox.setText(String.valueOf(tot_ordine));
			    }
			  }
			});
        
        stampa_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String n_ordine = n_ordine_textbox.getText();
            	ArrayList<Ordine> ordini = ordineDaDb(n_ordine);
            	for(int i=0; i < ordini.size(); i++) {
            		inserisciPerStampa(ordini.get(i));
            	}
            	
            	ReportOrdini r = new ReportOrdini();
            	try {
					r.generaReport();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	eliminaPerStampa();
            }
		});
	}
	
	public static void inserisciPerStampa(Ordine ordine) {
		Statement st = null;
	 	PreparedStatement pstmt = null;
		Connection con  = Database.connect();
		int n_ordine = ordine.getN_ordine();
		String codice_fornitore = String.valueOf(ordine.getCodice_fornitore());
		String data = String.valueOf(ordine.getData());
		int quantita = ordine.getQuantita();
		String codice = String.valueOf(ordine.getBarcode());
		String descrizione = String.valueOf(ordine.getDescrizione());
		double gcad = ordine.getGcad();
		double tot_peso = ordine.getTot_peso();
		int pr_unit = ordine.getPr_unit();
		int tot_riga = ordine.getTot_riga();
		
		try { 
				pstmt = con.prepareStatement("INSERT INTO sys.ordini_stampa (n_ordine, codice_fornitore, data, quantita, barcode, descrizione, gcad, tot_peso, pr_unit, tot_riga) VALUE \r\n"
						+ "        (?,?,?,?,?,?,?,?,?,?)");
				pstmt.setInt(1, n_ordine);
				pstmt.setString(2, codice_fornitore);
				pstmt.setString(3, data);
				pstmt.setInt(4, quantita);
				pstmt.setString(5, codice);
				pstmt.setString(6, descrizione);
				pstmt.setDouble(7, gcad);
				pstmt.setDouble(8, tot_peso);
				pstmt.setInt(9, pr_unit);
				pstmt.setInt(10, tot_riga);
				
				pstmt.executeUpdate(); 
	        
	    }  catch (SQLException ex) {
	    	ex.printStackTrace();

	    } finally {
	        try {
	            if (pstmt != null) {
	            	pstmt.close();
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
	
	public static void eliminaPerStampa() {
		Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("truncate sys.ordini_stampa;");
    		
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
	
	public static ArrayList<Ordine> ordineDaDb(String n_ordine){
    	Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	ArrayList<Ordine> ordini = new ArrayList<Ordine>();
    	
    	try { 
            pstmt = con.prepareStatement("SELECT * FROM sys.ordini WHERE n_ordine = ?;");

            pstmt.setInt(1,Integer.parseInt(n_ordine));
            rs = pstmt.executeQuery();
            System.out.println("query eseguita ordini da db");
            while (rs.next()) {
            	Ordine ordine = new Ordine(); 
            	ordine.setN_ordine(rs.getInt("n_ordine"));
            	ordine.setCodice_fornitore(rs.getString("codice_fornitore"));
            	ordine.setData(rs.getString("data"));
            	ordine.setQuantita(rs.getInt("quantita"));
            	ordine.setBarcode(rs.getString("barcode"));
            	ordine.setDescrizione(rs.getString("descrizione"));
            	ordine.setGcad(rs.getDouble("gcad"));
            	ordine.setTot_peso(rs.getDouble("tot_peso"));
            	ordine.setPr_unit(rs.getInt("pr_unit"));
            	ordine.setTot_riga(rs.getInt("tot_riga"));
            	ordini.add(ordine);
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
                if(pstmt != null) {
                	pstmt.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return ordini;
		
    }
	
	public static ArrayList<Ordine> ordiniDaDb(){
    	Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	ArrayList<Ordine> ordini = new ArrayList<Ordine>();
    	
    	try { 
            pstmt = con.prepareStatement("SELECT * FROM sys.ordini;");

            rs = pstmt.executeQuery();
            System.out.println("query eseguita ordini da db");
            while (rs.next()) {
            	Ordine ordine = new Ordine(); 
            	ordine.setN_ordine(rs.getInt("n_ordine"));
            	ordine.setCodice_fornitore(rs.getString("codice_fornitore"));
            	ordine.setData(rs.getString("data"));
            	ordine.setQuantita(rs.getInt("quantita"));
            	ordine.setBarcode(rs.getString("barcode"));
            	ordine.setDescrizione(rs.getString("descrizione"));
            	ordine.setGcad(rs.getDouble("gcad"));
            	ordine.setTot_peso(rs.getDouble("tot_peso"));
            	ordine.setPr_unit(rs.getInt("pr_unit"));
            	ordine.setTot_riga(rs.getInt("tot_riga"));
            	ordini.add(ordine);
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
                if(pstmt != null) {
                	pstmt.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return ordini;
		
    }
	
	public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.ordini WHERE barcode = ? ;";
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
