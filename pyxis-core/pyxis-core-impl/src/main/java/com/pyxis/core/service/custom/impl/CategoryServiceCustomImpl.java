package com.pyxis.core.service.custom.impl;

import com.pyxis.commons.service.PyxisJpaServiceCustomImpl;
import com.pyxis.core.dto.product.CategoryInfo;
import com.pyxis.core.model.product.Category;
import com.pyxis.core.service.CategoryService;
import com.pyxis.core.service.custom.CategoryServiceCustom;

public class CategoryServiceCustomImpl
    extends PyxisJpaServiceCustomImpl<Category, CategoryInfo, CategoryService>
    implements CategoryServiceCustom {

}
