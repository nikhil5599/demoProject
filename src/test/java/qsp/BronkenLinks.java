package qsp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BronkenLinks 
{

		@Test
		public void UnBroken() throws IOException  
		{
			URL url = new URL("https://www.google.com/");	
			//need to check for broken Link 404
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int rcode = con.getResponseCode();
			System.out.println(rcode);
			String msg = con.getResponseMessage();
			System.out.println(msg);
			}
}
