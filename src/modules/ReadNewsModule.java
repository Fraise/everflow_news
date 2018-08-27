package modules;

import java.util.ArrayList;

import dao.NewsDAOImpl;
import objects.News;

public class ReadNewsModule {

	public static void main(String[] args)
	{
		ArrayList<News> news = new ArrayList<News>();
		NewsDAOImpl newsDao = new NewsDAOImpl();
		
		news = newsDao.getNews();
		
		for (News n : news)
		{
			n.print();
		}
		
		System.out.println("All news fetched.");
	}
}
