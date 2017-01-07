package com.pyxis.core.service.custom.impl;

import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.core.dto.product.BrandInfo;
import com.pyxis.core.model.product.Brand;
import com.pyxis.core.service.BrandService;
import com.pyxis.core.service.custom.BrandServiceCustom;

public class BrandServiceCustomImpl
    extends PyxisJpaServiceCustomImpl<Brand, BrandInfo, BrandService>
    implements BrandServiceCustom {

}
