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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;

public class AumentoPrezzi {
	public static void main (String [] args) {
		JFrame window = new JFrame();
        window.setSize(800, 900);
        window.setTitle("Aumento prezzi");
        window.setResizable(false);
        
        JLabel aumento_prezzi_label = new JLabel("Aumento prezzi");
        aumento_prezzi_label.setFont(new Font("Courier", Font.PLAIN, 25));
        aumento_prezzi_label.setBounds(10, 15, 200, 30);
        window.add(aumento_prezzi_label);
        
        
        JLabel categoria_label = new JLabel("Categoria");
        categoria_label.setFont(new Font("Courier", Font.PLAIN, 15));
        categoria_label.setBounds(10, 60, 100, 20);
        window.add(categoria_label);

        JTextArea categoria_textbox = new JTextArea();
        categoria_textbox.setBounds(10, 85, 100, 30);
        window.add(categoria_textbox);
        
        JLabel aumento_label = new JLabel("Aumento");
        aumento_label.setFont(new Font("Courier", Font.PLAIN, 15));
        aumento_label.setBounds(120, 60, 100, 20);
        window.add(aumento_label);

        JTextArea aumento_textbox = new JTextArea();
        aumento_textbox.setBounds(120, 85, 100, 30);
        window.add(aumento_textbox);
        
        JButton esegui_button = new JButton("Esegui");
        esegui_button.setBounds(230, 75, 150, 40);
        window.add(esegui_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 130, 750, 700);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 750, 700);

        String[] columnNames = {"Tipologia", "Barcode", "Descrizione", "Peso", "Pr_unit"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        
        ArrayList<Articolo> articoli = articoliDaDb();
        for(int i=0; i < articoli.size(); i++) {
    		model.addRow(new Object[] {articoli.get(i).getCod_categoria(), articoli.get(i).getBarcode(), articoli.get(i).getDescrizione(), 
    				articoli.get(i).getPeso(), articoli.get(i).getPr_unit()});
    	}
        
        
       
        esegui_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int categoria = Integer.parseInt(categoria_textbox.getText());
            	int aumento = Integer.parseInt(aumento_textbox.getText());
            	
            	for(int i=0; i < articoli.size(); i++) {
               	 modificaPrezzoDb(articoli.get(i), categoria, aumento);
            	}
            	model.setRowCount(0);
               	ArrayList<Articolo> articoli = articoliDaDb();
               	
                for(int j=0; j < articoli.size(); j++) {
            		model.addRow(new Object[] {articoli.get(j).getCod_categoria(), articoli.get(j).getBarcode(), articoli.get(j).getDescrizione(), 
            				articoli.get(j).getPeso(), articoli.get(j).getPr_unit()});
            	}
                
                categoria_textbox.setText(null);
                aumento_textbox.setText(null);
               
            }
        });
        
        window.setLayout(null);
        window.setVisible(true);
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return articoli;
		
    }
	public static void modificaPrezzoDb(Articolo articolo, int categoria, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	int pr_unit = articolo.getPr_unit();
    	System.out.println("pr_unit: " + pr_unit);
    	double perc = pr_unit;
    	double oper = (((perc/100)* aumento )+perc);
    	System.out.println("oper: " + oper);
    	
    	try {
            st = con.prepareStatement("UPDATE sys.articoli SET pr_unit = ? WHERE cod_categoria = ?;");
            st.setDouble(1, oper);
            st.setInt(2, categoria);
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
}
