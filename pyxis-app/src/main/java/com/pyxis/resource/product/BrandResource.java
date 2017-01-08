package com.pyxis.resource.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.api.BaseResource;
import com.pyxis.core.dto.product.BrandInfo;
import com.pyxis.core.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandResource  extends BaseResource<BrandInfo, BrandService> {

}
