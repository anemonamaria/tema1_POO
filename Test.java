import java.util.ArrayList;
 import java.util.Vector;

public class Test {
    public static void main(String[] args) {
//        Consumer consumer1 = new Consumer() {
//            @Override
//            public void add(Consumer consumer) {
//                super.add(consumer);
//            }
//        };
//        Consumer consumer2 = new Consumer() {
//            @Override
//            public void add(Consumer consumer) {
//                super.add(consumer);
//            }
//        };
//        Consumer consumer3 = new Consumer() {
//            @Override
//            public void add(Consumer consumer) {
//                super.add(consumer);
//            }
//        };
//        Consumer consumer4 = new Consumer() {
//            @Override
//            public void add(Consumer consumer) {
//                super.add(consumer);
//            }
//        };
//        Consumer consumer5 = new Consumer() {
//            @Override
//            public void add(Consumer consumer) {
//                super.add(consumer);
//            }
//        };
//
//        Calendar data = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data1 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data2 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data3 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data4 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data5 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data6 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data7 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data8 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data9 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data10 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data11 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//        Calendar data12 = new Calendar() {
//            @Override
//            protected void computeTime() {
//
//            }
//
//            @Override
//            protected void computeFields() {
//
//            }
//
//            @Override
//            public void add(int field, int amount) {
//
//            }
//
//            @Override
//            public void roll(int field, boolean up) {
//
//            }
//
//            @Override
//            public int getMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getMaximum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getGreatestMinimum(int field) {
//                return 0;
//            }
//
//            @Override
//            public int getLeastMaximum(int field) {
//                return 0;
//            }
//        };
//
//        data.set(2001, 12, 10);
//        data2.set(1998, 5, 16);
//        data1.set(1974, 3, 20);
//        data3.set(1980, 10, 30);
//        data4.set(2003, 8, 25);
//        data5.set(1956, 11, 8);
//        data6.set(1965, 2, 13);
//        data7.set(2008, 1, 12);
//        data8.set(2009, 8, 14);
//        data9.set(2012, 7, 15);
//        data10.set(2010, 6, 23);
//        data11.set(2014, 5, 18);
//        data12.set(2015, 4, 23);
//        System.out.println(data1.YEAR);
//
//        Information info1 = new Information("Ana", "Popescu");
//        info1.setBirthday(data);
//        info1.setEmail("ana@mail.com");
//        info1.setPhone("12345678");
//        info1.setSex("female");
//        Information info2 = new Information("Mihai", "Po");
//        info2.setBirthday(data2);
//        info2.setEmail("mihai@mail.com");
//        info2.setPhone("12345678");
//        info2.setSex("male");
//        Information info3 = new Information("Ane", "Ionescu");
//        info3.setBirthday(data3);
//        info3.setEmail("ane@mail.com");
//        info3.setPhone("12345678");
//        info3.setSex("female");
//        Information info4 = new Information("Cris", "Totescu");
//        info4.setBirthday(data4);
//        info4.setEmail("cris@mail.com");
//        info4.setPhone("12345678");
//        info4.setSex("female");
//        Information info5 = new Information("Ion", "Escu");
//        info5.setBirthday(data5);
//        info5.setEmail("ion@mail.com");
//        info5.setPhone("12345678");
//        info5.setSex("male");
//
//        Language lang1 = new Language("ARABA", "BEGGINER");
//        Language lang2 = new Language("ROMANA", "ADVANCED");
//        Language lang3 = new Language("ENGLEZA", "EXPERIENCED");
//        Language lang4 = new Language("FRANCEZA", "BEGGINER");
//        Language lang5 = new Language("GERMANA", "ADVANCED");
//
//        ArrayList<Language> listLang1 = new ArrayList<>();
//        listLang1.add(lang1);
//        listLang1.add(lang4);
//        listLang1.add(lang3);
//        listLang1.add(lang2);
//        ArrayList<Language> listLang2 = new ArrayList<>();
//        listLang2.add(lang2);
//        listLang2.add(lang4);
//        listLang2.add(lang3);
//        listLang2.add(lang5);
//        ArrayList<Language> listLang3 = new ArrayList<>();
//        listLang3.add(lang1);
//        listLang3.add(lang4);
//        listLang3.add(lang3);
//        listLang3.add(lang2);
//        ArrayList<Language> listLang4 = new ArrayList<>();
//        listLang4.add(lang1);
//        listLang4.add(lang4);
//        listLang4.add(lang3);
//        listLang4.add(lang2);
//        ArrayList<Language> listLang5 = new ArrayList<>();
//        listLang5.add(lang1);
//        listLang5.add(lang4);
//        listLang5.add(lang3);
//        listLang5.add(lang2);
//        ArrayList<Language> listLang6 = new ArrayList<>();
//        listLang6.add(lang1);
//        listLang6.add(lang4);
//        listLang6.add(lang3);
//        listLang6.add(lang2);
//
//        info1.setKnownLanguages(listLang1);
//        info2.setKnownLanguages(listLang2);
//        info3.setKnownLanguages(listLang3);
//        info4.setKnownLanguages(listLang4);
//        info5.setKnownLanguages(listLang5);
//
//        Experience experience1 = new Experience();
//        experience1.setCompany(null); ////????? baga
//        experience1.setEndDate(data4);
//        experience1.setStartDate(data);
//        experience1.setPositon("ceo");
//
//        Experience experience2 = new Experience();
//        experience2.setCompany(null); ////????? baga
//        experience2.setEndDate(data4);
//        experience2.setStartDate(data);
//        experience2.setPositon("ceo");
//
//        Vector<Experience> experienceVector = new Vector<>();
//        experienceVector.add(experience1);
//        experienceVector.add(experience2);
//
//        Education education1 = new Education();
//        education1.setEndDate(data1);
//        education1.setStartDate(data5);
//        education1.setFinalAverage(10.00);
//        education1.setInstitution("liceu");
//        education1.setLevel("avansat");
//
//        Education education2 = new Education();
//        education2.setEndDate(data1);
//        education2.setStartDate(data5);
//        education2.setFinalAverage(8.00);
//        education2.setInstitution("scoala");
//        education2.setLevel("avansat");
//
//        Vector<Education> educationVector = new Vector<>();
//        educationVector.add(education1);
//        educationVector.add(education2);
//
//        Consumer.Resume resume;
//        resume = new Consumer.Resume();
//        resume.setInformation(info1);
//        resume.experience = experienceVector;
//        resume.education = educationVector;
//
//        consumer1.resume = resume;
    }
}
