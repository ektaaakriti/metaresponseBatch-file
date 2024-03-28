/*package uploadFileToDB;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;



public class UpdatetruckersData {
	static connectToDb DB=new connectToDb();
	 static Connection dbcon=DB.connect_db();

	 static Properties properties = DB.getProperties();
	 public static Logger log = LogManager.getLogger(UpdatetruckersData.class.getName());
	 public int NewTruckersData(int i) throws IOException {
			
		 
	     
	    	 String csvFilePath =properties.getProperty("csvpath");
	        int batchSize = 20;
	 
	        
	 
	        ICsvBeanReader beanReader = null;
	        CellProcessor[] processors = new CellProcessor[] {
	          
	                new NotNull(), 
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(), 
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(), 
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(), 
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(), 
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(), 
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(),
	                new NotNull(), 
	                new NotNull(),
	                new NotNull() 
	        };
	 
	        try {
	            long start = System.currentTimeMillis();
	 
	            
	           dbcon.setAutoCommit(false);
	 
	          // String sql="Insert INTO asset_master( adobe_reader, aforesight_agent_id, anydesk, assets_status, auto_cad, delete_status, department_name, google_chrome, hd_capacity, hd_make, hd_model, hd_serial_number, java8, mbd_make, mbd_model, mbd_serial_number, ms_office_2007, ms_office_2010, ms_office_2013, ms_office_2016, mcafee_antivirus, microsoft_teams, monitor_model, monitor_screen_make, monitor_screen_size, monitor_serial_number, mozilla_firefox, os_version, one_drive, processor_details, procument_id, procured_date, product_type, ram_available, ram_used, retired_date, scan_date, site_name, software_list_with_version_and_installed_date, sub_department_name, symantec_antivirus, system_hostname, system_ip_address, system_make, system_model, system_os_type, system_serial_number, team_viewer, total_ram, trend_micro_antivirus, type_of_chipset, user_id, warranty_amc, warranty_amc_vendor_name, warrenty_amc_from, warrenty_amc_to, webex, winrar, zoom, zip7, os_key, os_license_details, system_form_factor) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            
	            String sql = "INSERT INTO asset_master( vehicle_no,company_name,applicant_firstname,applicant_lastname,applicant_date_of_birth,maritalstatus,nominee_name,nominee_dob,nominee_age,nominee_relation,spouse_name,applicant_father_firstname,religion,applicant_qualification,applicant_employment_type,applicant_address_line_1,applicant_city_name,applicant_pin,applicant_mobile_no,no_of_family_member,no_of_working_member,house_type,	Ration_Card,medical_insurance,current_loan_outstanding_principle,current_loan_outstanding_interest,applicant_income,income_from_other_sources,food_expenses,houserent,house_renovation_expenses,total_monthly_bill_payment,applicant_expense_monthly) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement statement = dbcon.prepareStatement(sql);

	            beanReader = new CsvBeanReader(new FileReader(csvFilePath), CsvPreference.STANDARD_PREFERENCE);
	           
	            beanReader.getHeader(true); // skip header line
	 
	           // String[] header = {"Scan_Date","System_Make","System_form_Factor","System_Model","System_Serial_Number","Product_Type",	"System_IP_Address","System_Hostname","System_OS_type","OS_License_details","OS_Version","OS_Key","Total_RAM","RAM_Available","RAM_Used","HD_Make","HD_Model","HD_Serial_Number","HD_Capacity","Processor_Details","MBD_Make","MBD_Model","MBD_Serial_Number","Type_of_Chipset","Monitor_Screen_Make","Monitor_Model","Monitor_Serial_Number","Monitor_Screen_Size","Assets_Status","Retired_Date","Software_list_with_version_and_installed_Date","Procured_Date","Procument_ID","Warranty_AMC","Warranty_AMC_Vendor_Name","Warrenty_AMC_From","Warrenty_AMC_To","User_ID","Department_Name","Site_Name","Sub_Department_Name","Aforesight_Agent_ID","MS_Office_2010", "MS_Office_2013", "MS_Office_2016","Adobe_Reader", "Java8", "Symantec_Antivirus", "Mcafee_Antivirus", "Trend_Micro_Antivirus", "Microsoft_Teams", "MS_Office_2007", "Anydesk", "OneDrive","zip7","Mozilla_Firefox", "Google_Chrome","Team_Viewer","Zoom","Webex","AutoCad","Winrar"};
	            String[] header= {"VEHICLE NO","COMPANY NAME","TRUCK_DRIVER_NAME","DATE_OF_BIRTH (DD/MM/YY)","AGE","MARRIED/UN MARRIED/WIDOW/WIDOWER/DIVORCED","NOMINEE_NAME","NOMINEE_DOB (DD/MM/YYYY)","NOMINEE_AGE","NOMINEE_RELATION","SPOUSE NAME","FATHER NAME","RELIGION","Education 1. Upto Class 10, Class 12. Graduate and avove","Permanent/Contract Job","ADDRESS","VILLAGE_NAME/ CITY","PINCODE","Contact N os Phone / Mobile","Nos Of Family Members","Nos of working Members",	"House Own/ Rented",	"Ration Card Y/N",	"Mrdical Insurance Y/N",	"CURRENT A|LAON OUTSTANDING_PRINCIPAL (IF ANY)","CURRENT LOAN OUTSTANDING_INTEREST",	"TRUCK_INCOME",	"INCOME FROM OTHER SOURCES",	"Monthly Food Expenditure","Rent",	"House Repair",	"Total Monthly Bill Payment (Elec, Water etyc.)",	"Total Monthly Expenses"};
	            

	            Bean bean = null;
	 
	            int count = 0;
	 
	            while ((bean = beanReader.read(Bean.class, header, processors)) != null) {
	            	String vehicle_no=bean.getVehicle_no();
	           	 String company_name=bean.getCompany_name();
	           	 String applicant_name=bean.getApplicant_name();
	           	 java.sql.Date applicant_date_of_birth=bean.getApplicant_date_of_birth();
	           	 int AGE=bean.getAGE();
	           	 String maritalstatus=bean.getMaritalstatus();
	           	 String nominee_name=bean.getNominee_name();
	           	 java.sql.Date NOMINEE_DOB=bean.getNOMINEE_DOB();
	           	 int NOMINEE_AGE=bean.getNOMINEE_AGE();
	           	 String NOMINEE_RELATION=bean.getNOMINEE_RELATION();
	           	 String SPOUSE_NAME=bean.getSPOUSE_NAME();
	           	String FATHER_NAME=bean.getFATHER_NAME();
	           	String RELIGION=bean.getRELIGION();
	           	String Education=bean.getEducation();
	           	String Permanent_Contract_Job=bean.getPermanent_Contract_Job();
	           	String ADDRESS=bean.getADDRESS();
	           	String VILLAGE_NAME_city=bean.getVILLAGE_NAME_city();
	           	int PINCODE=bean.getPINCODE();
	           	long mobile_no=bean.getMobile_no();
	           	int Nos_Of_Family_Members=bean.getNos_Of_Family_Members();
	           	int Nos_of_working_Members=bean.getNos_of_working_Members();
	           	String House_type=bean.getHouse_type();
	           	String Ration_Card=bean.getRation_Card();
	           	String Medical_Insurance=bean.getMedical_Insurance();
	           	Float Loan_OUTSTANDING_PRINCIPAL=bean.getLoan_OUTSTANDING_PRINCIPAL();
	           	Float CURRENT_LOAN_OUTSTANDING_INTEREST=bean.getCURRENT_LOAN_OUTSTANDING_INTEREST();
	           	Float TRUCK_INCOME=bean.getTRUCK_INCOME();
	           	Float INCOME_FROM_OTHER_SOURCES=bean.getINCOME_FROM_OTHER_SOURCES();
	           	Float Monthly_Food_Expenditure=bean.getMonthly_Food_Expenditure();
	           	Float Rent=bean.getRent();
	           	Float House_Repair=bean.getHouse_Repair();
	           	Float Total_Monthly_Bill_Payment=bean.getTotal_Monthly_Bill_Payment();
	           	Float Total_Monthly_Expenses=bean.getTotal_Monthly_Expenses();
	          // 	VEHICLE NO	COMPANY NAME	TRUCK_DRIVER_NAME	DATE_OF_BIRTH (DD/MM/YY)	AGE	MARRIED/UN MARRIED/WIDOW/WIDOWER/DIVORCED	NOMINEE_NAME	NOMINEE_DOB (DD/MM/YYYY)	NOMINEE_AGE	NOMINEE_RELATION	SPOUSE NAME	FATHER NAME	RELIGION	Education 1. Upto Class 10, Class 12. Graduate and avove	Permanent/Contract Job	ADDRESS	VILLAGE_NAME/ CITY	PINCODE	Contact N os Phone / Mobile	Nos Of Family Members	Nos of working Members	House Own/ Rented	Ration Card Y/N	Mrdical Insurance Y/N	CURRENT A|LAON OUTSTANDING_PRINCIPAL (IF ANY)	CURRENT LOAN OUTSTANDING_INTEREST	TRUCK_INCOME	INCOME FROM OTHER SOURCES	Monthly Food Expenditure	Rent	House Repair	Total Monthly Bill Payment (Elec, Water etyc.)	Total Monthly Expenses
	           	statement.setString(1, vehicle_no);
	           	statement.setString(2,company_name);
	           	statement.setString(3,applicant_name);
	           	statement.setDate(4, applicant_date_of_birth);
	           	statement.setInt(5,AGE);
	           	statement.setString(6, maritalstatus);
	           	statement.setString(7, nominee_name);
	           	statement.setDate(8, NOMINEE_DOB);
	           	statement.setInt(9, NOMINEE_AGE);
	           	statement.setString(10, NOMINEE_RELATION);
	           	statement.setString(11, SPOUSE_NAME);
	           	statement.setString(12, FATHER_NAME);
	           	statement.setString(13, RELIGION);
	           	statement.setString(14, Education);
	           	statement.setString(15, Permanent_Contract_Job);
	           	statement.setString(16, ADDRESS);
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
	            log.error("File not found");
	        } catch (SQLException ex) {
	        	log.error("file not found");
	 
	            try {
	                dbcon.rollback();
	            } catch (SQLException e) {
	            	log.error(e);
	            }
	        }
	 
	    DB.moveFile(i,csvFilePath);
		return i;
	       
	 }
	
	
}*/
