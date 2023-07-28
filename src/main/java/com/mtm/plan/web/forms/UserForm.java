package com.mtm.plan.web.forms;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.persistence.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Write your web form here...
 * This is the main place where to make form for request and response.
 *
 * Note::Please do not use the business logic here!
 *
 * @author SaiZawMyint
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    public UserForm(UserDTO user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserForm(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
    
    private String password;
    
    @NotEmpty
    private List<Integer> roles;
}
