package com.pyxis.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyxis.commons.api.BaseResource;
import com.pyxis.core.dto.product.BucketInfo;
import com.pyxis.core.service.BucketService;

@RestController
@RequestMapping("/bucket")
public class BucketResource extends BaseResource<BucketInfo, BucketService> {

}
