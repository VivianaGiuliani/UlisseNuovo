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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Classi.ReportListinoOralux;
import Classi.ReportOrdini;
import Oggetti.Articolo;
import Oggetti.Oralux;
import Oggetti.Ordine;
import net.sf.jasperreports.engine.JRException;

public class ListinoOralux {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	
	public ListinoOralux() {
		window = new JFrame();
		window.setSize(1250, 750);
		window.setTitle("Listino Oralux");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	    
	    
	    JLabel listino_oralux_label = new JLabel("Listino Oralux");
	    listino_oralux_label.setFont(new Font("", Font.PLAIN, 30));
	    listino_oralux_label.setBounds(10, 10, 400, 40);
	    listino_oralux_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(listino_oralux_label);
        
        JLabel barcode_label = new JLabel("Barcode");
        barcode_label.setFont(new Font("", Font.PLAIN, 15));
        barcode_label.setForeground(new java.awt.Color(255,255,255));
        barcode_label.setBounds(10, 50, 100, 20);
        labelSfondo.add(barcode_label);

        JTextField barcode_textbox = new JTextField();
        barcode_textbox.setBounds(10, 70, 150, 40);
        barcode_textbox.setFont(new Font("", Font.PLAIN, 20));
        barcode_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(barcode_textbox);
        
        JLabel cod_art_label = new JLabel("Codice articolo");
        cod_art_label.setFont(new Font("", Font.PLAIN, 15));
        cod_art_label.setForeground(new java.awt.Color(255,255,255));
        cod_art_label.setBounds(170, 50, 100, 20);
        labelSfondo.add(cod_art_label);

        JTextField cod_art_textbox = new JTextField();
        cod_art_textbox.setBounds(170, 70, 150, 40);
        cod_art_textbox.setFont(new Font("", Font.PLAIN, 20));
        cod_art_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cod_art_textbox);

        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("", Font.PLAIN, 15));
        nome_label.setForeground(new java.awt.Color(255,255,255));
        nome_label.setBounds(330, 50, 100, 20);
        labelSfondo.add(nome_label);

        JTextField nome_textbox = new JTextField();
        nome_textbox.setBounds(330, 70, 450, 40);
        nome_textbox.setFont(new Font("", Font.PLAIN, 20));
        nome_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(nome_textbox);
        
        JLabel vendita_label = new JLabel("Vendita");
        vendita_label.setFont(new Font("", Font.PLAIN, 15));
        vendita_label.setForeground(new java.awt.Color(255,255,255));
        vendita_label.setBounds(790, 50, 100, 20);
        labelSfondo.add(vendita_label);

        JTextField vendita_textbox = new JTextField();
        vendita_textbox.setBounds(790, 70, 100, 40);
        vendita_textbox.setFont(new Font("", Font.PLAIN, 20));
        vendita_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(vendita_textbox);
        
        JLabel quantita_label = new JLabel("Quantità");
        quantita_label.setFont(new Font("", Font.PLAIN, 15));
        quantita_label.setForeground(new java.awt.Color(255,255,255));
        quantita_label.setBounds(900, 50, 100, 20);
        labelSfondo.add(quantita_label);

        JTextField quantita_textbox = new JTextField();
        quantita_textbox.setBounds(900, 70, 100, 40);
        quantita_textbox.setFont(new Font("", Font.PLAIN, 20));
        quantita_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(quantita_textbox);
        
        JButton inserisci_riga_button = new JButton("Inserisci riga");
        inserisci_riga_button.setBounds(1010, 70, 150, 40);
        inserisci_riga_button.setVisible(true);
        inserisci_riga_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(inserisci_riga_button);
		
		JButton elimina_riga_button = new JButton("Elimina riga");
		elimina_riga_button.setBounds(10, 140, 150, 40);
		elimina_riga_button.setVisible(true);
		elimina_riga_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(elimina_riga_button);
		
		JButton stampa_button = new JButton("Stampa");
		stampa_button.setBounds(170, 140, 150, 40);
		stampa_button.setVisible(true);
		stampa_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(stampa_button);
		
		JButton aumento_listino_button = new JButton("Aumento listino");
		aumento_listino_button.setBounds(330, 140, 150, 40);
		aumento_listino_button.setVisible(true);
		aumento_listino_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(aumento_listino_button);
		
		JTextField aumento_listino_textbox = new JTextField();
		aumento_listino_textbox.setBounds(490, 140, 100, 40);
		aumento_listino_textbox.setFont(new Font("", Font.PLAIN, 20));
		aumento_listino_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(aumento_listino_textbox);
        
        JPanel tablePanel = new JPanel();
	    tablePanel.setLayout(null);
	    tablePanel.setBounds(10, 190, 1200, 500);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 0, 1200, 600);

	    String[] columnNames = {"Barcode", "Codice Articolo", "Nome", "Vendita"};
	        
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
	    scrollPane.setViewportView(table);
	    tablePanel.add(scrollPane);
	    labelSfondo.add(tablePanel);
	    
	    int result = oraluxPresenti();
	    barcode_textbox.setText(String.valueOf(calcoloBarcode(result)));
	    
	    ArrayList<Oralux> oraluxi = oraluxDaDb();
    	for(int i=0; i < oraluxi.size(); i++) {
    		model.addRow(new Object[] {oraluxi.get(i).getBarcode(), oraluxi.get(i).getCod_art(), oraluxi.get(i).getNome(), 
    				oraluxi.get(i).getVendita()});
    	}
	    
	    inserisci_riga_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oralux oralux = new Oralux();
				oralux.setBarcode(barcode_textbox.getText());
				oralux.setCod_art(cod_art_textbox.getText());
				oralux.setNome(nome_textbox.getText());
				oralux.setVendita(Double.parseDouble(vendita_textbox.getText()));
				oralux.setQuantita(Integer.parseInt(quantita_textbox.getText()));
				
				inserisciArticoloOralux(oralux);
				
				barcode_textbox.setText(null);
				cod_art_textbox.setText(null);
				nome_textbox.setText(null);
				vendita_textbox.setText(null);
				quantita_textbox.setText(null);
				int result = oraluxPresenti();
			    barcode_textbox.setText(String.valueOf(calcoloBarcode(result)));
				
			    model.setRowCount(0);
			    ArrayList<Oralux> oraluxi = oraluxDaDb();
		    	for(int i=0; i < oraluxi.size(); i++) {
		    		model.addRow(new Object[] {oraluxi.get(i).getBarcode(), oraluxi.get(i).getCod_art(), oraluxi.get(i).getNome(), 
		    				oraluxi.get(i).getVendita()});
		    	}
			}
	    });
	    
	    elimina_riga_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
            	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	System.out.println("barcode riga da eliminare " + value);
            	model.removeRow(row);
            	eliminaRigaDb(value);
            	
            	model.setRowCount(0);
			    ArrayList<Oralux> oraluxi = oraluxDaDb();
		    	for(int i=0; i < oraluxi.size(); i++) {
		    		model.addRow(new Object[] {oraluxi.get(i).getBarcode(), oraluxi.get(i).getCod_art(), oraluxi.get(i).getNome(), 
		    				oraluxi.get(i).getVendita()});
		    	}
			}
	    });
	    
	    aumento_listino_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ArrayList<Oralux> oraluxi = oraluxDaDb();
				 int aumento = Integer.parseInt(aumento_listino_textbox.getText());
				 modificaPrezzoDb(oraluxi, aumento);
				 model.setRowCount(0);
				 ArrayList<Oralux> oraluxi2 = oraluxDaDb();
			     for(int i=0; i < oraluxi.size(); i++) {
			    		model.addRow(new Object[] {oraluxi2.get(i).getBarcode(), oraluxi2.get(i).getCod_art(), oraluxi2.get(i).getNome(), 
			    				oraluxi2.get(i).getVendita()});
			     }
			}
	    });
	    
	    stampa_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportListinoOralux r = new ReportListinoOralux();
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
	
	public static ArrayList<Oralux> oraluxDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Oralux> oraluxi = new ArrayList<Oralux>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.oralux ORDER BY barcode ASC;");                 
            System.out.println("query eseguita oralux da db");
            while (rs.next()) {
            	Oralux oralux = new Oralux();
            	
            	oralux.setBarcode(rs.getString("barcode"));
            	oralux.setCod_art(rs.getString("cod_art"));
            	oralux.setNome(rs.getString("nome"));
            	oralux.setVendita(rs.getDouble("vendita")); 
            	oralux.setQuantita(rs.getInt("quantita"));
            	
            	oraluxi.add(oralux);
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
		return oraluxi;
		
    }
	
	public static void inserisciArticoloOralux(Oralux oralux) {
	 	Statement st = null;
	 	PreparedStatement pstmt = null;
		Connection con  = Database.connect();
		String barcode = oralux.getBarcode();
		String cod_art = oralux.getCod_art();
		String nome = oralux.getNome();
		double vendita = oralux.getVendita();
		int quantita = oralux.getQuantita();
		
		try { 
				pstmt = con.prepareStatement("INSERT INTO sys.oralux (barcode, cod_art, nome, vendita, quantita) VALUE \r\n"
						+ "        (?,?,?,?,?)");
				pstmt.setString(1, barcode);
				pstmt.setString(2, cod_art);
				pstmt.setString(3, nome);
				pstmt.setDouble(4, vendita);
				pstmt.setInt(5, quantita);
				
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
	
	public static int oraluxPresenti() {
    	Statement st = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.oralux;");                 
            
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
		
    	
    	return result;
    }
 
	
	public static int calcoloBarcode(int result) {
    	Statement st = null;
        ResultSet rs = null;
        int barcode=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT barcode as last_barcode FROM sys.oralux ORDER BY barcode DESC LIMIT 1;");                 
                System.out.println("query eseguita barcode");
                while (rs.next()) {
                	barcode = rs.getInt("last_barcode");
                	System.out.println("Barcode arrivato: " +barcode);
                	barcode = barcode + 1;
                	System.out.println("Barcode modificato: " +barcode);
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
    		String newBarcode = "8001001";
    		barcode = Integer.parseInt(newBarcode);
    	}
    	
		
    	
    	return barcode;
    }
	
	public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.oralux WHERE barcode = ? ;";
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
	
	public static void modificaPrezzoDb(ArrayList<Oralux> oraluxi, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	
    	try {
    		for(int i = 0; i < oraluxi.size(); i++) {
    			
    			double vendita = oraluxi.get(i).getVendita();
    	    	double perc = vendita;
    	    	double oper = (((perc/100)* aumento )+perc);
    	    	oper = Math.ceil(oper);
    			st = con.prepareStatement("UPDATE sys.oralux SET vendita = ? WHERE barcode = ?;");
                st.setDouble(1, oper);
                st.setString(2, oraluxi.get(i).getBarcode());
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
}
