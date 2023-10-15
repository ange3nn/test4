package testselenium1;

  import java.util.concurrent.TimeUnit;
  import org.openqa.selenium.By;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.WebElement;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.chrome.ChromeOptions;
  import org.openqa.selenium.support.ui.Select;

 public class facebooklogin {


	public static void main(String[] args) {

	//Set the path to the ChromeDriver executable

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\2252204\\Downloads\\Open Source_Google_Chrome Driver_114.0.5735.90_chromedriver_win32 (5) (1)\\chromedrivr.exe");

	// Create a new instance of the ChromeDriver
     ChromeOptions chromeOptions= new ChromeOptions();
	 chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
	 WebDriver driver=new ChromeDriver (chromeOptions);
	 driver.manage().window().maximize();

	// Navigate to www.saucedemo.com
	 driver.get("http://www.facebook.com");

	//verify the page direction

	String currentUrl=driver.getCurrentUrl();
	
	if (currentUrl.equals("https://www.facebook.com/")) 
	
	{

	System.out.println("Page in correctly redirected to https://www.facebook.com/");
	
	}else {
		
		System.out.println("Page is not correctly redirected to https://www.facebook.com/");
	}
					

	//verify the create new account is present

	WebElement createAccount = driver.findElement(By.xpath("//a[@data-testid=\"open-registration-for-button\"]"));
	
	if (createAccount.isDisplayed()) {
		
		System.out.println("Create new Account is displayed");
		
	}else {

		System.out.println("Create Account is not displayed");
		
		}

	//fill the text boxes
	WebElement createAccount1 = driver.findElement(By.xpath("//a[@data-testid=\"open-cogitration-form-button\"]" ));
	createAccount1.click();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.name("firstname")).sendKeys("ange");
	driver.findElement(By.name("lastname")).sendKeys("nan");
	driver.findElement (By.name("reg_email__")).sendKeys("108@gmail.com");
	driver.findElement(By.name("reg_email_confirmation__")).sendKeys("10@gmail.com");
	driver.findElement(By.name("reg _passwd_")).sendKeys("123@abcd");

	 //update date of birth
	Select dayDropdown =new Select (driver.findElement(By.id("day")));
    dayDropdown.selectByValue ("3");

    Select monthDropdown = new Select (driver.findElement(By.id("month")));
	monthDropdown.selectByVisibleText("Apr");

    Select yearDropdown = new Select (driver.findElement(By.id("year")));
    yearDropdown.selectByValue ("2002");

	// select gender

	 driver.findElement(By.xpath("//labe[text()='Female']")).click();

	 //Give sign up

     driver.findElement(By.xpath("//button (@type='submit']) [2]")).click();

     //close the browser 
	driver.quit();

	}


}
