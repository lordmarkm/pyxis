package com.pyxis.core.service.custom.impl;

import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.core.dto.crate.CrateTemplateInfo;
import com.pyxis.core.model.crate.CrateTemplate;
import com.pyxis.core.service.CrateTemplateService;
import com.pyxis.core.service.custom.CrateTemplateServiceCustom;

public class CrateTemplateServiceCustomImpl
    extends PyxisJpaServiceCustomImpl<CrateTemplate, CrateTemplateInfo, CrateTemplateService>
    implements CrateTemplateServiceCustom {

}
