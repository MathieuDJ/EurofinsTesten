package be.codekata.tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class gvaSearch {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mathi\\Downloads\\chromedriver_win32\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://www.gva.be/");


        WebElement cookiesPopup = driver.findElement(By.id("didomi-notice-agree-button"));
        if (cookiesPopup.isDisplayed()) {
            cookiesPopup.click();
        }


        driver.findElement(By.xpath("//*[@id=\"znBcNVHzi\"]/div[1]/header/div[1]/nav/ul[1]/li[3]/a/div")).click();


        Thread.sleep(2000);


        assertEquals(true, driver.getCurrentUrl().contains("/sport"));


        WebElement firstArticleTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/main/div/div[2]/div/div/div[1]/div/div/div/a/div/div/div/h1"));
        String title = firstArticleTitle.getText();
        System.out.println("Title of first article: " + title);


        assertEquals("KVM-coach Defour rekent zich nog niet rijk tegen Zulte Waregem: “Maar wel logisch dat we aan de bekerfinale denken", title);

        driver.quit();
    }
}

