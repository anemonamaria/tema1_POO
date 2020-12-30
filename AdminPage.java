import javax.swing.*;
import java.awt.*;

public class AdminPage extends JFrame {
    JList<User> userJList;
    JList<Company> companyJList;
    JTextField companies = new JTextField("Companies");
    JTextField users = new JTextField("Users");

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Page");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
