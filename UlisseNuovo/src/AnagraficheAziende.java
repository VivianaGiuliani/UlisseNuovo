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
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
    public AnagraficheAziende(){
    	window = new JFrame();
        window.setSize(1300, 1000);
        window.setTitle("Anagrafiche Azienda");
        window.setResizable(false);
        
        labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
        
        JLabel anagrafiche_clienti_label = new JLabel("Anagrafiche Aziende");
        anagrafiche_clienti_label.setFont(new Font("", Font.BOLD, 20));
        anagrafiche_clienti_label.setBounds(10, 10, 300, 30);
        anagrafiche_clienti_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(anagrafiche_clienti_label);
        
        JLabel cf_label = new JLabel("C/F");
        cf_label.setFont(new Font("", Font.PLAIN, 15));
        cf_label.setBounds(10, 40, 70, 20);
        cf_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cf_label);

        JTextField cf_textbox = new JTextField();
        cf_textbox.setBounds(10, 60, 100, 40);
        cf_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cf_textbox);

        JLabel nome_label = new JLabel("Nome");
        nome_label.setFont(new Font("", Font.PLAIN, 15));
        nome_label.setBounds(120, 40, 50, 20);
        nome_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(nome_label);

        JTextField nome_textbox = new JTextField();
        nome_textbox.setBounds(120, 60, 200, 40);
        nome_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(nome_textbox);

        JLabel indirizzo_label = new JLabel("Indirizzo");
        indirizzo_label.setFont(new Font("", Font.PLAIN, 15));
        indirizzo_label.setBounds(340, 40, 90, 20);
        indirizzo_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(indirizzo_label);

        JTextField indirizzo_textbox = new JTextField();
        indirizzo_textbox.setBounds(340, 60, 180, 40);
        indirizzo_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(indirizzo_textbox);
        
        JLabel cap_label = new JLabel("Cap");
        cap_label.setFont(new Font("", Font.PLAIN, 15));
        cap_label.setBounds(540, 40, 100, 20);
        cap_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cap_label);

        JTextField cap_textbox = new JTextField();
        cap_textbox.setBounds(540, 60, 100, 40);
        cap_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cap_textbox);

        
        JLabel citta_label = new JLabel("Citta");
        citta_label.setFont(new Font("", Font.PLAIN, 15));
        citta_label.setBounds(650, 40, 100, 20);
        citta_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(citta_label);

        JTextField citta_textbox = new JTextField();
        citta_textbox.setBounds(650, 60, 200, 40);
        citta_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(citta_textbox);

        JLabel provincia_label = new JLabel("Provincia");
        provincia_label.setFont(new Font("", Font.PLAIN, 15));
        provincia_label.setBounds(860, 40, 100, 20);
        provincia_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(provincia_label);
        
        JTextField provincia_textbox = new JTextField();
        provincia_textbox.setBounds(860, 60, 120, 40);
        provincia_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(provincia_textbox);
        
        JLabel nome_dest_label = new JLabel("Nome_dest");
        nome_dest_label.setFont(new Font("", Font.PLAIN, 15));
        nome_dest_label.setBounds(990, 40, 100, 20);
        nome_dest_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(nome_dest_label);
        
        JTextField nome_dest_textbox = new JTextField();
        nome_dest_textbox.setBounds(990, 60, 200, 40);
        nome_dest_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(nome_dest_textbox);
        
        JLabel cap_dest_label = new JLabel("Cap_dest");
        cap_dest_label.setFont(new Font("", Font.PLAIN, 15));
        cap_dest_label.setBounds(10, 100, 100, 20);
        cap_dest_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cap_dest_label);
        
        JTextField cap_dest_textbox = new JTextField();
        cap_dest_textbox.setBounds(10, 120, 120, 40);
        cap_dest_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cap_dest_textbox);
        
        JLabel ind_dest_label = new JLabel("Ind_dest");
        ind_dest_label.setFont(new Font("", Font.PLAIN, 15));
        ind_dest_label.setBounds(140, 100, 100, 20);
        ind_dest_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(ind_dest_label);
        
        JTextField ind_dest_textbox = new JTextField();
        ind_dest_textbox.setBounds(140, 120, 120, 40);
        ind_dest_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(ind_dest_textbox);
        
        JLabel cit_dest_label = new JLabel("Cit_dest");
        cit_dest_label.setFont(new Font("", Font.PLAIN, 15));
        cit_dest_label.setBounds(270, 100, 100, 20);
        cit_dest_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cit_dest_label);
        
        JTextField cit_dest_textbox = new JTextField();
        cit_dest_textbox.setBounds(270, 120, 120, 40);
        cit_dest_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cit_dest_textbox);
        
        JLabel prov_dest_label = new JLabel("Prov_dest");
        prov_dest_label.setFont(new Font("", Font.PLAIN, 15));
        prov_dest_label.setBounds(400, 100, 100, 20);
        prov_dest_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(prov_dest_label);
        
        JTextField prov_dest_textbox = new JTextField();
        prov_dest_textbox.setBounds(400, 120, 70, 40);
        prov_dest_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(prov_dest_textbox);
        
        JLabel p_iva_label = new JLabel("P_iva");
        p_iva_label.setFont(new Font("", Font.PLAIN, 15));
        p_iva_label.setBounds(480, 100, 100, 20);
        p_iva_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(p_iva_label);
        
        JTextField p_iva_textbox = new JTextField();
        p_iva_textbox.setBounds(480, 120, 150, 40);
        p_iva_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(p_iva_textbox);
        
        JLabel cod_fisc_label = new JLabel("Cod_fisc");
        cod_fisc_label.setFont(new Font("", Font.PLAIN, 15));
        cod_fisc_label.setBounds(640, 100, 100, 20);
        cod_fisc_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cod_fisc_label);
        
        JTextField cod_fisc_textbox = new JTextField();
        cod_fisc_textbox.setBounds(640, 120, 150, 40);
        cod_fisc_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cod_fisc_textbox);
        
        JLabel pagamento_label = new JLabel("Pagamento");
        pagamento_label.setFont(new Font("", Font.PLAIN, 15));
        pagamento_label.setBounds(800, 100, 100, 20);
        pagamento_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(pagamento_label);
        
        JTextField pagamento_textbox = new JTextField();
        pagamento_textbox.setBounds(800, 120, 150, 40);
        pagamento_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(pagamento_textbox);
        
        JLabel pag_immediato_label = new JLabel("Pag_immediato");
        pag_immediato_label.setFont(new Font("", Font.PLAIN, 15));
        pag_immediato_label.setBounds(960, 100, 170, 20);
        pag_immediato_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(pag_immediato_label);
        
        JTextField pag_immediato_textbox = new JTextField();
        pag_immediato_textbox.setBounds(960, 120, 150, 40);
        pag_immediato_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(pag_immediato_textbox);
        
        JLabel scad_gg_label = new JLabel("Scad_gg");
        scad_gg_label.setFont(new Font("", Font.PLAIN, 15));
        scad_gg_label.setBounds(1120, 100, 100, 20);
        scad_gg_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(scad_gg_label);
        
        JTextField scad_gg_textbox = new JTextField();
        scad_gg_textbox.setBounds(1120, 120, 100, 40);
        scad_gg_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(scad_gg_textbox);
        
        JLabel scad_mesi_label = new JLabel("Scad_mesi");
        scad_mesi_label.setFont(new Font("", Font.PLAIN, 15));
        scad_mesi_label.setBounds(10, 160, 100, 20);
        scad_mesi_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(scad_mesi_label);
        
        JTextField scad_mesi_textbox = new JTextField();
        scad_mesi_textbox.setBounds(10, 180, 100, 40);
        scad_mesi_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(scad_mesi_textbox);
        
        JLabel n_rate_label = new JLabel("N_rate");
        n_rate_label.setFont(new Font("", Font.PLAIN, 15));
        n_rate_label.setBounds(120, 160, 100, 20);
        n_rate_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(n_rate_label);
        
        JTextField n_rate_textbox = new JTextField();
        n_rate_textbox.setBounds(120, 180, 100, 40);
        n_rate_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(n_rate_textbox);
        
        JLabel banca_label = new JLabel("Banca");
        banca_label.setFont(new Font("", Font.PLAIN, 15));
        banca_label.setBounds(230, 160, 100, 20);
        banca_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(banca_label);
        
        JTextField banca_textbox = new JTextField();
        banca_textbox.setBounds(230, 180, 150, 40);
        banca_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(banca_textbox);
        
        JLabel cab_label = new JLabel("Cab");
        cab_label.setFont(new Font("", Font.PLAIN, 15));
        cab_label.setBounds(390, 160, 100, 20);
        cab_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cab_label);
        
        JTextField cab_textbox = new JTextField();
        cab_textbox.setBounds(390, 180, 100, 40);
        cab_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cab_textbox);
        
        JLabel abi_label = new JLabel("Abi");
        abi_label.setFont(new Font("", Font.PLAIN, 15));
        abi_label.setBounds(500, 160, 100, 20);
        abi_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(abi_label);
        
        JTextField abi_textbox = new JTextField();
        abi_textbox.setBounds(500, 180, 100, 40);
        abi_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(abi_textbox);
        
        JLabel telefono_label = new JLabel("Telefono");
        telefono_label.setFont(new Font("", Font.PLAIN, 15));
        telefono_label.setBounds(610, 160, 100, 20);
        telefono_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(telefono_label);
        
        JTextField telefono_textbox = new JTextField();
        telefono_textbox.setBounds(610, 180, 120, 40);
        telefono_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(telefono_textbox);
        
        JLabel email_label = new JLabel("Email");
        email_label.setFont(new Font("", Font.PLAIN, 15));
        email_label.setBounds(740, 160, 100, 20);
        email_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(email_label);
        
        JTextField email_textbox = new JTextField();
        email_textbox.setBounds(740, 180, 120, 40);
        email_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(email_textbox);
        
        JLabel nome_stampa_label = new JLabel("Nome da Stampa");
        nome_stampa_label.setFont(new Font("", Font.PLAIN, 15));
        nome_stampa_label.setBounds(870, 160, 180, 20);
        nome_stampa_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(nome_stampa_label);
        
        JTextField nome_stampa_textbox = new JTextField();
        nome_stampa_textbox.setBounds(870, 180, 180, 40);
        nome_stampa_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(nome_stampa_textbox);
        
        JLabel note_1_label = new JLabel("Note_1");
        note_1_label.setFont(new Font("", Font.PLAIN, 15));
        note_1_label.setBounds(10, 220, 100 , 20);
        note_1_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(note_1_label);
        
        JTextField note_1_textbox = new JTextField();
        note_1_textbox.setBounds(10, 240, 1250, 40);
        note_1_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(note_1_textbox);
        
        JLabel note_2_label = new JLabel("Note_2");
        note_2_label.setFont(new Font("", Font.PLAIN, 15));
        note_2_label.setBounds(10, 280, 100 , 20);
        note_2_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(note_2_label);
        
        JTextField note_2_textbox = new JTextField();
        note_2_textbox.setBounds(10, 300, 1250, 40);
        note_2_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(note_2_textbox);
        
        JLabel note_3_label = new JLabel("Note_3");
        note_3_label.setFont(new Font("", Font.PLAIN, 15));
        note_3_label.setBounds(10, 340, 100 , 20);
        note_3_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(note_3_label);
        
        JTextField note_3_textbox = new JTextField();
        note_3_textbox.setBounds(10, 360, 1250, 40);
        note_3_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(note_3_textbox);
        
        JButton modifica_button = new JButton("Modifica");
        modifica_button.setBounds(10, 430, 200, 30);
        modifica_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(modifica_button);

        JButton alfabetico_button = new JButton("Alfabetico");
        alfabetico_button.setBounds(220, 430, 100, 40);
        alfabetico_button.setBackground(new java.awt.Color(0,153,0));
        labelSfondo.add(alfabetico_button);

        JButton naturale_button = new JButton("Naturale");
        naturale_button.setBounds(330, 430, 100, 40);
        naturale_button.setBackground(new java.awt.Color(0,153,0));
        labelSfondo.add(naturale_button);

        
        JButton aggiungi_button = new JButton("Aggiungi");
        aggiungi_button.setBounds(440, 430, 100, 40);
        aggiungi_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(aggiungi_button);

        JButton elimina_button = new JButton("Elimina");
        elimina_button.setBounds(550, 430, 100, 40);
        elimina_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(elimina_button);
        
        JButton stampa_button = new JButton("Stampa");
        stampa_button.setBounds(660, 430, 100, 40);
        stampa_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(stampa_button);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 500, 1250, 450);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1250, 450);

        String[] columnNames = {"C/F","Codice", "Nome", "Indirizzo", "CAP", "Città", "Provincia", "Nome_dest", "Ind_dest", "Cap_dest", "Cit_dest", "Prov_dest", "P_iva", 
        		"Cod_fisc", "Pagamento", "Pag_immediato", "Scad_gg", "Scad_mesi", "N_rate", "Banca", "Cab", "Abi", "Telefono", "Email", "Note_1", "Note_2", "Note_3"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for(int i = 0; i < 26; i++) {
        	table.getColumnModel().getColumn(i).setPreferredWidth(100);
        }
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        
        stampa_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	/*ReportFornitori r = new ReportFornitori();
            	try {
					r.generaReport();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
            }
    	});
        
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
						nome_stampa_textbox.getText(), note_1_textbox.getText(), note_2_textbox.getText(), note_3_textbox.getText());
			
				
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
				nome_stampa_textbox.setText(null);
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
    	
    	modifica_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificaDatiAnagraficaAzienda m = new ModificaDatiAnagraficaAzienda();
			}
    	});
        
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
    	String nome_stampa = anagraficaAzienda.getNome_stampa();
    	String note_1 = anagraficaAzienda.getNote_1();
    	String note_2 = anagraficaAzienda.getNote_2();
    	String note_3 = anagraficaAzienda.getNote_3();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.anagrafica_aziende (cf, codice, nome, indirizzo, cap, citta, provincia, "
    				+ "nome_dest, ind_dest, cap_dest, cit_dest, prov_dest, p_iva, cod_fisc, pagamento, pag_immediato, scad_gg, scad_mesi, n_rate, banca,"
    				+ "cab, abi, telefono, email, nome_stampa, note_1, note_2, note_3) VALUE \r\n"
    				+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
    		pstmt.setString(25, nome_stampa);
    		pstmt.setString(26, note_1);
    		pstmt.setString(27, note_2);
    		pstmt.setString(28, note_3);
    		
    		
    		
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