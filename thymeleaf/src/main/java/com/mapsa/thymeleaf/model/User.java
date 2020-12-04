package com.mapsa.thymeleaf.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "_user")
@Table(name = "user_tbl")
//@Inheritance(strategy = )
//@SequenceGenerator(sequenceName = )
public class User extends BaseEntity<Long> {
    @NotBlank(message = "cannot be blank")
    @Size(min = 3, max = 60, message = "size must be between 3 and 60")
//    @Min()
    @Basic(fetch = FetchType.EAGER)
    @Column(length = 60, unique = true, nullable = false)
    private String name;
    @Size(min = 4, max = 256, message = "size must be between 4 and 32")
    @NotBlank(message = "cannot be blank")
    @Column(length = 32, nullable = false)
    private String password;
    //    @Pattern(regexp = "")
    @Email(message = "email must be valid")
    @Column(length = 90, nullable = false)
    private String email;
    @PastOrPresent
    private LocalDateTime creationDate = LocalDateTime.now();

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
