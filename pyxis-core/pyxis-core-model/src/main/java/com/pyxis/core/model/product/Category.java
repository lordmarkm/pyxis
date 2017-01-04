package com.pyxis.core.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pyxis.commons.model.BaseEntity;

@Entity(name = "category")
public class Category extends BaseEntity {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
