// import java.util.concurrent.TimeUnit;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class Linkden {
//     ChromeDriver driver;
//     public Linkden()
//     {
//         System.out.println("Constructor: Linkden");
//         WebDriverManager.chromedriver().timeout(30).setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//     }

//     public void endTest()
//     {
//         System.out.println("End Test: TestCases");
//         driver.close();
//         driver.quit();

//     }

    
//     public  void testCase01(){
//         System.out.println("Start Test case: testCase01");
//         driver.get("https://www.linkedin.com/");
//         WebElement emailElement=driver.findElement(By.xpath("//input[@id='session_key']"));
//         emailElement.sendKeys("");
//         WebElement passwordElement=driver.findElement(By.xpath("//input[@id='session_password']"));
//         passwordElement.sendKeys("");
//         WebElement signinButton= driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
//         signinButton.click();
//         WebElement photoIcon=driver.findElement(By.xpath("//span[text()='Photo']"));
//         photoIcon.click();
//         WebElement selectimage=driver.findElement(By.xpath("//label[text()='Select images to share']"));
//         selectimage.click();
//         System.out.println("end Test case: testCase02");
//     }


// }


