package com.pyxis.audit.service.impl;

import java.util.Map;

import org.javers.core.Javers;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.NewObject;
import org.javers.core.diff.changetype.ObjectRemoved;
import org.javers.core.diff.changetype.ValueChange;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.pyxis.audit.dto.AuditRecordInfo;
import com.pyxis.audit.model.AuditRecord;
import com.pyxis.audit.service.AuditService;
import com.pyxis.audit.service.AuditServiceCustom;
import com.pyxis.commons.model.BaseEntity;
import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;

public class AuditServiceImpl extends PyxisJpaServiceCustomImpl<AuditRecord, AuditRecordInfo, AuditService>
    implements AuditServiceCustom {

    @Autowired
    private AuditService auditService;

    @Autowired
    private Javers javers;

    @Autowired
    private Gson gson;

    @Override
    public AuditRecordInfo audit(BaseEntity oldEntity, BaseEntity newEntity) {
        Diff diff = javers.compare(oldEntity, newEntity);

        Map<String, Object> oldEntityFields = Maps.newHashMap();
        Map<String, Object> newEntityFields = Maps.newHashMap();
        diff.getChangesByType(ValueChange.class).stream().forEach(change -> {
            oldEntityFields.put(change.getPropertyName(), change.getLeft());
            newEntityFields.put(change.getPropertyName(), change.getRight());
        });
        diff.getChangesByType(NewObject.class).stream().forEach(change -> {
            newEntityFields.put(change.getAffectedGlobalId().toString(), change.getAffectedObject().get());
        });
        diff.getChangesByType(ObjectRemoved.class).stream().forEach(change -> {
            oldEntityFields.put(change.getAffectedGlobalId().toString(), change.getAffectedObject().get());
        });

        AuditRecord auditRecord = new AuditRecord();
        auditRecord.setOldRecord(gson.toJson(oldEntityFields));
        auditRecord.setNewRecord(gson.toJson(newEntityFields));
        return toDto(auditService.save(auditRecord));
    }

}
