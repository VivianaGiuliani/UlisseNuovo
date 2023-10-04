import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        distinte_button.setBackground(new java.awt.Color(0,153,0));
        distinte_button.setForeground(new java.awt.Color(178,255,102));
        distinte_button.setFont(new Font("Courier", Font.PLAIN, 20));
		window.add(distinte_button);
		
		JButton etichette_button = new JButton("Etichette");
		etichette_button.setBounds(150, 50, 130, 40);
		etichette_button.setVisible(true);
		etichette_button.setBackground(new java.awt.Color(0,153,0));
		etichette_button.setForeground(new java.awt.Color(178,255,102));
		etichette_button.setFont(new Font("Courier", Font.PLAIN, 20));
		window.add(etichette_button);
		
		JButton inventario_button = new JButton("Inventario");
		inventario_button.setBounds(290, 50, 130, 40);
		inventario_button.setVisible(true);
		inventario_button.setBackground(new java.awt.Color(0,153,0));
		inventario_button.setForeground(new java.awt.Color(178,255,102));
		inventario_button.setFont(new Font("Courier", Font.PLAIN, 20));
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
		
		JButton articoli_button = new JButton("Articoli");
		articoli_button.setBounds(290, 135, 130, 40);
		articoli_button.setVisible(true);
		window.add(articoli_button);
		
		JLabel totali_label = new JLabel("Totali");
		totali_label.setFont(new Font("Courier", Font.PLAIN, 15));
		totali_label.setBounds(10, 190, 200, 30);
        window.add(totali_label);
        
		JButton saldi_categoria_button = new JButton("Saldi Categoria");
		saldi_categoria_button.setBounds(200, 225, 180, 40);
		saldi_categoria_button.setVisible(true);
		window.add(saldi_categoria_button);
		
		JButton saldi_macrocategoria_button = new JButton("Saldi Macrocategoria");
		saldi_macrocategoria_button.setBounds(390, 225, 180, 40);
		saldi_macrocategoria_button.setVisible(true);
		window.add(saldi_macrocategoria_button);
		
		JButton totale_magazzino_button = new JButton("Totale Magazzino");
		totale_magazzino_button.setBounds(200, 270, 180, 40);
		totale_magazzino_button.setVisible(true);
		window.add(totale_magazzino_button);
		
		JButton scadenze_button = new JButton("Scadenze");
		scadenze_button.setBounds(390, 270, 180, 40);
		scadenze_button.setVisible(true);
		window.add(scadenze_button);
		
		JLabel utilita_label = new JLabel("Utilità");
		utilita_label.setFont(new Font("Courier", Font.PLAIN, 15));
		utilita_label.setBounds(10, 325, 200, 30);
        window.add(utilita_label);
		
		JButton stampa_articoli_button = new JButton("Stampa Articoli");
		stampa_articoli_button.setBounds(200, 360, 180, 40);
		stampa_articoli_button.setVisible(true);
		window.add(stampa_articoli_button);
		
		JButton azzeramento_button = new JButton("Azzeramento");
		azzeramento_button.setBounds(580, 360, 180, 40);
		azzeramento_button.setVisible(true);
		window.add(azzeramento_button);
		
		JButton stampa_movimenti_button = new JButton("Stampa Movimenti");
		stampa_movimenti_button.setBounds(10, 405, 180, 40);
		stampa_movimenti_button.setVisible(true);
		window.add(stampa_movimenti_button);
		
		JButton ristampa_etichette_button = new JButton("Ristampa Etichette");
		ristampa_etichette_button.setBounds(200, 405, 180, 40);
		ristampa_etichette_button.setVisible(true);
		window.add(ristampa_etichette_button);
		
		JButton argenteria_button = new JButton("Argenteria");
		argenteria_button.setBounds(390, 405, 180, 40);
		argenteria_button.setVisible(true);
		window.add(argenteria_button);
		
		JButton oreficeria_button = new JButton("Oreficeria");
		oreficeria_button.setBounds(580, 405, 180, 40);
		oreficeria_button.setVisible(true);
		window.add(oreficeria_button);
		
		JButton elimina_privati_button = new JButton("Elimina Privati");
		elimina_privati_button.setBounds(10, 450, 180, 40);
		elimina_privati_button.setVisible(true);
		window.add(elimina_privati_button);
		
		JButton st_t_nuova_button = new JButton("St. t.nuova");
		st_t_nuova_button.setBounds(390, 450, 180, 40);
		st_t_nuova_button.setVisible(true);
		window.add(st_t_nuova_button);
		
		
		JButton costi_pulitura_button = new JButton("Costi Pulitura");
		costi_pulitura_button.setBounds(200, 495, 180, 40);
		costi_pulitura_button.setVisible(true);
		window.add(costi_pulitura_button);
		
		JButton costi_trattamento_button = new JButton("Costi Trattamento");
		costi_trattamento_button.setBounds(390, 495, 180, 40);
		costi_trattamento_button.setVisible(true);
		window.add(costi_trattamento_button);
		
		JLabel listini_label = new JLabel("Listini");
		listini_label.setFont(new Font("Courier", Font.PLAIN, 15));
		listini_label.setBounds(10, 550, 200, 30);
        window.add(listini_label);
        
        JButton riparazioni_argenteria_pubblico_button = new JButton("Rip. Arg. Pubblico");
        riparazioni_argenteria_pubblico_button.setBounds(10, 585, 180, 40);
        riparazioni_argenteria_pubblico_button.setVisible(true);
		window.add(riparazioni_argenteria_pubblico_button);
		
		JButton riparazioni_argenteria_negozi_button = new JButton("Rip. Arg. Negozi");
		riparazioni_argenteria_negozi_button.setBounds(200, 585, 180, 40);
		riparazioni_argenteria_negozi_button.setVisible(true);
		window.add(riparazioni_argenteria_negozi_button);
		
		JButton riparazioni_consegna_negozi_button = new JButton("Rip. Cons. Negozi");
		riparazioni_consegna_negozi_button.setBounds(390, 585, 180, 40);
		riparazioni_consegna_negozi_button.setVisible(true);
		window.add(riparazioni_consegna_negozi_button);
		
		JButton riparazioni_oreficeria_pubblico_button = new JButton("Rip. Oref. Pubblico");
		riparazioni_oreficeria_pubblico_button.setBounds(10, 630, 180, 40);
		riparazioni_oreficeria_pubblico_button.setVisible(true);
		window.add(riparazioni_oreficeria_pubblico_button);
		
		JButton riparazioni_oreficeria_negozi_button = new JButton("Rip. Oref. Negozi");
		riparazioni_oreficeria_negozi_button.setBounds(200, 630, 180, 40);
		riparazioni_oreficeria_negozi_button.setVisible(true);
		window.add(riparazioni_oreficeria_negozi_button);
		
		JButton anagrafica_aziendale_button = new JButton("Anagrafica Aziendale");
		anagrafica_aziendale_button.setBounds(900, 50, 180, 40);
		anagrafica_aziendale_button.setVisible(true);
		window.add(anagrafica_aziendale_button);
		
		JButton listino_oralux_button = new JButton("Listino Oralux");
		listino_oralux_button.setBounds(900, 300, 180, 40);
		listino_oralux_button.setVisible(true);
		window.add(listino_oralux_button);
		
		JButton magazzino_oralux_button = new JButton("Magazzino Oralux");
		magazzino_oralux_button.setBounds(900, 350, 180, 40);
		magazzino_oralux_button.setVisible(true);
		window.add(magazzino_oralux_button);
		
		JButton ordini_button = new JButton("Ordini");
		ordini_button.setBounds(900, 450, 180, 40);
		ordini_button.setVisible(true);
		window.add(ordini_button);
		
		saldi_categoria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SaldiCategoria s = new SaldiCategoria();
            }
		});
		
		distinte_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Distinte d = new Distinte();
            }
		});
		
		clienti_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Clienti c = new Clienti();
            }
		}); 
		fornitori_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TabellaFornitori f = new TabellaFornitori();
            }
		}); 
		articoli_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Articoli a = new Articoli();
            }
		});
		
		saldi_macrocategoria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TotaliMacrocategorie t = new TotaliMacrocategorie();
            }
		});
		
		totale_magazzino_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TotaleMagazzino t = new TotaleMagazzino();
            }
		});
		
		elimina_privati_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	EliminaPrivati e1 = new EliminaPrivati();
            }
		});
		
		window.setLayout(null);
        window.setVisible(true);
    }
}
