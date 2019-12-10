package qsp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class BrokenImgs 
{

	@Test
	public void Broken() throws IOException  
	{
		URL url = new URL("image Link");	
		//need to check for broken Link 404
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int rcode = con.getResponseCode();
		System.out.println(rcode);
		String msg = con.getResponseMessage();
		System.out.println(msg);
		}
}

