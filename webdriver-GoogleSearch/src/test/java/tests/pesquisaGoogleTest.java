package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class pesquisaGoogleTest {
    private WebDriver browser;


    @Before
    public void acessarGoogle(){
        System.setProperty("webdriver.chrome.driver","/home/vntnibo/drivers/chromedriver");
        browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.manage().window().maximize();
        browser.get("http://www.google.com");
    }

    @Test
    public void fazerPesquisa(){
        browser.findElement(By.id("lst-ib")).sendKeys("Daitan Group");
        browser.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
    }

    @After
    public void fecharBrowser(){
        browser.close();
    }
}
