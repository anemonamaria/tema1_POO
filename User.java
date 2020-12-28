public class User extends Consumer{
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
}