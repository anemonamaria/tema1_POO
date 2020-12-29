import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.*;

public class Test {
    public void load(){
        final String test = "Test.txt";
        try{
            RandomAccessFile testFile = new RandomAccessFile(test, "r");
            int numberOfUsers = Integer.parseInt(testFile.readLine());
            for (int i = 0; i < numberOfUsers; i++){
                // Informations
                Information info = new Information();
                // birthday
                String birthdayLine = testFile.readLine();
                StringTokenizer stBirthday = new StringTokenizer(birthdayLine,";");
                Calendar birthday = new Calendar(Integer.parseInt(stBirthday.nextToken()),
                        Integer.parseInt(stBirthday.nextToken()),
                        Integer.parseInt(stBirthday.nextToken()));
                info.setBirthday(birthday);
                // language
                int numberOfLanguages = Integer.parseInt(testFile.readLine());
                ArrayList<Language> languages = new ArrayList<>();
                for (int j = 0; j < numberOfLanguages; j++){
                    String languageLine = testFile.readLine();
                    StringTokenizer stLanguage = new StringTokenizer(languageLine, ";");
                    Language language = new Language(stLanguage.nextToken(), stLanguage.nextToken());
                    languages.add(language);
                }
                info.setKnownLanguages(languages);
                String infoLine = testFile.readLine();
                StringTokenizer stInfo = new StringTokenizer(infoLine, ";");
                info.setFirstName(stInfo.nextToken());
                info.setLastName(stInfo.nextToken());
                info.setEmail(stInfo.nextToken());
                info.setPhone(stInfo.nextToken());
                info.setSex(stInfo.nextToken());
                // education
                Vector<Education> educations = new Vector<>();
                int numberOfEducations = Integer.parseInt(testFile.readLine());
                for(int j = 0; j < numberOfEducations; j++){
                    String educationLine = testFile.readLine();
                    StringTokenizer stEducation = new StringTokenizer(educationLine, ";");
                    Education education = new Education();
                    try{
                        education.setStartDate(new Calendar(Integer.parseInt(stEducation.nextToken()),
                                Integer.parseInt(stEducation.nextToken()),
                                Integer.parseInt(stEducation.nextToken())));
                    } catch (Education.InvalidDatesException e){
                        throw new Education.InvalidDatesException();
                    }
                    try{
                        education.setEndDate(new Calendar(Integer.parseInt(stEducation.nextToken()),
                                Integer.parseInt(stEducation.nextToken()),
                                Integer.parseInt(stEducation.nextToken())));
                    } catch (Education.InvalidDatesException e){
                        throw new Education.InvalidDatesException();
                    }
                    education.setInstitution(stEducation.nextToken());
                    education.setLevel(stEducation.nextToken());
                    education.setFinalAverage(Double.parseDouble(stEducation.nextToken()));
                    educations.add(education);
                }
                // experience
                Vector<Experience> experiences = new Vector<>();
                int numberOfExperiences = Integer.parseInt(testFile.readLine());
                for (int j = 0; j < numberOfExperiences; j++){
                    String experiencesLine = testFile.readLine();
                    StringTokenizer stExperience = new StringTokenizer(experiencesLine, ";");
                    Experience experience = new Experience();
                    try{
                        experience.setStartDate(new Calendar(Integer.parseInt(stExperience.nextToken()),
                                Integer.parseInt(stExperience.nextToken()),
                                Integer.parseInt(stExperience.nextToken())));
                    } catch (Experience.InvalidDatesException e){
                        throw new Experience.InvalidDatesException();
                    }
                    try {
                        experience.setEndDate(new Calendar(Integer.parseInt(stExperience.nextToken()),
                                Integer.parseInt(stExperience.nextToken()),
                                Integer.parseInt(stExperience.nextToken())));
                    } catch (Experience.InvalidDatesException e){
                        throw new Experience.InvalidDatesException();
                    }
                    experience.setPositon(stExperience.nextToken());
                    Company c = new Company(stExperience.nextToken());
                    Application.companies.add(c);
                    experience.setCompany(c);
                }
                // resume
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(info)
                        .vectors(educations, experiences)
                        .build();

                // Consumer
                Consumer consumer = new Consumer() {
                    @Override
                    public void add(Consumer consumer) {
                        super.add(consumer);
                    }
                };
                consumer.setResume(resume);
                // DE FACUT ARRAYLIST AQUAINTANCES
                Application.users.add((User)consumer); // ???
            }

        }
        catch(IOException | Education.InvalidDatesException | Experience.InvalidDatesException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.load();

    }
}
