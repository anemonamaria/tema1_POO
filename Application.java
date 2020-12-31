import java.lang.Object;
import java.util.*;

public class Application {
    public static ArrayList<Company> companies;
    public static ArrayList<User> users;
    public static ArrayList<Job> jobs;

    // Singleton pattern
    private static Application instance;

    //constructor privat doar pentru a nu permine instantierea
    private Application() {
        this.companies = null;
    }

    public static Application getInstance() {
        if(instance == null) {
            instance = new Application();
        }
        return instance;
    }
    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<Job> getJobsAll(){
        return  jobs;
    }

    public Company getCompany(String name) {
        for (Company c : companies){
            if (c.getName().equals(name))
                return c;
        }
        return null;
    }

    public void add(Company company) {
        companies.add(company);
    }

    public void add(User user) {
        add(user);
    }

    public boolean remove(Company company){
        if (companies.contains(company)) {
            companies.remove(companies.indexOf(company));
            return true;
        }
        return false;
    }

    public boolean remove(User user){
        if (users.contains(user)){
            users.remove(users.indexOf(user));
            return true;
        }
        return false;
    }

    public ArrayList<Job> getJobs(List<String> companies) {
        ArrayList<Job> availableJobs = new ArrayList<>();
        for (String c : companies){
            for (Job j : this.jobs){
                if (j.getCompany().getName().equals(c) && j.getAvailable()){
                    availableJobs.add(j);
                }
            }
        }
        return availableJobs;
    }

    public User getUser(String firstName, String lastName){
        int index = 0;
        for (User u : this.users){
            if (u.getResume().getInformation().getFirstName() == firstName
                    && u.getResume().getInformation().getLastName() == lastName){
                index = users.indexOf(u);
            }
        }
        return users.get(index);
    }

    public Company findCompany(String name){
        for (Company c : companies){
            if(c.getName().equals(name))
                return c;
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public User findUser(String firstName, String lastName){
        for (User u : users){
            if(u.getResume().getInformation().getFirstName().equals(firstName) &&
                    u.getResume().getInformation().getLastName().equals(lastName)){
                return u;
            }
        }
        return null;
    }
}

