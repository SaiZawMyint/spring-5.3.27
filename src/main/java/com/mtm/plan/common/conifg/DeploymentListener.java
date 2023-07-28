package com.mtm.plan.common.conifg;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mtm.plan.persistence.entity.Role;
import com.mtm.plan.persistence.entity.User;
import com.mtm.plan.persistence.repository.RoleRepository;
import com.mtm.plan.persistence.repository.UserRepository;
import com.mtm.plan.utils.PropertyUtils;

/**
 * Write your deployment configuration here...<br>
 * This is the main place where to define configuration for your app.
 *
 * @author SaiZawMyint
 */
@Component
public class DeploymentListener {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    
    @Value("${app.roles}")
    String appRoles;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void dataFactory() {
        //Add roles
        addRoles();
        //Add admin
        addAdmin();

    }
    private void addRoles() {
        List<String> roleProps = PropertyUtils.parseStringListProperty(appRoles);
        for(String r:roleProps) {
            if(roleRepository.getRoleByName(r) == null) {
                Role role = new Role();
                role.setName(r);
                roleRepository.save(role);
            }
        }
    }

    private void addAdmin() {
        User admin = this.userRepository.getAdmin();
        if(admin == null) {
            User adminUser = new User();
            adminUser.setName("Admin");
            adminUser.setEmail("admin@gmail.com");
            adminUser.setPassword(bCryptPasswordEncoder.encode("111111"));
            adminUser.setRole(roleRepository.getReferenceById(1));
            this.userRepository.save(adminUser);
        }
    }
}
