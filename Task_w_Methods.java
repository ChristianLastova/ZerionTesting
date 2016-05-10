import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Task_w_Methods {

//	public static void main(String[] args) {
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://www.iformbuilder.com");
//		login("cnl4fh@virginia.edu", "1formPassword!", driver);
//		if(checkProfileID("459532", driver)){
//			System.out.println("Correct profileID");
//		}else{
//			System.out.println("Incorrect profileID");
//		}
//		if(checkUsername("cnl4fh@virginia.edu", driver)){
//			System.out.println("Correct Username");
//		}else{
//			System.out.println("Incorrect Username");
//		}
//		clickTab("Users", driver);
//		createNewUser(driver);
//		fillUsername("myNewUsername", driver);
//		fillFirstName("Keith", driver);
//		fillLastName("Keith", driver);
//		fillEmail("Keith", driver);
//		fillInitialPW("Keith!123Garber", driver);
//		fillPWConfirm("Keith!123Garber", driver);
//		setCreateForm(true, driver);
//		setCompanyAdmin(false, driver);
//		create(driver);
//		checkUserExists("myNewUsername", driver);
//		driver.quit();
//		
//	}
	
	public static void login(String username, String password, WebDriver driver){
		driver.findElement(By.xpath("//img[@src='http://www.iformbuilder.com/wp-content/uploads/2013/12/sign_in_2014.png']")).click();
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
	
	public static boolean checkProfileID(String profileID, WebDriver driver){
		String loggedIn = driver.findElement(By.id("header_rt")).getText();
		String [] loggedInSplit = loggedIn.split(" ");
		for(int i = 0; i < loggedInSplit.length; i++){
			if(loggedInSplit[i].equals("[" + profileID + "]")){
				return true;
			}
		}
		return false;
	}

	public static boolean checkUsername(String username, WebDriver driver){
		String loggedIn = driver.findElement(By.className("loggedin")).getText();
		if(loggedIn.contains(username)){
			return true;
		}else{
			return false;
		}
	}

	public static void clickTab(String tabName, WebDriver driver){
		if(tabName.toLowerCase().equals("data")){
			driver.get("https://app.iformbuilder.com/exzact/dataViews.php");
		}else if(tabName.toLowerCase().equals("forms")){
			driver.get("https://app.iformbuilder.com/exzact/adminAssignment.php");
		}else if(tabName.toLowerCase().equals("users")){
			driver.get("https://app.iformbuilder.com/exzact/adminUsers.php");
		}else if(tabName.toLowerCase().equals("company")){
			driver.get("https://app.iformbuilder.com/exzact/adminCompanyInfo.php");
		}else if(tabName.toLowerCase().equals("support")){
			driver.get("https://iformbuilder.zendesk.com/home");
		}else{
			System.out.println("method \'clickTab\' incorrect input \'" + tabName + "\'");
		}
				
	}

	public static void createNewUser(WebDriver driver){
		driver.findElement(By.className("new")).click();
	}

	public static void fillUsername(String username, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement newUsername = driver.findElement(By.name("newUsername"));
		builder.moveToElement(newUsername).click().sendKeys(username).perform();
	}

	public static void fillFirstName(String firstName, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement newFirstName = driver.findElement(By.name("newFirstname"));
		builder.moveToElement(newFirstName).click().sendKeys(firstName).perform();
	}

	public static void fillLastName(String lastName, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement newLastName = driver.findElement(By.name("newLastname"));
		builder.moveToElement(newLastName).click().sendKeys(lastName).perform();
	}

	public static void fillEmail(String emailAddress, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement newEmail = driver.findElement(By.name("newEmail"));
		builder.moveToElement(newEmail).click().sendKeys(emailAddress).perform();
	}

	public static void fillInitialPW(String initialPW, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement newInitialPW = driver.findElement(By.name("newPassword"));
		builder.moveToElement(newInitialPW).click().sendKeys(initialPW).perform();
	}

	public static void fillPWConfirm(String initialPWconfirm, WebDriver driver){
		Actions builder = new Actions(driver);
		WebElement newInitialPWconfirm = driver.findElement(By.name("newPasswordAgain"));
		builder.moveToElement(newInitialPWconfirm).click().sendKeys(initialPWconfirm).perform();
	}

	public static void setCreateForm(boolean bool, WebDriver driver){
		if(bool){
			WebElement newFormCreateRights = driver.findElement(By.name("newCreateRight"));
			newFormCreateRights.click();
		}
	}

	public static void setCompanyAdmin(boolean bool, WebDriver driver){
		if(bool){
			WebElement newAdminRights = driver.findElement(By.name("newAdminRight"));
			newAdminRights.click();
		}
	}

	public static void create(WebDriver driver){
		driver.findElement(By.linkText("Create User")).click();
	}
	
	public static boolean checkUserExists(String username, WebDriver driver){
		if(driver.findElement(By.linkText("myNewUsername")).getText().equals(username)){
			System.out.println("Found username \'" + username + "\'");
			return true;
		}else{
			System.out.println("Could not find username \'" + username + "\'");
			return false;
		}
	}
	//	//Login and check login status
	//	login(myUser,myPassword)
	//	test("Checking profile ID") = (profileID = "54321")
	//	test("Checking username") = (userName = "myUser")
	//
	//	//Go to user tab and create user
	//	click.adminUsers
	//	adminUsers.createNew
	//	adminUsers.createNew.userName("mynewUsername")
	//	adminUsers.createNew.firstName("Keith")
	//	adminUsers.createNew.lastName("Keith")
	//	adminUsers.createNew.email("Keith")
	//	adminUsers.createNew.initialPW("Keith")
	//	adminUsers.createNew.initialPWConfirm("Keith")
	//	adminUsers.createNew.createForms(true)
	//	adminUsers.createNew.companyAdmin(false)
	//	adminUsers.createNew.create
	//
	//	//Confirm user was created
	//
	//	searchBar.find("mynewUsername")
	//	searchBar.setOption("Username")
	//	searchBar.exact(true)
	//	searchBar.search
	//	test("Checking to see if username exists") = flexiGrid.contains("mynewusername") = true)
}
