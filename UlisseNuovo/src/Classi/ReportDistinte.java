package Classi;

import java.io.InputStream;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Oggetti.StampaDistintaDatiFissi;
import Oggetti.StampaDistintaDatiTabella;
import Oggetti.StampaDistintaDatiVendita;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportDistinte {
	
	public static void generaReport(int numeroVendita) throws JRException {
		Connection con  = Database.connect();
		InputStream arq = ReportDistinte.class.getResourceAsStream("/Report/finale1.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("numeroVendita", numeroVendita);
		
		JasperPrint print = JasperFillManager.fillReport(report, parameters, con);
		
		
		
		JasperViewer.viewReport(print, false);
		
		
		
	}
}
