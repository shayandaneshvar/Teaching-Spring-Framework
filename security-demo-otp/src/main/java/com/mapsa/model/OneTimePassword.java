package com.mapsa.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "OTP")
@Accessors(chain = true)
public class OneTimePassword {
    public static int OTP_VALIDATION_DURATION = 1000 * 60 * 60 * 3;
//    public static int OTP_VALIDATION_DURATION = 1000 * 30;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private Date creationDate;

    public boolean hasExpired(){
        return creationDate.getTime() + OTP_VALIDATION_DURATION < new Date().getTime();
    }
}
