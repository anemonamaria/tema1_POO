import java.util.*;
import java.io.*;

public class Experience implements Comparable{
    public Calendar startDate;
    public Calendar endDate;
    public String positon;
    public Company company;

    public Experience(){
        this.positon = "";
    }

    public Experience(String positon){
        this.positon = positon;
    }

    public void setEndDate(Calendar endDate) { //throws Exception??
        /// ???
        this.endDate = endDate;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public void setStartDate(Calendar startDate) {  //throws Exception???
        this.startDate = startDate;
    }

    @Override
    public int compareTo(Object o) {
        if (((Experience)o).endDate.equals(endDate))
            return company.name.compareTo(((Experience)o).company.name);
        if (!Experience.this.startDate.equals(java.time.LocalDate.now())){
            if (((Experience)o).endDate.compareTo(endDate) < 0) //?? verifica
                return  -1;
            else
                return 1;
        }
        if (Experience.this.startDate.equals(java.time.LocalDate.now())){
            this.endDate = null;
        }
        return 0;
    }

   // static class InvalidDatesException extends Exception{
        /// ???
    //}
}
