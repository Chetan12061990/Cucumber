package Cucumber.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	
	@Before("@Chrome")
	public void setUpChrome() {
		
	System.setProperty("webdriver.chrome.driver","src/test/java/Cucumber/resources/chromedriver.exe");
	this.driver= new ChromeDriver();
	this.driver.manage().window().maximize();
	this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	@Before("@Firefox")
	public void setUpFirefox() {
		
		System.setProperty("webdriver.gecko.driver","src/test/java/Cucumber/resources/geckodriver.exe");
		this.driver= new FirefoxDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
	@After
	public void tearDown() {
		driver.close();
		//driver.quit();
	}
	
	@Given("^User navigates to STackflow website$")
	public void user_navigates_to_STackflow_website() throws Throwable {
	   driver.navigate().to("https://stackoverflow.com/");
	}

	@Given("^User click on the log in button$")
	public void user_click_on_the_log_in_button() throws Throwable {
		driver.findElement(By.linkText("Log in")).click();
	}

	@Given("^User enter a valid username$")
	public void user_enter_a_valid_username(DataTable tb) throws Throwable {
		List<List<String>> data =tb.raw();
	   
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(data.get(0).get(0));
	}

	@Given("^User enter a valid password$")
	public void user_enter_a_valid_password(DataTable tb) throws Throwable {
		List<List<String>> data =tb.raw();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.get(0).get(0));
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//button[@id='submit-button']")).click();
	}

	@Then("^User should redirect to homepage$")
	public void user_should_redirect_to_homepage() throws Throwable {
		Thread.sleep(3000);
		WebElement askQuestionsButton = driver.findElement(By.xpath("//a[contains(text(),'Ask Question')]"));
		Assert.assertEquals(true, askQuestionsButton.isDisplayed());
		
	}

}
