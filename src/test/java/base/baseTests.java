package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DemoHomePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseTests  {

    public Properties prop = new Properties();
    public WebDriver driver;
    public String browserName;
    public String url;
    public utils utils = new utils();
    public ExtentReports extent = ExtentReporterNG.getReportObject();
    public static ExtentTest test;

    @BeforeMethod
    public void setUp() throws IOException {
        test = extent.createTest("Test");
        defineProperties();
        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver","src/main/java/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver","src/main/java/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        test.log(Status.PASS, "Browser opened");
        driver.manage().window().maximize();
        DemoHomePage demoHomePage = new DemoHomePage(driver);
        demoHomePage.waitForPopUp();
        demoHomePage.closePopUp();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void defineProperties() throws IOException {
        FileInputStream data = new FileInputStream("src/main/java/resources/data.properties");
        prop.load(data);
        browserName = prop.getProperty("browser");
        url = prop.getProperty("url");
    }

}