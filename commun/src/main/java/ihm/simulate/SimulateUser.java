package ihm.simulate;

import java.util.List;

import dao.WorkSpace;

public class SimulateUser {

    public SimulateUser(String firstName, String lastName, String login, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    private String login;

    private String password;

    private String lastName;

    private String firstName;

    private String phoneNumber;

    private List<WorkSpace> assigne;

    public List<WorkSpace> getAssigne() {
        return assigne;
    }

    public void setAssigne(List<WorkSpace> assigne) {
        this.assigne = assigne;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
