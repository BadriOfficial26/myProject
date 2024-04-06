package badri.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatientDetail  {
	Scanner scanner=new Scanner(System.in);
	
	  public void patientregistration() {
		   
		    System.out.println("ENTER PATIENT ID");
		    int patientId=scanner.nextInt();
		 	System.out.println("ENTER PATIENT NAME");
		 	String patientName =scanner.next();
		 	 Pattern pattern=Pattern.compile("[a-zA-Z]{4,10}");
			    Matcher matcher=pattern.matcher(patientName);
			    if (matcher.matches())
			    {
			    System.out.println("patientName is verified");
			    }
			    else {
			    	System.out.println("patientName is not verified");
			    	patientregistration();
			    }
		 	System.out.println("ENTER THE GENDER");
		 	String gender=scanner.next();
		 	Pattern pattern1=Pattern.compile("[a-zA-Z]{4}");
		    Matcher matcher1=pattern1.matcher(gender);
		    if (matcher1.matches())
		    {
		    System.out.println("Gender is verified");
		    }
		    else {
		    	System.out.println("Gender is not verified");
		    	patientregistration();
		    }
		 	System.out.println("ENTER PATIENT AGE");
		 	int Age =scanner.nextInt();
		 	System.out.println("ENTER THE ADDRESS");
		 	String Address=scanner.next();
		 	System.out.println("ENTER THE PHONE_NO");
		 	String phoneNumber=scanner.next();
		 	Pattern pattern2=Pattern.compile("[1-9]{10}");
		    Matcher matcher2=pattern2.matcher(phoneNumber);
		    if (matcher2.matches())
		    {
		    System.out.println("phonenumber is verified");
		    }
		    else {
		    	System.out.println("phonenumber is not verified");
		    	patientregistration();
		    }
		 	
		 	
		 try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","12345678");  
			PreparedStatement stmt=con.prepareStatement("insert into PatientTables values(?,?,?,?,?,?)");  
			stmt.setInt(1,patientId);
			stmt.setString(2,patientName);  
			stmt.setString(3,gender);
			stmt.setInt(4,Age);
			stmt.setString(5,Address);
			stmt.setString(6,phoneNumber);
			int i=stmt.executeUpdate();  
			System.out.println(i+" records inserted");  
			con.close();  
			}catch(Exception e){ System.out.println(e);}	 
		}


	
	
	
	public void showpatientdetails() throws ClassNotFoundException, SQLException {
	   try {
	   Class.forName("com.mysql.cj.jdbc.Driver");  
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","12345678");  

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from PatientTables");
		while (rs.next()) {

			System.out.println("-------------------------------------------------------------");
			System.out.println("*                                                            *");
			System.out.println("*   PatientID          =         " + rs.getInt(1)    + "     *");
			System.out.println("*   PatientName        =         " + rs.getString(2) + "     *");
			System.out.println("*   Gender             =         " + rs.getString(3) + "     *");
			System.out.println("*   Age                =         " + rs.getString(4) + "     *");
			System.out.println("*   Address            =         " + rs.getString(5) + "     *");
			System.out.println("*   PhoneNumber        =         " + rs.getString(6) + "     *");
			System.out.println("*                                                            *");
			System.out.println("-------------------------------------------------------------*");
		}
		con.close();
	} catch (Exception e) {
		System.out.println(e);
		
		
	}
}
 	public void patientproblem() {
		
		    
	    System.out.println("Enter your problem");
		try {	String problem=scanner.next();
			if (problem.equals("FamilyPhysicians")) {
				System.out.println("FamilyPhysicians YOUR APPOINTMENT IS PROCESS PAY Rs=500 ");
			}
			else if(problem.equals("Cardiologists")){
				System.out.println("Cardiologists APPOINTMENT IS PROCESS PAY Rs=1000");
				}
			else if(problem.equals("Neurologists")){
				System.out.println("Neurologists APPOINTMENT IS PROCESS PAY Rs=1200");
		}
			else if(problem.equals("Urologists")){
				System.out.println("Urologists APPOINTMENT IS PROCESS PAY Rs=750");
		}
			else if(problem.equals("Immunologists")){
				System.out.println("Immunologists APPOINTMENT IS PROCESS PAY Rs=950");
		}
			else if(problem.equals("ophthalmologist")){
				System.out.println("ophthalmologist  APPOINTMENT IS PROCESS PAY RS=600");
		}
			else if(problem.equals("Psychiatrists")){
				System.out.println("Psychiatrists APPOINTMENT IS PROCESS PAY Rs=650");
		}
			else if(problem.equals("Dermatologists")){
				System.out.println("Dermatologists APPOINTMENT IS PROCESS PAY Rs=1100");
		}
			else if(problem.equals("paediatrics")){
				System.out.println("paediatrics APPOINTMENT IS PROCESS PAY Rs=550");
		}
			else {
				System.out.println("ENTER THE VALID PROBLEM THEN CONTINUE");
			}}
				catch (Exception e) {
		System.out.println(e);}}
		

		 
		  public void paypayment()
			 {
			try {	System.out.println("PAYMENT OF THE PATIENT");
				 String payment =scanner.next();
				if (payment.equals("500")){
					System.out.println("PAYMENT SUCCESSFUL FamilyPhysicians YOUR APPOINTMENT FIXED");
				}
				else if(payment.equals("1000")) {
					System.out.println("PAYMENT SUCCESSFUL Cardiologists YOUR APPOINTMENT FIXED");
				}
				else if(payment.equals("1200")) {
					System.out.println("PAYMENT SUCCESSFUL Neurologists YOUR APPOINTMENT FIXED");
				 }
				else if(payment.equals("750")) {
					System.out.println("PAYMENT SUCCESSFUL Urologists YOUR APPOINTMENT FIXED");
				 }
				else if(payment.equals("950")) {
					System.out.println("PAYMENT SUCCESSFUL Immunologists YOUR APPOINTMENT FIXED");
				 }
				else if(payment.equals("600")) {
					System.out.println("PAYMENT SUCCESSFUL ophthalmologist YOUR APPOINTMENT FIXED");
				 }
				else if(payment.equals("650")) {
					System.out.println("PAYMENT SUCCESSFUL Psychiatrists YOUR APPOINTMENT FIXED");
				 }
				else if(payment.equals("1100")) {
					System.out.println("PAYMENT SUCCESSFUL Dermatologists YOUR APPOINTMENT FIXED");
				 }
				else if(payment.equals("550")) {
					System.out.println("PAYMENT SUCCESSFUL paediatrics YOUR APPOINTMENT FIXED");
				 }
				else {
					System.out.println("PAYMENT UNSUCCESSFUL YOUR APPOINTMENT IS NOT FIXED");
				 }
			 }
			catch (Exception e) {
				System.out.println(e);}}
		

}
