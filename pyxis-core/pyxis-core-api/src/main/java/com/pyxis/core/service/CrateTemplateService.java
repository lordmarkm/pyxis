package com.pyxis.core.service;

import com.pyxis.commons.service.PyxisJpaService;
import com.pyxis.core.model.crate.CrateTemplate;
import com.pyxis.core.service.custom.CrateTemplateServiceCustom;

public interface CrateTemplateService extends PyxisJpaService<CrateTemplate>,
    CrateTemplateServiceCustom {

}
