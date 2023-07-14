package booking.beans;

import java.util.StringJoiner;

public class User {
    private long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String phoneNumbers ;
    private int gender;
    private String address;
    private String role;
    public User() {}

    public User(long id,
                String username,
                String password,
                String fullName,
                String email,
                String phoneNumbers,
                int gender,
                String address,
                String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.gender = gender;
        this.address = address;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + username + "'")
                .add("passWord='" + password + "'")
                .add("fullName='" + fullName + "'")
                .add("email='" + email + "'")
                .add("phoneNumber='" + phoneNumbers + "'")
                .add("gender=" + gender)
                .add("address='" + address + "'")
                .add("role='" + role + "'")
                .toString();
    }
}
