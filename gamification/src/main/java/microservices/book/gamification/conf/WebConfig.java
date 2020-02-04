package microservices.book.gamification.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * Enables Cross-Origin Resource Sharing (CORS) More info: http://docs.spring.io/
   * spring/docs/current/spring-framework-reference/html /cors.html
   */
  @Override
  public void addCorsMappings(final CorsRegistry registry) {
    registry.addMapping("/**");
  }
}
