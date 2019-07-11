package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


    public class TestBase {
	
	    public static WebDriver driver;
		
	    public static ExtentReports extent;
	
	    public static  ExtentHtmlReporter htmlReporter;
	
	    public static ExtentTest logger;
	    
	   public static WebDriverWait wait;
    
	public static void initialization()  {
		
		
	String PATH = "http://10.100.11.95/";
		
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	
	driver = new ChromeDriver();
	
	wait = new WebDriverWait(driver, 30);
	
	extent = new ExtentReports();

	htmlReporter = new ExtentHtmlReporter("./reports/extent.html");

	extent.attachReporter(htmlReporter);
		
	driver.manage().window().maximize();
	
	driver.manage().deleteAllCookies();
	
	 driver.navigate().to(PATH);
	}
	public static void Login() {
	 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/section/div/form/div[2]/input")));
	
	driver.findElement(By.xpath("/html/body/section/section/div/form/div[2]/input")).sendKeys("isr123@gmail.com");
	
	driver.findElement(By.xpath("/html/body/section/section/div/form/div[3]/input")).sendKeys("israelfrank");
	
	driver.findElement(By.className("btn")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[3]/button")));
	
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button")).click();
	
	 }

	}
	
	
	

