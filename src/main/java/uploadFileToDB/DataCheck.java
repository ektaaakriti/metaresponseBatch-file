package uploadFileToDB;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DataCheck {
public Boolean string(String name) {
	/*Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
    Matcher match = pattern.matcher(name);
    boolean val = match.find();
    System.out.println("value on check"+val) ; 
    if (val == true)
	{return false;}
    else
    	{return true;}*/
	Pattern p = Pattern.compile(
            "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
 
        
        Matcher m = p.matcher(name);
 
       
        boolean res = m.find();
 
       
        if (res)
        {
            return false;
        }
        
        else
        {
            // Display this message on the console
            System.out.println(
                "No Special Characters found in String 1");
 return true;}
}
 
        

    
   public boolean date(String date) {
	   SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
       
       format.setLenient(false);
       try {
           format.parse(date);
           System.out.println("date is true");
           return true;
       } catch (ParseException e) {
    	   System.out.println("date is false");
           return false;
       }
       
   }
   public boolean marritalstatus(String status) {
	  // MARRIED/UN MARRIED/WIDOW/WIDOWER/DIVORCED
	   status=status.toLowerCase();
	   if(status.contains("married")||status.contains("unmarried")|| status.contains("widow")||status.contains("widower")||status.contains("divorce"))
	   {return true;}
	   else {
		   return false;
	   }
   }
   public boolean education(String status) {
	   //Upto Class 10, Class 12. Graduate and avove
	   status=status.toLowerCase();
		   if(status.contains("5")||status.contains("primary")|| status.contains("8")||status.contains("ssc")||status.contains("12")||status.contains("graduat")||status.contains("doctrat")||status.contains("10"))
		   {return true;}
		   else {
			   return false;
		   }
	   }
   public boolean job(String status) {
	   //Permanent/Contract
	   status=status.toLowerCase();
		   if(status.contains("permanent")||status.contains("contract"))
		   {return true;}
		   else {
			   return false;
		   }
	   }
   public boolean mobile(Long mobile) {
	   //Permanent/Contract
	   int len = String.valueOf(mobile).length();
	   if(len==10){
		   return true;}
		   else {
			   return false;
		   }
	   } 
   public boolean pincode(int pincode) {
	   //Permanent/Contract
	   int len = String.valueOf(pincode).length();
	   if(len==6){
		   return true;}
		   else {
			   return false;
		   }
	   } 
   public boolean house(String status) {
	   //Permanent/Contract
	   status=status.toLowerCase();
		   if(status.contains("own")||status.contains("rent"))
		   {return true;}
		   else {
			   return false;
		   }}
		   public boolean YN(String status) {
			   //Permanent/Contract
				   if(status.contains("Y")||status.contains("N"))
				   {return true;}
				   else {
					   return false;
				   }
			   }
	   }


