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
import Oggetti.Categoria;

public class TabellaCategorie {
public static void main(String[] args) {
    	
        JFrame window = new JFrame();
        window.setSize(600, 700);
        window.setTitle("Tabella Categorie");
        window.setResizable(false);
        
        JButton inserisci_categoria_button = new JButton("Inserisci categoria");
        inserisci_categoria_button.setBounds(10, 20, 150, 40);
        window.add(inserisci_categoria_button);
     

        JButton elimina_categoria_button = new JButton("Elimina categoria");
        elimina_categoria_button.setBounds(170, 20, 150, 40);
        window.add(elimina_categoria_button);
        
        JLabel tipologia_label = new JLabel("Tipologia");
        tipologia_label.setFont(new Font("Courier", Font.PLAIN, 15));
        tipologia_label.setBounds(10, 70, 100, 20);
        window.add(tipologia_label);

        JTextArea tipologia_textbox = new JTextArea();
        tipologia_textbox.setBounds(10, 95, 100, 30);
        window.add(tipologia_textbox);
        
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

        String[] columnNames = {"Tipologia", "Nome", "Min_Giac"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        
        ArrayList<Categoria> categorie = categorieDaDb();
    	System.out.println("Categorie:" + categorie);
    	for(int i=0; i < categorie.size(); i++) {
    		model.addRow(new Object[] {categorie.get(i).getPk(), categorie.get(i).getCategoria(), categorie.get(i).getMin_giac()});
    	}

    	inserisci_categoria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Categoria categoria = new Categoria(Integer.parseInt(tipologia_textbox.getText()), nome_textbox.getText(), 0);
          
            	
            	
            	model.addRow(new Object[] {categoria.getPk(), categoria.getCategoria(), categoria.getMin_giac()});
            	System.out.println(categoria.toString());
            	
            	inserisciCategoriaDb(categoria);
            	
            }
        });
    	
    	elimina_categoria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	int selezione = (int) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	
            	System.out.println("pk riga da eliminare " + selezione);
            	model.removeRow(row);
            	eliminaRigaDb(selezione);
            	
            }
        });
    	
        window.setLayout(null);
        window.setVisible(true);
	}

public static ArrayList<Categoria> categorieDaDb(){
	Statement st = null;
    ResultSet rs = null;
	Connection con  = Database.connect();
	ArrayList<Categoria> categorie = new ArrayList<Categoria>(); 
	try {
        st = con.createStatement();
        rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY pk ASC;");                 
        System.out.println("query eseguita categorie da db");
        while (rs.next()) {
        	Categoria categoria = new Categoria();
        	categoria.setPk(rs.getInt("pk"));
        	categoria.setCategoria(rs.getString("categoria"));
        	categoria.setMin_giac(rs.getInt("min_giac"));
        	categorie.add(categoria);
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

public static void inserisciCategoriaDb(Categoria categoria) {
	Statement st = null;
    ResultSet rs = null;
	Connection con  = Database.connect();
	
	int pk = categoria.getPk();
	String categoriaNome = categoria.getCategoria();
	int min_giac = categoria.getMin_giac();
	
	
	try { 
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.categoria (pk, categoria, min_giac) VALUE \r\n"
				+ "        (?,?,?)");
		pstmt.setInt(1, pk);
		pstmt.setString(2, categoriaNome);
		pstmt.setInt(3, min_giac);
		
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

public static void eliminaRigaDb(int selezione) {
	String SQL = "DELETE FROM sys.categoria WHERE pk = ? ";
	PreparedStatement pstmt = null;

	Connection con  = Database.connect();

	
	try {
		
		pstmt = con.prepareStatement(SQL); 
		pstmt.setInt(1, selezione);
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