package payroll;

import org.testng.annotations.Test;

import common.LoginAndLogout;
import common.Utility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class workers {
	
	public WebDriver driver;
	Utility obj=new Utility();
	LoginAndLogout log1=new LoginAndLogout();
	String expectedurl="https://www.qabible.in/payrollapp/";
	
	By worker=By.xpath("//*[@id='w1']/li[4]/a");
	By worker_create=By.xpath("//a[@href='/payrollapp/worker/create']");
	By worker_title=By.xpath("//*[@id='worker-title']");
	By worker_first_name=By.xpath("//*[@id='worker-first_name']");
	By worker_last_name=By.xpath("//*[@id='worker-last_name']");
	By worker_known=By.xpath("//*[@id='worker-known']");
	By worker_phone=By.xpath("//*[@id='worker-phone']");
	By worker_mobile=By.xpath("//*[@id='worker-mobile']");
	By worker_email=By.xpath("//*[@id='worker-email']");
	By worker_gender=By.xpath("//*[@id='worker-gender']");
	By worker_middle_name=By.xpath("//*[@id='worker-middle_name\']");
	By worker_dob=By.xpath("//*[@id='worker-dob']");
	By worker_address1=By.xpath("//*[@id='worker-address1']");
	By worker_address2=By.xpath("//*[@id='worker-address2']");
	By worker_address3=By.xpath("//*[@id='worker-address3']");
	By worker_postcode=By.xpath("//*[@id='worker-postcode']");
	By worker_branch_id=By.xpath("//*[@id='worker-branch_id']");
	By worker_division_id=By.xpath("//*[@id='worker-division_id']");
	By worker_employment_type=By.xpath("//*[@id='worker-employment_type']");
	By worker_payslip_method=By.xpath("//*[@id='worker-payslip_method']");
	By worker_engage_status=By.xpath("//*[@id='worker-engage_status']");
	By worker_ni_number=By.xpath("//*[@id='worker-ni_number']");
	By worker_country=By.xpath("//*[@id='worker-country']");
	By worker_next_btn=By.xpath("//*[@id='w0']/div[4]/div/button");
	
	
	By worker_bank_detail=By.xpath("//a[@href='/payrollapp/worker/bank?id=582']");
	By worker_payment_method=By.xpath("//*[@id='worker-payment_method']");
	By worker_ac_type=By.xpath("//*[@id='worker-ac_type']");
	By worker_ac_name=By.xpath("//*[@id='worker-ac_name']");
	By worker_ac_no=By.xpath("//*[@id='worker-ac_no']");
	By worker_sort_code=By.xpath("//*[@id='worker-sort_code']");
	By worker_start_date=By.xpath("//*[@id='worker-start_date']");
	By worker_roll_no=By.xpath("//*[@id='worker-roll_no']");
	By worker_bank_name=By.xpath("//*[@id='worker-bank_name']");
	By worker_bank_address=By.xpath("//*[@id='worker-bank_address']");
	By worker_bank_savebtn=By.xpath("//*[@id='w0']/div[4]/div/button");
	
	By worker_search=By.xpath("//a[@href='/payrollapp/worker']");
	By worker_search_firstname=By.xpath("//*[@id='workersearch-first_name']");
	By worker_search_lastname=By.xpath("//*[@id='workersearch-last_name']");
	By worker_search_postcode=By.xpath("//*[@id='workersearch-postcode']");
	By worker_search_ninumber=By.xpath("//*[@id='workersearch-ni_number']");
	By worker_search_btn=By.xpath("//*[@id='w0']/div[5]/button[1]");
	
	By worker_payslip=By.xpath("/html/body/section/div/div/div[1]/ul/li[3]/a");
	By worker_payslip_date=By.xpath("//*[@id='payslipsearch-created_at_range']");
	By worker_payslip_Search_btn=By.xpath("//*[@id='w0']/div[2]/button");

	By worker_timsheet=By.xpath("/html/body/section/div/div/div[1]/ul/li[4]/a");
	By worker_timesheet_date=By.xpath("//*[@id='timesheetsearch-created_at_range']");
	By worker_timesheet_Search_btn=By.xpath("//*[@id='w0']/div[2]/button");
	
	By worker_deduction=By.xpath("/html/body/section/div/div/div[1]/ul/li[5]/a");
	By worker_deduction_date=By.xpath("//*[@id='deductionsearch-created_at_range']");
	By worker_deduction_Search_btn=By.xpath("//*[@id='w0']/div[2]/button");
	
	By worker_Rate=By.xpath("/html/body/section/div/div/div[1]/ul/li[6]/a");
	By worker_Rate_client=By.xpath("//*[@id='select2-workerratesearch-client_id-container']");
	By worker_Rate_client1=By.xpath("//*[@class='select2-results__option']");
	By worker_Rate_Search_btn=By.xpath("//*[@id='w0']/div[2]/button");
	
	By worker_Expense=By.xpath("/html/body/section/div/div/div[2]/ul/li[7]/a");
	By worker_Expense_client=By.xpath("//*[@id='select2-workerexpensesearch-client_id-container']");
	By worker_Expense_client1=By.xpath("//*[@class='select2-results__option']");
	By worker_Expense_search_btn=By.xpath("//*[@id='w0']/div[2]/button");
	
  @Test(priority=1)
  public void createWorker() throws InterruptedException {

	  obj.click(worker, 40);
	  obj.click(worker_create,40);
	  obj.dropdown(worker_title, "","Mr", 0);
	  obj.sendkey(worker_first_name,"Biju",40);
	  obj.sendkey(worker_last_name,"Kp",40);
	  obj.sendkey( worker_known,"Pattimattam",40);
	  obj.sendkey( worker_phone,"0477625212",40);
	  obj.sendkey( worker_mobile,"9958491256",40);
	  obj.sendkey( worker_email,"Biju@pattimattam.com",40);
	  obj.dropdown(worker_gender, "","Male", 0);
	  obj.sendkey( worker_middle_name,"Matthay",40);
	  obj.sendkey( worker_dob,"26-04-1994",40);
	  obj.sendkey( worker_address1,"Puthanthara",40);
	  obj.sendkey( worker_address2,"Kaithavana",40);
	  obj.sendkey( worker_address3,"Alappuzha",40);
	  obj.sendkey( worker_postcode,"688003",40);
	  obj.dropdown(worker_branch_id, "","", 1);
	  obj.dropdown(worker_division_id, "","", 1);
	  obj.dropdown(worker_employment_type, "","Paye", 0);
	  obj.dropdown(worker_payslip_method, "","Paper", 0);
	  obj.dropdown(worker_engage_status, "","Paye", 0);
	  obj.sendkey( worker_ni_number,"203456",40);
	  obj.clear(worker_country);
	  obj.sendkey( worker_country,"United Kingdom",40);

	  obj.scroll("0","800");
	  obj.click(worker_next_btn, 40);
	  String agt=obj.gettitle();
	  obj.hardAssert("Worker Bank details: PattimattamMatthay",agt);
	 
  }
  
  
  @Test(priority=2)
  public void bankDetails() throws InterruptedException {
	  
	 // obj.click(worker_bank_detail, 40);
	
	  obj.dropdown(worker_payment_method, "", "", 0);
	  obj.dropdown(worker_ac_type, "", "",0);
	  obj.sendkey(worker_ac_name, "Arun", 40);
	  obj.sendkey(worker_ac_no, "45612389741", 40);
	  obj.sendkey(worker_sort_code, "123456", 40);
	  obj.sendkey(worker_start_date, "06-04-2021", 40);
	  obj.sendkey(worker_roll_no, "25",40);
	  obj.sendkey(worker_bank_name, "ICICI",40);
	  obj.sendkey(worker_bank_address, "Alappuzha", 40);
	  obj.scroll("0", "800");
	  obj.click(worker_bank_savebtn, 40);
	  
  }
  
  @Test(priority=3)
  public void paysliphistory() throws InterruptedException {
	 
	  obj.click(worker_payslip,40);
	  obj.sendkey(worker_payslip_date,"05-04-2021 - 27-04-2021",40);
	  obj.click(worker_payslip_Search_btn,40);
  }
  
  @Test(priority=4)
  public void paysliptimesheethistory() throws InterruptedException {
	 
	  obj.click(worker_timsheet,40);
	  obj.sendkey(worker_timesheet_date,"05-04-2021 - 27-04-2021",40);
	  obj.click(worker_timesheet_Search_btn,40);
  }
  
  @Test(priority=5)
  public void payslipdeductionhistory() throws InterruptedException {
	  
	  obj.click(worker_deduction,40);
	  obj.sendkey(worker_deduction_date,"05-04-2021 - 27-04-2021",40);
	  obj.click(worker_deduction_Search_btn,40);
  }
  @Test(priority=6)
  public void workerRate() throws InterruptedException {
	  
	  obj.click(worker_Rate,40);
	  obj.span(worker_Rate_client,worker_Rate_client1,2);
	  obj.click(worker_deduction_Search_btn,40);
  }
  
  @Test(priority=7)
  public void workerExpense() throws InterruptedException {
	  
	  obj.click(worker_Expense,40);
	  obj.span(worker_Expense_client,worker_Expense_client1,2);
	  obj.click(worker_Expense_search_btn,40);
  }
  
  @Test(priority=8)
  public void searchWorker() throws InterruptedException {
	 
	  obj.click(worker_search, 40);
	  obj.sendkey(worker_search_firstname, "Biju", 40);
	  obj.sendkey(worker_search_lastname, "Kp", 40);
	  obj.sendkey(worker_search_postcode, "688003", 40);
	  obj.sendkey(worker_search_ninumber, "203456",40);
	  obj.click(worker_search_btn, 40);
	  
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException, IOException {
	  driver=obj.loading(expectedurl, "chrome");
	  log1.login();
	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  
	  
	  driver.close();
  }

}
