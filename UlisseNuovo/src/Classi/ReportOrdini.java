package Classi;

import java.io.InputStream;
import java.sql.Connection;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportOrdini {
	public static void generaReport() throws JRException {
		Connection con  = Database.connect();
<<<<<<< HEAD
		InputStream arq = ReportOrdini.class.getResourceAsStream("/Report/printOrdini.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
=======
		InputStream arq = ReportOrdini.class.getResourceAsStream("/Report/ordini.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		
>>>>>>> b164b6b180cf8b5232bb561dff47f01e24120b2b
		JasperPrint print = JasperFillManager.fillReport(report, null, con);
		
		
		JasperViewer.viewReport(print, false);
	}
}
