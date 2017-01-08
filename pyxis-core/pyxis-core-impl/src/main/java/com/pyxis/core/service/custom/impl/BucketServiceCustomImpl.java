package com.pyxis.core.service.custom.impl;

import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.core.dto.product.BucketInfo;
import com.pyxis.core.model.product.Bucket;
import com.pyxis.core.service.BucketService;
import com.pyxis.core.service.custom.BucketServiceCustom;

public class BucketServiceCustomImpl
    extends PyxisJpaServiceCustomImpl<Bucket, BucketInfo, BucketService>
    implements BucketServiceCustom {

}
