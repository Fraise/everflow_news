package helpers;

import redis.clients.jedis.Jedis;

public class RedisHelper
{	
	public static Jedis getConnection(String url)
	{
		return new Jedis(url);
	}
}
