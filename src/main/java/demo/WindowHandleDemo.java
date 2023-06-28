package demo;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleDemo {
     ChromeDriver driver;
    public WindowHandleDemo()
    {
        System.out.println("Constructor: WindowHandle");
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
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        String ParentWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        WebElement tryButton = driver.findElement(By.xpath("//button[text()='Try it']"));
        tryButton.click();
        Iterator<String> itr = set.iterator();
        while(itr.hasNext())
        {
            String childwindow = itr.next();

            if(!ParentWindow.equals(childwindow))
            {
                driver.switchTo().window(childwindow);
                System.out.println(driver.switchTo().window(childwindow).getTitle());

                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
                String Path = System.getProperty("user.Dir")+"src\\Screenshots"+System.currentTimeMillis()+".PNG";
                File desFile = new File(Path);
                try {
                    FileUtils.copyFile(scrFile,desFile);
                } catch (IOException e) {
                   
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }

            driver.switchTo().window(ParentWindow);
        }
        System.out.println("end Test case: testCase02");
    }
}




