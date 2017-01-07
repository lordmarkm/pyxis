package com.pyxis.audit.service;

import static com.pyxis.audit.model.QAuditRecord.auditRecord;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.audit.dto.AuditRecordInfo;
import com.pyxis.audit.model.AuditRecord;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.BaseInfo;

public interface AuditRecordServiceCustom extends PyxisJpaServiceCustom<AuditRecord, AuditRecordInfo> {

    AuditRecordInfo audit(BaseInfo oldEntity, BaseInfo newEntity);

    @Override
    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of(
                "id", auditRecord.id,
                "operation", auditRecord.operation,
                "recordType", auditRecord.recordType,
                "createdBy", auditRecord.createdBy);
    };

}
