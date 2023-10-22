import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Classi.Database;
import Oggetti.Articolo;
import Oggetti.Categoria;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class SaldiCategoria {
	private JFrame window;
	private ImageIcon imageSfondo;
	private JLabel labelSfondo;
   public SaldiCategoria(){
	   	window = new JFrame();
		window.setSize(1000, 700);
		window.setTitle("Saldi Categoria");
		window.setResizable(false);
		
		labelSfondo = new JLabel(imageSfondo);
		labelSfondo.setSize(1400, 800);
	        
	    imageSfondo = new ImageIcon(this.getClass().getResource("/Images/background.png"));
	    Image img = imageSfondo.getImage();
	    Image imgScale = img.getScaledInstance(labelSfondo.getWidth(), labelSfondo.getHeight(), Image.SCALE_DEFAULT);
	    ImageIcon scaledIcon = new ImageIcon(imgScale);
	    labelSfondo.setIcon(scaledIcon);
	       
	    window.add(labelSfondo);

		JLabel saldi_categoria_label = new JLabel("Saldi Categoria");
		saldi_categoria_label.setFont(new Font("", Font.BOLD, 20));
		saldi_categoria_label.setBounds(10, 20, 180, 40);
		saldi_categoria_label.setForeground(new java.awt.Color(255,255,255));
        labelSfondo.add(saldi_categoria_label);

        JButton saldiCategoriaButton = new JButton("Stampa saldi categoria");
        saldiCategoriaButton.setBounds(10, 80, 200, 30);
        saldiCategoriaButton.setBackground(new java.awt.Color(132, 249, 58));
        labelSfondo.add(saldiCategoriaButton);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(10, 140, 950, 500);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 950, 500);

        String[] columnNames = {"Tipologia", "Nome", "Valore", "Peso", "Quantità"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.WIDTH);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        
        scrollPane.setViewportView(table);
        tablePanel.add(scrollPane);
        labelSfondo.add(tablePanel);
        ArrayList<Categoria> categorie = categorieDaDb();
        
        for(int i = 0; i < categorie.size(); i++) {
        	ArrayList<Integer> valori = valoriArticoliDaDb(categorie.get(i).getPk());
        	ArrayList<Integer> giacenze = giacenzeArticoliDaDb(categorie.get(i).getPk());
        	ArrayList<Double> pesi = pesiArticoliDaDb(categorie.get(i).getPk());
        	int tot_giacenze = 0;
        	int valore = 0;
        	double peso = 0.0;
        	for(int j = 0; j < valori.size(); j++) {
        		valore = valore + valori.get(j);
        	}
        	
        	for(int x = 0; x < pesi.size(); x++) {
        		peso = peso + pesi.get(x);
        	}
        	 
        	for(int k = 0; k < giacenze.size(); k++) {
        		tot_giacenze = tot_giacenze + giacenze.get(k);
        	}
        	model.addRow(new Object[] {categorie.get(i).getPk(), categorie.get(i).getCategoria(), valore, peso, tot_giacenze});
        }
        
        
        window.setLayout(null);
        window.setVisible(true);
       
    }
   
   public static ArrayList<Integer> valoriArticoliDaDb(int categoria){
   		Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
   		Connection con  = Database.connect();
   		ArrayList<Integer> valori = new ArrayList<Integer>();
   		
   		try { 
           pstmt = con.prepareStatement("SELECT giacenza, pr_unit FROM sys.articoli WHERE cod_categoria = ?;");

           pstmt.setInt(1, categoria);
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
   
   public static ArrayList<Integer> giacenzeArticoliDaDb(int categoria){
  		Statement st = null;
       ResultSet rs = null;
       PreparedStatement pstmt = null;
  		Connection con  = Database.connect();
  		ArrayList<Integer> giacenze = new ArrayList<Integer>();
  		
  		try { 
          pstmt = con.prepareStatement("SELECT giacenza FROM sys.articoli WHERE cod_categoria = ?;");

          pstmt.setInt(1, categoria);
          rs = pstmt.executeQuery();
          System.out.println("query eseguita articoli da db");
          while (rs.next()) {
       	 	 giacenze.add(rs.getInt("giacenza") ); 
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
   
   public static ArrayList<Double> pesiArticoliDaDb(int categoria){
 		Statement st = null;
 		ResultSet rs = null;
 		PreparedStatement pstmt = null;
 		Connection con  = Database.connect();
 		ArrayList<Double> pesi = new ArrayList<Double>();
 		
 		try { 
         pstmt = con.prepareStatement("SELECT peso FROM sys.articoli WHERE cod_categoria = ?;");

         pstmt.setInt(1, categoria);
         rs = pstmt.executeQuery();
         System.out.println("query eseguita articoli da db");
         while (rs.next()) {
      	 	 pesi.add(rs.getDouble("peso") ); 
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
   
   public static ArrayList<Categoria> categorieDaDb(){
		Statement st = null;
	    ResultSet rs = null;
		Connection con  = Database.connect();
		ArrayList<Categoria> categorie = new ArrayList<Categoria>(); 
		try {
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT * FROM sys.categoria ORDER BY pk ASC;");                 
	        System.out.println("query eseguita categorie da db");
	        while (rs.next()) {
	        	Categoria categoria = new Categoria();
	        	categoria.setPk(rs.getInt("pk"));
	        	categoria.setCategoria(rs.getString("categoria"));
	        	categoria.setMin_giac(rs.getInt("min_giac"));
	        	categorie.add(categoria);
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
		return categorie;
		
	}
    
}
