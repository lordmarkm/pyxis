package com.pyxis.core.service;

import com.pyxis.commons.service.PyxisJpaService;
import com.pyxis.core.model.product.Bucket;
import com.pyxis.core.service.custom.BucketServiceCustom;

public interface BucketService extends PyxisJpaService<Bucket>,
    BucketServiceCustom {

}
