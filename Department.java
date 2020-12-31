import java.util.ArrayList;

public abstract class Department {
    public ArrayList<Employee> employees;
    public ArrayList<Job> jobs;
    private String name;

    public Department(){
        this.employees = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.name = "";
    }
    // Metodă abstractă care va returna bugetul total de salarii, după aplicarea taxelor;
    public abstract double getTotalSalaryBudget(); //??

    // Metodă care întoarce toate joburile deschise din departament;
    public ArrayList<Job> getJobs(){
        ArrayList<Job> openJobs = new ArrayList<>();
        for(Job j : this.jobs){
            if(j.getAvailable()){
                openJobs.add(j);
            }
        }
        return openJobs;
    }

    // Metodă care adăuga un angajat în departament
    public void add(Employee employee){
        this.employees.add(employee);
    }

    // Metodă care sterge un angajat din departament;
    public void remove(Employee employee){
        this.employees.remove(employee);
    }

    // Metodă care adaugă un job în departament;
    public void add(Job job){
        this.jobs.add(job);
        for(User u : Company.observers){
            // Observer pattern - job nou
            /// E BINE????
            u.update(new Notification("New job!"));
        }
    }

    // Metodă care întoarce angajat, ii dintr-un departament;
    public ArrayList<Employee> getEmployees(){
        return employees; ///????
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Job findJob(String jobName){
        for(Job j : this.getJobs()){
            if(j.getJobName().equals(jobName))
                return j;
        }
        return null;
    }

    public Employee findEmployee(String firstName, String lastName){
        for (Employee e : this.getEmployees()){
            if(e.getResume().getInformation().getFirstName().equals(firstName) &&
            e.getResume().getInformation().getLastName().equals(lastName)){
                return e;
            }
        }
        return null;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Factory pattern ?????? E BINE?????
    static class DepartmentFactory {
        public static Department Factory(String departmentName){
            if (departmentName.equals("Marketing")){
                return new Marketing() {
                    @Override
                    public double getTotalSalaryBudget() {
                        return super.getTotalSalaryBudget();
                    }
                };
            }
            if (departmentName.equals("Finance")){
                return new Finance() {
                    @Override
                    public double getTotalSalaryBudget() {
                        return super.getTotalSalaryBudget();
                    }
                };
            }
            if (departmentName.equals("IT")){
                return new IT() {
                    @Override
                    public double getTotalSalaryBudget() {
                        return super.getTotalSalaryBudget();
                    }
                };
            }
            if (departmentName.equals("Management")){
                return new Management() {
                    @Override
                    public double getTotalSalaryBudget() {
                        return super.getTotalSalaryBudget();
                    }
                };
            }
            return null;
        }
    }
}
