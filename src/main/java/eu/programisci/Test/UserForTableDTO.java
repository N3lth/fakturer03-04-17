package eu.programisci.Test;

import java.util.Date;

public class UserForTableDTO {

    private Long id;
    private String name;
    private String lastname;
    private String login;
    private Date creationDate;

    public UserForTableDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long aId) {
        id = aId;
    }

    public String getName() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date aCreationDate) {
        creationDate = aCreationDate;
    }
}
