import java.util.ArrayList;

public class Information {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Calendar birthday;
    private String sex;
    private ArrayList<Language> knownLanguages;

    public Information(){
        this.firstName = "";
        this.lastName = "";
    }

    public Information(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setKnownLanguages(ArrayList<Language> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addKnownLanguages(Language language){
        this.knownLanguages.add(language);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }

    public ArrayList<Language> getKnownLanguages() {
        return knownLanguages;
    }
}

class Language{
    private String name;
    private String level;

    public Language(){
        this.name = "";
        this.level = "Beginner";
    }

    public Language(String name, String level){
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }
}
