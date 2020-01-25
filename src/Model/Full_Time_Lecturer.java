/*
    This class stores all associated object data to be retrieved and displayed, this class also uses a method which
    allows to store the object information into a collection, this case a HashMap. The HashMap is then used to be
    written into a file within the parent File_writer class.
*/

package Model;

import java.util.HashMap;

public class Full_Time_Lecturer extends Lecturer {

    private String salary;
    public HashMap<String, String> ftLecturerFile;

    public Full_Time_Lecturer(String first_name, String last_name, String contact_number, String email_address, String start_date, String department_id, String salary) {
        super(first_name, last_name, contact_number, email_address, start_date, department_id);
        this.salary = salary;
        this.ftLecturerFile = getFtLecturer();
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public HashMap<String, String> getFtLecturer() {
        HashMap<String, String> temp = new HashMap<>();

        temp.put("lec_id", getLec_id());
        temp.put("first_name", getFirst_name());
        temp.put("last_name", getLast_name());
        temp.put("contact", getContact_number());
        temp.put("email", getEmail_address());
        temp.put("start_date", getStart_date());
        temp.put("dep_id", getDepartment_id());
        temp.put("salary", getSalary());

        return temp;
    }
}
