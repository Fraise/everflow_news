package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import redis.clients.jedis.Jedis;

public class RedisHelper
{	
	public static Jedis getConnection(String url)
	{
		return new Jedis(url);
	}
}
