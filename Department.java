import java.util.ArrayList;

public abstract class Department {
    public ArrayList<Employee> employees;
    ArrayList<Job> jobs;

    public abstract double getTotalSalaryBudget(); //??

    public ArrayList<Job> getJobs(){
        ArrayList<Job> openJobs = new ArrayList<>();
        for(Job j : this.jobs){
            if(j.available){
                openJobs.add(j);
            }
        }
        return openJobs;
    }

    public void add(Employee employee){
        this.employees.add(employee);
    }

    public void remove(Employee employee){
        this.employees.remove(employee);
    }

    public void add(Job job){
        this.jobs.add(job);
    }

    public ArrayList<Employee> getEmployees(){
        return employees; ///????
    }
}
