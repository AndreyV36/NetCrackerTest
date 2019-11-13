import org.openqa.selenium.chrome.ChromeDriver;

public interface Step {
    void exec(ChromeDriver driver);
    void setDescription(String description);
    String getDescription();
}
