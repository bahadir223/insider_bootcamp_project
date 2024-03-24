package proje.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class CareersPage {
    public CareersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='category-title-media ml-0']")
    public WebElement ourLocations;

    @FindBy(xpath = "//*[text()='Life at Insider']")
    public WebElement lifeAtInsider;

}
