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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;

public class ArtXForn {
	public ArtXForn(){
		JFrame window = new JFrame();
        window.setSize(1050, 700);
        window.setTitle("Articoli x Fornitori");
        window.setResizable(false);
        
        JLabel artxforn_label = new JLabel("Articoli x Fornitori");
        artxforn_label.setFont(new Font("Courier", Font.PLAIN, 20));
        artxforn_label.setBounds(10, 10, 300, 20);
        window.add(artxforn_label);
        
        ArrayList<String> risultatoFornitori = fornitoriStr();
        String[] fornitori_values = new String[risultatoFornitori.size()];
        fornitori_values = risultatoFornitori.toArray(fornitori_values);
        JComboBox<String> fornitori_combobox = new JComboBox<>(fornitori_values);
        fornitori_combobox.setBounds(10, 50, 150, 40);
        window.add(fornitori_combobox);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 120, 1000, 500);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1000, 500);

        String[] columnNames = {"Cod_For", "Barcode", "For",  "Giacenza", "Descrizione", "Peso",
                "Caratura", "Pr_unit", "Tot_Giac", "Sc.1", "Sc.2", "Costo", "F/V"};


        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        
        JButton cerca_button = new JButton("Cerca");
        cerca_button.setBounds(200, 10, 150, 40);
        window.add(cerca_button);
        
        cerca_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	String sel = (String) fornitori_combobox.getSelectedItem();
            	ArrayList<Articolo> articoli = articoliDaDb(sel);
            	for(int i=0; i < articoli.size(); i++) {
            		model.addRow(new Object[] {articoli.get(i).getCod_for(), articoli.get(i).getBarcode(), articoli.get(i).getFornitore(),  
            				articoli.get(i).getGiacenza(), articoli.get(i).getDescrizione(), articoli.get(i).getPeso(), articoli.get(i).getCaratura(), 
                			articoli.get(i).getPr_unit(), articoli.get(i).getTot_giac(), articoli.get(i).getSconto1(), articoli.get(i).getSconto2(),
                			articoli.get(i).getCosto(), articoli.get(i).getFv()});
            	}
            }
        });
        
        window.setLayout(null);
        window.setVisible(true);
	}
	
	public static ArrayList<Articolo> articoliDaDb(String sel){
    	Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	ArrayList<Articolo> articoli = new ArrayList<Articolo>(); 
    	
    	try { 
            pstmt = con.prepareStatement("SELECT * FROM sys.articoli WHERE cfor = ? ORDER BY codfor ASC;");

            pstmt.setString(1, sel);
            rs = pstmt.executeQuery();
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
            	articolo.setCod_categoria(rs.getInt("cod_categoria"));
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
                if(pstmt != null) {
                	pstmt.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return articoli;
		
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
            	String fornitore = rs.getString("id"); 
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
}
