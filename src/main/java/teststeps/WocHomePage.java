package teststeps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WocHomePage {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wayofcoding.com/");
    }

    @Test
    public void clickOnExamMenu(){

        driver.findElement(By.xpath("//*[@id=\"micon\"]/ul/li[6]/a")).click();
        wait = new WebDriverWait(driver, 10);
        String currentUrl = driver.getCurrentUrl();
        String actualURL = "https://practicetostudy.in/";
        System.out.println(currentUrl);
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(currentUrl, actualURL);
        softAssert.assertTrue(false,"Actual URL and Expected URl is not matched");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
