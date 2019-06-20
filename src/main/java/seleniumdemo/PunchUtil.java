package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PunchUtil {
    private static void punch(String name, String password) throws Exception{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://monmouth.ultipro.com/");
        driver.findElement(By.id("userNameInput")).sendKeys(name);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("menuButtonLabel")).click();
        driver.findElement(By.className("menuTopHeaderLabel")).click();
        ////*[@id="newMegaMenuContainer"]/div[2]/div[3]/div[1]/div[7]/h3
        driver.findElementByXPath("//*[@id=\"newMegaMenuContainer\"]/div[2]/div[3]/div[1]/div[7]/h3").click();
        //switch into iframe
        ChromeDriver driver2 = (ChromeDriver)driver.switchTo().frame(driver.findElementById("ContentFrame"));
        driver2.findElementById("btnPunch").click();
        driver.close();
    }

    public static boolean workOneTime(final TimeRecord timeRecord){
        System.out.println("start working for "+timeRecord.hours+" hours, "+ timeRecord.minutes+ " minutes");
        try{
            punch(timeRecord.name, timeRecord.password);
        }catch (Exception e){
            System.out.println("fail punch on!");
        }

        final Timer timer = new Timer();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, timeRecord.hours);
        cal.add(Calendar.MINUTE, timeRecord.minutes);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try{
                    punch(timeRecord.name, timeRecord.password);
                }catch (Exception e){
                    System.out.println("fail punch out!");
                }
                System.out.println("punch out");
                timer.cancel();
            }
        }, cal.getTime());
       return true;
    }

}
