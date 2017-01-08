package com.pyxis.core.service.custom;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.product.BucketInfo;
import com.pyxis.core.model.product.Bucket;
import static com.pyxis.core.model.product.QBucket.bucket;

public interface BucketServiceCustom extends PyxisJpaServiceCustom<Bucket, BucketInfo> {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of(
                "name", bucket.name,
                "deleted", bucket.deleted);
    }

}
