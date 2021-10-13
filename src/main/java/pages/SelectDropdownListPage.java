package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.List;

public class SelectDropdownListPage {

    WebDriver driver;

    public SelectDropdownListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "select-demo")
    WebElement dropdownList;

    @FindBy(xpath = "//select[@id='select-demo']/option")
    List<WebElement> dropdownOptions;

    @FindBy(className = "selected-value")
    WebElement selectedValue;

    @FindBy(id = "multi-select")
    WebElement multiSelect;

    @FindBy(xpath = "//select[@id='multi-select']/option")
    List<WebElement> multiOptions;

    @FindBy(className = "getall-selected")
    WebElement allSelectedText;

    @FindBy(id="printMe")
    WebElement firstSelectedButton;

    @FindBy(id="printAll")
    WebElement getAllSelectedButton;

    public void selectDropDownOptionByID(int num) {
        Select dayDropdown = new Select(dropdownList);
        dayDropdown.selectByIndex(num);
    }

    public int getNumberOfOptions() {
        return dropdownOptions.size();
    }

    public String getSelectedOptionText() {
        Select dayDropdown = new Select(dropdownList);
        return dayDropdown.getFirstSelectedOption().getText();
    }

///////////////////////////////

    public void selectMultiOptionByValue(String value) {
        Select dayDropdown = new Select(multiSelect);
        dayDropdown.selectByValue(value);
    }

    public void unselectMultiOptionByValue(String value) {
        Select dayDropdown = new Select(multiSelect);
        dayDropdown.deselectByValue(value);
    }

    public int getNumberOfMultiOptions() {
        return multiOptions.size();
    }

    public List<String> getListOfValues() {
        List<String> valueList = new java.util.ArrayList<>(Collections.emptyList());
        for (WebElement x : multiOptions){
            valueList.add(x.getAttribute("value"));
        }
        return valueList;
    }

    public WebElement getMultiOptionByValue(String value){
        WebElement option = null;
        for (WebElement x : multiOptions){
            if(x.getAttribute("value").equals(value)){
                option = x;
                break;
            };
        }
        return option;
    }

    public void clickMultiOptionByValue(String value){
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).click(getMultiOptionByValue(value)).keyUp(Keys.CONTROL).build().perform();
    }


    public String getFirstSelectedOptionsValue() {
        Select dayDropdown = new Select(multiSelect);
        return dayDropdown.getFirstSelectedOption().getAttribute("value");
    }


    public List<WebElement> getAllSelectedOptions() {
        Select dayDropdown = new Select(multiSelect);
        return dayDropdown.getAllSelectedOptions();
    }

    public void clickFirstSelectedButton() {
        firstSelectedButton.click();
    }

    public void clickGetAllSelectedButton() {
        getAllSelectedButton.click();
    }

    public String getAllSelectedText() {
        return allSelectedText.getText();
    }


}


