package model;

public class RegisterUser {
    String userName;
    String passWord;
    String Email;

    @Override
    public String toString() {
        return "RegisterUser{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public RegisterUser(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        Email = email;
    }

    public RegisterUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
