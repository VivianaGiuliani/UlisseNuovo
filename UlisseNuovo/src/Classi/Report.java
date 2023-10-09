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

import Oggetti.StampaDistintaDatiFissi;
import Oggetti.StampaDistintaDatiVendita;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.WhenNoDataTypeEnum;
import net.sf.jasperreports.view.JasperViewer;

public class Report {
	public void generaReport(ArrayList<StampaDistintaDatiVendita> array) throws JRException {
		
		
		InputStream arq = Report.class.getResourceAsStream("/Report/report1.jrxml");
		
		JasperReport report = JasperCompileManager.compileReport(arq);
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(array));
		
		
		JasperViewer.viewReport(print, false);
		
		
	}
}
