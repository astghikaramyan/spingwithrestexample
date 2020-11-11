package am.bdg.dto;

import com.sun.istack.NotNull;
import lombok.*;

/**
 * Created by User on 08.11.2020.
 */
@Data
@EqualsAndHashCode
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
