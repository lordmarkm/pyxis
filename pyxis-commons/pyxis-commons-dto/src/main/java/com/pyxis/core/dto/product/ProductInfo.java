package com.pyxis.core.dto.product;

import org.springframework.core.style.ToStringCreator;

import com.pyxis.core.dto.BaseInfo;

/**
 *
 * @author Mark Baldwin B. Martinez on 5 Jan 2017
 *
 */
public class ProductInfo extends BaseInfo {

    private String name;
    private BrandInfo brand;
    private BucketInfo bucket;
    private CategoryInfo category;

    @Override
    public ToStringCreator toStringCreator() {
        return super.toStringCreator()
                .append("name", name)
                .append("brand", brand)
                .append("bucket", bucket)
                .append("cat", category);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BrandInfo getBrand() {
        return brand;
    }
    public void setBrand(BrandInfo brand) {
        this.brand = brand;
    }
    public BucketInfo getBucket() {
        return bucket;
    }
    public void setBucket(BucketInfo bucket) {
        this.bucket = bucket;
    }
    public CategoryInfo getCategory() {
        return category;
    }
    public void setCategory(CategoryInfo category) {
        this.category = category;
    }

}
