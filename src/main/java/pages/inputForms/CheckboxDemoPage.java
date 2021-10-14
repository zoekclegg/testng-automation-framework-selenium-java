package pages.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxDemoPage {

    WebDriver driver;
    public CheckboxDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="isAgeSelected")
    WebElement singleCheckbox;

    @FindBy(id="txtAge")
    WebElement singleCheckBoxSuccessMessage;

    @FindBy(xpath="//label[contains(.,'Option 1')]/input")
    WebElement option1;

    @FindBy(xpath="//label[contains(.,'Option 2')]/input")
    WebElement option2;

    @FindBy(xpath="//label[contains(.,'Option 3')]/input")
    WebElement option3;

    @FindBy(xpath="//label[contains(.,'Option 4')]/input")
    WebElement option4;

    @FindBy(id="check1")
    WebElement multipleCheckboxButton;

    public void clickMainCheckbox() {
        singleCheckbox.click();
    }

    public boolean isSingleCheckboxSuccessMessageDisplayed(){
        return singleCheckBoxSuccessMessage.isDisplayed();
    }

    public void clickOption1() {
        option1.click();
    }
    public void clickOption2() {
        option2.click();
    }
    public void clickOption3() {
        option3.click();
    }
    public void clickOption4() {
        option4.click();
    }

    public boolean isTickedOption1() {
        return option1.isSelected();
    }

    public boolean isTickedOption2() {
        return option2.isSelected();
    }

    public boolean isTickedOption3() {
        return option3.isSelected();
    }

    public boolean isTickedOption4() {
        return option4.isSelected();
    }

    public boolean allOptionsTicked() {
        return isTickedOption1() && isTickedOption2() && isTickedOption3() && isTickedOption4();
    }

    public boolean allOptionsUnticked() {
        return !isTickedOption1() && !isTickedOption2() && !isTickedOption3() && !isTickedOption4();
    }

    public void clickMultipleCheckboxButton() {
        multipleCheckboxButton.click();
    }

    public String getTextMultipleCheckboxButtonText() {
        return multipleCheckboxButton.getAttribute("value");
    }

}
