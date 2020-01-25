/*
    This class controls the interactions between the DepartmentEditForm class, this controls the logic based on what
    the user selects, if the user presses the edit button, the existing data is rewritten in the file and instantly
    displayed in the departments table in DepartmentsManageView.
*/

package Controller;

import Application.Controller;
import Model.File_Writer;
import View.DepartmentEditForm;
import View.DepartmentsManageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class DepartmentFormController extends Controller {

    private DepartmentEditForm departmentEditForm;

    public DepartmentFormController(DepartmentEditForm departmentEditForm) {

        this.departmentEditForm = departmentEditForm;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == departmentEditForm.button) {
            HashMap<String, String> resultSet = new HashMap<>();

            resultSet.put("dep_id", departmentEditForm.wow.get(0).getText());
            resultSet.put("dep_name", departmentEditForm.wow.get(1).getText());
            resultSet.put("dep_type", departmentEditForm.wow.get(2).getText());
            resultSet.put("dep_web", departmentEditForm.wow.get(3).getText());
            resultSet.put("dep_username", departmentEditForm.wow.get(4).getText());
            resultSet.put("dep_password", departmentEditForm.wow.get(5).getText());


            File_Writer updateFile = new File_Writer(resultSet, departmentEditForm.formBody, departmentEditForm.formHead, departmentEditForm.formSide, "departments", departmentEditForm.fileNum);
            updateFile.editFile();
            departmentEditForm.formPopUp.setVisible(false);
            JOptionPane.showMessageDialog(null, "Department has been edited");
            new DepartmentsManageView(departmentEditForm.formBody, departmentEditForm.formHead, departmentEditForm.formSide,
                    departmentEditForm.depId);
        }

        if (source == departmentEditForm.delete) {
            File_Writer deleteFile = new File_Writer(null, departmentEditForm.formBody, departmentEditForm.formHead,
                    departmentEditForm.formSide, "departments", departmentEditForm.fileNum);
            deleteFile.delFile();
            JOptionPane.showMessageDialog(null, "Department has been deleted");
            new DepartmentsManageView(departmentEditForm.formBody, departmentEditForm.formHead, departmentEditForm.formSide,
                    departmentEditForm.depId);
        }

    }
}
