import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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

public class TotaliMacrocategorie  {
		private JFrame window;
		private ImageIcon imageSfondo;
		private JLabel labelSfondo;
    public TotaliMacrocategorie(){
    	JFrame window = new JFrame();
		window.setSize(700, 700);
		window.setTitle("Totali Macrocategorie");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);


        JLabel titoloLabel = new JLabel("Totali Macrocategorie");
        titoloLabel.setFont(new Font("", Font.PLAIN, 20));
        titoloLabel.setBounds(10, 10, 200, 30);
        titoloLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(titoloLabel);

        JLabel daCatLabel = new JLabel("Da Cat.");
        daCatLabel.setFont(new Font("", Font.PLAIN, 12));
        daCatLabel.setBounds(10, 50, 200, 20);
        daCatLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(daCatLabel);

        JTextField daCatTextField = new JTextField();
        daCatTextField.setBounds(10, 70, 150, 30);
        labelSfondo.add(daCatTextField);

        JLabel aCatLabel = new JLabel("A Cat.");
        aCatLabel.setFont(new Font("", Font.PLAIN, 12));
        aCatLabel.setBounds(170, 50, 200, 20);
        aCatLabel.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(aCatLabel);

        JTextField aCatTextField = new JTextField();
        aCatTextField.setBounds(170, 70, 150, 30);
        labelSfondo.add(aCatTextField);

        JButton elaborazioneButton = new JButton("Elaborazione");
        elaborazioneButton.setBounds(330, 68, 150, 35);
        elaborazioneButton.setBackground(new java.awt.Color(132, 249, 58));
        labelSfondo.add(elaborazioneButton);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 140, 650, 500);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 650, 500);
        String[] columnNames = {"Macro_Cat", "Valore_Tot", "Peso_Tot", "Quant_Tot"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        elaborazioneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int partenza = Integer.parseInt(daCatTextField.getText());
                int arrivo = Integer.parseInt(aCatTextField.getText());
                for(int i = partenza; i <= arrivo; i++) {
                	ArrayList<Integer> valori = valoriArticoliDaDb(String.valueOf(i));
                	System.out.println(valori);
                	ArrayList<Double> pesi = pesiArticoliDaDb(String.valueOf(i));
                	ArrayList<Integer> giacenze = giacenzeArticoliDaDb(String.valueOf(i));
                	int valore = 0;
                	double peso = 0.0;
                	int tot_giacenze = 0;
                	for(int j = 0; j < valori.size(); j++) {
                		valore = valore + valori.get(j);
                	}
                	
                	for(int x = 0; x < pesi.size(); x++) {
                		peso = peso + pesi.get(x);
                	}
                	for(int k = 0; k < giacenze.size(); k++) {
                		tot_giacenze = tot_giacenze + giacenze.get(k);
                	}
                	model.addRow(new Object[] {String.valueOf(i), valore, peso, tot_giacenze});
                }
            }
        });
        

        window.setLayout(null);
        window.setVisible(true);
      
    }
    
    public static ArrayList<Integer> valoriArticoliDaDb(String categoria){
   		Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
   		Connection con  = Database.connect();
   		ArrayList<Integer> valori = new ArrayList<Integer>();
   		String numero = categoria+"%";
   		System.out.println(numero);
   		try { 
           pstmt = con.prepareStatement("SELECT giacenza, pr_unit FROM sys.articoli WHERE cod_categoria LIKE ?;");
           
           pstmt.setString(1, numero);
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
    
    public static ArrayList<Double> pesiArticoliDaDb(String categoria){
   		Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
   		Connection con  = Database.connect();
   		ArrayList<Double> pesi = new ArrayList<Double>();
   		String numero = categoria+"%";
   		try { 
           pstmt = con.prepareStatement("SELECT peso FROM sys.articoli WHERE cod_categoria LIKE ?;");
           
           pstmt.setString(1, numero);
           rs = pstmt.executeQuery();
           System.out.println("query eseguita articoli da db");
           while (rs.next()) {
        	   pesi.add(rs.getDouble("peso"));
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
		return pesi;
		
   }
    
    public static ArrayList<Integer> giacenzeArticoliDaDb(String categoria){
   		Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
   		Connection con  = Database.connect();
   		ArrayList<Integer> giacenze = new ArrayList<Integer>();
   		String numero = categoria+"%";
   		try { 
           pstmt = con.prepareStatement("SELECT giacenza FROM sys.articoli WHERE cod_categoria LIKE ?;");
           
           pstmt.setString(1, numero);
           rs = pstmt.executeQuery();
           System.out.println("query eseguita articoli da db");
           while (rs.next()) {
        	   giacenze.add(rs.getInt("giacenza"));
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
		return giacenze;
		
   }
}
