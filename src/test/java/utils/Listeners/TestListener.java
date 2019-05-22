package utils.Listeners;

import tests.BaseTest;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;




public class TestListener extends BaseTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

//    //Text attachments for Allure
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] saveScreenshotPNG (WebDriver driver) {
//        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//    //Text attachments for Allure
//    @Attachment(value = "{0}", type = "text/plain")
//    public static String saveTextLog (String message) {
//        return message;
//    }
//
//    //HTML attachments for Allure
//    @Attachment(value = "{0}", type = "text/html")
//    public static String attachHtml(String html) {
//        return html;
//    }
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//        System.out.println("I am in onStart method " + iTestContext.getName());
//        iTestContext.setAttribute("WebDriver", this.driver);
//    }



    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
