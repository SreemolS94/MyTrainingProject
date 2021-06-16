package common;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.ReadExcel;

public class LoginAndLogout {

	public static WebDriver driver; 
	Utility obj=new Utility();
	ReadExcel excelobj=new ReadExcel();
	By username=By.xpath("//*[@id='loginform-username']");
	By password=By.xpath("//*[@id='loginform-password']");
	By submit=By.xpath("//*[@id='login-form']/div[5]/button");
	
	public void login() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		Thread.sleep(4000);
		String uname=excelobj.readData(0,0);
		String pass=excelobj.readData(0,1);
		System.out.println(uname);
		obj.sendkey(username,uname,40);
		obj.sendkey(password,pass,40);
		obj.click(submit,40);	
	

	}

}
