package com.pyxis.audit.dto;

import org.springframework.core.style.ToStringCreator;

import com.pyxis.core.dto.BaseInfo;

public class AuditRecordInfo extends BaseInfo {

    private String oldRecord;
    private String newRecord;

    @Override
    public ToStringCreator toStringCreator() {
        return new ToStringCreator(this)
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

}
