package payroll;

import org.testng.annotations.Test;

import common.LoginAndLogout;
import common.Utility;
import pageFact.DeductionPageFactory;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class deduction {
	
	public WebDriver driver;
	Utility obj=new Utility();
	LoginAndLogout log1=new LoginAndLogout();
	String expectedurl="https://www.qabible.in/payrollapp/";
	
	
  @Test
  public void addDeduction() throws InterruptedException {
	  DeductionPageFactory fact=new DeductionPageFactory(driver);
	 fact.deduction_click(); 
	 fact.deductionWorkerSpan(2);
	 fact.deductiontype_drop(1);
	 fact.deductionamt_send("20000");
	 fact.deductiondate_send("09-04-2021");
	 fact.deductiondate_save();
	 Thread.sleep(4000);
	 fact.deductinview();
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException, IOException {
	  driver=obj.loading(expectedurl, "chrome");
	  log1.login();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.close();
  }

}
