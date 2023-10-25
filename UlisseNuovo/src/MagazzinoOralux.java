import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import Classi.ReportListinoOralux;
import Classi.ReportMagazzinoOralux;
import Oggetti.Oralux;
import net.sf.jasperreports.engine.JRException;

public class MagazzinoOralux {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	
	public MagazzinoOralux() {
		window = new JFrame();
		window.setSize(1250, 750);
		window.setTitle("Magazzino Oralux");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	    
	    
	    JLabel magazzino_oralux_label = new JLabel("Magazzino Oralux");
	    magazzino_oralux_label.setFont(new Font("Courier", Font.PLAIN, 30));
	    magazzino_oralux_label.setBounds(10, 10, 400, 40);
	    magazzino_oralux_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(magazzino_oralux_label);
        
       
		JButton calcolo_totale_button = new JButton("Calcolo Totale");
		calcolo_totale_button.setBounds(10, 70, 150, 40);
		calcolo_totale_button.setVisible(true);
		calcolo_totale_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(calcolo_totale_button);
		
		JTextArea calcolo_totale_textbox = new JTextArea();
		calcolo_totale_textbox.setBounds(170, 70, 150, 40);
		calcolo_totale_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
		calcolo_totale_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(calcolo_totale_textbox);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(350, 70, 100, 40);
        stampa_button.setVisible(true);
        stampa_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(stampa_button);
        
        JPanel tablePanel = new JPanel();
	    tablePanel.setLayout(null);
	    tablePanel.setBounds(10, 140, 1200, 500);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 0, 1200, 600);

	    String[] columnNames = {"Quantità", "Barcode", "Cod_art", "Nome"};
	        
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    
	    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
       
	    
	    scrollPane.setViewportView(table);
	    tablePanel.add(scrollPane);
	    labelSfondo.add(tablePanel);
	    
	    ArrayList<Oralux> oraluxi = oraluxDaDb();
    	for(int i=0; i < oraluxi.size(); i++) {
    		model.addRow(new Object[] {oraluxi.get(i).getQuantita(), oraluxi.get(i).getBarcode(), oraluxi.get(i).getCod_art(), oraluxi.get(i).getNome()});
    	}
    	
    	
    	
    	calcolo_totale_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totale = 0.0;
				for(int i = 0; i < oraluxi.size(); i++) {
					totale = totale + (oraluxi.get(i).getQuantita() * oraluxi.get(i).getVendita());
				}
				calcolo_totale_textbox.setText(String.valueOf(totale));
			}
    	});
    	
    	stampa_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportMagazzinoOralux r = new ReportMagazzinoOralux();
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
}
