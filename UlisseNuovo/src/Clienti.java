import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Classi.Database;
import Classi.ReportClienti;
import Classi.ReportRiparazioniArgenteriaPubblico;
import Oggetti.Articolo;
import Oggetti.Cliente;
import net.sf.jasperreports.engine.JRException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Clienti {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
    public Clienti() {
        JFrame window = new JFrame();
        window.setSize(1100, 750);
        window.setTitle("Clienti");
        window.setResizable(false);
        
        labelSfondo = new JLabel(imageSfondo);
        labelSfondo.setSize(1400, 800);
        
        imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
        Image img = imageSfondo.getImage();
        Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelSfondo.setIcon(scaledIcon);
        
        window.add(labelSfondo);

        JLabel titolo_label = new JLabel("Titolo");
        titolo_label.setFont(new Font("", Font.PLAIN, 15));
        titolo_label.setBounds(10, 20, 70, 20);
        titolo_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(titolo_label);
        
        String[] titolo_values = {"Sig.", "Sig.ra"};
        JComboBox<String> titolo_combobox = new JComboBox<>(titolo_values);
        titolo_combobox.setBounds(10, 40, 100, 40);
        labelSfondo.add(titolo_combobox);

        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("", Font.PLAIN, 15));
        nome_label.setBounds(120, 20, 50, 20);
        nome_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(nome_label);

        JTextField nome_textbox = new JTextField();
        nome_textbox.setBounds(120, 40, 200, 40);
        nome_textbox.setFont(new Font("", Font.PLAIN, 20));
        nome_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(nome_textbox);

        JLabel codice_barre_label = new JLabel("Codice a Barre");
        codice_barre_label.setFont(new Font("", Font.PLAIN, 15));
        codice_barre_label.setBounds(330, 20, 150, 20);
        codice_barre_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(codice_barre_label);

        JTextField codice_barre_textbox = new JTextField();
        codice_barre_textbox.setBounds(330, 40, 150, 40);
        codice_barre_textbox.setFont(new Font("", Font.PLAIN, 20));
        codice_barre_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(codice_barre_textbox);

        JButton modifica_button = new JButton("Modifica");
        modifica_button.setBounds(730, 10, 150, 30);
        modifica_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(modifica_button);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(900, 10, 150, 30);
        stampa_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(stampa_button);

        JLabel ordinamento_label = new JLabel("Ordinamento");
        ordinamento_label.setFont(new Font("", Font.PLAIN, 15));
        ordinamento_label.setBounds(860, 40, 100, 20);
        ordinamento_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(ordinamento_label);

        JButton alfabetico_button = new JButton("Alfabetico");
        alfabetico_button.setBounds(730, 65, 100, 40);
        alfabetico_button.setBackground(new java.awt.Color(193,255,57));
        labelSfondo.add(alfabetico_button);
        
        JButton email_button = new JButton("Email");
        email_button.setBounds(840, 65, 100, 40);
        email_button.setBackground(new java.awt.Color(193,255,57));
        labelSfondo.add(email_button);

        JButton naturale_button = new JButton("Naturale");
        naturale_button.setBounds(950, 65, 100, 40);
        naturale_button.setBackground(new java.awt.Color(193,255,57));
        labelSfondo.add(naturale_button);

        JLabel indirizzo_label = new JLabel("Indirizzo");
        indirizzo_label.setFont(new Font("", Font.PLAIN, 15));
        indirizzo_label.setBounds(10, 80, 100, 20);
        indirizzo_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(indirizzo_label);

        JTextField indirizzo_textbox = new JTextField();
        indirizzo_textbox.setBounds(10, 100, 200, 40);
        indirizzo_textbox.setFont(new Font("", Font.PLAIN, 20));
        indirizzo_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(indirizzo_textbox);

        JLabel cap_label = new JLabel("CAP");
        cap_label.setFont(new Font("", Font.PLAIN, 15));
        cap_label.setBounds(220, 80, 100, 20);
        cap_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cap_label);
        
        JTextField cap_textbox = new JTextField();
        cap_textbox.setBounds(220, 100, 120, 40);
        cap_textbox.setFont(new Font("", Font.PLAIN, 20));
        cap_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cap_textbox);
        
        JLabel citta_label = new JLabel("Città");
        citta_label.setFont(new Font("", Font.PLAIN, 15));
        citta_label.setBounds(350, 80, 100, 20);
        citta_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(citta_label);
        
        JTextField citta_textbox = new JTextField();
        citta_textbox.setBounds(350, 100, 200, 40);
        citta_textbox.setFont(new Font("", Font.PLAIN, 20));
        citta_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(citta_textbox);
        
        JLabel provincia_label = new JLabel("Provincia");
        provincia_label.setFont(new Font("", Font.PLAIN, 15));
        provincia_label.setBounds(560, 80, 100, 20);
        provincia_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(provincia_label);
        
        JTextField provincia_textbox = new JTextField();
        provincia_textbox.setBounds(560, 100, 100, 40);
        provincia_textbox.setFont(new Font("", Font.PLAIN, 20));
        provincia_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(provincia_textbox);
        
        JLabel telefono_label = new JLabel("Telefono");
        telefono_label.setFont(new Font("", Font.PLAIN, 15));
        telefono_label.setBounds(10, 140, 100, 20);
        telefono_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(telefono_label);
        
        JTextField telefono_textbox = new JTextField();
        telefono_textbox.setBounds(10, 160, 120, 40);
        telefono_textbox.setFont(new Font("", Font.PLAIN, 20));
        telefono_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(telefono_textbox);
        
        JLabel note_label = new JLabel("Note");
        note_label.setFont(new Font("", Font.PLAIN, 15));
        note_label.setBounds(140, 140, 100, 20);
        note_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(note_label);
        
        JTextField note_textbox = new JTextField();
        note_textbox.setBounds(140, 160, 400, 40);
        note_textbox.setFont(new Font("", Font.PLAIN, 20));
        note_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(note_textbox);
        
        JLabel email_label = new JLabel("Email");
        email_label.setFont(new Font("", Font.PLAIN, 15));
        email_label.setBounds(550, 140, 100, 20);
        email_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(email_label);
        
        JTextField email_textbox = new JTextField();
        email_textbox.setBounds(550, 160, 170, 40);
        email_textbox.setFont(new Font("", Font.PLAIN, 20));
        email_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(email_textbox);
        
        JButton aggiungi_button = new JButton("Aggiungi");
        aggiungi_button.setBounds(730, 160, 100, 40);
        aggiungi_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(aggiungi_button);

        JButton elimina_button = new JButton("Elimina");
        elimina_button.setBounds(840, 160, 100, 40);
        elimina_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(elimina_button);

        JButton trova_button = new JButton("Trova");
        trova_button.setBounds(950, 160, 100, 40);
        trova_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(trova_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 210, 1050, 470);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1050, 470);

        String[] columnNames = {"Titolo", "Nome", "Indirizzo", "CAP", "Città",
        		"Provincia", "Telefono", "Email", "Note", "Codice a barre", "Punti", "Ultimo Acquisto", "Possesso Email"};
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setPreferredWidth(150);
        table.getColumnModel().getColumn(9).setPreferredWidth(100);
        table.getColumnModel().getColumn(11).setPreferredWidth(100);
        table.getColumnModel().getColumn(12).setPreferredWidth(100);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(10).setCellRenderer(rightRenderer);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        
        window.setLayout(null);
        window.setVisible(true);
        labelSfondo.add(tablePanel);
        
        ArrayList<Cliente> clienti = clientiDaDb();
    	System.out.println("Clienti:" + clienti);
    	for(int i=0; i < clienti.size(); i++) {
    		model.addRow(new Object[] {clienti.get(i).getTitolo(), clienti.get(i).getNome(), clienti.get(i).getIndirizzo(), 
    				clienti.get(i).getCap(), clienti.get(i).getCitta(), clienti.get(i).getProvincia(), clienti.get(i).getTelefono(), 
    				clienti.get(i).getEmail(), clienti.get(i).getNote(), clienti.get(i).getCodiceBarre(),
    				clienti.get(i).getPunti(), clienti.get(i).getUltimo_acquisto(),clienti.get(i).getPossesso_email()});
    	}
    	
    	aggiungi_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	int result = clientiPresenti();
                System.out.println("Result: " + result);
                int codiceBarre = calcoloCodiceBarre(result);
                System.out.println("Codice barre: " + codiceBarre);
                codice_barre_textbox.setText(String.valueOf(codiceBarre));
            	
                Date dataUltimoAcquisto = java.sql.Date.valueOf(java.time.LocalDate.now());
                
                int cliccatoTitolo = titolo_combobox.getSelectedIndex();
                
            	Cliente cliente = new Cliente(titolo_values[cliccatoTitolo].toString(), nome_textbox.getText(), indirizzo_textbox.getText(), cap_textbox.getText(), 
            			citta_textbox.getText(), provincia_textbox.getText(), telefono_textbox.getText(), email_textbox.getText(), note_textbox.getText(), codice_barre_textbox.getText(),
            			0, dataUltimoAcquisto, null);
          
            	
            	
            	model.addRow(new Object[] {cliente.getTitolo(), cliente.getNome(), cliente.getIndirizzo(), 
            			cliente.getCap(), cliente.getCitta(), cliente.getProvincia(), cliente.getTelefono(), 
            			cliente.getEmail(), cliente.getNote(), cliente.getCodiceBarre(), 
            			cliente.getPunti(), cliente.getUltimo_acquisto(),cliente.getPossesso_email()});
            	System.out.println(cliente.toString());
            	inserisciClienteDb(cliente);
            	
            	
            	nome_textbox.setText(null);
            	indirizzo_textbox.setText(null);
            	cap_textbox.setText(null);
            	citta_textbox.setText(null);
            	provincia_textbox.setText(null);
            	telefono_textbox.setText(null);
            	note_textbox.setText(null);
            	codice_barre_textbox.setText(null);
            	
            }
        });
    	
    	elimina_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	System.out.println("Barcode riga da eliminare " + value);
            	model.removeRow(row);
            	eliminaRigaDb(value);
            	
            }
        });
    	
    	alfabetico_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	ArrayList<Cliente> clienti = clientiAlfabeticoDaDb();
            	for(int i=0; i < clienti.size(); i++) {
            		model.addRow(new Object[] {clienti.get(i).getTitolo(), clienti.get(i).getNome(), clienti.get(i).getIndirizzo(), 
            				clienti.get(i).getCap(), clienti.get(i).getCitta(), clienti.get(i).getProvincia(), clienti.get(i).getTelefono(), 
            				clienti.get(i).getEmail(), clienti.get(i).getNote(), clienti.get(i).getCodiceBarre(),
            				clienti.get(i).getPunti(), clienti.get(i).getUltimo_acquisto(),clienti.get(i).getPossesso_email()});
            	}
            }
    	});
    	
    	email_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	ArrayList<Cliente> clienti = clientiEmailDaDb();
            	for(int i=0; i < clienti.size(); i++) {
            		model.addRow(new Object[] {clienti.get(i).getTitolo(), clienti.get(i).getNome(), clienti.get(i).getIndirizzo(), 
            				clienti.get(i).getCap(), clienti.get(i).getCitta(), clienti.get(i).getProvincia(), clienti.get(i).getTelefono(), 
            				clienti.get(i).getEmail(), clienti.get(i).getNote(), clienti.get(i).getCodiceBarre(),
            				clienti.get(i).getPunti(), clienti.get(i).getUltimo_acquisto(),clienti.get(i).getPossesso_email()});
            	}
            }
    	});
    	
    	naturale_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	ArrayList<Cliente> clienti = clientiDaDb();
            	for(int i=0; i < clienti.size(); i++) {
            		model.addRow(new Object[] {clienti.get(i).getTitolo(), clienti.get(i).getNome(), clienti.get(i).getIndirizzo(), 
            				clienti.get(i).getCap(), clienti.get(i).getCitta(), clienti.get(i).getProvincia(), clienti.get(i).getTelefono(), 
            				clienti.get(i).getEmail(), clienti.get(i).getNote(), clienti.get(i).getCodiceBarre(),
            				clienti.get(i).getPunti(), clienti.get(i).getUltimo_acquisto(),clienti.get(i).getPossesso_email()});
            	}
            }
        });
    	
    	trova_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	Cliente cliente = clienteDaDb(codice_barre_textbox.getText());
            	model.setRowCount(0);
            	model.addRow(new Object[] {cliente.getTitolo(), cliente.getNome(), cliente.getIndirizzo(), 
        				cliente.getCap(), cliente.getCitta(), cliente.getProvincia(), cliente.getTelefono(), 
        				cliente.getEmail(), cliente.getNote(), cliente.getCodiceBarre(),
        				cliente.getPunti(), cliente.getUltimo_acquisto(),cliente.getPossesso_email()});
            	codice_barre_textbox.setText("");
            }
    	});
    	
    	stampa_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ReportClienti r = new ReportClienti();
            	try {
					r.generaReport();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
    	});
    	
    	modifica_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificaDatiCliente m = new ModificaDatiCliente();
            }
    	});
    	
    }
    
    public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.clienti WHERE CodiceBarre = ? ";
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
    
    public static void inserisciClienteDb(Cliente cliente) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String titolo = cliente.getTitolo();
    	String nome = cliente.getNome();
    	String indirizzo = cliente.getIndirizzo();
    	String cap = cliente.getCap();
    	String citta = cliente.getCitta();
    	String provincia = cliente.getProvincia();
    	String telefono = cliente.getTelefono();
    	String email = cliente.getEmail();
    	String note = cliente.getNote();
    	String codiceBarre = cliente.getCodiceBarre();
    	int punti = cliente.getPunti();
    	Date ultimo_acquisto = cliente.getUltimo_acquisto();
    	
    	
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.clienti (Titolo, Nome, Indirizzo, Cap, "
    				+ "Citta, Provincia, Telefono, Email, Note, CodiceBarre, Punti, UltimoAcquisto, PossessoEmail) VALUE \r\n"
    				+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		pstmt.setString(1, titolo );
    		pstmt.setString(2, nome);
    		pstmt.setString(3, indirizzo);
    		pstmt.setString(4, cap);
    		pstmt.setString(5, citta);
    		pstmt.setString(6, provincia);
    		pstmt.setString(7, telefono);
    		pstmt.setString(8, email);
    		pstmt.setString(9, note);
    		pstmt.setString(10, codiceBarre);
    		pstmt.setInt(11, punti);
    		pstmt.setDate(12, java.sql.Date.valueOf(java.time.LocalDate.now()));
    		if(email.equals(null)) {
    			pstmt.setString(13, "✓");
    		}else {
    			pstmt.setString(13, "");
    		}
    		
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
    public static Cliente clienteDaDb(String tessera){
    	Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	Cliente cliente = new Cliente(); 
    	System.out.println("tessera " + tessera);
    	try { 
            pstmt = con.prepareStatement("SELECT * FROM sys.clienti WHERE CodiceBarre = ?;");

            pstmt.setString(1, tessera);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	
            	cliente.setTitolo(rs.getString("Titolo"));
            	cliente.setNome(rs.getString("Nome"));
            	cliente.setIndirizzo(rs.getString("Indirizzo"));
            	cliente.setCap(rs.getString("Cap")); 
            	cliente.setCitta(rs.getString("Citta"));
            	cliente.setProvincia(rs.getString("Provincia"));
            	cliente.setTelefono(rs.getString("Telefono"));
            	cliente.setEmail(rs.getString("Email"));
            	cliente.setNote(rs.getString("Note"));
            	cliente.setCodiceBarre(rs.getString("CodiceBarre"));
            	cliente.setPunti(rs.getInt("Punti")); 
            	cliente.setUltimo_acquisto(rs.getDate("UltimoAcquisto"));
            	cliente.setPossesso_email(rs.getString("PossessoEmail"));
            	
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
		return cliente;
		
    }
    
    public static ArrayList<Cliente> clientiDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Cliente> clienti = new ArrayList<Cliente>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.clienti ORDER BY codiceBarre ASC;");                 
            System.out.println("query eseguita articoli da db");
            while (rs.next()) {
            	Cliente cliente = new Cliente();
            	
            	cliente.setTitolo(rs.getString("Titolo"));
            	cliente.setNome(rs.getString("Nome"));
            	cliente.setIndirizzo(rs.getString("Indirizzo"));
            	cliente.setCap(rs.getString("Cap")); 
            	cliente.setCitta(rs.getString("Citta"));
            	cliente.setProvincia(rs.getString("Provincia"));
            	cliente.setTelefono(rs.getString("Telefono"));
            	cliente.setEmail(rs.getString("Email"));
            	cliente.setNote(rs.getString("Note"));
            	cliente.setCodiceBarre(rs.getString("CodiceBarre"));
            	cliente.setPunti(rs.getInt("Punti")); 
            	cliente.setUltimo_acquisto(rs.getDate("UltimoAcquisto"));
            	cliente.setPossesso_email(rs.getString("PossessoEmail"));
            	clienti.add(cliente);
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
		return clienti;
		
    }
    
    public static ArrayList<Cliente> clientiAlfabeticoDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Cliente> clienti = new ArrayList<Cliente>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.clienti ORDER BY Nome ASC;");                 
            System.out.println("query eseguita articoli da db");
            while (rs.next()) {
            	Cliente cliente = new Cliente();
            	
            	cliente.setTitolo(rs.getString("Titolo"));
            	cliente.setNome(rs.getString("Nome"));
            	cliente.setIndirizzo(rs.getString("Indirizzo"));
            	cliente.setCap(rs.getString("Cap")); 
            	cliente.setCitta(rs.getString("Citta"));
            	cliente.setProvincia(rs.getString("Provincia"));
            	cliente.setTelefono(rs.getString("Telefono"));
            	cliente.setEmail(rs.getString("Email"));
            	cliente.setNote(rs.getString("Note"));
            	cliente.setCodiceBarre(rs.getString("CodiceBarre"));
            	cliente.setPunti(rs.getInt("Punti")); 
            	cliente.setUltimo_acquisto(rs.getDate("UltimoAcquisto"));
            	cliente.setPossesso_email(rs.getString("PossessoEmail"));
            	clienti.add(cliente);
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
		return clienti;
		
    }
    
    public static ArrayList<Cliente> clientiEmailDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Cliente> clienti = new ArrayList<Cliente>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.clienti ORDER BY Email ASC;");                 
            System.out.println("query eseguita articoli da db");
            while (rs.next()) {
            	Cliente cliente = new Cliente();
            	
            	cliente.setTitolo(rs.getString("Titolo"));
            	cliente.setNome(rs.getString("Nome"));
            	cliente.setIndirizzo(rs.getString("Indirizzo"));
            	cliente.setCap(rs.getString("Cap")); 
            	cliente.setCitta(rs.getString("Citta"));
            	cliente.setProvincia(rs.getString("Provincia"));
            	cliente.setTelefono(rs.getString("Telefono"));
            	cliente.setEmail(rs.getString("Email"));
            	cliente.setNote(rs.getString("Note"));
            	cliente.setCodiceBarre(rs.getString("CodiceBarre"));
            	cliente.setPunti(rs.getInt("Punti")); 
            	cliente.setUltimo_acquisto(rs.getDate("UltimoAcquisto"));
            	cliente.setPossesso_email(rs.getString("PossessoEmail"));
            	clienti.add(cliente);
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
		return clienti;
		
    }
    
    public static int calcoloCodiceBarre(int result) {
    	Statement st = null;
        ResultSet rs = null;
        int codiceBarre=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT CodiceBarre as last_codiceBarre FROM sys.clienti ORDER BY CodiceBarre DESC LIMIT 1;");                 
                while (rs.next()) {
                	codiceBarre = rs.getInt("last_codiceBarre");
                	System.out.println("codiceBarre arrivato: " +codiceBarre);
                	codiceBarre = codiceBarre + 1;
                	System.out.println("codiceBarre modificato: " +codiceBarre);
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
    		String newCodiceBarre = "950" + "0000";
    		codiceBarre = Integer.parseInt(newCodiceBarre);
    	}
    	
		
    	
    	return codiceBarre;
    }
    
    public static int clientiPresenti() {
    	Statement st = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.clienti;");                 
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