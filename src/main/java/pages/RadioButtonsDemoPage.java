package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonsDemoPage {

    WebDriver driver;
    public RadioButtonsDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="buttoncheck")
    WebElement getCheckedValueButton;

    @FindBy(className="radiobutton")
    WebElement singleRadioText;

    @FindBy(xpath="//button[contains(text(),'Get values')]")
    WebElement getValuesButton;

    @FindBy(className="groupradiobutton")
    WebElement groupRadioText;

    public void selectSingleRadioOption(String option) {
        driver.findElement(By.xpath("//input[@value='"+option+"' and @name='optradio']")).click();
    }

    public void clickCheckedValueButton() {
        getCheckedValueButton.click();
    }

    public String getSingleRadioText() {
        return singleRadioText.getText();
    }

    public void selectGenderMultiRadioOption(String option) {
        driver.findElement(By.xpath("//input[@value='"+option+"' and @name='gender']")).click();
    }

    public void selectAgeMultiRadioOption(String option) {
        driver.findElement(By.xpath("//input[@value='"+option+"' and @name='ageGroup']")).click();
    }

    public void clickGetValuesButton() {
        getValuesButton.click();
    }

    public String getGroupRadioText() {
        return groupRadioText.getText();
    }
}