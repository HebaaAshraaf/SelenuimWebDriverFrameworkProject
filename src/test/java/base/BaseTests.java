package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
	private WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox")){
            //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("chrome")){
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
           //create chrome instance
            driver = new ChromeDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
    }

    @BeforeClass
    public void setUp(){
        driver.manage().window().maximize();
    }
    
    @BeforeMethod
    public void beforeMethod() {
    	driver.get("https://the-internet.herokuapp.com/");
    	homePage = new HomePage(driver);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
    	TakesScreenshot camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        try{
            Files.move(screenshot, new File("resources/screenshots/" + browserName + result.getName() + ".png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
