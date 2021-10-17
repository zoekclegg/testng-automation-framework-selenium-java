package tests.datePickers;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import base.baseTests;
import pages.datePickers.JqueryDatePickerPage;

public class jqueryDatePickerTests extends baseTests {

    @BeforeMethod
    public void openJqueryDataPickerPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickJqueryDatePickerLink();
        test.log(Status.PASS, "Opened JQuery Date Picker page");
    }

    @Test
    public void canSelectFromDateBeforeEndDate(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickToField();
        jqueryDataPickerPage.clickDate("15");
        test.log(Status.PASS, "Selected To date");
        jqueryDataPickerPage.clickFromField();
        jqueryDataPickerPage.clickDate("14");
        test.log(Status.PASS, "Selected From date");
        Assert.assertEquals(jqueryDataPickerPage.getSelectedFromDay(),"14","From date not picked.");
        test.log(Status.PASS, "Selected dates verified");
    }

    @Test
    public void canSelectToDateAfterFromDate(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickFromField();
        jqueryDataPickerPage.clickDate("15");
        test.log(Status.PASS, "Selected From date");
        jqueryDataPickerPage.clickToField();
        jqueryDataPickerPage.clickDate("16");
        test.log(Status.PASS, "Selected To date");
        Assert.assertEquals(jqueryDataPickerPage.getSelectedToDay(),"16","To date not picked.");
        test.log(Status.PASS, "Selected dates verified");
    }

    @Test
    public void cannotSelectFromDateAfterEndDate(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickToField();
        jqueryDataPickerPage.clickDate("10");
        test.log(Status.PASS, "Selected To date");
        jqueryDataPickerPage.clickFromField();
        try {
            jqueryDataPickerPage.clickDate("11");
        }
        catch(Exception e) {
            test.log(Status.PASS, "Attempted to select From date");
        }
        Assert.assertEquals(jqueryDataPickerPage.getSelectedFromValue(), "", "From date was picked.");
        test.log(Status.PASS, "Selected dates verified");
    }

    @Test
    public void cannotSelectToDateBeforeFromDate(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickFromField();
        jqueryDataPickerPage.clickDate("19");
        test.log(Status.PASS, "Selected From date");
        jqueryDataPickerPage.clickToField();
        try {
            jqueryDataPickerPage.clickDate("18");
        }
        catch(Exception e) {
            test.log(Status.PASS, "Attempted to select To date");
        }
        Assert.assertEquals(jqueryDataPickerPage.getSelectedToValue(), "", "To date was picked.");
        test.log(Status.PASS, "Selected dates verified");
    }

    @Test
    public void canViewNextMonth(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickFromField();
        int initialMonth = jqueryDataPickerPage.getSelectedMonthValue();
        jqueryDataPickerPage.clickNextMonth();
        test.log(Status.PASS, "Clicked next month");
        Assert.assertEquals(jqueryDataPickerPage.getSelectedMonthValue(),(initialMonth+1)%13,"Next month not selected");
        test.log(Status.PASS, "Next month viewed");
    }

    @Test
    public void canViewPreviousMonth(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickFromField();
        int initialMonth = jqueryDataPickerPage.getSelectedMonthValue();
        jqueryDataPickerPage.clickPrevMonth();
        test.log(Status.PASS, "Clicked prev month");
        Assert.assertEquals(jqueryDataPickerPage.getSelectedMonthValue(),(initialMonth-1)%13,"Previous month not " +
                "selected");
        test.log(Status.PASS, "Previous month viewed");
    }

    @Test
    public void canSelectFromMonthBeforeToMonth(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickToField();
        jqueryDataPickerPage.clickDate("15");
        test.log(Status.PASS, "Selected To date");
        jqueryDataPickerPage.clickFromField();
        jqueryDataPickerPage.clickPrevMonth();
        test.log(Status.PASS, "Clicked prev month");
        jqueryDataPickerPage.clickDate("18");
        test.log(Status.PASS, "Selected From date");
        Assert.assertEquals(jqueryDataPickerPage.getSelectedFromDay(),"18","From date not picked.");
        test.log(Status.PASS, "Verified selection");
    }

    @Test
    public void cannotSelectFromMonthAfterToMonth(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickToField();
        int initialMonth = jqueryDataPickerPage.getSelectedMonthValue();
        jqueryDataPickerPage.clickDate("15");
        test.log(Status.PASS, "Selected To date");
        jqueryDataPickerPage.clickFromField();
        try {
            jqueryDataPickerPage.clickNextMonth();
        }
        catch(Exception e) {
            test.log(Status.PASS, "Attempted to click next month");
        }
        Assert.assertEquals(jqueryDataPickerPage.getSelectedMonthValue(), initialMonth, "Month has changed");
        test.log(Status.PASS, "Verified unable to select next month");
    }

    @Test
    public void canSelectToMonthAfterFromMonth(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickFromField();
        jqueryDataPickerPage.clickDate("15");
        test.log(Status.PASS, "Selected From date");
        jqueryDataPickerPage.clickToField();
        jqueryDataPickerPage.clickNextMonth();
        test.log(Status.PASS, "Clicked next month");
        jqueryDataPickerPage.clickDate("14");
        test.log(Status.PASS, "Selected To date");
        Assert.assertEquals(jqueryDataPickerPage.getSelectedToDay(),"14","To date not picked.");
        test.log(Status.PASS, "Verified selection");
    }

    @Test
    public void cannotSelectToMonthBeforeFromMonth(){
        JqueryDatePickerPage jqueryDataPickerPage = new JqueryDatePickerPage (driver);
        jqueryDataPickerPage.clickFromField();
        int initialMonth = jqueryDataPickerPage.getSelectedMonthValue();
        jqueryDataPickerPage.clickDate("15");
        test.log(Status.PASS, "Selected From date");
        jqueryDataPickerPage.clickToField();
        try {
            jqueryDataPickerPage.clickPrevMonth();
        }
        catch(Exception e) {
            test.log(Status.PASS, "Attempted to click previous month");
        }
        Assert.assertEquals(jqueryDataPickerPage.getSelectedMonthValue(), initialMonth, "Month has changed");
        test.log(Status.PASS, "Verified unable to select previous month");
    }

}
