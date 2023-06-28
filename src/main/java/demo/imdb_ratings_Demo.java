package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class imdb_ratings_Demo {
   ChromeDriver driver;
    public imdb_ratings_Demo()
    {
        System.out.println("Constructor: imdb_ratings_Demo");
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
        driver.get("https://www.imdb.com/chart/top");
        List<WebElement>highestratedMovies = driver.findElements(By.xpath("//strong[text()='9.2']//parent::td//preceding-sibling::td[1]//a"));
        List<WebElement>moviescount=driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
        List<WebElement>oldestMovies=driver.findElements(By.xpath("//span[text()='(1921)']/preceding-sibling::a"));
        List<WebElement>recentMovies=driver.findElements(By.xpath("//span[text()='(2023)']/preceding-sibling::a"));
        
        System.out.println("What is the oldest movie on the list?"+oldestMovies.size());
        System.out.println(moviescount.size());
        for(int i=0;i<highestratedMovies.size();i++)
        
        {
            System.out.println(highestratedMovies.get(i).getText());
            
        }
         
        for(int i=0;i<oldestMovies.size();i++)
        {
           System.out.println(oldestMovies.get(i).getText()); 
        }
        for(int i=0;i<recentMovies.size();i++)
        {
           System.out.println(recentMovies.get(i).getText()); 
        }

        System.out.println("end Test case: testCase02");
    }


}


