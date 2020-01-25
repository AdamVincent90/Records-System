/*
    The super-class for all staff which includes sub-classes Secretary and Admin, this stores all the generic information
    which is used by both sub-classes.
*/

package Model;

import java.io.Serializable;

public class Human_Resource_Staff implements Serializable {

    protected String first_name;
    protected String last_name;
    protected String date_of_birth;
    protected String employment_date;
    protected String department_id;
    protected String password;

    public Human_Resource_Staff(String first_name, String last_name, String date_of_birth, String employment_date, String department_id, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.employment_date = employment_date;
        this.department_id = department_id;
        this.password = password;
    }

}
