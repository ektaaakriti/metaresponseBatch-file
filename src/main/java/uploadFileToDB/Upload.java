package uploadFileToDB;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;



public class Upload {
	static connectToDb DB=new connectToDb();
	 static Connection dbcon=DB.connect_db();

	 static Properties properties = DB.getProperties();
	 public static Logger log = LogManager.getLogger(Upload.class.getName());
	 public int NewTruckersData(int i) throws IOException, ParseException {
			
		 
	     
	    	 String csvFilePath =properties.getProperty("csvpath");
	        int batchSize = 20;
	 
	        
	 
	        ICsvBeanReader beanReader = null;
	        
	 
	        try {
	            long start = System.currentTimeMillis();
	 
	            
	           dbcon.setAutoCommit(false);
	 
	         
	            String sql = "INSERT INTO applicant_table( vehicle_no,company_name,applicant_firstname,applicant_lastname,applicant_date_of_birth,maritalstatus,nominee_name,nominee_dob,nominee_age,nominee_relation,spouse_name,applicant_father_firstname,religion,applicant_qualification,applicant_employment_type,applicant_address_line_1,applicant_city_name,applicant_pin,applicant_mobile_no,no_of_family_member,no_of_working_member,house_type,	Ration_Card,medical_insurance,current_loan_outstanding_principle,current_loan_outstanding_interest,applicant_income,income_from_other_sources,food_expenses,houserent,house_renovation_expenses,total_monthly_bill_payment,applicant_expense_monthly) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement statement = dbcon.prepareStatement(sql);
	            System.out.println("ate3");
	            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
	            String lineText = null;
	 
	            int count = 0;
	 
	            lineReader.readLine();
	 
	            while ((lineText = lineReader.readLine()) != null) {
	            System.out.println("date2"); 
	            String[] data = lineText.split(",");	
	            	String vehicle_no=data[0];
	           	 String company_name=data[1];
	           	 String applicant_name=data[2];
	           	 String applicant_date_of_birth=data[3];
	           	 int AGE=Integer.parseInt(data[4]);
	           	 String maritalstatus=data[5];
	           	 String nominee_name=data[6];
	           	 System.out.println("date1");
	           	 String NOMINEE_DOB=data[7];
	           	System.out.println("date111");
	           	int NOMINEE_AGE=0;
	           	if(!data[8].isEmpty()) {
	             NOMINEE_AGE=Integer.parseInt(data[8]);}
	            System.out.println("date12");
	           	 String NOMINEE_RELATION=data[9];
	           	System.out.println("date13");
	           	 String SPOUSE_NAME=data[10];
	           	String FATHER_NAME=data[11];
	           	String RELIGION=data[12];
	           	String Education=data[13];
	           	String Permanent_Contract_Job=data[14];
	           	String ADDRESS=data[15];
	           	String VILLAGE_NAME_city=data[16];
	           	System.out.println(VILLAGE_NAME_city);
	           	System.out.println("date4");
	           	System.out.println(data[17]);
	           	int PINCODE=Integer.parseInt(data[17]);
	           	long mobile_no=0;
	           	if(!data[18].isEmpty())
	           	{ mobile_no=Long.parseLong(data[18]);}
	        	int Nos_Of_Family_Members=0;
	        	System.out.println("date41");
	        	if(!data[19].isEmpty())
	        	{ Nos_Of_Family_Members=Integer.parseInt(data[19]);}
	        	int Nos_of_working_Members=0;
	        	System.out.println("date42");
	        	if(!data[20].isEmpty())
	        	{ Nos_of_working_Members=Integer.parseInt(data[20]);}
	           	String House_type=data[21];
	           	System.out.println("date43");
	           	String Ration_Card=data[22];
	           	String Medical_Insurance=data[23];
	           	Float Loan_OUTSTANDING_PRINCIPAL=(float) 0.0;
	           	System.out.println("date44");
	           	if(!data[24].isEmpty())
	           	{Loan_OUTSTANDING_PRINCIPAL=Float.parseFloat(data[24]);}
	           	System.out.println("date45");
	           	Float CURRENT_LOAN_OUTSTANDING_INTEREST=(float) 0;
	           	if(!data[25].isEmpty())
	           	{CURRENT_LOAN_OUTSTANDING_INTEREST=Float.parseFloat(data[25]);}
	           	System.out.println("date46");
	           	Float TRUCK_INCOME=(float) 0;
	           	if(!data[26].isEmpty())
	           	{TRUCK_INCOME=Float.parseFloat(data[26]);}
	           	System.out.println("date47");
	           	Float INCOME_FROM_OTHER_SOURCES=(float) 0;
	           	if(!data[27].isEmpty())
	           	{INCOME_FROM_OTHER_SOURCES=Float.parseFloat(data[27]);}
	           	System.out.println("date48");
	           	Float Monthly_Food_Expenditure=(float) 0;
	           	if(!data[28].isEmpty())
	           	{Monthly_Food_Expenditure=Float.parseFloat(data[28]);}
	           	Float Rent=(float) 0;
	           	if(!data[29].isEmpty())
	           	{ Rent=Float.parseFloat(data[29]);}
	           	System.out.println("date49");
	           	Float House_Repair=(float) 0;
	           	if(!data[30].isEmpty())
	           	{House_Repair=Float.parseFloat(data[30]);}
	           	System.out.println("date50");
	        	Float Total_Monthly_Bill_Payment=(float) 0;
	        	if(!data[31].isEmpty())
	        	{ Total_Monthly_Bill_Payment=Float.parseFloat(data[31]);}
	        	System.out.println("date51");
	        	Float Total_Monthly_Expenses=(float) 0;
	        	if(!data[32].isEmpty())
	           	{Total_Monthly_Expenses=Float.parseFloat(data[32]);}
	          // 	VEHICLE NO	COMPANY NAME	TRUCK_DRIVER_NAME	DATE_OF_BIRTH (DD/MM/YY)	AGE	MARRIED/UN MARRIED/WIDOW/WIDOWER/DIVORCED	NOMINEE_NAME	NOMINEE_DOB (DD/MM/YYYY)	NOMINEE_AGE	NOMINEE_RELATION	SPOUSE NAME	FATHER NAME	RELIGION	Education 1. Upto Class 10, Class 12. Graduate and avove	Permanent/Contract Job	ADDRESS	VILLAGE_NAME/ CITY	PINCODE	Contact N os Phone / Mobile	Nos Of Family Members	Nos of working Members	House Own/ Rented	Ration Card Y/N	Mrdical Insurance Y/N	CURRENT A|LAON OUTSTANDING_PRINCIPAL (IF ANY)	CURRENT LOAN OUTSTANDING_INTEREST	TRUCK_INCOME	INCOME FROM OTHER SOURCES	Monthly Food Expenditure	Rent	House Repair	Total Monthly Bill Payment (Elec, Water etyc.)	Total Monthly Expenses
	           	statement.setString(1, vehicle_no);
	           	statement.setString(2,company_name);
	           	statement.setString(3,applicant_name);
	        	System.out.println("dobb");

	           	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	           if(!applicant_date_of_birth.isEmpty()) {
	           	String[] dobbb=applicant_date_of_birth.trim().split("\\.");
	           	System.out.println(applicant_date_of_birth);
	         	
	           	System.out.println(dobbb.length);
	           	System.out.println(dobbb[0]);
	           	String dobb=dobbb[0]+"-"+dobbb[1]+"-"+dobbb[2];
	           	System.out.println(dobb);
	           	java.util.Date date = sdf1.parse(dobb);
	           	java.sql.Date app_dob = new java.sql.Date(date.getTime());
	           	statement.setDate(4, app_dob);}
	           	statement.setInt(5,AGE);
	           	statement.setString(6, maritalstatus);
	           	statement.setString(7, nominee_name);
	           	if(!NOMINEE_DOB.isEmpty()) {
	           	String[] dob1=NOMINEE_DOB.split(".");
	           	String dobb1=dob1[0]+"-"+dob1[1]+"-"+dob1[2];
	           	java.util.Date date1 = sdf1.parse(dobb1);
	           	java.sql.Date nom_dob = new java.sql.Date(date1.getTime());
	           	statement.setDate(8, nom_dob);}
	           	statement.setDate(8,null);
	           	statement.setInt(9, NOMINEE_AGE);
	           	statement.setString(10, NOMINEE_RELATION);
	           	statement.setString(11, SPOUSE_NAME);
	           	statement.setString(12, FATHER_NAME);
	           	statement.setString(13, RELIGION);
	           	statement.setString(14, Education);
	           	statement.setString(15, Permanent_Contract_Job);
	           	statement.setString(16, ADDRESS);
	           	System.out.println(VILLAGE_NAME_city);
	           	statement.setString(17,VILLAGE_NAME_city);
	           	statement.setInt(18,PINCODE);
	           	statement.setLong(19,mobile_no);
	           	statement.setInt(20,Nos_Of_Family_Members);
	           	statement.setInt(21,Nos_of_working_Members);
	           	statement.setString(22,House_type);
	           	statement.setString(23,Ration_Card);
	           	statement.setString(24,Medical_Insurance);
	           	statement.setFloat(25,Loan_OUTSTANDING_PRINCIPAL);
	           	statement.setFloat(26,CURRENT_LOAN_OUTSTANDING_INTEREST);
	           	statement.setFloat(27,TRUCK_INCOME);
	           	statement.setFloat(28,INCOME_FROM_OTHER_SOURCES);
	           	statement.setFloat(29, Monthly_Food_Expenditure);
	           	statement.setFloat(30,Rent);
	           	statement.setFloat(31,House_Repair);
	           	statement.setFloat(32,Total_Monthly_Bill_Payment);
	           	statement.setFloat(33,Total_Monthly_Expenses);

	               	         
	                statement.addBatch();}
	              
	 i++;
	                if (count % batchSize == 0) {
	                    statement.executeBatch();
	                    count++;
	                }
	                
	            
	 
	            beanReader.close();
	 
	            // execute the remaining queries
	            statement.executeBatch();
	 
	            dbcon.commit();
	         
	 
	            long end = System.currentTimeMillis();
	            System.out.println("Execution Time: " + (end - start));
	        } catch (IOException ex) {
	            log.error("File not found"+ex);
	        } catch (SQLException ex) {
	        	log.error("file not found"+ex);
	 
	            try {
	                dbcon.rollback();
	            } catch (SQLException e) {
	            	log.error(e);
	            }
	        }
	 
	    DB.moveFile(i,csvFilePath);
		return i;
	       
	 }
	
	
}

