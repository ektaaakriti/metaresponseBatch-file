package uploadFileToDB;

import java.util.Date;

public class Bean {
	 String VEHICLE_NO;
	 String company_name;
	 String applicant_name;
	 java.sql.Date applicant_date_of_birth;
	 int AGE;
	 String maritalstatus;
	 String nominee_name;
	 java.sql.Date NOMINEE_DOB;
	 int NOMINEE_AGE;
	 String NOMINEE_RELATION;
	 String SPOUSE_NAME;
	String FATHER_NAME;
	String RELIGION;
	String Education;
	String Permanent_Contract_Job;
	String ADDRESS;
	String VILLAGE_NAME_city;
	int PINCODE;
	long mobile_no;
	int Nos_Of_Family_Members;
	int Nos_of_working_Members;
	String House_type;
	String Ration_Card;
	String Medical_Insurance;
	Float Loan_OUTSTANDING_PRINCIPAL;
	Float CURRENT_LOAN_OUTSTANDING_INTEREST;
	Float TRUCK_INCOME;
	Float INCOME_FROM_OTHER_SOURCES;
	Float Monthly_Food_Expenditure;
	Float Rent;
	Float House_Repair;
	Float Total_Monthly_Bill_Payment;
	Float Total_Monthly_Expenses;
	public String getVEHICLE_NO() {
		return VEHICLE_NO;
	}
	public void setVEHICLE_NO(String VEHICLE_NO) {
		this.VEHICLE_NO = VEHICLE_NO;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getApplicant_name() {
		return applicant_name;
	}
	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}
	public java.sql.Date getApplicant_date_of_birth() {
		return applicant_date_of_birth;
	}
	public void setApplicant_date_of_birth(java.sql.Date applicant_date_of_birth) {
		this.applicant_date_of_birth = applicant_date_of_birth;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getNominee_name() {
		return nominee_name;
	}
	public void setNominee_name(String nominee_name) {
		this.nominee_name = nominee_name;
	}
	public java.sql.Date getNOMINEE_DOB() {
		return NOMINEE_DOB;
	}
	public void setNOMINEE_DOB(java.sql.Date nOMINEE_DOB) {
		NOMINEE_DOB = nOMINEE_DOB;
	}
	public int getNOMINEE_AGE() {
		return NOMINEE_AGE;
	}
	public void setNOMINEE_AGE(int nOMINEE_AGE) {
		NOMINEE_AGE = nOMINEE_AGE;
	}
	public String getNOMINEE_RELATION() {
		return NOMINEE_RELATION;
	}
	public void setNOMINEE_RELATION(String nOMINEE_RELATION) {
		NOMINEE_RELATION = nOMINEE_RELATION;
	}
	public String getSPOUSE_NAME() {
		return SPOUSE_NAME;
	}
	public void setSPOUSE_NAME(String sPOUSE_NAME) {
		SPOUSE_NAME = sPOUSE_NAME;
	}
	public String getFATHER_NAME() {
		return FATHER_NAME;
	}
	public void setFATHER_NAME(String fATHER_NAME) {
		FATHER_NAME = fATHER_NAME;
	}
	public String getRELIGION() {
		return RELIGION;
	}
	public void setRELIGION(String rELIGION) {
		RELIGION = rELIGION;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	public String getPermanent_Contract_Job() {
		return Permanent_Contract_Job;
	}
	public void setPermanent_Contract_Job(String permanent_Contract_Job) {
		Permanent_Contract_Job = permanent_Contract_Job;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getVILLAGE_NAME_city() {
		return VILLAGE_NAME_city;
	}
	public void setVILLAGE_NAME_city(String vILLAGE_NAME_city) {
		VILLAGE_NAME_city = vILLAGE_NAME_city;
	}
	public int getPINCODE() {
		return PINCODE;
	}
	public void setPINCODE(int pINCODE) {
		PINCODE = pINCODE;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public int getNos_Of_Family_Members() {
		return Nos_Of_Family_Members;
	}
	public void setNos_Of_Family_Members(int nos_Of_Family_Members) {
		Nos_Of_Family_Members = nos_Of_Family_Members;
	}
	public int getNos_of_working_Members() {
		return Nos_of_working_Members;
	}
	public void setNos_of_working_Members(int nos_of_working_Members) {
		Nos_of_working_Members = nos_of_working_Members;
	}
	public String getHouse_type() {
		return House_type;
	}
	public void setHouse_type(String house_type) {
		House_type = house_type;
	}
	public String getRation_Card() {
		return Ration_Card;
	}
	public void setRation_Card(String ration_Card) {
		Ration_Card = ration_Card;
	}
	public String getMedical_Insurance() {
		return Medical_Insurance;
	}
	public void setMedical_Insurance(String medical_Insurance) {
		Medical_Insurance = medical_Insurance;
	}
	public Float getLoan_OUTSTANDING_PRINCIPAL() {
		return Loan_OUTSTANDING_PRINCIPAL;
	}
	public void setLoan_OUTSTANDING_PRINCIPAL(Float loan_OUTSTANDING_PRINCIPAL) {
		Loan_OUTSTANDING_PRINCIPAL = loan_OUTSTANDING_PRINCIPAL;
	}
	public Float getCURRENT_LOAN_OUTSTANDING_INTEREST() {
		return CURRENT_LOAN_OUTSTANDING_INTEREST;
	}
	public void setCURRENT_LOAN_OUTSTANDING_INTEREST(Float cURRENT_LOAN_OUTSTANDING_INTEREST) {
		CURRENT_LOAN_OUTSTANDING_INTEREST = cURRENT_LOAN_OUTSTANDING_INTEREST;
	}
	public Float getTRUCK_INCOME() {
		return TRUCK_INCOME;
	}
	public void setTRUCK_INCOME(Float tRUCK_INCOME) {
		TRUCK_INCOME = tRUCK_INCOME;
	}
	public Float getINCOME_FROM_OTHER_SOURCES() {
		return INCOME_FROM_OTHER_SOURCES;
	}
	public void setINCOME_FROM_OTHER_SOURCES(Float iNCOME_FROM_OTHER_SOURCES) {
		INCOME_FROM_OTHER_SOURCES = iNCOME_FROM_OTHER_SOURCES;
	}
	public Float getMonthly_Food_Expenditure() {
		return Monthly_Food_Expenditure;
	}
	public void setMonthly_Food_Expenditure(Float monthly_Food_Expenditure) {
		Monthly_Food_Expenditure = monthly_Food_Expenditure;
	}
	public Float getRent() {
		return Rent;
	}
	public void setRent(Float rent) {
		Rent = rent;
	}
	public Float getHouse_Repair() {
		return House_Repair;
	}
	public void setHouse_Repair(Float house_Repair) {
		House_Repair = house_Repair;
	}
	public Float getTotal_Monthly_Bill_Payment() {
		return Total_Monthly_Bill_Payment;
	}
	public void setTotal_Monthly_Bill_Payment(Float total_Monthly_Bill_Payment) {
		Total_Monthly_Bill_Payment = total_Monthly_Bill_Payment;
	}
	public Float getTotal_Monthly_Expenses() {
		return Total_Monthly_Expenses;
	}
	public void setTotal_Monthly_Expenses(Float total_Monthly_Expenses) {
		Total_Monthly_Expenses = total_Monthly_Expenses;
	}
	

}
