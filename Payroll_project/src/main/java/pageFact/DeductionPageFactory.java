package pageFact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class DeductionPageFactory {

	public WebDriver driver;
	public DeductionPageFactory(WebDriver driver1) {
		// TODO Auto-generated constructor stubs
		this.driver=driver1;
		PageFactory.initElements(driver,this);
		
		
	}
	@FindBy(xpath="//*[@id='w1']/li[5]/a")
	public WebElement deduction;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[2]/a")
	public WebElement add_deduction;
	
	@FindBy(xpath="//*[@id='select2-deduction-worker_id-container']")
	public WebElement deduction_worker;
	
	@FindBy(xpath="//*[@class='select2-results__option']")
	public WebElement deduction_worker_opt;
	
	@FindBy(xpath="//*[@id='deduction-type']")
	public WebElement deduction_type;
	
	@FindBy(xpath="//*[@id='deduction-amount']")
	public WebElement deduction_amount;
	
	@FindBy(xpath="//*[@id='deduction-effective_from']")
	public WebElement deduction_effective_date;
	
	@FindBy(xpath="//*[@id='w0']/div[5]/div/button")
	public WebElement deduction_save_btn;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/ul/li[1]/a")
	public WebElement deductin_click;
	
	public void deduction_click(){
	deduction.click();
	add_deduction.click();
	}
	
	public void deductionWorkerSpan(int index) throws InterruptedException {
		
		deduction_worker.click();
		deduction_worker.findElements(By.xpath("//*[@class='select2-results__option']")).get(index).click();
	}
	
	public void deductiontype_drop(int index){
		Select obt=new Select(deduction_type);
		obt.selectByIndex(index);
	}
	
	public void deductionamt_send(String val){
		 deduction_amount.sendKeys(val);
	}
	
	public void deductiondate_send(String val){
		deduction_effective_date.sendKeys(val);
	}
	
	public void deductiondate_save(){
		deduction_save_btn.click();
	}
	
	public void deductinview(){
		deductin_click.click();
	}
	
}
