import javax.swing.*;
import java.awt.*;

public class OpenPage extends JFrame {
    public OpenPage(String title){
        super(title);

        this.setSize(400,200);
        setLayout(new BorderLayout());

        JPanel homePanel = new JPanel();
        JButton profilePage = new JButton("Profile Page");
        profilePage.setBackground(Color.CYAN);
        profilePage.setForeground(Color.WHITE);
        profilePage.setSize(200,200);
        homePanel.add(profilePage);
        JButton managerPage = new JButton("Manager Page");
        managerPage.setBackground(Color.GREEN);
        managerPage.setForeground(Color.WHITE);
        managerPage.setSize(200,200);
        homePanel.add(managerPage);
        JButton adminPage = new JButton("Admin Page");
        adminPage.setBackground(Color.magenta);
        adminPage.setForeground(Color.WHITE);
        adminPage.setSize(200,200);
        homePanel.add(adminPage);
        add(homePanel);
        homePanel.setVisible(true);
        homePanel.setBackground(new Color(255,229,204));
        show();

        profilePage.addActionListener(e -> {
            Object source = e.getSource();
            if(source instanceof JButton){
                new ProfilePage("Profile Page");
            }
        });

        adminPage.addActionListener(e -> {
            Object source = e.getSource();
            if(source instanceof JButton){
                new AdminPage("Admin Page");
            }
        });

        managerPage.addActionListener(e -> {
            Object source = e.getSource();
            if (source instanceof JButton){
                new ManagerPage("Manager Page");
            }
        });
    }
}
