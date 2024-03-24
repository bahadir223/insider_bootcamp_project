package proje.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import proje.tests.C01;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//ITestListener ; Testlerin başlangıcını ve bitişini, başarı veya başarısızlık durumlarını dinler.
public class TestListener extends C01 implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        // Test başladığında yapılacak işlemler
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        TakesScreenshot screenshot = (TakesScreenshot) Driver.driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            FileUtils.copyFile(file, new File("./screenshots/" + "success" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        TakesScreenshot screenshot = (TakesScreenshot) Driver.driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            FileUtils.copyFile(file, new File("./screenshots/" + "failed" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // Test atlandığında yapılacak işlemler
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // Başarılı bir yüzde içinde başarısız olan bir test olduğunda yapılacak işlemler
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // TestNG test döngüsü başladığında yapılacak işlemler
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // TestNG test döngüsü bittiğinde yapılacak işlemler
    }
}
