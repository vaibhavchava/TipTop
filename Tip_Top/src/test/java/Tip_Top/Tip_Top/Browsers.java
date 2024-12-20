package Tip_Top.Tip_Top;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers extends Test_Base {
	
	public static void init(String browserType){
	
		switch(browserType.toLowerCase()) {
		case "chrome":
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
             driver = new ChromeDriver(options);
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--incognito");
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        break;
		case "edge":
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeoptions = new EdgeOptions();
            edgeoptions.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver(edgeoptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));     
            break;
            
		case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));          
            break;
		}
            
    }

    public static void navigateTo(String url) throws InterruptedException
    {
        driver.navigate().to(url);
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    public static void tearDown(){
        driver.close();
    }


}
