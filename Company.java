public class Company {
    public String name;
    private Manager managers;
    private Department departments;
    private Recruiter recruiters;

    public Company(){
        this.name = "";
    }

    public Company(String newName) {
        this.name = newName;
    }

}
