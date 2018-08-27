package helpers;

import java.sql.DriverManager;
import org.mariadb.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.Scanner;

public class SqlHelper
{	
	public static Connection getConnection(String url) throws SQLException, ClassNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter MySql username :");
		String user = scan.nextLine();

		System.out.println("Enter MySql password :");
		String pass = scan.nextLine();
		scan.close();
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		return 	DriverManager.getConnection(url, user, pass);
	}
 }
