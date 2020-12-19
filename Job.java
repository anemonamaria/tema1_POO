import javax.swing.*;
import java.util.ArrayList;

public class Job {
    public String jobName;
    public String companyName;
    public Boolean available;
    private Constraint graduation;
    private Constraint experience;
    private Constraint academicAverage;
    private ArrayList applicants;
    private int numberOfEmployees;
    private int salary;

    public Job(){
        this.jobName = "";
        this.companyName = "";
        this.available = true;
    }

    public Job(String jobName, String companyName, Boolean availabe){
        this.jobName = jobName;
        this.companyName = companyName;
        this.available = availabe;
    }

    public void apply(User user){

    }

    public boolean meetsRequirments(User user){

        return false;
    }
}

class Constraint{
    private int inferior;
    private int superior;
    private int x;

    public Constraint(){
        this.inferior = 0;
        this.superior = 0;
        this.x = 0;
    }

    public Constraint(int inferior, int superior, int x){
        this.inferior = inferior;
        this.superior = superior;
        this.x = x;
    }

    public void setConstraints(int inferior, int superior) {
        this.inferior = inferior;
        this.superior = superior;
    }

    public boolean setX(int x){
        if (this.inferior <= x && x <= this.superior){
            this.x = x;
            return true;
        }
        return false;
    }

}