import org.openqa.selenium.chrome.ChromeDriver;

public class ClickStep extends Description implements Step  {
    private String path;
    public ClickStep(String param){
        this.path = param;
    }
    public void exec(ChromeDriver driver){
        System.out.println(getDescription() + " : " + path);
        driver.findElementByXPath(path).click();
    }
}
