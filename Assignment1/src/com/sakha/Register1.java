 package com.sakha;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;

public class Register1 extends ConnectionManager1
  {
	static String q;
	static String name;
	static String id;
	static String mail;
	static String pass;
   
	Scanner in = new Scanner(System.in);
    public boolean validateName() 
	{
		System.out.println("Enter your Full-Name: ");
		name = in.next();
        Pattern pat = Pattern.compile("[a-zA-Z]*");
    	Matcher match = pat.matcher(name);
    	if(match.matches())
    	{
    		return true;
    	}
    	else
    	{
    		System.out.println("Name Should Contain only Alphabets:");
    		validateName();
    	}
         return false;
	}

    public boolean validateId() 
    {
    	System.out.println("Enter your UserId: ");
    	id = in.next();
    	Pattern pat = Pattern.compile("[a-zA-Z0-9]{6,10}");
        Matcher match = pat.matcher(id);
        if(match.matches())
        {
       		return true;
       	}
        else
       	{
       		System.out.println("UserId Should have Alphabets and Number between 6 -10 chars..");
       		validateId();
       	}
         return false;
    }
		
    public boolean validateMail() 
    {
	   System.out.println("Enter your Email-Id: ");
	   mail = in.next();
	   Pattern pat = Pattern.compile("^[_A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*@[a-zA-Z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
       Matcher match = pat.matcher(mail);
       if(match.matches())
       {
   		   return true;
   	   }
       else
   	   {
   		    System.out.println("Check your Email-Id");
   		    validateMail();
   	   }
        return false;
    }

    public boolean validatePass() 
    {
        System.out.println("Enter your PassWord: ");
        pass = in.next();
        Pattern pat = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*]).{8,16})");
        Matcher match = pat.matcher(pass);
        if(match.matches())
       {
		   return true;
	   }
       else
	   {
		    System.out.println("Password should contain one Capital, Numeric and Special char.. between 8-16 characters ");
		    validateMail();
	   }
        return false;
   }

public static void main(String[] a) throws ClassNotFoundException, SQLException 
   { 
    	
    try
     {
    	  boolean n = false;
    	  boolean i = false;
    	  boolean m = false;
    	  boolean p = false;
    	  Register1 r = new Register1();
    	  r.connection();
    	  System.out.println("Welcome to registration Page:");
    	  System.out.println();
	      System.out.println("Enter ur Details");
	      n = r.validateName(); 
	      i = r.validateId();
	      m = r.validateMail();
	      p = r.validatePass();
	      
	      if(n && i && m && p)
	      {
	      q = "insert into student values(?,?,?,?)"; //insert into <table-name>("with '?' has  
	      PreparedStatement ps= con.prepareStatement(q); // placeholder for columns in particular table")
	      ps.setString(1, name);
	      ps.setString(2, id);
	      ps.setString(3, mail);
	      ps.setString(4, pass);
	      ps.execute();
	      
//	      int rows=ps.executeUpdate();                 //If You want to check the number of rows 
//	      System.out.println("rows affected: "+rows); // affected.
	      System.out.println();
	      System.out.println("___________________________________________________________");
	      System.out.println("|Thank you "+name+" your details are Registerd sucessfully |");
	      System.out.println("|---------------------------------------------------------|");
	      }
	      else
	      {
	    	  System.out.println("Please Enter the Parameters as Specified.");
	      }
	      con.close();
	 }
	 catch(Exception e)
	 {
		e.printStackTrace();
	//System.out.println("Some undefined Error Occured");
	}
  }
}
	
	
	
	
	
		

	