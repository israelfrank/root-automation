package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


    public class TestBase {
	
	    public static WebDriver driver;
		
	    public static ExtentReports extent;
	
	    public static  ExtentHtmlReporter htmlReporter;
	
	    public static ExtentTest logger;
	
    
	public static void initialization() {
		
		
	String PATH = "http://10.100.11.95/";
		
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
	
	driver = new ChromeDriver();
	
	extent = new ExtentReports();

	htmlReporter = new ExtentHtmlReporter("./reports/extent.html");

	extent.attachReporter(htmlReporter);
		
	driver.manage().window().maximize();
	
	driver.manage().deleteAllCookies();
	
	 driver.navigate().to(PATH);
	 
	 driver.findElement(By.className("btn-primary")).click();
	 

	}
	
	
	
}
