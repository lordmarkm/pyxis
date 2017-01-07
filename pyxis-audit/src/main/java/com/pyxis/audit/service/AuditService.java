package com.pyxis.audit.service;

import com.pyxis.audit.model.AuditRecord;
import com.pyxis.commons.service.PyxisJpaService;

public interface AuditService extends AuditServiceCustom, PyxisJpaService<AuditRecord> {

}
