package com.pyxis.audit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Type;

import com.pyxis.audit.dto.AuditRecordOperation;
import com.pyxis.commons.model.BaseEntity;

@Entity(name = "audit_record")
public class AuditRecord extends BaseEntity {

    @Column(name = "operation")
    @Enumerated(EnumType.STRING)
    private AuditRecordOperation operation;
    @Column(name = "record_type")
    private String recordType;
    @Column(name = "old_record")
    @Type(type = "text")
    private String oldRecord;
    @Column(name = "new_record")
    @Type(type = "text")
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
    public AuditRecordOperation getOperation() {
        return operation;
    }
    public void setOperation(AuditRecordOperation operation) {
        this.operation = operation;
    }
    public String getRecordType() {
        return recordType;
    }
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

}
