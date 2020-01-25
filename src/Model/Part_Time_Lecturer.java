/*
    This class stores all associated object data to be retrieved and displayed, this class also uses a method which
    allows to store the object information into a collection, this case a HashMap. The HashMap is then used to be
    written into a file within the parent File_writer class.
*/

package Model;

import java.util.HashMap;

public class Part_Time_Lecturer extends Lecturer {

    private String hourly_rate;
    public HashMap<String, String> ptLecturerFile;

    public Part_Time_Lecturer(String first_name, String last_name, String contact_number, String email_address, String start_date, String department_id, String hourly_rate) {
        super(first_name, last_name, contact_number, email_address, start_date, department_id);
        this.hourly_rate = hourly_rate;
        this.ptLecturerFile = getPtLecturer();
    }

    public void setHourly_rate(String hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public String getHourly_rate() {
        return this.hourly_rate;
    }

    public HashMap<String, String> getPtLecturer() {
        HashMap<String, String> ptTemp = new HashMap<>();
        ptTemp.put("lec_id", getLec_id());
        ptTemp.put("first_name", getFirst_name());
        ptTemp.put("last_name", getLast_name());
        ptTemp.put("contact", getContact_number());
        ptTemp.put("email", getEmail_address());
        ptTemp.put("start_date", getStart_date());
        ptTemp.put("dep_id", getDepartment_id());
        ptTemp.put("hourly_rate", getHourly_rate());

        return ptTemp;
    }
}
