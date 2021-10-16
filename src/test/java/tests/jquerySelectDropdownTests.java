package tests;

import base.baseTests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import pages.inputForms.JQuerySelectDropdownPage;

public class jquerySelectDropdownTests extends baseTests {

    @BeforeMethod
    public void openJquerySelectPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickJquerySelectDropdownLink();
        test.log(Status.PASS, "Opened JQuery Select Dropdown page");
    }

    @Test
    public void canSelectCountry(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.selectCountry("India");
        test.log(Status.PASS, "Country selected");
        Assert.assertEquals(jQuerySelectDropdownPage.getCountrySelection(),"India","India is not selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void canTypeCountrySelection(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.clickCountryDropdownField();
        test.log(Status.PASS, "Clicked Country dropdown");
        Actions action = new Actions(driver);
        action.sendKeys("Denmark" + Keys.RETURN).perform();
        test.log(Status.PASS, "Typed in country");
        Assert.assertEquals(jQuerySelectDropdownPage.getCountrySelection(),"Denmark","Denmark is not selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void canSelectState(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.selectState("Maine");
        test.log(Status.PASS, "State selected");
        Assert.assertEquals(jQuerySelectDropdownPage.getStateSelection(),"Maine","Maine is not selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void canSelectMultipleStates(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.selectState("Maine");
        test.log(Status.PASS, "State selected");
        jQuerySelectDropdownPage.selectState("Alaska");
        test.log(Status.PASS, "Second state selected");
        Assert.assertEquals(jQuerySelectDropdownPage.getNoOfStatesSelected(),2,"Two states are not selected");
        test.log(Status.PASS, "Selection count verified");
    }

    @Test
    public void canRemoveAState(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.selectState("Maine");
        test.log(Status.PASS, "State selected");
        jQuerySelectDropdownPage.removeSelectedState();
        test.log(Status.PASS, "State unselected");
        Assert.assertEquals(jQuerySelectDropdownPage.getNoOfStatesSelected(),0,"State is still selected");
        test.log(Status.PASS, "Verified no states selected");
    }

    @Test
    public void canTypeAState(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.clickStateDropdownField();
        Actions action = new Actions(driver);
        action.sendKeys("Nevada" + Keys.RETURN).perform();
        test.log(Status.PASS, "State inputted");
        Assert.assertEquals(jQuerySelectDropdownPage.getStateSelection(),"Nevada","Nevada is not selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void canSelectTerritory(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.selectTerritory("Puerto Rica");
        test.log(Status.PASS, "Territory selected");
        Assert.assertEquals(jQuerySelectDropdownPage.getTerritorySelection(),"Puerto Rica","Puerto Rica is not " +
                "selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void cannotSelectCategory(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        try {
            jQuerySelectDropdownPage.selectFile("Other");
        }
        catch(Exception e) {
            test.log(Status.PASS, "Attempted to select 'Other'");
            Assert.assertNotEquals(jQuerySelectDropdownPage.getFileSelection(),"Other","Other is not selected");
            test.log(Status.PASS, "Other not selected");
        }
    }

    @Test
    public void canSelectFile(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        jQuerySelectDropdownPage.selectFile("Java");
        test.log(Status.PASS, "File selected");
        Assert.assertEquals(jQuerySelectDropdownPage.getFileSelection(),"Java","Java is not selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void cannotSelectUnselectableTerritory(){
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage (driver);
        try {
            jQuerySelectDropdownPage.selectTerritory("Guam");
        }
        catch(Exception e) {
            test.log(Status.PASS, "Attempted to select 'Guam'");
            Assert.assertNotEquals(jQuerySelectDropdownPage.getFileSelection(),"Guam","Guam is not selected");
            test.log(Status.PASS, "Guam not selected");
        }
    }

}
