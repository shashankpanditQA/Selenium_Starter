package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrame {

    ChromeDriver driver;

    public HandlingFrame() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        // Go to https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Go to https://the-internet.herokuapp.com/nested_frames
        // Switch to Top Frame Using Locator "Name" frame-top
        driver.switchTo().frame("frame-top");
        // Switch to Left Frame Using Locator "Name" frame-left.getText();
        driver.switchTo().frame("frame-left");
        WebElement lefttext = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println("Read a text for left Frame :" + lefttext.getText());
        Thread.sleep(2000);
        // Switch back to Top Frame Using Locator "Name" frame-top
        driver.switchTo().parentFrame();
        // Switch to Middle Frame Using Locator "Name";
         driver.switchTo().frame("frame-middle");
        // Switch to Left Frame Using Locator "Name" frame-Middle.getText();
        WebElement middletext = driver.findElement(By.xpath("//body/div[text()='MIDDLE']"));
        System.out.println("Read a text for Middle Frame" + middletext.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement righttext = driver.findElement(By.xpath("//body[contains(text(),' RIGHT')]"));
        System.out.println("Read a text for Right Frame"+ righttext.getText());
        driver.switchTo().defaultContent();
        // Switch back to Top Frame Using Locator "Name" frame-bottom
        driver.switchTo().frame("frame-bottom");
        // Switch back to Bottom Frame Using Locator "Name" frame-bottom.getText()
        WebElement bottomtext = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println("Read a text for Bottom Frame" + bottomtext.getText());
        System.out.println("end Test case: testCase02");
    }

}
