package com.pyxis.core.service;

import com.pyxis.commons.service.PyxisJpaService;
import com.pyxis.core.model.product.Product;
import com.pyxis.core.service.custom.ProductServiceCustom;

public interface ProductService extends ProductServiceCustom, PyxisJpaService<Product> {

}
