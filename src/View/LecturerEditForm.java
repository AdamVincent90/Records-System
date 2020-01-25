/*
    This class is designed to load a edit form in the form of a JDialog box, this form displays the text-fields and
    labels relevant to what the user selected, those text fields will be populated with the selected data for the user
    to edit, this also allows the user to delete the selected data.
*/

package View;

import Controller.LecturerFormController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LecturerEditForm {

    private ArrayList<String> information;

    private JPanel lecFormPanel;
    private JPanel lecButtonFormPanel;
    public JDialog lecDialog;
    public JPanel formBody;
    public JPanel formHead;
    public JPanel formSide;

    public List<JTextField> dataList;

    public JButton lecEdit;
    public JButton lecDelete;

    public int fileNum;
    public String informationKey;
    public String pathName;
    private String labelName;

    public String depId;

    private LecturerFormController lecturerFormController;

    public LecturerEditForm(ArrayList<String> information, int fileNum, String pathName,
                            String labelName, JPanel formBody, JPanel formHead, JPanel formSide, String depId) {

        this.lecturerFormController = new LecturerFormController(this);

        this.information = information;
        this.fileNum = fileNum;
        this.formBody = formBody;
        this.formHead = formHead;
        this.formSide = formSide;


        this.pathName = pathName;
        this.labelName = labelName;
        this.depId = depId;
        createForm();
    }

    public void createForm() {

        switch (pathName) {
            case "/lecturers/all/full_time":
                this.informationKey = "salary";
                break;
            case "/lecturers/all/part_time":
                this.informationKey = "hourly_rate";
                break;
            case "/lecturers/all/contract":
                this.informationKey = "end_date";
                break;
        }


        String[] colNames = {"Lecturer Id:", "First Name:", "Last Name:", "Contact:", "Email:", "Start Date:", "Department Id", this.informationKey};

        this.dataList = new ArrayList<>();

        this.lecFormPanel = new JPanel();
        this.lecFormPanel.setLayout(new BoxLayout(this.lecFormPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < information.size(); i++) {
            JTextField LecTextField = new JTextField(information.get(i));
            LecTextField.setName(information.get(i));
            LecTextField.setMargin(new Insets(10, 0, 0, 0));
            LecTextField.setFont(new Font("monospace", Font.ITALIC, 10));
            if (i == 0) {
                LecTextField.setEnabled(false);
            }
            JLabel label = new JLabel(colNames[i]);
            label.setFont(new Font("monospace", Font.PLAIN, 12));

            this.dataList.add(LecTextField);
            this.lecFormPanel.add(label);
            this.lecFormPanel.add(LecTextField);
        }

        this.lecButtonFormPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.lecButtonFormPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.lecButtonFormPanel.setBackground(Color.white);

        this.lecEdit = new JButton("Edit");
        lecEdit.addActionListener(this.lecturerFormController);
        lecEdit.setBackground(Color.white);
        this.lecButtonFormPanel.add(lecEdit);

        this.lecDelete = new JButton("Delete");
        lecDelete.addActionListener(this.lecturerFormController);
        lecDelete.setBackground(Color.white);
        this.lecButtonFormPanel.add(lecDelete);

        this.lecFormPanel.add(this.lecButtonFormPanel);

        JOptionPane form = new JOptionPane(lecFormPanel, JOptionPane.PLAIN_MESSAGE, JOptionPane.NO_OPTION, null, new Object[]{});
        this.lecDialog = form.createDialog(null, "Lecturer Edit Form");
        this.lecDialog.setVisible(true);
    }
}
