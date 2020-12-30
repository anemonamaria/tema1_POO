import netscape.javascript.JSObject;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.*;
import java.util.concurrent.atomic.LongAccumulator;

public class Test {
//    public void load(){
//        final String test = "src\\Test.txt";
//        // Application
//        Application application = Application.getInstance();
//        Application.companies = new ArrayList<>();
//        Application.users = new ArrayList<>();
//        Application.jobs = new ArrayList<>();
//        try{
//            RandomAccessFile testFile = new RandomAccessFile(test, "r");
//            int numberOfUsers = Integer.parseInt(testFile.readLine());
//            for (int i = 0; i < numberOfUsers; i++){
//                // Informations
//                Information info = new Information();
//                // birthday
//                String birthdayLine = testFile.readLine();
//                StringTokenizer stBirthday = new StringTokenizer(birthdayLine,";");
//                Calendar birthday = new Calendar(Integer.parseInt(stBirthday.nextToken()),
//                        Integer.parseInt(stBirthday.nextToken()),
//                        Integer.parseInt(stBirthday.nextToken()));
//                info.setBirthday(birthday);
//
//                // language
//                int numberOfLanguages = Integer.parseInt(testFile.readLine());
//                ArrayList<Language> languages = new ArrayList<>();
//                for (int j = 0; j < numberOfLanguages; j++){
//                    String languageLine = testFile.readLine();
//                    StringTokenizer stLanguage = new StringTokenizer(languageLine, ";");
//                    Language language = new Language(stLanguage.nextToken(), stLanguage.nextToken());
//                    languages.add(language);
//                    //System.out.println(language.getLevel());
//                }
//                info.setKnownLanguages(languages);
//                String infoLine = testFile.readLine();
//                StringTokenizer stInfo = new StringTokenizer(infoLine, ";");
//                info.setFirstName(stInfo.nextToken());
//                info.setLastName(stInfo.nextToken());
//                info.setEmail(stInfo.nextToken());
//                info.setPhone(stInfo.nextToken());
//                info.setSex(stInfo.nextToken());
//
//                // education
//                Vector<Education> educations = new Vector<>();
//                int numberOfEducations = Integer.parseInt(testFile.readLine());
//                for(int j = 0; j < numberOfEducations; j++){
//                    String educationLine = testFile.readLine();
//                    StringTokenizer stEducation = new StringTokenizer(educationLine, ";");
//                    Education education = new Education();
//                    try{
//                        education.setStartDate(new Calendar(Integer.parseInt(stEducation.nextToken()),
//                                Integer.parseInt(stEducation.nextToken()),
//                                Integer.parseInt(stEducation.nextToken())));
//                    } catch (Education.InvalidDatesException e){
//                        throw new Education.InvalidDatesException();
//                    }
//                    try{
//                        education.setEndDate(new Calendar(Integer.parseInt(stEducation.nextToken()),
//                                Integer.parseInt(stEducation.nextToken()),
//                                Integer.parseInt(stEducation.nextToken())));
//                    } catch (Education.InvalidDatesException e){
//                        throw new Education.InvalidDatesException();
//                    }
//                    education.setInstitution(stEducation.nextToken());
//                    education.setLevel(stEducation.nextToken());
//                    education.setFinalAverage(Double.parseDouble(stEducation.nextToken()));
//                    educations.add(education);
//                }
//
//                // experience
//                Vector<Experience> experiences = new Vector<>();
//                int numberOfExperiences = Integer.parseInt(testFile.readLine());
//                for (int j = 0; j < numberOfExperiences; j++){
//                    String experiencesLine = testFile.readLine();
//                    StringTokenizer stExperience = new StringTokenizer(experiencesLine, ";");
//                    Experience experience = new Experience();
//                    try{
//                        experience.setStartDate(new Calendar(Integer.parseInt(stExperience.nextToken()),
//                                Integer.parseInt(stExperience.nextToken()),
//                                Integer.parseInt(stExperience.nextToken())));
//                    } catch (Experience.InvalidDatesException e){
//                        throw new Experience.InvalidDatesException();
//                    }
//                    try {
//                        experience.setEndDate(new Calendar(Integer.parseInt(stExperience.nextToken()),
//                                Integer.parseInt(stExperience.nextToken()),
//                                Integer.parseInt(stExperience.nextToken())));
//                    } catch (Experience.InvalidDatesException e){
//                        throw new Experience.InvalidDatesException();
//                    }
//                    experience.setPositon(stExperience.nextToken());
//                    Company c = new Company(stExperience.nextToken());
//                    Application.companies.add(c);
//                    experience.setCompany(c);
//                }
//
//                // resume
//                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(info)
//                        .vectors(educations, experiences)
//                        .build();
//
//                // User
//                User user = new User() {
//                    @Override
//                    public Employee convert() {
//                        return super.convert();
//                    }
//                };
//                user.setResume(resume);
//
//                //Application
//                application.users.add(user); // ???
//
//                testFile.readLine(); //linie de diferentiere
//            }
//
//            for(int i = 0; i < numberOfUsers; i++){
//                // ArrayList Aquaintance
//                //lista de cunostinte --- DE MODIFICAT SI FACUT GRAF
//                String aquaintancesLine = testFile.readLine();
//                StringTokenizer stAquaintances = new StringTokenizer(aquaintancesLine, ";");
//                String firstName = stAquaintances.nextToken();
//                String lastName = stAquaintances.nextToken();
//                int numberOfAquaintances = Integer.parseInt(stAquaintances.nextToken());
//                User u = application.getUser(firstName,lastName);
//                ArrayList<Consumer> aquaintances = new ArrayList<>();
//                for ( int j = 0; j < numberOfAquaintances; j++){
//                    aquaintances.add(application.getUser(stAquaintances.nextToken(), stAquaintances.nextToken()));
//                }
//                application.getUser(firstName,lastName).setAquaintance(aquaintances); // buna??
//            }
//            testFile.readLine(); //linie de diferentiere
//
//            int numberOfCompanies = Integer.parseInt(testFile.readLine());
//            for (int i = 0; i < numberOfCompanies; i++){
//                StringTokenizer stCompanyInfo = new StringTokenizer(testFile.readLine(), ";");
//                int numberOfJobs = Integer.parseInt(stCompanyInfo.nextToken());
//                String companyName = stCompanyInfo.nextToken();
//                for (int j = 0; j < numberOfJobs; j++){
//                    //job
//                    Job job = new Job();
//                    job.setCompany(application.getCompany(companyName));
//                    String jobLine = testFile.readLine();
//                    StringTokenizer stJob = new StringTokenizer(jobLine, ";");
//                    job.setJobName(stJob.nextToken());
//                    int available = Integer.parseInt(stJob.nextToken());
//                    if (available == 1)
//                        job.setAvailable(true);
//                    else job.setAvailable(false);
//                    // Constraints
//                    Job.Constraint graduationYear = new Job.Constraint(Integer.parseInt(stJob.nextToken()), Integer.parseInt(stJob.nextToken()));
//                    job.setGraduation(graduationYear);
//                    Job.Constraint experience = new Job.Constraint(Integer.parseInt(stJob.nextToken()), Integer.parseInt(stJob.nextToken()));
//                    job.setExperience(experience);
//                    Job.Constraint academicAverage = new Job.Constraint(Integer.parseInt(stJob.nextToken()), Integer.parseInt(stJob.nextToken()));
//                    job.setAcademicAverage(academicAverage);
//                    job.setNumberOfEmployees(Integer.parseInt(stJob.nextToken()));
//                    job.setSalary(Integer.parseInt(stJob.nextToken()));
//                    // job fara applicants
//                    application.jobs.add(job);
//                }
//            }
//        }
//        catch(IOException | Education.InvalidDatesException | Experience.InvalidDatesException e){
//            e.printStackTrace();
//        }
//    }

