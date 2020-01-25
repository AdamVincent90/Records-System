/*
    This class controls controls the interaction of all components within the DepartmentsManageView class, this includes
    the drop-downs, textfields, and table, this also updates the table and filters data without the user needed to
    change section and back.
*/

package Controller;

import Application.Controller;
import View.DepartmentEditForm;
import View.DepartmentsManageView;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DepartmentManageController extends Controller {

    private DepartmentsManageView departmentsManageView;
    private DepartmentEditForm departmentEditForm;

    public DepartmentManageController(DepartmentsManageView departmentsManageView, DepartmentEditForm departmentEditForm) {
        this.departmentsManageView = departmentsManageView;
        this.departmentEditForm = departmentEditForm;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == departmentsManageView.selectRowButton) {
            ArrayList<String> result = new ArrayList<>();
            int getRow = departmentsManageView.depTable.getSelectedRow();
            int getColumn = departmentsManageView.depTable.getColumnCount();
            for (int i = 0; i < getColumn - 1; i++) {
                result.add(String.valueOf(departmentsManageView.depTable.getValueAt(getRow, i)));
            }
            new DepartmentEditForm(result, (Integer) departmentsManageView.tableModel.getValueAt(getRow, 6), departmentsManageView.depBody,
                    departmentsManageView.depHead, departmentsManageView.depSide, departmentsManageView.depId);
        }

        if (source == departmentsManageView.depSearch) {
            departmentsManageView.j = 0;
            departmentsManageView.updateTableRows(departmentsManageView.tfDepSearch.getText());
        }
    }
}
