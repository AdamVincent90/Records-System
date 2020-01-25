/*
    This class stores all associated object data to be retrieved and displayed, this class also uses a method which
    allows to store the object information into a collection, this case a HashMap. The HashMap is then used to be
    written into a file within the parent File_writer class.
*/

package Model;

import java.io.Serializable;
import java.time.Year;
import java.util.HashMap;
import java.util.Random;

public class Department implements Serializable {

    private String department_id;
    private String department_name;
    private String department_type;
    private String department_username;
    private String department_password;
    private String department_web;

    public HashMap<String, String> departmentFile;

    public Department(String department_id, String department_name, String department_type, String department_web) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_type = department_type;
        this.department_web = department_web;
        generateUsername();
        generatePassword();

        this.departmentFile = new HashMap<String, String>();
        this.departmentFile = getDepHash();
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setDepartment_type(String department_type) {
        this.department_type = department_type;
    }

    public void generateUsername() {
        String temp = "";
        temp = getDepartment_name() + Year.now().getValue();

        this.department_username = temp;

    }

    public void generatePassword() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        this.department_password = String.format("%06d", number);
    }


    public String getDepartment_id() {
        return department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getDepartment_type() {
        return department_type;
    }

    public String getDepartment_web() { return department_web; }

    public String getDepartment_password() {
        return department_password;
    }

    public String getDepartment_username() {
        return department_username;
    }

    public HashMap<String, String> getDepHash() {
        HashMap<String, String> depTemp = new HashMap<String, String>();

        depTemp.put("dep_id", getDepartment_id());
        depTemp.put("dep_name", getDepartment_name());
        depTemp.put("dep_type", getDepartment_type());
        depTemp.put("dep_web", getDepartment_web());
        depTemp.put("dep_password", getDepartment_password());
        depTemp.put("dep_username", getDepartment_username());

        return depTemp;
    }
}
