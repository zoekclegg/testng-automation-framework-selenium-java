package pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TablePaginationPage {

    WebDriver driver;
    public TablePaginationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//li[@class='active']/a")
    WebElement activePage;

    @FindBy(xpath="//tr[@style='display: table-row;']/td")
    WebElement firstRowID;

    @FindBy(xpath="//tr[@style='display: table-row;'][last()]/td")
    WebElement lastRowID;

    @FindBy(linkText="»")
    WebElement nextPageLink;

    @FindBy(linkText="«")
    WebElement previousPageLink;

    public void clickPageNumber(String page) {
        driver.findElement(By.linkText(page)).click();
    }

    public int getActivePage() {
        return Integer.parseInt(activePage.getText());
    }

    public int getFirstRowID() {
        return Integer.parseInt(firstRowID.getText());
    }

    public int getLastRowID() {
        return Integer.parseInt(lastRowID.getText());
    }

    public void clickNextPage() {
        nextPageLink.click();
    }

    public void clickPreviousPage() {
        previousPageLink.click();
    }


}
