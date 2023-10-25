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

public class AumentoPrezzi {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
	public AumentoPrezzi() {
		JFrame window = new JFrame();
        window.setSize(800, 900);
        window.setTitle("Aumento prezzi");
        window.setResizable(false);
        
        labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
        
        JLabel aumento_prezzi_label = new JLabel("Aumento prezzi");
        aumento_prezzi_label.setFont(new Font("", Font.PLAIN, 25));
        aumento_prezzi_label.setBounds(10, 15, 200, 30);
        aumento_prezzi_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(aumento_prezzi_label);
        
        
        JLabel categoria_label = new JLabel("Categoria");
        categoria_label.setFont(new Font("", Font.PLAIN, 15));
        categoria_label.setBounds(10, 60, 100, 20);
        categoria_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(categoria_label);

        JTextArea categoria_textbox = new JTextArea();
        categoria_textbox.setBounds(10, 85, 100, 30);
        categoria_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(categoria_textbox);
        
        JLabel aumento_label = new JLabel("Aumento");
        aumento_label.setFont(new Font("", Font.PLAIN, 15));
        aumento_label.setBounds(120, 60, 100, 20);
        aumento_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(aumento_label);

        JTextArea aumento_textbox = new JTextArea();
        aumento_textbox.setBounds(120, 85, 100, 30);
        aumento_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(aumento_textbox);
        
        JButton esegui_button = new JButton("Esegui");
        esegui_button.setBounds(230, 75, 150, 40);
        esegui_button.setBackground(new java.awt.Color(77, 191, 171));
        labelSfondo.add(esegui_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 130, 750, 700);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 750, 700);

        String[] columnNames = {"Tipologia", "Barcode", "Descrizione", "Peso", "Pr_unit"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        
        ArrayList<Articolo> articoli = articoliDaDb();
        for(int i=0; i < articoli.size(); i++) {
    		model.addRow(new Object[] {articoli.get(i).getCod_categoria(), articoli.get(i).getBarcode(), articoli.get(i).getDescrizione(), 
    				articoli.get(i).getPeso(), articoli.get(i).getPr_unit()});
    	}
        
        
       
        esegui_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int categoria = Integer.parseInt(categoria_textbox.getText());
            	int aumento = Integer.parseInt(aumento_textbox.getText());
            	
            	
               	modificaPrezzoDb(articoli, categoria, aumento);
            	
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
            	articolo.setCfor(rs.getString("cfor"));
            	articolo.setCod_for(rs.getString("codfor"));
            	articolo.setGiacenza(rs.getInt("giacenza")); 
            	articolo.setDescrizione(rs.getString("descrizione"));
            	articolo.setPeso(rs.getDouble("peso"));
            	articolo.setCaratura(rs.getDouble("caratura"));
            	articolo.setPr_unit(rs.getDouble("pr_unit"));
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
	public static void modificaPrezzoDb(ArrayList<Articolo>articoli, int categoria, int aumento){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	try {
			for(int i = 0; i < articoli.size(); i++) {
					double vendita = articoli.get(i).getPr_unit();
				 	double perc = vendita;
				 	double oper = (((perc/100)* aumento )+perc);
				 	oper = Math.ceil(oper);
				 	st = con.prepareStatement("UPDATE sys.articoli SET pr_unit = ? WHERE cod_categoria = ? and barcode = ?;");
				    st.setDouble(1, oper);
				    st.setInt(2, categoria);
				    st.setString(3, articoli.get(i).getBarcode());
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
