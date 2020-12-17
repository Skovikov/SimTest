package org.SKOVIGAMES;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

class PasswordPage
{
    private static WebDriver driver;
    @FindBy(name = "password")
    private static WebElement password;

    protected static void goPasswordPage(WebDriver browser) //открытие страницы
    {
        driver = browser;
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfReader.getProperty("waitPassword")), TimeUnit.SECONDS);
        PageFactory.initElements(driver, new PasswordPage());
    }

    protected static void enterPassword() //ввод пароля
    {
        password.sendKeys(ConfReader.getProperty("userPassword") + Keys.ENTER);
    }
}