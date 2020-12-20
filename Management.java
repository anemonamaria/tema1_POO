public abstract class Management extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Employee e : this.employees){
            salaries = salaries + (Double)e.salary;
        }
        return (double)salaries * 84 / 100;
    }
}
