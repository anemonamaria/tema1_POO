import java.util.ArrayList;

public class Company implements Subject{
    private String name;
    private Manager manager;
    private ArrayList<Department> departments;
    private ArrayList<Recruiter> recruiters;
    public static ArrayList<User> observers;

    public Company(){
        this.name = "";
        this.manager = null;
        this.departments = new ArrayList<>();
        this.recruiters = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public Company(String newName) {
        this.name = newName;
    }

    public ArrayList<User> getObservers() {
        return observers;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Manager getManager() {
        return manager;
    }

    public ArrayList<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartments(ArrayList<Department> departments) {
        if (departments == null) return;
        this.departments.addAll(departments);
    }

    public void setRecruiters(ArrayList<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    public String getName() {
        return name;
    }

    // Adăugarea unui nou departament în companie;
    public void add(Department department){
        this.departments.add(department);
    }

    // Adăugarea unui nou recruiter;
    public void add(Recruiter recruiter){
        this.recruiters.add(recruiter);
    }

    // Adăugarea unui angajat într-un departament;
    public void add(Employee employee, Department department){
        department.employees.add(employee);
        this.departments.add(department);
    }

    // Eliminarea unui angajat din companie
    public void remove(Employee employee){
        this.departments.remove(employee);
    }

    //  Eliminarea unui departament din companie si a tuturor angajat, ilor care fac parte din departamentul
    // respectiv;
    public void remove(Department department){
        for(Employee e : department.employees){
            department.remove(e);
        }
        this.departments.remove(department);
    }

    // Eliminarea unui recruiter;
    public void remove(Recruiter recruiter){
        this.recruiters.remove(recruiter);
    }

    // Mutarea unui departament în alt departament si transferarea tuturor angajatilor;
    public void move(Department source, Department destination){
        for(Employee e : source.employees){
            destination.employees.add(e);
            source.employees.remove(e);
        }
        for(Job j : source.jobs){
            destination.jobs.add(j);
            source.jobs.remove(j);
        }
    }

    // Mutarea unui angajat dintr-un departament în alt departament;
    public void move(Employee employee, Department newDepartment){
        this.departments.remove(employee);
        newDepartment.add(employee);
    }

    // Verificarea existent,ei unui departament în companie;
    public boolean contains(Department department){
        return this.departments.contains(department);
    }

    public Department getDepartment(String departmentName){
        for(Department d : departments){
            if(d.getName().equals(departmentName)){
                return d;
            }
        }
        return null;
    }
    // Verificare existent,ei unui angajat în companie;
    public boolean contains(Employee employee){
        for(Department d : this.departments){
            if (d.employees.contains(employee)){
                return true;
            }
        }
        return false;
    }

    // Verificarea existent,ei unui recruiter în companie;
    public boolean contains(Recruiter recruiter){
        return this.recruiters.contains(recruiter);
    }

    // Determinarea recruiter-ului potrivit pentru un utilizator;
    public Recruiter getRecruiter(User user){

        ArrayList<Integer> recruiterScores = new ArrayList<>();
        for (Recruiter r : recruiters){
            recruiterScores.add(r.getDegreeInFriendship(user));
        }
        int max = 0, index = 0;
        for(Integer i : recruiterScores){
            // alegem cel mai indepartat recruiter
            if(i == 0){
                // inseamna ca nu au nicio legatura
                index = recruiterScores.indexOf(i);
                break;
            }
            if (max < i){
                max = i;
                index = recruiterScores.indexOf(i);
            }
        }
        Recruiter recruiter = recruiters.get(index);
        return recruiter;
    }

    //Determinarea job-urilor disponibile dintr-o companie (cele care nu au fost deja închise);
    public ArrayList<Job> getJobs(){
        ArrayList<Job> availableJobs = new ArrayList<>();
        for(Department d : this.departments){
            for(Job j : d.jobs){
                if(j.getAvailable()) {
                    availableJobs.add(j);
                }
            }
        }
        return availableJobs;
    }

    public Recruiter findRecruiter(String firstName, String lastName){
        for (Recruiter r : recruiters){
            if(r.getResume().getInformation().getFirstName() == firstName &&
                    r.getResume().getInformation().getLastName() == lastName){
                return r;
            }
        }
        return null;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    @Override
    public void addObserver(User user) {
        this.observers.add(user);
    }

    @Override
    public void removeObserver(User c) {
        this.observers.remove(c);
    }

    @Override
    public void notifyAllObservers() {
        for(User o : observers){
            o.update(new Notification("Notification"));
        }
    }

    public void notifyAllObservers(Notification notification){
        for(User o : observers){
            o.update(notification);
        }
    }
}
