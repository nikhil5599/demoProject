package qsp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks
{


		@Test
		public void Link() throws Exception 
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get("file:///F:/broken.html");
			driver.get("https://selenium.dev/");
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			
			for(WebElement links : allLinks)
			{
				String text = links.getText();
				String href=links.getAttribute("href");
				System.out.println("Link text: "+text);
				System.out.println("Links attribute value:"+href);
				try
				{
					URL url=new URL(href);
					HttpURLConnection con=(HttpURLConnection) url.openConnection();
					int rcode=con.getResponseCode();
					if(rcode==200)
					{
						System.out.println("Links are not broken");
						System.out.println("----------------------");
					
					}
					else
					{
						System.out.println("Links are broken");
						String msg=con.getResponseMessage();
						System.out.println(msg);
						System.out.println("---------------------");
						
					}
					}
				catch (IOException e)
				{
					//
				}
				}
				
			Thread.sleep(2000);
			driver.close();
		}
}



