import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotStep extends Description implements Step {
    public void exec(ChromeDriver driver){
        System.out.println(getDescription());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        Date date = new Date();
        try {
            TakesScreenshot ts = driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "images/screen_" + dateFormat.format(date) + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
