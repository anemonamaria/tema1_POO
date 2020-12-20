public class Employee extends Consumer{
    private String companyName;
    public double salary;

    public Employee(){
        this.companyName = "";
        this.salary = 0;
    }

    public Employee(String name, double newSalary){
        this.companyName = name;
        this.salary = newSalary;
    }

    public void SetSalary(double newSalary){
        this.salary = newSalary;
    }

    public void SetCompany(String name){
        this.companyName = name;
    }
}
