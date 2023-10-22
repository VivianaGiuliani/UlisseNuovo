import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Classi.Database;
import Oggetti.Ordine;

public class InserisciOrdine {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
	public InserisciOrdine() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		window = new JFrame();
		window.setSize(900, 270);
		window.setTitle("Inserisci Ordini");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
	    
	    JLabel inserisci_ordine_label = new JLabel("Inserisci Ordine");
	    inserisci_ordine_label.setFont(new Font("Courier", Font.PLAIN, 30));
	    inserisci_ordine_label.setBounds(10, 10, 400, 40);
	    inserisci_ordine_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(inserisci_ordine_label);
        
        JLabel n_ordine_label = new JLabel("N° Ordine");
	    n_ordine_label.setFont(new Font("Courier", Font.PLAIN, 15));
	    n_ordine_label.setForeground(new java.awt.Color(255,255,255));
	    n_ordine_label.setBounds(10, 50, 100, 20);
        labelSfondo.add(n_ordine_label);

        JTextArea n_ordine_textbox = new JTextArea();
        n_ordine_textbox.setBounds(10, 70, 150, 40);
        n_ordine_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        n_ordine_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(n_ordine_textbox);
        
        JLabel data_label = new JLabel("Data");
        data_label.setFont(new Font("Courier", Font.PLAIN, 15));
        data_label.setForeground(new java.awt.Color(255,255,255));
        data_label.setBounds(170, 50, 100, 20);
        labelSfondo.add(data_label);

        JTextArea data_textbox = new JTextArea();
        data_textbox.setBounds(170, 70, 150, 40);
        data_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        data_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(data_textbox);
        
        JLabel fornitore_label = new JLabel("Fornitore");
        fornitore_label.setFont(new Font("Courier", Font.PLAIN, 15));
        fornitore_label.setForeground(new java.awt.Color(255,255,255));
        fornitore_label.setBounds(330, 50, 100, 20);
        labelSfondo.add(fornitore_label);
        
        ArrayList<String> risultatoFornitori = fornitoriStr();
        String[] fornitori_values = new String[risultatoFornitori.size()];
        fornitori_values = risultatoFornitori.toArray(fornitori_values);
        JComboBox<String> fornitori_combobox = new JComboBox<>(fornitori_values);
        fornitori_combobox.setBounds(330, 70, 250, 40);
        labelSfondo.add(fornitori_combobox);
        
        JLabel quantita_label = new JLabel("Quantità");
        quantita_label.setFont(new Font("Courier", Font.PLAIN, 15));
        quantita_label.setForeground(new java.awt.Color(255,255,255));
        quantita_label.setBounds(10, 120, 100, 20);
        labelSfondo.add(quantita_label);

        JTextArea quantita_textbox = new JTextArea();
        quantita_textbox.setBounds(10, 140, 100, 40);
        quantita_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        quantita_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(quantita_textbox);
        
        JLabel codice_label = new JLabel("Codice");
        codice_label.setFont(new Font("Courier", Font.PLAIN, 15));
        codice_label.setForeground(new java.awt.Color(255,255,255));
        codice_label.setBounds(120, 120, 100, 20);
        labelSfondo.add(codice_label);

        JTextArea codice_textbox = new JTextArea();
        codice_textbox.setBounds(120, 140, 100, 40);
        codice_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        codice_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(codice_textbox);
        
        JLabel descrizione_label = new JLabel("Descrizione");
        descrizione_label.setFont(new Font("Courier", Font.PLAIN, 15));
        descrizione_label.setForeground(new java.awt.Color(255,255,255));
        descrizione_label.setBounds(230, 120, 100, 20);
        labelSfondo.add(descrizione_label);

        JTextArea descrizione_textbox = new JTextArea();
        descrizione_textbox.setBounds(230, 140, 250, 40);
        descrizione_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        descrizione_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(descrizione_textbox);
        
        JLabel prezzo_unitario_label = new JLabel("Prezzo unitario");
        prezzo_unitario_label.setFont(new Font("Courier", Font.PLAIN, 15));
        prezzo_unitario_label.setForeground(new java.awt.Color(255,255,255));
        prezzo_unitario_label.setBounds(490, 120, 200, 20);
        labelSfondo.add(prezzo_unitario_label);

        JTextArea prezzo_unitario_textbox = new JTextArea();
        prezzo_unitario_textbox.setBounds(490, 140, 100, 40);
        prezzo_unitario_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        prezzo_unitario_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(prezzo_unitario_textbox);
        
        JLabel peso_label = new JLabel("G.Cad");
        peso_label.setFont(new Font("Courier", Font.PLAIN, 15));
        peso_label.setForeground(new java.awt.Color(255,255,255));
        peso_label.setBounds(600, 120, 200, 20);
        labelSfondo.add(peso_label);

