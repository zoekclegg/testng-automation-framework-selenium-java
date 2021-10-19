package tests.table;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import base.baseTests;
import pages.table.TableFilterPage;

public class tableFilterTests extends baseTests {

    @BeforeMethod
    public void openTableFilterPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickTableFilterLink();
        test.log(Status.PASS, "Opened Table Filter page");
    }

    @Test(dataProvider = "filters")
    public void canFilterByColour(String colour){
        TableFilterPage tableFilterPage = new TableFilterPage(driver);
        tableFilterPage.clickButton(colour);
        test.log(Status.PASS, "Clicked filter");
        Assert.assertTrue(tableFilterPage.verifyResults(colour),"Result count incorrect)");
        test.log(Status.PASS, "Search results verified");
    }

    @DataProvider
    public Object[][] filters() {
        Object[][] data = new Object[3][1];
        data[0][0] = "Green";
        data[1][0] = "Orange";
        data[2][0] = "Red";
        return data;
    }

    @Test
    public void canResetFilter(){
        TableFilterPage tableFilterPage = new TableFilterPage(driver);
        tableFilterPage.clickButton("Green");
        test.log(Status.PASS, "Clicked colour filter");
        tableFilterPage.clickButton("All");
        test.log(Status.PASS, "Clicked All filter");
        Assert.assertTrue(tableFilterPage.allRecordsDisplayed(),"Not all results displayed)");
        test.log(Status.PASS, "Search filter verified");
    }

}
