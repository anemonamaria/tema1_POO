import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.TableColumn;

public class AdminPage extends JFrame {
    JList<User> userJList;
    JList<Company> companyJList;
    JTextField companies = new JTextField("Companies");
    JTextField users = new JTextField("Users");

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

        JPanel buttonPanel = new JPanel( new GridLayout(0, 2, 5, 5) );
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
        JPanel tabelPanelDepartments = new JPanel();

        final int[] auxUsers = {0};
        final int[] auxCompanies = {0};
        userButton.addActionListener(e -> {
            Object source = e.getSource();
            if(tabelPanelCompanies.isVisible()){
                tabelPanelCompanies.setVisible(false);
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
                JScrollPane sp=new JScrollPane(jt);
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
            if(tabelPanelUsers.isVisible()){
                tabelPanelUsers.setVisible(false);
            }
            if(source instanceof JButton && auxCompanies[0] == 0){

                revalidate();
                auxCompanies[0] = 1;
                JTextField message = new JTextField("List of companies");
                add(message);//.setBounds(30,45,10,10); // todo muta la locatia buna
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
                tabelPanelCompanies.setSize(300,400);
                tabelPanelCompanies.setVisible(true);
                tabelPanelCompanies.setBackground(new Color(255,255,204));

                add(tabelPanelCompanies);//, BorderLayout.EAST
                revalidate();

                if(jList.getSelectedIndex() != 0 ){  //todo
                    int index = jList.getSelectedIndex();
                    System.out.println("row " + index );
                    String companyName = (String) jList.getSelectedValue(); // am retinut numele companiei
                    System.out.println(companyName);
                    JPanel departmentPanel = new JPanel();
                    if(Application.getInstance().getCompany(companyName) != null) {
                        int numberOfDepartments = Application.getInstance().getCompany(companyName).getDepartments().size();
                        String columsDepartments[] = {"Departments"};
                        String dataForDepartments[] = new String[numberOfDepartments];
                        i = 0;
                        for (Department d : Application.getInstance().getCompany(companyName).getDepartments()) {
                            dataForDepartments[i] = d.getName();
                        }

                        JList<String> jListDepart = new JList<>(dataForDepartments);
                        jListDepart.setBounds(30, 40, 200, 300);
                        JScrollPane sPaneDep = new JScrollPane(jListDepart);
                        tabelPanelDepartments.add(sPaneDep);
                        tabelPanelDepartments.setSize(300, 400);
                        tabelPanelDepartments.setVisible(true);
                        tabelPanelDepartments.setBackground(new Color(255, 255, 204));

                        if (tabelPanelDepartments.isVisible()) {
                            tabelPanelCompanies.setVisible(false);
                        }
                        add(tabelPanelDepartments);//, BorderLayout.EAST
                        revalidate();
                    }
                }


            }
            if(auxUsers[0] != 0){
                tabelPanelCompanies.setVisible(true);
            }
        });

        show();
    }

    public static void main(String[] args) {
        new AdminPage("Admin Page");
    }
}
