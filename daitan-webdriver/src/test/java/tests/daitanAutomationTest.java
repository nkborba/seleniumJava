package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class daitanAutomationTest {
    private WebDriver browser;
    private Actions action;

    @Before
    public void acessarPaginaDaitan(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nicholas\\drivers\\chromedriver.exe");
        browser = new ChromeDriver();
        action = new Actions(browser);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://www.daitangroup.com/");
    }

    @Test
    public void acessarWhyDaitan(){
        browser.findElement(By.linkText("Why Daitan")).click();
    }

    @Test
    public void acessarCareersDaitan(){
        //Efetuar ação de hover no botão About Us
        action.moveToElement(browser.findElement(By.linkText("About Us"))).perform();

        //Clicar no link de texto Careers
        browser.findElement(By.linkText("Careers")).click();

    }

    @Test
    public void visualizarBeneficios(){
        acessarCareersDaitan();
        //Utilizando REGEX para descer a página até o link de texto "Join the Team"
        action.moveToElement(browser.findElement(By.xpath("//a[text()=\"Join the Team\"]"))).perform();
    }

    @Before
    public void fechaSite(){
        //browser.close();
    }
}
