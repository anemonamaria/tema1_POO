public abstract class Finance extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Job j : this.jobs){
            if(j.experience.x < 1) {
                ///??? de modificat in calendar sau ceva
                salaries = salaries + (double)j.salary * 90 / 100;
            } else
                salaries = salaries + (double)j.salary * 84 / 100;
        }
        return salaries;
    }
}
