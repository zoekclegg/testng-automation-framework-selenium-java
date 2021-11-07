package tests.table;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import base.baseTests;
import pages.table.TableDataSearchPage;

public class tableDataSearchTests extends baseTests {

    @BeforeMethod
    public void openJqueryDataPickerPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickDropdownLink("Table", "Table Data Search");
        test.log(Status.PASS, "Opened Table Data Search page");
    }

    @Test
    public void canSearchByID(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.inputTaskSearch("3");
        test.log(Status.PASS, "Searched ID");
        Assert.assertTrue(tableDataSearchPage.isValueReturned(1,"3"),"ID not returned)");
        test.log(Status.PASS, "Search results verified");
    }

    @Test
    public void canSearchByTask(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.inputTaskSearch("Wireframes");
        test.log(Status.PASS, "Searched task");
        Assert.assertTrue(tableDataSearchPage.isValueReturned(1,"1"),"ID not returned)");
        test.log(Status.PASS, "Search results verified");
    }

    @Test
    public void canSearchByAssignee(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.inputTaskSearch("Mike Trout");
        test.log(Status.PASS, "Searched assignee");
        Assert.assertTrue(tableDataSearchPage.isValueReturned(1,"2"),"ID not returned)");
        test.log(Status.PASS, "Search results verified");
    }

    @Test
    public void canSearchByStatus(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.inputTaskSearch("failed qa");
        test.log(Status.PASS, "Searched Status");
        Assert.assertTrue(tableDataSearchPage.isValueReturned(1,"3"),"ID not returned)");
        test.log(Status.PASS, "Search results verified");
    }

    @Test
    public void verifyKeywordSearches(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.inputTaskSearch("u");
        test.log(Status.PASS, "Searched string");
        Assert.assertTrue(tableDataSearchPage.verifySearchResults("u"),"Not all results contained string");
        test.log(Status.PASS, "Search results verified");
    }

    @Test
    public void verifyFiltersUnselectableByDefault(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        Assert.assertFalse(tableDataSearchPage.areAnyFiltersEnabled(),"Not all filters are disabled");
        test.log(Status.PASS, "Verified all filters disabled");
    }

    @Test
    public void verifyFiltersCanBecomeSelectable(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        Assert.assertTrue(tableDataSearchPage.areAllFiltersEnabled(),"Not all filters are enabled");
        test.log(Status.PASS, "Verified all filters enabled");
    }

    @Test
    public void verifyFiltersCanBecomeUnselectable(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        Assert.assertFalse(tableDataSearchPage.areAnyFiltersEnabled(),"Not all filters are disabled");
        test.log(Status.PASS, "Verified all filters disabled");
    }

    @Test
    public void canSearchByUserID(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        tableDataSearchPage.inputUserID("3");
        test.log(Status.PASS, "Inputted ID");
        Assert.assertTrue(tableDataSearchPage.verifyUserSearchResults(1,"3"),"Not all results contained ID");
        test.log(Status.PASS, "Verified all search results");
    }

    @Test
    public void canSearchByUsername(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        tableDataSearchPage.inputUsername("o");
        test.log(Status.PASS, "Inputted username");
        Assert.assertTrue(tableDataSearchPage.verifyUserSearchResults(2,"o"),"Not all results contained username");
        test.log(Status.PASS, "Verified all search results");
    }

    @Test
    public void canSearchByFirstName(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        tableDataSearchPage.inputFirstName("d");
        test.log(Status.PASS, "Inputted first name");
        Assert.assertTrue(tableDataSearchPage.verifyUserSearchResults(3,"d"),"Not all results contained first name");
        test.log(Status.PASS, "Verified all search results");
    }

    @Test
    public void canSearchByLastName(){
        TableDataSearchPage tableDataSearchPage = new TableDataSearchPage (driver);
        tableDataSearchPage.clickFilterButton();
        test.log(Status.PASS, "Clicked filter button");
        tableDataSearchPage.inputLastName("o");
        test.log(Status.PASS, "Inputted last name");
        Assert.assertTrue(tableDataSearchPage.verifyUserSearchResults(4,"o"),"Not all results contained last name");
        test.log(Status.PASS, "Verified all search results");
    }

}
