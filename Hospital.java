package badri.com;
import java.sql.SQLException;
import java.util.*;
public class Hospital {
	
	
	
	Scanner scanner=new Scanner(System.in);

	   public void hospitalinfrastrucure() {
		   
		   System.out.println("****************************************************HOSPITAL FACILITES***********************************************************************************");
		   System.out.println("                                                                                                                                                         ");
		   System.out.println("                                                    |_________|----------------|                                                                         ");	
		   System.out.println("                                                    |_________|                |-----------------,                                                       ");
		   System.out.println("                                                    |         |----------------|                 '                                                       ");
		   System.out.println("                                                                                                 '                                                       ");
		   System.out.println("                                                    1.Day care Services                                                                                  ");
		   System.out.println("                                                    2.24X7 Pharmacy                                                                                      ");
		   System.out.println("                                                    3.24X7 Clinical Laboratory Services                                                                  ");
		   System.out.println("                                                    4.24X7 Ambulance                                                                                     ");
		   System.out.println("                                                    5.Best Enviornment                                                                                   ");
		   System.out.println("                                                                                                                                                         ");
		   System.out.println("                                              THERE ARE MORE DEPARTMENTS ARE THERE                                                                       ");
		   System.out.println("                                                    1.FamilyPhysicians ->family doctor                                                                   ");
		   System.out.println("                                                    2.Cardiologist     ->Heart and Blood Vessels                                                         ");
		   System.out.println("                                                    3.Neurologists     ->Nervous system                                                                  ");
		   System.out.println("                                                    4.Urologists       ->Urinary Tract                                                                   ");
		   System.out.println("                                                    5.Immunologist     ->Allergies                                                                       ");
		   System.out.println("                                                    6.ophthalmologist  ->Eye care                                                                        ");
		   System.out.println("                                                    7.Psychiatrists    ->Mental health                                                                   ");
	       System.out.println("                                                    8.Dermatologists   ->Skin and hair                                                                   ");
	       System.out.println("                                                    9.paediatrics      ->Chil care                                                                       ");
	       System.out.println("                                                                                                                                                         ");
	       System.out.println("                             ________                                                 _______________                                                    ");
	       System.out.println("                            |   ok   |                                               |     Cancel    |                                                   ");
	       System.out.println("                            |________|                                               |_______________|                                                   ");
	       System.out.println("                                                                                                                                                         ");
	   }

	 //************************************Patientanduser START***********************************************
	   
	   
	  public void patientAndUser() {
			 PatientDetail patientregistration=new PatientDetail();
			 LoginPage signup=new  LoginPage ();
			 LoginPage signin=new  LoginPage ();
			 PatientDetail patientproblem=new PatientDetail();
			 PatientDetail paypayment=new PatientDetail();
			 
			 System.out.println("ENTER CHOICE signup Enter:signup");
			 System.out.println("ENTER CHOICE login Enter:signin");
			 String page = scanner.nextLine();
			    
				switch (page) {
				case "signup":
					signup.signup();
				break;}
				switch (page) {
				case "signin":
					signin.signin();
					int registration=scanner.nextInt();
					
					switch(registration) {
					case 1:
						patientregistration.patientregistration();
						System.out.println("Registration Successful");
						patientproblem.patientproblem();
						paypayment.paypayment();
					}
				break;}
				 }
				       
				
					 
			
				
		
		  
		  
	   //************************************************************************Patientanduser END***************************************************************




	//*******************************************************************ADMIN START*************************************************************************

	
	  public void adminlogin() 
	  {   
	  	
	  	DoctorDetail doctordetails=new DoctorDetail();
	  	PatientDetail patientshowdetail=new PatientDetail();
	  	DoctorDetail showdoctordetails=new DoctorDetail();
	  		System.out.println("ENTER THE ADMIN E_MAIL ID");
	  		String a=scanner.next();
	  		String adminEmail="badrisivaraj26@gmail";
	  		System.out.println("ENTER THE ADMIN Password");
	  		String b=scanner.next();
	  		String adminpassword="Badri@2001";
	  	    try {
	  	    	if(a.equals(adminEmail)  && (b.equals(adminpassword)))
	  	    	   {
	  	    		System.out.println("VALID ADMIN LOGIN AND PASSWORD");
	  	    		System.out.println("ENTER CHOOSE YOUR NUMBER:");
	  	    		System.out.println("ADD NEW RECORDS IN DOCTORS    PRESS: 10:");
	  	    		System.out.println("SHOW THE ALL THE PATIENT DETAILS PRESS: 20");
	  	    		System.out.println("SHOW THE ALL THE DOCTOR DETAILS  PRESS: 30");
	  	    		System.out.println("ENTER CHOOSE YOUR NUMBER:");
	  	    	     int choose = scanner.nextInt();
	  	    			switch (choose) {
	  	    			case 10:
	  	    				doctordetails.doctor();
	  	    				break; 
	  	    			case 20:
	  	    				patientshowdetail.showpatientdetails();//PATIENT ALL DETAIL
	  					    break;
	  	    			case 30:
	  	    				 showdoctordetails.showdoctordetails();//DOCTOR ALL DETAIL
	  					      break;
	  					     }
	  	    	   }
	  	         else {
	  		    	 System.out.println("INVALID EMAIL OR PASSWORD");
	  		     } 
	  	    	   }
	  	     catch(Exception e){ System.out.println(e);}		
	  	    	}

	  public void hospitalfunctions() throws ClassNotFoundException, SQLException {    
		  Hospital hospitalinfra=new  Hospital();

		  Hospital adminlogin=new  Hospital();
		  Hospital patientanduser=new  Hospital();


		  boolean askAgain = true;

		  while (askAgain) {

		  System.out.println("__________________________***HOSPITAL MANAGEMENT SYSTEM***_______________________");
		  	System.out.println("*******************************************************************************");
		  	System.out.println("                                                                               ");
		    System.out.println("                                                                               ");
		    System.out.println("*******************<HOSPITALMANAGEMENTINFRASTRUCTURE press: 1******************");
		    System.out.println("                                                                               ");
		    System.out.println("*******************************************************************************");



		  	System.out.println("ENTER CHOOSE YOUR NUMBER:");
		  	int choose = scanner.nextInt();
		      
		  	switch (choose) {
		  	case 1:
		  		hospitalinfra.hospitalinfrastrucure();
		  		System.out.println("ENTER YOUR OPTION");
		  		String press=scanner.next();
		  		switch(press) {
		  		case "ok":
		  			  System.out.println("                                                                                           ");
		  			  System.out.println("************************<PATIENT and User> Enter:patientanduser ***************************");
		  			  System.out.println("                                                                                           ");
		  			  System.out.println("                                                                                           ");
		  			  System.out.println("******************************<ADMIN LOGIN> Enter: admin***********************************");
		  			  System.out.println("                                                                                           ");
		  			  System.out.println("                                                                                           ");
		  		      String choice=scanner.next(); 
		  			  switch(choice) {
		  			  case "patientanduser":
		  				  patientanduser.patientAndUser();
		  			      break;
		  			  case "admin":
		  				  adminlogin.adminlogin();
		  		      }
		  		
		  			
		  		    }
		  		break;
		  		

		  	case 4:
		  		askAgain = false;

		  		break;

		  	default:

		  		System.out.println("******SORRY PLEASE ENTER VALUABLE NUMBER********");

		  		break;
		  	}


		  	System.out.println("THANK YOU");

		  }

		  }

	


}
