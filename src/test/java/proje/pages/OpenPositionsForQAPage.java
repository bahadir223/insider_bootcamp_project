package proje.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;
import java.util.List;

public class OpenPositionsForQAPage {

    public OpenPositionsForQAPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    public WebElement ddmLocation;

    @FindBy(xpath = "(//h3)[2]")
    public WebElement browseOpenPositions;

    @FindBy(css = "[class='position-title font-weight-bold']")
    public static List<WebElement> positionList;
    @FindBy(xpath = "(//*[text()='Quality Assurance'])[position()>2]")
    public static List<WebElement> departmentList;
    @FindBy(xpath = "(//*[text()='Istanbul, Turkey'])[position()>2]")
    public static List<WebElement> locationList;

    @FindBy(xpath = "//*[@href='https://jobs.lever.co/useinsider/6013cc18-8219-4587-a78c-9325c137b436']")
    public WebElement viewRoleButton;

    @FindBy(xpath = "(//*[text()='Apply for this job'])[1]")
    public WebElement applyForThisJob;

}




