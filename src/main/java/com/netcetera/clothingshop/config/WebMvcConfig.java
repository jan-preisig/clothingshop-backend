package com.netcetera.clothingshop.config;

import com.netcetera.rest.WebServiceUrl;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
      .addMapping(WebServiceUrl.Prefix + "/**")
      .allowedOrigins("*")
      .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
  }

}
