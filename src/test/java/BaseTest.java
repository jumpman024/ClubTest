import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Config;
import utils.*;
import utils.TestHelper;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static utils.TestHelper.selectDate;
import static utils.TestHelper.selectTime;

public class BaseTest {
    public WebDriver driver;
    private final Properties config = Config.loadProperties("test.properties");

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kbezsmertnyi\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa-club.ubisoft.com/en-US/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDown(ITestResult testResult) throws IOException {
        driver.manage().deleteAllCookies();
        if (testResult.getStatus() == ITestResult.FAILURE) {
            getScreenshot(testResult.getMethod().getMethodName());
        }
        driver.close();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public void getScreenshot(String testMethodName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" +testMethodName+"_"+selectDate()+".png";
        FileUtils.copyFile(screenshot, new File(path));
    }



}
