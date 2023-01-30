import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Details
{
	String email="";
	String balance="";
	String transaction="";
	String tBalance="";
	String tDate="";
	String accDate="";
	
	public Details(String email,String balance,String transaction,String tBalance,String tDate,String accDate)
	{
		this.email = email;
		this.balance = balance;
		this.transaction = transaction;
		this.tBalance = tBalance;
		this.tDate = tDate;
		this.accDate = accDate;
	}
	
	String getEmail()
	{
		return email;
	}
	
	String getBalance()
	{
		return balance;
	}
	
	String getTransaction()
	{
		return transaction;
	}
	
	String getTransBalance()
	{
		return tBalance;
	}
	
	String getTransDate()
	{
		return tDate;
	}
	
	String getAccDate()
	{
		return accDate;
	}
}