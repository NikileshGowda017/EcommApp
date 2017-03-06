package com.sakha;

import java.sql.*;
import java.io.*;
import java.util.*;

public class Login1 extends ConnectionManager1 
{
    static String id;
    static String pass;
    static boolean status;
    static String n;
	public static void main(String[] a) throws ClassNotFoundException, SQLException 
	{
	 try
		{
		Login1 l = new Login1();
		l.connection();
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to your Login Page:");
		// Enter the User-Id and PassWord.
		System.out.println("Enter your User-ID");
		id = in.next();
		System.out.println();
		System.out.println("Enter your Password");
		pass = in.next();
		
		PreparedStatement ps = con.prepareStatement("select * from student where userId=? and sPass=?");
		ps.setString(1, id);     // search entered value for id in respective Database.
		ps.setString(2, pass);  // search entered value for Password in Database.
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();// status returns true if entered values are present in Database.
		n=rs.getString(1); // calls the first Column from Database which contains Student Name.
		System.out.println();
		
		if(status == true)                          //if status is true print following 
		{   System.out.println("|-----------------|");                                        //statements.
			System.out.println("|Login Sucessfull |");
			System.out.println("|Welcome: "+n+"|");
			System.out.println("|-----------------|");
		}
		else
		{
			System.out.println("UserId and Password Mismatch");
		}
	}
		catch(Exception e)
		{
			System.out.println("Error 404--");
		}
		
		
	}

}
