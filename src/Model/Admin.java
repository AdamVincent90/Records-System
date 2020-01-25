/*
    This class stores all associated object data to be retrieved and displayed, this class also uses a method which
    allows to store the object information into a collection, this case a HashMap. The HashMap is then used to be
    written into a file within the parent File_writer class.
*/

package Model;

import java.util.HashMap;

public class Admin extends Human_Resource_Staff {

    public String admin_id;
    public HashMap<String, String> adminFile;

    public Admin(String first_name, String last_name, String date_of_birth, String employment_date, String department_id, String admin_id, String password) {
        super(first_name, last_name, date_of_birth, employment_date, department_id, password);
        this.admin_id = admin_id;
        this.adminFile = getAdminHash();
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public void setSecretary_id(String secretary_id) {
        this.admin_id = secretary_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmployment_date() {
        return employment_date;
    }

    public String getDepartmentId() {
        return department_id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public String getAdminPassword() {
        return password;
    }

    public HashMap<String, String> getAdminHash() {
        HashMap<String, String> adminTemp = new HashMap<>();

        adminTemp.put("admin_id", getAdmin_id());
        adminTemp.put("password", getAdminPassword());
        adminTemp.put("first_name", getFirst_name());
        adminTemp.put("last_name", getLast_name());
        adminTemp.put("date_of_birth", getDate_of_birth());
        adminTemp.put("employment_date", getEmployment_date());
        adminTemp.put("department_id", getDepartmentId());


        return adminTemp;
    }
}
