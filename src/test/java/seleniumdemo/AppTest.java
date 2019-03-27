package seleniumdemo;


import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * Unit test for simple App.
 *
 * @author wenjin Zhang
 *
 */
public class AppTest 
{

    @Test
    public void punchon()throws Exception
    {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://monmouth.ultipro.com/");

        driver.findElement(By.id("userNameInput")).sendKeys("s1258754@monmouth.edu");
        driver.findElement(By.id("passwordInput")).sendKeys("55627045sxx");
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(3000);

        driver.findElement(By.className("menuButtonLabel")).click();
        driver.findElement(By.className("menuTopHeaderLabel")).click();

        driver.findElementByXPath("//*[@id=\"newMegaMenuContainer\"]/div[2]/div[3]/div[1]/div[6]/h3").click();
        Thread.sleep(1000);
        //switch into iframe
        ChromeDriver driver2 = (ChromeDriver)driver.switchTo().frame(driver.findElementById("ContentFrame"));
        //driver2.findElementById("btnPunch").click();
        //driver.findElementById("btnPunch").click();
        //driver.close();

    }



}
