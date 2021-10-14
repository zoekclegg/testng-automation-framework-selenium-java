package tests;

import base.baseTests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import pages.inputForms.AjaxFormSubmitPage;
import pages.datePickers.BootstrapDatePickerPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bootstrapDatePickerTests extends baseTests {

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("d");
    int todayDate = Integer.parseInt((formatter.format(date)));

    @BeforeMethod
    public void openBootstrapDataPickerPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickBootstrapDatePickerLink();
        test.log(Status.PASS, "Opened Bootstrap Date Picker page");
    }

    @Test
    public void verifyTodaysDateHighlighted(){
        BootstrapDatePickerPage bootstrapDataPickerPage = new BootstrapDatePickerPage (driver);
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        Assert.assertTrue(bootstrapDataPickerPage.getCalendarDay(todayDate).getAttribute("class").contains("today"),
                "Today's date does not contain 'today' class");
        test.log(Status.PASS, "Verified today's date highlighted");
    }

    @Test
    public void verifyUnableToSelectFutureDate(){
        BootstrapDatePickerPage bootstrapDataPickerPage = new BootstrapDatePickerPage (driver);
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        bootstrapDataPickerPage.clickCalendarDay(todayDate + 1);
        test.log(Status.PASS, "Clicked on Future Date");
        Assert.assertTrue(bootstrapDataPickerPage.isDatePickerVisible(),"Date picker isn't visible");
        test.log(Status.PASS, "Verify date picker still open");
    }

    @Test
    public void verifyUnableToSelectSunday(){
        BootstrapDatePickerPage bootstrapDataPickerPage = new BootstrapDatePickerPage (driver);
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        bootstrapDataPickerPage.clickSunday();
        test.log(Status.PASS, "Clicked on Sunday");
        Assert.assertTrue(bootstrapDataPickerPage.isDatePickerVisible(),"Date picker isn't visible");
        test.log(Status.PASS, "Verify date picker still open");
    }

    @Test
    public void verifyCanSelectToday(){
        BootstrapDatePickerPage bootstrapDataPickerPage = new BootstrapDatePickerPage (driver);
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        bootstrapDataPickerPage.clickTodayButton();
        test.log(Status.PASS, "Clicked 'Today' button");
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        Assert.assertTrue(bootstrapDataPickerPage.getCalendarDay(todayDate).getAttribute("class").contains("active"),
                "Today's date does not contain 'active' class");
        test.log(Status.PASS, "Verified today's date is active");
    }

    @Test
    public void verifyCanClearSelection(){
        BootstrapDatePickerPage bootstrapDataPickerPage = new BootstrapDatePickerPage (driver);
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        bootstrapDataPickerPage.clickTodayButton();
        test.log(Status.PASS, "Clicked 'Today' button");
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        bootstrapDataPickerPage.clickClearButton();
        test.log(Status.PASS, "Clicked 'Clear' button'");
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        Assert.assertFalse(bootstrapDataPickerPage.getCalendarDay(todayDate).getAttribute("class").contains("active"),
                "Today's date contains 'active' class");
        test.log(Status.PASS, "Verified today's date is not active");
    }

    @Test
    public void verifyCanSelectADay(){
        BootstrapDatePickerPage bootstrapDataPickerPage = new BootstrapDatePickerPage (driver);
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        bootstrapDataPickerPage.clickCalendarDay(todayDate - 1);
        test.log(Status.PASS, "Clicked on past date");
        bootstrapDataPickerPage.clickDateField();
        test.log(Status.PASS, "Clicked on Date Field");
        Assert.assertTrue(bootstrapDataPickerPage.getCalendarDay(todayDate - 1).getAttribute("class").contains(
                "active"),
                "Past date doesn't contain 'active' class");
        test.log(Status.PASS, "Verified Past date is active");
    }


}