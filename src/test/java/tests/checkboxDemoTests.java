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

public class checkboxDemoTests extends baseTests {

    @BeforeMethod
    public void openCheckboxDemoPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickCheckboxDemoDropdownLink();
        test.log(Status.PASS, "Opened Checkbox Demo page");
    }

    @Test
    public void verifyMessageDisplayedWhenSingleCheckboxTicked(){
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage (driver);
        checkboxDemoPage.clickMainCheckbox();
        test.log(Status.PASS, "Checkbox ticked");
        Assert.assertTrue(checkboxDemoPage.isSingleCheckboxSuccessMessageDisplayed(), "Single checkbox message not " +
                "displayed");
        test.log(Status.PASS, "Success message verified");
    }

    @Test
    public void verifyNoMessageDisplayedWhenSingleCheckboxUnTicked(){
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage (driver);
        checkboxDemoPage.clickMainCheckbox();
        test.log(Status.PASS, "Checkbox ticked");
        checkboxDemoPage.clickMainCheckbox();
        test.log(Status.PASS, "'Checkbox unticked");
        Assert.assertFalse(checkboxDemoPage.isSingleCheckboxSuccessMessageDisplayed(), "Single checkbox message is " +
                "wrongly displayed");
        test.log(Status.PASS, "No message verified");
    }

    @Test
    public void verifyButtonTextWhenAllCheckboxesTicked(){
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage (driver);
        checkboxDemoPage.clickOption1();
        test.log(Status.PASS, "Option one ticked");
        checkboxDemoPage.clickOption2();
        test.log(Status.PASS, "Option two ticked");
        checkboxDemoPage.clickOption3();
        test.log(Status.PASS, "Option three ticked");
        checkboxDemoPage.clickOption4();
        test.log(Status.PASS, "Option four ticked");
        Assert.assertEquals(checkboxDemoPage.getTextMultipleCheckboxButtonText(), "Uncheck All", "Button message not " +
                "as expected");
        test.log(Status.PASS, "'Uncheck all' button text verified'");
    }

    @Test
    public void verifyUncheckAllButton(){
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage (driver);
        checkboxDemoPage.clickOption1();
        test.log(Status.PASS, "Option one ticked");
        checkboxDemoPage.clickOption2();
        test.log(Status.PASS, "Option two ticked");
        checkboxDemoPage.clickOption3();
        test.log(Status.PASS, "Option three ticked");
        checkboxDemoPage.clickOption4();
        test.log(Status.PASS, "Option four ticked");
        checkboxDemoPage.clickMultipleCheckboxButton();
        test.log(Status.PASS, "'Uncheck all' button clicked");
        Assert.assertTrue(checkboxDemoPage.allOptionsUnticked(),"Not all options unticked");
        test.log(Status.PASS, "Verified all options unticked");
    }

    @Test
    public void verifyCheckAllButton(){
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage (driver);
        checkboxDemoPage.clickMultipleCheckboxButton();
        test.log(Status.PASS, "'Check All' button clicked'");
        Assert.assertTrue(checkboxDemoPage.allOptionsTicked(),"Not all options unticked");
        test.log(Status.PASS, "All options checked");
    }

    @Test
    public void verifyButtonTextWhenACheckboxUnticked(){
        CheckboxDemoPage checkboxDemoPage = new CheckboxDemoPage (driver);
        checkboxDemoPage.clickMultipleCheckboxButton();
        test.log(Status.PASS, "'Check All' button clicked");
        checkboxDemoPage.clickOption1();
        test.log(Status.PASS, "Option 1 unticked");
        Assert.assertEquals(checkboxDemoPage.getTextMultipleCheckboxButtonText(), "Check All", "Button message not " +
                "as expected");
        test.log(Status.PASS, "'Check All' button text verified");
    }

}