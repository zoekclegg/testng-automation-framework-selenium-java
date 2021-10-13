package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoHomePage {

    WebDriver driver;
    public DemoHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[contains(@class,'at-cm-no-button')]")
    WebElement popUpCloseButton;

    @FindBy(xpath="//a[contains(text(),'Input Forms') and @class='dropdown-toggle']")
    WebElement inputFormsDropdown;

    @FindBy(linkText="Simple Form Demo")
    WebElement simpleFormDemoLink;

    @FindBy(linkText="Checkbox Demo")
    WebElement checkboxDemoLink;

    @FindBy(linkText="Radio Buttons Demo")
    WebElement radioButtonsDemoLink;

    @FindBy(linkText="Select Dropdown List")
    WebElement selectDropdownListLink;

    @FindBy(linkText="Ajax Form Submit")
    WebElement ajaxFormSubmitLink;


    public void waitForPopUp(){
        WebDriverWait wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(popUpCloseButton));
    }

    public void closePopUp() {
        popUpCloseButton.click();
    }

    public void clickSimpleFormDemoDropdownLink() {
        inputFormsDropdown.click();
        simpleFormDemoLink.click();
    }

    public void clickCheckboxDemoDropdownLink() {
        inputFormsDropdown.click();
        checkboxDemoLink.click();
    }

    public void clickRadioButtonsDemoDropdownLink() {
        inputFormsDropdown.click();
        radioButtonsDemoLink.click();
    }

    public void clickSelectDropDownListLink() {
        inputFormsDropdown.click();
        selectDropdownListLink.click();
    }

    public void clickAjaxFormSubmitLink() {
        inputFormsDropdown.click();
        ajaxFormSubmitLink.click();
    }

}