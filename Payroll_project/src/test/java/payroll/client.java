package payroll;

import org.testng.annotations.Test;

import common.LoginAndLogout;
import common.Utility;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class client {
	
	public WebDriver driver;
	Utility obj=new Utility();
	LoginAndLogout log1=new LoginAndLogout();
	String expectedurl="https://www.qabible.in/payrollapp/";
	boolean check;

	By client=By.xpath("//a[@href='/payrollapp/client/index']");
	By create_client=By.xpath("//a[@href='/payrollapp/client/create']");
	By client_branch=By.xpath("//*[@id='client-branch_id']");
	By client_division=By.xpath("//*[@id='client-division_id']");
	By client_name=By.xpath("//*[@id='client-client_name']");
	By client_address=By.xpath("//*[@id='client-client_address']");
	By client_postcode=By.xpath("//*[@id='client-postcode']");
	By client_country=By.xpath("//*[@id='client-country']");
	By client_ref=By.xpath("//*[@id='client-your_ref']");
	By client_invoice_contact=By.xpath("//*[@id='client-invoice_contact']");
	By client_phone=By.id("client-phone");
	By client_fax=By.xpath("//*[@id='client-fax']");
	By client_email=By.xpath("//*[@id='client-email']");
	By client_company_reg=By.xpath("//*[@id='client-company_reg']");
	By client_invoice_order=By.xpath("//*[@id='client-invoice_order']");
	By client_invoice_delivery_method=By.xpath("//*[@id='client-invoice_delivery_method']");
	By client_master_document=By.xpath("//*[@id='client-master_document']");
	By client_settilement_days=By.xpath("//*[@id='client-settilement_days']");
	By client_vat_rate=By.xpath("//*[@id='client-vat_rate']");
	By client_save_btn=By.xpath("//*[@id='w0']/div[4]/div/button");
	By client_division_text=By.xpath("//*[@id='w0']/tbody/tr[1]/td");
	By client_require=By.xpath("//*[@id='client-require_po']");
	By client_direct=By.xpath("//*[@id='w0']/div[3]/div[7]/input");
	By client_uk=By.xpath("//*[@id='client-uk_public_sector_client']");
	By client_subject=By.xpath("//*[@id='w0']/div[3]/div[9]/input");
	
	By client_search_name=By.xpath("//*[@id='clientsearch-client_name']");
	By client_search_id=By.xpath("//*[@id='clientsearch-id']");
	By client_search_btn=By.xpath("//*[@id='w0']/div[3]/button[1]");
	By client_id=By.xpath("//*[@id='w1']/table/tbody/tr[1]/td[1]");
	
	By client_view_btn=By.xpath("//*[@id='w1']/table/tbody/tr/td[6]/a[1]/span");
	By client_view_name=By.xpath("//*[@id='w0']/tbody/tr[3]/td");
	By client_update_btn=By.xpath("//*[@id='w1']/table/tbody/tr/td[6]/a[2]/span");
	By client_fax_updt=By.xpath("//*[@id='w0']/tbody/tr[9]/td");
	By client_phn_updt=By.xpath("//*[@id='w0']/tbody/tr[8]/td");
	
  @Test(priority=1)
  public void createClient() throws InterruptedException, IOException {
	  
	//login
	  log1.login();
	 
	  
	  obj.click(client, 40);
	  obj.click(create_client, 40);
	 
	  
	  obj.dropdown(client_branch, "", "", 1);
	  obj.dropdown(client_division, "", "", 1);
	  obj.sendkey(client_name, "sree", 30);
	  obj.sendkey(client_address, "avsd", 40);
	  obj.sendkey(client_postcode, "670234", 40);
	  obj.clear(client_country);
	  obj.sendkey(client_country, "India", 40);
	  obj.sendkey(client_ref, "2345", 40);
	  obj.sendkey(client_invoice_contact, "042745678", 40);
	  obj.sendkey(client_phone, "9873456756", 40);
	  obj.sendkey(client_fax, "13231@fax.com", 40);
	  obj.sendkey(client_email, "sree123@gmail.com", 40);
	  obj.sendkey(client_company_reg, "43567", 40);
	  obj.dropdown(client_invoice_order, "", "Invoice per worker",3 );
	  obj.dropdown(client_invoice_delivery_method, "", "Paper", 1);
	  obj.dropdown(client_master_document, "", "PDF",2);
	  obj.sendkey(client_settilement_days, "5", 40);
	  obj.dropdown(client_vat_rate, "", "VAT 5.00%", 1);
	 
	  check=obj.chekSelection(client_require);
		//System.out.println(check);
		
		if(check!=true) {
			obj.click(client_require);
		}
	  obj.scroll("0", "800");
	  obj.click(client_save_btn, 40);
	  String division_text=obj.getTexts(client_division_text);
	  obj.hardAssert("NewAlpha",division_text );
  }
  @Test(priority=2)
  public void searchClient() throws InterruptedException {
	  obj.click(client, 40);
	  obj.sendkey(client_search_name, "sree",40);
	  obj.sendkey(client_search_id, "299", 40);
	  obj.click(client_search_btn, 40);
	  String id=obj.getTexts(client_id);
	  System.out.println("id:"+id);
	  obj.hardAssert("299", id);
  }
  
  @Test(priority=3)
  public void view() throws InterruptedException {
	  Thread.sleep(4000);
	  obj.click(client_view_btn, 40);
	  String name=obj.getTexts(client_view_name);
	  obj.hardAssert("sree", name);
	  
	  
  }
  @Test(priority=4)
  public void update() throws InterruptedException {
	  
	  obj.click(client, 40);
	  obj.sendkey(client_search_name, "sree",40);
	  obj.sendkey(client_search_id, "299", 40);
	  obj.click(client_search_btn, 40);
	  obj.click(client_update_btn, 40);
	  
	  obj.clear(client_phone);
	  obj.clear(client_fax);
	  obj.sendkey(client_phone, "9876593091", 40);
	  obj.sendkey(client_fax, "abcde@fax.com", 40);
	  obj.scroll("0", "800");
	  obj.click(client_save_btn, 40);
	  String client_fax_updte=obj.getTexts(client_fax_updt);
	  String client_phn_updte=obj.getTexts(client_phn_updt);
	  obj.hardAssert("abcde@fax.com", client_fax_updte);
	  obj.hardAssert("9876593091", client_phn_updte);  
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
