package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import java.util.Random;
import static utils.TestHelper.randomInt;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//button[@class='layout-btn register-button btn-wrapper dark-background btn btn-null btn-md']")
    private WebElement createAccountBtn;

    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div/div/div/div/iframe")
    private WebElement popUp;

    @FindBy (xpath = "//button[@class='layout-btn btn btn-primary btn-md']")
    private WebElement logIn;

    @FindBy (xpath = "//input[@id='AccountEmail']")
    private WebElement inputEmail;

    @FindBy (xpath = "//input[@id='ConfirmAccountEmail']")
    private WebElement confirmInputEmail;

    @FindBy (xpath = "//input[@id='AccountPassword']")
    private WebElement inputPassword;

    @FindBy (xpath = "//input[@id='Username']")
    private WebElement inputUsername;

    @FindBy (xpath = "//select[@formcontrolname='day']")
    private WebElement dayOfBirth;

    @FindBy (xpath = "//select[@formcontrolname='month']")
    private WebElement monthOfBirth;

    @FindBy (xpath = "//select[@formcontrolname='year']")
    private WebElement yearOfBirth;

    @FindBy (xpath = "//input[@id='tosCheckbox']")
    private WebElement termsOfUse;

    @FindBy (xpath = "//input[@class='custom-checkbox ng-untouched ng-pristine ng-valid']")
    private WebElement shareInformation;

//    @FindBy (xpath = "/html/body/app-component/div/app-create-component/main/app-create-shared-component/section/form/email-component/div/div[1]")
//    private WebElement some;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-block']")
    private WebElement createAccount;



    public MainPage clickCreateAccountBtn(){
        WebDriverWait dynamicElement = (new WebDriverWait(driver, 10));
        dynamicElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='layout-btn register-button btn-wrapper dark-background btn btn-null btn-md']")));
        Actions builder = new Actions(driver);
        builder.moveToElement(createAccountBtn).build().perform();
                        createAccountBtn.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean popUpIsDisplayed(){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div/iframe")));
        return popUp.isDisplayed();
    }


    public String username = "Test.Account"+ randomInt() + "@ubi.com";

    public MainPage accountCreation(){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='layout-btn register-button btn-wrapper dark-background btn btn-null btn-md']")));
        Actions builder = new Actions(driver);
        builder.moveToElement(createAccountBtn).build().perform();
        createAccountBtn.sendKeys(Keys.ENTER);
//        WebElement dynamic1Element = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/div/iframe")));
        driver.switchTo().frame(1);

        inputEmail.sendKeys(username);
        confirmInputEmail.sendKeys(username);
        inputPassword.sendKeys("Test.Account");
        inputUsername.sendKeys("Account"+randomInt());
        Select day = new Select(dayOfBirth);
        day.selectByValue("8");
        Select month = new Select(monthOfBirth);
        month.selectByValue("8");
        Select year = new Select(yearOfBirth);
        year.selectByValue("1990");
        Actions builer = new Actions(driver);
        builer.moveToElement(termsOfUse).click().build().perform();
        builer.moveToElement(shareInformation).click().build().perform();
        createAccount.click();
        System.out.println(username);
        return  this;
    }




}
