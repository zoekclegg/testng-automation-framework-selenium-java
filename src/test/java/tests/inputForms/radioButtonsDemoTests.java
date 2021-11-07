package tests.inputForms;

import base.baseTests;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DemoHomePage;
import pages.inputForms.RadioButtonsDemoPage;

public class radioButtonsDemoTests extends baseTests {


    @BeforeMethod
    public void openRadioButtonsDemoPage(){
        DemoHomePage homePage = new DemoHomePage(driver);
        homePage.clickDropdownLink("Input Forms", "Radio Buttons Demo");
        test.log(Status.PASS, "Navigated to Radio Buttons Demo page");
    }

    @Test(dataProvider = "singleRadioOptions")
    public void verifySingleRadioText(String option){
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage (driver);
        radioButtonsDemoPage.selectSingleRadioOption(option);
        test.log(Status.PASS, "Option selected");
        radioButtonsDemoPage.clickCheckedValueButton();
        test.log(Status.PASS, "'Get Checked Value' button clicked");
        Assert.assertTrue(radioButtonsDemoPage.getSingleRadioText().contains(option), "Option is not contained in " +
                "text");
        test.log(Status.PASS, "'Checked Value' text verified");
    }

    @DataProvider
    public Object[][] singleRadioOptions() {
        Object[][] data = new Object[2][1];
        data[0][0] = "Male";
        data[1][0] = "Female";
        return data;
    }

    @Test
    public void verifyUncheckedRadioText(){
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage (driver);
        radioButtonsDemoPage.clickCheckedValueButton();
        test.log(Status.PASS, "'Get Checked Value' button clicked");
        Assert.assertTrue(radioButtonsDemoPage.getSingleRadioText().contains("Not checked"), "Option is not contained in " +
                "text");
        test.log(Status.PASS, "'Checked Value' text verified");
    }

    @Test(dataProvider = "groupRadioOptions")
    public void verifyGroupRadioText(String gender, String age){
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage (driver);
        radioButtonsDemoPage.selectGenderMultiRadioOption(gender);
        test.log(Status.PASS, "Gender selected");
        radioButtonsDemoPage.selectAgeMultiRadioOption(age);
        test.log(Status.PASS, "Age selected");
        radioButtonsDemoPage.clickGetValuesButton();
        test.log(Status.PASS, "'Get Values' button clicked");
        Assert.assertTrue(radioButtonsDemoPage.getGroupRadioText().contains(gender) && radioButtonsDemoPage.getGroupRadioText().contains(age), "Options not in text");
        test.log(Status.PASS, "'Get Values' text verified");
    }

    @DataProvider
    public Object[][] groupRadioOptions() {
        Object[][] data = new Object[3][2];
        data[0][0] = "Male";
        data[0][1] = "0 - 5";
        data[1][0] = "Female";
        data[1][1] = "5 - 15";
        data[2][0] = "Male";
        data[2][1] = "15 - 50";
        return data;
    }

}