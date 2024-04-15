package gui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    public WebDriver getDriver(){
        return this.driver;
    }

    @BeforeTest
    public void tearUp(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(11));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        System.out.println(" THE CHROME BROWSER HAS STARTED ");
    }

    @AfterTest
    public void tearDown(){
        if (this.driver != null){
            this.driver.quit();
        }
    }

    public void sleepy(long milliSec){
        try {
            Thread.sleep(milliSec);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

