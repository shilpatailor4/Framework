package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	WebDriver driver;
	public Properties pro;
	
	public void openBrowser(String bType)
	{
		//Identify properties
		if(pro == null)
		{
			pro = new Properties();
			
			try {
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\source_test_resources\\productconfig.properties");
				pro.load(fs);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		//initiliaze browsers
		
		if(bType.equals("Mozila"))
		{
			System.setProperty("webdriver.gecko.driver", pro.getProperty("geckodriver"));
			driver = new FirefoxDriver();
		} 
		else if(bType.equals("Chrome"))
		{
			System.setProperty("websdriver.chrome.drive", pro.getProperty("chromedriver"));
			driver = new ChromeDriver();
		}
	}
	
	public void navigate(String urlkey)
	{
		driver.get(pro.getProperty("appurl"));
	}
	
	public void verifyText()
	{
		
	}

}
