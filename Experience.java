import java.util.*;
import java.io.*;

public class Experience implements Comparable{
    private Calendar startDate;
    private Calendar endDate;
    private String positon;
    private Company company;
    private String department;

    public Experience(){
        this.positon = "";
    }

    public Experience(String positon){
        this.positon = positon;
    }

    public void setEndDate(Calendar endDate) throws InvalidDatesException{
        // verificam daca data de final corespunde
        if (endDate == null || endDate.compareTo(this.startDate) > 0 ){
            this.endDate = endDate;
        } else throw new InvalidDatesException();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public void setStartDate(Calendar startDate) throws InvalidDatesException{
        // verificam daca data de inceput corespunde
           this.startDate = startDate;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getPositon() {
        return positon;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        if (endDate != null)
            return endDate;
        else return new Calendar(0,0,0);
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public int compareTo(Object o) {
        if (((Experience)o).endDate.equals(endDate))
            return company.getName().compareTo(((Experience)o).company.getName());
        if (!Experience.this.startDate.equals(java.time.LocalDate.now())){
            if (((Experience)o).endDate.compareTo(endDate) < 0)
                return  -1;
            else
                return 1;
        }
        if (Experience.this.startDate.equals(java.time.LocalDate.now())){
            this.endDate = null;
        }
        return 0;
    }

    static class InvalidDatesException extends Exception {
        public InvalidDatesException() {
            System.out.println("Invalid dates! Please enter another dates.");
        }
    }
}
