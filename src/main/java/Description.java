public abstract class Description implements Step{
    private String description = "No description";
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
