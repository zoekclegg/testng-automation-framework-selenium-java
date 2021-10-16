package pages.datePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class JqueryDatePickerPage {

    WebDriver driver;
    public JqueryDatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="from")
    WebElement fromField;

    @FindBy(id="to")
    WebElement toField;

    @FindBy(xpath="//select[@data-handler='selectMonth']")
    WebElement monthDropdown;

    @FindBy(xpath="//a[@data-handler='prev']")
    WebElement prevMonthLink;

    @FindBy(xpath="//a[@data-handler='next']")
    WebElement nextMonthLink;

    public void clickFromField() {
        fromField.click();
    }

    public void clickToField() {
        toField.click();
    }

    public void clickDate(String date) {
        driver.findElement(By.linkText(date)).click();
    }

    public String getSelectedFromDay(){
        return fromField.getAttribute("value").substring(3,5);
    }

    public String getSelectedFromValue(){
        return fromField.getAttribute("value");
    }

    public String getSelectedToDay(){
        return toField.getAttribute("value").substring(3,5);
    }

    public String getSelectedToValue(){
        return toField.getAttribute("value");
    }

    public int getSelectedMonthValue(){
        Select monthSelect = new Select(monthDropdown);
        return Integer.parseInt(monthSelect.getFirstSelectedOption().getAttribute("value"));
    }

    public void clickNextMonth() {
        nextMonthLink.click();
    }

    public void clickPrevMonth() {
        prevMonthLink.click();
    }

}
