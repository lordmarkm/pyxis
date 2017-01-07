package com.pyxis.core.service.custom;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.product.BrandInfo;
import com.pyxis.core.model.product.Brand;

public interface BrandServiceCustom extends PyxisJpaServiceCustom<Brand, BrandInfo> {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        // TODO Auto-generated method stub
        return null;
    }

}
