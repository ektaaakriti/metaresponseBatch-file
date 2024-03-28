package uploadFileToDB;

import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class UploadExcel {
	DataCheck check=new DataCheck();
	static connectToDb DB=new connectToDb();
	 static Connection dbcon=DB.connect_db();

	 static Properties properties = DB.getProperties();
		 public static Logger log = LogManager.getLogger(UploadExcel.class.getName());
		 
		 public void NewTruckersData(List<String> FilePathList,String excelFilePath) throws IOException, ParseException, SQLException {
	//String excelFilePath = properties.getProperty("csvpath");
//List<String> FilePathList=DB.getFilename(excelFilePath);
System.out.println("file list size"+FilePathList.size());
if(FilePathList.size()>0) {
	System.out.println("file list size1"+FilePathList.size());
for(int a=0;a<FilePathList.size();a++){
	 System.out.println("File path "+FilePathList.get(a));
	 String excelFilePath1=excelFilePath.concat( FilePathList.get(a));
	 System.out.println("file path is"+excelFilePath1);
    int batchSize = 1000;
    java.util.Date dataentd = new java.util.Date(); 
	 java.sql.Date dataentdt = new java.sql.Date(dataentd.getTime());
    long start = System.currentTimeMillis();
  //  long millis=System.currentTimeMillis();
    java.sql.Date datesql=new java.sql.Date(start);
    Random r = new Random();
    int File_id = 1000 + (int)(r.nextDouble() * 9999);

	 try {
		
         FileInputStream inputStream = new FileInputStream(excelFilePath1);

         Workbook workbook = new XSSFWorkbook(inputStream);

         Sheet firstSheet = workbook.getSheetAt(0);
         Iterator<Row> rowIterator = firstSheet.iterator();
         
         int applicant_id_sequence=applicant_id();
         
         
         dbcon.setAutoCommit(false);
         System.out.println("2");
         String sql = "INSERT INTO applicant_table( vehicle_no,company_name,applicant_firstname,applicant_date_of_birth,age,maritalstatus,nominee_name,nominee_dob,nominee_age,nominee_relation,spouse_name,applicant_father_firstname,religion,applicant_qualification,applicant_employment_type,applicant_address_line_1,applicant_city_name,applicant_pin,applicant_mobile_no,no_of_family_member,no_of_earning_member,house_type,	Ration_Card,medical_insurance,current_loan_outstanding_principal,current_loan_outstanding_interest,applicant_income,income_from_other_sources,food_expenses,houserent,house_renovation_expenses,total_monthly_bill_payment,applicant_expense_monthly,applicant_id,created_by,dataentdt,company_code) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement statement = dbcon.prepareStatement(sql);    
          
         int count = 0;
          
         
         
         rowIterator.next(); // skip the header row
         Boolean vehicle = false;
         Boolean company = false;
         Boolean truckername=false;
         Boolean adob=false;
         Boolean agecheck=false;
         Boolean marital=false;
         Boolean nominee_nme=false;
         Boolean nominee_dob=false;
         Boolean nomine_age=false;
         Boolean nomineerelation=false;
         Boolean spousename=false;
         Boolean fathername = false;
         Boolean religio=false;
         Boolean jobType=false;
         Boolean edu=false;
         Boolean villagename=false;
         Boolean pincode=false;
         Boolean mobileno=false;
         Boolean  familyno =false;
         Boolean workingno=false;
         Boolean housetype=false;
         Boolean rationcard=false;
         Boolean medica=false;
         Boolean loann=false;
         Boolean interst=false;
         Boolean incom=false;
         Boolean otherincome=false;
         Boolean foodd=false;
         Boolean rentt=false;
         Boolean repairr=false;
         Boolean bil=false;
         Boolean otherr=false;
         String vehicle_no = null;
         String company_name=null;
         String company_code=null;
         String trucker_name =null;
         java.sql.Date app_dob = null;
         int age = 0;
         String marital_status=null;
         String nominee_name=null;
         Date nominee_date_of_birt = null;
         int nominee_age=0;
         String nominee_relation=null;
        		 String spouse_name=null;
        		  String father_name="";
        		  String religion="";
        		  String job_type="";
        		  String education="";
        		  String address="";
        		  String village_name="";
        		  int pin=0;
        		  Long mobile=(long) 0;
        		  int family_no =0;
        		  int working_no=0;
        		  String house_type="";
        		  String ration_card="";
        		  String medical="";
        		  Float loan = null;
        		  Float interest = null;
        		  Float income=null;
        		  Float other_income=null;
        		  Float food=null;
        		  Float rent=null;
        		  Float repair=null;
        		  Float bill=null;
        		  Float other=null;
        			 int row_no=0;
         while (rowIterator.hasNext()) {
        	  String response="error in feilds- ";
        row_no++;
             Row nextRow = rowIterator.next();
             Iterator<Cell> cellIterator = nextRow.cellIterator();

             while (cellIterator.hasNext()) {
                 Cell nextCell = cellIterator.next();

                 int columnIndex = nextCell.getColumnIndex();
                 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
                 
                 switch (columnIndex) {
                 case 0:
                     vehicle_no = nextCell.getStringCellValue();
                      vehicle=check.string(vehicle_no);
                    
                    
                     break;
                 case 1:
                	                      company_name = nextCell.getStringCellValue();
                                          company_name=company_name.replace(" ","_");
                     
                      company_code=get_company_code(company_name);
                    
                     if(company_code==null) {
                    	  company=false;
                    	 response=response+", company name="+company_name;
                     }
                     else {
                    	 company=true;
                     }
                     
                     
                     break;
                 case 2:
                      trucker_name = nextCell.getStringCellValue();
                      truckername=check.string(trucker_name); 
                     if(truckername==false) {
                    	 response=response+", truckers_name="+trucker_name;
                     }
                    
                     break;
                 case 3:
                     String applicant_date_of_birth = nextCell.getStringCellValue();
                      adob=check.date(applicant_date_of_birth);
                     if(adob==true) {
                     if(!applicant_date_of_birth.isEmpty()) {
         	           	String[] dobbb=applicant_date_of_birth.trim().split("\\.");
         	           
         	           	String dobb=dobbb[0]+"-"+dobbb[1]+"-"+dobbb[2];
         	                    	           	java.util.Date date = sdf1.parse(dobb);
         	           	 app_dob = new java.sql.Date(date.getTime());
         	          
                     }}
                     else {
                    	// response=response+", applicant_dob="+applicant_date_of_birth;
                     }
                     break;
                     case 4:
                        
                         try {
                         age = (int) (nextCell.getNumericCellValue());
                        
                         
                         agecheck=true;}
                        	 catch(Exception e) {
                        		 agecheck=false;
                        		// response=response+", age="+age;
                        	 }
                         
                         break;
                     case 5:
                          marital_status = (nextCell.getStringCellValue());
                          marital=check.marritalstatus(marital_status);
                          
                         break;
                         
				case 6:
                          nominee_name = (nextCell.getStringCellValue());
                         nominee_nme=check.string(nominee_name);
                        
                         break;
                     case 7:
                         String nominee_date_of_birth = nextCell.getStringCellValue();
                         nominee_dob=check.date(nominee_date_of_birth);
                         if(nominee_dob==true) {
                        	 	if(!nominee_date_of_birth.isEmpty()) {
                        	 		String[] dobbb=nominee_date_of_birth.trim().split("\\.");
                        	 		
                        	 		String dobb=dobbb[0]+"-"+dobbb[1]+"-"+dobbb[2];
                        	 		
                        	 		java.util.Date date = sdf1.parse(dobb);
                        	 		nominee_date_of_birt = new java.sql.Date(date.getTime());
                        	 		}
                        	 	else {
                        	 		//response=response+", nominee dob="+nominee_date_of_birth;
                        	 		}
                        	 		}
                        	 	else {
                        	 		//response=response+", nominee dob="+nominee_date_of_birth;
                        	 		}
                         break; 
                         case 8:
                             System.out.println("age12");
                             try {
                              nominee_age = (int) (nextCell.getNumericCellValue());
                              nomine_age=true;}
                             catch(Exception e) {
                            	// response=response+", nominee_age="+nominee_age;
                            	 nomine_age=false;
                             }
                             
                           
                             System.out.println("age3");
                             break; 
                         case 9:
                              nominee_relation = (nextCell.getStringCellValue());
                              nomineerelation=check.string(nominee_relation);
                              if(nomineerelation==false) {
                            	//  response=response+", nominee_relation="+nominee_relation;
                              }
                             
                             break;
                         case 10:
                             spouse_name = (nextCell.getStringCellValue());
                             spousename=check.string(spouse_name);
                             if(spousename==false) {
                            	// response=response+", spouse_name="+spouse_name;
                             }
                             statement.setString(11, spouse_name);
                             break;
                         case 11:
                              father_name = (nextCell.getStringCellValue());
                              fathername=check.string(father_name);
                              if(fathername==false) {
                            	 // response=response+", father_name="+father_name;
                              }
                             
                             break;
                         case 12:
                              religion = (nextCell.getStringCellValue());
                              religio=check.string(religion);
                              if(religio==false) {
                            	 // response=response+", religion="+religion;
                              }
                            
                             break;
                         case 13:
                             education = (nextCell.getStringCellValue());
                             edu=check.education(education);
                             if(edu==false) {
                            	// response=response+", education="+education;
                             }
                             
                             break;
                         case 14:
                              job_type = (nextCell.getStringCellValue());
                              jobType=check.job(job_type);
                              if(jobType==false) {
                            	 // response=response+", job_type="+job_type;
                              }
                             
                             break;
                         case 15:
                              address = (nextCell.getStringCellValue());
                             
                             break;
                         case 16:
                              village_name = (nextCell.getStringCellValue());
                              villagename=check.string(village_name);
                              if(villagename==false) {
                            	 // response=response+", village_name"+village_name;
                              }
                             
                             break;
                         case 17:
                        //	 if(!nextCell.getStringCellValue().isEmpty()) {
                              pin = (int)(nextCell.getNumericCellValue());
                              pincode=check.pincode(pin);
                              if(pincode==false) {
                            	 // response=response+", pincode="+pin;
                              }
                             
                        	                             break; 
                             case 18:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                                      mobile =(long) (nextCell.getNumericCellValue());
                                      mobileno=check.mobile(mobile);
                                      if(mobileno==false) {
                                    	 // response=response+", mobile no="+mobile;
                                      }
                                    
                                	 
                            	 
                             case 19:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                            	 try {
                                 family_no = (int)(nextCell.getNumericCellValue());
                                 familyno=true;}
                            	 catch(Exception e) {
                            		// response=response+", family_no="+family_no;
                            		 familyno=false;
                            	 }
                               
                            	 
                                 break; 
                             case 20:
                            	 try {
                                 working_no = (int)(nextCell.getNumericCellValue());
                                 workingno=true;}
                            	 catch(Exception e) {
                            		workingno=false;
                            		//response=response+", working_member="+working_no;
                            	 }
                                 
                            	                           
                                 break; 
                             case 21:
                                  house_type = (nextCell.getStringCellValue());
                                  housetype=check.house(house_type);
                                  
                                 
                                 break;
                             case 22:
                                  ration_card = (nextCell.getStringCellValue());
                                  rationcard=check.YN(ration_card);
                                 
                                 
                                 break;

                             case 23:
                                  medical = (nextCell.getStringCellValue());
                                  medica=check.YN(medical);
                                 
                                 break;
                             case 24:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                            	 try {
                                 loan =(float) (nextCell.getNumericCellValue());
                                 loann=true;}
                            	 catch(Exception e) {
                            		 loann=false;
                            		// response=response+", outstanding loan amount="+loan;
                            	 }
                                 
                            	
                                 break;
                             case 25:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                            	 try {
                                  interest = (float)(nextCell.getNumericCellValue());
                                  interst=true;}
                            	 catch(Exception e) {
                            		 interst=false;
                            		// response=response+", outstanding interset="+interest;
                            	 }
                               
                            	 
                            	
                                 break;
                             case 26:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                                 try{income = (float)(nextCell.getNumericCellValue());
                                 incom=true;
                                 }
                                 catch(Exception e) {
                                	 incom=false;
                                	// response=response+", income="+income;
                                 }
                                
                            
                                 break;
                             case 27:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                                try { other_income = (float)(nextCell.getNumericCellValue());
                                otherincome=true;
                                }
                                catch(Exception e) {
                                	otherincome=false;
                                	//response=response+", income from other sources"+other_income;
                                }
                                 
                            	 
                                 break;
                             case 28:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                                 try { food = (float)(nextCell.getNumericCellValue());
                                 foodd=true;
                                 }
                                 catch(Exception e) {
                                	 foodd=false;
                                	// response=response+", food expense="+food;
                                 }
                                 
                            	                                  
                                 break;
                             case 29:
                            //	 if(!nextCell.getStringCellValue().isEmpty()) {
                            	 try {
                                  rent = (float)(nextCell.getNumericCellValue());
                                  rentt=true;}
                            	 catch(Exception e) {
                            		 rentt=false;
                            		// response=response+", rent="+rent;
                            	 }
                                 
                            	 
                                 break;
                             case 30:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                                 try { repair = (float)(nextCell.getNumericCellValue());
                                 repairr=true;
                                 }
                                 catch(Exception e) {
                                	 repairr=false;
                                	// response=response+", repair="+repair;
                                 }
                                
                            	
                                 break;
                             case 31:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                                 try { bill = (float)(nextCell.getNumericCellValue());
                                 bil=true;
                                 }
                                 catch(Exception e) {
                                	 bil=false;
                                	// response=response+", bill="+bill;
                                 }
                                 
                            	
                                 break;
                             case 32:
                            	// if(!nextCell.getStringCellValue().isEmpty()) {
                            	 try {
                                 other = (float)(nextCell.getNumericCellValue());
                                 otherr=true;}
                            	 catch(Exception e) {
                            		 otherr=false;
                            		// response=response+", other expenses="+other;
                            	 }
                                 
                            	                                 break;
                
                 }//switch
                
                 
                 
             }//while 1
            
              /*   if(  vehicle==true && company==true && adob==true &&
           agecheck==true &&
           marital==true &&
           nominee_nme==true &&
           nominee_dob==true &&
           nomine_age==true &&
           nomineerelation==true &&
           spousename==true &&
           fathername==true &&
           religio==true &&
           jobType==true &&
           edu==true &&
           villagename==true &&
           pincode==true &&
           mobileno==true &&
            familyno ==true &&
           workingno==true &&
           housetype==true &&
           rationcard==true &&
           medica==true &&
           loann==true &&
           interst==true &&
           incom==true &&
           otherincome==true &&
           foodd==true &&
           rentt==true &&
           repairr==true &&
           bil==true &&
           otherr==true ) {*/
            if(truckername==true&& mobileno==true) {
                	 System.out.println("all values are true");
                 statement.setString(1, vehicle_no);
                 statement.setString(2, company_name);
                 statement.setString(3, trucker_name);
                 statement.setDate(4, app_dob);
                 statement.setInt(5, age);
                 statement.setString(6, marital_status);
                 statement.setString(7, nominee_name);
                 statement.setDate(8, nominee_date_of_birt);
                 statement.setInt(9, nominee_age);
                 statement.setString(10, nominee_relation);
                 statement.setString(11, spouse_name);
                 statement.setString(12, father_name);
                 statement.setString(13, religion);
                 statement.setString(14, education);
                 statement.setString(15,job_type);
                 statement.setString(16, address);
                 statement.setString(17, village_name);
                 statement.setInt(18, pin);
                 statement.setLong(19, mobile);
                 statement.setInt(20, family_no);
                 statement.setInt(21, working_no);
                 statement.setString(22, house_type);
                 statement.setString(23, ration_card);
                 statement.setString(24, medical);
                 statement.setFloat(25, loan);
                 statement.setFloat(26,interest);
                 statement.setFloat(27, income);
                 statement.setFloat(28, other_income);
                 statement.setFloat(29, food);
                 statement.setFloat(30,rent);
                 statement.setFloat(31, repair);
                 statement.setFloat(32, bill);
                 statement.setString(37, company_code);
                 statement.setFloat(33, other);
                statement.setLong(34,applicant_id_sequence);
                statement.setString(35,InetAddress.getLocalHost().getHostName());
                
               

                statement.setDate(36,dataentdt);

                 System.out.println(response) ;
                 statement.addBatch();
                 updateErrorlOg(datesql,"no error",FilePathList.get(a),row_no,trucker_name,(long) applicant_id_sequence,File_id);  
                 applicant_id_sequence++;     
            }//if clodse
                         
                 
else {
	 System.out.println("all values are not true");
	 System.out.println("response is"+response);
	 updateMasterlOg(datesql,"error in uploading applicant data",FilePathList.get(a),File_id);
}   
            if(response=="error in feilds- ") {
            	updateMasterlOg(datesql,"File is uploaded successfully",FilePathList.get(a),File_id);
            }
         }//while 2
             
                
                
             if (count % batchSize == 0) {
                statement.executeBatch();                                                      
            }              
             
         
	 

         workbook.close();
          
         // execute the remaining queries
         statement.executeBatch();
         updateport_gen(applicant_id_sequence) ;
         dbcon.commit();
        // dbcon.close();
        //updateport_gen(applicant_id_sequence) ;
         long end = System.currentTimeMillis();
         System.out.printf("Import done in %d ms\n", (end - start));

     } //try
	 catch (IOException ex1) {
         System.out.println("Error reading file"+ex1);
         ex1.printStackTrace();
         updateMasterlOg(datesql," Error reading file"+ex1,FilePathList.get(a),File_id);
     } catch (SQLException ex2) {
         System.out.println("Database error"+ex2);
         updateMasterlOg(datesql," Error reading file"+ex2,FilePathList.get(a),File_id);
         ex2.printStackTrace();
     }
	
	 
		
		a++;
		DB.deleteFile(excelFilePath1);
}
}
else {
System.out.println("No file to be copied");
}
 }
		 public int applicant_id() {
			int applicant_idsequence=0;
				try {
					java.sql.Statement stmt1 = dbcon.createStatement();
					log.info("connection done");
					ResultSet rs1 = stmt1.executeQuery("select * from port_gen");
					
					List<Integer> list = new ArrayList<>();
int i=0;
					while(rs1.next()){
					  // list.add(rs.getString("col_name3"));
					
						
						list.add(Integer.parseInt(rs1.getString("next_val")));
						
						}
					applicant_idsequence=list.get(0);
					System.out.println("port_gen"+applicant_idsequence);
			}
					catch(Exception e) {
						log.error("error in sequence generator"+ e);
					}
			 return applicant_idsequence;
			 
		 }
		 public void updateport_gen(int applicant_id) {
				int applicant_idsequence=0;
					try {
						java.sql.Statement stmt1 = dbcon.createStatement();
						log.info("connection done");
						String update = "update port_gen  set next_val=?";
						PreparedStatement p = dbcon.prepareStatement(update);
						p.setInt(1,applicant_id);
						
						p.execute();
						
						
				}
						catch(Exception e) {
							log.error("error in updating sequence generator"+ e);
						}
				 
				 
			 }
		 public String get_company_code(String company_name) {
		 String company_code="";
			try {
				java.sql.Statement stmt1 = dbcon.createStatement();
				log.info("connection done");
				String update = "select * from company where company_name="+"'"+company_name+"'";
				System.out.println(update);
				ResultSet rs1 = stmt1.executeQuery(update);
			
				
				
				while (rs1.next()) {
					
					company_code=(rs1.getString("company_code"));}
				System.out.println("comapny code is"+company_code);
				
				
		}
				catch(Exception e) {
					log.error("error in retrieving company code from company name"+ e);
				}
		 return company_code;
		 
	 }
		 public void updateErrorlOg(Date date,String response,String filename,int row_no,String applicant_name,Long Applicant_id,int File_id) {
			 try {
			 String sql = "INSERT INTO uploadApplicants(date_time, error, Filename,row_no,applicant_name,applicant_id,file_id) values(?,?,?,?,?,?,?)";
             PreparedStatement statement = dbcon.prepareStatement(sql);
             long now = System.currentTimeMillis();
             Timestamp date1 = new Timestamp(now);
             Date date2 = new Date(date1.getTime());
             System.out.println("row no is"+row_no);
             System.out.println("date is timestamp"+date1);
             System.out.println("date is date"+date2);
             System.out.println("date is util"+date);
             statement.setObject(1,date1);
            	statement.setString(2, response);
            statement.setString(3,filename);
            if(row_no==0) {
            	statement.setString(4,"no error");
            }
            else {
            statement.setString(4, "row_no"+row_no);}
            statement.setString(5, applicant_name);
            statement.setLong(6, Applicant_id);
            statement.setInt(7, File_id);
            statement.execute();
            System.out.println("response is saved succesfully");
		 }
			 catch(Exception e){
				 System.out.println("error in updating error"+e);
			 }
				 
			 }
		 public void updateMasterlOg(Date date,String response,String filename,int file_id) {
			 try {
				// File_no, File_name, Log, datetime
			 String sql = "INSERT INTO uploadlogmaster (File_name,Log,datetime,file_id) values(?,?,?,?)";
             PreparedStatement statement = dbcon.prepareStatement(sql);
             long now = System.currentTimeMillis();
             Timestamp date1 = new Timestamp(now);
             Date date2 = new Date(date1.getTime());
            // System.out.println("row no is"+row_no);
             System.out.println("date is timestamp"+date1);
             System.out.println("date is date"+date2);
             System.out.println("date is util"+date);
             statement.setString(1,filename);
            	statement.setString(2, response);
            statement.setObject(3,date2);
            statement.setInt(4, file_id);
            
           // statement.setString(5, applicant_name);
            statement.execute();
            System.out.println("response is saved succesfully");
		 }
			 catch(Exception e){
				 System.out.println("error in updating error"+e);
			 }
				 
			 }


}
