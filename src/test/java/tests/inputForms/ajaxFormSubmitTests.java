package tests.inputForms;

import base.baseTests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import pages.inputForms.AjaxFormSubmitPage;

public class ajaxFormSubmitTests extends baseTests {

    @BeforeMethod
    public void openAjaxFormSubmitPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickDropdownLink("Input Forms", "Ajax Form Submit");
        test.log(Status.PASS, "Opened Ajax Form Submit page");
    }

    @Test
    public void verifyNameValidationErrorIsDisplayed(){
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage (driver);
        ajaxFormSubmitPage.clickSubmitButton();
        test.log(Status.PASS, "Submit Button clicked");
        Assert.assertTrue(ajaxFormSubmitPage.isNameValidationErrorDisplayed(),"Name validation not displayed.");
        test.log(Status.PASS, "Name validation error verified");
    }

    @Test
    public void verifyFormSubmitsSuccessfully(){
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage (driver);
        ajaxFormSubmitPage.inputName("Hello World!");
        test.log(Status.PASS, "Name inputted");
        ajaxFormSubmitPage.inputComment("Here's my comment.");
        test.log(Status.PASS, "Comment inputted");
        ajaxFormSubmitPage.clickSubmitButton();
        test.log(Status.PASS, "Submit Button clicked");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ajaxFormSubmitPage.loaderIconIsInvisible());
        test.log(Status.PASS, "Loading Spinner has disappeared");
        Assert.assertTrue(ajaxFormSubmitPage.isFormSuccessDisplayed(),"The form success message validation isn't " +
                "displayed");
        test.log(Status.PASS, "Form success message verified");
    }

}