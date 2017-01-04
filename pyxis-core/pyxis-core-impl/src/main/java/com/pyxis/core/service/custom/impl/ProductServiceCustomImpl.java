package com.pyxis.core.service.custom.impl;

import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.core.dto.product.ProductInfo;
import com.pyxis.core.model.product.Product;
import com.pyxis.core.service.ProductService;
import com.pyxis.core.service.custom.ProductServiceCustom;

public class ProductServiceCustomImpl
    extends PyxisJpaServiceCustomImpl<Product, ProductInfo, ProductService>
    implements ProductServiceCustom {

}
