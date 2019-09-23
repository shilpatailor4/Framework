package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
			System.setProperty("webdriver.chrome.driver", pro.getProperty("chromedriver"));
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void navigate(String urlkey)
	{
		driver.get(pro.getProperty("appurl"));
	}
	
	public void verifyText()
	{
		
	}
	
	public void username(String email)
	{
		//driver.findElement(By.xpath(pro.getProperty("email_xpath")));
		WebElement useremail = driver.findElement(By.xpath(pro.getProperty("email_xpath")));
		useremail.sendKeys(pro.getProperty("email"));
	}
	
	public void emailNext(String next)
	{
	    driver.findElement(By.xpath(pro.getProperty("button_xpath"))).click();
	}
	
	public void password(String pass)
	{
		WebElement passwd = driver.findElement(By.xpath(pro.getProperty("password_xpath")));
		passwd.sendKeys(pro.getProperty("password"));
	}
	
	public void passwordNext(String pnext)
	{
		driver.findElement(By.xpath(pro.getProperty("button1_xpath"))).click();
	}
	
	public void compose(String compo)
	{
		driver.findElement(By.xpath(pro.getProperty("compose_xpath"))).click();
	}
	
	public void to(String emailTo)
	{
		WebElement toemail = driver.findElement(By.name(pro.getProperty("to_name")));
		toemail.sendKeys(pro.getProperty("to_email"));
	}
	
	public void cc(String ccclick)
	{
		driver.findElement(By.xpath(pro.getProperty("cc_xpath"))).click();
		
	}
	
	public void cc_email(String ccemail)
	{
		WebElement email_cc = driver.findElement(By.name(pro.getProperty("ccemail_name")));
		email_cc.sendKeys(pro.getProperty("cc_email"));
	}
	
	public void subject(String subemail)
	{
		WebElement subj = driver.findElement(By.name(pro.getProperty("subject_name")));
		subj.sendKeys(pro.getProperty("subject_text"));
	}
	
	public void body(String btext)
	{
		WebElement textbody = driver.findElement(By.xpath(pro.getProperty("body_xpath")));
		textbody.sendKeys(pro.getProperty("body_text"));
	}
	
	public void attachDoc(String file) throws InterruptedException, IOException
	{
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@tabindex='1']")));
		WebElement addFile = driver.findElement(By.xpath("addFile_xpath"));
		addFile.click();
		
		//Using Autoit tool and write a script and paste script path (Chrome path scrit is changed, it'll work only firefox)
		Runtime.getRuntime().exec("E:\\Shilpa\\Selenium\\AutoitFiles\\GmailFile.exe");
		Thread.sleep(2000);
		
	}
	public void sendbtn(String btnclic)
	{
		driver.findElement(By.xpath(pro.getProperty("send_xpath"))).click();
	}
	
	public void sendpage(String sendp)
	{
		driver.findElement(By.xpath(pro.getProperty("sendpage_xpath"))).click();
	}
	
	/*public void sentmail(String openmail)
	{
		driver.findElement(By.xpath(pro.getProperty("sentmailclick_xpath"))).click();
	}  */
	
	

	
}

