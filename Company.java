import java.util.ArrayList;
import java.util.EnumMap;

public class Company {
    public String name;
    private Manager manager;
    private ArrayList<Department> departments;
    private ArrayList<Recruiter> recruiters;

    public Company(){
        this.name = "";
    }

    public Company(String newName) {
        this.name = newName;
    }

    public void add(Department department){
        this.departments.add(department);
    }

    public void add(Recruiter recruiter){
        this.recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department){
        department.employees.add(employee);
        this.departments.add(department);
    }

    public void remove(Employee employee){
        this.departments.remove(employee);
    }

    public void remove(Department department){
        for(Employee e : department.employees){
            department.remove(e);
        }
        this.departments.remove(department);
    }

    public void remove(Recruiter recruiter){
        this.recruiters.remove(recruiter);
    }

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

    public void move(Employee employee, Department newDepartment){
        this.departments.remove(employee);
        newDepartment.add(employee);
    }

    public boolean contains(Department department){
        return this.departments.contains(department);
    }

    public boolean contains(Employee employee){
        for(Department d : this.departments){
            if (d.employees.contains(employee)){
                return true;
            }
        }
        return false;
    }

    public boolean contains(Recruiter recruiter){
        return this.recruiters.contains(recruiter);
    }

    public Recruiter geRecruiter(User user){
        ArrayList<Integer> recruiterScores = new ArrayList<>();
        for (Recruiter r : recruiters){
            recruiterScores.add(r.getDegreeInFriendship(user));
        }
        int max = 0, index = 0;
        for(Integer i : recruiterScores){
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

    public ArrayList<Job> getJobs(){
        ArrayList<Job> availableJobs = new ArrayList<>();
        for(Department d : this.departments){
            for(Job j : d.jobs){
                if(j.available) {
                    availableJobs.add(j);
                }
            }
        }
        return availableJobs;
    }
}
