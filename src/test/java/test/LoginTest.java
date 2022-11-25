package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		// setting headless mode to true.. so there isn't any ui
		options.setHeadless(true);
		driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void login() {
		WebDriverWait wait = new WebDriverWait(driver, 12);
		driver.get("https://my.unt.edu/psp/ps/?cmd=login&languageCd=ENG&");
		driver.manage().window().setSize(new Dimension(1382, 744));
		driver.findElement(By.id("userid")).sendKeys(Properties.username);
		driver.findElement(By.id("pwd")).click();
		driver.findElement(By.id("pwd")).sendKeys(Properties.password);
		driver.findElement(By.cssSelector(".btn")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("SCC_PROF_FL_DRV_USERID")));
		assertEquals(driver.findElement(By.id("SCC_PROF_FL_DRV_USERID")).getText().toString(), Properties.rollno);
	}

	@Test
	public void logout() {
		login();
		WebDriverWait wait = new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("PT_ACTION_MENU$PIMG")));
		driver.findElement(By.id("PT_ACTION_MENU$PIMG")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("PT_LOGOUT_MENU")));
		driver.findElement(By.id("PT_LOGOUT_MENU")).click();
		System.out.println("Logout successful!");
	}
}
