package parallelTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class CrossBrowserScript {



    WebDriver driver;

    /**
     * This function will execute before each Test tag in testng.xml
     * @param browser
     * @throws Exception
     */
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Chrome")){
            //create firefox instance
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("firefox")){
            //set path to chromedriver.exe
         WebDriverManager.firefoxdriver().setup();
            //create chrome instance
            driver = new FirefoxDriver();
        }

        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testParameterWithXML() throws InterruptedException{
        driver.get("http://demo.guru99.com/V4/");
        //Find user name
        WebElement userName = driver.findElement(By.name("uid"));
        //Fill user name
        userName.sendKeys("guru99");
        //Find password
        WebElement password = driver.findElement(By.name("password"));
        //Fill password
        password.sendKeys("guru99");
    }
}
