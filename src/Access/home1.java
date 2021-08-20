package Access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class home1 {
public static WebDriver driver;
@BeforeMethod
@Parameters({"url"})
		public void browser(String url)
		{
			System.setProperty("webdriver.chrome.driver","D:\\new\\chromedriver_win32 (6)\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get(url);
		}
	
@DataProvider
public Iterator<Object[]> get_test_data() throws IOException
{
	ArrayList<Object[]> testdata= get_data.getdatafrom_excel();
	return testdata.iterator();//iterate each and every element in proper  sequence
}

@Test(dataProvider="get_test_data")
public void reg(String fname,String lname,String email) throws InterruptedException
{
	driver.findElement(By.xpath("//*[@id='r']/span")).click();
	
driver.findElement(By.xpath("//*[@id='contact_fname']")).sendKeys(fname);
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='contact_lname']")).sendKeys(lname);
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='email_id']")).sendKeys(email);

}
@AfterMethod
public void tear()
{
driver.quit();
}
public void tear1()
{

}
}

		
		
	


