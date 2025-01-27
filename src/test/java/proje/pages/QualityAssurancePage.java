package proje.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class QualityAssurancePage {
    public QualityAssurancePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='See all QA jobs']")
    public WebElement seeAllQaJobs;


}
