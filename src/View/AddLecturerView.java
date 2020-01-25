/*
    This class displays all the visual components for adding a department, this loads text-fields for the user to
    submit, these are also identified with a relevant label, the user is also given an button which calls the views
    respective controller to carry the logic.
*/

package View;

import Controller.AddLecturerController;

import javax.swing.*;
import java.awt.*;

public class AddLecturerView {

    public JPanel lecBody;
    public JPanel title;
    public JPanel lecSide;
    public JPanel formPanel;

    private JLabel lecFname;
    private JLabel lecLname;
    private JLabel lecContact;
    private JLabel lecEmail;
    private JLabel lecStart;
    private JLabel lecTypeLabel;
    private JLabel lecTitle;
    private JLabel lecPartTimeLabel;
    private JLabel lecDepId;
    private JLabel formTitle;

    public JComboBox lecType;

    public JTextField tfFname;
    public JTextField tfLname;
    public JTextField tfContact;
    public JTextField tfEmail;
    public JTextField tfStart;
    public JTextField tfPartTime;
    public JTextField tfDepId;

    public JButton lecSubmit;

    private AddLecturerController addLecturerController;

    public AddLecturerView(JPanel lecBody, JPanel title, JPanel lecSide) {
        this.lecBody = lecBody;
        this.title = title;
        this.lecSide = lecSide;

        this.addLecturerController = new AddLecturerController(this);

        setLecBody();
        setHeader();
        addActionListeners();
    }


    public void setLecBody() {


        this.lecBody.removeAll();
        this.lecBody.setVisible(false);
        this.lecBody.setLayout(new BorderLayout());
        this.lecBody.setPreferredSize(new Dimension(200, 400));
        this.lecBody.setBackground(Color.darkGray);


        JPanel secBodyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 150, 80));
        secBodyPanel.setBackground(Color.darkGray);

        this.formPanel = new JPanel(new GridLayout(9, 2, 30, 10));

        this.formPanel.setBackground(Color.darkGray);

        String[] contractType = {"Part-Time", "Full-Time", "Contract"};

        this.lecFname = new JLabel("First Name");
        this.lecFname.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecFname.setPreferredSize(new Dimension(120, 30));
        this.lecFname.setForeground(Color.white);
        this.formPanel.add(lecFname);

        this.tfFname = new JTextField();
        this.tfFname.setPreferredSize(new Dimension(140, 30));
        this.tfFname.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfFname);

        this.lecLname = new JLabel("Last Name");
        this.lecLname.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecLname.setPreferredSize(new Dimension(120, 30));
        this.lecLname.setForeground(Color.white);
        this.formPanel.add(lecLname);

        this.tfLname = new JTextField();
        this.tfLname.setPreferredSize(new Dimension(140, 30));
        this.tfLname.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfLname);

        this.lecContact = new JLabel("Contact: ");
        this.lecContact.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecContact.setPreferredSize(new Dimension(120, 30));
        this.lecContact.setForeground(Color.white);
        this.formPanel.add(lecContact);

        this.tfContact = new JTextField();
        this.tfContact.setPreferredSize(new Dimension(140, 30));
        this.tfContact.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfContact);

        this.lecEmail = new JLabel("Email: ");
        this.lecEmail.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecEmail.setPreferredSize(new Dimension(120, 30));
        this.lecEmail.setForeground(Color.white);
        this.formPanel.add(lecEmail);

        this.tfEmail = new JTextField();
        this.tfEmail.setPreferredSize(new Dimension(140, 30));
        this.tfEmail.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfEmail);

        this.lecStart = new JLabel("Start date ");
        this.lecStart.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecStart.setPreferredSize(new Dimension(120, 30));
        this.lecStart.setForeground(Color.white);
        this.formPanel.add(lecStart);

        this.tfStart = new JTextField();
        this.tfStart.setPreferredSize(new Dimension(140, 30));
        this.tfStart.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfStart);

        this.lecDepId = new JLabel("Department Id ");
        this.lecDepId.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecDepId.setPreferredSize(new Dimension(120, 30));
        this.lecDepId.setForeground(Color.white);
        this.formPanel.add(lecDepId);

        this.tfDepId = new JTextField();
        this.tfDepId.setPreferredSize(new Dimension(140, 30));
        this.tfDepId.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.formPanel.add(tfDepId);

        this.lecTypeLabel = new JLabel("Contract Type");
        this.lecTypeLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecTypeLabel.setPreferredSize(new Dimension(120, 30));
        this.lecTypeLabel.setForeground(Color.white);
        this.formPanel.add(lecTypeLabel);

        this.lecType = new JComboBox(contractType);
        this.lecType.setPreferredSize(new Dimension(140, 30));
        this.lecType.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        this.formPanel.add(lecType);

        secBodyPanel.add(formPanel, BorderLayout.CENTER);
        this.lecBody.add(secBodyPanel);
        this.lecBody.setVisible(true);

    }

    public void setHeader() {
        this.title.removeAll();
        this.title.setVisible(false);

        this.lecTitle = new JLabel("Add a New Lecturer");
        this.lecTitle.setFont(new Font("Monospace", Font.BOLD, 40));
        title.add(lecTitle);
        title.setVisible(true);
    }

    public void addActionListeners() {
        this.lecType.addActionListener(this.addLecturerController);
    }


    public void setDropDownInstance(String labName, String butName) {
        this.lecType.setVisible(false);
        this.lecTypeLabel.setVisible(false);
        this.lecPartTimeLabel = new JLabel(labName);
        this.tfPartTime = new JTextField();
        this.tfPartTime.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecPartTimeLabel.setFont(new Font("Monospace", Font.BOLD, 13));
        this.lecPartTimeLabel.setPreferredSize(new Dimension(120, 30));
        this.lecPartTimeLabel.setForeground(Color.white);
        this.formPanel.add(lecPartTimeLabel);
        this.tfPartTime.setPreferredSize(new Dimension(140, 30));
        this.formPanel.add(tfPartTime);
        this.lecSubmit = new JButton(butName);
        this.lecSubmit.setPreferredSize(new Dimension(120, 30));
        this.lecSubmit.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecSubmit.setBackground(Color.white);
        this.lecSubmit.addActionListener(this.addLecturerController);
        this.formPanel.add(lecSubmit);
    }
}
