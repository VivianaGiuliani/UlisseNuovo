package Classi;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportScadenze{
		public void generaReport(String categoria, String anno, String mese, String mf) throws JRException {
		Connection con  = Database.connect();
		
		if(categoria.equals("F")) {
			categoria = "Fornitori";
		}else if(categoria.equals("C")) {
			categoria = "Clienti";
		}else {
			categoria = "Spese";
		}
		
		if(mf.equals("M")) {
			mf = "Metà";
		}else {
			mf = "Fine";
		}
		
		InputStream arq = ReportDistinte.class.getResourceAsStream("/Report/scadenzeStampa.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("categoria", categoria);
		parameters.put("mf", mf);
		parameters.put("mese", mese);
		parameters.put("anno", anno);
		
		JasperPrint print = JasperFillManager.fillReport(report, parameters, con);
		
		JasperViewer.viewReport(print, false);
		
	}
}
