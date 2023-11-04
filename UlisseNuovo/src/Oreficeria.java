import java.io.File;
import java.io.FileOutputStream;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import Classi.Database;
import Oggetti.Articolo;
import Oggetti.Etichetta;

public class Oreficeria {
	public Oreficeria() throws IOException{
		
		ArrayList<Etichetta> etichette = etichetteDb();
		
		writeEtichetteToExcel(etichette, "etichette.xlsx");
		
		String path="cmd /c start oreficeria.bat";
		Runtime rn=Runtime.getRuntime();
		Process pr=rn.exec(path);
		
	}
	
	public static void writeEtichetteToExcel(ArrayList<Etichetta> etichette, String filePath) {
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Etichette");

	    int rownum = 0;
	    
	    // Crea una riga per le intestazioni
	    HSSFRow headerRow = sheet.createRow(rownum++);
	    
	    
	    int cellnum = 0;

	    // Aggiungi le intestazioni per ciascuna colonna
	    HSSFCell headerCell = headerRow.createCell(cellnum++);
	  
	    headerCell.setCellValue("Barcode");

	    headerCell = headerRow.createCell(cellnum++);
	    
	    headerCell.setCellValue("Descrizione");

	    headerCell = headerRow.createCell(cellnum++);
	   
	    headerCell.setCellValue("Peso");

	    headerCell = headerRow.createCell(cellnum++);
	    
	    headerCell.setCellValue("Caratura");

	    headerCell = headerRow.createCell(cellnum);
	
	    headerCell.setCellValue("Prezzo");
	    
	    // Ora inserisci i dati effettivi
	    for (Etichetta etichetta : etichette) {
	        HSSFRow row = sheet.createRow(rownum++);
	        cellnum = 0;

	        HSSFCell cell = row.createCell(cellnum++);
	        cell.setCellValue(etichetta.getBarcode());

	        cell = row.createCell(cellnum++);
	        cell.setCellValue(etichetta.getDescrizione());

	        cell = row.createCell(cellnum++);
	        cell.setCellValue(etichetta.getPeso());

	        cell = row.createCell(cellnum++);
	        cell.setCellValue(etichetta.getCaratura());

	        cell = row.createCell(cellnum);
	        cell.setCellValue(etichetta.getPrezzo());
	    }

	    try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
	        workbook.write(fileOut);
	        System.out.println("Dati scritti in Excel con successo.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	 public static ArrayList<Etichetta> etichetteDb(){
	    	Statement st = null;
	        ResultSet rs = null;
	        PreparedStatement pstmt = null;
	    	Connection con  = Database.connect();
	    	ArrayList<Etichetta> etichette = new ArrayList<Etichetta>(); 
	    	
	    	try { 
	            pstmt = con.prepareStatement("SELECT * FROM sys.etichette;");

             	
	            rs = pstmt.executeQuery();
	            System.out.println("query eseguita etichette da db");
	            while (rs.next()) {
	            	Etichetta etichetta = new Etichetta();
	            	
	            	etichetta.setBarcode(rs.getString("barcode"));
	            	etichetta.setDescrizione(rs.getString("descrizione"));
	            	etichetta.setPeso(rs.getDouble("peso"));
	            	etichetta.setCaratura(rs.getInt("caratura")); 
	            	etichetta.setPrezzo(rs.getDouble("prezzo"));
	            
	            	etichette.add(etichetta);
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
			return etichette;
			
	    }
}
