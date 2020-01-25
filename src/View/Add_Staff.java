/*
    This class displays all the visual components for adding a staff member, this loads text-fields for the user to
    submit, these are also identified with a relevant label, the user is also given an button which calls the views
    respective controller to carry the logic.
*/

package View;

import Controller.AddStaffController;

import javax.swing.*;
import java.awt.*;


public class Add_Staff {

    public JPanel staffBody;
    public JPanel staffHeader;
    public JPanel staffSide;
    private JPanel formPanel;

    private JLabel staffFname;
    private JLabel staffLname;
    private JLabel date_of_birth;
    private JLabel empDate;
    private JLabel staffRoleLabel;
    private JLabel staffTitle;
    private JLabel dropDownLabel;
    private JLabel depIdLabel;
    private JLabel passwordLabel;

    public JComboBox staffType;

    public JTextField tfStaffFname;
    public JTextField tfStaffLname;
    public JTextField tfDate_of_birth;
    public JTextField tfEmpDate;
    public JTextField tfDepId;
    public JTextField tfDropDown;
    public JPasswordField tfPassword;

    public JButton staffSubmit;

    private AddStaffController addStaffController;

    public Add_Staff(JPanel staffBody, JPanel staffHeader, JPanel staffSide) {
        this.staffBody = staffBody;
        this.staffHeader = staffHeader;
        this.staffSide = staffSide;

        this.addStaffController = new AddStaffController(this);

        setLecBody();
        setHeader();
        addActionListeners();
    }

    public void setLecBody() {
        this.staffBody.removeAll();
        this.staffBody.setVisible(false);

        this.staffBody.setLayout(new BorderLayout());
        this.staffBody.setPreferredSize(new Dimension(200, 400));
        this.staffBody.setBackground(Color.darkGray);

        JPanel staffBodyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 90));
        staffBodyPanel.setBackground(Color.darkGray);

        this.formPanel = new JPanel(new GridLayout(10, 2, 50, 10));

        formPanel.setBackground(Color.darkGray);

        String[] staffRole = {"Admin", "Secretary"};

        this.staffFname = new JLabel("First Name");
        this.staffFname.setFont(new Font("Monospace", Font.BOLD, 13));
        this.staffFname.setPreferredSize(new Dimension(120, 30));
        this.staffFname.setForeground(Color.white);
        this.formPanel.add(staffFname);

        this.tfStaffFname = new JTextField();
        this.tfStaffFname.setPreferredSize(new Dimension(140, 30));
        this.tfStaffFname.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfStaffFname);

        this.staffLname = new JLabel("Last Name");
        this.staffLname.setFont(new Font("Monospace", Font.BOLD, 13));
        this.staffLname.setPreferredSize(new Dimension(120, 30));
        this.staffLname.setForeground(Color.white);
        this.formPanel.add(staffLname);

        this.tfStaffLname = new JTextField();
        this.tfStaffLname.setPreferredSize(new Dimension(140, 30));
        this.tfStaffLname.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfStaffLname);

        this.date_of_birth = new JLabel("Date of Birth ");
        this.date_of_birth.setFont(new Font("Monospace", Font.BOLD, 13));
        this.date_of_birth.setPreferredSize(new Dimension(120, 30));
        this.date_of_birth.setForeground(Color.white);
        this.formPanel.add(date_of_birth);

        this.tfDate_of_birth = new JTextField();
        this.tfDate_of_birth.setPreferredSize(new Dimension(140, 30));
        this.tfDate_of_birth.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfDate_of_birth);

        this.empDate = new JLabel("Employment Date ");
        this.empDate.setFont(new Font("Monospace", Font.BOLD, 13));
        this.empDate.setPreferredSize(new Dimension(120, 30));
        this.empDate.setForeground(Color.white);
        this.formPanel.add(empDate);

        this.tfEmpDate = new JTextField();
        this.tfEmpDate.setPreferredSize(new Dimension(140, 30));
        this.tfEmpDate.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfEmpDate);

        this.depIdLabel = new JLabel("Department Id ");
        this.depIdLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.depIdLabel.setPreferredSize(new Dimension(120, 30));
        this.depIdLabel.setForeground(Color.white);
        this.formPanel.add(depIdLabel);

        this.tfDepId = new JTextField();
        this.tfDepId.setPreferredSize(new Dimension(140, 30));
        this.tfDepId.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfDepId);

        this.staffRoleLabel = new JLabel("Staff Role ");
        this.staffRoleLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.staffRoleLabel.setPreferredSize(new Dimension(120, 30));
        this.staffRoleLabel.setForeground(Color.white);
        this.formPanel.add(staffRoleLabel);

        this.staffType = new JComboBox(staffRole);
        this.staffType.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.staffType.setPreferredSize(new Dimension(140, 30));
        this.formPanel.add(staffType);

        staffBodyPanel.add(formPanel, BorderLayout.CENTER);
        this.staffBody.add(staffBodyPanel);

        this.staffBody.setVisible(true);

    }

    public void setHeader() {
        this.staffHeader.removeAll();
        this.staffHeader.setVisible(false);

        this.staffTitle = new JLabel("Add new Staff Member");
        this.staffTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        staffHeader.add(staffTitle);
        staffHeader.setVisible(true);
    }

    public void addActionListeners() {
        this.staffType.addActionListener(this.addStaffController);
    }

    public void setDropDownInstance(String labName, String butName) {
        this.staffType.setVisible(false);
        this.staffRoleLabel.setVisible(false);

        this.dropDownLabel = new JLabel(labName);
        this.dropDownLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.dropDownLabel.setPreferredSize(new Dimension(120, 30));
        this.dropDownLabel.setForeground(Color.white);
        this.formPanel.add(dropDownLabel);

        this.tfDropDown = new JTextField();
        this.tfDropDown.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.tfDropDown.setPreferredSize(new Dimension(140, 30));
        this.formPanel.add(tfDropDown);

        this.passwordLabel = new JLabel("Password");
        this.passwordLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.passwordLabel.setPreferredSize(new Dimension(120, 30));
        this.passwordLabel.setForeground(Color.white);
        this.formPanel.add(passwordLabel);

        this.tfPassword = new JPasswordField();
        this.tfPassword.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.tfPassword.setPreferredSize(new Dimension(140, 30));
        this.formPanel.add(tfPassword);

        this.staffSubmit = new JButton(butName);
        this.staffSubmit.setPreferredSize(new Dimension(140, 30));
        this.staffSubmit.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.staffSubmit.setBackground(Color.white);
        this.staffSubmit.addActionListener(this.addStaffController);
        this.formPanel.add(staffSubmit);
    }

}
