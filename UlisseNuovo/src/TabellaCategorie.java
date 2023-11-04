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
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Classi.ReportCategorie;
import Classi.ReportRiparazioniArgenteriaPubblico;
import Oggetti.Articolo;
import Oggetti.Categoria;
import net.sf.jasperreports.engine.JRException;

public class TabellaCategorie {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
public TabellaCategorie() {
    	
        window = new JFrame();
        window.setSize(600, 700);
        window.setTitle("Tabella Categorie");
        window.setResizable(false);
        
        labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
        
        JButton inserisci_categoria_button = new JButton("Inserisci categoria");
        inserisci_categoria_button.setBounds(10, 20, 150, 40);
        inserisci_categoria_button.setBackground(new java.awt.Color(132, 249, 58));
        labelSfondo.add(inserisci_categoria_button);
     

        JButton elimina_categoria_button = new JButton("Elimina categoria");
        elimina_categoria_button.setBounds(170, 20, 150, 40);
        elimina_categoria_button.setBackground(new java.awt.Color(132, 249, 58));
        labelSfondo.add(elimina_categoria_button);
        
        JButton stampa_categoria_button = new JButton("Stampa categorie");
        stampa_categoria_button.setBounds(340, 20, 150, 40);
        stampa_categoria_button.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(stampa_categoria_button);
        
        JLabel tipologia_label = new JLabel("Tipologia");
        tipologia_label.setFont(new Font("", Font.PLAIN, 15));
        tipologia_label.setBounds(10, 70, 100, 20);
        tipologia_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(tipologia_label);

        JTextField tipologia_textbox = new JTextField();
        tipologia_textbox.setBounds(10, 95, 100, 30);
        tipologia_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(tipologia_textbox);
        
        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("", Font.PLAIN, 15));
        nome_label.setBounds(120, 70, 100, 20);
        nome_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(nome_label);

        JTextField nome_textbox = new JTextField();
        nome_textbox.setBounds(120, 95, 300, 30);
        nome_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(nome_textbox);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 140, 570, 500);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 570, 500);

        String[] columnNames = {"Tipologia", "Nome"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        
        ArrayList<Categoria> categorie = categorieDaDb();
        ArrayList<Articolo> articoli = articoliDaDb();
    	System.out.println("Categorie:" + categorie);
    	
    	
    	for(int i = 0; i < categorie.size(); i++) {
    		ArrayList<Articolo> articoliCategoria = articoliCategoriaDaDb(categorie.get(i).getPk());
    		int tot_giac = 0;
    		for(int j = 0; j < articoliCategoria.size(); j++) {
    			tot_giac = tot_giac + articoliCategoria.get(j).getGiacenza();
    		}
    		categorie.get(i).setMin_giac(tot_giac);
    		model.addRow(new Object[] {categorie.get(i).getPk(), categorie.get(i).getCategoria(), categorie.get(i).getMin_giac()});
    	}

    	inserisci_categoria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Categoria categoria = new Categoria(Integer.parseInt(tipologia_textbox.getText()), nome_textbox.getText(), 0);

            	model.addRow(new Object[] {categoria.getPk(), categoria.getCategoria(), categoria.getMin_giac()});
            	System.out.println(categoria.toString());
            	
            	inserisciCategoriaDb(categoria);
            	
            	tipologia_textbox.setText(null);
            	nome_textbox.setText(null);
            	
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
    	
    	stampa_categoria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ReportCategorie r = new ReportCategorie();
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

public static ArrayList<Articolo> articoliCategoriaDaDb(int categoria){
	Statement st = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
	Connection con  = Database.connect();
	ArrayList<Articolo> articoli = new ArrayList<Articolo>(); 
	
	try { 
        pstmt = con.prepareStatement("SELECT * FROM sys.articoli WHERE cod_categoria = ?;");

        pstmt.setInt(1, categoria);
        rs = pstmt.executeQuery();
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
