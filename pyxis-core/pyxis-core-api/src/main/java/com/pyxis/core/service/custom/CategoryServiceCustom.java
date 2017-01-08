package com.pyxis.core.service.custom;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.product.CategoryInfo;
import com.pyxis.core.model.product.Category;
import static com.pyxis.core.model.product.QCategory.category;

public interface CategoryServiceCustom  extends PyxisJpaServiceCustom<Category, CategoryInfo> {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of("name", category.name,
                "deleted", category.deleted);
    }

}
