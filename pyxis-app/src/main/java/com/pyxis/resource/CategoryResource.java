package com.pyxis.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.api.BaseResource;
import com.pyxis.core.dto.product.CategoryInfo;
import com.pyxis.core.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource extends BaseResource<CategoryInfo, CategoryService> {

}
