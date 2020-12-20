public abstract class IT extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Employee e : this.employees){
            salaries = salaries + (Double)e.salary;
        }
        return salaries;
    }
    // no taxes
}
