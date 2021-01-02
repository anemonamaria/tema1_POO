import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Manager extends Employee{
    public Vector<Recruiter.Request<Job, Consumer>> requests;

    public Manager(){
        this.requests = new Vector<>();
    }

    public Manager(Vector<Recruiter.Request<Job, Consumer>> requests){
        this.requests = requests;
    }

    public void process(Job job) {
        ArrayList<Recruiter.Request<Job, Consumer>> possibleApplicants = new ArrayList<>();
        for (Recruiter.Request<Job, Consumer> r : requests) {
            Consumer user = r.getValue1();
            System.out.println("hmmmmmmm");   //TODO DE CE E UN SINGUR REQUEST
            if (job.meetsRequirments((User) user)) {
                possibleApplicants.add(r);
                System.out.println("hmmm");   //TODO: REPARA FUNCTIA ASTA
                /// fac o lista cu toti utilizatorii care intrunesc conditii
            }
            else ((User) user).update(new Notification("You were rejected!"));
            // Observer pattern - utilizatori respinsi
        }
        ArrayList<Recruiter.Request<Job, Consumer>> sortedList = new ArrayList<>();
        double max = 0;
        int copyNumberOfEmployees = job.getNumberOfEmployees();

        while(copyNumberOfEmployees != 0 && !possibleApplicants.contains(null)){
            Recruiter.Request<Job, Consumer> aux = null;
            System.out.println("mhhhhh");
            for (Recruiter.Request<Job, Consumer> req : possibleApplicants){
                System.out.println(req.getScore());
                if (max <= req.getScore()){
                    System.out.println("ajungi ????");
                    max = req.getScore();
                    aux = req;
                    // aleg utilizatorul cu cel mai mare scor
                }
            }
            if(aux.getValue1()!= null){
                if (!Application.users.contains(aux.getValue1())) {
                    sortedList.add(aux);
                    // il adaug in lista sortata descrescator daca nu este angajat intre timp
                    copyNumberOfEmployees = copyNumberOfEmployees - 1;
                    // sterg o pozitie din numarul pozitiilor disponibile
                }
            }
            possibleApplicants.remove(aux);
            // il sterg din lista pentru a putea gasi urmatorul utilizator cu cel mai mare scor
        }
        ArrayList<Recruiter.Request<Job, Consumer>> rejected = new ArrayList<>();
        for(Recruiter.Request<Job, Consumer> req : possibleApplicants){
            ((User)req.getValue1()).update(new Notification("You were rejected!"));
            // Observer pattern - utilizatori respinsi
        }
        for(Recruiter.Request<Job, Consumer> r : sortedList){
            User newUser = (User)r.getValue1();
            Employee newEmployee = newUser.convert();
            newEmployee.companyName = job.getCompany().getName();
            newEmployee.salary = job.getSalary();
            // se angajeaza
            for(Department d : job.getCompany().getDepartments()){
                for (Job j : d.getJobs()){
                    if(j == job){
                        d.getEmployees().add(newEmployee);
                        break;
                    }
                }
            }
            for(Company c : Application.companies){
                c.removeObserver(newUser);
                // Observer pattern - sterg din lista tuturor companiilor observatorul angajat
                // E BINE????
            }
        }
        for (Recruiter.Request<Job, Consumer> req : requests){
            if (req.getKey() == job){
                requests.remove(req);
                //sterg din colectia de requests request-urile pentru job
            }
        }
        job.setAvailable(false);
        Company company = job.getCompany();
        company.notifyAllObservers(new Notification("Closed job!")); // ???
        // Observer pattern - job inchis
        // inchidem job-ul dupa ce trecem prin toate request-urile
    }
}
