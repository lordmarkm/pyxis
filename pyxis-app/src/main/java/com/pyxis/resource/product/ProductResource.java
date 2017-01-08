package com.pyxis.resource.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.api.BaseResource;
import com.pyxis.core.dto.product.ProductInfo;
import com.pyxis.core.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductResource extends BaseResource<ProductInfo, ProductService> {

}
