/*
    This class is designed to load a edit form in the form of a JDialog box, this form displays the text-fields and
    labels relevant to what the user selected, those text fields will be populated with the selected data for the user
    to edit, this also allows the user to delete the selected data.
*/

package View;

import Controller.StaffFormController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StaffEditForm {

    private ArrayList<String> information;

    private JPanel staffFormPanel;
    private JPanel staffButtonFormPanel;
    public JDialog staffDialog;
    public JPanel formBody;
    public JPanel formHead;
    public JPanel formSide;

    public List<JTextField> dataList;

    public JButton staffEdit;
    public JButton staffDelete;

    public int fileNum;
    public String informationKey;

    private String labelName;
    public String pathName;
    public String depId;

    private StaffFormController staffFormController;

    public StaffEditForm(ArrayList<String> information, int fileNum, String pathName,
                         String labelName, JPanel formBody, JPanel formHead, JPanel formSide, String depId) {

        staffFormController = new StaffFormController(this);

        this.information = information;

        this.fileNum = fileNum;
        this.formBody = formBody;
        this.formHead = formHead;
        this.formSide = formSide;

        this.labelName = labelName;

        this.depId = depId;

        this.labelName = labelName;
        this.pathName = pathName;

        createForm();
    }

    public void createForm() {

        this.informationKey = (this.pathName.equals("/staff/all/admin")) ? "admin_id" : "secretary_id";

        String[] colNames = {this.labelName + "ID:", "Password", "First Name:", "Last Name:", "Date of Birth:", "Employment Date:", "Department Id:"};

        this.dataList = new ArrayList<>();

        this.staffFormPanel = new JPanel();
        this.staffFormPanel.setLayout(new BoxLayout(this.staffFormPanel, BoxLayout.Y_AXIS));

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

            this.dataList.add(textField);
            this.staffFormPanel.add(label);
            this.staffFormPanel.add(textField);
        }

        this.staffButtonFormPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.staffButtonFormPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.staffButtonFormPanel.setBackground(Color.white);

        this.staffEdit = new JButton("Edit");
        staffEdit.addActionListener(this.staffFormController);
        staffEdit.setBackground(Color.white);
        this.staffButtonFormPanel.add(staffEdit);

        this.staffDelete = new JButton("Delete");
        staffDelete.addActionListener(this.staffFormController);
        staffDelete.setBackground(Color.white);
        this.staffButtonFormPanel.add(staffDelete);

        this.staffFormPanel.add(staffButtonFormPanel);

        JOptionPane form = new JOptionPane(staffFormPanel, JOptionPane.PLAIN_MESSAGE, JOptionPane.NO_OPTION, null, new Object[]{});
        this.staffDialog = form.createDialog(null, "Staff Edit Form");
        this.staffDialog.setVisible(true);
    }
}
