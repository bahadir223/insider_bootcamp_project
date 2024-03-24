package proje.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//b)[1]")
    public WebElement insiderUnlocksText;

    @FindBy(xpath = "(//li/a)[6]")
    public WebElement ddmCompany;

    @FindBy(xpath = "//*[@href='https://useinsider.com/careers/']")
    public WebElement careers;




}
