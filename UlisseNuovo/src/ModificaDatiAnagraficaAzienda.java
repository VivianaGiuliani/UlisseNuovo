import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.AnagraficaAzienda;
import Oggetti.Cliente;

public class ModificaDatiAnagraficaAzienda {
	public static void main (String [] args) {
		JFrame window = new JFrame();
        window.setSize(1300, 1000);
        window.setTitle("Modifica Dati Anagrafica Azienda");
        window.setResizable(false);
        
        JLabel anagrafiche_clienti_label = new JLabel("Anagrafiche Aziende");
        anagrafiche_clienti_label.setFont(new Font("Courier", Font.BOLD, 20));
        anagrafiche_clienti_label.setBounds(10, 10, 300, 30);
        window.add(anagrafiche_clienti_label);
        
        JLabel inserisci_codice_label = new JLabel("Inserisci codice:");
        inserisci_codice_label.setFont(new Font("Courier", Font.BOLD, 20));
        inserisci_codice_label.setBounds(10, 50, 300, 30);
        window.add(inserisci_codice_label);
        
        JTextArea inserisci_codice_textbox = new JTextArea();
        inserisci_codice_textbox.setBounds(180, 50, 100, 40);
        window.add(inserisci_codice_textbox);
        
        JLabel cf_label = new JLabel("C/F");
        cf_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cf_label.setBounds(10, 80, 70, 20);
        window.add(cf_label);

        JTextArea cf_textbox = new JTextArea();
        cf_textbox.setBounds(10, 100, 100, 40);
        window.add(cf_textbox);

        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("Courier", Font.PLAIN, 10));
        nome_label.setBounds(120, 80, 50, 20);
        window.add(nome_label);

        JTextArea nome_textbox = new JTextArea();
        nome_textbox.setBounds(120, 100, 200, 40);
        window.add(nome_textbox);

        JLabel indirizzo_label = new JLabel("Indirizzo");
        indirizzo_label.setFont(new Font("Courier", Font.PLAIN, 10));
        indirizzo_label.setBounds(340, 80, 90, 20);
        window.add(indirizzo_label);

        JTextArea indirizzo_textbox = new JTextArea();
        indirizzo_textbox.setBounds(340, 100, 180, 40);
        window.add(indirizzo_textbox);
        
        JLabel cap_label = new JLabel("Cap");
        cap_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cap_label.setBounds(540, 80, 100, 20);
        window.add(cap_label);

        JTextArea cap_textbox = new JTextArea();
        cap_textbox.setBounds(540, 100, 100, 40);
        window.add(cap_textbox);

        
        JLabel citta_label = new JLabel("Citta");
        citta_label.setFont(new Font("Courier", Font.PLAIN, 10));
        citta_label.setBounds(650, 80, 100, 20);
        window.add(citta_label);

        JTextArea citta_textbox = new JTextArea();
        citta_textbox.setBounds(650, 100, 200, 40);
        window.add(citta_textbox);

        JLabel provincia_label = new JLabel("Provincia");
        provincia_label.setFont(new Font("Courier", Font.PLAIN, 10));
        provincia_label.setBounds(860, 80, 100, 20);
        window.add(provincia_label);
        
        JTextArea provincia_textbox = new JTextArea();
        provincia_textbox.setBounds(860, 100, 120, 40);
        window.add(provincia_textbox);
        
        JLabel nome_dest_label = new JLabel("Nome_dest");
        nome_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        nome_dest_label.setBounds(990, 80, 100, 20);
        window.add(nome_dest_label);
        
        JTextArea nome_dest_textbox = new JTextArea();
        nome_dest_textbox.setBounds(990, 100, 200, 40);
        window.add(nome_dest_textbox);
        
        JLabel cap_dest_label = new JLabel("Cap_dest");
        cap_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cap_dest_label.setBounds(10, 140, 100, 20);
        window.add(cap_dest_label);
        
        JTextArea cap_dest_textbox = new JTextArea();
        cap_dest_textbox.setBounds(10, 160, 120, 40);
        window.add(cap_dest_textbox);
        
        JLabel ind_dest_label = new JLabel("Ind_dest");
        ind_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        ind_dest_label.setBounds(140, 140, 100, 20);
        window.add(ind_dest_label);
        
        JTextArea ind_dest_textbox = new JTextArea();
        ind_dest_textbox.setBounds(140, 160, 120, 40);
        window.add(ind_dest_textbox);
        
        JLabel cit_dest_label = new JLabel("Cit_dest");
        cit_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cit_dest_label.setBounds(270, 140, 100, 20);
        window.add(cit_dest_label);
        
