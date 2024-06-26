package uploadFileToDB;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JasperReportPDFGenerator {
	//static connectToDb DB=new connectToDb();
	// static Connection dbcon=DB.connect_db();

	// static Properties properties = DB.getProperties();
		// public static Logger log = LogManager.getLogger(UploadExcel.class.getName());
    public void generateReport() {
    	 try {
    	        connectToDb DB = new connectToDb();
    	        Connection dbcon = DB.connect_db();

    	        Properties properties = DB.getProperties();
    	        String jrxmlFile = "metaresponse.jrxml"; // Assuming it's in the resources directory
    	        String outputFile = properties.getProperty("path_to_pdf");

    	        // Compile JRXML file
    	        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(jrxmlFile);
    	        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

    	        // Fetch data from your database
    	        // You can execute your SQL query here if needed

    	        // Pass parameters if necessary
    	        java.util.Map<String, Object> parameters = new java.util.HashMap<>();
    	        // Add parameters if needed
    	        // parameters.put("paramName", paramValue);

    	        // Fill the report with data
    	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dbcon);

    	        // Export the report to PDF
    	        JRPdfExporter exporter = new JRPdfExporter();
    	        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(outputFile)));
    	        exporter.exportReport();
    	        DB.updateFlag();
    	        // Close the database connection
    	        dbcon.close();

    	        System.out.println("Report generated successfully.");

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	}
    
}

