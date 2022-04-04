package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRM {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	public static WebDriver driver1;
	
	//Step1
	public BaseHRM() 
	{
		try
		{
		FileInputStream file= new FileInputStream("C:\\Users\\Owner\\eclipse-workspace\\HR_Management\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
		
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
	}
		
		//Step 2
		public static void initiate() throws InterruptedException
		{
			//driver path
			//maximize pageload,implicit, getting url
			String browsername= prop.getProperty("browser");
			if(browsername.equals("GoogleChrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\eclipse-workspace\\SELENIUMPROJ\\chromedriver.exe");
				 driver= new ChromeDriver();
					
			}
			else if(browsername.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Owner\\Desktop\\Navi Data\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
			Thread.sleep(1000);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		
			driver.get(prop.getProperty("url"));
			
			//driver1.get(prop.getProperty("url1"));
		}
	public static void screenshots(String Filename)
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		
		FileUtils.copyFile(file, new File("C:\\Users\\Owner\\eclipse-workspace\\HR_Management\\src\\test\\java\\screenshot\\Screenshots" +Filename+".jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
			}
		}
	
	

}
 