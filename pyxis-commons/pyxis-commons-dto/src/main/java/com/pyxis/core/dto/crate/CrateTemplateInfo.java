package com.pyxis.core.dto.crate;

import java.time.Month;
import java.util.List;

import com.pyxis.core.dto.BaseInfo;
import com.pyxis.core.dto.product.ProductInfo;

public class CrateTemplateInfo extends BaseInfo {

    private int year;
    private Month month;
    private List<ProductInfo> products;

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
    public List<ProductInfo> getProducts() {
        return products;
    }
    public void setProducts(List<ProductInfo> products) {
        this.products = products;
    }

}
