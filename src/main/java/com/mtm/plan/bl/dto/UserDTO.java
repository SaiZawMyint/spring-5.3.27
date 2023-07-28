package com.mtm.plan.bl.dto;

import com.mtm.plan.persistence.entity.User;
import com.mtm.plan.web.forms.UserForm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Write the data transfer object here...<br>
 * This is the place to write the data transfer object.
 * * <br>
 * <pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = -4600001884142621302L;
    Integer id;
    String name;
    String email;
    String password;
    RoleDTO role;
    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = new RoleDTO(user.getRole());
    }

    public UserDTO(UserForm form) {
        this.id = form.getId();
        this.name = form.getName();
        this.email = form.getEmail();
        this.password = form.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles = new ArrayList<>();
        roles.add(this.role.getName());
        return roles.stream().map(r -> new SimpleGrantedAuthority(r)).toList();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
