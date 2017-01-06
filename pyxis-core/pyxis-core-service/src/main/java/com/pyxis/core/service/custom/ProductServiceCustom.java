package com.pyxis.core.service.custom;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.product.ProductInfo;
import com.pyxis.core.model.product.Product;
import static com.pyxis.core.model.product.QProduct.product;

public interface ProductServiceCustom extends PyxisJpaServiceCustom<Product, ProductInfo> {

    @Override
    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of(
                "id", product.id,
                "deleted", product.deleted,
                "name", product.name);
    };

}
