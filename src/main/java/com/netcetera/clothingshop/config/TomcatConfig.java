package com.netcetera.clothingshop.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

  @Value("${tomcat.ajp.enabled}")
  private boolean ajpEnabled;

  @Value("${tomcat.ajp.protocol}")
  private String ajpProtocol;

  @Value("${tomcat.ajp.port}")
  private int ajpPort;

  @Bean
  public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
    final TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
    if (ajpEnabled) {
      final Connector ajpConnector = new Connector(ajpProtocol);
      ajpConnector.setPort(ajpPort);
      tomcatFactory.addAdditionalTomcatConnectors(ajpConnector);
    }
    return tomcatFactory;
  }

}
