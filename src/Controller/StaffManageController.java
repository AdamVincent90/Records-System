/*
    This class controls controls the interaction of all components within the Staff_Management class, this includes
    the drop-downs, textfields, and table, this also updates the table and filters data without the user needed to
    change section and back.
*/

package Controller;

import Application.Controller;
import View.StaffEditForm;
import View.Staff_Management;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class StaffManageController extends Controller {

    private Staff_Management staff_management;

    public StaffManageController(Staff_Management staff_management) {
        this.staff_management = staff_management;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == staff_management.staffRole) {

            callTableResults("");
            staff_management.staffSearch.setText("");
        }

        if (source == staff_management.searchButton) {
            callTableResults(staff_management.staffSearch.getText());
            System.out.println(staff_management.staffSearch.getText());
        }

        if (source == staff_management.editStaff) {
            ArrayList<String> result = new ArrayList<>();
            int getRow = staff_management.staffTable.getSelectedRow();
            int getColumn = staff_management.staffTable.getColumnCount();


            for (int i = 0; i < getColumn - 2; i++) {
                result.add(String.valueOf(staff_management.staffTable.getValueAt(getRow, i)));
            }

            switch (String.valueOf(staff_management.staffRole.getSelectedItem())) {

                case "Admin":
                    new StaffEditForm
                            (result, (Integer) staff_management.tableModel.getValueAt(getRow, 7),
                                    "/staff/all/admin", "Admin Id:",
                                    staff_management.staffBody, staff_management.staffHeader,
                                    staff_management.staffSide, staff_management.depId);
                    break;
                case "Secretary":
                    new StaffEditForm
                            (result, (Integer) staff_management.tableModel.getValueAt(getRow, 7),
                                    "/staff/all/secretary", "Secretary Id:",
                                    staff_management.staffBody, staff_management.staffHeader,
                                    staff_management.staffSide, staff_management.depId);
                    break;
                case "All":
                    new StaffEditForm
                            (result, (Integer) staff_management.tableModel.getValueAt(getRow, 7),
                                    "/staff/all/" + staff_management.tableModel.getValueAt(getRow, 8),
                                    (String) staff_management.tableModel.getValueAt(getRow, 8),
                                    staff_management.staffBody, staff_management.staffHeader,
                                    staff_management.staffSide, staff_management.depId);
                    break;
            }
        }
    }


    public void callTableResults(String filter) {
        switch (String.valueOf(staff_management.staffRole.getSelectedItem())) {
            case "Admin":
                staff_management.j = 0;
                staff_management.updateTableColumn("Admin Id", "staff/all/admin", filter, "admin");
                break;
            case "Secretary":
                staff_management.j = 0;
                staff_management.updateTableColumn("Secretary Id", "staff/all/secretary", filter, "secretary");
                break;
            case "All":
                staff_management.j = 0;
                staff_management.updateTableColumn("Admin/Department Id", "staff/all/", filter, "");
                break;
        }
    }
}
