package entity;

public class User extends BaseEntity {
    private String firstName;
    private String passwordString;

    public User(String firstName, String password) {
        this.firstName = firstName;
        this.passwordString = password;
        this.setCreationDate();
    }

    public User(int id, String firstName, String password, String creationDate) {
        this.setId(id);
        this.firstName = firstName;
        this.passwordString = password;
        this.setCreationDate(creationDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPasswordString() {
        return passwordString;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPasswordString(String passwordString) {
        this.passwordString = passwordString;
    }
}
