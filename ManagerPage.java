import java.awt.*;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.*;

public class ManagerPage extends JFrame{

    public ManagerPage(String title){
        super(title);
        this.setSize(1100, 600);
        setLayout(new BorderLayout());

        JPanel firstPage = new JPanel();
        AtomicReference<JPanel> managerPanel = new AtomicReference<>(new JPanel());


        JTextField firstName = new JTextField(20);
        JTextField lastName = new JTextField(20);
        firstPage.add(new Label("Manager's first name: "));
        firstPage.add(firstName);
        firstPage.add(new Label("Manager's last name: "));
        firstPage.add(lastName);
        firstPage.setSize(300,200);
        firstPage.setBackground(new Color(204,204,255));
        firstPage.setVisible(true);

        JButton showRequests = new JButton("Show requests");
        showRequests.setForeground(Color.WHITE);
        showRequests.setBackground(new Color(51,51,255));
        firstPage.add(showRequests);

        add(firstPage);

        showRequests.addActionListener(e -> {
            Object source = e.getSource();
            if(firstPage.isVisible()){
                firstPage.setVisible(false);
            }
            if(source instanceof JButton){
                revalidate();
                System.out.println(firstName.getText() + " " + lastName.getText());
                Company foundComp = null;
                for(Company c : Application.getInstance().getCompanies()){
                    if(c.getManager() != null){
                        if (c.getManager().getResume().getInformation().getFirstName().equals(firstName.getText()) &&
                                c.getManager().getResume().getInformation().getLastName().equals(lastName.getText())) {
                            foundComp = c;
                            break;
                        }
                    }
                }
                if(foundComp != null){
                    JButton acceptButton = new JButton("Accept request");
                    JButton declineButton = new JButton("Decline request");
                    int numberOfRequests  = foundComp.getManager().requests.size();

                    if(numberOfRequests != 0) {
                        String requestData[] = new String[numberOfRequests + 1];
                        requestData[0] = "JOB | USER | RECRUITER | SCORE";
                        int l = 1;

                        for(Recruiter.Request<Job,Consumer> req : foundComp.getManager().requests){
                            requestData[l] = req.getKey().getJobName() + " | " + req.getValue1().getResume()
                                    .getInformation().getFirstName() + " " + req.getValue1().getResume()
                                    .getInformation().getLastName() + " | " + req.getValue2().getResume()
                                    .getInformation().getFirstName() + " " + req.getValue2().getResume()
                                    .getInformation().getLastName() + " | " + req.getScore();
                            l++;
                        }

                        JList<String> requests = new JList<>(requestData);
                        AtomicReference<JScrollPane> sPaneReq = new AtomicReference<>(new JScrollPane(requests));
                        managerPanel.get().add(sPaneReq.get());
                        acceptButton.setBackground(new Color(0,0,204));
                        acceptButton.setForeground(Color.WHITE);
                        declineButton.setForeground(Color.WHITE);
                        declineButton.setBackground(new Color(255,51,51));
                        managerPanel.get().add(acceptButton);
                        managerPanel.get().add(declineButton);
                        managerPanel.get().setSize(300,400);
                        managerPanel.get().setVisible(true);
                        managerPanel.get().setBackground(new Color(153,204,255));
                        firstPage.setVisible(false);
                        add(managerPanel.get());
                        revalidate();

                        Company finalFoundComp = foundComp;
                        acceptButton.addActionListener(e1 -> {
                            Object source1 = e1.getSource();
                            if(source1 instanceof JButton) {
                                if (requests.getSelectedIndex() >= 0){
                                    managerPanel.set(new JPanel());
                                    String selectedUser = requests.getSelectedValue();
                                    StringTokenizer stSlctUser = new StringTokenizer(selectedUser, " |");
                                    String jobName = stSlctUser.nextToken();
                                    String userFirstName = stSlctUser.nextToken();
                                    String userLastName = stSlctUser.nextToken();
                                    for(Department d : finalFoundComp.getDepartments()){
                                        for (Job j : d.getJobs()){
                                            if(j.getJobName().equals(jobName)){
                                                for(Recruiter.Request<Job, Consumer> re : finalFoundComp.getManager()
                                                        .requests){
                                                    if(re.getValue1().getResume().getInformation().getFirstName()
                                                            .equals(userFirstName) && re.getValue1().getResume()
                                                            .getInformation().getFirstName().equals(userLastName)){
                                                        User futureEmpl = (User) re.getValue1();
                                                        d.add(futureEmpl.convert());

                                                        finalFoundComp.getManager().requests.remove(re);
                                                        break;
                                                    }
                                                }

                                                break;
                                            }
                                        }
                                    }
                                    requests.remove(requests.getSelectedIndex());
                                    sPaneReq.set(new JScrollPane(requests));
                                    managerPanel.get().add(sPaneReq.get());
                                    revalidate();
                                    //TODO vezi cum faci asta

                                }
                            }
                        });

                        declineButton.addActionListener(e2 -> {
                            Object source2 = e2.getSource();
                            if(source2 instanceof JButton){
                                if(requests.getSelectedIndex() >= 0){
                                    managerPanel.set(new JPanel());
                                    String selectedUser = requests.getSelectedValue();
                                    StringTokenizer stSlctUser = new StringTokenizer(selectedUser, " |");
                                    String jobName = stSlctUser.nextToken();
                                    String userFirstName = stSlctUser.nextToken();
                                    String userLastName = stSlctUser.nextToken();
                                    for(Department d : finalFoundComp.getDepartments()){
                                        for (Job j : d.getJobs()){
                                            if(j.getJobName().equals(jobName)){
                                                for(Recruiter.Request<Job, Consumer> re : finalFoundComp.getManager()
                                                        .requests){
                                                    if(re.getValue1().getResume().getInformation().getFirstName()
                                                            .equals(userFirstName) && re.getValue1().getResume()
                                                            .getInformation().getFirstName().equals(userLastName)){
                                                        User futureEmpl = (User) re.getValue1();
                                                        d.add(futureEmpl.convert());

                                                        finalFoundComp.getManager().requests.remove(re);
                                                        break;
                                                    }
                                                }

                                                break;
                                            }
                                        }
                                    }
                                    requests.remove(requests.getSelectedIndex());
                                    sPaneReq.set(new JScrollPane(requests));
                                    managerPanel.get().add(sPaneReq.get());
                                    revalidate();
                                    //todo nici asta nu e buna, de reparat sau vezi ce faci
                                }
                            }
                        });
                    } else {
                        managerPanel.get().add(new Label("This manager has no request. Please enter" +
                                " another" + " name.")).setBackground(new Color(255,0,0));
                        managerPanel.get().setSize(300,400);
                        managerPanel.get().setVisible(true);
                        managerPanel.get().setBackground(new Color(224,224,224));
                        firstPage.setVisible(false);
                        add(managerPanel.get());
                        revalidate();
                    }

                } else {
                    managerPanel.get().add(new Label("This manager does not exist in any company. Please enter" +
                            " another" + " name.")).setBackground(new Color(255,0,0));
                    managerPanel.get().setSize(300,400);
                    managerPanel.get().setVisible(true);
                    managerPanel.get().setBackground(new Color(224,224,224));
                    firstPage.setVisible(false);
                    add(managerPanel.get());
                    revalidate();
                }
            }
        });

        revalidate();
        show();

    }
}
