package com.pyxis.audit.service.test;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

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
import com.pyxis.audit.service.AuditRecordService;
import com.pyxis.audit.service.impl.AuditRecordServiceCustomImpl;
import com.pyxis.audit.service.test.config.AuditTestConfig;
import com.pyxis.commons.test.CommonTestConfig;
import com.pyxis.core.dto.product.BucketInfo;
import com.pyxis.core.dto.product.ProductInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
    AuditTestConfig.class,
    AuditConfig.class,
    CommonTestConfig.class
})
public class ProductAuditTest {

    private static final Logger LOG = LoggerFactory.getLogger(ProductAuditTest.class);

    @Autowired
    private AuditRecordService auditService;

    @Autowired
    private AuditRecordServiceCustomImpl auditServiceImpl;

    @Before
    public void setup() {
        reset(auditService);
    }

    @Test
    public void testAuditProductNameChange() {
        ProductInfo product1 = new ProductInfo();
        product1.setId(1l);
        product1.setName("Lebron");

        ProductInfo product2 = new ProductInfo();
        product2.setId(1l);
        product2.setName("James");

        when(auditService.save(any(AuditRecord.class))).then(returnsFirstArg());
        AuditRecordInfo record = auditServiceImpl.audit(product1, product2);

        LOG.info("Record created. record={}", record);
    }

    @Test
    public void testAuditMultiplePropertiesChange() {
        BucketInfo bucket1 = new BucketInfo();
        bucket1.setId(1l);

        BucketInfo bucket2 = new BucketInfo();
        bucket2.setId(2l);

        ProductInfo product1 = new ProductInfo();
        product1.setId(1l);
        product1.setBucket(bucket1);

        ProductInfo product2 = new ProductInfo();
        product2.setId(1l);
        product2.setBucket(bucket2);
        product2.setName("Forgot name");

        when(auditService.save(any(AuditRecord.class))).then(returnsFirstArg());
        AuditRecordInfo record = auditServiceImpl.audit(product1, product2);

        LOG.info("Record created. record={}", record);
    }

    @Test
    public void testPreviouslyNull() {
        BucketInfo bucket1 = new BucketInfo();
        bucket1.setId(1l);

        ProductInfo product1 = new ProductInfo();
        product1.setId(1l);
        product1.setBucket(bucket1);
        product1.setName("Lebron");

        when(auditService.save(any(AuditRecord.class))).then(returnsFirstArg());

        AuditRecordInfo record = auditServiceImpl.audit(null, product1);

        LOG.info("Record created. record={}", record);
    }

}
