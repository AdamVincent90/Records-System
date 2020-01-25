/*
    This class is used to control the user interactions between the user and program, this class focuses on allowing
    the user to add an staff member to store within the table of the "Staff_Management" class, this also saves the
    staff to a serialized file. This also includes each type of staff member such as an admin or secretary.
*/

package Controller;

import Application.Controller;
import Model.Admin;
import Model.File_Writer;
import Model.Secretary;
import View.Add_Staff;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddStaffController extends Controller {

    private Add_Staff add_staff;

    public AddStaffController(Add_Staff add_staff) {
        this.add_staff = add_staff;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == add_staff.staffType) {
            switch (String.valueOf(add_staff.staffType.getSelectedItem())) {
                case "Secretary":
                    add_staff.setDropDownInstance("Secretary Id: ", "Add Secretary");
                    break;
                case "Admin":
                    add_staff.setDropDownInstance("Admin ID: ", "Add Admin");
                    break;
            }
        }

        if (source == add_staff.staffSubmit) {
            switch (String.valueOf(add_staff.staffType.getSelectedItem())) {
                case "Secretary":
                    Secretary secretary = new Secretary
                            (add_staff.tfStaffFname.getText(), add_staff.tfStaffLname.getText(),
                                    add_staff.tfDate_of_birth.getText(), add_staff.tfEmpDate.getText(), add_staff.tfDepId.getText(),
                                    add_staff.tfDropDown.getText(), add_staff.tfPassword.getText());
                    File_Writer secFile = new File_Writer(secretary.getSecHash(), add_staff.staffBody, add_staff.staffHeader, add_staff.staffSide, "staff/all/secretary", 0);
                    secFile.writeFile();
                    confirmation();
                    break;

                case "Admin":
                    Admin admin = new Admin
                            (add_staff.tfStaffFname.getText(), add_staff.tfStaffLname.getText(), add_staff.tfDate_of_birth.getText(),
                                    add_staff.tfEmpDate.getText(), add_staff.tfDepId.getText(),
                                    add_staff.tfDropDown.getText(), add_staff.tfPassword.getText());
                    File_Writer adFile = new File_Writer(admin.getAdminHash(), add_staff.staffBody, add_staff.staffHeader, add_staff.staffSide, "staff/all/admin", 0);
                    adFile.writeFile();
                    confirmation();
                    break;
            }
        }
    }

    public void confirmation() {
        JOptionPane.showMessageDialog(null, "Staff Added");
        new Add_Staff(add_staff.staffBody, add_staff.staffHeader, add_staff.staffSide);
    }
}

