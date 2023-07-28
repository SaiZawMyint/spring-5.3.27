package com.mtm.plan.bl.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.bl.service.UserService;
import com.mtm.plan.persistence.entity.Role;
import com.mtm.plan.persistence.entity.User;
import com.mtm.plan.persistence.repository.RoleRepository;
import com.mtm.plan.persistence.repository.UserRepository;
import com.mtm.plan.web.forms.UserForm;

/**
 * Write the application business logic here... <br>
 * This the place to execute the business logic.
 *
 * @author SaiZawMyint
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired 
    RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserDTO> doGetAllUsers() {
        return this.userRepository.findAll().stream().map(u -> new UserDTO(u)).toList();
    }

    @Override
    public UserDTO doAddUser(UserForm form) {
        User user = new User(form);
        Role role = roleRepository.getReferenceById(form.getRoles().get(0));
        user.setRole(role);
        user.setPassword(bCryptPasswordEncoder.encode(form.getPassword()));
        User createdUser = this.userRepository.save(user);
        return new UserDTO(createdUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Bad Credential!");
        }
        return new UserDTO(user);
    }

    @Override
    public UserDTO doGetUserByEmail(String email) {
        User user = this.userRepository.getUserByEmail(email);
        
        return new UserDTO(user);
    }

}
