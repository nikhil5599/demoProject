package qsp;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Images {

@Test
	public void test() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://demo.actitime.com");
		 WebElement img = driver.findElement(By.xpath("//div[@class='atLogoImg']"));
		 
		 TakesScreenshot t= (TakesScreenshot) driver;
		 File src=t.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("./demo.png"));
		 
		 
		 //find the location ( x and y axis) and size(height and width)
		 int x=img.getLocation().getX();
		 int y=img.getLocation().getY();
		 int h=img.getSize().getHeight();
		 int w=img.getSize().getWidth();
		 
		 System.out.println("x"+x);
		 System.out.println("y"+y);
		 System.out.println("h"+h);
		 System.out.println("w"+w);
		 
		 //crop the img
		 
		 BufferedImage orgimg = ImageIO.read(new FileInputStream("./demo.png"));
		 BufferedImage subimg = orgimg.getSubimage(x, y, w, h);
		 
		 ImageIO.write(subimg, "png", new FileOutputStream("./d.png"));
		 
		 
		 //read act
		 BufferedImage aimg = ImageIO.read(new FileInputStream("./demo.png"));
		 BufferedImage eimg = ImageIO.read(new FileInputStream("./d.png"));
		 
		 DataBuffer aimgpix = aimg.getData().getDataBuffer();
		 DataBuffer eimgpix = eimg.getData().getDataBuffer();
		 
		 
		 int apixcount=aimgpix.getSize();
		 int epixcount=eimgpix.getSize();
		 
				 
		 System.out.println("apix count"+apixcount);
		 System.out.println("epix count"+epixcount);
		 
		 int matchcount= 0;
		 int count=0;
		 if(apixcount>epixcount)
		 {
			 count=epixcount;
			 
			 
		 }
		 else
		 {
			 count=apixcount;
			 
		 }
		 for (int i = 0; i < count; i++)
		 {
			if(aimgpix.getElem(i)==eimgpix.getElem(i));
			{
				matchcount++;
			}
		}
		 
		 int percent=(matchcount*100)/epixcount;
		 System.out.println("percent:"+percent);
		 
		 
		 driver.close();
		 
	}


}
