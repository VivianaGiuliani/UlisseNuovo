import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;
import Oggetti.Cliente;

public class ModificaDatiArticoli {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	public ModificaDatiArticoli() {
		JFrame window = new JFrame();
	    window.setSize(1100, 900);
	    window.setTitle("Modifica Dati Articoli");
	    window.setResizable(false);
	    
	    labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	
	    JLabel cfor_label = new JLabel("Codice Articolo Fornitore");
	    cfor_label.setFont(new Font("", Font.PLAIN, 15));
	    cfor_label.setBounds(10, 20, 300, 20);
	    cfor_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(cfor_label);
	
	    JTextField cfor_textbox = new JTextField();
	    cfor_textbox.setBounds(10, 40, 200, 40);
	    cfor_textbox.setFont(new Font("", Font.PLAIN, 20));
	    cfor_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(cfor_textbox);
	
	    JLabel cod_for_label = new JLabel("Fornitore");
	    cod_for_label.setFont(new Font("", Font.PLAIN, 15));
	    cod_for_label.setBounds(220, 20, 200, 20);
	    cod_for_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(cod_for_label);
	
	    JTextField cod_for_textbox = new JTextField();
	    cod_for_textbox.setBounds(220, 40, 100, 40);
	    cod_for_textbox.setFont(new Font("", Font.PLAIN, 20));
	    cod_for_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(cod_for_textbox);
	
	    JLabel giacenza_label = new JLabel("Giacenza");
	    giacenza_label.setFont(new Font("", Font.PLAIN, 15));
	    giacenza_label.setBounds(330, 20, 150, 20);
	    giacenza_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(giacenza_label);
	
	    JTextField giacenza_textbox = new JTextField();
	    giacenza_textbox.setBounds(330, 40, 150, 40);
	    giacenza_textbox.setFont(new Font("", Font.PLAIN, 20));
	    giacenza_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(giacenza_textbox);
	    
	    JLabel descrizione_label = new JLabel("Descrizione");
	    descrizione_label.setFont(new Font("", Font.PLAIN, 15));
	    descrizione_label.setBounds(10, 80, 100, 20);
	    descrizione_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(descrizione_label);
	
	    JTextField descrizione_textbox = new JTextField();
	    descrizione_textbox.setBounds(10, 100, 200, 40);
	    descrizione_textbox.setFont(new Font("", Font.PLAIN, 20));
	    descrizione_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(descrizione_textbox);
	
	    JLabel peso_label = new JLabel("Peso");
	    peso_label.setFont(new Font("", Font.PLAIN, 15));
	    peso_label.setBounds(220, 80, 100, 20);
	    peso_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(peso_label);
	    
	    JTextField peso_textbox = new JTextField();
	    peso_textbox.setBounds(220, 100, 120, 40);
	    peso_textbox.setFont(new Font("", Font.PLAIN, 20));
	    peso_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(peso_textbox);
	    
	    JLabel caratura_label = new JLabel("Caratura");
	    caratura_label.setFont(new Font("", Font.PLAIN, 15));
	    caratura_label.setBounds(350, 80, 100, 20);
	    caratura_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(caratura_label);
	    
	    JTextField caratura_textbox = new JTextField();
	    caratura_textbox.setBounds(350, 100, 200, 40);
	    caratura_textbox.setFont(new Font("", Font.PLAIN, 20));
	    caratura_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(caratura_textbox);
	    
	    JLabel pr_unit_label = new JLabel("Pr_unit");
	    pr_unit_label.setFont(new Font("", Font.PLAIN, 15));
	    pr_unit_label.setBounds(560, 80, 130, 20);
	    pr_unit_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(pr_unit_label);
	    
	    JTextField pr_unit_textbox = new JTextField();
	    pr_unit_textbox.setBounds(560, 100, 100, 40);
	    pr_unit_textbox.setFont(new Font("", Font.PLAIN, 20));
	    pr_unit_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(pr_unit_textbox);
	    
	    JLabel tot_giac_label = new JLabel("Tot_giac");
	    tot_giac_label.setFont(new Font("", Font.PLAIN, 15));
	    tot_giac_label.setBounds(10, 140, 100, 20);
	    tot_giac_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(tot_giac_label);
	    
	    JTextField tot_giac_textbox = new JTextField();
	    tot_giac_textbox.setBounds(10, 160, 120, 40);
	    tot_giac_textbox.setFont(new Font("", Font.PLAIN, 20));
	    tot_giac_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(tot_giac_textbox);
	    
