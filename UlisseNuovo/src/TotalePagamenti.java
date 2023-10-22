import java.awt.Font;
import java.awt.Image;
import java.sql.Date;

import javax.swing.*;

public class TotalePagamenti {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
	public TotalePagamenti(int contanti, int carte, int bonifici, Date data) {
		window = new JFrame();
		window.setSize(500, 500);
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
		
		
		JLabel totale_pagamenti_label = new JLabel("Totale Pagamenti");
		totale_pagamenti_label.setFont(new Font("", Font.PLAIN, 30));
		totale_pagamenti_label.setBounds(10, 15, 400, 40);
		totale_pagamenti_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totale_pagamenti_label);
        
        JLabel totale_contanti_label = new JLabel("Totale Contanti");
        totale_contanti_label.setFont(new Font("", Font.PLAIN, 20));
        totale_contanti_label.setBounds(10, 70, 200, 30);
        totale_contanti_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totale_contanti_label);
        
        JTextField totale_contanti_textbox = new JTextField();
        totale_contanti_textbox.setFont(new Font("", Font.PLAIN, 30));
        totale_contanti_textbox.setBounds(170, 70, 100, 30);
        totale_contanti_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totale_contanti_textbox);
        
        JLabel totale_carte_label = new JLabel("Totale Carte");
        totale_carte_label.setFont(new Font("", Font.PLAIN, 20));
        totale_carte_label.setBounds(10, 140, 200, 30);
        totale_carte_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totale_carte_label);
        
        JTextField totale_carte_textbox = new JTextField();
        totale_carte_textbox.setFont(new Font("", Font.PLAIN, 30));
        totale_carte_textbox.setBounds(170, 140, 100, 30);
        totale_carte_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totale_carte_textbox);
        
        JLabel totale_bonifico_label = new JLabel("Totale Bonifico");
        totale_bonifico_label.setFont(new Font("", Font.PLAIN, 20));
        totale_bonifico_label.setBounds(10, 210, 200, 30);
        totale_bonifico_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totale_bonifico_label);
        
        JTextField totale_bonifico_textbox = new JTextField();
        totale_bonifico_textbox.setFont(new Font("", Font.PLAIN, 30));
        totale_bonifico_textbox.setBounds(170, 210, 100, 30);
        totale_bonifico_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totale_bonifico_textbox);

        JLabel data_label = new JLabel("In data: ");
        data_label.setFont(new Font("", Font.PLAIN, 20));
        data_label.setBounds(10, 280, 200, 30);
        data_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(data_label);
        
        JTextField data_textbox = new JTextField();
        data_textbox.setFont(new Font("", Font.PLAIN, 30));
        data_textbox.setBounds(170, 280, 100, 30);
        data_textbox.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(data_textbox);
		
		window.setLayout(null);
        window.setVisible(true);
	}
}
