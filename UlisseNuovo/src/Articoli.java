import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Classi.Database;
import Classi.RecuperoCategorie;
import Oggetti.Articolo;



public class Articoli {
    public static void main(String[] args) {
    	
        JFrame window = new JFrame();
        window.setSize(1230, 800);
        window.setTitle("Articoli");
        window.setResizable(false);

        JLabel gestione_articoli_label = new JLabel("Gestione Articoli");
        gestione_articoli_label.setFont(new Font("Courier", Font.PLAIN, 15));
        gestione_articoli_label.setBounds(10, 15, 200, 30);
        window.add(gestione_articoli_label);

        JButton aumento_prezzi_button = new JButton("Aumento Prezzi");
        aumento_prezzi_button.setBounds(190, 10, 150, 40);
        window.add(aumento_prezzi_button);

        JButton modifica_sconto1_button = new JButton("Modifica sconto 1");
        modifica_sconto1_button.setBounds(345, 10, 150, 40);
        window.add(modifica_sconto1_button);

        JButton modifica_sconto2_button = new JButton("Modifica sconto 2");
        modifica_sconto2_button.setBounds(500, 10, 150, 40);
        window.add(modifica_sconto2_button);

        JButton sconto_fascia_button = new JButton("Sconto Fascia");
        sconto_fascia_button.setBounds(655, 10, 120, 40);
        window.add(sconto_fascia_button);

        JButton artxforn_button = new JButton("Art. X Forn");
        artxforn_button.setBounds(780, 10, 100, 40);
        window.add(artxforn_button);

        JButton prima_riga_button = new JButton("");
        prima_riga_button.setBounds(885, 10, 40, 40);
        window.add(prima_riga_button);

        JButton ultima_riga_button = new JButton("");
        ultima_riga_button.setBounds(925, 10, 40, 40);
        window.add(ultima_riga_button);

        JButton trova_riga_button = new JButton("");
        trova_riga_button.setBounds(965, 10, 40, 40);
        window.add(trova_riga_button);

        JButton filtra_rowset_button = new JButton("");
        filtra_rowset_button.setBounds(1005, 10, 40, 40);
        window.add(filtra_rowset_button);

        JButton abbandona_button = new JButton("");
        abbandona_button.setBounds(1045, 10, 40, 40);
        window.add(abbandona_button);

        JButton tabella_categorie_button = new JButton("Tabella Categorie");
        tabella_categorie_button.setBounds(10, 60, 150, 40);
        window.add(tabella_categorie_button);

        JButton refresh_categorie_button = new JButton("Refresh Categorie");
        refresh_categorie_button.setBounds(170, 60, 150, 40);
        window.add(refresh_categorie_button);

        JButton tabella_fornitori_button = new JButton("Tabella Fornitori");
        tabella_fornitori_button.setBounds(330, 60, 150, 40);
        window.add(tabella_fornitori_button);

        JButton converti_VF_button = new JButton("Converti V/F");
        converti_VF_button.setBounds(490, 60, 150, 40);
        window.add(converti_VF_button);

        JCheckBox vedi_costo_button = new JCheckBox("Vedi Costo");
        vedi_costo_button.setBounds(855, 60, 150, 40);
        window.add(vedi_costo_button);
        
        ArrayList<String> risultatoCategorie = categorieStr();
        String[] categorie_values = new String[risultatoCategorie.size()];
        categorie_values = risultatoCategorie.toArray(categorie_values);
        JComboBox<String> categorie_combobox = new JComboBox<>(categorie_values);
        categorie_combobox.setBounds(10, 110, 150, 40);
        window.add(categorie_combobox);

        JLabel codice_calcolato_label = new JLabel("Codice Calcolato");
        codice_calcolato_label.setFont(new Font("Courier", Font.PLAIN, 15));
        codice_calcolato_label.setBounds(220, 90, 150, 40);
        window.add(codice_calcolato_label);
        
        int cliccatoPk = categorie_combobox.getSelectedIndex();
        ArrayList<Integer> risultatoPkCategorie = pkCategorie();
        JLabel codice_calcolato_textbox = new JLabel();
        codice_calcolato_textbox.setFont(new Font("Courier", Font.PLAIN, 15));
        codice_calcolato_textbox.setBounds(200, 120, 150, 30);
       
        window.add(codice_calcolato_textbox);

        ArrayList<String> risultatoFornitori = fornitoriStr();
        String[] fornitori_values = new String[risultatoFornitori.size()];
        fornitori_values = risultatoFornitori.toArray(fornitori_values);
        JComboBox<String> fornitori_combobox = new JComboBox<>(fornitori_values);
        fornitori_combobox.setBounds(360, 110, 150, 40);
        window.add(fornitori_combobox);

        
        JLabel cod_for_label = new JLabel("Cod.For");
        cod_for_label.setFont(new Font("Courier", Font.PLAIN, 15));
        cod_for_label.setBounds(570, 100, 100, 20);
        window.add(cod_for_label);

        int cliccatoFornitore = fornitori_combobox.getSelectedIndex();
        ArrayList<Integer> risultatoIdFornitore = fornitoriId();
        JLabel cod_for_textbox = new JLabel();
        cod_for_textbox.setFont(new Font("Courier", Font.PLAIN, 15));
        cod_for_textbox.setBounds(520, 120, 160, 30);
        cod_for_textbox.setText(risultatoIdFornitore.get(cliccatoFornitore).toString());
        window.add(cod_for_textbox);

        JLabel descrizione_label = new JLabel("Descrizione");
        descrizione_label.setFont(new Font("Courier", Font.PLAIN, 15));
        descrizione_label.setBounds(715, 100, 100, 20);
        window.add(descrizione_label);

        JTextArea descrizione_textbox = new JTextArea();
        descrizione_textbox.setBounds(712, 120, 370, 30);
        window.add(descrizione_textbox);

        JLabel peso_label = new JLabel("Peso");
        peso_label.setFont(new Font("Courier", Font.PLAIN, 15));
        peso_label.setBounds(240, 170, 100, 20);
        window.add(peso_label);

        JTextArea peso_textbox = new JTextArea();
        peso_textbox.setBounds(240, 190, 100, 40);
        window.add(peso_textbox);

        JLabel caratura_label = new JLabel("Caratura");
        caratura_label.setFont(new Font("Courier", Font.PLAIN, 15));
        caratura_label.setBounds(350, 170, 100, 20);
        window.add(caratura_label);

        JTextArea caratura_textbox = new JTextArea();
        caratura_textbox.setBounds(350, 190, 100, 40);
        window.add(caratura_textbox);

        JLabel costo_label = new JLabel("Costo");
        costo_label.setFont(new Font("Courier", Font.PLAIN, 15));
        costo_label.setBounds(460, 170, 100, 20);
        window.add(costo_label);
        
        JTextArea costo_textbox = new JTextArea();
        costo_textbox.setBounds(460, 190, 100, 40);
        window.add(costo_textbox);

        JLabel prezzo_label = new JLabel("Prezzo");
        prezzo_label.setFont(new Font("Courier", Font.PLAIN, 15));
        prezzo_label.setBounds(570, 170, 100, 20);
        window.add(prezzo_label);

        JTextArea prezzo_textbox = new JTextArea();
        prezzo_textbox.setBounds(570, 190, 100, 40);
        window.add(prezzo_textbox);

        JLabel sconto1_label = new JLabel("Sconto 1");
        sconto1_label.setFont(new Font("Courier", Font.PLAIN, 15));
        sconto1_label.setBounds(680, 170, 100, 20);
        window.add(sconto1_label);

        JTextArea sconto1_textbox = new JTextArea();
        sconto1_textbox.setBounds(680, 190, 100, 40);
        window.add(sconto1_textbox);

        JLabel sconto2_label = new JLabel("Sconto 2");
        sconto2_label.setFont(new Font("Courier", Font.PLAIN, 15));
        sconto2_label.setBounds(790, 170, 100, 20);
        window.add(sconto2_label);

        JTextArea sconto2_textbox = new JTextArea();
        sconto2_textbox.setBounds(790, 190, 100, 40);
        window.add(sconto2_textbox);

        JLabel fv_label = new JLabel("F-V");
        fv_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fv_label.setBounds(900, 170, 100, 20);
        window.add(fv_label);

        JTextArea fv_textbox = new JTextArea();
        fv_textbox.setBounds(900, 190, 100, 40);
        window.add(fv_textbox);

        JButton inserisci_codice_button = new JButton("Inserisci articolo");
        inserisci_codice_button.setBounds(10, 250, 130, 40);
        window.add(inserisci_codice_button);
     

        JButton elimina_articolo_button = new JButton("Elimina articolo");
        elimina_articolo_button.setBounds(150, 250, 130, 40);
        window.add(elimina_articolo_button);
        

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 290, 1000, 280);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1000, 280);

        String[] columnNames = {"Barcode", "For", "Cod_For", "Giacenza", "Descrizione", "Peso",
                "Caratura", "Pr_unit", "Tot_Giac", "Sc.1", "Sc.2", "Costo", "F/V"};
        
        

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        table.getColumnModel().getColumn(11).setMinWidth(0);
        table.getColumnModel().getColumn(11).setMaxWidth(0);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        
        ArrayList<Articolo> articoli = articoliDaDb();
    	System.out.println("Articoli:" + articoli);
    	for(int i=0; i < articoli.size(); i++) {
    		model.addRow(new Object[] {articoli.get(i).getBarcode(), articoli.get(i).getFornitore(), articoli.get(i).getCod_for(), 
    				articoli.get(i).getGiacenza(), articoli.get(i).getDescrizione(), articoli.get(i).getPeso(), articoli.get(i).getCaratura(), 
        			articoli.get(i).getPr_unit(), articoli.get(i).getTot_giac(), articoli.get(i).getSconto1(), articoli.get(i).getSconto2(),
        			articoli.get(i).getCosto(), articoli.get(i).getFv()});
    	}
    	
        
        inserisci_codice_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 int result = categoriaPresente(risultatoPkCategorie.get(cliccatoPk).toString());
                 System.out.println("Result: " + result);
                 int barcode = calcoloBarcode(result, risultatoPkCategorie.get(cliccatoPk).toString());
                 codice_calcolato_textbox.setText(String.valueOf(barcode));
            	
            	Articolo articolo = new Articolo(codice_calcolato_textbox.getText(), cod_for_textbox.getText(), 
            			Long.parseLong(cod_for_textbox.getText()), 0, descrizione_textbox.getText(), 
            			Double.parseDouble(peso_textbox.getText()), Double.parseDouble(caratura_textbox.getText()), 
            			Integer.parseInt(prezzo_textbox.getText()), 0, 
            			Integer.parseInt(sconto1_textbox.getText()), Integer.parseInt(sconto2_textbox.getText()), 
            			Double.parseDouble(costo_textbox.getText()), fv_textbox.getText(), risultatoPkCategorie.get(cliccatoPk));
          
            	
            	
            	model.addRow(new Object[] {articolo.getBarcode(), articolo.getFornitore(), articolo.getCod_for(), 
            			articolo.getGiacenza(), articolo.getDescrizione(), articolo.getPeso(), articolo.getCaratura(), 
            			articolo.getPr_unit(), articolo.getTot_giac(), articolo.getSconto1(), articolo.getSconto2(),
            			articolo.getCosto(), articolo.getFv(), articolo.getCod_categoria()});
            	System.out.println(articolo.toString());
            	inserisciArticoloDb(articolo);
            	
            	
            	descrizione_textbox.setText(null);
            	peso_textbox.setText(null);
            	caratura_textbox.setText(null);
            	costo_textbox.setText(null);
            	prezzo_textbox.setText(null);
            	sconto1_textbox.setText(null);
            	sconto2_textbox.setText(null);
            	fv_textbox.setText(null);
            }
        });
        
        elimina_articolo_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	System.out.println("Barcode riga da eliminare " + value);
            	model.removeRow(row);
            	eliminaRigaDb(value);
            	
            }
        });
        
        vedi_costo_button.addItemListener((ItemListener) new ItemListener() {
        	public void itemStateChanged(ItemEvent ev) {
          	  Object item = ev.getItem();
          	  if (ev.getStateChange() == ItemEvent.DESELECTED) {
                  table.getColumnModel().getColumn(11).setMinWidth(0);
                  table.getColumnModel().getColumn(11).setMaxWidth(0);
                  table.getColumnModel().getColumn(11).setWidth(0);
                  table.getColumnModel().getColumn(11).setPreferredWidth(0);
                  
          	  } else {
	          	  table.getColumnModel().getColumn(11).setMinWidth(80);
	              table.getColumnModel().getColumn(11).setMaxWidth(80);
	              table.getColumnModel().getColumn(11).setWidth(80);
                  table.getColumnModel().getColumn(11).setPreferredWidth(80);
          	  }
          	}
        });
        
        tabella_categorie_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	new TabellaCategorie();
            	
            	
            }
            });
           
        
        
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    
    
    public static int categoriaPresente(String codiceCategoria) {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            pstmt = con.prepareStatement("SELECT * FROM sys.articoli WHERE cod_categoria = ?;");
            pstmt.setInt(1, Integer.parseInt(codiceCategoria));
            rs = pstmt.executeQuery();
            System.out.println("query eseguita ricerca categoria");
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
    
    
    public static int calcoloBarcode(int result, String codiceCategoria) {
    	Statement st = null;
        ResultSet rs = null;
        int barcode=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT barcode as last_barcode FROM sys.articoli ORDER BY barcode DESC LIMIT 1;");                 
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
    		String newBarcode = codiceCategoria + "0000";
    		barcode = Integer.parseInt(newBarcode);
    	}
    	
		
    	
    	return barcode;
    }
    
    public static ArrayList<Integer> pkCategorie(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Integer> pk = new ArrayList<Integer>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY pk DESC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	int id = rs.getInt("pk"); 
                pk.add(id);
                System.out.println(pk);
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
		return pk;
		
    }
    
    public static ArrayList<String> categorieStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> categorie = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY pk DESC;");               
            System.out.println("query eseguita");
            while (rs.next()) {
                String categoria = rs.getString("categoria"); 
            	categorie.add(categoria);    
            	System.out.println(categorie);
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
		return categorie;
		
    }
    
    public static ArrayList<String> fornitoriStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> fornitori = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.fornitori ORDER BY id DESC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String fornitore = rs.getString("fornitore"); 
            	fornitori.add(fornitore);
                System.out.println(fornitore);
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
		return fornitori;
		
    }
    
    public static ArrayList<Integer> fornitoriId(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Integer> fornitoreId = new ArrayList<Integer>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.fornitori ORDER BY id DESC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	int id = rs.getInt("id"); 
            	fornitoreId.add(id);
                System.out.println(id);
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
		return fornitoreId;
		
    }
    
    public static void inserisciArticoloDb(Articolo articolo) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String barcode = articolo.getBarcode();
    	String cfor = articolo.getFornitore() ;
    	long codfor = articolo.getCod_for();
    	int giacenza = articolo.getGiacenza();
    	String descrizione = articolo.getDescrizione();
    	double peso = articolo.getPeso(); 
    	double caratura = articolo.getCaratura();
    	int pr_unit = articolo.getPr_unit();
    	int tot_giacenza = articolo.getTot_giac();
    	int sc_1 = articolo.getSconto1();
    	int sc_2 = articolo.getSconto2();
    	double costo = articolo.getCosto();
    	String fv = articolo.getFv();
    	int cod_categoria = articolo.getCod_categoria();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.articoli (barcode, cfor, codfor, giacenza, "
    				+ "descrizione, peso, caratura, pr_unit, tot_giacenza, sc_1, sc_2, costo, tot_peso, tot_inv, fv, slot_costi, tot_costo, cod_categoria) VALUE \r\n"
    				+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		pstmt.setString(1, barcode );
    		pstmt.setString(2, cfor);
    		pstmt.setLong(3, codfor);
    		pstmt.setInt(4, giacenza);
    		pstmt.setString(5, descrizione);
    		pstmt.setDouble(6, peso);
    		pstmt.setDouble(7, caratura);
    		pstmt.setInt(8, pr_unit);
    		pstmt.setInt(9, 0);
    		pstmt.setInt(10, sc_1);
    		pstmt.setInt(11, sc_2);
    		pstmt.setDouble(12, costo);
    		pstmt.setInt(13, 0);
    		pstmt.setInt(14, 0);
    		pstmt.setString(15, fv);
    		pstmt.setInt(16, 0);
    		pstmt.setInt(17, 0);
    		pstmt.setInt(18, cod_categoria);
    		
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
    
    public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.articoli WHERE barcode = ? ";
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