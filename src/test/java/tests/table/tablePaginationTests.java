package tests.table;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import base.baseTests;
import pages.datePickers.JqueryDatePickerPage;
import pages.table.TablePaginationPage;

public class tablePaginationTests extends baseTests {

    @BeforeMethod
    public void openJqueryDataPickerPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickDropdownLink("Table", "Table Pagination");
        test.log(Status.PASS, "Opened Table Pagination page");
    }

    @Test
    public void canNavigateToSelectedPage(){
        TablePaginationPage tablePaginationPage = new TablePaginationPage (driver);
        int initialFirstResult = tablePaginationPage.getFirstRowID();
        tablePaginationPage.clickPageNumber("3");
        test.log(Status.PASS, "Clicked page number");
        Assert.assertTrue(tablePaginationPage.getActivePage()==3 && tablePaginationPage.getFirstRowID() != initialFirstResult);
        test.log(Status.PASS, "Verified new page selected");
    }

    @Test
    public void canNavigateToNextPage(){
        TablePaginationPage tablePaginationPage = new TablePaginationPage (driver);
        int initialLastResult = tablePaginationPage.getLastRowID();
        int initialActivePage = tablePaginationPage.getActivePage();
        tablePaginationPage.clickNextPage();
        test.log(Status.PASS, "Clicked next page");
        Assert.assertTrue(tablePaginationPage.getActivePage()==initialActivePage+1 && tablePaginationPage.getFirstRowID()==initialLastResult+1);
        test.log(Status.PASS, "Verified next page selected");
    }

    @Test
    public void canNavigateToPreviousPage(){
        TablePaginationPage tablePaginationPage = new TablePaginationPage (driver);
        tablePaginationPage.clickPageNumber("3");
        test.log(Status.PASS, "Navigate to page greatert than 1");
        int initialFirstResult = tablePaginationPage.getFirstRowID();
        int initialActivePage = tablePaginationPage.getActivePage();
        tablePaginationPage.clickPreviousPage();
        test.log(Status.PASS, "Clicked previous page");
        Assert.assertTrue(tablePaginationPage.getActivePage()==initialActivePage-1 && tablePaginationPage.getLastRowID()==initialFirstResult-1);
        test.log(Status.PASS, "Verified previous page selected");
    }

    @Test
    public void verifyPreviousPageLinkDisabledOnFirstPage(){
        TablePaginationPage tablePaginationPage = new TablePaginationPage (driver);
        tablePaginationPage.clickPageNumber("1");
        test.log(Status.PASS, "Navigated to page 1");
        try {
            tablePaginationPage.clickPreviousPage();
        }
        catch(Exception e){
            test.log(Status.PASS, "Attempted to navigate to previous page");
        }
        Assert.assertEquals(tablePaginationPage.getActivePage(),1,"Page one not selected");
        test.log(Status.PASS, "Verified previous page link is not displayed");
    }

    @Test
    public void verifyNextPageLinkDisabledOnLastPage(){
        TablePaginationPage tablePaginationPage = new TablePaginationPage (driver);
        tablePaginationPage.clickPageNumber("3");
        test.log(Status.PASS, "Navigated to last page");
        try {
            tablePaginationPage.clickNextPage();
        }
        catch(Exception e){
            test.log(Status.PASS, "Attempted to navigate to next page");
        }
        Assert.assertEquals(tablePaginationPage.getActivePage(),3,"Last page not selected");
        test.log(Status.PASS, "Verified next page link is not displayed");
    }

}
