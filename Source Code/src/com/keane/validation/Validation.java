package com.keane.validation;

import java.util.regex.*;


public class Validation{
	
	    public boolean isvalidStud_id(String Stud_id)
	       {
	           boolean status=true;
	           
	           if(Stud_id.length()<3 && Stud_id.isEmpty())
	           {
	               status=false;
	           }
	           return status;
	       }
	    
	    
	    public static boolean isvalidEmail( String Email ) {
	        { 
	            String EmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                                "[a-zA-Z0-9_+&*-]+)*@" + 
	                                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                                "a-z]{2,7}$"; 
	                                  
	            Pattern pat = Pattern.compile(EmailRegex); 
	            if (Email == null) 
	                return false; 
	            return pat.matcher(Email).matches(); 
	        } 
	      
	      }
	    
	    public static boolean isvalidNseats(int nseats) {
	    	boolean status=true;
	    	
	    	if(nseats<=100 && nseats>5000) {
	    		status=false;
	    	}
			return status;
	    	
	    }
	    
	    public static boolean isvalidNfaculty(int nfaculty) {
	    	boolean status=true;
	    	
	    	if(nfaculty<=20) {
	    		status=false;
	    	}
			return status;
	    	
	    }
}