        JTextArea cit_dest_textbox = new JTextArea();
        cit_dest_textbox.setBounds(270, 160, 120, 40);
        window.add(cit_dest_textbox);
        
        JLabel prov_dest_label = new JLabel("Prov_dest");
        prov_dest_label.setFont(new Font("Courier", Font.PLAIN, 10));
        prov_dest_label.setBounds(400, 140, 100, 20);
        window.add(prov_dest_label);
        
        JTextArea prov_dest_textbox = new JTextArea();
        prov_dest_textbox.setBounds(400, 160, 50, 40);
        window.add(prov_dest_textbox);
        
        JLabel p_iva_label = new JLabel("P_iva");
        p_iva_label.setFont(new Font("Courier", Font.PLAIN, 10));
        p_iva_label.setBounds(460, 140, 100, 20);
        window.add(p_iva_label);
        
        JTextArea p_iva_textbox = new JTextArea();
        p_iva_textbox.setBounds(460, 160, 170, 40);
        window.add(p_iva_textbox);
        
        JLabel cod_fisc_label = new JLabel("Cod_fisc");
        cod_fisc_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cod_fisc_label.setBounds(640, 140, 100, 20);
        window.add(cod_fisc_label);
        
        JTextArea cod_fisc_textbox = new JTextArea();
        cod_fisc_textbox.setBounds(640, 160, 150, 40);
        window.add(cod_fisc_textbox);
        
        JLabel pagamento_label = new JLabel("Pagamento");
        pagamento_label.setFont(new Font("Courier", Font.PLAIN, 10));
        pagamento_label.setBounds(800, 200, 100, 20);
        window.add(pagamento_label);
        
        JTextArea pagamento_textbox = new JTextArea();
        pagamento_textbox.setBounds(800, 220, 150, 40);
        window.add(pagamento_textbox);
        
        JLabel pag_immediato_label = new JLabel("Pag_immediato");
        pag_immediato_label.setFont(new Font("Courier", Font.PLAIN, 10));
        pag_immediato_label.setBounds(960, 200, 100, 20);
        window.add(pag_immediato_label);
        
        JTextArea pag_immediato_textbox = new JTextArea();
        pag_immediato_textbox.setBounds(960, 220, 150, 40);
        window.add(pag_immediato_textbox);
        
        JLabel scad_gg_label = new JLabel("Scad_gg");
        scad_gg_label.setFont(new Font("Courier", Font.PLAIN, 10));
        scad_gg_label.setBounds(1120, 200, 100, 20);
        window.add(scad_gg_label);
        
        JTextArea scad_gg_textbox = new JTextArea();
        scad_gg_textbox.setBounds(1120, 220, 100, 40);
        window.add(scad_gg_textbox);
        
        JLabel scad_mesi_label = new JLabel("Scad_mesi");
        scad_mesi_label.setFont(new Font("Courier", Font.PLAIN, 10));
        scad_mesi_label.setBounds(10, 200, 100, 20);
        window.add(scad_mesi_label);
        
        JTextArea scad_mesi_textbox = new JTextArea();
        scad_mesi_textbox.setBounds(10, 220, 100, 40);
        window.add(scad_mesi_textbox);
        
        JLabel n_rate_label = new JLabel("N_rate");
        n_rate_label.setFont(new Font("Courier", Font.PLAIN, 10));
        n_rate_label.setBounds(120, 200, 100, 20);
        window.add(n_rate_label);
        
        JTextArea n_rate_textbox = new JTextArea();
        n_rate_textbox.setBounds(120, 220, 100, 40);
        window.add(n_rate_textbox);
        
        JLabel banca_label = new JLabel("Banca");
        banca_label.setFont(new Font("Courier", Font.PLAIN, 10));
        banca_label.setBounds(230, 200, 100, 20);
        window.add(banca_label);
        
        JTextArea banca_textbox = new JTextArea();
        banca_textbox.setBounds(230, 220, 150, 40);
        window.add(banca_textbox);
        
        JLabel cab_label = new JLabel("Cab");
        cab_label.setFont(new Font("Courier", Font.PLAIN, 10));
        cab_label.setBounds(390, 200, 100, 20);
        window.add(cab_label);
        
        JTextArea cab_textbox = new JTextArea();
        cab_textbox.setBounds(390, 220, 100, 40);
        window.add(cab_textbox);
        
        JLabel abi_label = new JLabel("Abi");
        abi_label.setFont(new Font("Courier", Font.PLAIN, 10));
        abi_label.setBounds(500, 200, 100, 20);
        window.add(abi_label);
        
