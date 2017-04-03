package eu.programisci.Test;

import java.util.Date;

public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String login;
    private String password;
    private String email;
    private Date creationDate;

    public UserDTO() {
    }

    public UserDTO(String aName, String aLastname, String aLogin, String aPassword, String aEmail) {
        name = aName;
        lastname = aLastname;
        login = aLogin;
        password = aPassword;
        email = aEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getName() {
        System.out.println("UserDTO.java - Pobieram imie: "+name);
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String aLastname) {
        lastname = aLastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String aLogin) {
        login = aLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String aPassword) {
        password = aPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String aEmail) {
        email = aEmail;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date aCreationDate) {
        creationDate = aCreationDate;
    }
}
