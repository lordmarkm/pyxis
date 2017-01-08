package com.pyxis.core.service;

import com.pyxis.commons.service.PyxisJpaService;
import com.pyxis.core.model.product.Category;
import com.pyxis.core.service.custom.CategoryServiceCustom;

public interface CategoryService extends PyxisJpaService<Category>,
    CategoryServiceCustom {

}
