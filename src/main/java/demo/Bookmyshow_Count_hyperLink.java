package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookmyshow_Count_hyperLink {
     ChromeDriver driver;
    public Bookmyshow_Count_hyperLink()
    {
        System.out.println("Constructor: Bookmyshow_Count_hyperLink");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        driver.manage().deleteAllCookies();
        List<WebElement> count_of_Hyperlink = driver.findElements(By.tagName("a"));
        System.out.println("Count of Hyperlinks" +count_of_Hyperlink.size() );
        System.out.println("end Test case: testCase02");
    }


}


