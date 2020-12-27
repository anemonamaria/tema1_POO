public abstract class Marketing extends Department{
    public double getTotalSalaryBudget(){
        Double salaries = (double)0;
        for(Employee e : this.employees){
            if (e.salary > 5000) {
                salaries = salaries +(Double) e.salary * 90 / 100;
                // 10% pentru cei cu salarii mai mari de 5000
            } else if (e.salary >  3000){
                salaries = salaries + (Double) e.salary * 84 / 100;
                // 16% pentru cei cuprinsi intre 5000 si 3000
            } else
                // fara taxe pentru cei cu salarii mai mici de 3000
                salaries = salaries + (Double) e.salary;
        }
        return (double)salaries;
    }
}
