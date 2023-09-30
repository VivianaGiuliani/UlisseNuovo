import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
	public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(1400, 800);
        window.setTitle("Ulisse");
        window.setResizable(false);
        
        JLabel applicazioni_label = new JLabel("Applicazioni");
        applicazioni_label.setFont(new Font("Courier", Font.PLAIN, 15));
        applicazioni_label.setBounds(10, 15, 200, 30);
        window.add(applicazioni_label);
        
        JButton distinte_button = new JButton("Distinte");
        distinte_button.setBounds(10, 50, 130, 40);
        distinte_button.setVisible(true);
		window.add(distinte_button);
		
		JButton etichette_button = new JButton("Distinte");
		etichette_button.setBounds(150, 50, 130, 40);
		etichette_button.setVisible(true);
		window.add(etichette_button);
		
		JButton inventario_button = new JButton("Distinte");
		inventario_button.setBounds(290, 50, 130, 40);
		inventario_button.setVisible(true);
		window.add(inventario_button);
        
		JLabel archivi_label = new JLabel("Archivi");
		archivi_label.setFont(new Font("Courier", Font.PLAIN, 15));
		archivi_label.setBounds(10, 100, 200, 30);
        window.add(archivi_label);
        
        JButton clienti_button = new JButton("Clienti");
        clienti_button.setBounds(10, 135, 130, 40);
        clienti_button.setVisible(true);
		window.add(clienti_button);
		
		JButton fornitori_button = new JButton("Fornitori");
		fornitori_button.setBounds(150, 135, 130, 40);
		fornitori_button.setVisible(true);
		window.add(fornitori_button);
		
		window.setLayout(null);
        window.setVisible(true);
    }
}
