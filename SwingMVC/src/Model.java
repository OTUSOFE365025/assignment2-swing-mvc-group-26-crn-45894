/**
 * Very small data model used for the demo GUI.
 *
 * It simply stores the user's first and last name and exposes
 * standard getters and setters. Keeping the model tiny makes the
 * example easier to understand for the assignment.
 */
public class Model {
    private String firstname;
    private String lastname;

    public Model(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
