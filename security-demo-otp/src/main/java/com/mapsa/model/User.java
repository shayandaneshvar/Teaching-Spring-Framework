package com.mapsa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "_user")
@Table(name = "user_tbl")
public class User extends BaseEntity<Long> {
    @NotBlank(message = "cannot be blank")
    @Size(min = 3, max = 60, message = "size must be between 3 and 60")
    @Basic(fetch = FetchType.EAGER)
    @Column(length = 60, unique = true, nullable = false)
    private String name;
    @Size(min = 4, max = 256, message = "size must be between 4 and 32")
    @NotBlank(message = "cannot be blank")
    @Column(length = 32, nullable = false)
    private String password;
    @Email(message = "email must be valid")
    @Column(length = 90, nullable = false)
    private String email;
    @PastOrPresent
    private LocalDateTime creationDate = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Roles> roles = new ArrayList<>(List.of(Roles.USER));
    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    private OneTimePassword oneTimePassword;
}
