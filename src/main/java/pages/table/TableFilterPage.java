package pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TableFilterPage {

    WebDriver driver;
    public TableFilterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//table[contains(@class,'table-filter')]//tr")
    List<WebElement> records;

    @FindBy(xpath="//table[contains(@class,'table-filter')]//tr[not(@style='display: none;')]")
    List<WebElement> visibleRecords;

    public void clickButton(String colour) {
        driver.findElement(By.xpath("//button[contains(text(),'" + colour + "')]")).click();
    }

    public int getRecordCount() {
        return records.size();
    }

    public int getRecordColourCount(String colour) {
        return driver.findElements(By.xpath("//table[contains(@class,'table-filter')]//span[contains(text(),'" + colour + "')]")).size();
    }

    public int getVisibleRecordCount() {
        return visibleRecords.size();
    }

    public int getVisibleRecordColourCount(String colour) {
        return driver.findElements(By.xpath("//table[contains(@class,'table-filter')]//tr[not(@style='display: none;')" +
                "]//span[contains" +
                "(text(),'" + colour + "')]")).size();
    }

    public boolean verifyResults(String colour){
        System.out.println(getRecordColourCount(colour));
        System.out.println(getVisibleRecordCount());
        System.out.println(getVisibleRecordColourCount(colour));
        return getRecordColourCount(colour) == getVisibleRecordCount() && getRecordColourCount(colour) == getVisibleRecordColourCount(colour);
    }

    public boolean allRecordsDisplayed() {
        return getRecordCount() == getVisibleRecordCount();
    }

}
