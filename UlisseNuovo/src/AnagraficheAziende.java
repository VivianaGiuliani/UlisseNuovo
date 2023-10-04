import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.AnagraficaAzienda;
import Oggetti.Articolo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AnagraficheAziende {
    public AnagraficheAziende(){
    	JFrame window = new JFrame();
        window.setSize(1300, 1000);
        window.setTitle("Anagrafiche Azienda");
        window.setResizable(false);
        
        JLabel anagrafiche_clienti_label = new JLabel("Anagrafiche Aziende");
        anagrafiche_clienti_label.setFont(new Font("Courier", Font.BOLD, 20));
        anagrafiche_clienti_label.setBounds(10, 10, 300, 30);
        window.add(anagrafiche_clienti_label);
        
        JLabel cf_label = new JLabel("C/F");
        cf_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cf_label.setBounds(10, 40, 70, 20);
        window.add(cf_label);

        JTextArea cf_textbox = new JTextArea();
        cf_textbox.setBounds(10, 60, 100, 40);
        window.add(cf_textbox);

        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("Courier", Font.PLAIN, 10));
        nome_label.setBounds(120, 40, 50, 20);
        window.add(nome_label);

        JTextArea nome_textbox = new JTextArea();
        nome_textbox.setBounds(120, 60, 200, 40);
        window.add(nome_textbox);

        JLabel indirizzo_label = new JLabel("Indirizzo");
        indirizzo_label.setFont(new Font("Courier", Font.PLAIN, 10));
        indirizzo_label.setBounds(340, 40, 90, 20);
        window.add(indirizzo_label);

        JTextArea indirizzo_textbox = new JTextArea();
        indirizzo_textbox.setBounds(340, 60, 180, 40);
        window.add(indirizzo_textbox);
        
        JLabel cap_label = new JLabel("Cap");
        cap_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cap_label.setBounds(540, 40, 100, 20);
        window.add(cap_label);

        JTextArea cap_textbox = new JTextArea();
        cap_textbox.setBounds(540, 60, 100, 40);
        window.add(cap_textbox);

        
        JLabel citta_label = new JLabel("Citta");
        citta_label.setFont(new Font("Courier", Font.PLAIN, 10));
        citta_label.setBounds(650, 40, 100, 20);
        window.add(citta_label);

        JTextArea citta_textbox = new JTextArea();
        citta_textbox.setBounds(650, 60, 200, 40);
        window.add(citta_textbox);

        JLabel provincia_label = new JLabel("Provincia");
        provincia_label.setFont(new Font("Courier", Font.PLAIN, 10));
        provincia_label.setBounds(860, 40, 100, 20);
        window.add(provincia_label);
        
        JTextArea provincia_textbox = new JTextArea();
        provincia_textbox.setBounds(860, 60, 120, 40);
        window.add(provincia_textbox);
        
        JLabel nome_dest_label = new JLabel("Nome_dest");
        nome_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        nome_dest_label.setBounds(990, 40, 100, 20);
        window.add(nome_dest_label);
        
        JTextArea nome_dest_textbox = new JTextArea();
        nome_dest_textbox.setBounds(990, 60, 200, 40);
        window.add(nome_dest_textbox);
        
        JLabel cap_dest_label = new JLabel("Cap_dest");
        cap_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cap_dest_label.setBounds(10, 100, 100, 20);
        window.add(cap_dest_label);
        
        JTextArea cap_dest_textbox = new JTextArea();
        cap_dest_textbox.setBounds(10, 120, 120, 40);
        window.add(cap_dest_textbox);
        
        JLabel ind_dest_label = new JLabel("Ind_dest");
        ind_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        ind_dest_label.setBounds(140, 100, 100, 20);
        window.add(ind_dest_label);
        
        JTextArea ind_dest_textbox = new JTextArea();
        ind_dest_textbox.setBounds(140, 120, 120, 40);
        window.add(ind_dest_textbox);
        
        JLabel cit_dest_label = new JLabel("Cit_dest");
        cit_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cit_dest_label.setBounds(270, 100, 100, 20);
        window.add(cit_dest_label);
        
        JTextArea cit_dest_textbox = new JTextArea();
        cit_dest_textbox.setBounds(270, 120, 120, 40);
        window.add(cit_dest_textbox);
        
        JLabel prov_dest_label = new JLabel("Prov_dest");
        prov_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        prov_dest_label.setBounds(400, 100, 100, 20);
        window.add(prov_dest_label);
        
        JTextArea prov_dest_textbox = new JTextArea();
        prov_dest_textbox.setBounds(400, 120, 50, 40);
        window.add(prov_dest_textbox);
        
        JLabel p_iva_label = new JLabel("P_iva");
        p_iva_label.setFont(new Font("Courier", Font.PLAIN, 10));
        p_iva_label.setBounds(460, 100, 100, 20);
        window.add(p_iva_label);
        
        JTextArea p_iva_textbox = new JTextArea();
        p_iva_textbox.setBounds(460, 120, 170, 40);
        window.add(p_iva_textbox);
        
        JLabel cod_fisc_label = new JLabel("Cod_fisc");
        cod_fisc_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cod_fisc_label.setBounds(640, 100, 100, 20);
        window.add(cod_fisc_label);
        
        JTextArea cod_fisc_textbox = new JTextArea();
        cod_fisc_textbox.setBounds(640, 120, 150, 40);
        window.add(cod_fisc_textbox);
        
        JLabel pagamento_label = new JLabel("Pagamento");
        pagamento_label.setFont(new Font("Courier", Font.PLAIN, 10));
        pagamento_label.setBounds(800, 100, 100, 20);
        window.add(pagamento_label);
        
        JTextArea pagamento_textbox = new JTextArea();
        pagamento_textbox.setBounds(800, 120, 150, 40);
        window.add(pagamento_textbox);
        
        JLabel pag_immediato_label = new JLabel("Pag_immediato");
        pag_immediato_label.setFont(new Font("Courier", Font.PLAIN, 10));
        pag_immediato_label.setBounds(960, 100, 100, 20);
        window.add(pag_immediato_label);
        
        JTextArea pag_immediato_textbox = new JTextArea();
        pag_immediato_textbox.setBounds(960, 120, 150, 40);
        window.add(pag_immediato_textbox);
        
        JLabel scad_gg_label = new JLabel("Scad_gg");
        scad_gg_label.setFont(new Font("Courier", Font.PLAIN, 10));
        scad_gg_label.setBounds(1120, 100, 100, 20);
        window.add(scad_gg_label);
        
        JTextArea scad_gg_textbox = new JTextArea();
        scad_gg_textbox.setBounds(1120, 120, 100, 40);
        window.add(scad_gg_textbox);
        
        JLabel scad_mesi_label = new JLabel("Scad_mesi");
        scad_mesi_label.setFont(new Font("Courier", Font.PLAIN, 10));
        scad_mesi_label.setBounds(10, 160, 100, 20);
        window.add(scad_mesi_label);
        
        JTextArea scad_mesi_textbox = new JTextArea();
        scad_mesi_textbox.setBounds(10, 180, 100, 40);
        window.add(scad_mesi_textbox);
        
        JLabel n_rate_label = new JLabel("N_rate");
        n_rate_label.setFont(new Font("Courier", Font.PLAIN, 10));
        n_rate_label.setBounds(120, 160, 100, 20);
        window.add(n_rate_label);
        
        JTextArea n_rate_textbox = new JTextArea();
        n_rate_textbox.setBounds(120, 180, 100, 40);
        window.add(n_rate_textbox);
        
        JLabel banca_label = new JLabel("Banca");
        banca_label.setFont(new Font("Courier", Font.PLAIN, 10));
        banca_label.setBounds(230, 160, 100, 20);
        window.add(banca_label);
        
        JTextArea banca_textbox = new JTextArea();
        banca_textbox.setBounds(230, 180, 150, 40);
        window.add(banca_textbox);
        
        JLabel cab_label = new JLabel("Cab");
        cab_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cab_label.setBounds(390, 160, 100, 20);
        window.add(cab_label);
        
        JTextArea cab_textbox = new JTextArea();
        cab_textbox.setBounds(390, 180, 100, 40);
        window.add(cab_textbox);
        
        JLabel abi_label = new JLabel("Abi");
        abi_label.setFont(new Font("Courier", Font.PLAIN, 10));
        abi_label.setBounds(500, 160, 100, 20);
        window.add(abi_label);
        
        JTextArea abi_textbox = new JTextArea();
        abi_textbox.setBounds(500, 180, 100, 40);
        window.add(abi_textbox);
        
        JLabel telefono_label = new JLabel("Telefono");
        telefono_label.setFont(new Font("Courier", Font.PLAIN, 10));
        telefono_label.setBounds(610, 160, 100, 20);
        window.add(telefono_label);
        
        JTextArea telefono_textbox = new JTextArea();
        telefono_textbox.setBounds(610, 180, 120, 40);
        window.add(telefono_textbox);
        
        JLabel email_label = new JLabel("Email");
        email_label.setFont(new Font("Courier", Font.PLAIN, 10));
        email_label.setBounds(740, 160, 100, 20);
        window.add(email_label);
        
        JTextArea email_textbox = new JTextArea();
        email_textbox.setBounds(740, 180, 120, 40);
        window.add(email_textbox);
        
        JLabel note_1_label = new JLabel("Note_1");
        note_1_label.setFont(new Font("Courier", Font.PLAIN, 10));
        note_1_label.setBounds(10, 220, 100 , 20);
        window.add(note_1_label);
        
        JTextArea note_1_textbox = new JTextArea();
        note_1_textbox.setBounds(10, 240, 1250, 40);
        window.add(note_1_textbox);
        
        JLabel note_2_label = new JLabel("Note_2");
        note_2_label.setFont(new Font("Courier", Font.PLAIN, 10));
        note_2_label.setBounds(10, 280, 100 , 20);
        window.add(note_2_label);
        
        JTextArea note_2_textbox = new JTextArea();
        note_2_textbox.setBounds(10, 300, 1250, 40);
        window.add(note_2_textbox);
        
        JLabel note_3_label = new JLabel("Note_3");
        note_3_label.setFont(new Font("Courier", Font.PLAIN, 10));
        note_3_label.setBounds(10, 340, 100 , 20);
        window.add(note_3_label);
        
        JTextArea note_3_textbox = new JTextArea();
        note_3_textbox.setBounds(10, 360, 1250, 40);
        window.add(note_3_textbox);
        
        JButton modifica_button = new JButton("Modifica");
        modifica_button.setBounds(10, 430, 200, 30);
        window.add(modifica_button);

        JButton alfabetico_button = new JButton("Alfabetico");
        alfabetico_button.setBounds(220, 430, 100, 40);
        window.add(alfabetico_button);

        JButton naturale_button = new JButton("Naturale");
        naturale_button.setBounds(330, 430, 100, 40);
        window.add(naturale_button);

        
        JButton aggiungi_button = new JButton("Aggiungi");
        aggiungi_button.setBounds(440, 430, 100, 40);
        window.add(aggiungi_button);

        JButton elimina_button = new JButton("Elimina");
        elimina_button.setBounds(550, 430, 100, 40);
        window.add(elimina_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 500, 1250, 450);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1250, 450);

        String[] columnNames = {"C/F","Codice", "Nome", "Indirizzo", "CAP", "Città", "Provincia", "Nome_dest", "Ind_dest", "Cap_dest", "Cit_dest", "Prov_dest", "P_iva", 
        		"Cod_fisc", "Pagamento", "Pag_immediato", "Scad_gg", "Scad_mesi", "N_rate", "Banca", "Cab", "Abi", "Telefono", "Email", "Note_1", "Note_2", "Note_3"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        window.add(tablePanel);
        
        alfabetico_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				ArrayList<AnagraficaAzienda> anagraficheAziende = anagraficaAziendaAlfabeticoDaDb();
				for(int i=0; i < anagraficheAziende.size(); i++) {
		    		model.addRow(new Object[] {anagraficheAziende.get(i).getCf(), anagraficheAziende.get(i).getCodice(), anagraficheAziende.get(i).getNome(), 
		    				anagraficheAziende.get(i).getIndirizzo(), anagraficheAziende.get(i).getCap(), anagraficheAziende.get(i).getCitta(), anagraficheAziende.get(i).getProvincia(), 
		    				anagraficheAziende.get(i).getNome_dest(), anagraficheAziende.get(i).getInd_dest(), anagraficheAziende.get(i).getCap_dest(), anagraficheAziende.get(i).getCit_dest(),
		    				anagraficheAziende.get(i).getProv_dest(), anagraficheAziende.get(i).getP_iva(), anagraficheAziende.get(i).getCod_fisc(), anagraficheAziende.get(i).getPagamento(),
		    				anagraficheAziende.get(i).getPag_immediato(), anagraficheAziende.get(i).getScad_gg(), anagraficheAziende.get(i).getScad_mesi(), anagraficheAziende.get(i).getN_rate(),
		    				anagraficheAziende.get(i).getBanca(), anagraficheAziende.get(i).getCab(), anagraficheAziende.get(i).getAbi(), anagraficheAziende.get(i).getTelefono(), 
		    				anagraficheAziende.get(i).getEmail(), anagraficheAziende.get(i).getNote_1(), anagraficheAziende.get(i).getNote_2(), anagraficheAziende.get(i).getNote_3()});
		    	}
			}
        });
        
        naturale_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				ArrayList<AnagraficaAzienda> anagraficheAziende = anagraficaAziendaDaDb();
		    	for(int i=0; i < anagraficheAziende.size(); i++) {
		    		model.addRow(new Object[] {anagraficheAziende.get(i).getCf(), anagraficheAziende.get(i).getCodice(), anagraficheAziende.get(i).getNome(), 
		    				anagraficheAziende.get(i).getIndirizzo(), anagraficheAziende.get(i).getCap(), anagraficheAziende.get(i).getCitta(), anagraficheAziende.get(i).getProvincia(), 
		    				anagraficheAziende.get(i).getNome_dest(), anagraficheAziende.get(i).getInd_dest(), anagraficheAziende.get(i).getCap_dest(), anagraficheAziende.get(i).getCit_dest(),
		    				anagraficheAziende.get(i).getProv_dest(), anagraficheAziende.get(i).getP_iva(), anagraficheAziende.get(i).getCod_fisc(), anagraficheAziende.get(i).getPagamento(),
		    				anagraficheAziende.get(i).getPag_immediato(), anagraficheAziende.get(i).getScad_gg(), anagraficheAziende.get(i).getScad_mesi(), anagraficheAziende.get(i).getN_rate(),
		    				anagraficheAziende.get(i).getBanca(), anagraficheAziende.get(i).getCab(), anagraficheAziende.get(i).getAbi(), anagraficheAziende.get(i).getTelefono(), 
		    				anagraficheAziende.get(i).getEmail(), anagraficheAziende.get(i).getNote_1(), anagraficheAziende.get(i).getNote_2(), anagraficheAziende.get(i).getNote_3()});
		    	}
			}
        });
        
        aggiungi_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = anagraficheAziendePresenti();
				int codice = calcoloNumeroCodiceAzienda(result);
				
				AnagraficaAzienda anagraficaAzienda = new AnagraficaAzienda(cf_textbox.getText(), codice, nome_textbox.getText(), indirizzo_textbox.getText(), cap_textbox.getText(),
						citta_textbox.getText(), provincia_textbox.getText(), nome_dest_textbox.getText(), ind_dest_textbox.getText(), cap_dest_textbox.getText(), cit_dest_textbox.getText(),
						prov_dest_textbox.getText(), p_iva_textbox.getText(), cod_fisc_textbox.getText(), pagamento_textbox.getText(), pag_immediato_textbox.getText(), scad_gg_textbox.getText(),
						scad_mesi_textbox.getText(), n_rate_textbox.getText(), banca_textbox.getText(), cab_textbox.getText(), abi_textbox.getText(), telefono_textbox.getText(), email_textbox.getText(),
						note_1_textbox.getText(), note_2_textbox.getText(), note_3_textbox.getText());
			
				
				model.addRow(new Object[] {anagraficaAzienda.getCf(), anagraficaAzienda.getCodice(), anagraficaAzienda.getNome(), 
						anagraficaAzienda.getIndirizzo(), anagraficaAzienda.getCap(), anagraficaAzienda.getCitta(), anagraficaAzienda.getProvincia(), 
						anagraficaAzienda.getNome_dest(), anagraficaAzienda.getInd_dest(), anagraficaAzienda.getCap_dest(), anagraficaAzienda.getCit_dest(),
						anagraficaAzienda.getProv_dest(), anagraficaAzienda.getP_iva(), anagraficaAzienda.getCod_fisc(), anagraficaAzienda.getPagamento(),
						anagraficaAzienda.getPag_immediato(), anagraficaAzienda.getScad_gg(), anagraficaAzienda.getScad_mesi(), anagraficaAzienda.getN_rate(),
						anagraficaAzienda.getBanca(), anagraficaAzienda.getCab(), anagraficaAzienda.getAbi(), anagraficaAzienda.getTelefono(), 
						anagraficaAzienda.getEmail(), anagraficaAzienda.getNote_1(), anagraficaAzienda.getNote_2(), anagraficaAzienda.getNote_3()});
				
				inserisciAnagraficaAziendaDb(anagraficaAzienda, codice);
				cf_textbox.setText(null);
				nome_textbox.setText(null);
				indirizzo_textbox.setText(null);
				cap_textbox.setText(null);
				citta_textbox.setText(null);
				provincia_textbox.setText(null);
				nome_dest_textbox.setText(null);
				ind_dest_textbox.setText(null);
				cap_dest_textbox.setText(null);
				cit_dest_textbox.setText(null);
				prov_dest_textbox.setText(null);
				p_iva_textbox.setText(null);
				cod_fisc_textbox.setText(null);
				pagamento_textbox.setText(null);
				pag_immediato_textbox.setText(null);
				scad_gg_textbox.setText(null);
				scad_mesi_textbox.setText(null);
				n_rate_textbox.setText(null);
				banca_textbox.setText(null);
				cab_textbox.setText(null);
				abi_textbox.setText(null);
				telefono_textbox.setText(null);
				email_textbox.setText(null);
				note_1_textbox.setText(null);
				note_2_textbox.setText(null);
				note_3_textbox.setText(null);
			}
        });
        
        elimina_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
		    	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
		    	System.out.println("Codice riga da eliminare " + value);
		    	model.removeRow(row);
		    	eliminaRigaDb(value);
			}
        });
        
        
        ArrayList<AnagraficaAzienda> anagraficheAziende = anagraficaAziendaDaDb();
    	for(int i=0; i < anagraficheAziende.size(); i++) {
    		model.addRow(new Object[] {anagraficheAziende.get(i).getCf(), anagraficheAziende.get(i).getCodice(), anagraficheAziende.get(i).getNome(), 
    				anagraficheAziende.get(i).getIndirizzo(), anagraficheAziende.get(i).getCap(), anagraficheAziende.get(i).getCitta(), anagraficheAziende.get(i).getProvincia(), 
    				anagraficheAziende.get(i).getNome_dest(), anagraficheAziende.get(i).getInd_dest(), anagraficheAziende.get(i).getCap_dest(), anagraficheAziende.get(i).getCit_dest(),
    				anagraficheAziende.get(i).getProv_dest(), anagraficheAziende.get(i).getP_iva(), anagraficheAziende.get(i).getCod_fisc(), anagraficheAziende.get(i).getPagamento(),
    				anagraficheAziende.get(i).getPag_immediato(), anagraficheAziende.get(i).getScad_gg(), anagraficheAziende.get(i).getScad_mesi(), anagraficheAziende.get(i).getN_rate(),
    				anagraficheAziende.get(i).getBanca(), anagraficheAziende.get(i).getCab(), anagraficheAziende.get(i).getAbi(), anagraficheAziende.get(i).getTelefono(), 
    				anagraficheAziende.get(i).getEmail(), anagraficheAziende.get(i).getNote_1(), anagraficheAziende.get(i).getNote_2(), anagraficheAziende.get(i).getNote_3()});
    	}
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.anagrafica_aziende WHERE codice = ? ";
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
    
    public static void inserisciAnagraficaAziendaDb(AnagraficaAzienda anagraficaAzienda, int codice) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String cf = anagraficaAzienda.getCf();
    	int codiceAn = codice;
    	String nome = anagraficaAzienda.getNome();
    	String indirizzo = anagraficaAzienda.getIndirizzo();
    	String cap = anagraficaAzienda.getCap();
    	String citta = anagraficaAzienda.getCitta(); 
    	String provincia = anagraficaAzienda.getProvincia();
    	String nome_dest = anagraficaAzienda.getNome_dest();
    	String ind_dest = anagraficaAzienda.getInd_dest();
    	String cap_dest = anagraficaAzienda.getCap_dest();
    	String cit_dest = anagraficaAzienda.getCit_dest();
    	String prov_dest = anagraficaAzienda.getProv_dest();
    	String p_iva = anagraficaAzienda.getP_iva();
    	String cod_fisc = anagraficaAzienda.getCod_fisc();
    	String pagamento = anagraficaAzienda.getPagamento();
    	String pag_immediato = anagraficaAzienda.getPag_immediato();
    	String scad_gg = anagraficaAzienda.getScad_gg();
    	String scad_mesi = anagraficaAzienda.getScad_mesi();
    	String n_rate = anagraficaAzienda.getN_rate();
    	String banca = anagraficaAzienda.getBanca();
    	String cab = anagraficaAzienda.getCab();
    	String abi = anagraficaAzienda.getCod_fisc();
    	String telefono = anagraficaAzienda.getCod_fisc();
    	String email = anagraficaAzienda.getCod_fisc();
    	String note_1 = anagraficaAzienda.getNote_1();
    	String note_2 = anagraficaAzienda.getNote_2();
    	String note_3 = anagraficaAzienda.getNote_3();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.anagrafica_aziende (cf, codice, nome, indirizzo, cap, citta, provincia, "
    				+ "nome_dest, ind_dest, cap_dest, cit_dest, prov_dest, p_iva, cod_fisc, pagamento, pag_immediato, scad_gg, scad_mesi, n_rate, banca,"
    				+ "cab, abi, telefono, email, note_1, note_2, note_3) VALUE \r\n"
    				+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		pstmt.setString(1, cf);
    		pstmt.setInt(2, codice);
    		pstmt.setString(3, nome);
    		pstmt.setString(4, indirizzo);
    		pstmt.setString(5, cap);
    		pstmt.setString(6, citta);
    		pstmt.setString(7, provincia);
    		pstmt.setString(8, nome_dest);
    		pstmt.setString(9, ind_dest);
    		pstmt.setString(10, cap_dest);
    		pstmt.setString(11, cit_dest);
    		pstmt.setString(12, prov_dest);
    		pstmt.setString(13, p_iva);
    		pstmt.setString(14, cod_fisc);
    		pstmt.setString(15, pagamento);
    		pstmt.setString(16, pag_immediato);
    		pstmt.setString(17, scad_gg);
    		pstmt.setString(18, scad_mesi);
    		pstmt.setString(19, n_rate);
    		pstmt.setString(20, banca);
    		pstmt.setString(21, cab);
    		pstmt.setString(22, abi);
    		pstmt.setString(23, telefono);
    		pstmt.setString(24, email);
    		pstmt.setString(25, note_1);
    		pstmt.setString(26, note_2);
    		pstmt.setString(27, note_3);
    		
    		
    		
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
    
    public static int anagraficheAziendePresenti() {
    	Statement st = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.anagrafica_aziende;");                 
            
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
    
    public static int calcoloNumeroCodiceAzienda(int result) {
    	Statement st = null;
        ResultSet rs = null;
        int numeroAnagraficaAzienda=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT codice as last_codice FROM sys.anagrafica_aziende ORDER BY codice DESC LIMIT 1;");                 
                while (rs.next()) {
                	numeroAnagraficaAzienda = rs.getInt("last_codice");
                	System.out.println("NumeroVendita arrivato: " +numeroAnagraficaAzienda);
                	numeroAnagraficaAzienda = numeroAnagraficaAzienda + 1;
                	System.out.println("NumeroVendita modificato: " +numeroAnagraficaAzienda);
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
    		String newNumeroAnagraficaAzienda = "1";
    		numeroAnagraficaAzienda = Integer.parseInt(newNumeroAnagraficaAzienda);
    	}
    	
    	return numeroAnagraficaAzienda;
    }
    
    public static ArrayList<AnagraficaAzienda> anagraficaAziendaDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<AnagraficaAzienda> anagraficheAziende = new ArrayList<AnagraficaAzienda>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.anagrafica_aziende ORDER BY codice ASC;");                 
           
            while (rs.next()) {
            	AnagraficaAzienda anagraficaAzienda = new AnagraficaAzienda();
            	
            	anagraficaAzienda.setCf(rs.getString("cf"));
            	anagraficaAzienda.setCodice(rs.getInt("codice"));
            	anagraficaAzienda.setNome(rs.getString("nome"));
            	anagraficaAzienda.setIndirizzo(rs.getString("indirizzo"));
            	anagraficaAzienda.setCap(rs.getString("cap"));
            	anagraficaAzienda.setCitta(rs.getString("citta"));
            	anagraficaAzienda.setProvincia(rs.getString("provincia"));
            	anagraficaAzienda.setNome_dest(rs.getString("nome_dest"));
            	anagraficaAzienda.setInd_dest(rs.getString("ind_dest"));
            	anagraficaAzienda.setCap_dest(rs.getString("cap_dest"));
            	anagraficaAzienda.setCit_dest(rs.getString("cit_dest"));
            	anagraficaAzienda.setProv_dest(rs.getString("prov_dest"));
            	anagraficaAzienda.setP_iva(rs.getString("p_iva"));
            	anagraficaAzienda.setCod_fisc(rs.getString("cod_fisc"));
            	anagraficaAzienda.setPagamento(rs.getString("pagamento"));
            	anagraficaAzienda.setPag_immediato(rs.getString("pag_immediato"));
            	anagraficaAzienda.setScad_gg(rs.getString("scad_gg"));
            	anagraficaAzienda.setScad_mesi(rs.getString("scad_mesi"));
            	anagraficaAzienda.setN_rate(rs.getString("n_rate"));
            	anagraficaAzienda.setBanca(rs.getString("banca"));
            	anagraficaAzienda.setCab(rs.getString("cab"));
            	anagraficaAzienda.setAbi(rs.getString("abi"));
            	anagraficaAzienda.setTelefono(rs.getString("telefono"));
            	anagraficaAzienda.setEmail(rs.getString("email"));
            	anagraficaAzienda.setNote_1(rs.getString("note_1"));
            	anagraficaAzienda.setNote_2(rs.getString("note_2"));
            	anagraficaAzienda.setNote_3(rs.getString("note_3"));
            	anagraficheAziende.add(anagraficaAzienda);
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
		return anagraficheAziende;
		
    }
    
    public static ArrayList<AnagraficaAzienda> anagraficaAziendaAlfabeticoDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<AnagraficaAzienda> anagraficheAziende = new ArrayList<AnagraficaAzienda>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.anagrafica_aziende ORDER BY nome ASC;");                 
           
            while (rs.next()) {
            	AnagraficaAzienda anagraficaAzienda = new AnagraficaAzienda();
            	
            	anagraficaAzienda.setCf(rs.getString("cf"));
            	anagraficaAzienda.setCodice(rs.getInt("codice"));
            	anagraficaAzienda.setNome(rs.getString("nome"));
            	anagraficaAzienda.setIndirizzo(rs.getString("indirizzo"));
            	anagraficaAzienda.setCap(rs.getString("cap"));
            	anagraficaAzienda.setCitta(rs.getString("citta"));
            	anagraficaAzienda.setProvincia(rs.getString("provincia"));
            	anagraficaAzienda.setNome_dest(rs.getString("nome_dest"));
            	anagraficaAzienda.setInd_dest(rs.getString("ind_dest"));
            	anagraficaAzienda.setCap_dest(rs.getString("cap_dest"));
            	anagraficaAzienda.setCit_dest(rs.getString("cit_dest"));
            	anagraficaAzienda.setProv_dest(rs.getString("prov_dest"));
            	anagraficaAzienda.setP_iva(rs.getString("p_iva"));
            	anagraficaAzienda.setCod_fisc(rs.getString("cod_fisc"));
            	anagraficaAzienda.setPagamento(rs.getString("pagamento"));
            	anagraficaAzienda.setPag_immediato(rs.getString("pag_immediato"));
            	anagraficaAzienda.setScad_gg(rs.getString("scad_gg"));
            	anagraficaAzienda.setScad_mesi(rs.getString("scad_mesi"));
            	anagraficaAzienda.setN_rate(rs.getString("n_rate"));
            	anagraficaAzienda.setBanca(rs.getString("banca"));
            	anagraficaAzienda.setCab(rs.getString("cab"));
            	anagraficaAzienda.setAbi(rs.getString("abi"));
            	anagraficaAzienda.setTelefono(rs.getString("telefono"));
            	anagraficaAzienda.setEmail(rs.getString("email"));
            	anagraficaAzienda.setNote_1(rs.getString("note_1"));
            	anagraficaAzienda.setNote_2(rs.getString("note_2"));
            	anagraficaAzienda.setNote_3(rs.getString("note_3"));
            	anagraficheAziende.add(anagraficaAzienda);
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
		return anagraficheAziende;
		
    }
}