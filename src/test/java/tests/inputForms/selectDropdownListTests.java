package tests.inputForms;

import base.baseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import pages.inputForms.SelectDropdownListPage;

public class selectDropdownListTests extends baseTests {

    @BeforeMethod
    public void openRadioButtonsDemoPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickSelectDropDownListLink();
        test.log(Status.PASS, "Navigated to Select Dropdown List page");
    }

    @Test
    public void verifySelectedDayText(){
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage (driver);
        int randOption = utils.randomInt(1,selectDropdownListPage.getNumberOfOptions()-1);
        selectDropdownListPage.selectDropDownOptionByID(randOption);
        test.log(Status.PASS, "Day selected");
        Assert.assertTrue(selectDropdownListPage.getSelectedOptionText().contains(selectDropdownListPage.getSelectedOptionText()));
        test.log(Status.PASS, "'Selected Day' text verified");
    }

    @Test
    public void verifyCanSelectAnOption(){
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage (driver);
        int randOption = utils.randomInt(0,selectDropdownListPage.getNumberOfMultiOptions()-1);
        String value = selectDropdownListPage.getListOfValues().get(randOption);
        selectDropdownListPage.clickMultiOptionByValue(value);
        test.log(Status.PASS, "Option selected");
        Assert.assertEquals(selectDropdownListPage.getFirstSelectedOptionsValue(),value,"The selected value wasn't " +
                "selected.");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void verifyCanSelectMultipleOptions(){
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        int randOption = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        String value = selectDropdownListPage.getListOfValues().get(randOption);
        selectDropdownListPage.clickMultiOptionByValue(value);
        test.log(Status.PASS, "First option selected");
        int randOption2 = randOption;
        while(randOption2 == randOption){
            randOption2 = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        }
        String value2 = selectDropdownListPage.getListOfValues().get(randOption2);
        selectDropdownListPage.clickMultiOptionByValue(value2);
        test.log(Status.PASS, "Second option selected");
        Assert.assertEquals(selectDropdownListPage.getAllSelectedOptions().size(),2,"2 options aren't selected");
        test.log(Status.PASS, "Selection verified");
    }

    @Test
    public void verifyCanUnselectAnOption() {
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        int randOption = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        String value = selectDropdownListPage.getListOfValues().get(randOption);
        selectDropdownListPage.clickMultiOptionByValue(value);
        test.log(Status.PASS, "Option selected");
        selectDropdownListPage.clickMultiOptionByValue(value);
        test.log(Status.PASS, "Option unselected");
        Assert.assertEquals(selectDropdownListPage.getAllSelectedOptions().size(),0,"An option is selected.");
        test.log(Status.PASS, "Unselection verified");

    }

    @Test
    public void verifyFirstSelectedText(){
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        int randOption = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        String value = selectDropdownListPage.getListOfValues().get(randOption);
        selectDropdownListPage.clickMultiOptionByValue(value);
        test.log(Status.PASS, "First option selected");
        int randOption2 = randOption;
        while(randOption2 == randOption){
            randOption2 = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        }
        String value2 = selectDropdownListPage.getListOfValues().get(randOption2);
        selectDropdownListPage.clickMultiOptionByValue(value2);
        test.log(Status.PASS, "Second option selected");
        selectDropdownListPage.clickFirstSelectedButton();
        test.log(Status.PASS, "'First Selected' button clicked");
        Assert.assertTrue(selectDropdownListPage.getAllSelectedText().contains(value),"First Selected Text doesn't " +
                "contain first selected value");
        test.log(Status.PASS, "'First Selected' text verified");
    }

    @Test
    public void verifyAllSelectedText(){
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        int randOption = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        String value = selectDropdownListPage.getListOfValues().get(randOption);
        selectDropdownListPage.clickMultiOptionByValue(value);
        test.log(Status.PASS, "First option selected");
        int randOption2 = randOption;
        while(randOption2 == randOption){
            randOption2 = utils.randomInt(0, selectDropdownListPage.getNumberOfMultiOptions()-1);
        }
        String value2 = selectDropdownListPage.getListOfValues().get(randOption2);
        selectDropdownListPage.clickMultiOptionByValue(value2);
        test.log(Status.PASS, "Second option selected");
        selectDropdownListPage.clickGetAllSelectedButton();
        test.log(Status.PASS, "'Get All Selected' button clicked");
        Assert.assertTrue(selectDropdownListPage.getAllSelectedText().contains(value + "," + value2),"First Selected " +
                "Text " +
                "doesn't" +
                " " +
                "contain first selected value");
        test.log(Status.PASS, "'All Selected' text verified");
    }

}
