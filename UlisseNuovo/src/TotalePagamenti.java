import java.awt.Font;
import java.sql.Date;

import javax.swing.*;

public class TotalePagamenti {
	public TotalePagamenti(int contanti, int carte, int bonifici, Date data) {
		JFrame window = new JFrame();
		window.setSize(500, 500);
		window.setTitle("Distinte");
		window.setResizable(false);
		
		JLabel totale_pagamenti_label = new JLabel("Totale Pagamenti");
		totale_pagamenti_label.setFont(new Font("Courier", Font.PLAIN, 30));
		totale_pagamenti_label.setBounds(10, 15, 400, 40);
        window.add(totale_pagamenti_label);
        
        JLabel totale_contanti_label = new JLabel("Totale Contanti");
        totale_contanti_label.setFont(new Font("Courier", Font.PLAIN, 20));
        totale_contanti_label.setBounds(10, 70, 200, 30);
        window.add(totale_contanti_label);
        
        JTextArea totale_contanti_textbox = new JTextArea();
        totale_contanti_textbox.setFont(new Font("Courier", Font.PLAIN, 30));
        totale_contanti_textbox.setBounds(170, 70, 100, 30);
        window.add(totale_contanti_textbox);
        
        JLabel totale_carte_label = new JLabel("Totale Carte");
        totale_carte_label.setFont(new Font("Courier", Font.PLAIN, 20));
        totale_carte_label.setBounds(10, 140, 200, 30);
        window.add(totale_carte_label);
        
        JTextArea totale_carte_textbox = new JTextArea();
        totale_carte_textbox.setFont(new Font("Courier", Font.PLAIN, 30));
        totale_carte_textbox.setBounds(170, 140, 100, 30);
        window.add(totale_carte_textbox);
        
        JLabel totale_bonifico_label = new JLabel("Totale Bonifico");
        totale_bonifico_label.setFont(new Font("Courier", Font.PLAIN, 20));
        totale_bonifico_label.setBounds(10, 210, 200, 30);
        window.add(totale_bonifico_label);
        
        JTextArea totale_bonifico_textbox = new JTextArea();
        totale_bonifico_textbox.setFont(new Font("Courier", Font.PLAIN, 30));
        totale_bonifico_textbox.setBounds(170, 210, 100, 30);
        window.add(totale_bonifico_textbox);

        JLabel data_label = new JLabel("In data: ");
        data_label.setFont(new Font("Courier", Font.PLAIN, 20));
        data_label.setBounds(10, 280, 200, 30);
        window.add(data_label);
        
        JTextArea data_textbox = new JTextArea();
        data_textbox.setFont(new Font("Courier", Font.PLAIN, 30));
        data_textbox.setBounds(170, 280, 100, 30);
        window.add(data_textbox);
		
		window.setLayout(null);
        window.setVisible(true);
	}
}
