import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import pages.MainPage;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class MainPageTest extends BaseTest {

    private MainPage mainPage;


    @BeforeMethod
    public void startUp(){
        mainPage = new MainPage(driver);
    }



    @Test (description =  "Click create Account Button ")
    public void AccountRegistrationBtnClicked(){
        mainPage.clickCreateAccountBtn();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }

    }

    @Test (description = "create Account Button - Open Pop-up window рплор" )
    public void AccountRegistrationOpenPopUp(){

            boolean actualValue = mainPage.clickCreateAccountBtn()
                                .popUpIsDisplayed();
            boolean expectedField = mainPage.popUpIsDisplayed();
        Assert.assertEquals(actualValue,expectedField);
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }

    @Test (description = "Create Account")
    public void AccountCreation(){
        mainPage.clickCreateAccountBtn()
               .accountCreation();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
    }

    @AfterMethod
    public void screenShot() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1, new File("C:\\Users\\kbezsmertnyi\\IdeaProjects\\screenshots\\test1.PNG"));
    }

}
