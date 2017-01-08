package com.pyxis.audit.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.pyxis.audit.service.AuditRecordService;
import com.pyxis.commons.model.BaseEntity;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.BaseInfo;

@Aspect
@Component
public class PyxisServiceAuditingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(PyxisServiceAuditingAspect.class);

    @Autowired
    private AuditRecordService auditRecordService;

    @Autowired
    private Gson gson;

    @Pointcut("execution(* com.pyxis.commons.service.PyxisJpaService.save(..))")
    public void pyxisJpaServiceSaveOperation() { }

    @Pointcut("execution(* com.pyxis.audit.service.AuditRecordService.save(..))")
    public void auditServiceSaveOperation() { }

    @SuppressWarnings("unchecked")
    @Around(value = "pyxisJpaServiceSaveOperation() && !auditServiceSaveOperation()")
    public Object interceptPyxisSave(ProceedingJoinPoint pjp) throws Throwable {
        Object serviceObject = pjp.getThis();
        if (PyxisJpaServiceCustom.class.isAssignableFrom(serviceObject.getClass())) {
            PyxisJpaServiceCustom<? extends BaseEntity, ? extends BaseInfo> service =
                    (PyxisJpaServiceCustom<? extends BaseEntity, ? extends BaseInfo>) serviceObject;
            BaseEntity entityToSave = (BaseEntity) pjp.getArgs()[0];

            BaseInfo oldEntity = null;
            BaseInfo newEntity = null;

            if (null != entityToSave.getId()) {
                //Update operation
                oldEntity = service.findOneInfo(entityToSave.getId());
                LOG.debug("Got old entity. entity={}", gson.toJson(oldEntity));
            }
            BaseEntity savedEntity = (BaseEntity) pjp.proceed();

            newEntity = service.toDto(savedEntity);
            LOG.debug("Got new entity. entity={}", gson.toJson(newEntity));

            auditRecordService.audit(oldEntity, newEntity);

            return savedEntity;
        } else {
            return pjp.proceed();
        }

    }

}
