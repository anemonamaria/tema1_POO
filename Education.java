import java.util.*;

public class Education implements Comparable {
    public Calendar startDate;
    public Calendar endDate;
    public String institution;
    public String level;
    public Double finalAverage;

    public Education(){
        this.institution = "";
    }

    public Education(String institution) throws InvalidDatesException{
        this.institution = institution;
    }

    public void setStartDate(Calendar startDate) throws InvalidDatesException{
        this.startDate = startDate;
    }

    public void setFinalAverage(Double finalAverage) throws InvalidDatesException{
        this.finalAverage = finalAverage;
    }

    public void setInstitution(String institution) throws InvalidDatesException{
        this.institution = institution;
    }

    public void setEndDate(Calendar endDate) throws InvalidDatesException{
        this.endDate = endDate;
    }

    public void setLevel(String level) throws InvalidDatesException{
        this.level = level;
    }

    @Override
    public int compareTo(Object o) {
        if (((Education)o).endDate.equals(endDate))
            return finalAverage.compareTo(((Education)o).finalAverage);
        if (!Education.this.endDate.equals(0)){
            if (finalAverage - ((Education)o).finalAverage < 0)
                return  -1;
            else
                return 1;
        }
        if (Education.this.endDate.equals(0)){
            this.endDate = null;
            this.finalAverage = (double)0;
            if(((Education)o).startDate.compareTo(startDate) < 0) //?? verifica
                return 1;
            else
                return -1;
        }
        return 0;
    }

    static class InvalidDatesException extends Exception{
        /// ???
    }
}
