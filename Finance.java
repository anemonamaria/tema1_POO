public abstract class Finance extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Employee e : this.employees){
            if( e.getTotalYearsExperience() < 1) {
                salaries = salaries + (double)e.salary * 90 / 100;
                // 10% pentru cei cu mai putin de 1 an experienta
            } else
                salaries = salaries + (double)e.salary * 84 / 100;
                // 16% pentru toti ceilalti
        }
        return salaries;
    }
}
