package badri.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.regex.*;
public class LoginPage {
	Scanner scanner=new Scanner(System.in);
	public void signup()  {
		   
	    System.out.println("ENTER THE USERNAME");
	    String username=scanner.nextLine();
	    Pattern pattern=Pattern.compile("[a-zA-Z]{6,10}");
	    Matcher matcher=pattern.matcher(username);
	    if (matcher.matches())
	    {
	    System.out.println("Username is verified");
	    }
	    else {
	    	System.out.println("username is not verified");
	    	signup();
	    }
	
	 	System.out.println("ENTER THE EMAILID");
	 	String email =scanner.next();
	 	Pattern pattern1=Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$");
		Matcher matcher1=pattern1.matcher(email);
		if (matcher1.matches())
		{
			System.out.println("Email is verified");
		}
		else {
			System.out.println("Email is not verified");
			signup();
		}
	 	System.out.println("ENTER THE PASSWORD");
	 	String password=scanner.next();
	 	Pattern pattern2=Pattern.compile("[a-z]{4,7}");
		Matcher matcher2=pattern2.matcher(password);
		if (matcher2.matches())
		{
			System.out.println("password is verified");
		}
		else {
			System.out.println("password is not verified");
			signup();
		}
	   

	   
	 	 try{  
	 		Class.forName("com.mysql.cj.jdbc.Driver");  
	 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","12345678");  
	 		PreparedStatement stmt=con.prepareStatement("insert into signup values(?,?,?)");  
	 		stmt.setString(1,username);
	 		stmt.setString(2,email);  
	 		stmt.setString(3,password);
	 		int i=stmt.executeUpdate();  
	 		System.out.println(i+" records inserted");  
	 		con.close();  
	 		}catch(Exception e){ System.out.println(e);}	 
	 	 }   
	   
public void signin() {
 try {
	
	 System.out.println("Enter email");
	 String email=scanner.nextLine();
	   Class.forName("com.mysql.cj.jdbc.Driver");  
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","12345678");  

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from signup where Email like '%"+email+"'");
		while (rs.next()) {

		String getting=rs.getString(2);
		System.out.println( getting);
		if(getting.equals(email))
		{
			System.out.println("successful signin");
			System.out.println("Patient Registration press:1");}
			else {
				System.out.println("unsuceesful signin");
			}	
			
			
		}
		con.close();
		 }catch (Exception e) {
			System.out.println(e);}
		}

}