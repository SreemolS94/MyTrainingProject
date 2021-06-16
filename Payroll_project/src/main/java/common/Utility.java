package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class Utility {
	
	public static  WebDriver driver;
	//To launch the browser and pass URL to browser
	//url-to pass url 
	//browser-specify the browser want to test
	public WebDriver loading(String url,String browser) throws InterruptedException{
		switch(browser)
		{
       case "chrome":
		   	System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");  
		   	driver=new ChromeDriver();
		   	break;
       case "ie":	   	
		    System.setProperty("webdriver.ie.driver","D:\\selenium\\IEDriverServer.exe" );  
		    driver=new InternetExplorerDriver();
		    break;
		default:
			System.out.println("Please enter valid browser");
		}
		
		Thread.sleep(4000);
		driver.manage().window().maximize();
		driver.get(url);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(4000);
		return driver;
	}
	//perform click
	public void click(By property) {
		driver.findElement(property).click();
	}
	//tittle
	public String gettitle()
	{
		String title=driver.getTitle();
		return title;
	}
	//perform click using thread
	public void click(By property,int sec) throws InterruptedException {
		//driver.findElement(property).click();
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(property)).click();
		//Thread.sleep(2000);
	}
	public void clear(By property) {
		
		driver.findElement(property).clear();
	}
	
	//To pass value to textbox
	public void sendkey(final By property,String arg) {
		//driver.findElement(property).sendKeys(arg);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement key = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(property);
			}
		});
		
			key.click();
	}
	//To pass value to textbox with thread
	public void sendkey(By property,String arg,int sec) throws InterruptedException {
		driver.findElement(property).sendKeys(arg);
		Thread.sleep(sec);
	}
	
	public String getTexts(By property) {
	
		
		return(driver.findElement(property).getText());
		
	}
	//softassert
	public void softAssert(String expect,String actual,boolean b) {
		SoftAssert softAssertion= new SoftAssert();
		softAssertion.assertEquals(expect,actual);
		softAssertion.assertTrue(b);
		softAssertion.assertAll();
		
	}
	
	
	//hardassert
	public void hardAssert(String expect,String actual) {
		
		Assert.assertEquals(actual, expect);
		//Assert.assertTrue(b);
	}
	
	//for scroll vertically
	public void scroll(String values,String value1) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+values+","+value1+")");
		}
	
	//check box selection
	public boolean chekSelection(By property) {
		boolean check=driver.findElement(property).isSelected();
		return check;
		
	}
	//handle alert
	public void alert(String S){
	if(S.toLowerCase().equals("ok")){
	driver.switchTo().alert().accept();
	}
	else{
		driver.switchTo().alert().dismiss();
	}
	}
	//to send text to textbox of alert
	public void alertSendkeys(String msg ){
			driver.switchTo().alert().sendKeys(msg);
		}
	
	//handle dropdown with single selection
	//property-By class object with locator
	//val-specified the value for dropdown and pass to selectByValue Function()
	//txt-specified the value for dropdown and pass to selectByVisibleText Function
	//index-specified the value for dropdown and pass to selectByIndex Function
	public void dropdown(By property,String val,String txt,int index){
		WebElement dr=driver.findElement(property);
		Select ob=new Select(dr);
		if(val!=""){
			ob.selectByValue(val);
		}
		else if(txt!=""){
			ob.selectByVisibleText(txt);
		}
		else{
		ob.selectByIndex(index);
		}
	}
	
	public void span(By property,By property1,int index) throws InterruptedException
	{
		WebElement dropdownBtn = driver.findElement(property);
		dropdownBtn.click();
		Thread.sleep(3000);
		dropdownBtn.findElements(property1).get(index).click();
	}
	//automate iframe
	public void iframe(By property){
	WebElement iframe=driver.findElement(property);
	driver.switchTo().frame(iframe);
	}
	public void takeSnapShot() throws Exception{

		 Date objd=new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("E-yyyy-MM-dd'-'hh-mm-ss");

	      System.out.println("Current Date: " + ft.format(objd));
		
        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        
        

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File("D:/New folder/test"+ft.format(objd)+".jpg");
                //getDate()+"-"+objd.getMonth()+"-"+objd.getYear()+" "+objd.getTime()
               // File DestFile=new File("D:\\New folder\\test"+ft.format(objd)+".jpg");
                //Copy file at destination

                Files.copy(SrcFile, DestFile);

    }

}
