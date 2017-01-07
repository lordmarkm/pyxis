package com.pyxis.audit.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pyxis.audit.config.AuditConfig;
import com.pyxis.audit.dto.AuditRecordInfo;
import com.pyxis.audit.model.AuditRecord;
import com.pyxis.audit.service.AuditService;
import com.pyxis.audit.service.impl.AuditServiceImpl;
import com.pyxis.audit.service.test.config.AuditTestConfig;
import com.pyxis.commons.test.CommonTestConfig;
import com.pyxis.core.model.product.Bucket;
import com.pyxis.core.model.product.Product;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalAnswers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    AuditTestConfig.class,
    AuditConfig.class,
    CommonTestConfig.class
})
public class ProductAuditTest {

    private static final Logger LOG = LoggerFactory.getLogger(ProductAuditTest.class);

    @Autowired
    private AuditService auditService;

    @Autowired
    private AuditServiceImpl auditServiceImpl;

    @Before
    public void setup() {
        reset(auditService);
    }

    @Test
    public void testAuditProductNameChange() {
        Product product1 = new Product();
        product1.setId(1l);
        product1.setName("Lebron");

        Product product2 = new Product();
        product2.setId(1l);
        product2.setName("James");

        when(auditService.save(any(AuditRecord.class))).then(returnsFirstArg());
        AuditRecordInfo record = auditServiceImpl.audit(product1, product2);

        LOG.info("Record created. record={}", record);
    }

    @Test
    public void testAuditMultiplePropertiesChange() {
        Bucket bucket1 = new Bucket();
        bucket1.setId(1l);

        Bucket bucket2 = new Bucket();
        bucket2.setId(2l);

        Product product1 = new Product();
        product1.setId(1l);
        product1.setBucket(bucket1);

        Product product2 = new Product();
        product2.setId(1l);
        product2.setBucket(bucket2);
        product2.setName("Forgot name");

        when(auditService.save(any(AuditRecord.class))).then(returnsFirstArg());
        AuditRecordInfo record = auditServiceImpl.audit(product1, product2);

        LOG.info("Record created. record={}", record);
    }

}
