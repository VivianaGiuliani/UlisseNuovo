import javax.swing.*;

import Classi.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TotaleMagazzino {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
    public TotaleMagazzino() {
    	window = new JFrame();
		window.setSize(500, 400);
		window.setTitle("Totale Magazzino");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
		
        JLabel titoloLabel = new JLabel("Totale Magazzino");
<<<<<<< HEAD
        titoloLabel.setFont(new Font("", Font.BOLD, 20));
=======
<<<<<<< HEAD
        titoloLabel.setFont(new Font("", Font.BOLD, 20));
=======
<<<<<<< HEAD
        titoloLabel.setFont(new Font("", Font.BOLD, 20));
=======
<<<<<<< HEAD
        titoloLabel.setFont(new Font("", Font.BOLD, 20));
=======
        titoloLabel.setFont(new Font("Courier", Font.BOLD, 20));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        titoloLabel.setBounds(150, 10, 200, 30);
        titoloLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(titoloLabel);

        JLabel totGiacFissoLabel = new JLabel("Totale Giacenza Fisso");
<<<<<<< HEAD
        totGiacFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
        totGiacFissoLabel.setFont(new Font("Courier", Font.BOLD, 12));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        totGiacFissoLabel.setBounds(10, 50, 200, 20);
        totGiacFissoLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totGiacFissoLabel);

        JTextField totGiacFissoTextField = new JTextField();
        totGiacFissoTextField.setBounds(300, 50, 150, 30);
        labelSfondo.add(totGiacFissoTextField);

        JLabel totGiacVarLabel = new JLabel("Totale Giacenza Variabile");
<<<<<<< HEAD
        totGiacVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
        totGiacVarLabel.setFont(new Font("Courier", Font.BOLD, 12));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        totGiacVarLabel.setBounds(10, 90, 200, 20);
        totGiacVarLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totGiacVarLabel);

        JTextField totGiacVarTextField = new JTextField();
        totGiacVarTextField.setBounds(300, 90, 150, 30);
        labelSfondo.add(totGiacVarTextField);

        JLabel totGiacLabel = new JLabel("Totale Giacenza");
<<<<<<< HEAD
        totGiacLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totGiacLabel.setFont(new Font("", Font.BOLD, 12));
=======
        totGiacLabel.setFont(new Font("Courier", Font.BOLD, 12));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        totGiacLabel.setBounds(10, 130, 200, 20);
        totGiacLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totGiacLabel);

        JTextField totGiacTextField = new JTextField();
        totGiacTextField.setBounds(300, 130, 150, 30);
        labelSfondo.add(totGiacTextField);

        JLabel totCostoFissoLabel = new JLabel("Totale Costo Fisso");
<<<<<<< HEAD
        totCostoFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoFissoLabel.setFont(new Font("", Font.BOLD, 12));
=======
        totCostoFissoLabel.setFont(new Font("Courier", Font.BOLD, 12));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        totCostoFissoLabel.setBounds(10, 170, 200, 20);
        totCostoFissoLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totCostoFissoLabel);

        JTextField totCostoFissoTextField = new JTextField();
        totCostoFissoTextField.setBounds(300, 170, 150, 30);
        labelSfondo.add(totCostoFissoTextField);

        JLabel totCostoVarLabel = new JLabel("Totale Costo Variabile");
<<<<<<< HEAD
        totCostoVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoVarLabel.setFont(new Font("", Font.BOLD, 12));
=======
        totCostoVarLabel.setFont(new Font("Courier", Font.BOLD, 12));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        totCostoVarLabel.setBounds(10, 210, 200, 20);
        totCostoVarLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totCostoVarLabel);

        JTextField totCostoVarTextField = new JTextField();
        totCostoVarTextField.setBounds(300, 210, 150, 30);
        labelSfondo.add(totCostoVarTextField);

        JLabel totCostoLabel = new JLabel("Totale Costo");
<<<<<<< HEAD
        totCostoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoLabel.setFont(new Font("", Font.BOLD, 12));
=======
<<<<<<< HEAD
        totCostoLabel.setFont(new Font("", Font.BOLD, 12));
=======
        totCostoLabel.setFont(new Font("Courier", Font.BOLD, 12));
>>>>>>> 92ba0878318a769571cc1e9456393151517d6ac3
>>>>>>> b3f423dce0bf0d73c6a9c24aaf71265d864d2beb
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
>>>>>>> 3f256a41156cb108967f500bddb2e616b7b7d81d
        totCostoLabel.setBounds(10, 250, 200, 20);
        totCostoLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totCostoLabel);

        JTextField totCostoTextField = new JTextField();
        totCostoTextField.setBounds(300, 250, 150, 30);
        labelSfondo.add(totCostoTextField);

        JButton stampaSaldiButton = new JButton("Stampa Saldi");
        stampaSaldiButton.setBounds(10, 300, 150, 35);
        stampaSaldiButton.setBackground(new java.awt.Color(132, 249, 58));
        labelSfondo.add(stampaSaldiButton);

        JButton stampaDettaglioButton = new JButton("Stampa Dettaglio");
        stampaDettaglioButton.setBounds(170, 300, 150, 35);
        stampaDettaglioButton.setBackground(new java.awt.Color(132, 249, 58));
        labelSfondo.add(stampaDettaglioButton);
        
        ArrayList<Integer> valoriF = valoriArticoliDaDb("F");
        int valoreF = 0;
        for(int i = 0; i < valoriF.size(); i++) {
        	valoreF = valoreF + valoriF.get(i);
        }
        totGiacFissoTextField.setText(String.valueOf(valoreF));
        
        ArrayList<Integer> valoriV = valoriArticoliDaDb("V");
        int valoreV = 0;
        for(int i = 0; i < valoriV.size(); i++) {
        	valoreV = valoreV + valoriV.get(i);
        }
        totGiacVarTextField.setText(String.valueOf(valoreV));
        int tot_giac = valoreF + valoreV;
        totGiacTextField.setText(String.valueOf(tot_giac));
        
        window.setLayout(null);
        window.setVisible(true);
    }

    public static ArrayList<Integer> valoriArticoliDaDb(String fv){
   		Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
   		Connection con  = Database.connect();
   		ArrayList<Integer> valori = new ArrayList<Integer>();
   		
   		try { 
           pstmt = con.prepareStatement("SELECT giacenza, pr_unit FROM sys.articoli WHERE fv = ?;");
           
           pstmt.setString(1, fv);
           rs = pstmt.executeQuery();
           System.out.println("query eseguita articoli da db");
           while (rs.next()) {
        	   int valore = rs.getInt("giacenza") * rs.getInt("pr_unit");
        	   System.out.println("Valore: " + valore);
        	   valori.add(valore); 
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
		return valori;
		
   }
}
