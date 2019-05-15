import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;

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
        //hghjghjgjhj
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
}
