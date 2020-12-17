package org.SKOVIGAMES;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MailPage
{
    private static WebDriver driver;
    @FindBy(xpath = "//div[@class='aic']")
    private static WebElement writeButton;
    @FindBy(name = "to")
    private static WebElement letterRecipient;
    @FindBy(name = "subjectbox")
    private static WebElement subjectBox;
    @FindBy(xpath = "//div[@class='Ar Au']/div")
    private static WebElement mainText;
    @FindBy(xpath = "//div[@class='J-J5-Ji btA']")
    private static WebElement sendButton;
    @FindBy(xpath = "//div[@class='TN bzz aHS-bnu']")
    private static WebElement sentLettersButton;
    @FindBy(xpath = "//div[@class='gK']/span[@class='g3']")
    private static WebElement timeElement;
    @FindBy(xpath = "//div[@class='a3s aiL ']")
    private static WebElement textElement;
    private static String timeText;
    private static String textText;
    private static WebElement lastLetter;
    private static List<WebElement> mails;
    private static WebDriverWait wait;

    protected static void goMailPage(WebDriver browser) //открытие страницы
    {
        driver = browser;
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfReader.getProperty("waitMail")), TimeUnit.SECONDS);
        PageFactory.initElements(driver, new MailPage());
        wait = new WebDriverWait(driver, Long.parseLong(ConfReader.getProperty("waitMail")));
    }

    protected static void findMails() //поиск писем
    {
        mails = driver.findElements(By.xpath("//div[@class='yW']//span[@name='" + ConfReader.getProperty("nameRecipient") + "']"));
    }

    protected static void sendMail() //отправка письма
    {
        writeButton.click();
        letterRecipient.sendKeys(ConfReader.getProperty("letterRecipient"));
        subjectBox.sendKeys("Тестовое задание. Сковиков");
        mainText.sendKeys(Integer.toString(mails.size()));
        sendButton.click();
    }

    protected static void checkMail () throws InterruptedException //проверка отправки
    {
        Thread.sleep(5000);
        sentLettersButton.click();
        lastLetter = driver.findElement(By.xpath("//div[@class='yW']/span[@email='"+ ConfReader.getProperty("letterRecipient") +"']"));
        lastLetter.click();
        timeText = timeElement.getText();
        textText = textElement.getText();
        if (!(timeText.charAt(7)=='0' && textText.charAt(0)=='2'))
            Assert.fail();
    }
}