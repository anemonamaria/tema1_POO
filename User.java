import java.util.ArrayList;

public abstract class User extends Consumer implements Observer{
    private ArrayList<Notification> notifications;

    public Employee convert(){ // ???
        Employee newEmployee = new Employee();
        newEmployee.setResume(this.getResume());
        newEmployee.setAquaintance(this.getAquaintance());
        return newEmployee;
    }

    public Double getTotalScore(){
        Double score = (double)0; ///????
        Integer yearsOfExperience = 0;
        if (this.getResume().getExperience().firstElement().getStartDate().getYear() == this.getResume().getExperience().lastElement().getEndDate().getYear()){
            yearsOfExperience = 1;
        } else {
            yearsOfExperience = this.getResume().getExperience().lastElement().getEndDate().getYear() - this.getResume().getExperience().firstElement().getStartDate().getYear();
        }
        score = yearsOfExperience * 1.5 + this.meanGPA();
        return score;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    // Observer pattern
    public void update(Notification notification){
        this.notifications.add(notification);
    }
}