import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    static public void main(String[] args){
        ConfigReader reader = new ConfigReader();
        ArrayList<Command> commandList;
        try{
            commandList = reader.getCommands("src/main/resources/UnitTestConfig.xls");
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return;
        }
        catch(IllegalArgumentException e){
            System.out.println("Wrong file format.");
            return;
        }
        TestEngine testEngine = new TestEngine(commandList);
        try{
            testEngine.execTest();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        /*
        for(int i = 0; i<commandList.size();i++){
            System.out.println(commandList.get(i).getAction() + " : " + commandList.get(i).getParams() + " : " + commandList.get(i).getDescription());
        }

         */
    }
}
