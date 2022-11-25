package test;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanStatusTest {
  private WebDriver driver;
  @SuppressWarnings("unused")
private Map<String, Object> vars;
  JavascriptExecutor js;
  
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  public void login()
  {
	WebDriverWait wait = new WebDriverWait(driver, 12);
	driver.get("https://my.unt.edu/psp/ps/?cmd=login&languageCd=ENG&");
	driver.manage().window().setSize(new Dimension(1382, 744));
	driver.findElement(By.id("userid")).sendKeys(Properties.username);
	driver.findElement(By.id("pwd")).click();
	driver.findElement(By.id("pwd")).sendKeys(Properties.password);
	driver.findElement(By.cssSelector(".btn")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.id("SCC_PROF_FL_DRV_USERID")));
	assertEquals(driver.findElement(By.id("SCC_PROF_FL_DRV_USERID")).getText().toString(),Properties.rollno);
  }
  
  @DisplayName("Check the Loan Status")
  @Test 
  public void loanStatus() {
	  login();
    WebDriverWait wait = new WebDriverWait(driver, 12);
	
	System.out.println(driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML"));
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("win0divPTNUI_LAND_REC_GROUPLET$4")));
	driver.findElement(By.id("win0divPTNUI_LAND_REC_GROUPLET$4")).click();
	System.out.println("Entered the Loan and scholarships....");
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("AWDSUM_LFF_GRID$0_row_0")));
	System.out.println(driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML"));
	
	if(driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML").contains("Financial Aid") || driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML").contains("Summary")){
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("AWDSUM_LFF_GRID$0_row_0")));
		    driver.findElement(By.id("AWDSUM_LFF_GRID$0_row_0")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("iframe[name='ptModFrame_0']")));
		    WebElement iframe = driver.findElement(By.cssSelector("iframe[name='ptModFrame_0']"));
		    driver.switchTo().frame(iframe);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("SFA_DISB_AMOUNT$0")));
		    driver.findElement(By.id("SFA_DISB_AMOUNT$0")).click();
		    driver.findElement(By.id("SFA_FL_MISC_WRK_SFA_FILLER_FIELD3")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("SFA_FL_WRK_SFA_LN_STATUS_LBL")));
		    if(driver.findElement(By.id("SFA_FL_WRK_SFA_LN_STATUS_LBL")).getText().equals("Approved")) {
				System.out.println("Loan Status Approved!");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("#ICCancel")));
				driver.findElement(By.id("#ICCancel")).click();
			}
			else 
			{ 
				System.out.println("Loan Status is "+driver.findElement(By.id("SFA_FL_WRK_SFA_LN_STATUS_LBL")).getText()); 
				
			}
		    driver.switchTo().defaultContent(); 
		    logout(); 
	}
	else {System.out.println("Not Entered Summary");}
	
  }
  
  @DisplayName("Check the Enrolled Subjects")
  @Test 
  public void enrollment() {
	  login();
    WebDriverWait wait = new WebDriverWait(driver, 12);
	
	System.out.println(driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML"));
	
	wait.until(ExpectedConditions.elementToBeClickable(By.id("win0divPTNUI_LAND_REC_GROUPLET$2")));
	driver.findElement(By.id("win0divPTNUI_LAND_REC_GROUPLET$2")).click();
	
	System.out.println("Entered the Enrollment....");
	
	System.out.println(driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML"));
	
	if(driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML").contains("View My Classes") || driver.findElement(By.xpath("/html/head/title")).getAttribute("innerHTML").contains("Manage Classes")){
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("GRID_TERM_SRC5$0_row_1")));
		    driver.findElement(By.id("GRID_TERM_SRC5$0_row_1")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("DERIVED_SSR_FL_SSR_SCRTAB_DTLS$0")));

		    List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@id, 'DERIVED_SSR_FL_SSR_SCRTAB_DTLS')]//h2/a"));
		    for (WebElement element : elements) {
		       System.out.println("------------------------------------------------------");
		       System.out.println(element.getText());  
		       System.out.println("------------------------------------------------------");
		    }
		    
		    
		   /* for(int i=0; i<6; i++) {
		    	if(driver.findElement(By.xpath("//*[contains(@id, 'DERIVED_SSR_FL_SSR_SCRTAB_DTLS$"+i+"')]")).isDisplayed()) {
		    	 	System.out.println("------------------------------------------------------");
				    System.out.println(driver.findElement(By.xpath("//*[contains(@id, 'DERIVED_SSR_FL_SSR_SCRTAB_DTLS$"+i+"')]")).getText());
				    System.out.println("------------------------------------------------------");
		    	}
		    }
		   */
		    //System.out.println(driver.findElement(By.className("ps-link")).getText().toString());
		    
		    
		    driver.switchTo().defaultContent(); 
		    logout(); 
	}
	else {System.out.println("Not Entered Summary");}
	
 }
  
  public void logout() {
	  WebDriverWait wait = new WebDriverWait(driver, 12);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("PT_ACTION_MENU$PIMG")));
	  driver.findElement(By.id("PT_ACTION_MENU$PIMG")).click();
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("PT_LOGOUT_MENU")));
	  driver.findElement(By.id("PT_LOGOUT_MENU")).click();
	  System.out.println("Logout successful!");
  }
  
  }
