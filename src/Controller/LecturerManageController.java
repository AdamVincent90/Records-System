/*
    This class controls controls the interaction of all components within the LecturersManageView class, this includes
    the drop-downs, textfields, and table, this also updates the table and filters data without the user needed to
    change section and back.
*/

package Controller;

import Application.Controller;
import View.LecturerEditForm;
import View.LecturersManageView;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class LecturerManageController extends Controller {

    private LecturersManageView lecturersManageView;

    public LecturerManageController(LecturersManageView lecturersManageView) {
        this.lecturersManageView = lecturersManageView;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == lecturersManageView.lecSelect) {
            callTableResults("");
            lecturersManageView.lecSearch.setText("");
        }

        if (source == lecturersManageView.lecSearchButton) {
            callTableResults(lecturersManageView.lecSearch.getText());
            System.out.println(lecturersManageView.lecSearch.getText());
        }

        if (source == lecturersManageView.selectRow) {
            ArrayList<String> result = new ArrayList<>();
            int getRow = lecturersManageView.depTableLec.getSelectedRow();
            int getColumn = lecturersManageView.depTableLec.getColumnCount();
            for (int i = 0; i < getColumn - 2; i++) {
                result.add(String.valueOf(lecturersManageView.depTableLec.getValueAt(getRow, i)));
            }
            switch (String.valueOf(lecturersManageView.lecSelect.getSelectedItem())) {

                case "Full-Time":
                    new LecturerEditForm
                            (result, (Integer) lecturersManageView.tableModel.getValueAt(getRow, 8),
                                    "/lecturers/all/full_time", "Salary:",
                                    lecturersManageView.lecBody, lecturersManageView.lecHead,
                                    lecturersManageView.lecSide, lecturersManageView.depId);
                    break;
                case "Part-Time":
                    new LecturerEditForm
                            (result, (Integer) lecturersManageView.tableModel.getValueAt(getRow, 8),
                                    "/lecturers/all/part_time", "Hourly Rate:",
                                    lecturersManageView.lecBody, lecturersManageView.lecHead,
                                    lecturersManageView.lecSide, lecturersManageView.depId);
                    break;
                case "Contract":
                    new LecturerEditForm
                            (result, (Integer) lecturersManageView.tableModel.getValueAt(getRow, 8),
                                    "/lecturers/all/contract", "End Date:",
                                    lecturersManageView.lecBody, lecturersManageView.lecHead,
                                    lecturersManageView.lecSide, lecturersManageView.depId);
                    break;
                case "All":
                    new LecturerEditForm
                            (result, (Integer) lecturersManageView.tableModel.getValueAt(getRow, 8),
                                    "/lecturers/all/" + lecturersManageView.tableModel.getValueAt(getRow, 9),
                                    (String) lecturersManageView.tableModel.getValueAt(getRow, 9),
                                    lecturersManageView.lecBody, lecturersManageView.lecHead,
                                    lecturersManageView.lecSide, lecturersManageView.depId);
                    break;
            }
        }

    }

    public void callTableResults(String filter) {
        switch (String.valueOf(lecturersManageView.lecSelect.getSelectedItem())) {
            case "Full-Time":
                lecturersManageView.j = 0;
                lecturersManageView.updateTableColumn("Salary", "lecturers/all/full_time", filter, "full_time");
                break;
            case "Part-Time":
                lecturersManageView.j = 0;
                lecturersManageView.updateTableColumn("Hourly Rate", "lecturers/all/part_time", filter, "part_time");
                break;
            case "Contract":
                lecturersManageView.j = 0;
                lecturersManageView.updateTableColumn("End Date", "lecturers/all/contract", filter, "contract");
                break;
            case "All":
                lecturersManageView.j = 0;
                lecturersManageView.updateTableColumn("Salary/Wage/End", "lecturers/all/", filter, "");
        }
    }
}