	    JLabel sconto1_label = new JLabel("Sconto 1");
	    sconto1_label.setFont(new Font("", Font.PLAIN, 15));
	    sconto1_label.setBounds(140, 140, 100, 20);
	    sconto1_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(sconto1_label);
	    
	    JTextField sconto1_textbox = new JTextField();
	    sconto1_textbox.setBounds(140, 160, 120, 40);
	    sconto1_textbox.setFont(new Font("", Font.PLAIN, 20));
	    sconto1_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(sconto1_textbox);
	    
	    JLabel sconto2_label = new JLabel("Sconto 2");
	    sconto2_label.setFont(new Font("", Font.PLAIN, 15));
	    sconto2_label.setBounds(270, 140, 100, 20);
	    sconto2_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(sconto2_label);
	    
	    JTextField sconto2_textbox = new JTextField();
	    sconto2_textbox.setBounds(270, 160, 120, 40);
	    sconto2_textbox.setFont(new Font("", Font.PLAIN, 20));
	    sconto2_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(sconto2_textbox);
	    
	    JLabel costo_label = new JLabel("Costo");
	    costo_label.setFont(new Font("", Font.PLAIN, 15));
	    costo_label.setBounds(400, 140, 100, 20);
	    costo_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(costo_label);
	    
	    JTextField costo_textbox = new JTextField();
	    costo_textbox.setBounds(400, 160, 120, 40);
	    costo_textbox.setFont(new Font("", Font.PLAIN, 20));
	    costo_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(costo_textbox);
	    
	    JLabel fv_label = new JLabel("F/V");
	    fv_label.setFont(new Font("", Font.PLAIN, 15));
	    fv_label.setBounds(530, 140, 100, 20);
	    fv_label.setForeground(new java.awt.Color(255,255,255));
	    labelSfondo.add(fv_label);
	    
	    JTextField fv_textbox = new JTextField();
	    fv_textbox.setBounds(530, 160, 120, 40);
	    fv_textbox.setFont(new Font("", Font.PLAIN, 20));
	    fv_textbox.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(fv_textbox);
	    
	    JPanel tablePanel = new JPanel();
	    tablePanel.setLayout(null);
	    tablePanel.setBounds(10, 210, 1050, 500);
	
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 0, 1050, 500);
	
