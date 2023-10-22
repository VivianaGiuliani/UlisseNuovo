import javax.swing.*;

import Classi.Database;
import Oggetti.Articolo;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ParzialeGiornaliero {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
    public ParzialeGiornaliero(int totaleScontato) {
<<<<<<< HEAD
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	
=======
<<<<<<< HEAD
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	
=======
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
    	window = new JFrame();
        window.setSize(300, 300);
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

        JLabel incassoLabel = new JLabel("Incasso di oggi");
        incassoLabel.setFont(new Font("", Font.PLAIN, 18));
        incassoLabel.setBounds(20, 10, 200, 30);
        incassoLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(incassoLabel);

        
        String today = String.valueOf(dateFormat.format(java.sql.Date.valueOf(java.time.LocalDate.now())));
        JLabel dataLabel = new JLabel(today);
        dataLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        dataLabel.setBounds(50, 40, 150, 30);
        dataLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(dataLabel);

        JLabel euroLabel = new JLabel("€");
        euroLabel.setFont(new Font("", Font.PLAIN, 40));
        euroLabel.setBounds(20, 90, 30, 40);
        euroLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(euroLabel);

<<<<<<< HEAD
        JLabel incassoSoldiLabel = new JLabel("");
        incassoSoldiLabel.setFont(new Font("", Font.PLAIN, 40));
        incassoSoldiLabel.setBounds(160, 90, 300, 30);
=======
<<<<<<< HEAD
        JLabel incassoSoldiLabel = new JLabel("");
        incassoSoldiLabel.setFont(new Font("", Font.PLAIN, 40));
        incassoSoldiLabel.setBounds(160, 90, 300, 30);
=======
        JLabel incassoSoldiLabel = new JLabel();
        incassoSoldiLabel.setFont(new Font("Courier", Font.PLAIN, 18));
        incassoSoldiLabel.setBounds(160, 105, 50, 30);
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
        incassoSoldiLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(incassoSoldiLabel);
        incassoSoldiLabel.setText(String.valueOf(totaleScontato));

        JButton chiudiButton = new JButton("Chiudi");
        chiudiButton.setPreferredSize(new Dimension(87, 60));
        chiudiButton.setBounds(20, 170, 200, 60);
        chiudiButton.setBackground(new java.awt.Color(240, 71, 50));
        chiudiButton.addActionListener(e -> window.dispose());
        labelSfondo.add(chiudiButton);
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
}
