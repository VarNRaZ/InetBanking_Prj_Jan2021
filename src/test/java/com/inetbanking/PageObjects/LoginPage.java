package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class LoginPage {

    WebDriver Idriver;

   public LoginPage(WebDriver rdriver)
    {
        Idriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(name="uid")
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    WebElement btnLogin;

    public void setUserNames(String uname) {

        txtUserName.sendKeys(uname);
    }

    public void setTxtPassword(String pwd) {

        txtPassword.sendKeys(pwd);
    }

    public void setBtnLogin() {

        btnLogin.click();
    }
}
