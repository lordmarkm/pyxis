package com.pyxis.ui.customer;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import edu.wisc.my.restproxy.config.RestProxyConfiguration;
import edu.wisc.my.restproxy.web.ResourceProxyController;

@Configuration
@Import(RestProxyConfiguration.class)
public class WebappConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("index");
    }

    @Bean(autowire = Autowire.BY_TYPE)
    public ResourceProxyController resourceProxyController() {
        return new ResourceProxyController();
    }

}
