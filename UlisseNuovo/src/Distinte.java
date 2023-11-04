import java.awt.Font;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Classi.ReportDistinte;
import Oggetti.Articolo;
import Oggetti.Cliente;
import Oggetti.StampaDistintaDatiFissi;
import Oggetti.StampaDistintaDatiVendita;
import Oggetti.Vendita;
import net.sf.jasperreports.engine.JRException;

public class Distinte {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	public Distinte(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		DecimalFormat dc = new DecimalFormat("0.00");
		
		window = new JFrame();
		window.setSize(1250, 750);
		window.setTitle("Distinte");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);

        JButton aggiungi_valori_button = new JButton("Aggiungi riga - Trasferisci valori");
        aggiungi_valori_button.setBounds(10, 10, 1210, 30);
        aggiungi_valori_button.setBackground(new java.awt.Color(132, 249, 58));
        aggiungi_valori_button.setFont(new Font("", Font.BOLD, 15));
        labelSfondo.add(aggiungi_valori_button);

        JLabel barcode_label = new JLabel("Barcode");
        barcode_label.setFont(new Font("", Font.PLAIN, 15));
        barcode_label.setForeground(new java.awt.Color(255,255,255));
        barcode_label.setBounds(10, 52, 100, 20);
        labelSfondo.add(barcode_label);

        JTextArea barcode_textbox = new JTextArea();
        barcode_textbox.setBounds(10, 70, 150, 40);
        barcode_textbox.setFont(new Font("", Font.PLAIN, 20));
        barcode_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(barcode_textbox);

        JLabel descrizione_label = new JLabel("Descrizione");
        descrizione_label.setFont(new Font("", Font.PLAIN, 15));
        descrizione_label.setBounds(170, 52, 150, 20);
        descrizione_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(descrizione_label);

        JTextArea descrizione_textbox = new JTextArea();
        descrizione_textbox.setBounds(170, 70, 290, 40);
        descrizione_textbox.setFont(new Font("", Font.PLAIN, 20));
        descrizione_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(descrizione_textbox);

        JLabel quantita_label = new JLabel("Quant.");
        quantita_label.setFont(new Font("", Font.PLAIN, 15));
        quantita_label.setBounds(470, 52, 50, 20);
        quantita_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(quantita_label);

        JTextArea quantita_textbox = new JTextArea("1");
        quantita_textbox.setBounds(470, 70, 60, 40);
        quantita_textbox.setFont(new Font("", Font.PLAIN, 20));
        quantita_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(quantita_textbox);

        JLabel peso_label = new JLabel("Peso");
        peso_label.setFont(new Font("", Font.PLAIN, 15));
        peso_label.setBounds(540, 52, 50, 20);
        peso_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(peso_label);

        JTextArea peso_textbox = new JTextArea();
        peso_textbox.setBounds(540, 70, 80, 40);
        peso_textbox.setFont(new Font("", Font.PLAIN, 20));
        peso_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(peso_textbox);

        JLabel caratura_label = new JLabel("Carat.");
        caratura_label.setFont(new Font("", Font.PLAIN, 15));
        caratura_label.setBounds(630, 52, 100, 20);
        caratura_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(caratura_label);

        JTextArea caratura_textbox = new JTextArea();
        caratura_textbox.setBounds(630, 70, 100, 40);
        caratura_textbox.setFont(new Font("", Font.PLAIN, 20));
        caratura_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(caratura_textbox);

        JLabel prezzo_unitario_label = new JLabel("Pr.unit");
        prezzo_unitario_label.setFont(new Font("", Font.PLAIN, 15));
        prezzo_unitario_label.setBounds(740, 52, 100, 20);
        prezzo_unitario_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(prezzo_unitario_label);

        JTextArea prezzo_unitario_textbox = new JTextArea();
        prezzo_unitario_textbox.setBounds(740, 70, 100, 40);
        prezzo_unitario_textbox.setFont(new Font("", Font.PLAIN, 20));
        prezzo_unitario_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(prezzo_unitario_textbox);

        JLabel tot_riga_label = new JLabel("Tot.riga");
        tot_riga_label.setFont(new Font("", Font.PLAIN, 15));
        tot_riga_label.setBounds(850, 52, 100, 20);
        tot_riga_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(tot_riga_label);

        JTextArea tot_riga_textbox = new JTextArea();
        tot_riga_textbox.setBounds(850, 70, 100, 40);
        tot_riga_textbox.setFont(new Font("", Font.PLAIN, 20));
        tot_riga_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(tot_riga_textbox);

        JLabel sconto1_label = new JLabel("Sc.1");
        sconto1_label.setFont(new Font("", Font.PLAIN, 15));
        sconto1_label.setBounds(960, 52, 100, 20);
        sconto1_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(sconto1_label);

        JTextArea sconto1_textbox = new JTextArea();
        sconto1_textbox.setBounds(960, 70, 100, 40);
        sconto1_textbox.setFont(new Font("", Font.PLAIN, 20));
        sconto1_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(sconto1_textbox);

        JLabel sconto2_label = new JLabel("Sc.2");
        sconto2_label.setFont(new Font("", Font.PLAIN, 15));
        sconto2_label.setBounds(1070, 52, 100, 20);
        sconto2_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(sconto2_label);

