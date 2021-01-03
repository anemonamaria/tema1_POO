import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class ProfilePage extends JFrame {

    public ProfilePage(String title){
        super(title);

        this.setSize(1100, 600);
        setLayout(new BorderLayout());

        JPanel userPanel = new JPanel();
        JPanel infoPanel = new JPanel();
        JButton showInfo = new JButton("Show user information");
        JTextField firstName = new JTextField(20);
        JTextField lastName = new JTextField(20);
        userPanel.add(new Label("User's first name: "));
        userPanel.add(firstName);
        userPanel.add(new Label("User's last name; "));
        userPanel.add(lastName);
        userPanel.setSize(300,200);
        userPanel.setVisible(true);
        userPanel.setBackground(new Color(229,204,255));
        showInfo.setBackground(new Color(102,0,102));
        showInfo.setForeground(new Color(255,255,255));
        userPanel.add(showInfo);

        add(userPanel);
        revalidate();


        revalidate();
        showInfo.addActionListener(e -> {
            Object source = e.getSource();
            if(userPanel.isVisible()){
                userPanel.setVisible(false);
            }
            if(source instanceof  JButton){
                revalidate();
                //System.out.println(firstName.getText() + " " + lastNameString.get() + "aaaaaaaaa");
                String firstNameUser = firstName.getText();
                String lastNameUser = lastName.getText();
                Consumer.Resume foundResume = null;
                for(User u : Application.getInstance().getUsers()){
                    if(u.getResume().getInformation().getFirstName().equals(firstNameUser) && u.getResume().getInformation().getLastName().equals(lastNameUser)){
                        foundResume = u.getResume();
                        break;
                    }
                }
                JTextField email = new JTextField("User's email: " + foundResume.getInformation().getEmail());
                JTextField phone = new JTextField("User's phone: " + foundResume.getInformation().getPhone());
                JTextField sex = new JTextField("User's gender: " + foundResume.getInformation().getSex());
                JTextField bday = new JTextField("User's birthday: " + foundResume.getInformation().getBirthday().getDay() + "." +
                        foundResume.getInformation().getBirthday().getMonth() + "." +
                        foundResume.getInformation().getBirthday().getYear());
                JList<String> knownLanguages = new JList<>();
                for(Language l : foundResume.getInformation().getKnownLanguages()){
                    knownLanguages.add(new Label(l.getName() + " level " + l.getLevel()));
                }

                String column[] = {"Institution", "Level", "Start date", "End date", "Final average"};
                String dataForEducation[][] = new String[foundResume.getEducation().size()][5];
                int j = 0;
                for(Education edu : foundResume.getEducation()){
                    dataForEducation[j][0] = edu.getInstitution();
                    dataForEducation[j][1] = edu.getLevel();
                    dataForEducation[j][2] = edu.getStartDate().getDay() + "." + edu.getStartDate().getMonth() +
                    "." + edu.getStartDate().getYear();
                    dataForEducation[j][3] = edu.getEndDate().getDay() + "." + edu.getEndDate().getMonth() +
                            "." + edu.getEndDate().getYear();
                    dataForEducation[j][4] = String.valueOf(edu.getFinalAverage());
                    j++;
                }
                JTable educationTable = new JTable(dataForEducation, column);
                educationTable.setBounds(30,40,200,300);

                String columnExp[] = {"Company", "Position", "Department", "Start date", "End date"};
                String dataForExperience[][] = new String[foundResume.getExperience().size()][5];
                int k = 0;
                for(Experience exp : foundResume.getExperience()){
                    dataForExperience[k][0] = exp.getCompany().getName();
                    dataForExperience[k][1] = exp.getPositon();
                    dataForExperience[k][2] = exp.getDepartment();
                    dataForExperience[k][3] = exp.getStartDate().getDay() + "." + exp.getStartDate().getMonth() +
                            "." + exp.getStartDate().getYear();
                    dataForExperience[k][4] = exp.getEndDate().getDay() + "." + exp.getEndDate().getMonth() +
                            "." + exp.getEndDate().getYear();
                    k++;
                }
                JTable expTable = new JTable(dataForExperience, columnExp);
                expTable.setBounds(30,40,200,300);

                //todo introdu astea pe un panel si afiseaza-l cand se apasa butonul
            }
        });
        show();

    }
}
