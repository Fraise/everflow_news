package dao;

import objects.News;
import java.util.ArrayList;

import objects.SqlConnection;

public interface NewsDAO
{
	public abstract ArrayList<News> getNews();
	public abstract void addNews(ArrayList<News> news);
	public abstract void addNews(News news);
	public abstract void removeAllNews();
}
