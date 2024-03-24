package proje.tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import proje.pages.CareersPage;
import proje.pages.HomePage;
import proje.pages.OpenPositionsForQAPage;
import proje.pages.QualityAssurancePage;
import proje.utilities.ConfigReader;
import proje.utilities.Driver;
import proje.utilities.ReusableMethods;
import proje.utilities.TestListener;

@Listeners(TestListener.class)
public class C01 {
    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qaPage = new QualityAssurancePage();
    OpenPositionsForQAPage openPositions = new OpenPositionsForQAPage();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {
        //Go to the https://useinsider.com/
        Driver.getDriver().get(ConfigReader.getProperty("insiderUrl"));
        //Check Insider home page is opened or no
        ReusableMethods.visibleWait(homePage.insiderUnlocksText, 10);
        softAssert.assertTrue(homePage.insiderUnlocksText.isDisplayed());
        //Select the “Company” menu in the navigation bar,select “Careers”
        ReusableMethods.click(homePage.ddmCompany);
        ReusableMethods.bekle(1);
        ReusableMethods.click(homePage.careers);
        //Check Career page, its Locations, Teams, and Life at Insider blocks are open or no
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), ConfigReader.getProperty("careersUrl"));
        ReusableMethods.scroll(careersPage.ourLocations);
        softAssert.assertTrue(careersPage.ourLocations.isDisplayed());
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(careersPage.lifeAtInsider);
        softAssert.assertTrue(careersPage.lifeAtInsider.isDisplayed());
        //Go to the https://useinsider.com/careers/quality-assurance ,  click “See all QA jobs”
        Driver.getDriver().get(ConfigReader.getProperty("qualityAssuranceUrl"));
        ReusableMethods.click(qaPage.seeAllQaJobs);
        // Filter jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”, check the presence of the job list
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(10);  //dropdown menüdeki değerler geç gelebiliyor. Bu yüzden 10 saniye bekleme koydum.
        ReusableMethods.click(openPositions.ddmLocation);
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.CONTROL).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(1);
        ReusableMethods.scroll(openPositions.browseOpenPositions);
        ReusableMethods.bekle(2);
        //Check that all jobs’ Position contains “Quality Assurance”,
        for (int i = 0; i < OpenPositionsForQAPage.positionList.size(); i++) {
            softAssert.assertTrue(OpenPositionsForQAPage.positionList.get(i).getText().contains("Quality Assurance") ||
                    OpenPositionsForQAPage.positionList.get(i).getText().contains("QA"));
        }
        ReusableMethods.bekle(2);

        //Check Department contains “Quality Assurance”
        for (int i = 0; i < OpenPositionsForQAPage.departmentList.size(); i++) {
            softAssert.assertTrue(OpenPositionsForQAPage.departmentList.get(i).getText().contains(ConfigReader.getProperty("department")));
        }
        ReusableMethods.bekle(2);

        for (int i = 0; i < OpenPositionsForQAPage.locationList.size(); i++) {
            softAssert.assertTrue(OpenPositionsForQAPage.locationList.get(i).getText().contains(ConfigReader.getProperty("location")));
        }

        //Click the “View Role” button and check that this action redirects us to the Lever Application form page
        actions.moveToElement(openPositions.viewRoleButton).perform();
        ReusableMethods.bekle(1);
        ReusableMethods.click(openPositions.viewRoleButton);

        ReusableMethods.window(1);  //yeni sekmeye geçildi.
        ReusableMethods.visibleWait(openPositions.applyForThisJob, 9);
        softAssert.assertTrue(openPositions.applyForThisJob.isDisplayed());
        softAssert.assertAll();
    }

}
