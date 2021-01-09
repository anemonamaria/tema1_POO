public class Calendar {
    //clasa pentru reprezentarea unei dati
    private int year;
    private int month;
    private int day;

    public Calendar() {
        this.year = this.day = this.month = 0;
    }

    public Calendar(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int compareTo(Calendar calendar) {
        if (day == calendar.day && year == calendar.year && month == calendar.month)
            return 0;
        if (this.year < calendar.year) return -1;
        if (this.year == calendar.year){
            if(this.month < calendar.month) return -1;
            else if(this.month == calendar.month){
                if (this.day < calendar.day) return -1;
                else return 1;
            }  else return 1;
        }
        return 1;
    }
}
