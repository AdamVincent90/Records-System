/*
    This class is used as the main navigation tool for the user to change which section the user wishes to use, this
    offers action listeners for each navigation button which call their respective view class upon selecting.
*/

package Controller;

import Application.Controller;
import View.*;

import java.awt.event.ActionEvent;

public class DashboardController extends Controller {

    private DashboardView dashboardView;

    public DashboardController(DashboardView dashboardView) {
        this.dashboardView = dashboardView;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == dashboardView.addDepartment) {
            new AddDepartmentView(dashboardView.body, dashboardView.banner, dashboardView.side);
        }

        if (source == dashboardView.addLecturer) {
            new AddLecturerView(dashboardView.body, dashboardView.banner, dashboardView.side);
        }

        if (source == dashboardView.logOut) {
            new LogInView(dashboardView.body, dashboardView.side, dashboardView.banner);
        }

        if (source == dashboardView.Departments) {
            new DepartmentsManageView(dashboardView.body, dashboardView.banner, dashboardView.side, dashboardView.depId);
        }

        if (source == dashboardView.Lecturers) {
            new LecturersManageView(dashboardView.body, dashboardView.banner, dashboardView.side, dashboardView.depId);
        }

        if (source == dashboardView.staff) {
            new Staff_Management(dashboardView.body, dashboardView.banner, dashboardView.side, dashboardView.depId);
        }

        if (source == dashboardView.addStaff) {
            new Add_Staff(dashboardView.body, dashboardView.banner, dashboardView.side);
        }
    }
}
