package com.pyxis.audit.model;

import javax.persistence.Entity;

import com.pyxis.commons.model.BaseEntity;

@Entity(name = "audit_record")
public class AuditRecord extends BaseEntity {

    private String oldRecord;
    private String newRecord;

    public String getOldRecord() {
        return oldRecord;
    }
    public void setOldRecord(String oldRecord) {
        this.oldRecord = oldRecord;
    }
    public String getNewRecord() {
        return newRecord;
    }
    public void setNewRecord(String newRecord) {
        this.newRecord = newRecord;
    }

}