        JTextArea abi_textbox = new JTextArea();
        abi_textbox.setBounds(500, 220, 100, 40);
        window.add(abi_textbox);
        
        JLabel telefono_label = new JLabel("Telefono");
        telefono_label.setFont(new Font("Courier", Font.PLAIN, 10));
        telefono_label.setBounds(610, 200, 100, 20);
        window.add(telefono_label);
        
        JTextArea telefono_textbox = new JTextArea();
        telefono_textbox.setBounds(610, 220, 120, 40);
        window.add(telefono_textbox);
        
        JLabel email_label = new JLabel("Email");
        email_label.setFont(new Font("Courier", Font.PLAIN, 10));
        email_label.setBounds(740, 200, 100, 20);
        window.add(email_label);
        
        JTextArea email_textbox = new JTextArea();
        email_textbox.setBounds(740, 220, 120, 40);
        window.add(email_textbox);
        
        JLabel note_1_label = new JLabel("Note_1");
        note_1_label.setFont(new Font("Courier", Font.PLAIN, 10));
        note_1_label.setBounds(10, 260, 100 , 20);
        window.add(note_1_label);
        
        JTextArea note_1_textbox = new JTextArea();
        note_1_textbox.setBounds(10, 280, 1250, 40);
        window.add(note_1_textbox);
        
        JLabel note_2_label = new JLabel("Note_2");
        note_2_label.setFont(new Font("Courier", Font.PLAIN, 10));
        note_2_label.setBounds(10, 320, 100 , 20);
        window.add(note_2_label);
        
        JTextArea note_2_textbox = new JTextArea();
        note_2_textbox.setBounds(10, 340, 1250, 40);
        window.add(note_2_textbox);
        
        JLabel note_3_label = new JLabel("Note_3");
        note_3_label.setFont(new Font("Courier", Font.PLAIN, 10));
        note_3_label.setBounds(10, 390, 100 , 20);
        window.add(note_3_label);
        
        JTextArea note_3_textbox = new JTextArea();
        note_3_textbox.setBounds(10, 410, 1250, 40);
        window.add(note_3_textbox);
        
        JButton modifica_button = new JButton("Modifica");
        modifica_button.setBounds(10, 460, 200, 30);
        window.add(modifica_button);
        
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
        
        inserisci_codice_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				  String codiceText = inserisci_codice_textbox.getText();
				  int codice = 0;

