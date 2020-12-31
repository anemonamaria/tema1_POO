import javax.swing.*;
import java.util.ArrayList;

public class Job {
    private String jobName;
    private Company company;
    private Boolean available;
    private Constraint graduationYear;
    private Constraint experience;
    private Constraint academicAverage;
    private ArrayList<User> applicants;
    private int numberOfEmployees;
    private int salary;

    public Job(){
        this.jobName = "";
        this.company = new Company();
        this.available = true;
        applicants = new ArrayList<>();
    }

    public Job(String jobName, Company companyName, Boolean availabe){
        this.jobName = jobName;
        this.company = companyName;
        this.available = availabe;
    }

    public Company getCompany() {
        return company;
    }

    public Boolean getAvailable() {
        return available;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public Constraint getExperience() {
        return experience;
    }

    public int getSalary() {
        return salary;
    }

    public String getJobName() {
        return jobName;
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

    public void setAcademicAverage(Constraint<Double> academicAverage) {
        this.academicAverage = academicAverage;
    }

    public void setApplicants(ArrayList<User> applicants) {
        this.applicants = applicants;
    }

    public void setAvailable(Boolean available) {
        this.available = available;

        // Observer pattern
        if (this.available == false){
            this.company.notifyAllObservers(); ///??
        }
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

    // O metodă prin care un utilizator aplică la un job în companie
    public void apply(User user){
        // AICI INTRA O DATA
        //TODO:  de ce are problema aici?
        Recruiter recruiter = this.company.geRecruiter(user);   /// DE MODFICAT FUNCTIA ASTA PT GRAF, TREBUIE MUTATA IN CLASA ASTA
        int scor = recruiter.evaluate(this, user);
        Recruiter.Request<Job, Consumer> newRequest = new Recruiter.Request<Job, Consumer>(this, user, recruiter, (double)scor);
        Manager.requests.add(newRequest);

        // Observer pattern
        this.company.addObserver(user);
        //Un utilizator este adăugat drept observator pentru o companie în momentul în care acesta aplică la
        //un job din compania respectivă.
    }

    // O metodă care iterează prin lista de constrângeri s, i verifică dacă sunt îndeplinite pentru aplicantul primit
    //ca parametru
    public boolean meetsRequirments(User user){
        int aux = 1;
        if (!this.academicAverage.verifyX(user.meanGPA().intValue())){
            aux = 0;
        }
        if(!this.experience.verifyX(user.getTotalYearsExperience())){
            aux = 0;
        }
        if(!this.graduationYear.verifyX(user.getResume().getEducation().lastElement().getEndDate().getYear())){ ///????
            aux = 0;
        }
        if(aux == 1) return true;
        else return false;
    }

    public static class Constraint <V extends Comparable<V>>{
        // clasa pentru definirea constrangerilor
        public V inferior;
        public V superior;

        public Constraint(){
            this.inferior = null;
            this.superior = null;
        }

        public Constraint(V inferior, V superior){
            this.inferior = inferior;
            this.superior = superior;
        }

        public void setConstraints(V inferior, V superior) {
            this.inferior = (V) inferior;
            this.superior = (V) superior;
        }

        // verificam daca o valoare se incadreaza in constrangerile clasei
        public boolean verifyX(V x){
            if (this.inferior.compareTo(x) > 0 && this.superior.compareTo(x) < 0){
                return true;
            }
            return false;
        }
    }
}

