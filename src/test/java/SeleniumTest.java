import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    WebDriver driver;

   @Before
   public void setup()
   {
       String browser = System.getProperty("browser");

       if (browser == null)
       {
           driver = new ChromeDriver();
       }
       else if (browser.equals("chrome"))
       {
           driver = new ChromeDriver();
       }
       else if (browser.equals("firefox"))
       {
           driver = new FirefoxDriver();
       }
       else if (browser.equals("opera"))
       {
           driver = new OperaDriver();
       }

       else
       {
           driver = new ChromeDriver();
       }

       //driver = new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://www.google.com");
   }
   @After
   public void quitBrowser()
   {
       driver.quit();
   }

    @Test
    public void testENTER()throws InterruptedException {
        String expected = "French language - Wikipedia";

        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("french");
        barreRecherche.sendKeys(Keys.ENTER);

        WebElement premierResultat = driver.findElement(By.cssSelector(".rc > .r > a"));
        Assert.assertEquals(expected, premierResultat.getText());
        Thread.sleep( 1000);
    }

    //@Test
    public void testclick()throws InterruptedException {
        String expected = "République française - France — Wikipédia";


        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("france");

        WebElement buttonRecherche = driver.findElement(By.className("lsb"));
        buttonRecherche.click();
        WebElement premierResultat = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[2]/h3/a"));
        Assert.assertEquals(expected, premierResultat.getText());
        Thread.sleep( 1000);
    }


}


