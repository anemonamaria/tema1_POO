public class Employee extends Consumer{
    private String companyName;
    private int salary;

    public Employee(){
        this.companyName = "";
        this.salary = 0;
    }

    public Employee(String name, int newSalary){
        this.companyName = name;
        this.salary = newSalary;
    }

    public void SetSalary(int newSalary){
        this.salary = newSalary;
    }

    public void SetCompany(String name){
        this.companyName = name;
    }
}