				  if (!codiceText.isEmpty()) {
				      try {
				          codice = Integer.parseInt(codiceText);
				      } catch (NumberFormatException e) {
				          // Gestisci l'eccezione o mostra un messaggio di errore all'utente
				      }
				  } else {
				      // Gestisci il caso in cui il campo sia vuoto
				  }
				  AnagraficaAzienda anagraficaAzienda = anagraficaAziendaDaDb(codice);
				  if (evt.getKeyCode() == evt.VK_TAB) {
					  	if(anagraficaAzienda.getCf().equals(null)) {
					  		cf_textbox.setText("");
					  	}else {
					  		cf_textbox.setText(anagraficaAzienda.getCf());
					  	}
					  	if(anagraficaAzienda.getNome().equals(null)) {
					  		nome_textbox.setText("");
					  	}else {
					  		nome_textbox.setText(anagraficaAzienda.getNome());
					  	}
					  	if(anagraficaAzienda.getIndirizzo().equals(null)) {
					  		indirizzo_textbox.setText("");
					  	}else {
					  		indirizzo_textbox.setText(anagraficaAzienda.getIndirizzo());
					  	}
					  	if(anagraficaAzienda.getCap().equals(null)) {
					  		cap_textbox.setText("");
					  	}else {
					  		cap_textbox.setText(anagraficaAzienda.getCap());
					  	}
					  	if(anagraficaAzienda.getCitta().equals(null)) {
					  		citta_textbox.setText("");
					  	}else {
					  		citta_textbox.setText(anagraficaAzienda.getCitta());
					  	}
					  	if(anagraficaAzienda.getProvincia().equals(null)) {
					  		provincia_textbox.setText("");
					  	}else {
					  		provincia_textbox.setText(anagraficaAzienda.getProvincia());
					  	}
					  	if(anagraficaAzienda.getNome().equals(null)) {
					  		nome_dest_textbox.setText("");
					  	}else {
					  		nome_dest_textbox.setText(anagraficaAzienda.getNome_dest());
					  	}
					  	if(anagraficaAzienda.getInd_dest().equals(null)) {
					  		ind_dest_textbox.setText("");
					  	}else {
					  		ind_dest_textbox.setText(anagraficaAzienda.getInd_dest());
					  	}
					  	if(anagraficaAzienda.getCap_dest().equals(null)) {
					  		cap_dest_textbox.setText("");
					  	}else {
					  		cap_dest_textbox.setText(anagraficaAzienda.getCap_dest());
					  	}
					  	if(anagraficaAzienda.getCit_dest().equals(null)) {
					  		cit_dest_textbox.setText("");
					  	}else {
					  		cit_dest_textbox.setText(anagraficaAzienda.getCit_dest());
					  	}
						
						if(anagraficaAzienda.getProv_dest().equals(null)) {
							prov_dest_textbox.setText("");
					  	}else {
					  		prov_dest_textbox.setText(anagraficaAzienda.getProv_dest());
					  	}
						if(anagraficaAzienda.getP_iva().equals(null)) {
							p_iva_textbox.setText("");
					  	}else {
							p_iva_textbox.setText(anagraficaAzienda.getP_iva());
					  	}
						if(anagraficaAzienda.getCod_fisc().equals(null)) {
							cod_fisc_textbox.setText("");
					  	}else {
							cod_fisc_textbox.setText(anagraficaAzienda.getCod_fisc());
					  	}
						if(anagraficaAzienda.getPagamento().equals(null)) {
							pagamento_textbox.setText("");
					  	}else {
							pagamento_textbox.setText(anagraficaAzienda.getPagamento());
					  	}
						if(anagraficaAzienda.getPag_immediato().equals(null)) {
							pag_immediato_textbox.setText("");
					  	}else {
							pag_immediato_textbox.setText(anagraficaAzienda.getPag_immediato());
					  	}
						if(anagraficaAzienda.getScad_gg().equals(null)) {
							scad_gg_textbox.setText("");
					  	}else {
							scad_gg_textbox.setText(anagraficaAzienda.getScad_gg());
					  	}
						if(anagraficaAzienda.getScad_mesi().equals(null)) {
							scad_mesi_textbox.setText("");
					  	}else {
							scad_mesi_textbox.setText(anagraficaAzienda.getScad_mesi());
					  	}
						if(anagraficaAzienda.getN_rate().equals(null)) {
							n_rate_textbox.setText("");
					  	}else {
					  		n_rate_textbox.setText(anagraficaAzienda.getN_rate());
					  	}
						if(anagraficaAzienda.getBanca().equals(null)) {
							banca_textbox.setText("");
					  	}else {
							banca_textbox.setText(anagraficaAzienda.getBanca());
					  	}
						if(anagraficaAzienda.getCab().equals(null)) {
							cab_textbox.setText("");
					  	}else {
							cab_textbox.setText(anagraficaAzienda.getCab());
					  	}
						if(anagraficaAzienda.getAbi().equals(null)) {
							abi_textbox.setText("");
					  	}else {
							abi_textbox.setText(anagraficaAzienda.getAbi());
					  	}
						if(anagraficaAzienda.getTelefono().equals(null)) {
							telefono_textbox.setText("");
					  	}else {
							telefono_textbox.setText(anagraficaAzienda.getTelefono());
					  	}
						if(anagraficaAzienda.getEmail().equals(null)) {
							email_textbox.setText("");
					  	}else {
							email_textbox.setText(anagraficaAzienda.getEmail());
					  	}
						if(anagraficaAzienda.getNote_1().equals(null)) {
							note_1_textbox.setText("");
					  	}else {
							note_1_textbox.setText(anagraficaAzienda.getNote_1());
					  	}
						if(anagraficaAzienda.getNote_2().equals(null)) {
							note_2_textbox.setText("");
					  	}else {
							note_2_textbox.setText(anagraficaAzienda.getNote_2());
					  	}
						if(anagraficaAzienda.getNote_3().equals(null)) {
							note_3_textbox.setText("");
					  	}else {
							note_3_textbox.setText(anagraficaAzienda.getNote_3());
					  	}

						
						model.addRow(new Object[] {anagraficaAzienda.getCf(), anagraficaAzienda.getCodice() , anagraficaAzienda.getNome(), 
								anagraficaAzienda.getIndirizzo(), anagraficaAzienda.getCap(), anagraficaAzienda.getCitta(), anagraficaAzienda.getProvincia(), 
								anagraficaAzienda.getNome_dest(), anagraficaAzienda.getInd_dest(), anagraficaAzienda.getCap_dest(), anagraficaAzienda.getCit_dest(),
								anagraficaAzienda.getProv_dest(), anagraficaAzienda.getP_iva(), anagraficaAzienda.getCod_fisc(), anagraficaAzienda.getPagamento(),
								anagraficaAzienda.getPag_immediato(), anagraficaAzienda.getScad_gg(), anagraficaAzienda.getScad_mesi(), anagraficaAzienda.getN_rate(),
								anagraficaAzienda.getBanca(), anagraficaAzienda.getCab(), anagraficaAzienda.getAbi(), anagraficaAzienda.getTelefono(), 
								anagraficaAzienda.getEmail(), anagraficaAzienda.getNote_1(), anagraficaAzienda.getNote_2(), anagraficaAzienda.getNote_3()});
				  }
			  }
        });
        
        modifica_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AnagraficaAzienda anagraficaAzienda = new AnagraficaAzienda();
            	
            	anagraficaAzienda.setCf(cf_textbox.getText());
            	anagraficaAzienda.setNome(nome_textbox.getText());
            	anagraficaAzienda.setIndirizzo(indirizzo_textbox.getText());
            	anagraficaAzienda.setCap(cap_textbox.getText());
            	anagraficaAzienda.setCitta(citta_textbox.getText());
            	anagraficaAzienda.setProvincia(provincia_textbox.getText());
            	anagraficaAzienda.setNome_dest(nome_dest_textbox.getText());
            	anagraficaAzienda.setInd_dest(ind_dest_textbox.getText());
            	anagraficaAzienda.setCap_dest(cap_dest_textbox.getText());
            	anagraficaAzienda.setCit_dest(cit_dest_textbox.getText());
            	anagraficaAzienda.setProv_dest(prov_dest_textbox.getText());
            	anagraficaAzienda.setP_iva(p_iva_textbox.getText());
            	anagraficaAzienda.setCod_fisc(cod_fisc_textbox.getText());
            	anagraficaAzienda.setPagamento(pagamento_textbox.getText());
            	anagraficaAzienda.setPag_immediato(pag_immediato_textbox.getText());
            	anagraficaAzienda.setScad_gg(scad_gg_textbox.getText());
            	anagraficaAzienda.setScad_mesi(scad_mesi_textbox.getText());
            	anagraficaAzienda.setN_rate(n_rate_textbox.getText());
            	anagraficaAzienda.setBanca(banca_textbox.getText());
            	anagraficaAzienda.setCab(cab_textbox.getText());
            	anagraficaAzienda.setAbi(abi_textbox.getText());
            	anagraficaAzienda.setTelefono(telefono_textbox.getText());
            	anagraficaAzienda.setEmail(email_textbox.getText());
            	anagraficaAzienda.setNote_1(note_1_textbox.getText());
            	anagraficaAzienda.setNote_2(note_2_textbox.getText());
            	anagraficaAzienda.setNote_3(note_3_textbox.getText());
            	
            	aggiornaAnagraficaAzienda(anagraficaAzienda);
            	System.out.println(anagraficaAzienda);
            	
            	model.setRowCount(0);
            	
            	String codiceText = inserisci_codice_textbox.getText();
				  int codice = 0;

				  if (!codiceText.isEmpty()) {
				      try {
				          codice = Integer.parseInt(codiceText);
				      } catch (NumberFormatException e1) {
				          // Gestisci l'eccezione o mostra un messaggio di errore all'utente
				      }
				  } else {
				      // Gestisci il caso in cui il campo sia vuoto
				  }
				  
            	anagraficaAzienda = anagraficaAziendaDaDb(codice);
            	model.addRow(new Object[] {anagraficaAzienda.getCf(), anagraficaAzienda.getCodice() , anagraficaAzienda.getNome(), 
						anagraficaAzienda.getIndirizzo(), anagraficaAzienda.getCap(), anagraficaAzienda.getCitta(), anagraficaAzienda.getProvincia(), 
						anagraficaAzienda.getNome_dest(), anagraficaAzienda.getInd_dest(), anagraficaAzienda.getCap_dest(), anagraficaAzienda.getCit_dest(),
						anagraficaAzienda.getProv_dest(), anagraficaAzienda.getP_iva(), anagraficaAzienda.getCod_fisc(), anagraficaAzienda.getPagamento(),
						anagraficaAzienda.getPag_immediato(), anagraficaAzienda.getScad_gg(), anagraficaAzienda.getScad_mesi(), anagraficaAzienda.getN_rate(),
						anagraficaAzienda.getBanca(), anagraficaAzienda.getCab(), anagraficaAzienda.getAbi(), anagraficaAzienda.getTelefono(), 
						anagraficaAzienda.getEmail(), anagraficaAzienda.getNote_1(), anagraficaAzienda.getNote_2(), anagraficaAzienda.getNote_3()});
            	
            }
        });
        
        window.setLayout(null);
        window.setVisible(true);
        
	}
	
	public static void aggiornaAnagraficaAzienda(AnagraficaAzienda anagraficaAzienda){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	String cf, nome, indirizzo, cap, citta, provincia, nome_dest, ind_dest, cap_dest, cit_dest, prov_dest, p_iva, cod_fisc, pagamento,
    	pag_immediato, scad_gg, scad_mesi, n_rate, banca, cab, abi, telefono, email, note_1, note_2, note_3;
    	
    	int codice = anagraficaAzienda.getCodice();
    	if(anagraficaAzienda.getCf().equals(null)) {
    		cf = "";
    	}else {
    		cf = anagraficaAzienda.getCf();
    	}
    	if(anagraficaAzienda.getNome() == "") {
    		nome = "";
    	}else {
    		nome = anagraficaAzienda.getNome();
    	}
    	if(anagraficaAzienda.getIndirizzo() == "") {
    		indirizzo = "";
    	}else {
    		indirizzo = anagraficaAzienda.getIndirizzo();
    	}
    	if(anagraficaAzienda.getCap() == "") {
    		cap = "";
    	}else {
    		cap = anagraficaAzienda.getCap();
    	}
    	if(anagraficaAzienda.getCitta() == "") {
    		citta = "";
    	}else {
    		citta = anagraficaAzienda.getCitta();
    	}
    	if(anagraficaAzienda.getProvincia() == "") {
    		provincia = "";
    	}else {
    		provincia = anagraficaAzienda.getProvincia();
    	}
    	if(anagraficaAzienda.getNome_dest() == "") {
    		nome_dest = "";
    	}else {
    		nome_dest = anagraficaAzienda.getNome_dest();
    	}
    	if(anagraficaAzienda.getInd_dest() == "") {
    		ind_dest = "";
    	}else {
    		ind_dest = anagraficaAzienda.getInd_dest();
    	}
    	if(anagraficaAzienda.getCap_dest() == "") {
    		cap_dest = "";
    	}else {
    		cap_dest = anagraficaAzienda.getCap_dest();
    	}
    	if(anagraficaAzienda.getCit_dest() == "") {
    		cit_dest = "";
    	}else {
    		cit_dest = anagraficaAzienda.getCit_dest();
    	}
    	if(anagraficaAzienda.getProv_dest() == "") {
    		prov_dest = "";
    	}else {
    		prov_dest = anagraficaAzienda.getProv_dest();
    	}
    	if(anagraficaAzienda.getP_iva() == "") {
    		p_iva = "";
    	}else {
    		p_iva = anagraficaAzienda.getP_iva();
    	}
    	if(anagraficaAzienda.getCod_fisc() == "") {
    		cod_fisc = "";
    	}else {
    		cod_fisc = anagraficaAzienda.getCod_fisc();
    	}
    	if(anagraficaAzienda.getPagamento() == "") {
    		pagamento = "";
    	}else {
    		pagamento = anagraficaAzienda.getPagamento();
    	}
    	if(anagraficaAzienda.getPag_immediato() == "") {
    		pag_immediato = "";
    	}else {
    		pag_immediato = anagraficaAzienda.getPag_immediato();
    	}
    	if(anagraficaAzienda.getScad_gg() == "") {
    		scad_gg = "";
    	}else {
    		scad_gg = anagraficaAzienda.getScad_gg();
    	}
    	if(anagraficaAzienda.getScad_mesi() == "") {
    		scad_mesi = "";
    	}else {
    		scad_mesi = anagraficaAzienda.getScad_mesi();
    	}
    	if(anagraficaAzienda.getN_rate() == "") {
    		n_rate = "";
    	}else {
    		n_rate = anagraficaAzienda.getN_rate();
    	}
    	if(anagraficaAzienda.getBanca() == "") {
    		banca = "";
    	}else {
    		banca = anagraficaAzienda.getBanca();
    	}
    	if(anagraficaAzienda.getCab() == "") {
    		cab = "";
    	}else {
    		cab = anagraficaAzienda.getCab();
    	}
    	if(anagraficaAzienda.getAbi() == "") {
    		abi = "";
    	}else {
    		abi = anagraficaAzienda.getAbi();
    	}
    	if(anagraficaAzienda.getTelefono() == "") {
    		telefono = "";
    	}else {
    		telefono = anagraficaAzienda.getTelefono();
    	}
    	if(anagraficaAzienda.getEmail() == "") {
    		email = "";
    	}else {
    		email = anagraficaAzienda.getEmail();
    	}
    	if(anagraficaAzienda.getNote_1().equals(null)) {
    		note_1 = "";
    	}else {
    		note_1 = anagraficaAzienda.getNote_1();
    	}
    	if(anagraficaAzienda.getNote_2() == "") {
    		note_2 = "";
    	}else {
    		note_2 = anagraficaAzienda.getNote_2();
    	}
    	if(anagraficaAzienda.getNote_3() == "") {
    		note_3 = "";
    	}else {
    		note_3 = anagraficaAzienda.getNote_3();
    	}
    	
    	try {
    		st = con.prepareStatement("UPDATE sys.anagrafica_aziende SET cf = ?, nome = ?, indirizzo = ?, cap = ?, citta = ?, provincia = ?, nome_dest = ?, ind_dest = ?, cap_dest = ?,"
    				+ "cit_dest = ?, prov_dest = ?, p_iva = ?, cod_fisc = ?, pagamento = ?, pag_immediato = ?, scad_gg = ?, scad_mesi = ?, n_rate = ?, banca = ?,"
    				+ "cab = ?, abi = ?, telefono = ?, email = ?, note_1 = ?, note_2 = ?, note_3 = ? WHERE codice = ?;");
    		st.setString(1, cf);
    		st.setString(2, nome);
    		st.setString(3, indirizzo);
    		st.setString(4, cap);
    		st.setString(5, citta);
    		st.setString(6, provincia);
    		st.setString(7, nome_dest);
    		st.setString(8, ind_dest);
    		st.setString(9, cap_dest);
    		st.setString(10, cit_dest);
    		st.setString(11, prov_dest);
    		st.setString(12, p_iva);
    		st.setString(13, cod_fisc);
    		st.setString(14, pagamento);
    		st.setString(15, pag_immediato);
    		st.setString(16, scad_gg);
    		st.setString(17, scad_mesi);
    		st.setString(18, n_rate);
    		st.setString(19, banca);
    		st.setString(20, cab);
    		st.setString(21, abi);
    		st.setString(22, telefono);
    		st.setString(23, email);
    		st.setString(24, note_1);
    		st.setString(25, note_2);
    		st.setString(26, note_3);
    		st.setInt(27, codice);
	        st.executeUpdate();
    		System.out.println(cf + " " + nome + " " + indirizzo + " " + cap + " " + citta + " " + provincia + " " + nome_dest + " " + ind_dest + " " + cap_dest + " " + cit_dest
    				 + " " + prov_dest + " " + p_iva + " " + cod_fisc + " " + pagamento + " " + pag_immediato + " " + scad_gg + " " + scad_mesi + " " + n_rate + " " + banca
    				 + " " + cab + " " + abi + " " + telefono + " " + email + " " + note_1 + " " + note_2 + " " + note_3);
            
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
	
	public static AnagraficaAzienda anagraficaAziendaDaDb(int codice){
    	Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	AnagraficaAzienda anagraficaAzienda = new AnagraficaAzienda();
    	try { 
            pstmt = con.prepareStatement("SELECT * FROM sys.anagrafica_aziende WHERE codice = ?;");

            pstmt.setInt(1, codice);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
            	if(rs.getString("cf").equals(null)) {
            		anagraficaAzienda.setCf("");
            	}else {
            		anagraficaAzienda.setCf(rs.getString("cf"));
            	}
            	
            	anagraficaAzienda.setCodice(rs.getInt("codice"));
            	
            	if(rs.getString("nome").equals(null)) {
            		anagraficaAzienda.setNome("");
            	}else {
            		anagraficaAzienda.setNome(rs.getString("nome"));
            	}
            	if(rs.getString("indirizzo").equals(null)) {
            		anagraficaAzienda.setIndirizzo("");
            	}else {
            		anagraficaAzienda.setIndirizzo(rs.getString("indirizzo"));
            	}
            	if(rs.getString("cap").equals(null)) {
            		anagraficaAzienda.setCap("");
            	}else {
            		anagraficaAzienda.setCap(rs.getString("cap"));
            	}
            	if(rs.getString("citta").equals(null)) {
            		anagraficaAzienda.setCitta("");
            	}else {
            		anagraficaAzienda.setCitta(rs.getString("citta"));
            	}
            	if(rs.getString("provincia").equals(null)) {
            		anagraficaAzienda.setProvincia("");
            	}else {
                	anagraficaAzienda.setProvincia(rs.getString("provincia"));
            	}
            	if(rs.getString("nome_dest").equals(null)) {
            		anagraficaAzienda.setNome_dest("");
            	}else {
            		anagraficaAzienda.setNome_dest(rs.getString("nome_dest"));
            	}
            	if(rs.getString("ind_dest").equals(null)) {
            		anagraficaAzienda.setInd_dest("");
            	}else {
            		anagraficaAzienda.setInd_dest(rs.getString("ind_dest"));
            	}
            	if(rs.getString("cap_dest").equals(null)) {
            		anagraficaAzienda.setCap_dest("");
            	}else {
                	anagraficaAzienda.setCap_dest(rs.getString("cap_dest"));
            	}
            	if(rs.getString("cit_dest").equals(null)) {
            		anagraficaAzienda.setCit_dest("");
            	}else {
            		anagraficaAzienda.setCit_dest(rs.getString("cit_dest"));
            	}
            	if(rs.getString("prov_dest").equals(null)) {
            		anagraficaAzienda.setProv_dest("");
            	}else {
            		anagraficaAzienda.setProv_dest(rs.getString("prov_dest"));
            	}
            	if(rs.getString("prov_dest").equals(null)) {
            		anagraficaAzienda.setProv_dest("");
            	}else {
            		anagraficaAzienda.setP_iva(rs.getString("p_iva"));
            	}
            	if(rs.getString("cod_fisc").equals(null)) {
            		anagraficaAzienda.setCod_fisc("");
            	}else {
            		anagraficaAzienda.setCod_fisc(rs.getString("cod_fisc"));
            	}
            	if(rs.getString("pagamento").equals(null)) {
            		anagraficaAzienda.setPagamento("");
            	}else {
            		anagraficaAzienda.setPagamento(rs.getString("pagamento"));
            	}
            	if(rs.getString("pag_immediato").equals(null)) {
            		anagraficaAzienda.setPag_immediato("");
            	}else {
            		anagraficaAzienda.setPag_immediato(rs.getString("pag_immediato"));
            	}
            	if(rs.getString("scad_gg").equals(null)) {
            		anagraficaAzienda.setScad_gg("");
            	}else {
            		anagraficaAzienda.setScad_gg(rs.getString("scad_gg"));
            	}
            	if(rs.getString("scad_mesi").equals(null)) {
            		anagraficaAzienda.setScad_mesi("");
            	}else {
            		anagraficaAzienda.setScad_mesi(rs.getString("scad_mesi"));
            	}
            	if(rs.getString("n_rate").equals(null)) {
            		anagraficaAzienda.setN_rate("");
            	}else {
            		anagraficaAzienda.setN_rate(rs.getString("n_rate"));
            	}
            	if(rs.getString("banca").equals(null)) {
            		anagraficaAzienda.setBanca("");
            	}else {
            		anagraficaAzienda.setBanca(rs.getString("banca"));
            	}
            	if(rs.getString("cab").equals(null)) {
            		anagraficaAzienda.setCab("");
            	}else {
            		anagraficaAzienda.setCab(rs.getString("cab"));
            	}
            	if(rs.getString("abi").equals(null)) {
            		anagraficaAzienda.setAbi("");
            	}else {
            		anagraficaAzienda.setAbi(rs.getString("abi"));
            	}
            	if(rs.getString("telefono").equals(null)) {
            		anagraficaAzienda.setTelefono("");
            	}else {
            		anagraficaAzienda.setTelefono(rs.getString("telefono"));
            	}
            	if(rs.getString("email").equals(null)) {
            		anagraficaAzienda.setEmail("");
            	}else {
            		anagraficaAzienda.setEmail(rs.getString("email"));
            	}
            	if(rs.getString("note_1").equals(null)) {
            		anagraficaAzienda.setNote_1("");
            	}else {
            		anagraficaAzienda.setNote_1(rs.getString("note_1"));
            	}
            	if(rs.getString("note_2").equals(null)) {
            		anagraficaAzienda.setNote_2("");
            	}else {
            		anagraficaAzienda.setNote_2(rs.getString("note_2"));
            	}
            	if(rs.getString("note_3").equals(null)) {
            		anagraficaAzienda.setNote_3("");
            	}else {
            		anagraficaAzienda.setNote_3(rs.getString("note_3"));
            	}
            	
            	
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
		return anagraficaAzienda;
		
    }
}
