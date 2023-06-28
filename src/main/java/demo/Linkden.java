package demo;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;


public class Linkden {
    ChromeDriver driver;
    public Linkden()
    {
        System.out.println("Constructor: Linkden");
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
        driver.get("https://www.linkedin.com/");
        WebElement emailElement=driver.findElement(By.xpath("//input[@id='session_key']"));
        emailElement.sendKeys("shashank.pandit4@gmail.com");
        WebElement passwordElement=driver.findElement(By.xpath("//input[@id='session_password']"));
        passwordElement.sendKeys("Kartik@1234.");
        WebElement signinButton= driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
        signinButton.click();
        WebElement photoIcon=driver.findElement(By.xpath("//span[text()='Photo']"));
        photoIcon.click();
        // Thread.sleep(2000);
          WebElement selectimage=driver.findElement(By.xpath("//label[text()='Select images to share']"));
          selectimage.sendKeys("C:\\Users\\Shashank Pandit\\Pictures\\FWMY7097.JPG");
        // Thread.sleep(2000);
        // StringSelection strSelection = new StringSelection("C:\\Users\\Shashank Pandit\\Pictures\\FWMY7097.JPG");
        // Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // clipboard.setContents(strSelection, null);
 
        // Robot robot = new Robot();
  
        // robot.delay(300);
        // robot.keyPress(KeyEvent.VK_ENTER);
        // robot.keyRelease(KeyEvent.VK_ENTER);
        // robot.keyPress(KeyEvent.VK_CONTROL);
        // robot.keyPress(KeyEvent.VK_V);
        // robot.keyRelease(KeyEvent.VK_V);
        // robot.keyRelease(KeyEvent.VK_CONTROL);
        // robot.keyPress(KeyEvent.VK_ENTER);
        // robot.delay(200);
        // robot.keyRelease(KeyEvent.VK_ENTER);
        WebElement clickonDoneButton= driver.findElement(By.xpath("//span[text()='Done']"));
        clickonDoneButton.click();
        WebElement post = driver.findElement(By.xpath("//span[text()='Post']"));
        post.click();
        System.out.println("end Test case: testCase02");
    }
}


