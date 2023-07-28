package com.mtm.plan.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Write the entity here...<br>
 * This is the place to write entity or table for database model.
 * * <br>
 * <pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 *
 */
@Entity
@Table(name = "persistent_logins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersistentLogins{

    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "series", length = 64, nullable = false)
    private String series;

    @Column(name = "username", length = 64, nullable = false)
    private String username;

    @Column(name = "token", length = 64, nullable = false)
    private String token;

    @Column(name = "last_used", nullable = false)
    private LocalDateTime lastUsed;

}
