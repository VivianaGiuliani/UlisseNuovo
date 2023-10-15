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

public class ReportRiparazioniArgenteriaNegozi {
	public static void generaReport() throws JRException {
		Connection con  = Database.connect();
		InputStream arq = ReportDistinte.class.getResourceAsStream("/Report/riparazioniArgenteriaNegozi.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		
		JasperPrint print = JasperFillManager.fillReport(report, null, con);
		
		
		JasperViewer.viewReport(print, false);
	}
}
