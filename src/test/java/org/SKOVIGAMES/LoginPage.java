package org.SKOVIGAMES;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

class LoginPage
{
    private static WebDriver driver;
    @FindBy(id = "identifierId")
    private static WebElement login;
    private static WebDriverWait wait;

    protected static void goLoginPage(WebDriver browser) //открытие страницы
    {
        driver = browser;
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfReader.getProperty("waitLogin")), TimeUnit.SECONDS);
        PageFactory.initElements(driver, new LoginPage());
        driver.get(ConfReader.getProperty("startPage"));
    }

    protected static void enterLogin() //ввод логина
    {
        login.sendKeys(ConfReader.getProperty("userLogin") + Keys.ENTER);
    }
}
