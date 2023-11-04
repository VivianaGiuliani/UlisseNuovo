import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Classi.ReportDistinte;
import Classi.ReportScadenze;
import Oggetti.Articolo;
import Oggetti.Scadenza;
import Oggetti.Vendita;
import net.sf.jasperreports.engine.JRException;

public class Scadenze {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
	public Scadenze() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		window = new JFrame();
		window.setSize(1500, 800);
		window.setTitle("Scadenze");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);
		
		JButton anagrafiche_button = new JButton("Anagrafiche");
		anagrafiche_button.setBounds(10, 20, 150, 35);
		anagrafiche_button.setBackground(new java.awt.Color(132, 249, 58));
	    labelSfondo.add(anagrafiche_button);
	    
	    JLabel gestione_scadenze_label = new JLabel("Gestione Scadenze");
	    gestione_scadenze_label.setFont(new Font("", Font.PLAIN, 25));
	    gestione_scadenze_label.setBounds(200, 20, 300, 40);
	    gestione_scadenze_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(gestione_scadenze_label);
	    
	    JButton rate_button = new JButton("Rate");
	    rate_button.setBounds(990, 20, 150, 35);
	    rate_button.setBackground(new java.awt.Color(203, 203, 146));
	    labelSfondo.add(rate_button);
	    
	    JLabel nomeLabel = new JLabel("Nome");
	    nomeLabel.setFont(new Font("", Font.PLAIN, 15));
	    nomeLabel.setBounds(10, 60, 60, 20);
	    nomeLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(nomeLabel);
	    
        ArrayList<String> risultatoAnagraficheAziende = anagraficheAziendeNomeStr();
        String [] anagraficheAziende_values = new String[risultatoAnagraficheAziende.size()];
        anagraficheAziende_values = risultatoAnagraficheAziende.toArray(anagraficheAziende_values);
	    JComboBox<String> nomeComboBox = new JComboBox<>(anagraficheAziende_values);
        nomeComboBox.setBounds(10, 80, 440, 20);
        labelSfondo.add(nomeComboBox);

        JLabel docNumLabel = new JLabel("Doc.Num.");
        docNumLabel.setFont(new Font("", Font.PLAIN, 15));
        docNumLabel.setBounds(455, 60, 100, 20);
        docNumLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(docNumLabel);

        JTextField docNumTextField = new JTextField();
        docNumTextField.setBounds(455, 80, 70, 20);
        docNumTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(docNumTextField);

        JLabel dataDocLabel = new JLabel("Data Doc.");
        dataDocLabel.setFont(new Font("", Font.PLAIN, 15));
        dataDocLabel.setBounds(540, 60, 100, 20);
        dataDocLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(dataDocLabel);

        JTextField dataDocTextField = new JTextField();
        dataDocTextField.setBounds(540, 80, 70, 20);
        dataDocTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(dataDocTextField);

        JLabel imponibileLabel = new JLabel("Imponibile");
        imponibileLabel.setFont(new Font("", Font.PLAIN, 15));
        imponibileLabel.setBounds(625, 60, 100, 20);
        imponibileLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(imponibileLabel);

        JTextField imponibileTextField = new JTextField();
        imponibileTextField.setBounds(625, 80, 80, 20);
        imponibileTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(imponibileTextField);

        JLabel ivaLabel = new JLabel("IVA");
        ivaLabel.setFont(new Font("", Font.PLAIN, 15));
        ivaLabel.setBounds(725, 60, 40, 20);
        ivaLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(ivaLabel);

        JTextField ivaTextField = new JTextField();
        ivaTextField.setBounds(725, 80, 60, 20);
        ivaTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(ivaTextField);

        JLabel totaleRataLabel = new JLabel("Totale Rata");
        totaleRataLabel.setFont(new Font("", Font.PLAIN, 15));
        totaleRataLabel.setBounds(810, 60, 100, 20);
        totaleRataLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totaleRataLabel);

        JTextField totaleRataTextField = new JTextField();
        totaleRataTextField.setBounds(810, 80, 100, 20);
        totaleRataTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totaleRataTextField);

        JLabel bancaLabel = new JLabel("Banca");
        bancaLabel.setFont(new Font("", Font.PLAIN, 15));
        bancaLabel.setBounds(925, 60, 100, 20);
        bancaLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(bancaLabel);

        ArrayList<String> risultatoBanche = bancaCodiceStr();
        String [] banche_values = new String[risultatoBanche.size()];
        banche_values = risultatoBanche.toArray(banche_values);
        JComboBox<String> bancaComboBox = new JComboBox<>(banche_values);
        bancaComboBox.setBounds(925, 80, 100, 20);
        labelSfondo.add(bancaComboBox);

        JLabel scadenzaLabel = new JLabel("Scadenza");
        scadenzaLabel.setFont(new Font("", Font.PLAIN, 15));
        scadenzaLabel.setBounds(1050, 60, 100, 20);
        scadenzaLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(scadenzaLabel);

        JTextField scadenzaTextField = new JTextField();
        scadenzaTextField.setBounds(1050, 80, 100, 20);
        scadenzaTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(scadenzaTextField);

        JLabel rataNumLabel = new JLabel("Rata Num.");
        rataNumLabel.setFont(new Font("", Font.PLAIN, 15));
        rataNumLabel.setBounds(1175, 60, 100, 20);
        rataNumLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(rataNumLabel);

        ArrayList<String> risultatoRate = rateNomeStr();
        String [] rate_values = new String[risultatoRate.size()];
        rate_values = risultatoRate.toArray(rate_values);
        JComboBox<String> rataNumComboBox = new JComboBox<>(rate_values);
        rataNumComboBox.setBounds(1175, 80, 100, 20);
        labelSfondo.add(rataNumComboBox);

        JButton aggiungiRigaButton = new JButton("Aggiungi riga");
        aggiungiRigaButton.setBounds(10, 110, 600, 40);
        aggiungiRigaButton.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(aggiungiRigaButton);

        JButton eliminaRigaButton = new JButton("Elimina riga");
        eliminaRigaButton.setBounds(620, 110, 570, 40);
        eliminaRigaButton.setBackground(new java.awt.Color(250,255,133));
        labelSfondo.add(eliminaRigaButton);
        
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 170, 1150, 450);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 1150, 450);

        String[] columnNames = {"Categoria", "Nome", "Doc_Num", "Data_Doc", "Imponibile", "IVA", "Totale", "Cod_Banca", "Data_Scad", "N_Rata"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        
        JLabel categoriaLabel = new JLabel("Categoria");
        categoriaLabel.setFont(new Font("", Font.PLAIN, 15));
        categoriaLabel.setBounds(10, 620, 100, 20);
        categoriaLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(categoriaLabel);

        String [] categorie_values = {"F", "C"};
        JComboBox<String> categoriaComboBox = new JComboBox<>(categorie_values);
        categoriaComboBox.setBounds(10, 640, 100, 20);
        labelSfondo.add(categoriaComboBox);
        
        JLabel annoLabel = new JLabel("Anno");
        annoLabel.setFont(new Font("", Font.PLAIN, 15));
        annoLabel.setBounds(120, 620, 100, 20);
        annoLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(annoLabel);

        ArrayList<String> risultatoAnni= anniStr();
        String [] anni_values = new String[risultatoAnni.size()];
        anni_values = risultatoAnni.toArray(anni_values);
        JComboBox<String> annoComboBox = new JComboBox<>(anni_values);
        annoComboBox.setBounds(120, 640, 100, 20);
        labelSfondo.add(annoComboBox);
        
        JLabel meseLabel = new JLabel("Mese");
        meseLabel.setFont(new Font("", Font.PLAIN, 15));
        meseLabel.setBounds(230, 620, 100, 20);
        meseLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(meseLabel);
        
        String [] mesi_values = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        JComboBox<String> meseComboBox = new JComboBox<>(mesi_values);
        meseComboBox.setBounds(230, 640, 100, 20);
        labelSfondo.add(meseComboBox);
        
        JLabel mfMeseLabel = new JLabel("M/F Mese");
        mfMeseLabel.setFont(new Font("", Font.PLAIN, 15));
        mfMeseLabel.setBounds(340, 620, 100, 20);
        mfMeseLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(mfMeseLabel);

        String [] mf_values = {"M", "F"};
        JComboBox<String> mfMeseComboBox = new JComboBox<>(mf_values);
        mfMeseComboBox.setBounds(340, 640, 100, 20);
        labelSfondo.add(mfMeseComboBox);
        
        JButton applicaFiltroButton = new JButton("Applica filtro");
        applicaFiltroButton.setBounds(450, 640, 120, 20);
        applicaFiltroButton.setBackground(new java.awt.Color(0, 255, 255));
        labelSfondo.add(applicaFiltroButton);
        
        JButton disattivaFiltroButton = new JButton("Disattiva filtro");
        disattivaFiltroButton.setBounds(575, 640, 120, 20);
        disattivaFiltroButton.setBackground(new java.awt.Color(0, 255, 255));
        labelSfondo.add(disattivaFiltroButton);
        
        JButton eliminaPeriodoButton = new JButton("Elimina periodo");
        eliminaPeriodoButton.setBounds(705, 640, 150, 20);
        eliminaPeriodoButton.setBackground(new java.awt.Color(77, 191, 171));
        labelSfondo.add(eliminaPeriodoButton);
        
        JLabel totalePeriodoLabel = new JLabel("Totale Periodo");
        totalePeriodoLabel.setFont(new Font("", Font.PLAIN, 15));
        totalePeriodoLabel.setBounds(865, 620, 120, 20);
        totalePeriodoLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(totalePeriodoLabel);

        JTextField totalePeriodoTextField = new JTextField();
        totalePeriodoTextField.setBounds(865, 640, 120, 20);
        totalePeriodoTextField.setBackground(new java.awt.Color(203, 203, 146));
        labelSfondo.add(totalePeriodoTextField);
        
        JButton stampaScadenzeButton = new JButton("Stampa scadenze");
        stampaScadenzeButton.setBounds(1150, 20, 150, 35);
        stampaScadenzeButton.setBackground(new java.awt.Color(210, 254, 132));
        labelSfondo.add(stampaScadenzeButton);
        
        anagrafiche_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AnagraficheAziende a = new AnagraficheAziende();
            }
        });
        
        rate_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TabellaRate t = new TabellaRate();
            }
        });
        
        aggiungiRigaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
           	 int result = scadenzePresenti();
             System.out.println("Result: " + result);
             int numeroScadenza = calcoloNumeroScadenza(result);
             int cliccatoNome = nomeComboBox.getSelectedIndex();
           	 String nomeAnagrafiche = risultatoAnagraficheAziende.get(cliccatoNome).toString();
           	 String categoria = anagraficaAziendaId(nomeAnagrafiche);
           	 int cliccatoBanca = bancaComboBox.getSelectedIndex();
           	 String banca = risultatoBanche.get(cliccatoBanca).toString();
           	 int cliccatoRata = rataNumComboBox.getSelectedIndex();
          	 String rata = risultatoRate.get(cliccatoRata).toString();
           	 Scadenza scadenza = new Scadenza(numeroScadenza, categoria, nomeAnagrafiche, docNumTextField.getText(), dataDocTextField.getText(), 
						 Double.parseDouble(imponibileTextField.getText()), Double.parseDouble(ivaTextField.getText()), Double.parseDouble(totaleRataTextField.getText()), banca, scadenzaTextField.getText(), rata);
			
           	
           	model.addRow(new Object[] {scadenza.getCategoria(), scadenza.getNome(), 
           			scadenza.getDoc_num(), scadenza.getData_doc(), scadenza.getImponibile(), scadenza.getIva(), 
           			scadenza.getTotale(), scadenza.getCod_banca(), scadenza.getData_scad(), scadenza.getN_rata()});
           	System.out.println(scadenza.toString());
           	inserisciScadenzaDb(scadenza);
           	
           	docNumTextField.setText(null);
           	dataDocTextField.setText(null); 
  			imponibileTextField.setText(null);
  			ivaTextField.setText(null);
  			totaleRataTextField.setText(null);
  			scadenzaTextField.setText(null);
       
           }
       });
        
        
        stampaScadenzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int cliccatoMese = meseComboBox.getSelectedIndex();
             	String mese = mesi_values[cliccatoMese].toString();
             	int cliccatoAnno = annoComboBox.getSelectedIndex();
             	String anno = risultatoAnni.get(cliccatoAnno).toString();
             	int cliccatoCategoria = categoriaComboBox.getSelectedIndex();
             	String categoria = categorie_values[cliccatoCategoria].toString();
             	int cliccatoMF = mfMeseComboBox.getSelectedIndex();
             	String mf = mf_values[cliccatoMF].toString();
            	ArrayList<Scadenza> scadenze = scadenzeFiltrate(categoria, anno, mese, mf);
            	
            	for(int i=0; i < scadenze.size(); i++) {
            		inserisciPerStampa(scadenze.get(i));
            	}
            	
            	ReportScadenze r = new ReportScadenze();
            	try {
					r.generaReport(categoria, anno, mese, mf);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	eliminaPerStampa();
            }
    	});
	    
        ArrayList<Scadenza> scadenze = scadenzeDaDb();
    	for(int i=0; i < scadenze.size(); i++) {
    		model.addRow(new Object[] {scadenze.get(i).getCategoria(), scadenze.get(i).getNome(), 
    				scadenze.get(i).getDoc_num(), scadenze.get(i).getData_doc(), scadenze.get(i).getImponibile(), scadenze.get(i).getIva(), 
    				scadenze.get(i).getTotale(), scadenze.get(i).getCod_banca(), scadenze.get(i).getData_scad(), scadenze.get(i).getN_rata()});
    	}
    	
    	applicaFiltroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int cliccatoMese = meseComboBox.getSelectedIndex();
             	String mese = mesi_values[cliccatoMese].toString();
             	int cliccatoAnno = annoComboBox.getSelectedIndex();
             	String anno = risultatoAnni.get(cliccatoAnno).toString();
             	int cliccatoCategoria = categoriaComboBox.getSelectedIndex();
             	String categoria = categorie_values[cliccatoCategoria].toString();
             	int cliccatoMF = mfMeseComboBox.getSelectedIndex();
             	String mf = mf_values[cliccatoMF].toString();
            	ArrayList<Scadenza> scadenze = scadenzeFiltrate(categoria, anno, mese, mf);
            	
            	model.setRowCount(0);
            	for(int i=0; i < scadenze.size(); i++) {
            		model.addRow(new Object[] {scadenze.get(i).getCategoria(), scadenze.get(i).getNome(), 
            				scadenze.get(i).getDoc_num(), scadenze.get(i).getData_doc(), scadenze.get(i).getImponibile(), scadenze.get(i).getIva(), 
            				scadenze.get(i).getTotale(), scadenze.get(i).getCod_banca(), scadenze.get(i).getData_scad(), scadenze.get(i).getN_rata()});
            	}
            	
            	double totale = 0.0;
            	for(int i=0; i < scadenze.size(); i++) {
            		totale += scadenze.get(i).getTotale();
            	}
            	totalePeriodoTextField.setText(String.valueOf(totale));
            	
            }
    	});
    	
    	disattivaFiltroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	model.setRowCount(0);
            	ArrayList<Scadenza> scadenze = scadenzeDaDb();
            	for(int i=0; i < scadenze.size(); i++) {
            		model.addRow(new Object[] {scadenze.get(i).getCategoria(), scadenze.get(i).getNome(), 
            				scadenze.get(i).getDoc_num(), scadenze.get(i).getData_doc(), scadenze.get(i).getImponibile(), scadenze.get(i).getIva(), 
            				scadenze.get(i).getTotale(), scadenze.get(i).getCod_banca(), scadenze.get(i).getData_scad(), scadenze.get(i).getN_rata()});
            	}
            }
    	});
    	
    	
    	eliminaPeriodoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int cliccatoMese = meseComboBox.getSelectedIndex();
             	String mese = mesi_values[cliccatoMese].toString();
             	int cliccatoAnno = annoComboBox.getSelectedIndex();
             	String anno = risultatoAnni.get(cliccatoAnno).toString();
             	int cliccatoCategoria = categoriaComboBox.getSelectedIndex();
             	String categoria = categorie_values[cliccatoCategoria].toString();
             	int cliccatoMF = mfMeseComboBox.getSelectedIndex();
             	String mf = mf_values[cliccatoMF].toString();
            	ArrayList<Scadenza> scadenze = scadenzeFiltrate(categoria, anno, mese, mf);
            	for(int i=0; i < scadenze.size(); i++) {
            		eliminaPeriodo(scadenze.get(i));
            	}
            	model.setRowCount(0);
            	
            }
    	});
    	
        
		window.setLayout(null);
        window.setVisible(true);
	}
	
	public static void eliminaPerStampa() {
		Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("truncate sys.scadenze_stampa;");
    		
    		pstmt.executeUpdate(); 
            
            con.close(); 
        }  catch (SQLException ex) {
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
	}
	
	public static void eliminaPeriodo(Scadenza scadenza) {
		String SQL = "DELETE FROM sys.scadenze WHERE id = ? ";
    	PreparedStatement pstmt = null;

    	Connection con  = Database.connect();

    	
    	try {
    		pstmt = con.prepareStatement(SQL); 
			pstmt.setInt(1, scadenza.getId());
			pstmt.executeUpdate();
			con.close(); 
        }  catch (SQLException ex) {
        	ex.printStackTrace();

        } finally {
            try {
                if (pstmt != null) {
                	pstmt.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
	}
	
	public static void inserisciPerStampa(Scadenza scadenza) {
		Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	String cod_banca = scadenza.getCod_banca();
    	String nome = scadenza.getNome();
    	String doc_num = scadenza.getDoc_num();
    	String data_scad = scadenza.getData_scad();
    	String n_rata = scadenza.getN_rata();
    	double totale = scadenza.getTotale();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.scadenze_stampa (cod_banca, nome, doc_num, data_scad, n_rata, totale) VALUE \r\n"
    				+ "        (?,?,?,?,?,?)");
    		pstmt.setString(1, cod_banca );
    		pstmt.setString(2, nome);
    		pstmt.setString(3, doc_num);
    		pstmt.setString(4, data_scad);
    		pstmt.setString(5, n_rata);
    		pstmt.setDouble(6, totale);
    		
    		pstmt.executeUpdate(); 
            
            con.close(); 
        }  catch (SQLException ex) {
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
	}
	
	public static void inserisciScadenzaDb(Scadenza scadenza) {
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	
    	int id = scadenza.getId();
    	String categoria = scadenza.getCategoria();
    	String nome = scadenza.getNome();
    	String doc_num = scadenza.getDoc_num();
    	String data_doc = scadenza.getData_doc(); 
    	double imponibile = scadenza.getImponibile();
    	double iva = scadenza.getIva();
    	double totale = scadenza.getTotale();
    	String cod_banca = scadenza.getCod_banca();
    	String data_scad = scadenza.getData_scad();
    	String n_rata = scadenza.getN_rata();
    	
    	try { 
    		PreparedStatement pstmt = con.prepareStatement("INSERT INTO sys.scadenze (id, categoria, nome, doc_num, data_doc, imponibile, "
    				+ "iva, totale, cod_banca, data_scad, n_rata) VALUE \r\n"
    				+ "        (?,?,?,?,?,?,?,?,?,?,?)");
    		pstmt.setInt(1, id );
    		pstmt.setString(2, categoria);
    		pstmt.setString(3, nome);
    		pstmt.setString(4, doc_num);
    		pstmt.setString(5, data_doc);
    		pstmt.setDouble(6, imponibile);
    		pstmt.setDouble(7, iva);
    		pstmt.setDouble(8, totale);
    		pstmt.setString(9, cod_banca);
    		pstmt.setString(10, data_scad);
    		pstmt.setString(11, n_rata);
    		
    		pstmt.executeUpdate(); 
            
            con.close(); 
        }  catch (SQLException ex) {
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }
	
	public static ArrayList<String> anagraficheAziendeNomeStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> anagraficheAziende = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.anagrafica_aziende ORDER BY codice DESC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String nome = rs.getString("nome_stampa"); 
            	anagraficheAziende.add(nome);
                System.out.println(nome);
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return anagraficheAziende;
		
    }
	
	public static String anagraficaAziendaId(String nome) {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
        String categoria = null;
    	Connection con  = Database.connect();
    	try {
            pstmt = con.prepareStatement("SELECT cf FROM sys.anagrafica_aziende WHERE nome_stampa = ?;");
            pstmt.setString(1, nome);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            	categoria = rs.getString("cf");
            }
            
            
            
        } catch (SQLException ex) {
        	ex.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                	pstmt.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		
    	
    	return categoria;
    }
	
	public static ArrayList<String> bancaCodiceStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> banche = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.banca ORDER BY codiceBanca ASC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String codice = rs.getString("codiceBanca"); 
            	banche.add(codice);
                System.out.println(codice);
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return banche;
		
    }
	
	public static ArrayList<String> rateNomeStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> rate = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.rate ORDER BY idrate ASC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String nome = rs.getString("nome"); 
            	rate.add(nome);
                System.out.println(nome);
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return rate;
		
    }
	
	public static ArrayList<String> anniStr(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<String> anni = new ArrayList<String>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.anni ORDER BY anno DESC;");                 
            System.out.println("query eseguita");
            while (rs.next()) {
            	String anno = rs.getString("anno"); 
            	anni.add(anno);
                System.out.println(anno);
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return anni;
		
    }
	
	public static ArrayList<Scadenza> scadenzeDaDb(){
    	Statement st = null;
        ResultSet rs = null;
    	Connection con  = Database.connect();
    	ArrayList<Scadenza> scadenze = new ArrayList<Scadenza>(); 
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.scadenze ORDER BY id ASC;");                 
            System.out.println("query eseguita articoli da db");
            while (rs.next()) {
            	Scadenza scadenza = new Scadenza();
            	
            	scadenza.setId(rs.getInt("id"));
            	scadenza.setCategoria(rs.getString("categoria"));
            	scadenza.setNome(rs.getString("nome"));
            	scadenza.setDoc_num(rs.getString("doc_num"));
            	scadenza.setData_doc(rs.getString("data_doc"));
            	scadenza.setImponibile(rs.getDouble("imponibile"));
            	scadenza.setIva(rs.getDouble("iva"));
            	scadenza.setTotale(rs.getDouble("totale"));
            	scadenza.setCod_banca(rs.getString("cod_banca"));
            	scadenza.setData_scad(rs.getString("data_scad"));
            	scadenza.setN_rata(rs.getString("n_rata"));
            	scadenze.add(scadenza);
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		return scadenze;
		
    }
	
	public static int calcoloNumeroScadenza(int result) {
    	Statement st = null;
        ResultSet rs = null;
        int numeroScadenza=0;
    	Connection con  = Database.connect();
    	if(result == 1) {
    		try {
                st = con.createStatement();
                rs = st.executeQuery("SELECT id as last_id FROM sys.scadenze ORDER BY id DESC LIMIT 1;");                 
                while (rs.next()) {
                	numeroScadenza = rs.getInt("last_id");
                	System.out.println("NumeroVendita arrivato: " +numeroScadenza);
                	numeroScadenza = numeroScadenza + 1;
                	System.out.println("NumeroVendita modificato: " +numeroScadenza);
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

                } catch (SQLException ex) {
                   ex.printStackTrace();
                }
            }
    	}else {
    		String newNumeroScadenza = "1";
    		numeroScadenza = Integer.parseInt(newNumeroScadenza);
    	}
    	
    	return numeroScadenza;
    }
 
 public static int scadenzePresenti() {
    	Statement st = null;
        ResultSet rs = null;
        int result = 0;
    	Connection con  = Database.connect();
    	try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM sys.scadenze;");                 
            
            if (rs.next() == false) {
                System.out.println("ResultSet in empty in Java");
                result = 0;
            }else {
            	result = 1;
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

            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
		
    	
    	return result;
    }
 
 
 public static ArrayList<Scadenza> scadenzeFiltrate(String categoria, String anno, String mese, String giorno) {
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Connection con = Database.connect();
	    ArrayList<Scadenza> scadenze = new ArrayList<Scadenza>();
	    
	    System.out.println("Dati: " + categoria + ", " + anno + ", " + mese + ", " + giorno);

	    try {
	        if (giorno.equals("F")) {
	            pstmt = con.prepareStatement("select * from sys.scadenze where categoria = ? and data_scad like ? and data_scad like ? and data_scad like '31%';");
	        } else {
	            pstmt = con.prepareStatement("select * from sys.scadenze where categoria = ? and data_scad like ? and data_scad like ? and data_scad not like '31%';");
	        }

	        pstmt.setString(1, categoria);
	        pstmt.setString(2, "%" + anno);
	        pstmt.setString(3, "%" + mese + "%");
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Scadenza scadenza = new Scadenza();
	            scadenza.setId(rs.getInt("id"));
	            scadenza.setCategoria(rs.getString("categoria"));
	            scadenza.setNome(rs.getString("nome"));
	            scadenza.setDoc_num(rs.getString("doc_num"));
	            scadenza.setData_doc(rs.getString("data_doc"));
	            scadenza.setImponibile(rs.getDouble("imponibile"));
	            scadenza.setIva(rs.getDouble("iva"));
	            scadenza.setTotale(rs.getDouble("totale"));
	            scadenza.setCod_banca(rs.getString("cod_banca"));
	            scadenza.setData_scad(rs.getString("data_scad"));
	            scadenza.setN_rata(rs.getString("n_rata"));
	            System.out.println(scadenza.toString());
	            scadenze.add(scadenza);
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }

	    return scadenze;
	}

	
}
