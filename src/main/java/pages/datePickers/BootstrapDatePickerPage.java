package pages.datePickers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BootstrapDatePickerPage {



    WebDriver driver;
    public BootstrapDatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
    WebElement dateField;

    @FindBy(className="datepicker-days")
    WebElement datePicker;

    @FindBy(xpath="//div[@class='datepicker-days']//td[7]")
    WebElement sundayDate;

    @FindBy(xpath="//th[contains(text(),'Today')]")
    WebElement todayButton;

    @FindBy(xpath="//th[contains(text(),'Clear')]")
    WebElement clearButton;

    public void clickDateField() {
        dateField.click();
    }

    public WebElement getCalendarDay(int day) {
        return driver.findElement(By.xpath("//td[contains(@class,'day') and contains(.,"+day+")]"));
    }

    public void clickCalendarDay(int day) {
        getCalendarDay(day).click();
    }

    public void clickSunday() {
        sundayDate.click();
    }

    public boolean isDatePickerVisible(){
        return datePicker.isDisplayed();
    }

    public void clickTodayButton(){
        todayButton.click();
    }

    public void clickClearButton(){
        clearButton.click();
    }

}