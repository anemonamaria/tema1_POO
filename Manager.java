import java.util.Collections;
import java.util.Vector;

public class Manager extends Employee{
    Vector<Recruiter.Request> requests;

    public Manager(){
        this.requests = null;
    }

    public Manager(Vector<Recruiter.Request> requests){
        this.requests = requests;
    }

    public void process(Job job) {
        ///????
    }

}
