package objects;

import helpers.RedisHelper;
import helpers.SqlHelper;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.SQLException;

//This class is a singleton used to have an unique connection to the db and cache across the app
//When using this singleton, one needs to first get the instance, then get the connection to the database and/or cache

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
	
	//Get the instance of the class
	public static SqlConnection getSqlConnection() throws SQLException
	{
		if (connectionSingleton == null)
		{
			connectionSingleton = new SqlConnection();
		}
		
		return connectionSingleton;
	}
	
	//Get the sql database connection
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
	
	//Close the sql database connection
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
	
	//Get the cache connection
	public static Jedis getCacheConnection()
	{
		connectionSingleton.cacheConnection = RedisHelper.getConnection(CACHE_URL);
		
		return cacheConnection;
	}
	
	//Close the cache connection
	public static void closeCacheConnection()
	{
		cacheConnection.close();
	}

}
