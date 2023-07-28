package com.mtm.plan.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mtm.plan.persistence.entity.PasswordResetToken;

public interface TokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    
    @Query(value = "SELECT * FROM password_reset_token where user_id=:userId and used <> 1", nativeQuery = true)
    public PasswordResetToken getTokenByUserId(@Param("userId") Integer userId);
}
