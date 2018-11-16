package uiautomation.test;

import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import utility.ExcelUtils;
 
@Test public class Finaltest {
 
	private String sTestCaseName;
 
	private int iTestCaseRow;
 
	WebDriver driver;
 
  @BeforeMethod
 
  public void beforeMethod() throws Exception {
 
	  WebDriver driver = new ChromeDriver(); // create object of ChromeDriver
	  
	  driver.manage().window().maximize();
 
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
      driver.get("https://www.google.com/");	 // Enter the URL
 
  }	
 
  @Test(dataProvider = "Authentication")
 
  public void f(String Images, String Googlesearch) {
 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys(Images);
 
	    System.out.println(Images);
 
	    driver.findElement(By.id("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).Click();
 
		System.out.println(Googlesearch);
  }
  
  @DataProvider
 
  public Object[][] Authentication() throws Exception{
  
	 	ExcelUtils.setExcelFile("/DataDriven/src/Data/TestData.xlsx");
 
	 	sTestCaseName = this.toString();
 	  	
	  	sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
 	
	 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
 
	    Object[][] testObjArray = ExcelUtils.getTableArray("/DataDriven/src/Data/TestData.xlsx","Sheet1",iTestCaseRow);
 
	    	return (testObjArray);
 
		}
 
}
