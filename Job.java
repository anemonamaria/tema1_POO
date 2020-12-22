import javax.swing.*;
import java.util.ArrayList;

public class Job {
    public String jobName;
    public Company company;
    public Boolean available;
    private Constraint graduation;
    public Constraint experience;
    private Constraint academicAverage;
    private ArrayList<User> applicants;
    private int numberOfEmployees;
    public int salary;

    public Job(){
        this.jobName = "";
        this.company = null;
        this.available = true;
    }

    public Job(String jobName, Company companyName, Boolean availabe){
        this.jobName = jobName;
        this.company = companyName;
        this.available = availabe;
    }

    public void apply(User user){
        ////????
        Recruiter recruiter = this.company.geRecruiter(user);
        int scor = recruiter.evaluate(this, user);
    }

    public boolean meetsRequirments(User user){
        ///????
        return false;
    }

    public class Constraint{
        public int inferior;
        public int superior;
        public int x;

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
}

