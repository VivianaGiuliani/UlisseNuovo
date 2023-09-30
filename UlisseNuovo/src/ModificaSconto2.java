import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Classi.Database;
import Oggetti.Articolo;

public class ModificaSconto2 {
	public ModificaSconto2() {
		JFrame window = new JFrame();
        window.setSize(600, 210);
        window.setTitle("Modifica Sconto 2");
        window.setResizable(false);
        
        JLabel categoria_label = new JLabel("Inserisci categoria");
        categoria_label.setFont(new Font("Courier", Font.PLAIN,20));
        categoria_label.setBounds(10, 20, 200, 30);
        window.add(categoria_label);

        JTextArea categoria_textbox = new JTextArea();
        categoria_textbox.setBounds(180, 20, 100, 30);
        window.add(categoria_textbox);
        
        JLabel da_sconto_label = new JLabel("Da sconto:");
        da_sconto_label.setFont(new Font("Courier", Font.PLAIN,20));
        da_sconto_label.setBounds(10, 70, 200, 30);
        window.add(da_sconto_label);

        JTextArea da_sconto_textbox = new JTextArea();
        da_sconto_textbox.setBounds(120, 70, 100, 30);
        window.add(da_sconto_textbox);
        
        JLabel a_sconto_label = new JLabel("A sconto:");
        a_sconto_label.setFont(new Font("Courier", Font.PLAIN,20));
        a_sconto_label.setBounds(300, 70, 200, 30);
        window.add(a_sconto_label);

        JTextArea a_sconto_textbox = new JTextArea();
        a_sconto_textbox.setBounds(400, 70, 100, 30);
        window.add(a_sconto_textbox);
        
        JButton modifica_button = new JButton("Modifica");
        modifica_button.setBounds(10, 110, 560, 40);
        window.add(modifica_button);
        
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
    		st = con.prepareStatement("UPDATE sys.articoli SET sc_2 = ? WHERE cod_categoria = ? AND sc_2 = ?;");
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
