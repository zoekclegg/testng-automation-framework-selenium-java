package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AjaxFormSubmitPage {

    WebDriver driver;
    public AjaxFormSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="title")
    WebElement nameField;

    @FindBy(xpath="//span[contains(@class,'title-validation') and contains(.,'*')]")
    WebElement nameValidation;

    @FindBy(id="description")
    WebElement commentField;

    @FindBy(id="btn-submit")
    WebElement submitButton;

    @FindBy(css="img[src='LoaderIcon.gif']")
    WebElement loadingSpinner;

    @FindBy(xpath="//div[@id='submit-control' and contains(.,'Form submited Successfully')]")
    WebElement successMessage;

    public void inputName(String name) {
        nameField.sendKeys(name);
    }

    public boolean isNameValidationErrorDisplayed(){
        return nameValidation.isDisplayed();
    }

    public void inputComment(String comment) {
        commentField.sendKeys(comment);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isFormSuccessDisplayed(){
        return successMessage.isDisplayed();
    }

    public ExpectedCondition<Boolean> loaderIconIsInvisible(){
        return ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("img[src='LoaderIcon.gif']"));
    }


}