package com.pyxis.audit.service.test.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pyxis.audit.service.AuditRecordService;
import com.pyxis.audit.service.impl.AuditRecordServiceCustomImpl;

@Configuration
public class AuditTestConfig {

    @Bean
    public AuditRecordService auditService() {
        return Mockito.mock(AuditRecordService.class);
    }

    @Bean(autowire = Autowire.BY_TYPE)
    public AuditRecordServiceCustomImpl auditServiceImpl() {
        return new AuditRecordServiceCustomImpl();
    }

}
