package pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TableDataSearchPage {

    WebDriver driver;
    public TableDataSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="task-table-filter")
    WebElement taskSearch;

    @FindBy(xpath="//input[@placeholder='#']")
    WebElement idField;

    @FindBy(xpath="//input[@placeholder='Username']")
    WebElement usernameField;

    @FindBy(xpath="//input[@placeholder='First Name']")
    WebElement firstNameField;

    @FindBy(xpath="//input[@placeholder='Last Name']")
    WebElement lastNameField;

    @FindBy(xpath="//button[contains(@class,'btn-filter')]")
    WebElement filterButton;

    public boolean areAnyFiltersEnabled(){
        return idField.isEnabled() || usernameField.isEnabled() || firstNameField.isEnabled() || lastNameField.isEnabled();
    }

    public boolean areAllFiltersEnabled(){
        return idField.isEnabled() && usernameField.isEnabled() && firstNameField.isEnabled() && lastNameField.isEnabled();
    }

    public void inputTaskSearch(String search) {
        taskSearch.sendKeys(search);
    }

    public List<String> getTaskColumnValues(int column){
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']//tr/td[" + column + "]"));
        List values = new ArrayList();
        for (int i = 0; i<rows.size(); i++){
            values.add(rows.get(i).getText());
        }
        return values;
    }

    public boolean isValueReturned(int column, String value){
        List<String> values = getTaskColumnValues(column);
        int validResults = 0;
        for (int i=0;i<values.size();i++){
            String something = values.get(i);
            if(values.get(i).equals(value)){
                validResults++;
            };
        }
        return validResults>0;
    }

    public boolean verifySearchResults(String text) {
        String value = text.toLowerCase();
        List<String> taskRowIds = new ArrayList<>();
        List<WebElement> taskRows = driver.findElements(By.xpath("//table[@id='task-table']//tr[not(@style)]"));
        int noTaskRows = taskRows.size();
        for (int i=1;i<=noTaskRows-1;i++) {
            String id =
                    driver.findElement(By.xpath("//table[@id='task-table']//tr[not(@style)][" + i + "]/td[1]")).getText();
            taskRowIds.add(id);
        }
        int validResults = 0;
        for (String row: taskRowIds) {
            for (int column = 1; column <= 4; column++) {
                String rowValue = driver.findElement(By.xpath("//table[@id='task-table']//tr[" + row +
                        "]/td["+ column +"]")).getText();
                if (rowValue.toLowerCase().contains(value)) {
                    validResults++;
                    break;
                }
            }
        }
        return validResults == noTaskRows-1;
    }

    public void clickFilterButton(){
        filterButton.click();
    }

    public void inputUserID(String id){
        idField.sendKeys(id);
    }

    public void inputUsername(String username){
        usernameField.sendKeys(username);
    }

    public void inputFirstName(String name){
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String name){
        lastNameField.sendKeys(name);
    }

    public boolean verifyUserSearchResults(int column, String text) {
        String value = text.toLowerCase();
        List<String> taskRowIds = new ArrayList<>();
        List<WebElement> taskRows = driver.findElements(By.xpath("//table[@class='table']//tr[not(@style)]"));
        int noTaskRows = taskRows.size();
        int validResults = 0;
        for (int i=1;i<=noTaskRows-1;i++) {
            String rowValue =
                    driver.findElement(By.xpath("//table[@class='table']//tr[not(@style)][" + i + "]/td[" + column +
                            "]")).getText();
            if(rowValue.toLowerCase().contains(text)){
                validResults++;
            };
        }
        return validResults == noTaskRows-1;
    }

}
