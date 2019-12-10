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

public class Svg
{
	@Test
	public void Line() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///F:/SVG.html");	
		List<WebElement> allelements = driver.findElements(By.xpath("//*"));
		int count =0;
		Actions act = new Actions(driver);
		for(WebElement line : allelements)
		{
			String tname = line.getTagName();
			if(tname.equals("line"))
			{
				count++;
				Thread.sleep(1000);
				String bfcolor = line.getCssValue("stroke");
				System.out.println("before placing cursor "+bfcolor);
				act.moveToElement(line).perform();
				String afcolor = line.getCssValue("stroke");
				System.out.println("After placing cursor "+afcolor);
				System.out.println("----------------------------------------");
				WebElement tooltip = line.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				String text = tooltip.getText();
				System.out.println("tootltip text "+text);
				System.out.println("================================");				
			}
			
		}
		System.out.println("No of lines are "+count);
		Thread.sleep(3000);
		driver.close();
}
}
