package com.pyxis.resource.crate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.api.BaseResource;
import com.pyxis.core.dto.crate.CrateTemplateInfo;
import com.pyxis.core.service.CrateTemplateService;

@RestController
@RequestMapping("/crate-template")
public class CrateTemplateResource extends BaseResource<CrateTemplateInfo, CrateTemplateService> {

}
