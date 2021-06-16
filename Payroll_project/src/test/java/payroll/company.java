package payroll;

import org.testng.annotations.Test;

import common.LoginAndLogout;
import common.Utility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class company {
	
	public WebDriver driver;
	Utility obj=new Utility();
	LoginAndLogout log1=new LoginAndLogout();
	String expectedurl="https://www.qabible.in/payrollapp/";
	By company=By.xpath("//*[@id='w1']/li[2]/a");
	By cmny_name=By.xpath("//*[@id='company-company_name']");
	By cmny_email=By.xpath("//*[@id='company-company_email']");
	By cmny_address=By.xpath("//*[@id='company-company_address']");
	By startdate=By.xpath("//*[@id='company-started_at']");
	By save=By.xpath("//*[@id='w0']/div[6]/div/button");
	
	By branch=By.xpath("//a[@href='/payrollapp/branch/create']");
	By text=By.xpath("//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[2]");
	By drop_company=By.xpath("//*[@id='branch-company_id']");
	By branch_name=By.xpath("//*[@id='branch-branch_name']");
	By branch_add=By.xpath("//*[@id='branch-branch_address']");
	By save_branch=By.xpath("//*[@id='w1']/div[5]/div/button");
	
	By branch_viewbtn=By.xpath("//*[@id='w0']/table/tbody/tr[1]/td[5]/a[1]/span");
	By branch_updtebtn=By.xpath("//*[@id='w0']/table/tbody/tr[1]/td[5]/a[2]/span");
	By tabl2=By.xpath("//table[@id='w1']//tbody//tr[2]//td");
	By cmny_row=By.xpath("//table[@id='w1']//tbody//tr[1]//td");
	By brnch_name=By.xpath("//*[@id='w0']/table/tbody/tr[1]/td[3]");
	By division=By.xpath("/html/body/section/div/div/div[1]/ul/li[3]/a");
	By division_company=By.xpath("//*[@id='division-company_id']");
	By division_branch=By.xpath("//*[@id='division-branch_id']");
	By division_name=By.xpath("//*[@id='division-division_name']");
	By table3=By.xpath("//table[@id='w1']//tbody/tr[1]/td");
  @Test(priority=1)
  public void company_branch() throws InterruptedException, IOException {
	  //login
	  log1.login();
	 
	  //company module
	  obj.click(company, 30);
	  //clear data
	  obj.clear(cmny_name);
	  obj.clear(cmny_email);
	  obj.clear(cmny_address);
	 // obj.clear(startdate);
	  
	  //send data to the field
	  obj.sendkey(cmny_name, "Infosys", 40);
	  obj.sendkey(cmny_email, "sreemolsj2014@gmail.com", 40);
	  obj.sendkey(cmny_address, "Technopark,Trivandrum", 40);
	  obj.sendkey(startdate, "01-04-2021", 30);
	  obj.scroll("0", "700");
	  obj.click(save, 40);
	 
	  //branch module  
	  obj.click(branch, 40);
	
	  
	  String companyName= obj.getTexts(text);
	 obj.hardAssert("Infosys",companyName );
	 
  }
  
  @Test(priority=2)
  public void branch_branch() throws InterruptedException {
	  
	  
	  obj.dropdown(drop_company,"","Infosys",0);
	  obj.sendkey(branch_name, "technopark", 40);
	  obj.sendkey(branch_add, "trivandrum", 40);
	  obj.click(save_branch, 40);
	 
	  String branch_nametxt=obj.getTexts(tabl2);
	  obj.hardAssert("technopark", branch_nametxt);
	  
	  
	  obj.click(branch_viewbtn, 40);
	  String companyName= obj.getTexts(text);
	  String companyRow=obj.getTexts(cmny_row);
	  obj.softAssert(companyRow, companyName, true);
	  String branchRow=obj.getTexts(brnch_name);
	  String branch_name1=obj.getTexts(tabl2);
	  obj.softAssert(branch_name1,branchRow,true);
	  
	  
	  obj.click(branch_updtebtn, 40);
	  obj.clear(branch_name);
	  obj.sendkey(branch_name, "test", 40);
	  obj.click(save_branch, 40);
	  System.out.println(branchRow);
	  String branchRowupdt=obj.getTexts(brnch_name);
	  obj.hardAssert("test", branchRowupdt);
	  
  }
  @Test(priority=3)
  public void division_branch() throws InterruptedException {
	  
	  obj.click(division,40);
	  obj.dropdown(division_company,"","Infosys",0);
	  obj.dropdown(division_branch,"","tvm1",0);
	  obj.sendkey(division_name, "Alappuzha", 40);
	  obj.click(save_branch, 40);
	 
	  String division_nametxt=obj.getTexts(table3);
	  obj.hardAssert("Alappuzha", division_nametxt);
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
	  driver=obj.loading(expectedurl, "chrome");
  }

  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  
	  driver.close();
	 
  }

}
