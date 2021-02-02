package com.inetbanking.TestCases;


import com.inetbanking.com.inetbanking.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class BaseClass {

    ReadConfig readConfig = new ReadConfig();


    public String baseURL=readConfig.getApplicationURL();
    public String username=readConfig.getusername();
    public  String password=readConfig.getpassword();
    public WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br)
    {
        if(br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getgeckopath());
            driver = new FirefoxDriver();
        }
        else if (br.equals("ie"))
        {
            System.setProperty("webdriver.ie.driver",readConfig.getiepath());
            driver = new InternetExplorerDriver();
        }
    }

    public void tearDown()
    {
        driver.quit();
    }
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomestring()
    {
        String generatedstring=RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }


}
