package com.pyxis.audit.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.audit.dto.AuditRecordInfo;
import com.pyxis.audit.service.AuditRecordService;
import com.pyxis.commons.api.BaseResource;

@RestController
@RequestMapping("/audit-record")
public class AuditRecordResource extends BaseResource<AuditRecordInfo, AuditRecordService> {

    @Override
    public ResponseEntity<AuditRecordInfo> save(AuditRecordInfo auditRecordInfo) {
        throw new UnsupportedOperationException("Save not allowed for this resource");
    }

    @Override
    public ResponseEntity<AuditRecordInfo> delete(Long id) {
        throw new UnsupportedOperationException("Delete not allowed for this resource");
    }

}
