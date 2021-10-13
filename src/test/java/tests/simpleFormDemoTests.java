package tests;

import base.baseTests;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import pages.*;

public class simpleFormDemoTests extends baseTests {

    @BeforeMethod
    public void openSimpleFormDemoPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickSimpleFormDemoDropdownLink();
        test.log(Status.PASS, "Navigated to Simple Form Demo page");
    }

    @Test
    public void verifyCanInputUserMessage(){
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage (driver);
        simpleFormDemoPage.submitUserMessage("Hello World!");
        test.log(Status.PASS, "Message submitted");
        Assert.assertEquals(simpleFormDemoPage.getUserMessage(), "Hello World!", "Input message doesn't match.");
        test.log(Status.PASS, "Message verified");
    }

    @Test
    public void verifyValidSum(){
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage (driver);
        simpleFormDemoPage.submitSum("4","7");
        test.log(Status.PASS, "Two integers submitted");
        Assert.assertEquals(simpleFormDemoPage.getSum(), "11", "Sum doesn't match.");
        test.log(Status.PASS, "Sum verified");
    }

    @Test
    public void verifySumError(){
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage (driver);
        simpleFormDemoPage.submitSum("x","y");
        test.log(Status.PASS, "Two non-integers submitted");
        Assert.assertEquals(simpleFormDemoPage.getSum(), "NaN", "Error not shown");
        test.log(Status.PASS, "Error verified");
    }

}