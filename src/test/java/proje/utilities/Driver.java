package proje.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;

    private Driver(){
    }
    public static WebDriver getDriver(){

        String istenenBrowser = ConfigReader.getProperty("browser");
        // chrome, firefox, safari, edge

        if(driver == null){

            switch (istenenBrowser){
                case "firefox" :
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    driver= new SafariDriver();
                    break;
                case "edge" :
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }

}