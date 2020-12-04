package com.mapsa.datajpademo.domain;

import javax.persistence.*;

//@Table
//@Entity
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TYPE",discriminatorType = DiscriminatorType.STRING)
public abstract class Person  extends BaseEntity<Long>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
