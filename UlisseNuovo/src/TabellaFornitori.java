import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;
import Oggetti.Categoria;
import Oggetti.Fornitore;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class TabellaFornitori{

    public TabellaFornitori(){
    	JFrame window = new JFrame();
        window.setSize(600, 700);
        window.setTitle("Tabella Fornitori");
        window.setResizable(false);
        
        JButton inserisci_fornitore_button = new JButton("Inserisci fornitore");
        inserisci_fornitore_button.setBounds(10, 20, 150, 40);
        window.add(inserisci_fornitore_button);
     

        JButton elimina_fornitore_button = new JButton("Elimina fornitore");
        elimina_fornitore_button.setBounds(170, 20, 150, 40);
        window.add(elimina_fornitore_button);
        
        JLabel codice_label = new JLabel("Codice");
        codice_label.setFont(new Font("Courier", Font.PLAIN, 15));
        codice_label.setBounds(10, 70, 100, 20);
        window.add(codice_label);

        JTextArea codice_textbox = new JTextArea();
        codice_textbox.setBounds(10, 95, 100, 30);
        window.add(codice_textbox);
        
        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("Courier", Font.PLAIN, 15));
        nome_label.setBounds(120, 70, 100, 20);
        window.add(nome_label);

        JTextArea nome_textbox = new JTextArea();
        nome_textbox.setBounds(120, 95, 300, 30);
        window.add(nome_textbox);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 140, 570, 500);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 570, 500);

        String[] columnNames = {"Codice", "Nome"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        
        ArrayList<Fornitore> fornitori = fornitoriDaDb();
    	
    	for(int i=0; i < fornitori.size(); i++) {
    		model.addRow(new Object[] {fornitori.get(i).getCodiceFornitore(), fornitori.get(i).getNomeFornitore()});
    	}
        
        window.setLayout(null);
        window.setVisible(true);
        
        inserisci_fornitore_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Fornitore fornitore = new Fornitore(codice_textbox.getText(), nome_textbox.getText());

            	model.addRow(new Object[] {fornitore.getCodiceFornitore(), fornitore.getNomeFornitore()});
            	
            	inserisciFornitoreDb(fornitore);
            	
            }
        });
        
        elimina_fornitore_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	String selezione = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	
            	model.removeRow(row);
            	eliminaRigaDb(selezione);
            	
            }
        });
    	
    }
    
    public static ArrayList<Fornitore> fornitoriDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Fornitore> fornitori = new ArrayList<Fornitore>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.fornitori ORDER BY id ASC;");                 
            System.out.println("query eseguita fornitori da db");
            while (rs.next()) {
            	Fornitore fornitore = new Fornitore();
            	
            	fornitore.setCodiceFornitore(rs.getString("id"));
            	fornitore.setNomeFornitore(rs.getString("fornitore"));
            	fornitori.add(fornitore);
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
    
    public static void inserisciFornitoreDb(Fornitore fornitore) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String codiceFornitore = fornitore.getCodiceFornitore();
    	String nomeFornitore = fornitore.getNomeFornitore();   	
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.fornitori (id, fornitore) VALUE \r\n"
    				+ "        (?,?)");
    		pstmt.setString(1, codiceFornitore);
    		pstmt.setString(2, nomeFornitore);
    		
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

    public static void eliminaRigaDb(String selezione) {
    	String SQL = "DELETE FROM sys.fornitori WHERE id = ? ";
    	PreparedStatement pstmt = null;

    	Connection con  = Database.connect();

    	
    	try {
    		
    		pstmt = con.prepareStatement(SQL); 
    		pstmt.setString(1, selezione);
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
