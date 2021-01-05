import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.*;

public class ManagerPage extends JFrame{

    public ManagerPage(String title){
        super(title);
        this.setSize(1100, 600);
        setLayout(new BorderLayout());

        JPanel firstPage = new JPanel();
        AtomicReference<JPanel> managerPanel = new AtomicReference<>(new JPanel());

        JButton acceptButton = new JButton("Accept request");
        JButton declineButton = new JButton("Decline request");

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
                    if(c.getManager().getResume().getInformation().getFirstName().equals(firstName.getText()) &&
                            c.getManager().getResume().getInformation().getLastName().equals(lastName.getText())){
                        foundComp = c;
                        break;
                    }
                }
                if(foundComp != null){

                } else {
                    managerPanel.get().add(new Label("This manager does not exist in any company. Please enter" +
                            " another" + " name.")).setBackground(new Color(255,0,0));
                    managerPanel.get().setSize(300,400);
                    managerPanel.get().setVisible(true);
                    managerPanel.get().setBackground(new Color(224,224,224));
                    firstPage.setVisible(false);
                    add(managerPanel.get());
                    revalidate();                }
            }
        });

        JList<String> requestInfo = new JList<>();
        revalidate();
        show();

    }
}
