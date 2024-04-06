package badri.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.*;
public class DoctorDetail {
	Scanner scanner=new Scanner(System.in);
	
	 public void doctor()  {
		   
		    System.out.println("ENTER THE DOCTOR ID");
		    int doctorID=scanner.nextInt();
		    System.out.println("ENTER DOCTOR NAME");
		 	String doctorName=scanner.next();
		 	  Pattern pattern=Pattern.compile("[a-zA-Z]{6,10}");
			    Matcher matcher=pattern.matcher(doctorName);
			    if (matcher.matches())
			    {
			    System.out.println("doctorName is verified");
			    }
			    else {
			    	System.out.println("doctorName is not verified");
			    	doctor();
			    }
		 	System.out.println("ENTER THE AREA OF SPECIALIST");
		 	String doctorDepartment=scanner.next();
		    
		 	try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","12345678");  
				PreparedStatement stmt=con.prepareStatement("insert into DoctorTables values(?,?,?)");  
				stmt.setInt(1,doctorID);
				stmt.setString(2,doctorName);  
				stmt.setString(3,doctorDepartment);
				int i=stmt.executeUpdate();  
				System.out.println(i+" records inserted");  
				con.close();  
				}catch(Exception e){ System.out.println(e);}    
	 }
	  public void showdoctordetails() throws ClassNotFoundException, SQLException {
		   try {
		   //Connection connection=null;
		   Class.forName("com.mysql.cj.jdbc.Driver");  
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","12345678");  

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from DoctorTables");
			while (rs.next()) {

				System.out.println("-------------------------------------------------------------");
				System.out.println("*                                                            *");
				System.out.println("*   doctorID           =         " + rs.getInt(1)    + "     *");
				System.out.println("*   doctorName         =         " + rs.getString(2) + "     *");
				System.out.println("*   doctorDepartment   =         " + rs.getString(3) + "     *");
				System.out.println("*                                                            *");
				System.out.println("-------------------------------------------------------------*");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	  }
	  }
