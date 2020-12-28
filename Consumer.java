import java.beans.Expression;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public abstract class Consumer {
    private Resume resume;
    private ArrayList<Consumer> aquaintance;

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

    public Resume getResume() {
        return resume;
    }

    public ArrayList<Consumer> getAquaintance() {
        return aquaintance;
    }

    // Adăugarea unor studii;
    public  void add(Education education){
        this.resume.education.add(education);
        Collections.sort(this.resume.education);
    }

    // Adăugarea unei experient,e profesionale;
    public void add(Experience experience){
        this.resume.experience.add(experience);
        Collections.sort(this.resume.experience);
    }

    // Adăugarea unui nou cunoscut;
    public void add(Consumer consumer){
        this.aquaintance.add(consumer);
    }

    //Determinarea gradului de prietenie cu un alt utilizator – se realizează o parcurgere în lăt, ime în ret,eaua
    //socială a utilizatorului;
    public int getDegreeInFriendship(Consumer consumer){
        /// DE MODIFICAT !!!! DE ADAUGAT GRAFURI

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

    //Eliminarea unei persoane din ret,eaua socială
    public void remove(Consumer consumer){
        this.aquaintance.remove(consumer);
    }

    // Determinarea anului absolvirii
    public Integer getGraduationYear(){
        Calendar mostRecent = null;
        for(Education e : this.resume.education){
            if (mostRecent.compareTo(e.getEndDate()) < 0){
                mostRecent = e.getEndDate();
            }
        }
        return mostRecent.getYear();
    }

    //  Determinarea mediei studiilor absolvite;
    public Double meanGPA(){
        double sum = 0;
        int numberOf = 0;
        for(Education e : this.resume.education){
            sum = sum + e.getFinalAverage();
            numberOf = numberOf + 1;
        }
        return (Double) sum / numberOf;
    }

    //metoda pentru aflarea anilor de experienta
    public int getTotalYearsExperience(){
        Integer yearsOfExperience = 0;
        if (this.resume.experience.firstElement().getStartDate().getYear() == this.resume.experience.lastElement().getEndDate().getYear()){
            yearsOfExperience = 1;
        } else {
            yearsOfExperience = this.resume.experience.lastElement().getEndDate().getYear() - this.resume.experience.firstElement().getStartDate().getYear();
        }
        return yearsOfExperience;
    }

    public static class Resume{
        private Information information;
        private Vector<Education> education;
        private Vector<Experience> experience;

        // Builder pattern
        public Resume(ResumeBuilder resumeBuilder) {
            this.information = resumeBuilder.information;
            this.education = resumeBuilder.education;
            this.experience = resumeBuilder.experience;
        }

        public Information getInformation() {
            return information;
        }

        public Vector<Education> getEducation() {
            return education;
        }

        public Vector<Experience> getExperience() {
            return experience;
        }

        // Builder pattern
        public static class ResumeBuilder{
            private Information information;
            private Vector<Education> education;
            private Vector<Experience> experience;

            public ResumeBuilder(Information information){
                this.information = information;
            }

            public ResumeBuilder(Vector<Education> education, Vector<Experience> experience){
                this.education = education;
                this.experience = experience;
            }

            public Resume build(){
                return new Resume(this);
            }
        }
    }
}

