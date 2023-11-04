import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Classi.Database;
import Classi.RecuperoCategorie;
import Oggetti.Articolo;

public class Articoli {
	
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	
    public Articoli() {
    	
        window = new JFrame();
        window.setSize(1300, 650);
        window.setTitle("Articoli");
        window.setResizable(false);

        labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
        
        JLabel gestione_articoli_label = new JLabel("Gestione Articoli");
        gestione_articoli_label.setFont(new Font("", Font.BOLD, 20));
        gestione_articoli_label.setBounds(10, 15, 200, 30);
        gestione_articoli_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(gestione_articoli_label);

        JButton aumento_prezzi_button = new JButton("Aumento Prezzi");
        aumento_prezzi_button.setBounds(190, 10, 150, 40);
        aumento_prezzi_button.setBackground(new java.awt.Color(193,255,57));
        labelSfondo.add(aumento_prezzi_button);

        JButton modifica_sconto1_button = new JButton("Modifica sconto 1");
        modifica_sconto1_button.setBounds(345, 10, 150, 40);
        modifica_sconto1_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(modifica_sconto1_button);

        JButton modifica_sconto2_button = new JButton("Modifica sconto 2");
        modifica_sconto2_button.setBounds(500, 10, 150, 40);
        modifica_sconto2_button.setBackground(new java.awt.Color(255,209,110));
        labelSfondo.add(modifica_sconto2_button);

        JButton sconto_fascia_button = new JButton("Sconto Fascia");
        sconto_fascia_button.setBounds(655, 10, 120, 40);
        sconto_fascia_button.setBackground(new java.awt.Color(231, 177, 181));
        labelSfondo.add(sconto_fascia_button);

        JButton artxforn_button = new JButton("Art. X Forn");
        artxforn_button.setBounds(780, 10, 100, 40);
        artxforn_button.setBackground(new java.awt.Color(145, 177, 181));
        labelSfondo.add(artxforn_button);
        
        JButton modifica_button = new JButton("Modifica Articolo");
        modifica_button.setBounds(980, 10, 200, 40);
        modifica_button.setBackground(new java.awt.Color(250, 50, 181));
        labelSfondo.add(modifica_button);

        JButton ordine_barcode_button = new JButton("Ordine barcode");
        ordine_barcode_button.setBounds(1020, 250, 130, 40);
        ordine_barcode_button.setBackground(new java.awt.Color(145, 210, 135));
        labelSfondo.add(ordine_barcode_button);

        JButton ordine_barcode_decresc_button = new JButton("Ultimo articolo elenco");
        ordine_barcode_decresc_button.setBounds(1020, 300, 200, 40);
        ordine_barcode_decresc_button.setBackground(new java.awt.Color(145, 210, 135));
        labelSfondo.add(ordine_barcode_decresc_button);
        
        JLabel trova_codice_label = new JLabel("<html> Inserisci il codice a barre del<br /> articolo da trovare</html>");
        trova_codice_label.setFont(new Font("", Font.BOLD, 15));
        trova_codice_label.setBounds(1020, 350, 400, 50);
        trova_codice_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(trova_codice_label);

        JButton trova_riga_button = new JButton("Trova");
        trova_riga_button.setBounds(1020, 400, 100, 40);
        trova_riga_button.setBackground(new java.awt.Color(241, 255, 135));
        labelSfondo.add(trova_riga_button);
        
        JTextField trova_riga_textbox = new JTextField();
        trova_riga_textbox.setBounds(1130, 400, 120, 40);
        trova_riga_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(trova_riga_textbox);

        JButton tabella_categorie_button = new JButton("Tabella Categorie");
        tabella_categorie_button.setBounds(10, 60, 150, 40);
        tabella_categorie_button.setBackground(new java.awt.Color(142, 227, 233));
        labelSfondo.add(tabella_categorie_button);
        
        JButton tabella_fornitori_button = new JButton("Tabella Fornitori");
        tabella_fornitori_button.setBounds(170, 60, 150, 40);
        tabella_fornitori_button.setBackground(new java.awt.Color(142, 227, 233));
        labelSfondo.add(tabella_fornitori_button);

        JButton converti_VF_button = new JButton("Converti V/F");
        converti_VF_button.setBounds(330, 60, 150, 40);
        converti_VF_button.setBackground(new java.awt.Color(54, 150, 255));
        labelSfondo.add(converti_VF_button);

        JCheckBox vedi_costo_button = new JCheckBox("Vedi Costo");
        vedi_costo_button.setBounds(855, 60, 150, 40);
        vedi_costo_button.setOpaque(false);
        vedi_costo_button.setContentAreaFilled(false);
        vedi_costo_button.setBorderPainted(false);
        vedi_costo_button.setFont(new Font("", Font.BOLD, 15));
        vedi_costo_button.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(vedi_costo_button);
        
        JLabel categorie_label = new JLabel("Categorie");
        categorie_label.setFont(new Font("", Font.PLAIN, 15));
        categorie_label.setBounds(10, 100, 100, 20);
        categorie_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(categorie_label);
        
        ArrayList<String> risultatoCategorie = categorieStr();
        String[] categorie_values = new String[risultatoCategorie.size()];
        categorie_values = risultatoCategorie.toArray(categorie_values);
        JComboBox<String> categorie_combobox = new JComboBox<>(categorie_values);
        categorie_combobox.setBounds(10, 120, 150, 40);
        labelSfondo.add(categorie_combobox);

        JLabel codice_calcolato_label = new JLabel("Codice Calcolato");
        codice_calcolato_label.setFont(new Font("", Font.PLAIN, 15));
        codice_calcolato_label.setBounds(170, 90, 150, 40);
        codice_calcolato_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(codice_calcolato_label);
        
        
        ArrayList<Integer> risultatoPkCategorie = pkCategorie();
        JTextField codice_calcolato_textbox = new JTextField();
        codice_calcolato_textbox.setFont(new Font("", Font.PLAIN, 15));
        codice_calcolato_textbox.setBounds(170, 120, 150, 40);
        codice_calcolato_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(codice_calcolato_textbox);
        
        categorie_combobox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	int cliccatoPk = categorie_combobox.getSelectedIndex();
            	System.out.println("Cliccato? " + cliccatoPk);
            	codice_calcolato_textbox.setText(null);
            	System.out.println(risultatoPkCategorie.get(cliccatoPk).toString());
            	int result = categoriaPresente(risultatoPkCategorie.get(cliccatoPk).toString());
                System.out.println("Result: " + result);
                int barcode = calcoloBarcode(result, risultatoPkCategorie.get(cliccatoPk).toString());
                codice_calcolato_textbox.setText(String.valueOf(barcode));
            }
        });
        
        
        
        JLabel fornitori_label = new JLabel("Fornitori");
        fornitori_label.setFont(new Font("", Font.PLAIN, 15));
        fornitori_label.setBounds(330, 100, 100, 20);
        fornitori_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(fornitori_label);

        ArrayList<String> risultatoFornitori = fornitoriStr();
        String[] fornitori_values = new String[risultatoFornitori.size()];
        fornitori_values = risultatoFornitori.toArray(fornitori_values);
        JComboBox<String> fornitori_combobox = new JComboBox<>(fornitori_values);
        fornitori_combobox.setBounds(330, 120, 150, 40);
        labelSfondo.add(fornitori_combobox);

        
        JLabel cod_for_label = new JLabel("Cod.For");
        cod_for_label.setFont(new Font("", Font.PLAIN, 15));
        cod_for_label.setBounds(490, 100, 100, 20);
        cod_for_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(cod_for_label);

        
        ArrayList<String> risultatoIdFornitore = fornitoriId();
        JTextField cod_for_textbox = new JTextField();
        cod_for_textbox.setFont(new Font("", Font.PLAIN, 15));
        cod_for_textbox.setBounds(490, 120, 160, 40);
        cod_for_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(cod_for_textbox);

        
        JLabel descrizione_label = new JLabel("Descrizione");
        descrizione_label.setFont(new Font("", Font.PLAIN, 15));
        descrizione_label.setBounds(660, 100, 100, 20);
        descrizione_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(descrizione_label);

        JTextField descrizione_textbox = new JTextField();
        descrizione_textbox.setBounds(660, 120, 370, 40);
        descrizione_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(descrizione_textbox);

        JLabel peso_label = new JLabel("Peso");
        peso_label.setFont(new Font("", Font.PLAIN, 15));
        peso_label.setBounds(10, 170, 100, 20);
        peso_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(peso_label);

        JTextField peso_textbox = new JTextField();
        peso_textbox.setBounds(10, 190, 100, 40);
        peso_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(peso_textbox);

        JLabel caratura_label = new JLabel("Caratura");
        caratura_label.setFont(new Font("", Font.PLAIN, 15));
        caratura_label.setBounds(120, 170, 100, 20);
        caratura_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(caratura_label);

        JTextField caratura_textbox = new JTextField();
        caratura_textbox.setBounds(120, 190, 100, 40);
        caratura_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(caratura_textbox);

        JLabel costo_label = new JLabel("Costo");
        costo_label.setFont(new Font("", Font.PLAIN, 15));
        costo_label.setBounds(230, 170, 100, 20);
        costo_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(costo_label);
        
        JTextField costo_textbox = new JTextField();
        costo_textbox.setBounds(230, 190, 100, 40);
        costo_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(costo_textbox);

        JLabel prezzo_label = new JLabel("Prezzo");
        prezzo_label.setFont(new Font("", Font.PLAIN, 15));
        prezzo_label.setBounds(340, 170, 100, 20);
        prezzo_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(prezzo_label);

        JTextField prezzo_textbox = new JTextField();
        prezzo_textbox.setBounds(340, 190, 100, 40);
        prezzo_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(prezzo_textbox);

        JLabel sconto1_label = new JLabel("Sconto 1");
        sconto1_label.setFont(new Font("", Font.PLAIN, 15));
        sconto1_label.setBounds(450, 170, 100, 20);
        sconto1_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(sconto1_label);

        JTextField sconto1_textbox = new JTextField();
        sconto1_textbox.setBounds(450, 190, 100, 40);
        sconto1_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(sconto1_textbox);

        JLabel sconto2_label = new JLabel("Sconto 2");
        sconto2_label.setFont(new Font("", Font.PLAIN, 15));
        sconto2_label.setBounds(560, 170, 100, 20);
        sconto2_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(sconto2_label);

        JTextField sconto2_textbox = new JTextField();
        sconto2_textbox.setBounds(560, 190, 100, 40);
        sconto2_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(sconto2_textbox);

        JLabel fv_label = new JLabel("F-V");
        fv_label.setFont(new Font("", Font.PLAIN, 15));
        fv_label.setBounds(670, 170, 100, 20);
        fv_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(fv_label);

        JTextField fv_textbox = new JTextField();
        fv_textbox.setBounds(670, 190, 100, 40);
        fv_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(fv_textbox);

        JButton inserisci_codice_button = new JButton("Inserisci articolo");
        inserisci_codice_button.setBounds(10, 240, 130, 40);
        inserisci_codice_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(inserisci_codice_button);
     

        JButton elimina_articolo_button = new JButton("Elimina articolo");
        elimina_articolo_button.setBounds(150, 240, 130, 40);
        elimina_articolo_button.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(elimina_articolo_button);
        

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 290, 1000, 280);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1000, 280);

        String[] columnNames = {"Barcode",  "Cod_For", "Cod_art_for", "Giacenza", "Descrizione", "Peso",
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
        
        ArrayList<Articolo> articoli = articoliDaDb();
    	System.out.println("Articoli:" + articoli);
    	for(int i=0; i < articoli.size(); i++) {
    		model.addRow(new Object[] {articoli.get(i).getBarcode(),  articoli.get(i).getCod_for(), articoli.get(i).getCfor(), 
    				articoli.get(i).getGiacenza(), articoli.get(i).getDescrizione(), articoli.get(i).getPeso(), articoli.get(i).getCaratura(), 
        			articoli.get(i).getPr_unit(), articoli.get(i).getTot_giac(), articoli.get(i).getSconto1(), articoli.get(i).getSconto2(),
        			articoli.get(i).getCosto(), articoli.get(i).getFv()});
    	}
    	
        modifica_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificaDatiArticoli m = new ModificaDatiArticoli();
            }
        });
    	
        inserisci_codice_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	int cliccatoPk = categorie_combobox.getSelectedIndex();
            	int cliccatoFornitore = fornitori_combobox.getSelectedIndex();
            	
            	if(peso_textbox.getText().isEmpty()) {
            		peso_textbox.setText(String.valueOf(0.0));
            	}
            	if(caratura_textbox.getText().isEmpty()) {
            		caratura_textbox.setText(String.valueOf(0.0));
            	}
            	if(sconto1_textbox.getText().isEmpty()) {
            		sconto1_textbox.setText(String.valueOf(0));
            	}
            	if(sconto2_textbox.getText().isEmpty()) {
            		sconto2_textbox.setText(String.valueOf(0));
            	}
            	if(costo_textbox.getText().isEmpty()) {
            		costo_textbox.setText(String.valueOf(0.0));
            	}
            	
            	
            	Articolo articolo = new Articolo(codice_calcolato_textbox.getText(), cod_for_textbox.getText(), 
            			risultatoIdFornitore.get(cliccatoFornitore).toString(), 0, descrizione_textbox.getText(), 
            			Double.parseDouble(peso_textbox.getText()), Double.parseDouble(caratura_textbox.getText()), 
            			Integer.parseInt(prezzo_textbox.getText()), 0, 
            			Integer.parseInt(sconto1_textbox.getText()), Integer.parseInt(sconto2_textbox.getText()), 
            			Double.parseDouble(costo_textbox.getText()), fv_textbox.getText(), risultatoPkCategorie.get(cliccatoPk));
          
            	
            	
            	model.addRow(new Object[] {articolo.getBarcode(), articolo.getCod_for(), articolo.getCfor(), 
            			articolo.getGiacenza(), articolo.getDescrizione(), articolo.getPeso(), articolo.getCaratura(), 
            			articolo.getPr_unit(), articolo.getTot_giac(), articolo.getSconto1(), articolo.getSconto2(),
            			articolo.getCosto(), articolo.getFv(), articolo.getCod_categoria()});
            	System.out.println(articolo.toString());
            	inserisciArticoloDb(articolo);
            	
            	
            	descrizione_textbox.setText(null);
            	peso_textbox.setText(null);
            	caratura_textbox.setText(null);
            	costo_textbox.setText(null);
            	prezzo_textbox.setText(null);
            	sconto1_textbox.setText(null);
            	sconto2_textbox.setText(null);
            	fv_textbox.setText(null);
            	
            	int cliccatoPk1 = categorie_combobox.getSelectedIndex();
            	codice_calcolato_textbox.setText(null);
            	int result = categoriaPresente(risultatoPkCategorie.get(cliccatoPk1).toString());
                System.out.println("Result: " + result);
                int barcode = calcoloBarcode(result, risultatoPkCategorie.get(cliccatoPk1).toString());
                codice_calcolato_textbox.setText(String.valueOf(barcode));
            }
        });
        
        elimina_articolo_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = table.getSelectedRow();
            	String value = (String) table.getValueAt(table.getSelectedRow() , table.getSelectedColumn());
            	System.out.println("Barcode riga da eliminare " + value);
            	model.removeRow(row);
            	eliminaRigaDb(value);
            	
            }
        });
        
        vedi_costo_button.addItemListener((ItemListener) new ItemListener() {
        	public void itemStateChanged(ItemEvent ev) {
          	  Object item = ev.getItem();
          	  if (ev.getStateChange() == ItemEvent.DESELECTED) {
                  table.getColumnModel().getColumn(11).setMinWidth(0);
                  table.getColumnModel().getColumn(11).setMaxWidth(0);
                  table.getColumnModel().getColumn(11).setWidth(0);
                  table.getColumnModel().getColumn(11).setPreferredWidth(0);
                  
          	  } else {
	          	  table.getColumnModel().getColumn(11).setMinWidth(80);
	              table.getColumnModel().getColumn(11).setMaxWidth(80);
	              table.getColumnModel().getColumn(11).setWidth(80);
                  table.getColumnModel().getColumn(11).setPreferredWidth(80);
          	  }
          	}
        });
        
        tabella_categorie_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TabellaCategorie t = new TabellaCategorie();
            }
         });
           
        aumento_prezzi_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AumentoPrezzi a = new AumentoPrezzi();
            }
        });
        
        modifica_sconto1_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificaSconto1 m = new ModificaSconto1();
            }
        });
        
        modifica_sconto2_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ModificaSconto2 m = new ModificaSconto2();
            }
        });
        
        ordine_barcode_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	ArrayList<Articolo> articoli = articoliDaDb();
            	for(int i=0; i < articoli.size(); i++) {
            		model.addRow(new Object[] {articoli.get(i).getBarcode(), articoli.get(i).getCod_for(), articoli.get(i).getCfor(), 
            				articoli.get(i).getGiacenza(), articoli.get(i).getDescrizione(), articoli.get(i).getPeso(), articoli.get(i).getCaratura(), 
                			articoli.get(i).getPr_unit(), articoli.get(i).getTot_giac(), articoli.get(i).getSconto1(), articoli.get(i).getSconto2(),
                			articoli.get(i).getCosto(), articoli.get(i).getFv()});
            	}
            }
        });
        
        ordine_barcode_decresc_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int row = model.getRowCount();
            	table.getSelectionModel().setSelectionInterval(row-1, row-1);
            	table.scrollRectToVisible(table.getCellRect(row-1, row-1, false));


            }
        });
       
        trova_riga_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	Articolo articolo = articoliDaDbTab(trova_riga_textbox.getText());
            	model.addRow(new Object[] {articolo.getBarcode(), articolo.getCfor(), articolo.getCod_for(), 
            			articolo.getGiacenza(), articolo.getDescrizione(), articolo.getPeso(), articolo.getCaratura(), 
            			articolo.getPr_unit(), articolo.getTot_giac(), articolo.getSconto1(), articolo.getSconto2(),
            			articolo.getCosto(), articolo.getFv()});
            }
        });
        
        converti_VF_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	convertiVF();
            	model.setRowCount(0);
            	ArrayList<Articolo> articoli = articoliDaDb();
            	for(int i=0; i < articoli.size(); i++) {
            		model.addRow(new Object[] {articoli.get(i).getBarcode(),  articoli.get(i).getCod_for(), articoli.get(i).getCfor(),
            				articoli.get(i).getGiacenza(), articoli.get(i).getDescrizione(), articoli.get(i).getPeso(), articoli.get(i).getCaratura(), 
                			articoli.get(i).getPr_unit(), articoli.get(i).getTot_giac(), articoli.get(i).getSconto1(), articoli.get(i).getSconto2(),
                			articoli.get(i).getCosto(), articoli.get(i).getFv()});
            	}
            }
        });
        
        artxforn_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ArtXForn a = new ArtXForn();
            }
        });
        
        tabella_fornitori_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TabellaFornitori t = new TabellaFornitori();
            }
        });
        
        sconto_fascia_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ScontoFascia s = new ScontoFascia();
            }
        });
        
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    
    
    public static int categoriaPresente(String codiceCategoria) {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
        System.out.println("Codice Categoria: " + codiceCategoria);
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            pstmt = con.prepareStatement("SELECT * FROM sys.articoli WHERE cod_categoria = ?;");
            pstmt.setInt(1, Integer.parseInt(codiceCategoria));
            rs = pstmt.executeQuery();
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
		
    	
    	return result;
    }
    
    
    public static int calcoloBarcode(int result, String codiceCategoria) {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
        int barcode=0;
        System.out.println("Result " + result + " Codice Categoria " + codiceCategoria);
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
    			pstmt = con.prepareStatement("SELECT barcode as last_barcode FROM sys.articoli WHERE cod_categoria = ? ORDER BY barcode DESC LIMIT 1;"); 	           
                pstmt.setInt(1, Integer.parseInt(codiceCategoria));
                System.out.println("query eseguita barcode");
                rs = pstmt.executeQuery();
                while (rs.next()) {
                	barcode = rs.getInt("last_barcode");
                	System.out.println("Barcode arrivato: " +barcode);
                	barcode = barcode + 1;
                	System.out.println("Barcode modificato: " +barcode);
                }
                
                
            } catch (SQLException ex) {
            	ex.printStackTrace();

            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
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
    	}else {
    		String newBarcode = codiceCategoria + "0000";
    		barcode = Integer.parseInt(newBarcode);
    	}
    	
		
    	
    	return barcode;
    }
    
    public static ArrayList<Integer> pkCategorie(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Integer> pk = new ArrayList<Integer>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY categoria ASC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	int id = rs.getInt("pk"); 
                pk.add(id);
                System.out.println(pk);
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
		return pk;
		
    }
    
    public static ArrayList<String> categorieStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> categorie = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY categoria ASC;");               
            System.out.println("query eseguita");
            while (rs.next()) {
                String categoria = rs.getString("categoria"); 
            	categorie.add(categoria);    
            	System.out.println(categorie);
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
    
    public static ArrayList<String> fornitoriStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> fornitori = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.fornitori ORDER BY fornitore ASC;");                 
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
    
    public static ArrayList<String> fornitoriId(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> fornitoreId = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.fornitori ORDER BY fornitore ASC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String id = rs.getString("id"); 
            	fornitoreId.add(id);
                System.out.println(id);
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
		return fornitoreId;
		
    }
    
    public static void inserisciArticoloDb(Articolo articolo) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String barcode = articolo.getBarcode();
    	String cfor = articolo.getCfor() ;
    	String codfor = articolo.getCod_for();
    	int giacenza = articolo.getGiacenza();
    	String descrizione = articolo.getDescrizione();
    	double peso = articolo.getPeso(); 
    	double caratura = articolo.getCaratura();
    	double pr_unit = articolo.getPr_unit();
    	int tot_giacenza = articolo.getTot_giac();
    	int sc_1 = articolo.getSconto1();
    	int sc_2 = articolo.getSconto2();
    	double costo = articolo.getCosto();
    	String fv = articolo.getFv();
    	int cod_categoria = articolo.getCod_categoria();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.articoli (barcode, cfor, codfor, giacenza, "
    				+ "descrizione, peso, caratura, pr_unit, tot_giacenza, sc_1, sc_2, costo, tot_peso, tot_inv, fv, slot_costi, tot_costo, cod_categoria) VALUE \r\n"
    				+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    		pstmt.setString(1, barcode );
    		pstmt.setString(2, cfor);
    		pstmt.setString(3, codfor);
    		pstmt.setInt(4, giacenza);
    		pstmt.setString(5, descrizione);
    		pstmt.setDouble(6, peso);
    		pstmt.setDouble(7, caratura);
    		pstmt.setDouble(8, pr_unit);
    		pstmt.setInt(9, 0);
    		pstmt.setInt(10, sc_1);
    		pstmt.setInt(11, sc_2);
    		pstmt.setDouble(12, costo);
    		pstmt.setInt(13, 0);
    		pstmt.setInt(14, 0);
    		pstmt.setString(15, fv);
    		pstmt.setInt(16, 0);
    		pstmt.setInt(17, 0);
    		pstmt.setInt(18, cod_categoria);
    		
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
    
    public static Articolo articoliDaDbTab(String barcode){
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
    
    public static void eliminaRigaDb(String value) {
    	String SQL = "DELETE FROM sys.articoli WHERE barcode = ? ";
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
    
    public static void convertiVF(){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	try {
            st = con.prepareStatement("UPDATE sys.articoli SET fv = ? WHERE fv = ?;");
            st.setString(1, "F");
            st.setString(2, "V");
            st.executeUpdate();
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