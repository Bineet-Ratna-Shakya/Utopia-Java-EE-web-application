package model;

import java.io.Serializable;

public class UtopiaModel implements Serializable {
    private static final long serialVersionUID = 1L;
  
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean admin;

    public UtopiaModel() {}

    public UtopiaModel(String firstName, String lastName, String email, String password, String phoneNumber, boolean admin) {
 
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.admin = admin;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
