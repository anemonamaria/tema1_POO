public abstract class Finance extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Employee e : this.employees){
            if( e.getTotalYearsExperience() < 1) {
                ///??? de modificat in calendar sau ceva
                salaries = salaries + (double)e.salary * 90 / 100;
            } else
                salaries = salaries + (double)e.salary * 84 / 100;
        }
        return salaries;
    }
}
