package com.devopsbuddy.backend.persistence.domain.backend;


import com.devopsbuddy.enums.PlanEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sreenu on 28-10-2017.
 */
@Entity
public class Plan implements Serializable {

    /** The Serial Version UID for Serializable classes. */
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String name;

    /** Default constructor. */
    public Plan() {

    }
    public Plan(PlanEnum planEnum) {
        this.id = planEnum.getId();
        this.name = planEnum.getPlanName();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        return id == plan.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}