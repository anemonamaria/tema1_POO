import java.lang.Object;
import java.util.*;


// facuta, neverificata
public class Application {
    public ArrayList<Company> companies;
    public ArrayList<User> users;
    public ArrayList<Job> jobs;

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
                if (j.companyName.equals(c) && j.available){
                    availableJobs.add(j);
                }
            }
        }
        return availableJobs;
    }


}

