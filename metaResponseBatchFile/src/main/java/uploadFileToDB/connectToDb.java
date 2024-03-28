package uploadFileToDB;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;

//import java.util.logging.Level;




public class connectToDb {
	
	
	String username ="";
	String password ="";
	String dbconfStr="";
	 
	Properties properties = new Properties();
	public static Logger log = LogManager.getLogger(connectToDb.class.getName());
	 
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	connectToDb(){
		loadPropertiesFile();
		this.username=properties.getProperty("dbuser");
		this.password=properties.getProperty("dbpassword");
		this.dbconfStr=properties.getProperty("DB_CONF_STRING");
		
		if (dbcon==null)
		{
				dbcon = connect_db();}
	}
	


	public static  Connection dbcon = null;//connect_db();

	private  void loadPropertiesFile(){
	    InputStream iStream= getClass().getClassLoader().getResourceAsStream("config.properties");
	    		try {
	       if(iStream!=null) {           
	    	   
	     
			properties.load(iStream);
	       } else {throw new FileNotFoundException("Property file Not found");}
	      } catch (IOException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	      }finally {
	        try {
	          if(iStream != null){
	            iStream.close();
	          }
	        } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	      }
	    }
	 
	 public  Connection connect_db() {

			Connection con = null;
			
			try {
				
			   // System.out.println("username is "+username);
				//System.out.println("password is "+password);
				System.out.println("str is"+dbconfStr);
				con = DriverManager.getConnection(dbconfStr, username, password);
			  // log.info("Database connection estblished");
			  
			} catch (Exception e) {
				//log.fatal("exception is" + e);

			}
			return con;

		}
	 public void updateFlag() {
		 String sqlQuery = "UPDATE metadata_response SET  report_flag='Y'";

	        try (
	             Statement statement = dbcon.createStatement()) {
	            // Execute the SQL query
	            int rowsAffected = statement.executeUpdate(sqlQuery);

	            // Check the number of rows affected
	            System.out.println("Rows affected: " + rowsAffected);
	            
	            // Display success message
	            System.out.println("Table updated successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 }
	
	
	
	 
	 
	  
	     

	 



