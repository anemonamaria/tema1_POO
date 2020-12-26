import javax.swing.*;
import java.util.ArrayList;

public class Job {
    public String jobName;
    public Company company;
    public Boolean available;
    private Constraint graduationYear;
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

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setAcademicAverage(Constraint academicAverage) {
        this.academicAverage = academicAverage;
    }

    public void setApplicants(ArrayList<User> applicants) {
        this.applicants = applicants;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setExperience(Constraint experience) {
        this.experience = experience;
    }

    public void setGraduation(Constraint graduation) {
        this.graduationYear = graduation;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void apply(User user){
        ////????
        Recruiter recruiter = this.company.geRecruiter(user);
        int scor = recruiter.evaluate(this, user);
    }

    public boolean meetsRequirments(User user){
        int aux = 1;
        if (!this.academicAverage.verifyX(user.meanGPA().intValue())){
            aux = 0;
        }
        if(!this.experience.verifyX(user.getTotalYearsExperience())){
            aux = 0;
        }
        if(!this.graduationYear.verifyX(user.resume.education.lastElement().endDate.getYear())){ ///????
            aux = 0;
        }
        if(aux == 1) return true;
        else return false;
    }

    public static class Constraint{
        public int inferior;
        public int superior;

        public Constraint(){
            this.inferior = 0;
            this.superior = 0;
        }

        public Constraint(int inferior, int superior){
            this.inferior = inferior;
            this.superior = superior;
        }

        public void setConstraints(int inferior, int superior) {
            this.inferior = inferior;
            this.superior = superior;
        }

        public boolean verifyX(int x){
            if (this.inferior <= x && x <= this.superior){
                return true;
            }
            return false;
        }
    }
}

