import org.openqa.selenium.chrome.ChromeDriver;

public class SetValueStep extends Description implements Step {
    private String path;
    private String value;
    public SetValueStep(String param){
        String[] parts = param.split("\\|");
        path = parts[0];
        value = parts[1];
    }
    public void exec(ChromeDriver driver){
        System.out.println(getDescription() + " : " + path + " | " + value);
        driver.findElementByXPath(path).sendKeys(value);
    }
}
