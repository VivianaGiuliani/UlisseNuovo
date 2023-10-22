import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Classi.Database;
import Oggetti.Articolo;

public class ModificaSconto1 {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
	public ModificaSconto1() {
		window = new JFrame();
        window.setSize(600, 210);
        window.setTitle("Modifica Sconto 1");
        window.setResizable(false);
        
        labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
        
        JLabel categoria_label = new JLabel("Inserisci categoria");
        categoria_label.setFont(new Font("", Font.PLAIN,20));
        categoria_label.setBounds(10, 20, 200, 30);
        categoria_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(categoria_label);

        JTextField categoria_textbox = new JTextField();
        categoria_textbox.setBounds(180, 20, 100, 30);
        categoria_textbox.setBackground(new java.awt.Color(156, 191, 171));
        labelSfondo.add(categoria_textbox);
        
        JLabel da_sconto_label = new JLabel("Da sconto:");
        da_sconto_label.setFont(new Font("", Font.PLAIN,20));
        da_sconto_label.setBounds(10, 70, 200, 30);
        da_sconto_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(da_sconto_label);

        JTextField da_sconto_textbox = new JTextField();
        da_sconto_textbox.setBounds(120, 70, 100, 30);
        da_sconto_textbox.setBackground(new java.awt.Color(156, 191, 171));
        labelSfondo.add(da_sconto_textbox);
        
        JLabel a_sconto_label = new JLabel("A sconto:");
        a_sconto_label.setFont(new Font("", Font.PLAIN,20));
        a_sconto_label.setBounds(300, 70, 200, 30);
        a_sconto_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(a_sconto_label);

        JTextField a_sconto_textbox = new JTextField();
        a_sconto_textbox.setBounds(400, 70, 100, 30);
        a_sconto_textbox.setBackground(new java.awt.Color(156, 191, 171));
        labelSfondo.add(a_sconto_textbox);
        
        JButton modifica_button = new JButton("Modifica");
        modifica_button.setBounds(10, 110, 560, 40);
        modifica_button.setBackground(new java.awt.Color(46, 255, 171));
        labelSfondo.add(modifica_button);
        
        modifica_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int categoria = Integer.parseInt(categoria_textbox.getText());
            	int daSconto = Integer.parseInt(da_sconto_textbox.getText());
            	int aSconto = Integer.parseInt(a_sconto_textbox.getText());
            	modificaSconto(categoria, daSconto, aSconto);
            }
        });
        
        window.setLayout(null);
        window.setVisible(true);

	}
	
	public static void modificaSconto(int categoria, int daSconto, int aSconto){
		PreparedStatement st = null;
    	Connection con  = Database.connect();
    	
    	try {
    		st = con.prepareStatement("UPDATE sys.articoli SET sc_1 = ? WHERE cod_categoria = ? AND sc_1 = ?;");
	        st.setInt(1, aSconto);
	        st.setInt(2, categoria);
	        st.setInt(3, daSconto);
	        st.executeUpdate();
    		
            
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
