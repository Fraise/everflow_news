package helpers;

import org.json.*;
import org.json.JSONException;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class APIHelper
{
	public static JSONObject getData(URL url) throws JSONException, IOException
	{
		JSONObject data = new JSONObject();
        String input;

		URLConnection connection = url.openConnection();
		BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        while ((input = buff.readLine()) != null)
        {
           data = new JSONObject(input);
        }

        buff.close();

		return data;
	}
}
