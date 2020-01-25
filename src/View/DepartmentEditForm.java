/*
    This class is designed to load a edit form in the form of a JDialog box, this form displays the text-fields and
    labels relevant to what the user selected, those text fields will be populated with the selected data for the user
    to edit, this also allows the user to delete the selected data.
*/

package View;

import Controller.DepartmentFormController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentEditForm {

    private ArrayList<String> information;

    private JPanel formPanel;
    private JPanel buttonFormPanel;
    public JPanel formBody;
    public JPanel formHead;
    public JPanel formSide;
    public JDialog formPopUp;
    public List<JTextField> wow;
    public JButton button;
    public JButton delete;
    public int fileNum;
    public String depId;

    private DepartmentFormController departmentFormController;


    public DepartmentEditForm(ArrayList<String> information, int fileNum, JPanel formBody, JPanel formHead, JPanel formSide, String depId) {

        this.departmentFormController = new DepartmentFormController(this);

        this.information = information;
        this.fileNum = fileNum;
        this.formBody = formBody;
        this.formHead = formHead;
        this.formSide = formSide;
        this.depId = depId;
        createForm();
    }

    public void createForm() {

        String[] colNames = {"Department Id:", "Department Name", "Department Type", "Department Web-Address", "Department Username", "Department Password"};

        this.wow = new ArrayList<>();

        this.formPanel = new JPanel();
        this.formPanel.setLayout(new BoxLayout(this.formPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < information.size(); i++) {
            JTextField textField = new JTextField(information.get(i));
            textField.setName(information.get(i));
            textField.setMargin(new Insets(10, 0, 0, 0));
            textField.setFont(new Font("monospace", Font.ITALIC, 10));
            if (i == 0) {
                textField.setEnabled(false);
            }
            JLabel label = new JLabel(colNames[i]);
            label.setFont(new Font("monospace", Font.PLAIN, 12));

            this.wow.add(textField);
            this.formPanel.add(label);
            this.formPanel.add(textField);
        }
        this.buttonFormPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.buttonFormPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.buttonFormPanel.setBackground(Color.white);

        this.button = new JButton("Edit");
        button.addActionListener(this.departmentFormController);
        button.setBackground(Color.white);
        this.buttonFormPanel.add(button);

        this.delete = new JButton("Delete");
        delete.addActionListener(this.departmentFormController);
        delete.setBackground(Color.white);
        this.buttonFormPanel.add(delete);
        this.formPanel.setVisible(true);

        this.formPanel.add(buttonFormPanel);

        JOptionPane form = new JOptionPane(formPanel, JOptionPane.PLAIN_MESSAGE, JOptionPane.NO_OPTION, null, new Object[]{});
        this.formPopUp = form.createDialog(null, "Department Edit Form");
        this.formPopUp.setVisible(true);
    }
}
