/*
    This class controls the interactions between the StaffEditForm class, this controls the logic based on what
    the user selects, if the user presses the edit button, the existing data is rewritten in the file and instantly
    displayed in the departments table in Staff_Management.
*/

package Controller;

import Application.Controller;
import Model.File_Writer;
import View.StaffEditForm;
import View.Staff_Management;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class StaffFormController extends Controller {

    private StaffEditForm staffEditForm;

    public StaffFormController(StaffEditForm staffEditForm) {
        this.staffEditForm = staffEditForm;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == staffEditForm.staffEdit) {
            HashMap<String, String> resultSet = new HashMap<>();

            resultSet.put(staffEditForm.informationKey, staffEditForm.dataList.get(0).getText());
            resultSet.put("password", staffEditForm.dataList.get(1).getText());
            resultSet.put("first_name", staffEditForm.dataList.get(2).getText());
            resultSet.put("last_name", staffEditForm.dataList.get(3).getText());
            resultSet.put("date_of_birth", staffEditForm.dataList.get(4).getText());
            resultSet.put("employment_date", staffEditForm.dataList.get(5).getText());
            resultSet.put("department_id", staffEditForm.dataList.get(6).getText());


            File_Writer updateFile = new File_Writer(resultSet, staffEditForm.formBody, staffEditForm.formHead, staffEditForm.formSide, staffEditForm.pathName, staffEditForm.fileNum);
            updateFile.editFile();
            staffEditForm.staffDialog.setVisible(false);
            JOptionPane.showMessageDialog(null, "Staff has been edited");
            new Staff_Management(staffEditForm.formBody, staffEditForm.formHead, staffEditForm.formSide, staffEditForm.depId);
        }

        if (source == staffEditForm.staffDelete) {
            File_Writer deleteFile = new File_Writer(null, staffEditForm.formBody, staffEditForm.formHead, staffEditForm.formSide, staffEditForm.pathName, staffEditForm.fileNum);
            deleteFile.delFile();
            staffEditForm.staffDialog.setVisible(false);
            JOptionPane.showMessageDialog(null, "Staff has been deleted");
            new Staff_Management(staffEditForm.formBody, staffEditForm.formHead, staffEditForm.formSide, staffEditForm.depId);
        }
    }
}
