package pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableSortAndSearchPage {

    WebDriver driver;
    public TableSortAndSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//li[@class='active']/a")
    WebElement activePage;



    public void clickPageNumber(String page) {
        driver.findElement(By.linkText(page)).click();
    }



}
