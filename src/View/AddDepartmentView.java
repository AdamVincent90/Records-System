/*
    This class displays all the visual components for adding a department, this loads text-fields for the user to
    submit, these are also identified with a relevant label, the user is also given an button which calls the views
    respective controller to carry the logic.
*/

package View;

import Controller.AddDepartmentController;

import javax.swing.*;
import java.awt.*;


public class AddDepartmentView {
    public JPanel depBody;
    public JPanel title;
    public JPanel depSide;

    public JTextField departmentName;
    public JTextField departmentId;
    public JTextField departmentType;
    public JTextField departmentWeb;

    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel typeLabel;
    private JLabel depTitle;
    private JLabel depWeb;

    public JButton addDepartment;

    private AddDepartmentController addDepartmentController;

    public AddDepartmentView(JPanel body, JPanel title, JPanel depSide) {
        this.depBody = body;
        this.title = title;
        this.depSide = depSide;

        this.addDepartmentController = new AddDepartmentController(this);

        setBody();
        setHeader();
        addActionListeners();
    }

    public void setBody() {

        this.depBody.removeAll();
        this.depBody.setVisible(false);
        this.depBody.setLayout(new BorderLayout());
        this.depBody.setPreferredSize(new Dimension(200, 400));
        this.depBody.setBackground(Color.darkGray);


        JPanel secBodyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 200, 130));
        secBodyPanel.setBackground(Color.darkGray);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 100, 10));

        formPanel.setBackground(Color.darkGray);


        this.idLabel = new JLabel("Department Id");
        this.idLabel.setPreferredSize(new Dimension(130, 30));
        this.idLabel.setForeground(Color.white);
        this.idLabel.setFont(new Font("Monospace", Font.BOLD, 14));
        formPanel.add(this.idLabel);

        this.departmentId = new JTextField();
        this.departmentId.setPreferredSize(new Dimension(150, 30));
        this.departmentId.setForeground(Color.black);
        this.departmentId.setFont(new Font("Monospace", Font.BOLD, 13));
        this.departmentId.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.departmentId.setName("department_id");
        formPanel.add(this.departmentId);

        this.nameLabel = new JLabel("Department Name");
        this.nameLabel.setPreferredSize(new Dimension(130, 30));
        this.nameLabel.setForeground(Color.white);
        this.nameLabel.setFont(new Font("Monospace", Font.BOLD, 14));
        formPanel.add(this.nameLabel);

        this.departmentName = new JTextField();
        this.departmentName.setPreferredSize(new Dimension(150, 30));
        this.departmentName.setForeground(Color.black);
        this.departmentName.setFont(new Font("Monospace", Font.BOLD, 13));
        this.departmentName.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        formPanel.add(this.departmentName);

        this.typeLabel = new JLabel("Department Type");
        this.typeLabel.setPreferredSize(new Dimension(130, 30));
        this.typeLabel.setForeground(Color.white);
        this.typeLabel.setFont(new Font("Monospace", Font.BOLD, 14));
        formPanel.add(this.typeLabel);

        this.departmentType = new JTextField();
        this.departmentType.setPreferredSize(new Dimension(150, 30));
        this.departmentType.setForeground(Color.black);
        this.departmentType.setFont(new Font("Monospace", Font.BOLD, 13));
        this.departmentType.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.departmentType.setName("department_type");
        formPanel.add(this.departmentType);

        this.depWeb = new JLabel("Department Web-Address");
        this.depWeb.setPreferredSize(new Dimension(150, 30));
        this.depWeb.setForeground(Color.white);
        this.depWeb.setFont(new Font("Monospace", Font.BOLD, 12));
        formPanel.add(this.depWeb);

        this.departmentWeb = new JTextField();
        this.departmentWeb.setPreferredSize(new Dimension(150, 30));
        this.departmentWeb.setForeground(Color.black);
        this.departmentWeb.setFont(new Font("Monospace", Font.BOLD, 13));
        this.departmentWeb.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        formPanel.add(this.departmentWeb);

        this.addDepartment = new JButton("Add department");
        this.addDepartment.setPreferredSize(new Dimension(100, 20));
        this.addDepartment.setForeground(Color.black);
        this.addDepartment.setFont(new Font("Monospace", Font.BOLD, 13));
        this.addDepartment.setBackground(Color.white);
        this.addDepartment.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        formPanel.add(addDepartment);

        secBodyPanel.add(formPanel, BorderLayout.CENTER);
        this.depBody.add(secBodyPanel);

        depBody.setVisible(true);
    }

    public void setHeader() {
        this.title.removeAll();
        this.title.setVisible(false);

        this.depTitle = new JLabel("Add a New Department");
        this.depTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        title.add(depTitle);
        title.setVisible(true);

    }

    public void addActionListeners() {
        this.addDepartment.addActionListener(this.addDepartmentController);
    }

}
