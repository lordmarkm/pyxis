package com.pyxis.core.dto;

import org.javers.core.metamodel.annotation.DiffIgnore;
import org.joda.time.DateTime;
import org.springframework.core.style.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.pyxis.core.dto.crate.CrateTemplateInfo;
import com.pyxis.core.dto.product.BrandInfo;
import com.pyxis.core.dto.product.BucketInfo;
import com.pyxis.core.dto.product.CategoryInfo;
import com.pyxis.core.dto.product.ProductInfo;

/**
 *
 * @author Mark Baldwin B. Martinez on 5 Jan 2017
 *
 */

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = BrandInfo.class, name = "brand"),
    @JsonSubTypes.Type(value = ProductInfo.class, name = "product"),
    @JsonSubTypes.Type(value = CategoryInfo.class, name = "category"),
    @JsonSubTypes.Type(value = BucketInfo.class, name = "bucket"),
    @JsonSubTypes.Type(value = CrateTemplateInfo.class, name = "crate_template")
})
//TODO configure superclass ignore and remove javers dependency in commons-dto module
public abstract class BaseInfo {

    private Long id;
    @DiffIgnore
    private String createdBy;
    @DiffIgnore
    private DateTime createdDate;
    @DiffIgnore
    private String updatedBy;
    @DiffIgnore
    private DateTime updatedDate;
    private Boolean deleted = false;

    public abstract String getType();

    @Override
    public final String toString() {
        return this.toStringCreator().toString();
    }

    protected ToStringCreator toStringCreator() {
        return new ToStringCreator(this)
                .append("id", id)
                .append("created", createdDate)
                .append("createdBy", createdBy)
                .append("updated", createdDate)
                .append("updatedBy", updatedBy)
                .append("deleted", deleted);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public DateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(DateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
