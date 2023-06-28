package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookmyShowurl {
    ChromeDriver driver;
    public BookmyShowurl()
    {
        System.out.println("Constructor: TestCases");
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

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get(" https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement>print_URL_RecommendedMovies=driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../..//../..//img[starts-with(@src,'https://assets-in.bmscdn.com/discovery-catalog/events')]"));
         System.out.println("printURLRecommendedMovies"+print_URL_RecommendedMovies.size());
        for(int i=0;i<print_URL_RecommendedMovies.size();i++)
        {
            System.out.println("print URL for RecommendedMovies"+print_URL_RecommendedMovies.get(i).getAttribute("src"));
        }

        

        Thread.sleep(20000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement printMoviename = driver.findElement(By.xpath("(//h2[text()='Premieres']/../../../../../..//a[@class='sc-133848s-11 sc-lnhrs7-5 bgiQIj'])[2]//div[contains(@class,'fyTNyu')]"));
        System.out.println("Print the movie name of 2nd item in the Premiere list" + printMoviename.getText());
     WebElement language = driver.findElement(By.xpath("(//h2[text()='Premieres']/../../../../../..//a[@class='sc-133848s-11 sc-lnhrs7-5 bgiQIj'])[2]//div[contains(@class,'fyTNyu')]/../..//div[contains(@class,'eeVqLW')]"));
         System.out.println("Print the movie langauge of 2nd item in the Premiere list" + language.getText());
     System.out.println("end Test case: testCase02");
    }

}
