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
import com.pyxis.audit.service.AuditRecordService;
import com.pyxis.audit.service.AuditRecordServiceCustom;
import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.core.dto.BaseInfo;

import static com.pyxis.audit.dto.AuditRecordOperation.*;

public class AuditRecordServiceCustomImpl extends PyxisJpaServiceCustomImpl<AuditRecord, AuditRecordInfo, AuditRecordService>
    implements AuditRecordServiceCustom {

    @Autowired
    private AuditRecordService auditService;

    @Autowired
    private Javers javers;

    @Autowired
    private Gson gson;

    @Override
    public AuditRecordInfo audit(BaseInfo oldEntity, BaseInfo newEntity) {
        AuditRecord auditRecord = new AuditRecord();
        if (null == oldEntity && null == newEntity) {
            throw new IllegalStateException("Both entities can't be null!");
        } else if (null == oldEntity && null != newEntity) {
            auditRecord.setOperation(CREATE);
            auditRecord.setNewRecord(gson.toJson(newEntity));
            auditRecord.setRecordType(newEntity.getClass().getSimpleName());
        } else if (null != oldEntity && null == newEntity) {
            auditRecord.setOperation(DELETE);
            auditRecord.setOldRecord(gson.toJson(oldEntity));
            auditRecord.setRecordType(oldEntity.getClass().getSimpleName());
        } else {
            auditRecord.setOperation(UPDATE);
            auditRecord.setRecordType(newEntity.getClass().getSimpleName());

            Diff diff = javers.compare(oldEntity, newEntity);

            //No audit when no changes
            if (!diff.hasChanges()) {
                return null;
            }

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

            auditRecord.setOldRecord(gson.toJson(oldEntityFields));
            auditRecord.setNewRecord(gson.toJson(newEntityFields));
        }

        return toDto(auditService.save(auditRecord));
    }

}
