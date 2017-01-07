package com.pyxis.core.service;

import com.pyxis.commons.service.PyxisJpaService;
import com.pyxis.core.model.product.Brand;
import com.pyxis.core.service.custom.BrandServiceCustom;

public interface BrandService extends PyxisJpaService<Brand>,
    BrandServiceCustom {

}
