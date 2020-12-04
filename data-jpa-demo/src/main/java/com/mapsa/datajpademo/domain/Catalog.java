package com.mapsa.datajpademo.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/*@Entity
@Table*/
@Embeddable
public class Catalog {
    @ElementCollection
    @CollectionTable(name = "context_map")
    private Map<String,Integer> context = new HashMap<>();

    public Map<String, Integer> getContext() {
        return context;
    }

    public void setContext(Map<String, Integer> context) {
        this.context = context;
    }
}
