/*
    The super-class for all lecturers which includes sub-classes full time, part time, and contract lecturers, this
     stores all the generic information which is used by both sub-classes.
*/

package Model;

import java.io.Serializable;
import java.util.Random;

public class Lecturer implements Serializable {

    protected String first_name;
    protected String last_name;
    protected String contact_number;
    protected String email_address;
    protected String start_date;
    protected String department_id;
    protected String lec_id;

    public Lecturer(String first_name, String last_name, String contact_number, String email_address, String start_date, String department_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact_number = contact_number;
        this.email_address = email_address;
        this.start_date = start_date;
        this.department_id = department_id;
        this.lec_id = generateStaffId();
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String generateStaffId() {
        Random rnd = new Random();
        int number = rnd.nextInt(99999);

        return this.lec_id = String.format("%06d", number);
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public String getLec_id() {
        return lec_id;
    }
}
