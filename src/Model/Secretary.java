/*
    This class stores all associated object data to be retrieved and displayed, this class also uses a method which
    allows to store the object information into a collection, this case a HashMap. The HashMap is then used to be
    written into a file within the parent File_writer class.
*/

package Model;

import java.util.HashMap;

public class Secretary extends Human_Resource_Staff {

    private String secretary_id;
    public HashMap<String, String> secFile;

    public Secretary(String first_name, String last_name, String date_of_birth, String employment_date, String department_id, String secretary_id, String password) {
        super(first_name, last_name, date_of_birth, employment_date, department_id, password);
        this.secretary_id = secretary_id;
        this.secFile = getSecHash();
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmployment_date(String employment_date) {
        this.employment_date = employment_date;
    }

    public void setDepartmentId(String departmentId) {
        this.department_id = departmentId;
    }

    public void setSecretary_id(String secretary_id) {
        this.secretary_id = secretary_id;
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

    public String getSecretary_id() {
        return secretary_id;
    }

    public String getPassword() {
        return password;
    }

    public HashMap<String, String> getSecHash() {
        HashMap<String, String> secTemp = new HashMap<>();

        secTemp.put("secretary_id", getSecretary_id());
        secTemp.put("password", getPassword());
        secTemp.put("first_name", getFirst_name());
        secTemp.put("last_name", getLast_name());
        secTemp.put("date_of_birth", getDate_of_birth());
        secTemp.put("employment_date", getEmployment_date());
        secTemp.put("department_id", getDepartmentId());
        return secTemp;
    }
}
