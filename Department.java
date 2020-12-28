import java.util.ArrayList;

public abstract class Department {
    public ArrayList<Employee> employees;
    public ArrayList<Job> jobs;

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

    // Metodă care s, terge un angajat din departament;
    public void remove(Employee employee){
        this.employees.remove(employee);
    }

    // Metodă care adaugă un job în departament;
    public void add(Job job){
        this.jobs.add(job);
    }

    // Metodă care întoarce angajat, ii dintr-un departament;
    public ArrayList<Employee> getEmployees(){
        return employees; ///????
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
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
