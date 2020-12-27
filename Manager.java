import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Manager extends Employee{
    public static Vector<Recruiter.Request<Job, Consumer>> requests;

    public Manager(){
        this.requests = null;
    }

    public Manager(Vector<Recruiter.Request<Job, Consumer>> requests){
        this.requests = requests;
    }

    public void process(Job job) {
        ArrayList<Recruiter.Request<Job, Consumer>> possibleApplicants = new ArrayList<>();
        for (Recruiter.Request<Job, Consumer> r : requests) {
            Consumer user = r.getValue1();
            if (job.meetsRequirments((User) user)) {
                possibleApplicants.add(r);
                /// fac o lista cu toti utilizatorii care intrunesc conditii
            }
        }
        ArrayList<Recruiter.Request<Job, Consumer>> sortedList = new ArrayList<>();
        double max = 0;
        int copyNumberOfEmployees = job.getNumberOfEmployees();

        while(copyNumberOfEmployees != 0 && !possibleApplicants.contains(null)){
            Recruiter.Request<Job, Consumer> aux = null;
            for (Recruiter.Request<Job, Consumer> req : possibleApplicants){
                if (max <= req.getScore()){
                    max = req.getScore();
                    aux = req;
                    // aleg utilizatorul cu cel mai mare scor
                }
            }
            if (!Application.users.contains(aux.getValue1())){
                sortedList.add(aux);
                // il adaug in lista sortata descrescator daca nu este angajat intre timp
                copyNumberOfEmployees = copyNumberOfEmployees - 1;
                // sterg o pozitie din numarul pozitiilor disponibile
            }
            possibleApplicants.remove(aux);
            // il sterg din lista pentru a putea gasi urmatorul utilizator cu cel mai mare scor
        }
        for (Recruiter.Request<Job, Consumer> req : requests){
            if (req.getKey() == job){
                requests.remove(req);
                //sterg din colectia de requests request-urile pentru job
            }
        }
        job.setAvailable(false);
        // inchidem job-ul dupa ce trecem prin toate request-urile
    }
}
