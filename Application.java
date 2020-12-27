import java.lang.Object;
import java.util.*;

public class Application {
    private ArrayList<Company> companies;
    public static ArrayList<User> users;
    private ArrayList<Job> jobs;

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public Company getCompany(String name) {
        if (companies.contains(name))
            return companies.get(companies.indexOf(name));
        return null;
    }

    public void add(Company company) {
        add(company);
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


}

