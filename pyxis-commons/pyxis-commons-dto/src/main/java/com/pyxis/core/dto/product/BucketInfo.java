package com.pyxis.core.dto.product;

import com.pyxis.core.dto.BaseInfo;

public class BucketInfo extends BaseInfo {

    private String name;

    @Override
    public String getType() {
        return "bucket";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
