package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;

import objects.News;
import objects.SqlConnection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.sql.Connection;
import java.sql.ResultSet;

public class NewsDAOImpl implements NewsDAO
{
	public NewsDAOImpl()
	{
		
	}
	
	//Try to fetch the news
	//First try to get them from the redis cache
	//If no news is found, then fetch them from the database
	
	@Override
	public ArrayList<News> getNews()
	{
		ArrayList<News> news = new ArrayList<News>();
		
		try
		{
			SqlConnection.getSqlConnection();
			//First try to get the data from the cache
			Jedis jedis = SqlConnection.getCacheConnection();
			List<String> keys = jedis.sort("all:news", new SortingParams().by("news:*->publishedAt").desc());
			
			if (!keys.isEmpty())
			{
				for (String k : keys)
				{
					Map<String, String> map = jedis.hgetAll("news:" + k); // get the map values for this news
					news.add(new News(map.get("title"), map.get("description"), map.get("url"), Long.parseLong(map.get("publishedAt"))));
				}
				
				System.out.println("News fetched from the cache.");
				
				return news;
			}
		}
		catch (Exception e)
		{
			System.out.println("Could not reach the cache, trying to get the news from the database.");
		}
		
		try
		{
			SqlConnection.getSqlConnection();
			
			Connection conn = SqlConnection.getDbConnection();
			
			String query = "SELECT title, description, url, publishedAt FROM news ORDER BY publishedAt DESC;";
			
			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();
			
			//Don't forget to close the connection
			SqlConnection.closeDbConnection();
			
			while (resultSet.next())
			{
				news.add(new News(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getLong(4)));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("News fetched from the database.");
		
		return news;
	}
	
	//First try to add news to redis cache, then to the sql database
	
	@Override
	public void addNews(ArrayList<News> news)
	{
		try
		{
			SqlConnection.getSqlConnection();
			Jedis jedis = SqlConnection.getCacheConnection();

			for (News n : news)
			{
				//Add news to redis
				HashMap<String, String> hashMap = new HashMap<String, String>();
				
				hashMap.put("title", n.getTitle());
				hashMap.put("description", n.getDescription());
				hashMap.put("url", n.getUrl());
				hashMap.put("publishedAt", String.valueOf(n.getPublishedAt()));
				
				jedis.hmset("news:" + n.getUrl(), hashMap);
				jedis.lpush("all:news", n.getUrl());
			}
			
			//Don't forget to close the connection
			SqlConnection.closeCacheConnection();
			
			System.out.println("News fetched and added to the cache.\n");
		}
		catch (Exception e)
		{
			System.out.println("No cache could be reached.");
		}
		
		try
		{
			SqlConnection.getSqlConnection();
			Connection conn = SqlConnection.getDbConnection();

			for (News n : news)
			{
				//Add news to mySql
				//Using a replace statement to avoid duplicate
				String query = "REPLACE INTO news (title, description, url, publishedAt) VALUES (?, ?, ?, ?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				
				statement.setString(1, n.getTitle());
				statement.setString(2, n.getDescription());
				statement.setString(3, n.getUrl());
				statement.setLong(4, n.getPublishedAt());
				
				statement.execute();
				
			}
			
			//Don't forget to close the connection
			SqlConnection.closeDbConnection();
			
			System.out.println("News fetched and added to the database.\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//First try to add news to redis cache, then to the sql database
	
	@Override
	public void addNews(News news)
	{
		try
		{
			SqlConnection.getSqlConnection();
			
			Jedis jedis = SqlConnection.getCacheConnection();
			//Add news to redis
			HashMap<String, String> hashMap = new HashMap<String, String>();
			
			hashMap.put("title", news.getTitle());
			hashMap.put("description", news.getDescription());
			hashMap.put("url", news.getUrl());
			hashMap.put("publishedAt", String.valueOf(news.getPublishedAt()));
			
			jedis.hmset("news:" + news.getUrl(), hashMap);
			jedis.lpush("all:news", news.getUrl());
			
			SqlConnection.closeCacheConnection();
			
			
			Connection conn = SqlConnection.getDbConnection();
			
			//Using a replace statement to avoid duplicate
			String query = "REPLACE INTO news (title, description, url, publishedAt) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, news.getTitle());
			statement.setString(2, news.getDescription());
			statement.setString(3, news.getUrl());
			statement.setLong(4, news.getPublishedAt());
			
			statement.execute();
			
			//Don't forget to close the connection
			SqlConnection.closeDbConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	//Remove the news ONLY from the sql database
	
	@Override
	public void removeAllNews()
	{
		try
		{
			SqlConnection.getSqlConnection();
			Connection conn = SqlConnection.getDbConnection();
			
			String query = "DELETE FROM news";
			
			PreparedStatement statement = conn.prepareStatement(query);

			statement.execute();
			
			//Don't forget to close the connection
			SqlConnection.closeDbConnection();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
