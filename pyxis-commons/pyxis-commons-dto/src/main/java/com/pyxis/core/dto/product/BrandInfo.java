package com.pyxis.core.dto.product;

import com.pyxis.core.dto.BaseInfo;

public class BrandInfo extends BaseInfo {

    private String name;

    @Override
    public String getType() {
        return "brand";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
