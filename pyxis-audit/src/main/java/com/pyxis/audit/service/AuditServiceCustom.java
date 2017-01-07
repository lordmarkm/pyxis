package com.pyxis.audit.service;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.audit.dto.AuditRecordInfo;
import com.pyxis.audit.model.AuditRecord;
import com.pyxis.commons.model.BaseEntity;
import com.pyxis.commons.service.PyxisJpaServiceCustom;

public interface AuditServiceCustom extends PyxisJpaServiceCustom<AuditRecord, AuditRecordInfo> {

    AuditRecordInfo audit(BaseEntity oldEntity, BaseEntity newEntity);

    @Override
    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return null;
    }

}
