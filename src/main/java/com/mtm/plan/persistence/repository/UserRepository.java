package com.mtm.plan.persistence.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mtm.plan.persistence.entity.User;

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
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value="SELECT u FROM User u WHERE u.email=:email")
    public User getUserByEmail(@Param("email") String email);

    @Query(value="SELECT * FROM user as u WHERE u.role_id = 1", nativeQuery = true)
    public User getAdmin();

}