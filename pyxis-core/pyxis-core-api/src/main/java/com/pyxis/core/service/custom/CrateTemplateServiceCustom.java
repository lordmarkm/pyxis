package com.pyxis.core.service.custom;

import com.google.common.collect.ImmutableMap;
import com.mysema.query.types.Path;
import com.pyxis.commons.service.PyxisJpaServiceCustom;
import com.pyxis.core.dto.crate.CrateTemplateInfo;
import com.pyxis.core.model.crate.CrateTemplate;
import static com.pyxis.core.model.crate.QCrateTemplate.crateTemplate;

public interface CrateTemplateServiceCustom extends PyxisJpaServiceCustom<CrateTemplate, CrateTemplateInfo> {

    default ImmutableMap<String, Path<?>> getFieldMapping() {
        return ImmutableMap.of(
                "deleted", crateTemplate.deleted,
                "month", crateTemplate.month,
                "year", crateTemplate.year,
                "products", crateTemplate.products
            );
    }

}
