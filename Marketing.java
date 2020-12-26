public abstract class Marketing extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Employee e : this.employees){
            if (e.salary > 5000) {
                salaries = salaries +(Double) e.salary * 90 / 100;
            } else if (e.salary >  3000){
                salaries = salaries + (Double) e.salary * 84 / 100;
            } else
                salaries = salaries + (Double) e.salary;
        }
        return (double)salaries;
    }
}
