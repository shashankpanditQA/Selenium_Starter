package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkdenProfile {
  
        ChromeDriver driver;

        public  LinkdenProfile()
        {
            System.out.println("Constructor: LinkdenProfile");
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
            driver.get("https://in.linkedin.com/");
            WebElement emailElement=driver.findElement(By.xpath("//input[@id='session_key']"));
            emailElement.sendKeys("shashank.pandit4@gmail.com");
            WebElement passwordElement=driver.findElement(By.xpath("//input[@id='session_password']"));
            passwordElement.sendKeys("Kartik@1234."); 
            WebElement signinButton= driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
            signinButton.click();
            WebElement Whosviewedyourprofile =driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[1]//strong"));
            WebElement Impressionsofyourpost = driver.findElement(By.xpath("(//span[@class='feed-identity-widget-item__stat'])[2]//strong"));
            WebElement start_Post = driver.findElement(By.xpath("//span[text()='Start a post']"));
            start_Post.click();
            WebElement Select_post_setting_dropdown =driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']"));
            Select_post_setting_dropdown.click();
            WebElement select_sharing_with_Connections_only=driver.findElement(By.xpath("//span[@class='sharing-shared-generic-list__description-double-line']"));
            select_sharing_with_Connections_only.click();
            WebElement clcikOnDone=driver.findElement(By.xpath("//span[text()='Done']"));
            clcikOnDone.click();
            WebElement Create_Post = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
            Create_Post.sendKeys("hi!, this is shashank");
            WebElement Post_Button= driver.findElement(By.xpath("//span[text()='Post']"));
            Post_Button.click();
            System.out.println("count of Who's viewed your profile" +Whosviewedyourprofile.getText());
             System.out.println("count Impressions of your post" +Impressionsofyourpost.getText());
            System.out.println("end Test case: testCase02");
        }
    
    
    }
    

