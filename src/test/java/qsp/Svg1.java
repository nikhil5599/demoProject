package qsp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Svg1
{
	@Test
	public void Circle() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///F:/svgdemo.html");
		List<WebElement> allelements = driver.findElements(By.xpath("//*"));
		int count =0;
		{
			Actions act = new Actions(driver);
			for(WebElement Circle : allelements)
			{
			String tname = Circle.getTagName();
			if(tname.equals("circle"))
			{
				count++;
				Thread.sleep(1000);		
				act.moveToElement(Circle).perform();
				String color = Circle.getAttribute("fill-opacity");
				System.out.println("After placing cursor "+color);
				System.out.println("----------------------------------------");
			}
			
		}
		System.out.println("No of Circles are "+count);
		}
		}
	}
