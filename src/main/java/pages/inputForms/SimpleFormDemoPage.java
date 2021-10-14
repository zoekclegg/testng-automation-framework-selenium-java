package pages.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemoPage {

    WebDriver driver;
    public SimpleFormDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-message")
    WebElement userMessageField;

    @FindBy(xpath="//button[contains(text(),'Show Message')]")
    WebElement showMessageButton;

    @FindBy(id="display")
    WebElement userMessage;

    @FindBy(id="sum1")
    WebElement enterAField;

    @FindBy(id="sum2")
    WebElement enterBField;

    @FindBy(xpath="//button[contains(text(),'Get Total')]")
    WebElement getTotalButton;

    @FindBy(id="displayvalue")
    WebElement totalSum;

    public void enterUserMessage(String message) {
        userMessageField.sendKeys(message);
    }

    public void clickShowMessageButton() {
        showMessageButton.click();
    }

    public String getUserMessage() {
        return userMessage.getText();
    }

    public void submitUserMessage(String message){
        enterUserMessage(message);
        clickShowMessageButton();
    }

    public void enterAValue(String a) {
        enterAField.sendKeys(a);
    }

    public void enterBValue(String b) {
        enterBField.sendKeys(b);
    }

    public void clickGetTotalButton() {
        getTotalButton.click();
    }

    public String getSum() { return totalSum.getText();
    }

    public void submitSum(String a, String b){
        enterAValue(a);
        enterBValue(b);
        clickGetTotalButton();
    }
}