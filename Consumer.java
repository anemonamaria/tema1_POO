import java.beans.Expression;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;

public abstract class Consumer {
    Resume resume;
    ArrayList<Consumer> aquaintance;

    public Consumer(){
        this.resume = null;
        this.aquaintance = null;
    }

    public Consumer(Resume resume, ArrayList<Consumer> aquaintance){
        this.resume = resume;
        this.aquaintance = aquaintance;
    }

    public void setAquaintance(ArrayList<Consumer> aquaintance) {
        this.aquaintance = aquaintance;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public  void add(Education education){
        this.resume.education.add(education);
        Collections.sort(this.resume.education);
    }

    public void add(Experience experience){
        this.resume.experience.add(experience);
        Collections.sort(this.resume.experience);
    }

    public void add(Consumer consumer){
        this.aquaintance.add(consumer);
    }

    public int getDegreeInFriendship(Consumer consumer){
        int contoar = 0;
        for(Consumer c : this.aquaintance){
            if(!c.equals(consumer)){
                contoar = contoar + 1;

            } else {
                contoar = contoar + 1;
                break;
            }
        }
        if (contoar == this.aquaintance.size()) return  0;
        return contoar;
    }

    public void remove(Consumer consumer){
        this.aquaintance.remove(consumer);
    }

    public Integer getGraduationYear(){
        Calendar mostRecent = null;
        for(Education e : this.resume.education){
            if (mostRecent.compareTo(e.endDate) < 0){
                mostRecent = e.endDate;
            }
        }
        return mostRecent.YEAR;
    }

    public Double meanGPA(){
        double sum = 0;
        int numberOf = 0;
        for(Education e : this.resume.education){
            sum = sum + e.finalAverage;
            numberOf = numberOf + 1;
        }
        return (Double) sum / numberOf;
    }

    public static class Resume{
        public Information information;
        public Vector<Education> education;  //?? collections
        public Vector<Experience> experience; //???

        public Resume(){
            this.information = null;
            this.experience = null;
            this.education = null;
        }

        public Resume(Information information, Vector<Experience> experience, Vector<Education> education){
            this.information = information;
            this.education = education;
            this.experience = experience;
        }

        public void setEducation(Vector<Education> education) {
            this.education = education;
            Collections.sort(education);
        }

        public void setExperience(Vector<Experience> experience) {
            this.experience = experience;
            Collections.sort(experience);
        }

        public void setInformation(Information information) {
            this.information = information;
        }
    }
}

