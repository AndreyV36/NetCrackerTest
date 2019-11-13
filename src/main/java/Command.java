public class Command {
    private String action;
    private String params;
    private String description;
    public Command(String action, String params, String description){
        this.action = action;
        this.params = params;
        this.description = description;
    }
    public String getAction(){
        return action;
    }
    public String getParams(){
        return params;
    }
    public String getDescription(){
        return description;
    }
}
