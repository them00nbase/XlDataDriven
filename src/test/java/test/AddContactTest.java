 package test;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.AddContact;
import page.HomePage;
import page.LoginPage;

import util.BrowserFactory;
import util.Xls_Reader;



public class AddContactTest {
	
Xls_Reader reader=new Xls_Reader("/Users/thegh/documents/Selenium2020excel.xlsx");

String email=reader.getCellData("Sheet1","email",2);
String password=reader.getCellData("Sheet1","password",2);	
String Name=reader.getCellData("Sheet1","Name",2);
String Company=reader.getCellData("Sheet1","Company",2);
String Email=reader.getCellData("Sheet1","Email",2);
String Phone=reader.getCellData("Sheet1","Phone",2);
String Address=reader.getCellData("Sheet1","Address",2);
String City=reader.getCellData("Sheet1","City",2);
String State=reader.getCellData("Sheet1","State",2);
String Zip=reader.getCellData("Sheet1","Zip",2);
	
	
@Test
public void AddingContact()throws InterruptedException{

	WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");

	LoginPage logintotechfios= PageFactory.initElements(driver, LoginPage.class);

	logintotechfios.Login(email,password);

HomePage home= PageFactory.initElements(driver, HomePage.class);

home.NavigateToAddContact();

Thread.sleep(1000);

AddContact contact=PageFactory.initElements(driver, AddContact.class);

Thread.sleep(2000);

contact.FillingUpAdressForm(Name,Company,Email,Phone,Address,City,State,Zip);

AddContact.clickSubmitButton();

driver.close();

driver.quit();

}
}