	    String[] columnNames = {"Barcode", "Cod_art_for", "Cod_For", "Giacenza", "Descrizione", "Peso",
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
	    
	    JLabel inserisci_codice_modifica_label = new JLabel("<html> Inserisci il codice a barre <br /> dell'articolo da modificare</html>");
		inserisci_codice_modifica_label.setFont(new Font("", Font.PLAIN, 15));
		inserisci_codice_modifica_label.setBounds(800, 60, 500, 60);
		inserisci_codice_modifica_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(inserisci_codice_modifica_label);
		
        JTextArea codice_modifica_textbox = new JTextArea();
        codice_modifica_textbox.setBounds(800, 115, 170, 40);
        codice_modifica_textbox.setBackground(new java.awt.Color(203, 203, 146));
        codice_modifica_textbox.setFont(new Font("", Font.PLAIN, 20));
        labelSfondo.add(codice_modifica_textbox);
        
		JButton modifica_button = new JButton("Modifica");
		modifica_button.setBounds(800, 160, 200, 40);
		modifica_button.setVisible(true);
		modifica_button.setBackground(new java.awt.Color(250,255,133));
		labelSfondo.add(modifica_button);
	    
	    window.setLayout(null);
        window.setVisible(true);
        
        codice_modifica_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				  Articolo articolo = articoloDaDb(codice_modifica_textbox.getText().replaceAll("\\s", ""));
				  if (evt.getKeyCode() == evt.VK_TAB) {
					  cfor_textbox.setText(articolo.getCfor());
					  cod_for_textbox.setText(articolo.getCod_for());
					  giacenza_textbox.setText(String.valueOf(articolo.getGiacenza()));
					  descrizione_textbox.setText(articolo.getDescrizione());
					  peso_textbox.setText(String.valueOf(articolo.getPeso()));
					  caratura_textbox.setText(String.valueOf(articolo.getCaratura()));
					  pr_unit_textbox.setText(String.valueOf(articolo.getPr_unit()));
					  tot_giac_textbox.setText(String.valueOf(articolo.getTot_giac()));
					  sconto1_textbox.setText(String.valueOf(articolo.getSconto1()));
					  sconto2_textbox.setText(String.valueOf(articolo.getSconto2()));
					  costo_textbox.setText(String.valueOf(articolo.getCosto()));
					  fv_textbox.setText(articolo.getFv());
					  
					  model.addRow(new Object[] {articolo.getBarcode(), articolo.getCfor(), articolo.getCod_for(), 
		            			articolo.getGiacenza(), articolo.getDescrizione(), articolo.getPeso(), articolo.getCaratura(), 
		            			articolo.getPr_unit(), articolo.getTot_giac(), articolo.getSconto1(), articolo.getSconto2(),
		            			articolo.getCosto(), articolo.getFv()});
					  
				  }
			  }
        });
        
        modifica_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Articolo articolo = new Articolo();
            	articolo.setBarcode(codice_modifica_textbox.getText().replaceAll("\\s", ""));
            	articolo.setCfor(cfor_textbox.getText());
            	articolo.setCod_for(cod_for_textbox.getText());
            	articolo.setGiacenza(Integer.parseInt(giacenza_textbox.getText()));
            	articolo.setDescrizione(descrizione_textbox.getText());
            	articolo.setPeso(Double.parseDouble(peso_textbox.getText()));
            	articolo.setCaratura(Double.parseDouble(caratura_textbox.getText()));
            	articolo.setPr_unit(Double.parseDouble(pr_unit_textbox.getText()));
            	articolo.setTot_giac(Integer.parseInt(tot_giac_textbox.getText()));
            	articolo.setSconto1(Integer.parseInt(sconto1_textbox.getText()));
            	articolo.setSconto2(Integer.parseInt(sconto2_textbox.getText()));
            	articolo.setCosto(Double.parseDouble(costo_textbox.getText()));
            	articolo.setFv(fv_textbox.getText());
            	aggiornaArticolo(articolo);
            	
            	model.setRowCount(0);
            	articolo = articoloDaDb(codice_modifica_textbox.getText().replaceAll("\\s", ""));
            	model.addRow(new Object[] {articolo.getBarcode(), articolo.getCfor(), articolo.getCod_for(), 
            			articolo.getGiacenza(), articolo.getDescrizione(), articolo.getPeso(), articolo.getCaratura(), 
            			articolo.getPr_unit(), articolo.getTot_giac(), articolo.getSconto1(), articolo.getSconto2(),
            			articolo.getCosto(), articolo.getFv()});
            }
        });
	}
	
	public static Articolo articoloDaDb(String barcode){
    	Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	Articolo articolo = new Articolo(); 
    	System.out.println("barcode " + barcode);
    	try { 
            pstmt = con.prepareStatement("SELECT * FROM sys.articoli WHERE barcode = ?;");

            pstmt.setString(1, barcode);
            rs = pstmt.executeQuery();
            System.out.println("query eseguita articoli da db");
            while (rs.next()) {
            	
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
		return articolo;
		
    }
	
	public static void aggiornaArticolo(Articolo articolo){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	String cfor, cod_for, descrizione, fv ;
    	int giacenza, tot_giac, sconto1, sconto2;
    	double peso, caratura, pr_unit, costo;
    	
    	System.out.println("Aggiorna Articolo: " + articolo.toString());    	
    	cfor = articolo.getCfor();
    	cod_for = articolo.getCod_for();
    	descrizione = articolo.getDescrizione();
    	fv = articolo.getFv();
    	giacenza = articolo.getGiacenza();
    	tot_giac = articolo.getTot_giac();
    	sconto1 = articolo.getSconto1();
    	sconto2 = articolo.getSconto2();
    	peso = articolo.getPeso();
    	caratura = articolo.getCaratura();
    	pr_unit = articolo.getPr_unit();
    	costo = articolo.getCosto();
    	
    	try {
    		st = con.prepareStatement("UPDATE sys.articoli SET cfor = ?, codfor = ?, giacenza = ?, descrizione = ?, peso = ?, caratura = ?, pr_unit = ?, tot_giacenza = ?, sc_1 = ?, sc_2= ?, costo = ?, fv = ? WHERE barcode = ?;");
	        st.setString(1, cfor);
	        st.setString(2, cod_for);
	        st.setInt(3, giacenza);
	        st.setString(4, descrizione);
	        st.setDouble(5, peso);
	        st.setDouble(6, caratura);
	        st.setDouble(7, pr_unit);
	        st.setInt(8, tot_giac);
	        st.setInt(9, sconto1);
	        st.setInt(10, sconto2);
	        st.setDouble(11, costo);
	        st.setString(12, fv);
	        st.setString(13, articolo.getBarcode());
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
