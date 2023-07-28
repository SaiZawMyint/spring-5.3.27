package com.mtm.plan.bl.service;

import java.util.List;

import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.web.forms.UserForm;

/**
 * Write the service interface here...<br>
 * This is the place to write the service interface.
 *
 * @author SaiZawMyint
 *
 */
public interface UserService {
    public List<UserDTO> doGetAllUsers();
    public UserDTO doGetUserByEmail(String email);
    public UserDTO doAddUser(UserForm form);
}