    public Test(String filename) throws Exception {
        try{
            Application application = Application.getInstance();
            Application.companies = new ArrayList<>();
            Application.users = new ArrayList<>();
            Application.jobs = new ArrayList<>();

            FileReader reader = new FileReader(filename);
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(reader);
            for (Object o : (JSONArray)jsonObject.get("employees")){
                JSONObject empl = (JSONObject) o;
                // employee
                Employee employee = new Employee();
                // information
                Information information = new Information();
                String name = (String) empl.get("name");
                StringTokenizer stName = new StringTokenizer(name, " ");
                information.setFirstName(stName.nextToken());
                information.setLastName(stName.nextToken());
                information.setPhone((String)empl.get("phone"));
                information.setSex((String)empl.get("genre"));
                information.setEmail((String)empl.get("email"));
                ArrayList<Language> languages = new ArrayList<>();
                ArrayList<String> languagesName = new ArrayList<>();
                int countLanguages = 0;
                for (Object languageName : (JSONArray)empl.get("languages")){
                    languagesName.add((String)languageName);
                    countLanguages ++;
                }
                ArrayList<String> languagesLevel = new ArrayList<>();
                for(Object languageLevel : (JSONArray)empl.get("languages_level")){
                    languagesLevel.add((String)languageLevel);
                }
                for (int i = 0; i < countLanguages; i++){
                    languages.add(new Language(languagesName.get(i),languagesLevel.get(i)));
                }
                information.setKnownLanguages(languages);
                Vector<Education> educations = new Vector<>();
                for(Object ed : (JSONArray)empl.get("education")){
                    JSONObject educ = (JSONObject) ed;
                    Education education = new Education();
                    education.setFinalAverage(((Number) educ.get("grade")).doubleValue());
                    education.setLevel((String)educ.get("level"));
                    education.setInstitution((String)educ.get("name"));
                    String startDate = (String)educ.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    education.setStartDate(stDate);
                    String endDate = (String)educ.get("end_data");
                    Calendar endD = new Calendar();
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    education.setEndDate(endD);
                    educations.add(education);
                }
                Vector<Experience> experiences = new Vector<>();
                for (Object ex : (JSONArray)empl.get("experience")){
                    JSONObject exper = (JSONObject)ex;
                    Experience experience = new Experience();
                    String startDate = (String)exper.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    experience.setStartDate(stDate);
                    Calendar endD = new Calendar();
                    String endDate = (String)exper.get("end_date");
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    experience.setEndDate(endD);
                    experience.setPositon((String)exper.get("position"));
                    experience.setDepartment((String)exper.get("departament"));
                    Company company = new Company();
                    ArrayList<Department> departments = new ArrayList<>();
                    company.setDepartments(departments);
                    String typeOfDepartment = (String)exper.get("departament");
                    switch(typeOfDepartment){
                        case "IT":
                            IT newDepartment = new IT() {
                                @Override
                                public double getTotalSalaryBudget() {
                                    return super.getTotalSalaryBudget();
                                }
                            };
                            newDepartment.setName(typeOfDepartment);
                            newDepartment.employees = new ArrayList<>();
                            if(!company.contains(newDepartment))
                                company.add(newDepartment);
                        case "Management":
                            Management newDepartmentM = new Management() {
                                @Override
                                public double getTotalSalaryBudget() {
                                    return super.getTotalSalaryBudget();
                                }
                            };
                            newDepartmentM.setName(typeOfDepartment);
                            newDepartmentM.employees = new ArrayList<>();
                            if(!company.contains(newDepartmentM))
                                company.add(newDepartmentM);
                        case "Marketing":
                            Marketing newDepartmentMarketing = new Marketing() {
                                @Override
                                public double getTotalSalaryBudget() {
                                    return super.getTotalSalaryBudget();
                                }
                            };
                            newDepartmentMarketing.setName(typeOfDepartment);
                            newDepartmentMarketing.employees = new ArrayList<>();
                            if(!company.contains(newDepartmentMarketing))
                                company.add(newDepartmentMarketing);
                        case "Finance":
                            Finance newDepartmentF = new Finance() {
                                @Override
                                public double getTotalSalaryBudget() {
                                    return super.getTotalSalaryBudget();
                                }
                            };
                            newDepartmentF.setName(typeOfDepartment);
                            newDepartmentF.employees = new ArrayList<>();
                            if(!company.contains(newDepartmentF))
                                company.add(newDepartmentF);
                        case "HR":
                            Department newDep = new Department() {
                                @Override
                                public double getTotalSalaryBudget() {
                                    return 0;
                                }
                            };
                            newDep.setName(typeOfDepartment);
                            newDep.employees = new ArrayList<>();
                            if(!company.contains(newDep))
                                company.add(newDep);
                    }
                    company.setName((String)exper.get("company"));
                    if(!application.getCompanies().contains(company))
                        application.add(company);
                    experience.setCompany(company);
                    experiences.add(experience);
                }
                employee.companyName = experiences.lastElement().getCompany().getName();
                employee.salary = (double)((long)empl.get("salary"));
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(information)
                        .vectors(educations,experiences)
                        .build();
                employee.setResume(resume);
                application.companies.get(application.companies.size()-1).getDepartment(employee.getResume()
                .getExperience().lastElement().getDepartment()).add(employee);
                Job job = new Job();
                job.setSalary((int)employee.salary);
                job.setJobName(experiences.lastElement().getPositon());
                job.setCompany(experiences.lastElement().getCompany());
                if((!application.getJobsAll().contains(job)))
                    application.jobs.add(job);
            }

            for (Object o : (JSONArray)jsonObject.get("recruiters")){
                JSONObject recr = (JSONObject) o;
                // recruiters
                Recruiter recruiter = new Recruiter();
                // information
                Information information = new Information();
                String name = (String) recr.get("name");
                StringTokenizer stName = new StringTokenizer(name, " ");
                information.setFirstName(stName.nextToken());
                information.setLastName(stName.nextToken());
                information.setPhone((String)recr.get("phone"));
                information.setSex((String)recr.get("genre"));
                information.setEmail((String)recr.get("email"));
                ArrayList<Language> languages = new ArrayList<>();
                ArrayList<String> languagesName = new ArrayList<>();
                int countLanguages = 0;
                for (Object languageName : (JSONArray)recr.get("languages")){
                    languagesName.add((String)languageName);
                    countLanguages ++;
                }
                ArrayList<String> languagesLevel = new ArrayList<>();
                for(Object languageLevel : (JSONArray)recr.get("languages_level")){
                    languagesLevel.add((String)languageLevel);
                }
                for (int i = 0; i < countLanguages; i++){
                    languages.add(new Language(languagesName.get(i),languagesLevel.get(i)));
                }
                information.setKnownLanguages(languages);
                Vector<Education> educations = new Vector<>();
                for(Object ed : (JSONArray)recr.get("education")){
                    JSONObject educ = (JSONObject) ed;
                    Education education = new Education();
                    education.setFinalAverage(((Number) educ.get("grade")).doubleValue());
                    education.setLevel((String)educ.get("level"));
                    education.setInstitution((String)educ.get("name"));
                    String startDate = (String)educ.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    education.setStartDate(stDate);
                    String endDate = (String)educ.get("end_data");
                    Calendar endD = new Calendar();
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    education.setEndDate(endD);
                    educations.add(education);
                }
                Vector<Experience> experiences = new Vector<>();
                for (Object ex : (JSONArray)recr.get("experience")){
                    JSONObject exper = (JSONObject)ex;
                    Experience experience = new Experience();
                    String startDate = (String)exper.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    experience.setStartDate(stDate);
                    Calendar endD = new Calendar();
                    String endDate = (String)exper.get("end_date");
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    experience.setEndDate(endD);
                    experience.setPositon((String)exper.get("position"));
                    Company company = new Company();

                    company.setName((String)exper.get("company"));
                    if(!application.getCompanies().contains(company))
                        application.add(company);
                    experience.setCompany(company);
                    experiences.add(experience);
                }
                recruiter.companyName = experiences.lastElement().getCompany().getName();
                recruiter.salary = (double)((long)recr.get("salary"));
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(information)
                        .vectors(educations,experiences)
                        .build();
                recruiter.setResume(resume);
                Job job = new Job();
                job.setSalary((int)recruiter.salary);
                job.setJobName(experiences.lastElement().getPositon());
                job.setCompany(experiences.lastElement().getCompany());
                if((!application.getJobsAll().contains(job)))
                    application.jobs.add(job);
            }

            for (Object o : (JSONArray)jsonObject.get("users")){
                JSONObject userJson = (JSONObject) o;
                // users
                User user = new User();
                // information
                Information information = new Information();
                String name = (String) userJson.get("name");
                StringTokenizer stName = new StringTokenizer(name, " ");
                information.setFirstName(stName.nextToken());
                information.setLastName(stName.nextToken());
                information.setPhone((String)userJson.get("phone"));
                information.setSex((String)userJson.get("genre"));
                information.setEmail((String)userJson.get("email"));
                ArrayList<Language> languages = new ArrayList<>();
                ArrayList<String> languagesName = new ArrayList<>();
                int countLanguages = 0;
                for (Object languageName : (JSONArray)userJson.get("languages")){
                    languagesName.add((String)languageName);
                    countLanguages ++;
                }
                ArrayList<String> languagesLevel = new ArrayList<>();
                for(Object languageLevel : (JSONArray)userJson.get("languages_level")){
                    languagesLevel.add((String)languageLevel);
                }
                for (int i = 0; i < countLanguages; i++){
                    languages.add(new Language(languagesName.get(i),languagesLevel.get(i)));
                }
                information.setKnownLanguages(languages);
                Vector<Education> educations = new Vector<>();
                for(Object ed : (JSONArray)userJson.get("education")){
                    JSONObject educ = (JSONObject) ed;
                    Education education = new Education();
                    education.setFinalAverage(((Number) educ.get("grade")).doubleValue());
                    education.setLevel((String)educ.get("level"));
                    education.setInstitution((String)educ.get("name"));
                    String startDate = (String)educ.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    education.setStartDate(stDate);
                    String endDate = (String)educ.get("end_data");
                    Calendar endD = new Calendar();
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    education.setEndDate(endD);
                    educations.add(education);
                }
                Vector<Experience> experiences = new Vector<>();
                for (Object ex : (JSONArray)userJson.get("experience")){
                    JSONObject exper = (JSONObject)ex;
                    Experience experience = new Experience();
                    String startDate = (String)exper.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    experience.setStartDate(stDate);
                    Calendar endD = new Calendar();
                    String endDate = (String)exper.get("end_date");
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    experience.setEndDate(endD);
                    experience.setPositon((String)exper.get("position"));
                    Company company = new Company();

                    company.setName((String)exper.get("company"));
                    if(!application.getCompanies().contains(company))
                        application.add(company);
                    experience.setCompany(company);
                    experiences.add(experience);
                }
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(information)
                        .vectors(educations,experiences)
                        .build();
                user.setResume(resume);
                ArrayList<Company> intCompanies = new ArrayList<>();
                for (Object companies : (JSONArray)userJson.get("interested_companies")){
                    Company c;
                    c = application.getCompany((String)companies);
                    intCompanies.add(c);
                }
                user.setInterestedCompanies(intCompanies);
                Job job = new Job();
                job.setJobName(experiences.lastElement().getPositon());
                job.setCompany(experiences.lastElement().getCompany());
                if((!application.getJobsAll().contains(job)))
                    application.jobs.add(job);
                application.users.add(user);
            }

            for (Object o : (JSONArray)jsonObject.get("managers")){
                JSONObject manag = (JSONObject) o;
                // managers
                Manager manager = new Manager();
                // information
                Information information = new Information();
                String name = (String) manag.get("name");
                StringTokenizer stName = new StringTokenizer(name, " ");
                information.setFirstName(stName.nextToken());
                information.setLastName(stName.nextToken());
                information.setPhone((String)manag.get("phone"));
                information.setSex((String)manag.get("genre"));
                information.setEmail((String)manag.get("email"));
                ArrayList<Language> languages = new ArrayList<>();
                ArrayList<String> languagesName = new ArrayList<>();
                int countLanguages = 0;
                for (Object languageName : (JSONArray)manag.get("languages")){
                    languagesName.add((String)languageName);
                    countLanguages ++;
                }
                ArrayList<String> languagesLevel = new ArrayList<>();
                for(Object languageLevel : (JSONArray)manag.get("languages_level")){
                    languagesLevel.add((String)languageLevel);
                }
                for (int i = 0; i < countLanguages; i++){
                    languages.add(new Language(languagesName.get(i),languagesLevel.get(i)));
                }
                information.setKnownLanguages(languages);
                Vector<Education> educations = new Vector<>();
                for(Object ed : (JSONArray)manag.get("education")){
                    JSONObject educ = (JSONObject) ed;
                    Education education = new Education();
                    education.setFinalAverage(((Number) educ.get("grade")).doubleValue());
                    education.setLevel((String)educ.get("level"));
                    education.setInstitution((String)educ.get("name"));
                    String startDate = (String)educ.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    education.setStartDate(stDate);
                    String endDate = (String)educ.get("end_data");
                    Calendar endD = new Calendar();
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    education.setEndDate(endD);
                    educations.add(education);
                }
                Vector<Experience> experiences = new Vector<>();
                for (Object ex : (JSONArray)manag.get("experience")){
                    JSONObject exper = (JSONObject)ex;
                    Experience experience = new Experience();
                    String startDate = (String)exper.get("start_date");
                    StringTokenizer stStartDate = new StringTokenizer(startDate, ".");
                    Calendar stDate = new Calendar();
                    stDate.setDay(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setMonth(Integer.parseInt(stStartDate.nextToken()));
                    stDate.setYear(Integer.parseInt(stStartDate.nextToken()));
                    experience.setStartDate(stDate);
                    Calendar endD = new Calendar();
                    String endDate = (String)exper.get("end_date");
                    if(endDate != null){
                        StringTokenizer stEndDate = new StringTokenizer(endDate, ".");
                        endD.setDay(Integer.parseInt(stEndDate.nextToken()));
                        endD.setMonth(Integer.parseInt(stEndDate.nextToken()));
                        endD.setYear(Integer.parseInt(stEndDate.nextToken()));
                    } else endD = null;
                    experience.setEndDate(endD);
                    experience.setPositon((String)exper.get("position"));
                    Company company = new Company();

                    company.setName((String)exper.get("company"));
                    if(!application.getCompanies().contains(company))
                        application.add(company);
                    experience.setCompany(company);
                    experiences.add(experience);
                }
                manager.companyName = experiences.lastElement().getCompany().getName();
                manager.salary = (double)((long)manag.get("salary"));
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(information)
                        .vectors(educations,experiences)
                        .build();
                manager.setResume(resume);
                Job job = new Job();
                job.setSalary((int)manager.salary);
                job.setJobName(experiences.lastElement().getPositon());
                job.setCompany(experiences.lastElement().getCompany());
                if((!application.getJobsAll().contains(job)))
                    application.jobs.add(job);
            }
        }  catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test("consumers.json");
        //test.load();
    }
}
