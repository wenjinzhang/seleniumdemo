package seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    static String name ="s1258754@monmouth.edu";
    static String password ="55627045sxx";

    public static void punch() throws Exception{
        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeDriver driver= new ChromeDriver();
        driver.get("https://monmouth.ultipro.com/");
        driver.findElement(By.id("userNameInput")).sendKeys(name);
        driver.findElement(By.id("passwordInput")).sendKeys(password);
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("menuButtonLabel")).click();
        driver.findElement(By.className("menuTopHeaderLabel")).click();
        driver.findElementByXPath("//*[@id=\"newMegaMenuContainer\"]/div[2]/div[3]/div[1]/div[6]/h3").click();
        //switch into iframe
        ChromeDriver driver2 = (ChromeDriver)driver.switchTo().frame(driver.findElementById("ContentFrame"));
        driver2.findElementById("btnPunch").click();
        driver.close();

    }

    public static  void main (String args[]){
        int hours = 0;
        int minutes = 2;

        System.out.println("start working");
        try{
            punch();
        }catch (Exception e){
            System.out.println("fail punch on!");
        }


        final Timer timer = new Timer();

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, hours);
        cal.add(Calendar.MINUTE, minutes);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("start working");
                try{
                    punch();
                }catch (Exception e){
                    System.out.println("fail punch out!");
                }
                System.out.println("punch out");
                timer.cancel();
            }
        }, cal.getTime());


    }
}
