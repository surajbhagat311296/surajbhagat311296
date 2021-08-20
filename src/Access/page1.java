package Access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class page1 extends home1 {
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
}
