package modules;

import helpers.APIHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import objects.News;
import dao.NewsDAOImpl;

public class GetNewsModule
{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<News> news = new ArrayList<News>();
		NewsDAOImpl newsDao = new NewsDAOImpl();
		
		try
		{
			JSONObject data = APIHelper.getData(new URL("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=57f4696d8c28484f849bc09108670849"));
			JSONArray articles = data.getJSONArray("articles");
			
			for (int i = 0; i < articles.length(); i++)
			{
				news.add(new News(articles.getJSONObject(i)));
			}
			
			newsDao.addNews(news);
		}
		catch (JSONException | IOException e)
		{
			System.out.println("Error, can't fetch or store the news.\n");
	        e.printStackTrace();
	    }
	}

}
