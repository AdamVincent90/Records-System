/*
    This class is used to control the user interactions between the user and program, this class focuses on allowing
    the user to add an lecturer to store within the table of the "LecturersManageView" class, this also saves the
    lecturer to a serialized file. This also includes each type of lecturer.
*/

package Controller;

import Application.Controller;
import Model.Contract_Lecturer;
import Model.File_Writer;
import Model.Full_Time_Lecturer;
import Model.Part_Time_Lecturer;
import View.AddLecturerView;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class AddLecturerController extends Controller {

    private AddLecturerView addLecturerView;

    public AddLecturerController(AddLecturerView addLecturerView) {
        this.addLecturerView = addLecturerView;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == addLecturerView.lecType) {
            switch (String.valueOf(addLecturerView.lecType.getSelectedItem())) {
                case "Part-Time":
                    addLecturerView.setDropDownInstance("Hourly Rate: ", "Add Part-Time Lecturer");
                    break;
                case "Full-Time":
                    addLecturerView.setDropDownInstance("Salary: ", "Add Full-Time Lecturer");
                    break;
                case "Contract":
                    addLecturerView.setDropDownInstance("End Date: ", "Add Contract Lecturer");
                    break;
            }
        }

        if (source == addLecturerView.lecSubmit) {
            switch (String.valueOf(addLecturerView.lecType.getSelectedItem())) {
                case "Part-Time":
                    Part_Time_Lecturer ptLecturer = new Part_Time_Lecturer
                            (addLecturerView.tfFname.getText(),
                                    addLecturerView.tfLname.getText(), addLecturerView.tfContact.getText(),
                                    addLecturerView.tfEmail.getText(), addLecturerView.tfStart.getText(),
                                    addLecturerView.tfDepId.getText(), addLecturerView.tfPartTime.getText());
                    File_Writer ptLecFile = new File_Writer(ptLecturer.ptLecturerFile, addLecturerView.lecBody, addLecturerView.title, addLecturerView.lecSide, "lecturers/all/part_time", 0);
                    ptLecFile.writeFile();
                    confirmation();
                    break;

                case "Full-Time":
                    Full_Time_Lecturer ftLecturer = new Full_Time_Lecturer
                            (addLecturerView.tfFname.getText(), addLecturerView.tfLname.getText(),
                                    addLecturerView.tfContact.getText(), addLecturerView.tfEmail.getText(),
                                    addLecturerView.tfStart.getText(), addLecturerView.tfDepId.getText(),
                                    addLecturerView.tfPartTime.getText());
                    File_Writer ftLecFile = new File_Writer(ftLecturer.ftLecturerFile, addLecturerView.lecBody, addLecturerView.title, addLecturerView.lecSide, "lecturers/all/full_time/", 0);
                    ftLecFile.writeFile();
                    confirmation();
                    break;

                case "Contract":
                    Contract_Lecturer cLecturer = new Contract_Lecturer
                            (addLecturerView.tfFname.getText(), addLecturerView.tfLname.getText(),
                                    addLecturerView.tfContact.getText(), addLecturerView.tfEmail.getText(),
                                    addLecturerView.tfStart.getText(), addLecturerView.tfDepId.getText(),
                                    addLecturerView.tfPartTime.getText());
                    File_Writer cLecFile = new File_Writer(cLecturer.cLecturerFile, addLecturerView.lecBody, addLecturerView.title, addLecturerView.lecSide, "lecturers/all/contract/", 0);
                    cLecFile.writeFile();
                    confirmation();
                    break;
            }

        }
    }

    public void confirmation() {
        JOptionPane.showMessageDialog(null, "Lecturer Added");
        new AddLecturerView(addLecturerView.lecBody, addLecturerView.title, addLecturerView.lecSide);
    }
}
