/*
    This class stores all associated object data to be retrieved and displayed, this class also uses a method which
    allows to store the object information into a collection, this case a HashMap. The HashMap is then used to be
    written into a file within the parent File_writer class.
*/

package Model;

import java.util.HashMap;

public class Contract_Lecturer extends Lecturer {

    private String end_date;
    public HashMap<String, String> cLecturerFile;

    public Contract_Lecturer(String first_name, String last_name, String contact_number, String email_address, String start_date, String department_id, String end_date) {
        super(first_name, last_name, contact_number, email_address, start_date, department_id);
        this.end_date = end_date;
        this.cLecturerFile = getCLecturer();
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public HashMap<String, String> getCLecturer() {
        HashMap<String, String> cTemp = new HashMap<>();

        cTemp.put("lec_id", getLec_id());
        cTemp.put("first_name", getFirst_name());
        cTemp.put("last_name", getLast_name());
        cTemp.put("contact", getContact_number());
        cTemp.put("email", getEmail_address());
        cTemp.put("start_date", getStart_date());
        cTemp.put("dep_id", getDepartment_id());
        cTemp.put("end_date", getEnd_date());

        return cTemp;
    }
}
