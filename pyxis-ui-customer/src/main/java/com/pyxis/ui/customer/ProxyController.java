package com.pyxis.ui.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.wisc.my.restproxy.web.ResourceProxyController;

@Controller
@RequestMapping("/proxy/*")
public class ProxyController extends ResourceProxyController {

}
