package com.pyxis.audit.service.test.config;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pyxis.audit.service.AuditService;
import com.pyxis.audit.service.impl.AuditServiceImpl;

@Configuration
public class AuditTestConfig {

    @Bean
    public AuditService auditService() {
        return Mockito.mock(AuditService.class);
    }

    @Bean(autowire = Autowire.BY_TYPE)
    public AuditServiceImpl auditServiceImpl() {
        return new AuditServiceImpl();
    }

}
