import netscape.javascript.JSObject;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.*;

public class Test {

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
                            if(company.getDepartment(newDepartment.getName()) == null)
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
                            if(company.getDepartment(newDepartmentM.getName()) == null)
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
                            if(company.getDepartment(newDepartmentMarketing.getName()) == null)
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
                            if(company.getDepartment(newDepartmentF.getName()) == null)
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
                            if(company.getDepartment(newDep.getName()) == null)
                                company.add(newDep);
                    }
                    company.setName((String)exper.get("company"));
                    if(!application.getCompanies().contains(company))
                        application.add(company);
                    else
                        application.getCompany(company.getName()).setDepartments(company.getDepartments());
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
                    // recruiters list
                    // ce naiba ai????
                    //ArrayList<Recruiter> recruiters = new ArrayList<>();
                    //company.setRecruiters(recruiters);
                    company.setName((String)exper.get("company"));
                    if(!application.getCompanies().contains(company))
                        application.add(company);
                    //else
                    //    application.getCompanies().get(application.getCompanies().indexOf(company)).setRecruiters(recruiters);
                    experience.setCompany(company);
                    experiences.add(experience);
                }
                recruiter.companyName = experiences.lastElement().getCompany().getName();
                recruiter.salary = (double)((long)recr.get("salary"));
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder(information)
                        .vectors(educations,experiences)
                        .build();
                recruiter.setResume(resume);
                // se adauga recruiterul?
                experiences.lastElement().getCompany().add(recruiter);
                if (experiences.lastElement().getCompany().contains(recruiter)){
                    System.out.println("da, contine recriuter - ul compania respectiva");
                }
                // de ce nu adauga recruiter aici???
                Job job = new Job();
                job.setSalary((int)recruiter.salary);
                job.setJobName(experiences.lastElement().getPositon());
                job.setCompany(experiences.lastElement().getCompany());
                if((!application.getJobsAll().contains(job))){
                    application.jobs.add(job);
                    System.out.println("da, am adaugat job - ul");

                }
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
                experiences.lastElement().getCompany().setManager(manager);
                Job job = new Job();
                job.setSalary((int)manager.salary);
                job.setJobName(experiences.lastElement().getPositon());
                job.setCompany(experiences.lastElement().getCompany());
                if((!application.getJobsAll().contains(job)))
                    application.jobs.add(job);
            }

            final String test = new String("src\\Acquaintances.txt");
            RandomAccessFile testFile = new RandomAccessFile(test, "r");
            int numberOfCategories = Integer.parseInt(testFile.readLine());
            for (int i = 0;  i < numberOfCategories; i++){
                String consumerInfo = testFile.readLine();
                StringTokenizer stConsumerIfo = new StringTokenizer(consumerInfo, ";");
                String typeOfConsumer = stConsumerIfo.nextToken();
                int numberOfConsumers = Integer.parseInt(stConsumerIfo.nextToken());
                switch (typeOfConsumer){
                    case "employees":
                        for (int j = 0; j < numberOfConsumers; j++){
                            String emplInfo = testFile.readLine();
                            StringTokenizer stEmployeeInfo = new StringTokenizer(emplInfo, ";");
                            String firstName = stEmployeeInfo.nextToken();
                            String lastName = stEmployeeInfo.nextToken();
                            int numberOfAcquaintanes = Integer.parseInt(stEmployeeInfo.nextToken());
                          //  System.out.println("firstName " +firstName + " lastName " + lastName + numberOfAcquaintanes);

                            if (numberOfAcquaintanes > 0){
                                for(Company c : application.getCompanies()){
                                    for (Department d : c.getDepartments()){
                                        for (Employee e : d.getEmployees()) {
                                            if (d.findEmployee(firstName,lastName) != null) {
                                                // am gasit employee-ul
                                                for (int k = 0; k < numberOfAcquaintanes; k++) {
                                                    String firstNameAcq = stEmployeeInfo.nextToken();
                                                    String lastNameAcq = stEmployeeInfo.nextToken();
                                                    // daca are prieteni employee
                                                    for (Company co : application.getCompanies()) {
                                                        for (Department de : co.getDepartments()) {
                                                            if (de.findEmployee(firstNameAcq, lastNameAcq) != null) {
                                                                d.findEmployee(firstName, lastName).add(de.findEmployee(firstNameAcq, lastNameAcq));
                                                            }
                                                            //adaugam la employee-ul gasit prietenul employee
                                                        }
                                                    }
                                                    // daca are prieteni user
                                                    if (application.findUser(firstNameAcq, lastNameAcq) != null) {
                                                        d.findEmployee(firstName, lastName).add(application.findUser(firstNameAcq, lastNameAcq));
                                                        // adaugam la employee prietenul user
                                                    }
                                                    //daca are prieteni recruiteri
                                                    for (Company comp : application.getCompanies()) {
                                                        if (comp.findRecruiter(firstNameAcq, lastNameAcq) != null) {
                                                            d.findEmployee(firstName, lastName).add(comp.findRecruiter(firstNameAcq, lastNameAcq));
                                                        }
                                                        // adaugam la employee ul gasit prietenul recruiter
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "recruiters":
                        for (int j = 0; j < numberOfConsumers; j++){
                            String recrInfo = testFile.readLine();
                            StringTokenizer stRecruiterInfo = new StringTokenizer(recrInfo, ";");
                            String firstName = stRecruiterInfo.nextToken();
                            String lastName = stRecruiterInfo.nextToken();
                            int numberOfAcquaintanes = Integer.parseInt(stRecruiterInfo.nextToken());
                            for (Company c : application.getCompanies()){
                                if (c.findRecruiter(firstName,lastName) != null){
                                    // am gasit recruiter-ul
                                    for (int k = 0; k < numberOfAcquaintanes; k ++){
                                        String firstNameAcq = stRecruiterInfo.nextToken();
                                        String lastNameAcq = stRecruiterInfo.nextToken();
                                        // daca are prieteni employee
                                        for(Company co : application.getCompanies()){
                                            for (Department de : co.getDepartments()){
                                                if(de.findEmployee(firstNameAcq,lastNameAcq) != null){
                                                    c.findRecruiter(firstName,lastName).add(de.findEmployee(firstNameAcq,lastNameAcq));
                                                }
                                                //adaugam la recruiter-ul gasit prietenul employee
                                            }
                                        }
                                        // daca are prieteni user
                                        if (application.findUser(firstNameAcq,lastNameAcq) != null){
                                            c.findRecruiter(firstName,lastName).add(application.findUser(firstNameAcq,lastNameAcq));
                                            // adaugam la recruiter-ul gasit prietenul user
                                        }
                                        //daca are prieteni recruiteri
                                        for(Company comp : application.getCompanies()){
                                            if(comp.findRecruiter(firstNameAcq,lastNameAcq) != null){
                                                c.findRecruiter(firstName,lastName).add(comp.findRecruiter(firstNameAcq,lastNameAcq));
                                            }
                                            // adaugam la recruiter ul gasit prietenul recruiter
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    case "users":
                        for (int j = 0; j < numberOfConsumers; j++) {
                            String userInfo = testFile.readLine();
                            StringTokenizer stUserInfo = new StringTokenizer(userInfo, ";");
                            String firstName = stUserInfo.nextToken();
                            String lastName = stUserInfo.nextToken();
                            int numberOfAcquaintanes = Integer.parseInt(stUserInfo.nextToken());
                            if(application.findUser(firstName,lastName) != null){
                                // daca am gasit user-ul
                                for (int k = 0; k < numberOfAcquaintanes; k ++) {
                                    String firstNameAcq = stUserInfo.nextToken();
                                    String lastNameAcq = stUserInfo.nextToken();
                                    // daca are prieteni employee
                                    for(Company co : application.getCompanies()){
                                        for (Department de : co.getDepartments()){
                                            if(de.findEmployee(firstNameAcq,lastNameAcq) != null){
                                                application.findUser(firstName,lastName).add(de.findEmployee(firstNameAcq,lastNameAcq));
                                            }
                                            //adaugam la user-ul gasit prietenul employee
                                        }
                                    }
                                    // daca are prieteni user
                                    if (application.findUser(firstNameAcq,lastNameAcq) != null){
                                        application.findUser(firstName,lastName).add(application.findUser(firstNameAcq,lastNameAcq));
                                        // adaugam la recruiter-ul gasit prietenul user
                                    }
                                    //daca are prieteni recruiteri
                                    for(Company comp : application.getCompanies()){
                                        if(comp.findRecruiter(firstNameAcq,lastNameAcq) != null){
                                            application.findUser(firstName,lastName).add(comp.findRecruiter(firstNameAcq,lastNameAcq));
                                        }
                                        // adaugam la recruiter ul gasit prietenul recruiter
                                    }
                                }
                            }
                        }
                        break;
                    //testFile.readLine();
                }
            }

            // introducem job-urile disponibile
            final String testJob = new String("src\\Jobs.txt");
            RandomAccessFile testFileJob = new RandomAccessFile(testJob, "r");
            int numberOfCompanies = Integer.parseInt(testFileJob.readLine());
            for (int i = 0; i < numberOfCompanies; i++){
                String companyInfo = testFileJob.readLine();
                StringTokenizer stCompanyInfo = new StringTokenizer(companyInfo, ";");
                String companyName = stCompanyInfo.nextToken();
                String depName = testFileJob.readLine();
                int numberOfJobs = Integer.parseInt(stCompanyInfo.nextToken());
                for (Company company : application.getCompanies()){
                    if(company.getName().equals(companyName)){
                        for (Department department : company.getDepartments()){
                            if(department.getName().equals(depName)){
                                for(int j = 0; j < numberOfJobs; j++){
                                    String jobInfo = testFileJob.readLine();
                                    StringTokenizer stJobInfo = new StringTokenizer(jobInfo, ";");
                                    String jobName = stJobInfo.nextToken();
                                    if(department.findJob(jobName) != null) {
                                        if (Integer.parseInt(stJobInfo.nextToken()) == 1) {
                                            department.findJob(jobName).setAvailable(true);
                                        } else
                                            department.findJob(jobName).setAvailable(false);
                                        department.findJob(jobName).setNumberOfEmployees(Integer.parseInt(stJobInfo.nextToken()));
                                        Job.Constraint gradYear = new Job.Constraint(Integer.parseInt(stJobInfo.nextToken()),
                                                Integer.parseInt(stJobInfo.nextToken()));
                                        department.findJob(jobName).setGraduation(gradYear);
                                        Job.Constraint experience = new Job.Constraint(Integer.parseInt(stJobInfo.nextToken()),
                                                Integer.parseInt(stJobInfo.nextToken()));
                                        department.findJob(jobName).setExperience(experience);
                                        Job.Constraint average = new Job.Constraint(Double.parseDouble(stJobInfo.nextToken()),
                                                Double.parseDouble(stJobInfo.nextToken()));
                                        department.findJob(jobName).setAcademicAverage(average);
                                    }
                                    else{
                                        Job newJob = new Job();
                                        newJob.setJobName(jobName);
                                        int available = Integer.parseInt(stJobInfo.nextToken());
                                        if (available == 1) {
                                            newJob.setAvailable(true);
                                        } else
                                            newJob.setAvailable(false);
                                        int nrOfEmployees = Integer.parseInt(stJobInfo.nextToken());
                                        newJob.setNumberOfEmployees(nrOfEmployees);
                                        Job.Constraint gradYear = new Job.Constraint(Integer.parseInt(stJobInfo.nextToken()),
                                                Integer.parseInt(stJobInfo.nextToken()));
                                        newJob.setGraduation(gradYear);
                                        Job.Constraint experience = new Job.Constraint(Integer.parseInt(stJobInfo.nextToken()),
                                                Integer.parseInt(stJobInfo.nextToken()));
                                        newJob.setExperience(experience);
                                        Job.Constraint average = new Job.Constraint(Double.parseDouble(stJobInfo.nextToken()),
                                                Double.parseDouble(stJobInfo.nextToken()));
                                        newJob.setAcademicAverage(average);
                                        newJob.setCompany(company);
                                        department.add(newJob);
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }

            // userii care aplica
            System.out.println("nu exista recruiteri aici in companie");
            ArrayList<Job> availableJobs = new ArrayList<>();
            for (User user : application.users){

                ArrayList<String> companiesName = new ArrayList<>();
                for (Company c : user.getInterestedCompanies()){
                    companiesName.add(c.getName());
                }
                availableJobs = application.getJobs(companiesName);
                for (Job job : availableJobs){
                    for ( Recruiter r : job.getCompany().getRecruiters()){
                        System.out.println(" avem recruiteri");  //nu n avem
                        // de ce nu avem recruiteri in companii?!?!?!?
                    }
                    //TODO: ce naiba are functia de apply???
                    job.apply(user);
                    job.getCompany().getManager().process(job);
                    // is good???
                    //TODO: verifica daca astia aplica la job
                    //TODO: verifica request-urile daca sunt trimise
                }
            }

        }  catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
    //TODO: fisiser pentru aplicarea userilor

    public static void main(String[] args) throws Exception {
        Test test = new Test("consumers.json");
    }
}
