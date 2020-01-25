/*
    This is the main view class loaded upon the opening of the application, This displays a form which contains a
    textfield and password-field in which the user can submit in their credentials, the logic is then sent to the
    log-in controller to process the information.
*/

package View;

import Controller.LogInController;

import javax.swing.*;
import java.awt.*;

public class LogInView {

    public JPanel body;
    public JPanel side;
    public JPanel banner;
    private JPanel logInPanel;

    private JLabel usernameLabel;
    public JTextField username;

    private JLabel passwordLabel;
    public JPasswordField password;

    public JButton submit;

    private LogInController logInController;

    public LogInView(JPanel body, JPanel side, JPanel banner) {
        this.body = body;
        this.side = side;
        this.banner = banner;
        this.logInController = new LogInController(this);

        getBody();
        setHead();
        addActionListeners();
    }

    public void getBody() {
        this.body.removeAll();
        this.body.setVisible(false);
        this.side.removeAll();

        this.body.setLayout(new BorderLayout());
        this.body.setPreferredSize(new Dimension(200, 400));
        this.body.setBackground(Color.darkGray);

        JPanel logBodyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 90, 120));
        logBodyPanel.setBackground(Color.darkGray);

        this.logInPanel = new JPanel(new GridLayout(3, 2, 80, 30));

        logInPanel.setBackground(Color.darkGray);

        this.usernameLabel = new JLabel("Enter your Username");
        this.usernameLabel.setPreferredSize(new Dimension(180, 40));
        this.usernameLabel.setForeground(Color.white);
        this.usernameLabel.setFont(new Font("Monospace", Font.BOLD, 16));
        logInPanel.add(this.usernameLabel);

        this.username = new JTextField();
        this.username.setPreferredSize(new Dimension(180, 40));
        this.username.setBackground(Color.white);
        this.username.setFont(new Font("Monospace", Font.BOLD, 25));
        this.username.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        logInPanel.add(this.username);

        this.passwordLabel = new JLabel("Enter your Password");
        this.passwordLabel.setPreferredSize(new Dimension(180, 40));
        this.passwordLabel.setForeground(Color.white);
        this.passwordLabel.setFont(new Font("Monospace", Font.BOLD, 16));
        logInPanel.add(this.passwordLabel);

        this.password = new JPasswordField();
        this.password.setPreferredSize(new Dimension(180, 40));
        this.password.setBackground(Color.white);
        this.password.setFont(new Font("Monospace", Font.BOLD, 25));
        this.password.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        logInPanel.add(this.password);

        this.submit = new JButton("Log In");
        this.submit.setPreferredSize(new Dimension(150, 30));
        this.submit.setBackground(Color.white);
        this.submit.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        logInPanel.add(this.submit);

        logBodyPanel.add(logInPanel, BorderLayout.CENTER);
        this.body.add(logBodyPanel);
        this.body.setVisible(true);
    }

    public void setHead() {
        banner.removeAll();
        banner.setVisible(false);

        JLabel titleLogIn = new JLabel("University Management System");
        titleLogIn.setFont(new Font("Monospace", Font.BOLD, 40));

        this.banner.add(titleLogIn);
        this.banner.setVisible(true);
    }

    public void addActionListeners() {
        this.submit.setName("login");
        this.submit.addActionListener(this.logInController);
    }

    public JButton getSubmit() {
        return this.submit;
    }
}
