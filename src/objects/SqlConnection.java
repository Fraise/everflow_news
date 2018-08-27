package objects;

import java.util.Scanner;

import org.json.JSONException;

import helpers.RedisHelper;
import helpers.SqlHelper;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class SqlConnection
{
	private static final String URL = "jdbc:mysql://localhost:3306/everflow_news_db";
	private static final String CACHE_URL = "localhost";

	private static SqlConnection connectionSingleton = null;
	private static Connection dbConnection = null;
	private static Jedis cacheConnection = null;
	
	private SqlConnection()
	{
		
	}
	
	public static SqlConnection getSqlConnection() throws SQLException
	{
		if (connectionSingleton == null)
		{
			connectionSingleton = new SqlConnection();
		}
		
		return connectionSingleton;
	}
	
	public static Connection getDbConnection() throws SQLException
	{
		if (dbConnection == null || !dbConnection.isValid(1000))
		{
			try
			{
				connectionSingleton.dbConnection = SqlHelper.getConnection(URL);
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}

		return dbConnection;
	}
	
	public static void closeDbConnection()
	{
		try
		{
			dbConnection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Jedis getCacheConnection()
	{
		connectionSingleton.cacheConnection = RedisHelper.getConnection(CACHE_URL);
		
		return cacheConnection;
	}
	
	public static void closeCacheConnection()
	{
		cacheConnection.close();
	}

}