        JTextArea sconto2_textbox = new JTextArea();
        sconto2_textbox.setBounds(1070, 70, 100, 40);
        sconto2_textbox.setFont(new Font("", Font.PLAIN, 20));
        sconto2_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(sconto2_textbox);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 125, 1210, 200);
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1210, 200);

        String[] columnNames = {"Barcode", "Descrizione", "Quant.", "Peso", "Carat.",
        		"Pr_unit", "Tot.Riga", "Sc.1", "Sc.2", "Tot.Scont."};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(9).setCellRenderer(rightRenderer);
        

        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        
        
		JButton cancella_riga_button = new JButton("Cancella Riga");
		cancella_riga_button.setBounds(10, 330, 1210, 30);
		cancella_riga_button.setVisible(true);
		cancella_riga_button.setBackground(new java.awt.Color(152, 9, 3));
		cancella_riga_button.setFont(new Font("", Font.BOLD, 15));
		cancella_riga_button.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(cancella_riga_button);
		
		JTextArea tessera_cliente_textbox = new JTextArea();
		tessera_cliente_textbox.setBounds(10, 370, 120, 40);
		tessera_cliente_textbox.setVisible(true);
		tessera_cliente_textbox.setFont(new Font("", Font.PLAIN, 20));
		tessera_cliente_textbox.setBackground(new java.awt.Color(210, 254, 132));
		labelSfondo.add(tessera_cliente_textbox);
        
		JTextArea nome_cliente_textbox = new JTextArea();
		nome_cliente_textbox.setBounds(135, 370, 150, 40);
		nome_cliente_textbox.setVisible(true);
		nome_cliente_textbox.setFont(new Font("", Font.PLAIN, 20));
		nome_cliente_textbox.setBackground(new java.awt.Color(215, 193, 132));
		labelSfondo.add(nome_cliente_textbox);
		
		JButton usa_punti_button = new JButton("Usa punti");
		usa_punti_button.setBounds(365, 370, 100, 20);
		usa_punti_button.setVisible(true);
		usa_punti_button.setBackground(new java.awt.Color(255, 249, 0));
		labelSfondo.add(usa_punti_button);
		
		JButton parizale_giornaliero_button = new JButton("Parziale giornaliero");
		parizale_giornaliero_button.setBounds(470, 370, 150, 20);
		parizale_giornaliero_button.setVisible(true);
		parizale_giornaliero_button.setBackground(new java.awt.Color(0, 255, 255));
		labelSfondo.add(parizale_giornaliero_button);
		
		JTextArea punto_domanda_label = new JTextArea("?");
		punto_domanda_label.setFont(new Font("", Font.PLAIN, 40));
		punto_domanda_label.setBounds(10, 415, 275, 45);
		punto_domanda_label.setVisible(true);
		punto_domanda_label.setBackground(new java.awt.Color(106, 177, 24));
		labelSfondo.add(punto_domanda_label);
		
		JLabel punti_prec_label = new JLabel("Punti prec.");
		punti_prec_label.setFont(new Font("", Font.PLAIN, 15));
		punti_prec_label.setBounds(300, 400, 90, 20);
		punti_prec_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(punti_prec_label);
		
        JTextArea punto_prec_textbox = new JTextArea();
        punto_prec_textbox.setBounds(300, 420, 80, 40);
        punto_prec_textbox.setVisible(true);
        punto_prec_textbox.setFont(new Font("", Font.PLAIN, 20));
        punto_prec_textbox.setBackground(new java.awt.Color(182, 210, 7));
        labelSfondo.add(punto_prec_textbox);
        
		JLabel val_in_euro_label = new JLabel("Val in €");
		val_in_euro_label.setFont(new Font("", Font.PLAIN, 15));
		val_in_euro_label.setBounds(385, 400, 90, 20);
		val_in_euro_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(val_in_euro_label);
		
        JTextArea val_in_euro_textbox = new JTextArea();
        val_in_euro_textbox.setBounds(385, 420, 80, 40);
        val_in_euro_textbox.setVisible(true);
        val_in_euro_textbox.setFont(new Font("", Font.PLAIN, 20));
        val_in_euro_textbox.setBackground(new java.awt.Color(182, 255, 255));
        labelSfondo.add(val_in_euro_textbox);
		
		JLabel punti_scal_label = new JLabel("Punti scal.");
		punti_scal_label.setFont(new Font("", Font.PLAIN, 15));
		punti_scal_label.setBounds(470, 400, 90, 20);
		punti_scal_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(punti_scal_label);
		
        JTextArea punti_scal_textbox = new JTextArea();
        punti_scal_textbox.setBounds(470, 420, 80, 40);
        punti_scal_textbox.setVisible(true);
        punti_scal_textbox.setFont(new Font("", Font.PLAIN, 20));
        punti_scal_textbox.setBackground(new java.awt.Color(182, 210, 7));
        labelSfondo.add(punti_scal_textbox);
		
		JLabel val_buono_label = new JLabel("Val. Buono");
		val_buono_label.setFont(new Font("", Font.PLAIN, 15));
		val_buono_label.setBounds(555, 400, 90, 20);
		val_buono_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(val_buono_label);
		
        JTextArea val_buono_textbox = new JTextArea();
        val_buono_textbox.setBounds(555, 420, 80, 40);
        val_buono_textbox.setVisible(true);
        val_buono_textbox.setFont(new Font("", Font.PLAIN, 20));
        val_buono_textbox.setBackground(new java.awt.Color(182, 255, 255));
        labelSfondo.add(val_buono_textbox);

		JLabel numero_label = new JLabel("Numero");
		numero_label.setFont(new Font("", Font.PLAIN, 15));
		numero_label.setBounds(640, 400, 90, 20);
		numero_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(numero_label);
		
        JTextArea numero_textbox = new JTextArea();
        numero_textbox.setBounds(640, 420, 80, 40);
        numero_textbox.setVisible(true);
        numero_textbox.setFont(new Font("", Font.PLAIN, 20));
        numero_textbox.setBackground(new java.awt.Color(182, 210, 7));
        labelSfondo.add(numero_textbox);
		
		JLabel data_label = new JLabel("Data");
		data_label.setFont(new Font("", Font.PLAIN, 15));
		data_label.setBounds(725, 400, 90, 20);
		data_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(data_label);
        
        JTextArea data_textbox = new JTextArea();
        data_textbox.setBounds(725, 420, 150, 40);
        data_textbox.setVisible(true);
        data_textbox.setFont(new Font("", Font.PLAIN, 20));
        data_textbox.setBackground(new java.awt.Color(182, 210, 7));
        labelSfondo.add(data_textbox);
        
        JLabel euro_label = new JLabel("€");
        euro_label.setFont(new Font("", Font.PLAIN, 40));
        euro_label.setBounds(10, 470, 50, 50);
        euro_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(euro_label);
		
        JLabel totale_merce_label = new JLabel("Totale merce");
        totale_merce_label.setFont(new Font("", Font.PLAIN, 15));
        totale_merce_label.setBounds(50, 460, 90, 20);
        totale_merce_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totale_merce_label);
		
        JTextArea totale_merce_textbox = new JTextArea();
        totale_merce_textbox.setBounds(50, 480, 110, 40);
        totale_merce_textbox.setVisible(true);
        totale_merce_textbox.setFont(new Font("", Font.PLAIN, 20));
        totale_merce_textbox.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(totale_merce_textbox);
		
		JLabel sconto_label = new JLabel("Sconto");
		sconto_label.setFont(new Font("", Font.PLAIN, 15));
		sconto_label.setBounds(165, 460, 90, 20);
		sconto_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(sconto_label);
		
        JTextArea sconto_textbox = new JTextArea();
        sconto_textbox.setBounds(165, 480, 110, 40);
        sconto_textbox.setVisible(true);
        sconto_textbox.setFont(new Font("", Font.PLAIN, 20));
        sconto_textbox.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(sconto_textbox);
		
		JLabel merce_scontata_label = new JLabel("Merce scontata");
		merce_scontata_label.setFont(new Font("", Font.PLAIN, 15));
		merce_scontata_label.setBounds(280, 460, 110, 20);
		merce_scontata_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(merce_scontata_label);
		
        JTextArea merce_scontata_textbox = new JTextArea();
        merce_scontata_textbox.setBounds(280, 480, 140, 40);
        merce_scontata_textbox.setVisible(true);
        merce_scontata_textbox.setFont(new Font("", Font.PLAIN, 20));
        merce_scontata_textbox.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(merce_scontata_textbox);
		
		JLabel totale_scontato_label = new JLabel("Totale scontato");
		totale_scontato_label.setFont(new Font("", Font.PLAIN, 15));
		totale_scontato_label.setBounds(425, 460, 110, 20);
		totale_scontato_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(totale_scontato_label);
		
        JTextArea totale_scontato_textbox = new JTextArea();
        totale_scontato_textbox.setBounds(425, 480, 140, 40);
        totale_scontato_textbox.setVisible(true);
        totale_scontato_textbox.setFont(new Font("", Font.PLAIN, 20));
        totale_scontato_textbox.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(totale_scontato_textbox);
		
		JLabel acconto_label = new JLabel("Acconto");
		acconto_label.setFont(new Font("", Font.PLAIN, 15));
		acconto_label.setBounds(575, 460, 110, 20);
		acconto_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(acconto_label);
		
        JTextArea acconto_textbox = new JTextArea();
        acconto_textbox.setBounds(575, 480, 140, 40);
        acconto_textbox.setVisible(true);
        acconto_textbox.setFont(new Font("", Font.PLAIN, 20));
        acconto_textbox.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(acconto_textbox);
		
		JLabel totale_saldo_label = new JLabel("Totale saldo");
		totale_saldo_label.setFont(new Font("", Font.PLAIN, 15));
		totale_saldo_label.setBounds(725, 460, 110, 20);
		totale_saldo_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(totale_saldo_label);
		
        JTextArea totale_saldo_textbox = new JTextArea();
        totale_saldo_textbox.setBounds(725, 480, 140, 40);
        totale_saldo_textbox.setVisible(true);
        totale_saldo_textbox.setFont(new Font("", Font.PLAIN, 20));
        totale_saldo_textbox.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(totale_saldo_textbox);
		
		JCheckBox contanti_button = new JCheckBox("Contanti");
		contanti_button.setBounds(10, 538, 150, 20);
		contanti_button.setVisible(true);
		contanti_button.setOpaque(false);
		contanti_button.setContentAreaFilled(false);
		contanti_button.setBorderPainted(false);
		contanti_button.setFont(new Font("", Font.BOLD, 15));
		contanti_button.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(contanti_button);
		
		JCheckBox carte_button = new JCheckBox("Carte");
		carte_button.setBounds(170, 538, 150, 20);
		carte_button.setVisible(true);
		carte_button.setOpaque(false);
		carte_button.setContentAreaFilled(false);
		carte_button.setBorderPainted(false);
		carte_button.setFont(new Font("", Font.BOLD, 15));
		carte_button.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(carte_button);
		
		JCheckBox bonifico_button = new JCheckBox("Bonifico");
		bonifico_button.setBounds(330, 538, 150, 20);
		bonifico_button.setVisible(true);
		bonifico_button.setOpaque(false);
		bonifico_button.setContentAreaFilled(false);
		bonifico_button.setBorderPainted(false);
		bonifico_button.setFont(new Font("", Font.BOLD, 15));
		bonifico_button.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(bonifico_button);
		
		JButton totale_pagamenti_button = new JButton("Totale pagamenti");
		totale_pagamenti_button.setBounds(490, 538, 150, 20);
		totale_pagamenti_button.setVisible(true);
		totale_pagamenti_button.setBackground(new java.awt.Color(143, 134, 255));
		labelSfondo.add(totale_pagamenti_button);
		
		JButton ristampa_distinta_button = new JButton("Ristampa distinta");
		ristampa_distinta_button.setBounds(650, 538, 150, 20);
		ristampa_distinta_button.setVisible(true);
		ristampa_distinta_button.setBackground(new java.awt.Color(143, 216, 164));
		labelSfondo.add(ristampa_distinta_button);
		
		JButton nuova_vendita_button = new JButton("Nuova vendita");
		nuova_vendita_button.setBounds(10, 600, 130, 40);
		nuova_vendita_button.setVisible(true);
		nuova_vendita_button.setBackground(new java.awt.Color(32, 198, 92));
		labelSfondo.add(nuova_vendita_button);
		
		JButton nuovo_carico_button = new JButton("Nuovo carico");
		nuovo_carico_button.setBounds(150, 600, 130, 40);
		nuovo_carico_button.setVisible(true);
		nuovo_carico_button.setBackground(new java.awt.Color(32, 198, 92));
		labelSfondo.add(nuovo_carico_button);
		
		JButton annulla_vendita_button = new JButton("Annulla vendita");
		annulla_vendita_button.setBounds(290, 600, 130, 40);
		annulla_vendita_button.setVisible(true);
		annulla_vendita_button.setBackground(new java.awt.Color(231, 177, 181));
		labelSfondo.add(annulla_vendita_button);	
		
		JButton annulla_carico_button = new JButton("Annulla carico");
		annulla_carico_button.setBounds(430, 600, 130, 40);
		annulla_carico_button.setVisible(true);
		annulla_carico_button.setBackground(new java.awt.Color(231, 177, 181));
		labelSfondo.add(annulla_carico_button);	
		
		JButton memorizza_e_stampa_vendita_button = new JButton("<html>Memorizza e<br />Stampa Vendita</html>");
		memorizza_e_stampa_vendita_button.setBounds(570, 600, 130, 40);
		memorizza_e_stampa_vendita_button.setVisible(true);
		memorizza_e_stampa_vendita_button.setBackground(new java.awt.Color(0,153,0));
		labelSfondo.add(memorizza_e_stampa_vendita_button);
		
		JButton memorizza_carico_button = new JButton("<html>Memorizza<br />Carico</html>");
		memorizza_carico_button.setBounds(710, 600, 130, 40);
		memorizza_carico_button.setVisible(true);
		memorizza_carico_button.setBackground(new java.awt.Color(0,153,0));
		labelSfondo.add(memorizza_carico_button);	
		
		JButton articoli_button = new JButton("Articoli");
		articoli_button.setBounds(850, 600, 130, 40);
		articoli_button.setVisible(true);
		articoli_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(articoli_button);
		
		JButton clienti_button = new JButton("Clienti");
		clienti_button.setBounds(990, 600, 130, 40);
		clienti_button.setVisible(true);
		clienti_button.setBackground(new java.awt.Color(178,255,102));
		labelSfondo.add(clienti_button);
		
		nuovo_carico_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	punto_domanda_label.setText("Carico");
            	barcode_textbox.grabFocus();
            }
            
		});
		
		
		
		aggiungi_valori_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String barcode = barcode_textbox.getText().replaceAll("\\s", "");
        		final ArrayList<Articolo> articoli = articoliDaDb(barcode);
                System.out.println(articoli);
                
            	for(int j=0; j < articoli.size(); j++) {
            		double totaleScontato = totaleScontatoQuantita(articoli.get(j), quantita_textbox.getText());
            		model.addRow(new Object[] {articoli.get(j).getBarcode(), articoli.get(j).getDescrizione(), quantita_textbox.getText() ,
            				articoli.get(j).getPeso(), articoli.get(j).getCaratura(), articoli.get(j).getPr_unit(), Integer.parseInt(quantita_textbox.getText())*articoli.get(0).getPr_unit(), 
            				articoli.get(j).getSconto1(), articoli.get(j).getSconto2(), round(totaleScontato, 2)});
            	}
            	
            	barcode_textbox.setText(null);
            	descrizione_textbox.setText(null);
            	peso_textbox.setText(null);
			    caratura_textbox.setText(null);
			    prezzo_unitario_textbox.setText(null);
			    tot_riga_textbox.setText(null);
			    sconto1_textbox.setText(null);
			    sconto2_textbox.setText(null);
			    quantita_textbox.setText("1");
			    
			    barcode_textbox.grabFocus();
            }
		});
		
		barcode_textbox.setFocusTraversalKeys(
			    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.emptySet());
		
		barcode_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				String barcode = barcode_textbox.getText().replaceAll("\\s", "");
			  	Articolo articolo = articoliDaDbTab(barcode);
			    System.out.println(articolo);
			    if (evt.getKeyCode() == evt.VK_TAB) {
			      descrizione_textbox.setText(articolo.getDescrizione().trim());
			      peso_textbox.setText(String.valueOf(articolo.getPeso()).trim());
			      caratura_textbox.setText(String.valueOf(articolo.getCaratura()).trim());
			      prezzo_unitario_textbox.setText(String.valueOf(articolo.getPr_unit()).trim());
			      tot_riga_textbox.setText(String.valueOf(((Integer.parseInt(quantita_textbox.getText())*articolo.getPr_unit()))).trim());
			      sconto1_textbox.setText(String.valueOf(articolo.getSconto1()).trim());
			      sconto2_textbox.setText(String.valueOf(articolo.getSconto2()).trim());
			      
			      
			      quantita_textbox.grabFocus();
			    }
			  }
			});
		
		memorizza_carico_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String [] barcodeTabella = new String[table.getRowCount()];
            	int [] quantitaTabella = new int [table.getRowCount()];
            	ArrayList<Articolo> articoli = new ArrayList<Articolo>();
            	for (int i = 0; i < table.getRowCount(); i++) {
            		barcodeTabella[i] = (String) table.getModel().getValueAt(i, 0);
            		quantitaTabella[i] = Integer.parseInt( (String) table.getModel().getValueAt(i, 2));
                }
            	for(int i = 0; i < barcodeTabella.length; i++) {
                	System.out.println("Barcode in array " + barcodeTabella[i]);
                	System.out.println("Quantita in array " + quantitaTabella[i]);
                }
                for(int i = 0; i < barcodeTabella.length; i++) {
                	Articolo articolo = articoliDaDbTab(barcodeTabella[i]);
                	articoli.add(articolo);
                }
            	
			    System.out.println(articoli);
            	quantitaNuovoCarico(articoli, quantitaTabella);
            	
            	inserisciEtichette(articoli, quantitaTabella);
            	
            	model.setRowCount(0);
            	punto_domanda_label.setText("?");
            }
		});
		
		annulla_carico_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	barcode_textbox.setText(null);
            	descrizione_textbox.setText(null);
            	peso_textbox.setText(null);
			    caratura_textbox.setText(null);
			    prezzo_unitario_textbox.setText(null);
			    tot_riga_textbox.setText(null);
			    sconto1_textbox.setText(null);
			    sconto2_textbox.setText(null);
			    quantita_textbox.setText("1");
			}
		});
		
		nuova_vendita_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	punto_domanda_label.setText("Nuova Vendita");
            	barcode_textbox.grabFocus();
            }
		});
		
		tessera_cliente_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				  
				  Cliente cliente = clienteDaDb(tessera_cliente_textbox.getText().replaceAll("\\s", ""));
				  if (evt.getKeyCode() == evt.VK_TAB) {
					  nome_cliente_textbox.setText(cliente.getNome().trim());
					  punto_prec_textbox.setText(String.valueOf(cliente.getPunti()).trim());
					  val_in_euro_textbox.setText(String.valueOf((double)cliente.getPunti()*0.4).trim());
		            	
					  int result = venditePresenti();
					  System.out.println("Result: " + result);
					  int numeroVendita = calcoloNumeroVendita(result);
					  numero_textbox.setText(String.valueOf(numeroVendita).trim());
					  data_textbox.setText(String.valueOf(dateFormat.format(java.sql.Date.valueOf(java.time.LocalDate.now()))).trim()); 
					  
					  int [] tot_riga_tutte = new int[table.getRowCount()];
					  double tot_merce = 0;
					  for (int i = 0; i < table.getRowCount(); i++) { 
						  tot_merce = tot_merce + (double) table.getModel().getValueAt(i, 6);
		              }
					  totale_merce_textbox.setText(String.valueOf(round(tot_merce,2)).trim());
					  
					  
					  double merce_scontata = 0;
					  for (int i = 0; i < table.getRowCount(); i++) { 
						  merce_scontata = merce_scontata + (double) table.getModel().getValueAt(i, 9);
		              }
					  merce_scontata_textbox.setText(String.valueOf(round(merce_scontata,2)).trim());
					  
					  double sconto = tot_merce - merce_scontata;
					  sconto_textbox.setText(String.valueOf(round(sconto,2)).trim());
					  
					  totale_scontato_textbox.setText(String.valueOf(((int) merce_scontata)).trim());
					  
					  int totaleScontato = Integer.parseInt(totale_scontato_textbox.getText());
					  
					  totale_saldo_textbox.setText(String.valueOf(totaleScontato).trim());
					  
					  punti_scal_textbox.setText("0");
					  val_buono_textbox.setText("0");
					  acconto_textbox.setText("0");

				  }
			  }
			});
		
		annulla_vendita_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	barcode_textbox.setText(null);
            	descrizione_textbox.setText(null);
            	peso_textbox.setText(null);
			    caratura_textbox.setText(null);
			    prezzo_unitario_textbox.setText(null);
			    tot_riga_textbox.setText(null);
			    sconto1_textbox.setText(null);
			    sconto2_textbox.setText(null);
			    quantita_textbox.setText("1");
			    
			    tessera_cliente_textbox.setText(null);
			    nome_cliente_textbox.setText(null);
			    punto_prec_textbox.setText(null);
			    totale_merce_textbox.setText(null);
			    merce_scontata_textbox.setText(null);
			    sconto_textbox.setText(null);
			    totale_scontato_textbox.setText(null);
			    totale_saldo_textbox.setText(null);
			    punti_scal_textbox.setText("0");
				val_buono_textbox.setText("0");
				acconto_textbox.setText("0");
			}
		});
		
		acconto_textbox.addKeyListener(new java.awt.event.KeyAdapter() {
			  public void keyPressed (java.awt.event.KeyEvent evt){
				  if (evt.getKeyCode() == evt.VK_TAB) {
					  int acconto = Integer.parseInt(acconto_textbox.getText().replaceAll("\\s", ""));
					  int totale_saldo = Integer.parseInt(totale_saldo_textbox.getText());
					  int totale_saldo_con_acconto = totale_saldo - acconto;
					  totale_saldo_textbox.setText(String.valueOf(totale_saldo_con_acconto).trim());
				  }
			  }
		});
		usa_punti_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Cliente cliente = clienteDaDb(tessera_cliente_textbox.getText().replaceAll("\\s", ""));
            	int puntiPrec = cliente.getPunti();
            	if((cliente.getPunti() - 25)>=0 ) {
            		updatePunti(tessera_cliente_textbox.getText().replaceAll("\\s", ""), cliente.getPunti() - 25);
            		int punti_scal = Integer.parseInt(punti_scal_textbox.getText()) + 25;
            		punti_scal_textbox.setText(String.valueOf(punti_scal).trim());
            		double val_buono_punti = punti_scal * 0.4;
            		val_buono_textbox.setText(String.valueOf(val_buono_punti).trim());
            		double totale_saldo = Double.parseDouble(totale_saldo_textbox.getText());
            		totale_saldo_textbox.setText(String.valueOf(totale_saldo - 10));
            		
            	}
            	
            	
            }
		});
		
		memorizza_e_stampa_vendita_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String [] barcodeTabella = new String[table.getRowCount()];
            	int [] quantitaTabella = new int [table.getRowCount()];
            	for (int i = 0; i < table.getRowCount(); i++) {
            		barcodeTabella[i] = (String) table.getModel().getValueAt(i, 0);
            		quantitaTabella[i] = Integer.parseInt( (String) table.getModel().getValueAt(i, 2));
                }
            	int numeroVendita = Integer.parseInt(numero_textbox.getText());
            	String tesseraCliente = tessera_cliente_textbox.getText().replaceAll("\\s", "");
            	String data = data_textbox.getText();
            	double totale_merce = Double.parseDouble(totale_merce_textbox.getText());
            	double sconto = Double.parseDouble(sconto_textbox.getText());
            	double merce_scontata = Double.parseDouble(merce_scontata_textbox.getText());
            	int totale_scontato = Integer.parseInt(totale_scontato_textbox.getText());
            	int acconto = Integer.parseInt(acconto_textbox.getText().replaceAll("\\s", ""));
            	double totale_saldo = Double.parseDouble(totale_saldo_textbox.getText());
            	ArrayList<Articolo> articoli = new ArrayList<Articolo>();
            	for(int i = 0; i < barcodeTabella.length; i ++) {
            		Articolo articolo = articoliDaDbTab(barcodeTabella[i]);
            		articoli.add(articolo);
            	}
            	String metodoPagamento = "";
            	if(contanti_button.isSelected()) {
            		metodoPagamento = "CON";
            	}else if(carte_button.isSelected()) {
            		metodoPagamento = "CAR";
            	}else if(bonifico_button.isSelected()) {
            		metodoPagamento = "BON";
            	}
            	
            	inserisciVendita(numeroVendita, data, totale_merce, sconto, merce_scontata, totale_scontato, acconto, totale_saldo, metodoPagamento);
            	inserisciDistinta(barcodeTabella, numeroVendita, tesseraCliente);
            	quantitaDopoVendita(articoli, quantitaTabella);
            	
            	
            	
            	ArrayList<StampaDistintaDatiVendita> array = prendiTuttiDati(numeroVendita, quantitaTabella);
            	System.out.println(array);
            	for(int i = 0; i < quantitaTabella.length; i++) {
            		System.out.println(quantitaTabella[i]);
            	}
            	
            	ArrayList<StampaDistintaDatiVendita> arrayCompleto = datiCompletiVendita(array, totale_merce, sconto, 
            			merce_scontata, Integer.parseInt(punti_scal_textbox.getText()), Double.parseDouble(val_buono_textbox.getText()), Integer.parseInt(punto_prec_textbox.getText()),
            			Double.parseDouble(totale_scontato_textbox.getText()), Double.parseDouble(acconto_textbox.getText())); 
            	
            	
            	inserisciDatiStampaVendita(arrayCompleto);
            	
            	System.out.println("ArrayCompleto:" + arrayCompleto);
            	
            	ReportDistinte r = new ReportDistinte();
            	try {
					r.generaReport(numeroVendita);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	barcode_textbox.setText(null);
            	descrizione_textbox.setText(null);
            	peso_textbox.setText(null);
			    caratura_textbox.setText(null);
			    prezzo_unitario_textbox.setText(null);
			    tot_riga_textbox.setText(null);
			    sconto1_textbox.setText(null);
			    sconto2_textbox.setText(null);
			    quantita_textbox.setText("1");
			    
			    tessera_cliente_textbox.setText(null);
			    nome_cliente_textbox.setText(null);
			    punto_prec_textbox.setText(null);
			    totale_merce_textbox.setText(null);
			    merce_scontata_textbox.setText(null);
			    sconto_textbox.setText(null);
			    totale_scontato_textbox.setText(null);
			    totale_saldo_textbox.setText(null);
			    punti_scal_textbox.setText("0");
				val_buono_textbox.setText("0");
				acconto_textbox.setText("0");
            }
		});
		
		clienti_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Clienti c = new Clienti();
            }
		});
		
		parizale_giornaliero_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String today = dateFormat.format(java.sql.Date.valueOf(java.time.LocalDate.now()));
            	ArrayList<Vendita> vendite = parzialeGiornaliero(today);
            	System.out.println("VenditePG: " + vendite);
            	int totaleScontato = 0;
            	for(int i = 0; i < vendite.size(); i++) {
            		totaleScontato = totaleScontato + vendite.get(i).getTotaleSaldo();
            	}
            	ParzialeGiornaliero p = new ParzialeGiornaliero(totaleScontato);
            }
		});
		
		totale_pagamenti_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String today = dateFormat.format(java.sql.Date.valueOf(java.time.LocalDate.now()));
            	ArrayList<Vendita> vendite = parzialeGiornaliero(today);
            	int totale_contanti = 0;
            	int totale_carte = 0;
            	int totale_bonifici = 0;
            	for(int i = 0; i < vendite.size(); i++) {
            		if(vendite.get(i).getMetodoPagamento().equals("CON")) {
            			totale_contanti = totale_contanti + vendite.get(i).getTotaleScontato();
            		}else if(vendite.get(i).getMetodoPagamento().equals("CAR")) {
            			totale_carte = totale_carte + vendite.get(i).getTotaleScontato();
            		}else if(vendite.get(i).getMetodoPagamento().equals("BON")) {
            			totale_bonifici = totale_bonifici + vendite.get(i).getTotaleScontato();
            		}
            	}
            	TotalePagamenti t = new TotalePagamenti(totale_contanti, totale_carte, totale_bonifici, java.sql.Date.valueOf(java.time.LocalDate.now()));
            }
		});
		
		articoli_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Articoli a = new Articoli();
            }
		});
		
		ristampa_distinta_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String numeroVendita = JOptionPane.showInputDialog("Inserisci Numero Vendita");
            	
            	ReportDistinte r = new ReportDistinte();
            	try {
					r.generaReport(Integer.parseInt(numeroVendita));
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		
		window.setLayout(null);
        window.setVisible(true);
    }
	public static ArrayList<StampaDistintaDatiVendita> datiCompletiVendita(ArrayList<StampaDistintaDatiVendita> array, double totale_merce, double sconto,
			double merce_scontata, int punti_scal, double d, int punti_prec, double totale_scontato, double acconto) {
		Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
    	Connection con  = Database.connect();
    	int punti_guadagnati = 0;
    	int punti_totali = 0;
    	int punti_disponibili = 0;
       	try { 
       		for(int i = 0; i < array.size(); i++) {
       			pstmt = con.prepareStatement("select * from sys.clienti join sys.distinte on sys.clienti.CodiceBarre = sys.distinte.CardCodeCliente where sys.distinte.CodiceVendita = ? AND sys.distinte.BarcodeArticolo = ?;");

                pstmt.setInt(1, array.get(i).getNumero_vendita());
                pstmt.setString(2, array.get(i).getBarcode());
                rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	array.get(i).setTotale_merce(totale_merce);
	            	array.get(i).setSconto(sconto);
	            	array.get(i).setMerce_scontata(merce_scontata);
	            	array.get(i).setValore_buono(d);
	            	array.get(i).setTotale_scontato(totale_scontato);
	            	array.get(i).setPunti_precedenti(punti_prec);
	            	punti_guadagnati = (int) (totale_scontato /10);
	            	array.get(i).setPunti_guadagnati(punti_guadagnati);
	            	punti_totali = punti_prec + punti_guadagnati;
	            	array.get(i).setPunti_totali(punti_totali);
	            	array.get(i).setPunti_usati(punti_scal);
	            	punti_disponibili = punti_totali - punti_scal;
	            	array.get(i).setPunti_disponibili(punti_disponibili);
	            	String titolo = rs.getString("Titolo");
		            String daTitoloCliente = ""; 

		            if (titolo.equals("Sig.")) {
		                daTitoloCliente = "mo";
		            } else if (titolo.equals("Sig.ra")) {
		                daTitoloCliente = "ma";
		            }
		            array.get(i).setDa_titolo_cliente(daTitoloCliente);
		            array.get(i).setTitolo_cliente(rs.getString("Titolo"));
		            array.get(i).setNome_cliente(rs.getString("Nome"));
		            array.get(i).setCodice_carta_cliente(rs.getString("CodiceBarre"));
		            array.get(i).setEmail_cliente(rs.getString("Email"));
		            array.get(i).setAcconto(acconto);
	            	
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
		return array;
		
	}
	public static void quantitaDopoVendita(ArrayList<Articolo> articoli, int [] quantitaTabella){
			PreparedStatement st = null;
	    	Connection con  = Database.connect();
	    	
	    	try {
	    		for(int i = 0; i < articoli.size(); i++) {
	    			st = con.prepareStatement("UPDATE sys.articoli SET giacenza = ? WHERE barcode = ?;");
		            int giacenza = articoli.get(i).getGiacenza() - quantitaTabella[i];
		            st.setInt(1, giacenza);
		            st.setString(2, articoli.get(i).getBarcode());
		            st.executeUpdate();
	    		}
	            
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
	 
	
	 
	 public static double totaleScontatoQuantita(Articolo articolo, String quantita) {
		 double totale = Integer.parseInt(quantita)*articolo.getPr_unit();
         System.out.println("Totale " + totale);
         double totaleScontato1 = totale -(totale * ((double) articolo.getSconto1() / 100));

         System.out.println("Tot scontato1 " + totaleScontato1);
         double totaleScontato2 = totaleScontato1- (totaleScontato1 * ((double) articolo.getSconto2() / 100));
         System.out.println("Tot scontato2 " + totaleScontato2);
         return totaleScontato2;
	 }
	 
	 
	 public static ArrayList<StampaDistintaDatiVendita> prendiTuttiDati(int numeroVendita, int[] quantita){
	    	Statement st = null;
	        ResultSet rs = null;
	        PreparedStatement pstmt = null;
	    	Connection con  = Database.connect();
	    	double tot_riga = 0.0;
	    	ArrayList<StampaDistintaDatiVendita> dati = new ArrayList<StampaDistintaDatiVendita>(); 
	    	try { 
	            pstmt = con.prepareStatement("select * from sys.articoli join sys.distinte on sys.articoli.barcode = sys.distinte.BarcodeArticolo join sys.clienti on sys.clienti.CodiceBarre = sys.distinte.CardCodeCliente join sys.vendite on sys.distinte.CodiceVendita = sys.vendite.NumeroVendita where sys.distinte.CodiceVendita = ?;");

	            pstmt.setInt(1, numeroVendita);
	            rs = pstmt.executeQuery();
	            System.out.println("query eseguita dati da db");
	            int i = 0;
	            while (rs.next()) {
	            	StampaDistintaDatiVendita dato = new StampaDistintaDatiVendita();
	            	
	            	dato.setNumero_vendita(rs.getInt("CodiceVendita"));
	            	dato.setQuantita(quantita[i]);
	            	dato.setBarcode(rs.getString("barcode"));
	            	dato.setDescrizione(rs.getString("descrizione"));
	            	dato.setPeso(rs.getDouble("peso"));
	            	dato.setCaratura(rs.getDouble("caratura"));
	            	tot_riga = quantita[i] * rs.getInt("pr_unit");
	            	dato.setTotale_riga(tot_riga);
	            	dato.setSc_1(rs.getInt("sc_1"));
	            	dato.setSc_2(rs.getInt("sc_2"));
	            	
	            	double totale = (quantita[i])*rs.getInt("pr_unit");
	                System.out.println("Totale " + totale);
	                double totaleScontato1 = totale -(totale * ((double) rs.getInt("sc_1") / 100));

	                System.out.println("Tot scontato1 " + totaleScontato1);
	                double totaleScontato2 = totaleScontato1- (totaleScontato1 * ((double) rs.getInt("sc_2") / 100));
	                System.out.println("Tot scontato2 " + totaleScontato2);
	            	
	            	dato.setScontato(totaleScontato2);
	            	dato.setTotale_merce(0.0);
	            	dato.setSconto(0.0);
	            	dato.setMerce_scontata(0.0);
	            	dato.setValore_buono(0.0);
	            	dato.setTotale_scontato(0.0);
	            	dato.setPunti_precedenti(0);
	            	dato.setPunti_guadagnati(0);
	            	dato.setPunti_totali(0);
	            	dato.setPunti_usati(0);
	            	dato.setPunti_disponibili(0);
	            	dato.setDa_titolo_cliente("");
	            	dato.setTitolo_cliente("");
	            	dato.setNome_cliente("");
	            	dato.setCodice_carta_cliente("");
	            	dato.setEmail_cliente("");
	            	
	            	dati.add(dato);
	            	i++;
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
	    	
			return dati;
			
	    }
	 
	 
	 
	 public static ArrayList<Articolo> articoliDaDb(String barcode){
	    	Statement st = null;
	        ResultSet rs = null;
	        PreparedStatement pstmt = null;
	    	Connection con  = Database.connect();
	    	ArrayList<Articolo> articoli = new ArrayList<Articolo>(); 
	    	System.out.println("barcode " + barcode);
	    	try { 
	            pstmt = con.prepareStatement("SELECT * FROM sys.articoli WHERE barcode = ?;");

                pstmt.setString(1, barcode);
                rs = pstmt.executeQuery();
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
	 
	 public static void quantitaNuovoCarico(ArrayList<Articolo> articoli, int [] quantitaTabella){
			PreparedStatement st = null;
	    	Connection con  = Database.connect();
	    	
	    	try {
	    		for(int i = 0; i < articoli.size(); i++) {
	    			st = con.prepareStatement("UPDATE sys.articoli SET giacenza = ?, tot_giacenza = ? WHERE barcode = ?;");
		            int giacenza = articoli.get(i).getGiacenza() + quantitaTabella[i];
		            st.setInt(1, giacenza);
		            st.setDouble(2, giacenza * articoli.get(i).getPr_unit());
		            st.setString(3, articoli.get(i).getBarcode());
		            st.executeUpdate();
		            
	    		}
	            
	            
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
	 
	 public static ArrayList<Vendita> parzialeGiornaliero(String string){
	    	Statement st = null;
	        ResultSet rs = null;
	        PreparedStatement pstmt = null;
	        System.out.println("Data " + string);
	    	Connection con  = Database.connect();
	    	ArrayList<Vendita> vendite = new ArrayList<Vendita>();
	    	try { 
	            pstmt = con.prepareStatement("SELECT * FROM sys.vendite WHERE Data = ?;");

	            pstmt.setString(1, string);
	            rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	            	Vendita vendita = new Vendita();
	            	vendita.setNumeroVendita(rs.getInt("NumeroVendita"));
	            	vendita.setData(rs.getString("Data"));
	            	vendita.setTotaleMerce(rs.getInt("TotaleMerce"));
	            	vendita.setSconto(rs.getDouble("Sconto"));
	            	vendita.setMerceScontata(rs.getDouble("MerceScontata"));
	            	vendita.setTotaleScontato(rs.getInt("TotaleScontato"));
	            	vendita.setAcconto(rs.getInt("Acconto"));
	            	vendita.setTotaleSaldo(rs.getInt("TotaleSaldo"));
	            	vendita.setMetodoPagamento(rs.getString("MetodoPagamento"));
	            	vendite.add(vendita);		
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
			return vendite;
			
	    }
	 
	 public static void updatePunti(String codiceBarre, int puntiAggiornati){
			PreparedStatement st = null;
	    	Connection con  = Database.connect();
	    	
	    	try {
	            st = con.prepareStatement("UPDATE sys.clienti SET Punti = ? WHERE CodiceBarre = ?;");
	            st.setInt(1, puntiAggiornati);
	            st.setString(2, codiceBarre);
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
	 
	
	 
	 public static int calcoloNumeroVendita(int result) {
	    	Statement st = null;
	        ResultSet rs = null;
	        int numeroVendita=0;
	    	Connection con  = Database.connect();
	    	if(result == 1) {
	    		try {
	                st = con.createStatement();
	                rs = st.executeQuery("SELECT NumeroVendita as last_numeroVendita FROM sys.vendite ORDER BY NumeroVendita DESC LIMIT 1;");                 
	                while (rs.next()) {
	                	numeroVendita = rs.getInt("last_numeroVendita");
	                	System.out.println("NumeroVendita arrivato: " +numeroVendita);
	                	numeroVendita = numeroVendita + 1;
	                	System.out.println("NumeroVendita modificato: " +numeroVendita);
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
	    		String newNumeroVendita = "1";
	    		numeroVendita = Integer.parseInt(newNumeroVendita);
	    	}
	    	
	    	return numeroVendita;
	    }
	 
	 public static int venditePresenti() {
	    	Statement st = null;
	        ResultSet rs = null;
	        int result = 0;
	    	Connection con  = Database.connect();
	    	try {
	            st = con.createStatement();
	            rs = st.executeQuery("SELECT * FROM sys.vendite;");                 
	            
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
	 
	 public static void inserisciEtichette(ArrayList<Articolo> articoli, int [] quantita) {
		 	Statement st = null;
		    ResultSet rs = null;
			Connection con  = Database.connect();
			
			
			
			try { 
				for(int i = 0; i < articoli.size(); i++) {
					int quant = quantita[i];
					for(int j = 0; j < quant; j++) {
						PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.etichette (barcode, descrizione, peso, "
								+ "caratura, prezzo) VALUE \r\n"
								+ "        (?,?,?,?,?)");
						pstmt.setString(1, articoli.get(i).getBarcode());
						pstmt.setString(2, articoli.get(i).getDescrizione());
						pstmt.setDouble(3, articoli.get(i).getPeso());
						pstmt.setDouble(4, articoli.get(i).getCaratura());
						pstmt.setDouble(5, articoli.get(i).getPr_unit());
						
						pstmt.executeUpdate(); 
					}
					
				}
				
		        
		        
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
	 
	 public static void inserisciDistinta(String[] barcodeTabella, int numeroVendita, String tesseraCliente) {
			Statement st = null;
		    ResultSet rs = null;
			Connection con  = Database.connect();
			
			try { 
				for(int i = 0; i < barcodeTabella.length; i++) {
					PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.distinte (CodiceVendita, CardCodeCliente, BarcodeArticolo) VALUE \r\n"
							+ "        (?,?,?)");
					pstmt.setInt(1, numeroVendita);
					pstmt.setString(2, tesseraCliente);
					pstmt.setString(3, barcodeTabella[i]);
					
					pstmt.executeUpdate(); 
				}
				
		        
		        
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
	 
	 public static void inserisciVendita(int numeroVendita, String data, double totale_merce, double sconto, double merce_scontata, double totale_scontato, double acconto, double totale_saldo, String metodoPagamento) {
		 	Statement st = null;
		 	PreparedStatement pstmt = null;
			Connection con  = Database.connect();
			
			try { 
					pstmt = con.prepareStatement("INSERT INTO sys.vendite (NumeroVendita, Data, TotaleMerce, Sconto, MerceScontata, TotaleScontato, Acconto, TotaleSaldo, MetodoPagamento) VALUE \r\n"
							+ "        (?,?,?,?,?,?,?,?,?)");
					pstmt.setInt(1, numeroVendita);
					pstmt.setString(2, data);
					pstmt.setDouble(3, totale_merce);
					pstmt.setDouble(4, sconto);
					pstmt.setDouble(5, merce_scontata);
					pstmt.setDouble(6, totale_scontato);
					pstmt.setDouble(7, acconto);
					pstmt.setDouble(8, totale_saldo);
					pstmt.setString(9, metodoPagamento);
					
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
	 
	 public static void inserisciDatiStampaVendita(ArrayList<StampaDistintaDatiVendita> array) {
			Statement st = null;
		    ResultSet rs = null;
			Connection con  = Database.connect();
			PreparedStatement pstmt = null;

			
			try { 
				for(int i = 0; i < array.size(); i++) {
					 pstmt = con.prepareStatement("INSERT INTO sys.stampa_distinta (numero_vendita, quantita, barcode, descrizione, peso, caratura, totale_riga, sc_1, sc_2, scontato, "
							+ "totale_merce, sconto, merce_scontata, valore_buono, totale_scontato, punti_precedenti, punti_guadagnati, punti_totali, punti_usati,"
							+ "punti_disponibili, da_titolo_cliente, titolo_cliente, nome_cliente, codice_carta_cliente, email_cliente, acconto) VALUE \r\n"
							+ "        (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setInt(1, array.get(i).getNumero_vendita());
					pstmt.setInt(2, array.get(i).getQuantita());
					pstmt.setString(3, array.get(i).getBarcode());
					pstmt.setString(4, array.get(i).getDescrizione());
					pstmt.setDouble(5, array.get(i).getPeso());
					pstmt.setDouble(6, array.get(i).getCaratura());
					pstmt.setDouble(7, array.get(i).getTotale_riga());
					pstmt.setInt(8, array.get(i).getSc_1());
					pstmt.setInt(9, array.get(i).getSc_2());
					pstmt.setDouble(10, array.get(i).getScontato());
				
					pstmt.setDouble(11, array.get(i).getTotale_merce());
					pstmt.setDouble(12, array.get(i).getSconto());
					pstmt.setDouble(13, array.get(i).getMerce_scontata());
					pstmt.setDouble(14, array.get(i).getValore_buono());
					pstmt.setDouble(15, array.get(i).getTotale_scontato());
					pstmt.setInt(16, array.get(i).getPunti_precedenti());
					pstmt.setInt(17, array.get(i).getPunti_guadagnati());
					pstmt.setInt(18, array.get(i).getPunti_totali());
					pstmt.setInt(19, array.get(i).getPunti_usati());
					pstmt.setInt(20, array.get(i).getPunti_disponibili());
					pstmt.setString(21, array.get(i).getDa_titolo_cliente());
					pstmt.setString(22, array.get(i).getTitolo_cliente());
					pstmt.setString(23, array.get(i).getNome_cliente());
					pstmt.setString(24, array.get(i).getCodice_carta_cliente());
					pstmt.setString(25, array.get(i).getEmail_cliente());
					pstmt.setDouble(26, array.get(i).getAcconto());
					
					pstmt.executeUpdate(); 
				
				}
		        
		        
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
	 
	 public static double round(double value, int places) {
		    if (places < 0) throw new IllegalArgumentException();

		    BigDecimal bd = BigDecimal.valueOf(value);
		    bd = bd.setScale(places, RoundingMode.HALF_UP);
		    return bd.doubleValue();
		}
}