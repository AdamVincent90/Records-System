/*
    This class controls the interactions between the LecturersEditForm class, this controls the logic based on what
    the user selects, if the user presses the edit button, the existing data is rewritten in the file and instantly
    displayed in the departments table in LecturersManageView.
*/

package Controller;

import Application.Controller;
import Model.File_Writer;
import View.LecturerEditForm;
import View.LecturersManageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class LecturerFormController extends Controller {

    private LecturerEditForm lecturerEditForm;

    public LecturerFormController(LecturerEditForm lecturerEditForm) {
        this.lecturerEditForm = lecturerEditForm;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == lecturerEditForm.lecEdit) {
            HashMap<String, String> resultSet = new HashMap<>();

            resultSet.put("lec_id", lecturerEditForm.dataList.get(0).getText());
            resultSet.put("first_name", lecturerEditForm.dataList.get(1).getText());
            resultSet.put("last_name", lecturerEditForm.dataList.get(2).getText());
            resultSet.put("contact", lecturerEditForm.dataList.get(3).getText());
            resultSet.put("email", lecturerEditForm.dataList.get(4).getText());
            resultSet.put("start_date", lecturerEditForm.dataList.get(5).getText());
            resultSet.put("dep_id", lecturerEditForm.dataList.get(6).getText());
            resultSet.put(lecturerEditForm.informationKey, lecturerEditForm.dataList.get(7).getText());


            File_Writer updateFile = new File_Writer(resultSet, lecturerEditForm.formBody, lecturerEditForm.formHead, lecturerEditForm.formSide, lecturerEditForm.pathName, lecturerEditForm.fileNum);
            updateFile.editFile();
            lecturerEditForm.lecDialog.setVisible(false);
            JOptionPane.showMessageDialog(null, "Lecturer has been edited");
            new LecturersManageView(lecturerEditForm.formBody, lecturerEditForm.formHead, lecturerEditForm.formSide, lecturerEditForm.depId);
        }

        if (source == lecturerEditForm.lecDelete) {
            File_Writer deleteFile = new File_Writer(null, lecturerEditForm.formBody, lecturerEditForm.formHead, lecturerEditForm.formSide, lecturerEditForm.pathName, lecturerEditForm.fileNum);
            deleteFile.delFile();
            lecturerEditForm.lecDialog.setVisible(false);
            JOptionPane.showMessageDialog(null, "Lecturer has been deleted");
            new LecturersManageView(lecturerEditForm.formBody, lecturerEditForm.formHead, lecturerEditForm.formSide, lecturerEditForm.depId);
        }
    }
}
