/*
    This class is used to control the user interactions between the user and program, this class focuses on allowing
    the user add an department to store within the table of the "DepartmentManageView" class, this also saves the
    department to a serialized file.
*/

package Controller;

import Application.Controller;
import Model.Department;
import Model.File_Writer;
import View.AddDepartmentView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddDepartmentController extends Controller {

    private AddDepartmentView addDepartmentView;


    public AddDepartmentController(AddDepartmentView addDepartmentView) {
        this.addDepartmentView = addDepartmentView;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addDepartmentView.addDepartment) {
            Department name = new Department(addDepartmentView.departmentId.getText(), addDepartmentView.departmentName.getText(),
                    addDepartmentView.departmentType.getText(), addDepartmentView.departmentWeb.getText());
            File_Writer depFile = new File_Writer(name.departmentFile, addDepartmentView.depBody, addDepartmentView.title, addDepartmentView.depSide, "departments", 0);
            depFile.writeFile();
            confirmation();
        }
    }

    public void confirmation() {
        JOptionPane.showMessageDialog(null, "Department Added");
        new AddDepartmentView(addDepartmentView.depBody, addDepartmentView.title, addDepartmentView.depSide);
    }
}
