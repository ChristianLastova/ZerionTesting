import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

import org.junit.Test;

public class Task_2 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.iformbuilder.com"); //go to iformbuilder website
		//go to login page
		driver.findElement(By.xpath("//img[@src='http://www.iformbuilder.com/wp-content/uploads/2013/12/sign_in_2014.png']")).click();
		//login
		login("cnl4fh@virginia.edu", "1formPassword!", driver);
		String loggedIn = driver.findElement(By.className("loggedin")).getText();
		if(loggedIn.contains("cnl4fh@virginia.edu")){
			System.out.println("Login Success");
		}else{
			System.out.println("Login Failure");
		}
		//because of the "cannot delete same name within 30 days", this test can only be run once unless you edit the SQL stuff
		driver.get("https://app.iformbuilder.com/exzact/adminUsers.php");
		driver.findElement(By.className("new")).click();
		Actions builder = new Actions(driver);
		WebElement newUsername = driver.findElement(By.name("newUsername"));
		WebElement newEmail = driver.findElement(By.name("newEmail"));
		WebElement newPassword = driver.findElement(By.name("newPassword"));
		WebElement newPasswordAgain = driver.findElement(By.name("newPasswordAgain"));
		builder.moveToElement(newUsername).click().sendKeys("SeleniumFuntimes").perform();
		builder.moveToElement(newEmail).click().sendKeys("cnl4fh@virginia.edu").perform();
		builder.moveToElement(newPassword).click().sendKeys("1formPassword!").perform();
		builder.moveToElement(newPasswordAgain).click().sendKeys("1formPassword!").perform();
		driver.findElement(By.linkText("Create User")).click();
		//confirm that user is now visible
		if(driver.findElement(By.linkText("SeleniumFuntimes")).getText().equals("SeleniumFuntimes")){
			System.out.println("New User record found");
		}else{
			System.out.println("New User record not found");
		}
		driver.findElement(By.xpath("//img[@src='https://iform-artwork.s3.amazonaws.com/iformbuilder.com/logout.png']")).click();
		login("SeleniumFuntimes", "1formPassword!", driver);
		//check to make sure logged in
		loggedIn = driver.findElement(By.className("loggedin")).getText();
		if(loggedIn.contains("SeleniumFuntimes")){
			System.out.println("Login Success");
		}else{
			System.out.println("Login Failure");
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
