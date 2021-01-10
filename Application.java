import java.lang.Object;
import java.util.*;

public class Application {
    public static ArrayList<Company> companies;
    public static ArrayList<User> users;

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

    // Determinarea companiilor care au fost înscrise în aplicatie;
    public ArrayList<Company> getCompanies() {
        return companies;
    }

    //  Determinarea unei anumite companii în functie de numele furnizat;
    public Company getCompany(String name) {
        for (Company c : companies){
            if (c.getName().equals(name))
                return c;
        }
        return null;
    }

    // Adăugarea unei companii;
    public void add(Company company) {
        companies.add(company);
    }

    // Adăugarea unui utilizator;
    public void add(User user) {
        add(user);
    }

    // Stergerea unei companii – va întoarce false dacă compania nu există;
    public boolean remove(Company company){
        if (companies.contains(company)) {
            companies.remove(companies.indexOf(company));
            return true;
        }
        return false;
    }

    // Stergerea unui utilizator – va întoarce false dacă utilizatorul nu există;
    public boolean remove(User user){
        if (users.contains(user)){
            users.remove(users.indexOf(user));
            return true;
        }
        return false;
    }

    // Determinarea joburile disponibile de la companiile pe care le preferă utilizatorul.
    public ArrayList<Job> getJobs(List<String> companies) {
        ArrayList<Job> availableJobs = new ArrayList<>();
        for (String c : companies){
            for ( Department d : getCompany(c).getDepartments()){
                availableJobs.addAll(d.getJobs());
            }
        }
        return availableJobs;
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

