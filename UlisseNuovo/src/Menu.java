import javax.imageio.ImageIO;
import javax.swing.*;

import Classi.ReportArticoli;
import Classi.ReportRiparazioniArgenteriaPubblico;
import net.sf.jasperreports.engine.JRException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {
	
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
	
	public static void main(String [] args) {
		new Menu();
	}
	
	public Menu() {

        window = new JFrame();
        window.setSize(1200, 800);
        window.setTitle("Ulisse");
        window.setResizable(false);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        
        labelSfondo = new JLabel(imageSfondo);
        labelSfondo.setSize(1400, 800);
        
        imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
        Image img = imageSfondo.getImage();
        Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelSfondo.setIcon(scaledIcon);
       
        window.add(labelSfondo);
        
        JLabel applicazioni_label = new JLabel("Applicazioni");
        applicazioni_label.setFont(new Font("", Font.PLAIN, 20));
        applicazioni_label.setForeground(new java.awt.Color(255,255,255));
        applicazioni_label.setBounds(10, 15, 200, 30);
        labelSfondo.add(applicazioni_label);
        
        JButton distinte_button = new JButton("Distinte");
        distinte_button.setBounds(10, 50, 130, 40);
        distinte_button.setVisible(true);
        distinte_button.setBackground(new java.awt.Color(0,153,0));
        distinte_button.setForeground(new java.awt.Color(178,255,102));
        distinte_button.setFont(new Font("", Font.PLAIN, 20));
        labelSfondo.add(distinte_button);
		
		JButton etichette_button = new JButton("Etichette");
		etichette_button.setBounds(150, 50, 130, 40);
		etichette_button.setVisible(true);
		etichette_button.setBackground(new java.awt.Color(0,153,0));
		etichette_button.setForeground(new java.awt.Color(178,255,102));
		etichette_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(etichette_button);
		
		JButton inventario_button = new JButton("Inventario");
		inventario_button.setBounds(290, 50, 130, 40);
		inventario_button.setVisible(true);
		inventario_button.setBackground(new java.awt.Color(0,153,0));
		inventario_button.setForeground(new java.awt.Color(178,255,102));
		inventario_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(inventario_button);
        
		JLabel archivi_label = new JLabel("Archivi");
		archivi_label.setFont(new Font("", Font.PLAIN, 20));
		archivi_label.setForeground(new java.awt.Color(255,255,255));
		archivi_label.setBounds(10, 100, 200, 30);
		labelSfondo.add(archivi_label);
        
        JButton clienti_button = new JButton("Clienti");  
        clienti_button.setBounds(10, 135, 130, 40);
        clienti_button.setVisible(true);
        clienti_button.setBackground(new java.awt.Color(255,209,110));
        clienti_button.setFont(new Font("", Font.PLAIN, 20));
        labelSfondo.add(clienti_button);
		
		JButton fornitori_button = new JButton("Fornitori");
		fornitori_button.setBounds(150, 135, 130, 40);
		fornitori_button.setVisible(true);
		fornitori_button.setBackground(new java.awt.Color(255,209,110));
		fornitori_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(fornitori_button);
		
		JButton articoli_button = new JButton("Articoli");
		articoli_button.setBounds(290, 135, 130, 40);
		articoli_button.setVisible(true);
		articoli_button.setBackground(new java.awt.Color(255,209,110));
		articoli_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(articoli_button);
		
		JLabel totali_label = new JLabel("Totali");
		totali_label.setFont(new Font("", Font.PLAIN, 20));
		totali_label.setForeground(new java.awt.Color(255,255,255));
		totali_label.setBounds(10, 190, 200, 30);
		labelSfondo.add(totali_label);
        
		JButton saldi_categoria_button = new JButton("Saldi Categoria");
		saldi_categoria_button.setBounds(10, 225, 230, 40);
		saldi_categoria_button.setVisible(true);
		saldi_categoria_button.setBackground(new java.awt.Color(193,255,57));
		saldi_categoria_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(saldi_categoria_button);
		
		JButton saldi_macrocategoria_button = new JButton("Saldi Macrocategoria");
		saldi_macrocategoria_button.setBounds(250, 225, 230, 40);
		saldi_macrocategoria_button.setVisible(true);
		saldi_macrocategoria_button.setBackground(new java.awt.Color(193,255,57));
		saldi_macrocategoria_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(saldi_macrocategoria_button);
		
		JButton totale_magazzino_button = new JButton("Totale Magazzino");
		totale_magazzino_button.setBounds(10, 270, 230, 40);
		totale_magazzino_button.setVisible(true);
		totale_magazzino_button.setBackground(new java.awt.Color(193,255,57));
		totale_magazzino_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(totale_magazzino_button);
		
		JButton scadenze_button = new JButton("Scadenze");
		scadenze_button.setBounds(250, 270, 230, 40);
		scadenze_button.setVisible(true);
		scadenze_button.setBackground(new java.awt.Color(193,255,57));
		scadenze_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(scadenze_button);
		
		JLabel utilita_label = new JLabel("Utilità");
		utilita_label.setFont(new Font("", Font.PLAIN, 20));
		utilita_label.setForeground(new java.awt.Color(255,255,255));
		utilita_label.setBounds(10, 325, 200, 30);
		labelSfondo.add(utilita_label);
		
		JButton stampa_articoli_button = new JButton("Stampa Articoli");
		stampa_articoli_button.setBounds(10, 360, 200, 40);
		stampa_articoli_button.setVisible(true);
		stampa_articoli_button.setBackground(new java.awt.Color(250,126,133));
		stampa_articoli_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(stampa_articoli_button);
		
		JButton azzeramento_button = new JButton("Azzeramento");
		azzeramento_button.setBounds(220, 360, 200, 40);
		azzeramento_button.setVisible(true);
		azzeramento_button.setBackground(new java.awt.Color(250,126,133));
		azzeramento_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(azzeramento_button);
		
		JButton pulisci_etichette_button = new JButton("Pulisci Etichette");
		pulisci_etichette_button.setBounds(430, 360, 200, 40);
		pulisci_etichette_button.setVisible(true);
		pulisci_etichette_button.setBackground(new java.awt.Color(250,126,133));
		pulisci_etichette_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(pulisci_etichette_button);
		
		JButton ristampa_etichette_button = new JButton("Ristampa Etichette");
		ristampa_etichette_button.setBounds(10, 405, 200, 40);
		ristampa_etichette_button.setVisible(true);
		ristampa_etichette_button.setBackground(new java.awt.Color(250,126,133));
		ristampa_etichette_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(ristampa_etichette_button);
		
		JButton argenteria_button = new JButton("Argenteria");
		argenteria_button.setBounds(220, 405, 200, 40);
		argenteria_button.setVisible(true);
		argenteria_button.setBackground(new java.awt.Color(250,126,133));
		argenteria_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(argenteria_button);
		
		JButton oreficeria_button = new JButton("Oreficeria");
		oreficeria_button.setBounds(430, 405, 200, 40);
		oreficeria_button.setVisible(true);
		oreficeria_button.setBackground(new java.awt.Color(250,126,133));
		oreficeria_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(oreficeria_button);
		
		JButton elimina_privati_button = new JButton("Elimina Privati");
		elimina_privati_button.setBounds(10, 450, 200, 40);
		elimina_privati_button.setVisible(true);
		elimina_privati_button.setBackground(new java.awt.Color(250,126,133));
		elimina_privati_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(elimina_privati_button);
		
		
		JButton costi_pulitura_trattamento_button = new JButton("Costi Pulitura e Trattamento");
		costi_pulitura_trattamento_button.setBounds(220, 450, 410, 40);
		costi_pulitura_trattamento_button.setVisible(true);
		costi_pulitura_trattamento_button.setBackground(new java.awt.Color(250,126,133));
		costi_pulitura_trattamento_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(costi_pulitura_trattamento_button);
		
		JLabel listini_label = new JLabel("Listini");
		listini_label.setFont(new Font("", Font.PLAIN, 20));
		listini_label.setBounds(10, 495, 200, 30);
		listini_label.setForeground(new java.awt.Color(255,255,255));
		labelSfondo.add(listini_label);
        
        JButton riparazioni_argenteria_pubblico_button = new JButton("Rip. Arg. Pubblico");
        riparazioni_argenteria_pubblico_button.setBounds(10, 535, 200, 40);
        riparazioni_argenteria_pubblico_button.setVisible(true);
        riparazioni_argenteria_pubblico_button.setBackground(new java.awt.Color(250,126,133));
        riparazioni_argenteria_pubblico_button.setFont(new Font("", Font.PLAIN, 20));
        labelSfondo.add(riparazioni_argenteria_pubblico_button);
		
		JButton riparazioni_argenteria_negozi_button = new JButton("Rip. Arg. Negozi");
		riparazioni_argenteria_negozi_button.setBounds(220, 535, 200, 40);
		riparazioni_argenteria_negozi_button.setBackground(new java.awt.Color(250,126,133));
		riparazioni_argenteria_negozi_button.setFont(new Font("", Font.PLAIN, 20));
		riparazioni_argenteria_negozi_button.setVisible(true);
		labelSfondo.add(riparazioni_argenteria_negozi_button);
		
		JButton riparazioni_consigliati_negozi_button = new JButton("Rip. Cons. Negozi");
		riparazioni_consigliati_negozi_button.setBounds(430, 535, 200, 40);
		riparazioni_consigliati_negozi_button.setVisible(true);
		riparazioni_consigliati_negozi_button.setBackground(new java.awt.Color(250,126,133));
		riparazioni_consigliati_negozi_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(riparazioni_consigliati_negozi_button);
		
		JButton riparazioni_oreficeria_pubblico_button = new JButton("Rip. Oref. Pubblico");
		riparazioni_oreficeria_pubblico_button.setBounds(10, 580, 200, 40);
		riparazioni_oreficeria_pubblico_button.setVisible(true);
		riparazioni_oreficeria_pubblico_button.setBackground(new java.awt.Color(250,126,133));
		riparazioni_oreficeria_pubblico_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(riparazioni_oreficeria_pubblico_button);
		
		JButton riparazioni_oreficeria_negozi_button = new JButton("Rip. Oref. Negozi");
		riparazioni_oreficeria_negozi_button.setBounds(220, 580, 200, 40);
		riparazioni_oreficeria_negozi_button.setVisible(true);
		riparazioni_oreficeria_negozi_button.setBackground(new java.awt.Color(250,126,133));
		riparazioni_oreficeria_negozi_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(riparazioni_oreficeria_negozi_button);
		
		JButton anagrafica_aziendale_button = new JButton("Anagrafica Aziendale");
		anagrafica_aziendale_button.setBounds(870, 50, 250, 40);
		anagrafica_aziendale_button.setVisible(true);
		anagrafica_aziendale_button.setBackground(new java.awt.Color(250,255,133));
		anagrafica_aziendale_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(anagrafica_aziendale_button);
		
		JButton listino_oralux_button = new JButton("Listino Oralux");
		listino_oralux_button.setBounds(870, 100, 250, 40);
		listino_oralux_button.setVisible(true);
		listino_oralux_button.setBackground(new java.awt.Color(250,255,133));
		listino_oralux_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(listino_oralux_button);
		
		JButton magazzino_oralux_button = new JButton("Magazzino Oralux");
		magazzino_oralux_button.setBounds(870, 150, 250, 40);
		magazzino_oralux_button.setVisible(true);
		magazzino_oralux_button.setBackground(new java.awt.Color(250,255,133));
		magazzino_oralux_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(magazzino_oralux_button);
		
		JButton ordini_button = new JButton("Ordini");
		ordini_button.setBounds(870, 200, 250, 40);
		ordini_button.setVisible(true);
		ordini_button.setBackground(new java.awt.Color(250,255,133));
		ordini_button.setFont(new Font("", Font.PLAIN, 20));
		labelSfondo.add(ordini_button);
		
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
		
		stampa_articoli_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ReportArticoli r = new ReportArticoli();
            	try {
					r.generaReport();
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		
		anagrafica_aziendale_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AnagraficheAziende a = new AnagraficheAziende();
            }
		});
		
		scadenze_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Scadenze s = new Scadenze();
            }
		});
		

		
		riparazioni_argenteria_pubblico_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RiparazioniArgenteriaPubblico r = new RiparazioniArgenteriaPubblico();
            }
		});
		riparazioni_argenteria_negozi_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RiparazioniArgenteriaNegozi r = new RiparazioniArgenteriaNegozi();
            }
		});
		riparazioni_consigliati_negozi_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RiparazioniConsigliatiArgenteriaNegozi r = new RiparazioniConsigliatiArgenteriaNegozi();
            }
		});
		riparazioni_oreficeria_pubblico_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RiparazioniOreficeriaPubblico r = new RiparazioniOreficeriaPubblico();
            }
		});
		riparazioni_oreficeria_negozi_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	RiparazioniOreficeriaNegozi r = new RiparazioniOreficeriaNegozi();
            }
		});
		
		costi_pulitura_trattamento_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CostiPulitura c = new CostiPulitura();
            }
		});
		
		azzeramento_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Azzeramento a = new Azzeramento();
            }
		});
		
		inventario_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Inventario i = new Inventario();
            }
		});
		
		ordini_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Ordini o = new Ordini();
            }
		});
		
		listino_oralux_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ListinoOralux o = new ListinoOralux();
            }
		});
		
		magazzino_oralux_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MagazzinoOralux o = new MagazzinoOralux();
            }
		});
		
		argenteria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					Argenteria a = new Argenteria();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		
		oreficeria_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
					Oreficeria a = new Oreficeria();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		
        window.setVisible(true);
    }
}
