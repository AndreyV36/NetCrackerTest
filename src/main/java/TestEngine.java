import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestEngine {
    private ArrayList<Step> stepList;
    public TestEngine(ArrayList<Command> commandList){
        this.stepList = new ArrayList<Step>();
        for(int i = 0; i < commandList.size(); i++){
            try{
                stepList.add(parse(commandList.get(i)));
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver/chromedriver.exe");
    }
    public void execTest() throws Exception{
        if(stepList.get(0) instanceof OpenUrlStep){
            ChromeDriver driver = new ChromeDriver();
            for(Step step : stepList){
                step.exec(driver);
            }
            driver.quit();
        }
        else{
            throw new Exception("Test page not set.");
        }
    }
    private Step parse(Command command){
        Step result;
        if(command.getAction().equals("openUrl")){
            result = new OpenUrlStep(command.getParams());
        }
        else if(command.getAction().equals("click")){
            result = new ClickStep(command.getParams());
        }
        else if(command.getAction().equals("setValue")){
            result = new SetValueStep(command.getParams());
        }
        else if(command.getAction().equals("screenshot")){
            result = new ScreenshotStep();
        }
        else if(command.getAction().equals("checkElementVisible")){
            result = new CheckVisibleStep(command.getParams());
        }
        else{
            throw new IllegalArgumentException("Unknown command " + command.getParams());
        }
        result.setDescription(command.getDescription());
        return result;
    }
}
