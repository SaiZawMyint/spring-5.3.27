package com.mtm.plan.bl.dto;

import java.io.Serializable;

import com.mtm.plan.persistence.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Write the data transfer object here...<br>
 * This is the place to write the data transfer object.
 * * <br>
 * <pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -4901965391008029261L;
    Integer id;
    String name;

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}
