/*
    This class creates the main frame and window of the application, the 3 main panels are created here and are modified
    based on the view selected.
*/

package Application;

import View.LogInView;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame {
    protected Controller controller;
    protected Model model;

    protected JPanel mainPanel;
    protected JPanel header;
    protected JPanel footer;

    protected JFrame window;

    protected JLabel title;

    public View() {
        createGui();

        this.window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.window.setPreferredSize(new Dimension(1000, 600));
        this.window.setTitle("University Management System");
        this.window.pack();
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);

    }

    public void createGui() {
        this.window = new JFrame();
        this.window.setBackground(Color.gray);
        this.window.setLayout(new BorderLayout());
        this.window.setResizable(false);
        this.window.setLocationRelativeTo(null);
        jPanel();
        setHeader();
        setFooter();
        new LogInView(mainPanel, footer, header);

    }

    public void jPanel() {
        this.mainPanel = new JPanel();
        this.mainPanel.setPreferredSize(new Dimension(1000, 600));
        this.mainPanel.setBackground(Color.darkGray);
        this.mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 150, 30));
        this.mainPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        window.add(this.mainPanel, BorderLayout.CENTER);

    }

    public void setHeader() {
        this.header = new JPanel();
        this.header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        this.title = new JLabel("University Management System Log In page");
        this.header.setPreferredSize(new Dimension(1000, 100));
        this.title.setFont(new Font("Monospace", Font.BOLD, 40));
        this.header.setBackground(Color.gray);
        this.header.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        window.add(this.header, BorderLayout.NORTH);
        this.header.add(this.title);
    }

    public void setFooter() {
        this.footer = new JPanel();
        this.footer.setPreferredSize(new Dimension(200, 600));
        this.footer.setBackground(Color.lightGray);
        this.footer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        this.footer.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        window.add(this.footer, BorderLayout.WEST);
    }
}
