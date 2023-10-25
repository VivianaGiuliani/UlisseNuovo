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
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;

public class Inventario {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
	public Inventario() {
		window = new JFrame();
		window.setSize(1250, 750);
		window.setTitle("Distinte");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	    
	    JLabel inventario_label = new JLabel("Inventario");
	    inventario_label.setFont(new Font("", Font.PLAIN, 30));
	    inventario_label.setBounds(10, 15, 400, 40);
	    inventario_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(inventario_label);
        
        JLabel codice_scalato_label = new JLabel("Codice Scalato:");
        codice_scalato_label.setFont(new Font("", Font.PLAIN, 20));
        codice_scalato_label.setBounds(10, 55, 220, 40);
        codice_scalato_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(codice_scalato_label);
        
        JTextArea codice_scalato_textbox = new JTextArea();
        codice_scalato_textbox.setFont(new Font("", Font.PLAIN, 20));
        codice_scalato_textbox.setBounds(160, 60, 150, 30);
        codice_scalato_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(codice_scalato_textbox);
        
        JButton genera_inventario_button = new JButton("Genera Inventario");
        genera_inventario_button.setBounds(400, 50, 200, 40);
        genera_inventario_button.setVisible(true);
        genera_inventario_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(genera_inventario_button);
        
		JButton elimina_inventario_button = new JButton("Elimina Inventario");
		elimina_inventario_button.setBounds(610, 50, 200, 40);
		elimina_inventario_button.setVisible(true);
		elimina_inventario_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(elimina_inventario_button);
		
		JButton resoconto_inventario_button = new JButton("Resoconto Inventario");
		resoconto_inventario_button.setBounds(820, 50, 200, 40);
		resoconto_inventario_button.setVisible(true);
		resoconto_inventario_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(resoconto_inventario_button);
		
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 100, 1200, 600);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1200, 600);

        String[] columnNames = {"Barcode", "For", "Cod_For", "Giacenza", "Descrizione", "Peso",
                "Caratura", "Pr_unit", "Tot_Giac", "Sc.1", "Sc.2", "Costo", "F/V"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        table.getColumnModel().getColumn(11).setMinWidth(0);
        table.getColumnModel().getColumn(11).setMaxWidth(0);
        
        table.getColumnModel().getColumn(4).setPreferredWidth(250);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(9).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(10).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(11).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(12).setCellRenderer(rightRenderer);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        
        genera_inventario_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	eliminaInventario();
            	ArrayList<Articolo> copiaA = articoliDaDb();
                inserisciArticoliDb(copiaA);
                ArrayList<Articolo> copia = inventarioDaDb();
                for(int i=0; i < copia.size(); i++) {
            		model.addRow(new Object[] {copia.get(i).getBarcode(), copia.get(i).getCfor(), copia.get(i).getCod_for(), 
            				copia.get(i).getGiacenza(), copia.get(i).getDescrizione(), copia.get(i).getPeso(), copia.get(i).getCaratura(), 
            				copia.get(i).getPr_unit(), copia.get(i).getTot_giac(), copia.get(i).getSconto1(), copia.get(i).getSconto2(),
            				copia.get(i).getCosto(), copia.get(i).getFv()});
            	}
            }
        });
        
        
        elimina_inventario_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	eliminaInventario();
            	model.setRowCount(0);
            }
        });
        
        
        codice_scalato_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				  ArrayList<Articolo> copiaI = inventarioDaDb();
				  if (evt.getKeyCode() == evt.VK_TAB) {
					  Articolo click = new Articolo();
					  for(int i = 0; i < copiaI.size(); i++) {
						  if(copiaI.get(i).getBarcode().equals(codice_scalato_textbox.getText().substring(0,7).replaceAll("\\s", ""))) {
							  click = copiaI.get(i);
						  }
					  }
					  System.out.println("CLick: " + codice_scalato_textbox.getText().substring(0,7).replaceAll("\\s", ""));
					  quantitaDopoClick(click);
					  model.setRowCount(0);
					  ArrayList<Articolo> copia = inventarioDaDb();
					  for(int i=0; i < copia.size(); i++) {
		            		model.addRow(new Object[] {copia.get(i).getBarcode(), copia.get(i).getCfor(), copia.get(i).getCod_for(), 
		            				copia.get(i).getGiacenza(), copia.get(i).getDescrizione(), copia.get(i).getPeso(), copia.get(i).getCaratura(), 
		            				copia.get(i).getPr_unit(), copia.get(i).getTot_giac(), copia.get(i).getSconto1(), copia.get(i).getSconto2(),
		            				copia.get(i).getCosto(), copia.get(i).getFv()});
		            	}
				  }
			  }
        });
        
        resoconto_inventario_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {	
            	 ArrayList<Articolo> resoconto = inventarioResoconto();
            	 model.setRowCount(0);
            	 for(int i=0; i < resoconto.size(); i++) {
	            		model.addRow(new Object[] {resoconto.get(i).getBarcode(), resoconto.get(i).getCfor(), resoconto.get(i).getCod_for(), 
	            				resoconto.get(i).getGiacenza(), resoconto.get(i).getDescrizione(), resoconto.get(i).getPeso(), resoconto.get(i).getCaratura(), 
	            				resoconto.get(i).getPr_unit(), resoconto.get(i).getTot_giac(), resoconto.get(i).getSconto1(), resoconto.get(i).getSconto2(),
	            				resoconto.get(i).getCosto(), resoconto.get(i).getFv()});
	            	}
            }
        });
        
        window.setLayout(null);
        window.setVisible(true);
	}
	
	public static void eliminaInventario() {
    	String SQL = "DELETE FROM sys.inventario";
    	PreparedStatement pstmt = null;

    	Connection con  = Database.connect();

    	
    	try {
    		pstmt = con.prepareStatement(SQL); 
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
            	articolo.setCfor(rs.getString("cfor"));
            	articolo.setCod_for(rs.getString("codfor"));
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
	
	public static ArrayList<Articolo> inventarioDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Articolo> inventario = new ArrayList<Articolo>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.inventario ORDER BY barcode ASC;");                 
            System.out.println("query eseguita inventario da db");
            while (rs.next()) {
            	Articolo articolo = new Articolo();
            	
            	articolo.setBarcode(rs.getString("barcode"));
            	articolo.setCfor(rs.getString("cfor"));
            	articolo.setCod_for(rs.getString("codfor"));
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
            	inventario.add(articolo);
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
		return inventario;
		
    }
	
	public static ArrayList<Articolo> inventarioResoconto(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Articolo> inventario = new ArrayList<Articolo>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.inventario WHERE giacenza != 0 ORDER BY barcode ASC;");                 
            System.out.println("query eseguita inventario da db");
            while (rs.next()) {
            	Articolo articolo = new Articolo();
            	
            	articolo.setBarcode(rs.getString("barcode"));
            	articolo.setCfor(rs.getString("cfor"));
            	articolo.setCod_for(rs.getString("codfor"));
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
            	inventario.add(articolo);
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
		return inventario;
		
    }
	
	
	public static void inserisciArticoliDb(ArrayList<Articolo> copia) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	try { 
    		for(int i = 0; i < copia.size(); i++) {
    			PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.inventario (barcode, cfor, codfor, giacenza, "
        				+ "descrizione, peso, caratura, pr_unit, tot_giacenza, sc_1, sc_2, costo, tot_peso, tot_inv, fv, slot_costi, tot_costo, cod_categoria) VALUE \r\n"
        				+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        		pstmt.setString(1, copia.get(i).getBarcode());
        		pstmt.setString(2, copia.get(i).getCfor());
        		pstmt.setString(3, copia.get(i).getCod_for());
        		pstmt.setInt(4, copia.get(i).getGiacenza());
        		pstmt.setString(5, copia.get(i).getDescrizione());
        		pstmt.setDouble(6, copia.get(i).getPeso());
        		pstmt.setDouble(7, copia.get(i).getCaratura());
        		pstmt.setDouble(8, copia.get(i).getPr_unit());
        		pstmt.setInt(9, copia.get(i).getTot_giac());
        		pstmt.setInt(10, copia.get(i).getSconto1());
        		pstmt.setInt(11, copia.get(i).getSconto2());
        		pstmt.setDouble(12, copia.get(i).getCosto());
        		pstmt.setInt(13, (int) (copia.get(i).getPeso()*copia.get(i).getGiacenza()));
        		pstmt.setInt(14, 0);
        		pstmt.setString(15, copia.get(i).getFv());
        		pstmt.setInt(16, 0);
        		pstmt.setDouble(17, copia.get(i).getPr_unit()*copia.get(i).getGiacenza());
        		pstmt.setInt(18, copia.get(i).getCod_categoria());
        		
        		pstmt.executeUpdate(); 
    		}
    		
            
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
	
	public static void quantitaDopoClick(Articolo copia){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	try {
    			st = con.prepareStatement("UPDATE sys.inventario SET giacenza = ? WHERE barcode = ?;");
	            int giacenza = copia.getGiacenza() - 1;
	            System.out.println("Giacenza " + giacenza);
	            st.setInt(1, giacenza);
	            st.setString(2, copia.getBarcode());
	            st.executeUpdate();
    		
            
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
