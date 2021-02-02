package com.inetbanking.TestCases;

import com.inetbanking.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {
        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        lp.setUserNames(username);
        lp.setTxtPassword(password);
        lp.setBtnLogin();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue(false);
        }
    }

}
