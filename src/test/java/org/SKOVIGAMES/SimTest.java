package org.SKOVIGAMES;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SimTest
{
    private static WebDriver driver;

    @Before
    public void beforeTest () throws IOException //подготовка браузера
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(ConfReader.getPropertyUrl("remoteDriver"), chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void mainTest () throws InterruptedException //отправка письма
    {
        LoginPage.goLoginPage(driver);
        LoginPage.enterLogin();
        PasswordPage.goPasswordPage(driver);
        PasswordPage.enterPassword();
        MailPage.goMailPage(driver);
        MailPage.findMails();
        MailPage.sendMail();
        MailPage.checkMail();
    }

    @After
    public void afterTest () //завершение работы
    {
        driver.close();
    }
}
