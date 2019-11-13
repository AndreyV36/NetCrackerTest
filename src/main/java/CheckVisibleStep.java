import org.openqa.selenium.chrome.ChromeDriver;

public class CheckVisibleStep extends Description implements Step {
    private String path;
    public CheckVisibleStep(String param){
        this.path = param;
    }
    public void exec(ChromeDriver driver){
        System.out.print(getDescription() + " : ");
        if(driver.findElementByXPath(path).isDisplayed()){
            System.out.println(path + " is visible element.");
        }
        else{
            System.out.println(path + " is invisible element.");
        }
    }
}
