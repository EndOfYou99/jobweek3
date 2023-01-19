package hangman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "hangman.controller", "hangman.businessLogic", "hangman.exceptions" })
public class WebApplicationContextConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver getinternalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
//		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
