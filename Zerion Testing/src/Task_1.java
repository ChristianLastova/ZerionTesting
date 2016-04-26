import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;




public class Task_1 {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.iformbuilder.com"); //go to iformbuilder website
		//go to login page
		driver.findElement(By.xpath("//img[@src='http://www.iformbuilder.com/wp-content/uploads/2013/12/sign_in_2014.png']")).click();
		//login
		login("cnl4fh@virginia.edu", "1formPassword!", driver);
		//First Test: Check to see if logged in
		String loggedIn = driver.findElement(By.className("loggedin")).getText();
		if(loggedIn.contains("cnl4fh@virginia.edu")){
			System.out.println("Login Success");
		}else{
			System.out.println("Login Failure");
		}
		//go to data page to create new record
		driver.get("https://app.iformbuilder.com/exzact/dataViews.php");
		driver.get("https://app.iformbuilder.com/exzact/dataList.php?PAGE_ID=3570835");
		driver.findElement(By.id("fbutton_Create_New_Record")).click();
		WebElement text1 = driver.findElement(By.id("p3570835_rec0_text1"));
		WebElement text2 = driver.findElement(By.id("p3570835_rec0_text2"));
		WebElement number1 = driver.findElement(By.id("p3570835_rec0_number1"));
		Actions builder = new Actions(driver);
		builder.moveToElement(text1).click().sendKeys("Christian").perform();
		builder.moveToElement(text2).click().sendKeys("Lastova").perform();
		builder.moveToElement(number1).click().sendKeys("8675309").perform();
		driver.findElement(By.linkText("Save")).click();
		//Test: to see if data page is updated with record
		//I know this is hardcoded. I tried using regular expressions but something kept getting messed up, 
		//so I hardcoded a value in (34). If I was in a work scenario and I encountered this problem, I would first try to look up how to solve
		//it and if that failed consult a more experienced employee to make sure I hardcode as few things as possible due to the app developing over time
		if(driver.findElement(By.xpath("//*[@id='row34_text1']/div")).getText().equals("Christian")){
			System.out.println("Update Success");
		}else{
			System.out.println("Update Failure");
		}
		driver.quit();
	}
	public static void login(String username, String password, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement webUsername = driver.findElement(By.name("USERNAME"));
		WebElement webPassword = driver.findElement(By.name("PASSWORD"));
		//fill in username
		builder.moveToElement(webUsername).click().sendKeys(username).perform();
		//fill in password
		builder.moveToElement(webPassword).click().sendKeys(password).perform();
		//log in
		driver.findElement(By.xpath("//input[@src='https://iform-artwork.s3.amazonaws.com/iformbuilder.com/login.png']")).click();
		//check to make sure I am logged in correctly
	}
	
}
