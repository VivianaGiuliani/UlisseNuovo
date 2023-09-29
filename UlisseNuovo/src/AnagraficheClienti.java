import javax.swing.*;
import java.awt.*;

public class AnagraficheClienti extends JFrame {
    public AnagraficheClienti() {
    	JFrame window = new JFrame();
        window.setSize(920, 700);
        window.setTitle("Anagrafiche Clienti");
        window.setResizable(false);
        
        JLabel anagrafiche_clienti_label = new JLabel("Anagrafiche Clienti");
        anagrafiche_clienti_label.setFont(new Font("Courier", Font.BOLD, 20));
        anagrafiche_clienti_label.setBounds(30, 8, 300, 30);
        window.add(anagrafiche_clienti_label);
        
        JButton inizio_button = new JButton("|<");
        inizio_button.setBounds(30, 60, 60, 30);
        window.add(inizio_button);
        
        JButton indietro_button = new JButton("<");
        indietro_button.setBounds(95, 60, 60, 30);
        window.add(indietro_button);
        
        JButton avanti_button = new JButton(">");
        avanti_button.setBounds(160, 60, 60, 30);
        window.add(avanti_button);
        
        JButton fine_button = new JButton(">|");
        fine_button.setBounds(225, 60, 60, 30);
        window.add(fine_button);
        
        JButton aggiungi_riga_button = new JButton("AR");
        aggiungi_riga_button.setBounds(300, 60, 60, 30);
        window.add(aggiungi_riga_button);
        
        JButton elimina_riga_button = new JButton("ER");
        elimina_riga_button.setBounds(365, 60, 60, 30);
        window.add(elimina_riga_button);
        
        JButton salva_riga_button = new JButton("SR");
        salva_riga_button.setBounds(430, 60, 60, 30);
        window.add(salva_riga_button);
        
        JButton abbandona_riga_button = new JButton("ABR");
        abbandona_riga_button.setBounds(495, 60, 60, 30);
        window.add(abbandona_riga_button);
        
        JButton filtra_rowset_button = new JButton("FR");
        filtra_rowset_button.setBounds(560, 60, 60, 30);
        window.add(filtra_rowset_button);
        
        JButton trova_riga_button = new JButton("TR");
        trova_riga_button.setBounds(625, 60, 60, 30);
        window.add(trova_riga_button);
        
        window.setLayout(null);
        window.setVisible(true);
    }
    
    public static void main(String[] args) {
        new AnagraficheClienti();
    }
}