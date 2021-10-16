package pages.inputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class JQuerySelectDropdownPage {

    WebDriver driver;
    public JQuerySelectDropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="country")
    WebElement countryDropdown;

    @FindBy(xpath="//span[@aria-labelledby='select2-country-container']")
    WebElement countryDropdownField;

    @FindBy(xpath="//select[contains(@class,'js-example-basic-multiple')]")
    WebElement stateDropdown;

    @FindBy(xpath="//span[contains(@class,'select2-selection--multiple')]")
    WebElement stateDropdownField;

    @FindBy(xpath="//span[contains(@class,'select2-selection__choice__remove')]")
    WebElement removeSelectedStateIcon;

    @FindBy(xpath="//select[contains(@class,'js-example-disabled-results')]")
    WebElement territoryDropdown;

    @FindBy(id="files")
    WebElement fileDropdown;


    public void selectCountry(String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    public void clickCountryDropdownField() {
        countryDropdownField.click();
    }

    public String getCountrySelection() {
        Select select = new Select(countryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public void selectState(String state) {
        Select select = new Select(stateDropdown);
        select.selectByVisibleText(state);
    }

    public void clickStateDropdownField() {
        stateDropdownField.click();
    }

    public String getStateSelection() {
        Select select = new Select(stateDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public int getNoOfStatesSelected() {
        Select select = new Select(stateDropdown);
        return select.getAllSelectedOptions().size();
    }

    public void selectTerritory(String file) {
        Select select = new Select(territoryDropdown);
        select.selectByVisibleText(file);
    }

    public String getTerritorySelection() {
        Select select = new Select(territoryDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public void selectFile(String file) {
        Select select = new Select(fileDropdown);
        select.selectByVisibleText(file);
    }

    public String getFileSelection() {
        Select select = new Select(fileDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public void removeSelectedState() {
        removeSelectedStateIcon.click();
    }

}
