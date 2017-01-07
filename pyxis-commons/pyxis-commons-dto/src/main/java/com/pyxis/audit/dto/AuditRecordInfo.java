package com.pyxis.audit.dto;

import org.springframework.core.style.ToStringCreator;

import com.pyxis.core.dto.BaseInfo;

public class AuditRecordInfo extends BaseInfo {

    private AuditRecordOperation operation;
    private String recordType;
    private String oldRecord;
    private String newRecord;

    @Override
    public ToStringCreator toStringCreator() {
        return super.toStringCreator()
                .append("op", operation)
                .append("recordType", recordType)
                .append("old", oldRecord)
                .append("new", newRecord);
    }

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
