import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.border.*;

public class AdminPage extends JFrame {

    public AdminPage(String title){
        super(title);
        this.setSize(1100, 600);
        setLayout(new BorderLayout());

        JButton compButton = new JButton("Companies");
        JButton  userButton = new JButton("Users");

        compButton.setBackground(new Color(0,0,102));
        compButton.setForeground(Color.WHITE);
        userButton.setBackground(new Color(0,0,102));
        userButton.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        buttonPanel.setBorder( new EmptyBorder(0, 0, 0, 0) );
        buttonPanel.setOpaque( false );

        JButton button = new JButton("Button ");
        button.setPreferredSize( new Dimension(100, 100) );
        buttonPanel.add(compButton, BorderLayout.WEST);
        buttonPanel.add(userButton, BorderLayout.WEST);

        setBackground(new Color(204,204,255));
        add(buttonPanel, BorderLayout.WEST);
        JPanel tabelPanelUsers = new JPanel();
        JPanel tabelPanelCompanies = new JPanel();
        AtomicReference<JPanel> tabelPanelDepartments = new AtomicReference<>(new JPanel());
        AtomicReference<JPanel> tabelPanelEmployees = new AtomicReference<>(new JPanel());
        AtomicReference<JPanel> tabelPanelJobs = new AtomicReference<>(new JPanel());
        AtomicReference<JPanel> tabelPanelSalary = new AtomicReference<>(new JPanel());


        final int[] auxUsers = {0};
        final int[] auxCompanies = {0};
        final int[] auxDepartments = {0};
        final int[] auxSalary = {0};
        userButton.addActionListener(e -> {
            Object source = e.getSource();
            if(tabelPanelCompanies.isVisible() || tabelPanelSalary.get().isVisible() || tabelPanelJobs.get().isVisible() || tabelPanelDepartments.get().isVisible() || tabelPanelEmployees.get().isVisible()){//
                tabelPanelCompanies.setVisible(false);
                tabelPanelDepartments.get().setVisible(false);
                tabelPanelEmployees.get().setVisible(false);
                tabelPanelJobs.get().setVisible(false);
                tabelPanelSalary.get().setVisible(false);
            }
            if(source instanceof JButton && auxUsers[0] == 0) {

                revalidate();
                auxUsers[0] = 1;
                JTextField message = new JTextField("List of users");
                add(message);//.setBounds(30,45,10,10); // todo muta la locatia buna
                int numberOfUsers = Application.getUsers().size();
                String column[] = {"FIRST NAME","LAST NAME"};
                String data[][] = new String[numberOfUsers][2];
                int i = 0;
                for(User u : Application.getUsers()){
                    data[i][0] = u.getResume().getInformation().getFirstName();
                    data[i][1] = u.getResume().getInformation().getLastName();
                    i++;
                }
                JTable jt = new JTable(data,column);
                jt.setBounds(30,40,200,300);
                JScrollPane sp = new JScrollPane(jt);
                tabelPanelUsers.add(sp);
                tabelPanelUsers.setSize(300,200);
                tabelPanelUsers.setVisible(true);
                tabelPanelUsers.setBackground(new Color(255,255,204));

                add(tabelPanelUsers);
                revalidate();
            }
            if(auxUsers[0] != 0){
                tabelPanelUsers.setVisible(true);
            }
        });


        compButton.addActionListener(e -> {
            Object source = e.getSource();
            if(tabelPanelUsers.isVisible() || tabelPanelSalary.get().isVisible() || tabelPanelJobs.get().isVisible() || tabelPanelDepartments.get().isVisible() || tabelPanelEmployees.get().isVisible()){
                tabelPanelUsers.setVisible(false);
                tabelPanelDepartments.get().setVisible(false);
                tabelPanelEmployees.get().setVisible(false);
                tabelPanelJobs.get().setVisible(false);
                tabelPanelSalary.get().setVisible(false);

            }
            if(source instanceof JButton && auxCompanies[0] == 0){

                revalidate();
                auxCompanies[0] = 1;
                JTextField message = new JTextField("List of companies");
                add(message);//.setBounds(30,45,10,10); // todo muta la locatia buna
                JButton showDeps = new JButton("Show departments");
                showDeps.setBackground(new Color(255,128,0));
                showDeps.setForeground(Color.WHITE);
                int numberOfCompanies = Application.companies.size();
                String column[] = {"Company name"};
                String data[] = new String[numberOfCompanies];
                int i = 0;
                for(Company c : Application.companies){
                    data[i] = c.getName();
                    i++;
                }
                JList<String> jList = new JList<>(data);
                jList.setBounds(30,40,200,300);
                JScrollPane sp = new JScrollPane(jList);
                tabelPanelCompanies.add(sp);
                tabelPanelCompanies.add(showDeps);
                tabelPanelCompanies.setSize(300,400);
                tabelPanelCompanies.setVisible(true);
                tabelPanelCompanies.setBackground(new Color(255,255,204));

                add(tabelPanelCompanies);
                revalidate();

                showDeps.addActionListener(e1 -> {
                    Object source1 = e1.getSource();
                    if(source1 instanceof JButton && auxDepartments[0] == 0){
                        if(jList.getSelectedIndex() >= 0 ){  //todo
                            int index = jList.getSelectedIndex();
                            tabelPanelDepartments.set(new JPanel());
                            String companyName = (String) jList.getSelectedValue(); // am retinut numele companiei
                            int numberOfDepartments = Application.getInstance().getCompany(companyName).getDepartments().size();

                            if(numberOfDepartments != 0) {//Application.getInstance().getCompany(companyName) != null &&
                                String dataForDepartments[] = new String[numberOfDepartments];
                                int j = 0;
                                JButton showEmployees = new JButton("Show employees");
                                showEmployees.setBackground(new Color(255,128,0));
                                showEmployees.setForeground(Color.WHITE);
                                JButton showJobs = new JButton("Show jobs");
                                showJobs.setBackground(new Color(255,128,0));
                                showJobs.setForeground(Color.WHITE);
                                JButton showSalary = new JButton("Show salary");
                                showSalary.setBackground(new Color(255,128,0));
                                showSalary.setForeground(Color.WHITE);
                                System.out.println("departamente " + numberOfDepartments + " index " + index) ;
                                for (Department d : Application.getInstance().getCompany(companyName).getDepartments()) {
                                    dataForDepartments[j] = d.getName();
                                    System.out.println(" dep de adaugat "+dataForDepartments[j]);
                                    j++;
                                }

                                JList<String> jListDepart = new JList<>(dataForDepartments);

                                jListDepart.setBounds(30, 40, 200, 300);
                                JScrollPane sPaneDep = new JScrollPane(jListDepart);
                                tabelPanelDepartments.get().add(sPaneDep);
                                tabelPanelDepartments.get().setSize(300, 400);
                                tabelPanelDepartments.get().setVisible(true);
                                tabelPanelDepartments.get().setBackground(new Color(255, 255, 204));
                                tabelPanelDepartments.get().add(showSalary);
                                tabelPanelDepartments.get().add(showEmployees);
                                tabelPanelDepartments.get().add(showJobs);
                                tabelPanelCompanies.setVisible(false);

                                add(tabelPanelDepartments.get());
                                revalidate();
                                showEmployees.addActionListener(e2 -> {
                                    Object source2 = e2.getSource();
                                    if (source2 instanceof JButton ) {
                                        if(jListDepart.getSelectedIndex() >= 0 ){
                                            tabelPanelEmployees.set(new JPanel());
                                            String departmentName = (String) jListDepart.getSelectedValue(); // am retinut numele departamentului
                                            int numberOfEmployees = Application.getInstance().getCompany(companyName).getDepartment(departmentName).getEmployees().size();
                                            if(numberOfEmployees != 0){
                                                String newDataNameE[] = new String[numberOfEmployees];
                                                int l = 0;
                                                for (Employee employ : Application.getInstance().getCompany(companyName).getDepartment(departmentName).getEmployees()) {
                                                    newDataNameE[l] = new String(employ.getResume().getInformation().getFirstName() + " " + employ.getResume().getInformation().getLastName() );
                                                    l++;
                                                }

                                                JList<String> jLEmplNames = new JList<>(newDataNameE);
                                                jLEmplNames.setBounds(30, 40, 200, 300);
                                                JScrollPane sPaneEmpl = new JScrollPane(jLEmplNames);
                                                tabelPanelEmployees.get().add(sPaneEmpl);
                                                tabelPanelEmployees.get().setSize(300, 400);
                                                tabelPanelEmployees.get().setVisible(true);
                                                tabelPanelEmployees.get().setBackground(new Color(204, 255, 204));  //todo de ce nu aapri?
                                                tabelPanelDepartments.get().setVisible(false);

                                                add(tabelPanelEmployees.get());
                                                revalidate();

                                            } else {

                                                tabelPanelEmployees.get().add(new Label("This department has no employees yet.")).setBackground(new Color(255,0,0));
                                                tabelPanelEmployees.get().setSize(300, 400);
                                                tabelPanelEmployees.get().setVisible(true);
                                                tabelPanelEmployees.get().setBackground(new Color(204, 255, 204));
                                                tabelPanelDepartments.get().setVisible(false);
                                                add(tabelPanelEmployees.get());
                                                revalidate();
                                            }

                                        }
                                    }
                                });

                                showSalary.addActionListener(e4 -> {
                                    Object source4 = e4.getSource();
                                    if (source4 instanceof JButton ) {
                                        if(jListDepart.getSelectedIndex() >= 0 ){
                                            tabelPanelSalary.set(new JPanel());
                                            String departmentName = (String) jListDepart.getSelectedValue(); // am retinut numele departamentului
                                            double salaryBudget = Application.getInstance().getCompany(companyName).getDepartment(departmentName).getTotalSalaryBudget();
                                            if(salaryBudget != (double)0){
                                                tabelPanelSalary.get().add(new Label("Total salary budget is " + salaryBudget));
                                                tabelPanelSalary.get().setSize(300, 400);
                                                tabelPanelSalary.get().setVisible(true);
                                                tabelPanelSalary.get().setBackground(new Color(204, 255, 204));  //todo de ce nu aapri?
                                                tabelPanelDepartments.get().setVisible(false);

                                                add(tabelPanelSalary.get());
                                                revalidate();

                                            } else {

                                                tabelPanelSalary.get().add(new Label("This department has no salary budget yet.")).setBackground(new Color(255,0,0));
                                                tabelPanelSalary.get().setSize(300, 400);
                                                tabelPanelSalary.get().setVisible(true);
                                                tabelPanelSalary.get().setBackground(new Color(204, 255, 204));
                                                tabelPanelDepartments.get().setVisible(false);
                                                add(tabelPanelSalary.get());
                                                revalidate();
                                            }

                                        }
                                    }
                                });

                                showJobs.addActionListener(e3 -> {
                                    Object source3 = e3.getSource();
                                    if (source3 instanceof JButton) {
                                        if(jListDepart.getSelectedIndex() >= 0 ){
                                            tabelPanelJobs.set(new JPanel());
                                            String departmentName = (String) jListDepart.getSelectedValue(); // am retinut numele departamentului
                                            int numberOfJobs = Application.getInstance().getCompany(companyName).getDepartment(departmentName).getJobs().size();
                                            if(numberOfJobs != 0){
                                                String newDataNameJ[] = new String[numberOfJobs];
                                                int m = 0;
                                                for (Job job : Application.getInstance().getCompany(companyName).getDepartment(departmentName).getJobs()) {
                                                    newDataNameJ[m] = job.getJobName();
                                                    m++;
                                                }

                                                JList<String> jLJob = new JList<>(newDataNameJ);
                                                jLJob.setBounds(30, 40, 200, 300);
                                                JScrollPane sPaneJob = new JScrollPane(jLJob);
                                                tabelPanelJobs.get().add(sPaneJob);
                                                tabelPanelJobs.get().setSize(300, 400);
                                                tabelPanelJobs.get().setVisible(true);
                                                tabelPanelJobs.get().setBackground(new Color(204, 255, 204));  //todo de ce nu actualizezi lista cu job-uri?
                                                tabelPanelDepartments.get().setVisible(false);

                                                add(tabelPanelJobs.get());
                                                revalidate();

                                            } else {

                                                tabelPanelJobs.get().add(new Label("This department has no available jobs yet.")).setBackground(new Color(255,0,0));
                                                tabelPanelJobs.get().setSize(300, 400);
                                                tabelPanelJobs.get().setVisible(true);
                                                tabelPanelJobs.get().setBackground(new Color(204, 255, 204));
                                                tabelPanelDepartments.get().setVisible(false);
                                                add(tabelPanelJobs.get());
                                                revalidate();
                                            }

                                        }

                                    }
                                });
                            }
                            else {
                                tabelPanelDepartments.get().add(new Label("This company has no depatments yet.")).setBackground(new Color(255,0,0));
                                tabelPanelDepartments.get().setSize(300, 400);
                                tabelPanelDepartments.get().setVisible(true);
                                tabelPanelDepartments.get().setBackground(new Color(255, 255, 204));
                                tabelPanelCompanies.setVisible(false);
                                add(tabelPanelDepartments.get());
                                revalidate();
                            }
                        }
                    }
                });
            }
            if(auxUsers[0] != 0){
                tabelPanelCompanies.setVisible(true);
            }
        });
        show();
    }
}
