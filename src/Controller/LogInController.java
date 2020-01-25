/*
    This log-in controller processes the logic for when the user submits their credentials, this compares their id to
    the serialised files, if that matches, it then compares the password for a match, upon success, the user is sent to
    the dashboard area and has access to the main navigation buttons.
*/

package Controller;

import Application.Controller;
import Model.File_Writer;
import View.DashboardView;
import View.LogInView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;

public class LogInController extends Controller {

    private LogInView LogInView;
    private String username;
    private String password;
    private HashMap<String, String> confirmLogin;
    private String message;

    public LogInController(LogInView LogInView) {
        this.LogInView = LogInView;
    }


    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == this.LogInView.getSubmit()) {


            this.username = LogInView.username.getText();
            this.password = LogInView.password.getText();
            this.message = "Invalid Username or Password";
            this.confirmLogin = new HashMap<>();

            File_Writer findUsername = new File_Writer(null, null, null, null, "departments", 0);
            File_Writer finderAdminUsername = new File_Writer(null, null, null, null, "staff/all/admin", 0);

            for (int i = 0; i < findUsername.fileCount(0, ""); i++) {
                try {
                    this.confirmLogin = findUsername.readFile(i, "");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (this.confirmLogin.get("dep_username").equals(this.username)) {

                    if (this.confirmLogin.get("dep_password").equals(this.password)) {
                        String depId = confirmLogin.get("dep_id");
                        int accessLevel = 0;
                        new DashboardView(LogInView.body, LogInView.side, LogInView.banner, accessLevel, depId);
                        this.message = "You are now logged in as the department: " + confirmLogin.get("dep_name");
                        this.confirmLogin.clear();
                        break;
                    }
                }
            }
            for (int i = 0; i < finderAdminUsername.fileCount(0, ""); i++) {
                try {
                    this.confirmLogin = finderAdminUsername.readFile(i, "");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (this.confirmLogin.get("admin_id").equals(this.username)) {

                    if (this.confirmLogin.get("password").equals(this.password)) {
                        int accessLevel = 1;
                        new DashboardView(LogInView.body, LogInView.side, LogInView.banner, accessLevel, null);
                        this.message = "You are now logged in as: " + this.confirmLogin.get("first_name") + " " + this.confirmLogin.get("last_name");
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, this.message);
        }
    }
}