        JTextArea peso_textbox = new JTextArea();
        peso_textbox.setBounds(600, 140, 100, 40);
        peso_textbox.setFont(new Font("Courier", Font.PLAIN, 20));
        peso_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(peso_textbox);
        
        JButton inserisci_riga_button = new JButton("Inserisci riga");
		inserisci_riga_button.setBounds(710, 140, 150, 40);
		inserisci_riga_button.setVisible(true);
		inserisci_riga_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(inserisci_riga_button);
		
		int result = ordiniPresenti();
		System.out.println("Result: " + result);
		int numeroOrdine = calcoloNumeroOrdine(result);
		n_ordine_textbox.setText(String.valueOf(numeroOrdine));
		data_textbox.setText(String.valueOf(dateFormat.format(java.sql.Date.valueOf(java.time.LocalDate.now())))); 
        
		
		inserisci_riga_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	Ordine ordine = new Ordine();
            	int cliccatoFornitore = fornitori_combobox.getSelectedIndex();
            	ordine.setN_ordine(Integer.parseInt(n_ordine_textbox.getText()));
            	ordine.setCodice_fornitore(risultatoFornitori.get(cliccatoFornitore).toString());
            	ordine.setData(data_textbox.getText());
            	ordine.setQuantita(Integer.parseInt(quantita_textbox.getText()));
            	ordine.setBarcode(codice_textbox.getText());
            	ordine.setDescrizione(descrizione_textbox.getText());
            	ordine.setGcad(Double.parseDouble(peso_textbox.getText()));
            	ordine.setTot_peso(Integer.parseInt(quantita_textbox.getText())*Double.parseDouble(peso_textbox.getText()));
            	ordine.setPr_unit(Integer.parseInt(prezzo_unitario_textbox.getText()));
            	ordine.setTot_riga(Integer.parseInt(quantita_textbox.getText())*Integer.parseInt(prezzo_unitario_textbox.getText()));

            	inserisciOrdine(ordine);
        		JOptionPane.showMessageDialog(null, "Operazione eseguita", "InfoBox: Ordine inserito", JOptionPane.INFORMATION_MESSAGE);
        		quantita_textbox.setText(null);
        		codice_textbox.setText(null);
        		descrizione_textbox.setText(null);
        		peso_textbox.setText(null);
        		prezzo_unitario_textbox.setText(null);
            }
        });
		
		
		
        window.setLayout(null);
        window.setVisible(true);
	}
	
	public static void inserisciOrdine(Ordine ordine) {
	 	Statement st = null;
	 	PreparedStatement pstmt = null;
		Connection con  = Database.connect();
		int n_ordine = ordine.getN_ordine();
		String codice_fornitore = String.valueOf(ordine.getCodice_fornitore());
		String data = String.valueOf(ordine.getData());
		int quantita = ordine.getQuantita();
		String codice = String.valueOf(ordine.getBarcode());
		String descrizione = String.valueOf(ordine.getDescrizione());
		double gcad = ordine.getGcad();
		double tot_peso = ordine.getTot_peso();
		int pr_unit = ordine.getPr_unit();
		int tot_riga = ordine.getTot_riga();
		
		try { 
				pstmt = con.prepareStatement("INSERT INTO sys.ordini (n_ordine, codice_fornitore, data, quantita, barcode, descrizione, gcad, tot_peso, pr_unit, tot_riga) VALUE \r\n"
						+ "        (?,?,?,?,?,?,?,?,?,?)");
				pstmt.setInt(1, n_ordine);
				pstmt.setString(2, codice_fornitore);
				pstmt.setString(3, data);
				pstmt.setInt(4, quantita);
				pstmt.setString(5, codice);
				pstmt.setString(6, descrizione);
				pstmt.setDouble(7, gcad);
				pstmt.setDouble(8, tot_peso);
				pstmt.setInt(9, pr_unit);
				pstmt.setInt(10, tot_riga);
				
				pstmt.executeUpdate(); 
	        
	    }  catch (SQLException ex) {
	    	ex.printStackTrace();

	    } finally {
	        try {
	            if (pstmt != null) {
	            	pstmt.close();
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
	
	public static int calcoloNumeroOrdine(int result) {
    	Statement st = null;
        ResultSet rs = null;
        int numeroOrdine=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT n_ordine as last_n_ordine FROM sys.ordini ORDER BY n_ordine DESC LIMIT 1;");                 
                while (rs.next()) {
                	numeroOrdine = rs.getInt("last_n_ordine");
                	System.out.println("NumeroOrdine arrivato: " +numeroOrdine);
                	numeroOrdine = numeroOrdine + 1;
                	System.out.println("NumeroOrdine modificato: " +numeroOrdine);
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
    		String newNumeroOrdine = "1";
    		numeroOrdine = Integer.parseInt(newNumeroOrdine);
    	}
    	
    	return numeroOrdine;
    }
 
 public static int ordiniPresenti() {
    	Statement st = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.ordini;");                 
            
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
		
    	
    	return result;
    }
}
