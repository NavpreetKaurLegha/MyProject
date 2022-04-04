package testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRM;
import pompackage.POMLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRM {
	POMLogin Log;
	public static WebDriver driver1;

	public LoginTest() {
		super();// call constructor of parent class
	}

	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initiate();
		screenshots("Login");
		Log = new POMLogin();
	}

	@Test(priority = 1)
	public void Title() {
		String actual = Log.verify();
		System.out.println("Actual title is " + actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider
	public Object [][] Details()
	{
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}

	@Test(priority = 2, dataProvider="Details")
	public void Login(String name, String password) throws InterruptedException {
		Thread.sleep(5000);
		Log.typeusername(name);
		Log.typepswd(password);
		//Log.btn();
		Thread.sleep(10000);
	}

	/*
	 * @Test(priority=3) public void MainPage() throws InterruptedException {
	 * driver1=new ChromeDriver(); driver1.get(
	 * "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	 * 
	 * Actions action= new Actions(driver1);
	 * action.moveToElement(driver1.findElement(By.xpath(
	 * "/html/body/div[1]/div[2]/ul/li[1]/a"))).build().perform(); // to implement
	 * actions required
	 * driver1.findElement(By.cssSelector("#menu_admin_viewAdminModule")).click();
	 * 
	 * //boolean res= driver.findElement(By.cssSelector("#welcome")).isDisplayed();
	 * //driver.findElement(By.partialLinkText("welcome")).click();
	 * //System.out.println(res);
	 * 
	 * Thread.sleep(2000); }
	 */
	/*
	 * @Test(priority = 3)
	 */
	/*
	 * public void Admin() throws InterruptedException { //Select obj= new
	 * Select(driver.findElement(By.id("menu_admin_UserManagement")));
	 * //obj.selectByValue("users"); System.setProperty("Webdriver.chrome.driver",
	 * "chromedriver.exe"); ChromeDriver driver= new ChromeDriver();
	 * //driver.navigate().to(
	 * "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	 * driver.get(
	 * "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	 * Actions action= new Actions(driver);
	 * action.moveToElement(driver.findElement(By.cssSelector(
	 * "menu_admin_viewAdminModule"))).build().perform(); // to implement actions
	 * required driver.findElement(By.partialLinkText("Users")).click();// Partial
	 * link text value is given half
	 */

		/*
		 * Actions action= new Actions(driver1);
		 * action.moveToElement(driver1.findElement(By.partialLinkText("Admin"))).build(
		 * ).perform(); // to implement actions required
		 * driver1.findElement(By.cssSelector("#menu_admin_viewAdminModule")).click();
		 * driver1.findElement(By.partialLinkText("User Management")).click(); boolean
		 * res= driver.findElement(By.linkText("Gmail")).isDisplayed();
		 */
	//}
	/*
	 * @Test(priority=4)
	 * 
	 * public void Title1() { String actual1 = Log.verify1();
	 * System.out.println("Actual1 title is " + actual1);
	 * Assert.assertEquals(actual1, "HI"); }9o
	 */

	/*
	 * @Test(priority=3) public void Submit() throws InterruptedException {
	 * if("username"=="Admin"&&"password"=="admin123") { driver.navigate().to(
	 * "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	 * Thread.sleep(1000); } else { System.out.println("Invalid credentials"); } }
	 */

	@AfterMethod
	public void close() {
		driver.close();
	}
	}


