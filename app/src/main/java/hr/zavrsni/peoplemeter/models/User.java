package hr.zavrsni.peoplemeter.models;

public class User {
    public User(String username, String password) {
        Username = username;
        Password = password;
    }

    public User(String name, String surname, String password, String username, String email, String phoneNumber) {
        Name = name;
        Surname = surname;
        Password = password;
        Username = username;
        Email = email;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    private String Name;

    private String Surname;

    private String Password;

    private String Username;

    private String Email;

    private String PhoneNumber;
}
