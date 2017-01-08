package com.pyxis.core.model.crate;

import java.time.Month;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.pyxis.commons.model.BaseEntity;
import com.pyxis.core.model.product.Product;

@Entity(name = "crate_template")
public class CrateTemplate extends BaseEntity {

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "month", nullable = false)
    @Enumerated(EnumType.STRING)
    private Month month;

    @OneToMany
    @JoinTable(
        name = "join_crate_template_products"
    )
    private List<Product> products;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
