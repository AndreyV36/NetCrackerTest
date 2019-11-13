import org.openqa.selenium.chrome.ChromeDriver;

public class OpenUrlStep extends Description implements Step {
    private String path;
    public OpenUrlStep(String param){
        this.path = param;
    }
    public void exec(ChromeDriver driver){
        System.out.println(getDescription() + " : " + path);
        driver.get(path);
    }
}