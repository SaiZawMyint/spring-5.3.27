package com.mtm.plan.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtm.plan.persistence.entity.Role;

/**
 *
 * Write database repository here...<br>
 * This is the place to make transition between the application and the database.
 * <br>
 * <pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT r FROM Role r WHERE r.name = :name")
    public Role getRoleByName(@Param("name") String name);

}
