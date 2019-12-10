package qsp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PopUp 
{
	@Test
	public void Popup() throws InterruptedException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actiTime.com/login.do");	
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath( "//div[.='Login ']")).click();
		
		//driver.findElement(By.className("popup_menu_button popup_menu_button_support")).click();
		//driver.findElement(By.xpath( "//div[.='menu_icon']")).click();
		//driver.findElement(By.className("item_link")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[3]")).click();
		driver.findElement(By.xpath("//a[text()='Contact actiTIME Support']")).click();
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		
		Thread.sleep(3000);
		String filepath= "C:\\Users\\B4S\\Desktop\\Maven_POM_xmlfile.txt";
		StringSelection file = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		
		Robot r = new Robot();
		int control = KeyEvent.VK_CONTROL;
		int v = KeyEvent.VK_V;
		int enter = KeyEvent.VK_ENTER;
		
		
		r.keyPress(control);
		r.keyPress(v);
		Thread.sleep(2000);
		r.keyRelease(control);
		r.keyRelease(v);
		Thread.sleep(2000);
		r.keyPress(enter);
		Thread.sleep(2000);
		r.keyRelease(enter);
				
	}
	
}
