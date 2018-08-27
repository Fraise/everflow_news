package objects;

import org.json.*;
import org.json.JSONException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class News
{
	private String title;
	private String description;
	private String url;
	private long publishedAt;
	
	public News()
	{
		this.title = "";
		this.description = "";
		this.url = "";
		this.publishedAt = -1;
	}
	
	public News(String title, String description, String url, long publishedAt)
	{
		this.title = title;
		this.description = description;
		this.url = url;
		this.publishedAt = publishedAt;
	}
	
	public News(JSONObject json)
	{
		this.title = "";
		this.description = "";
		this.url = "";
		this.publishedAt = -1;
		
		
		//Avoid trying to get null values
		Object tempObject;
		
		tempObject = json.get("title");
		if (!tempObject.equals(null)) this.title = (String)tempObject;
		tempObject = json.get("description");
		if (!tempObject.equals(null)) this.description = (String)tempObject;
		tempObject = json.get("url");
		if (!tempObject.equals(null)) this.url = (String)tempObject;
		
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			Date date = format.parse(json.getString("publishedAt"));
			this.publishedAt = date.getTime();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			this.publishedAt = -1;
		}
	}
	
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public long getPublishedAt()
	{
		return this.publishedAt;
	}
	
	public void print()
	{
		System.out.println("* " + this.title + " *\n");
		System.out.println(this.description + "\n");
		System.out.println("From : " + this.url);
		
		//Avoid printing -1 if no date is provided
		if (this.publishedAt > 0)
		{
			Date date = new Date(this.publishedAt);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

			System.out.println("Date : " + format.format(date) + "\n");
		}
		else
		{
			System.out.println("Date : -- \n");
		}
	}

}
