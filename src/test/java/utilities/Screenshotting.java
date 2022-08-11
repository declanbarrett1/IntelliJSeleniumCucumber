package utilities;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshotting {
    public static void takeScreenshot(WebDriver driver, String fileName){
        try {
            TakesScreenshot screenshot = ((TakesScreenshot)driver);
            File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("Screenshots/"+fileName);

            Files.copy(screenshotFile, DestFile);
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}
