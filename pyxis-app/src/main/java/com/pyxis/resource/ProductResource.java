package com.pyxis.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.api.BaseResource;
import com.pyxis.core.dto.product.ProductInfo;
import com.pyxis.core.service.custom.ProductServiceCustom;

@RestController
@RequestMapping("/product")
public class ProductResource extends BaseResource<ProductInfo, ProductServiceCustom> {

}
