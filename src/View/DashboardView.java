/*
    This class displays all the visual components for the navigation, multiple buttons are added to the side of the
    program and are accessed to their respective controller when selected in which prompts the correct section for the
    user to be navigated to.
*/

package View;

import Controller.DashboardController;

import javax.swing.*;
import java.awt.*;

public class DashboardView {

    public JPanel body;
    public JPanel side;
    public JPanel banner;

    private JLabel annoucement;
    private JLabel title;

    public JButton Departments;
    public JButton Lecturers;
    public JButton addDepartment;
    public JButton addLecturer;
    public JButton addStaff;
    public JButton logOut;
    public JButton staff;

    public String depId;

    private DashboardController dashboardController;
    private int accessLevel;


    public DashboardView(JPanel body, JPanel side, JPanel banner, int accessLevel, String depId) {

        this.body = body;
        this.side = side;
        this.banner = banner;
        this.accessLevel = accessLevel;
        this.depId = depId;

        this.dashboardController = new DashboardController(this);

        getBody();
        getSide();
        getBanner();

        addActionListeners();
    }

    public void getBody() {
        body.removeAll();
        body.setVisible(false);
        this.body.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 150));
        annoucement = new JLabel("<html>Welcome user <br> your current available <br> options are available on the side panel</html>");
        annoucement.setFont(new Font("Monospace", Font.BOLD, 30));
        annoucement.setForeground(Color.white);
        this.body.setVisible(true);
        this.body.add(annoucement, BorderLayout.CENTER);

        System.out.println(this.depId);
    }

    public void getSide() {

        this.side.removeAll();
        this.side.setVisible(false);

        this.Departments = new JButton("Departments Management");
        this.Departments.setPreferredSize(new Dimension(160, 30));
        this.Departments.setFont(new Font("Monospace", Font.BOLD, 10));
        this.Departments.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.Departments.setBackground(Color.white);

        this.Lecturers = new JButton("Lecturers Management");
        this.Lecturers.setPreferredSize(new Dimension(160, 30));
        this.Lecturers.setFont(new Font("Monospace", Font.BOLD, 10));
        this.Lecturers.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.Lecturers.setBackground(Color.white);

        this.staff = new JButton("Staff Management");
        this.staff.setPreferredSize(new Dimension(160, 30));
        this.staff.setFont(new Font("Monospace", Font.BOLD, 10));
        this.staff.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.staff.setBackground(Color.white);

        this.logOut = new JButton("Log Out");
        this.logOut.setPreferredSize(new Dimension(60, 30));
        this.logOut.setFont(new Font("Monospace", Font.BOLD, 10));
        this.logOut.setBackground(Color.white);
        this.logOut.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        side.add(this.logOut);

        if (this.accessLevel > 0) {

            this.addStaff = new JButton("Add New Staff");
            this.addStaff.setPreferredSize(new Dimension(160, 30));
            this.addStaff.setFont(new Font("Monospace", Font.BOLD, 10));
            this.addStaff.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            this.addStaff.setBackground(Color.white);

            this.addDepartment = new JButton("Add A department");
            this.addDepartment.setPreferredSize(new Dimension(160, 30));
            this.addDepartment.setFont(new Font("Monospace", Font.BOLD, 10));
            this.addDepartment.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            this.addDepartment.setBackground(Color.white);

            this.addLecturer = new JButton("Add A lecturer");
            this.addLecturer.setPreferredSize(new Dimension(160, 30));
            this.addLecturer.setFont(new Font("Monospace", Font.BOLD, 10));
            this.addLecturer.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            this.addLecturer.setBackground(Color.white);

            side.add(this.addDepartment);
            side.add(this.addLecturer);
            side.add(addStaff);
        }

        side.add(this.Departments);
        side.add(this.Lecturers);
        side.add(this.staff);

        this.side.setVisible(true);
    }

    public void getBanner() {
        banner.removeAll();
        banner.setVisible(false);
        this.title = new JLabel("University Management System Dashboard");
        this.title.setFont(new Font("Monospace", Font.BOLD, 40));
        banner.add(title);
        banner.setVisible(true);
    }

    public void addActionListeners() {
        this.Departments.addActionListener(this.dashboardController);
        this.Lecturers.addActionListener(this.dashboardController);
        this.staff.addActionListener(this.dashboardController);
        this.logOut.addActionListener(this.dashboardController);

        if (this.accessLevel > 0) {
            this.addDepartment.addActionListener(this.dashboardController);
            this.addLecturer.addActionListener(this.dashboardController);
            this.addStaff.addActionListener(this.dashboardController);
        }
    }

}
