
package com.teste.wendel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.teste.wendel.api.*")
public class WebConfiguration implements WebMvcConfigurer{
	
		@Autowired
		private ApplicationContext applicationContext;
		
		@Bean
		public SpringResourceTemplateResolver templateResolver() {
			SpringResourceTemplateResolver tempResolver = new SpringResourceTemplateResolver();
			tempResolver.setApplicationContext(applicationContext);
			tempResolver.setPrefix("classpath:/templates/");
			tempResolver.setSuffix(".html");
			tempResolver.setCacheable(false);
			return tempResolver;
		}
		
		@Bean
		public SpringTemplateEngine templateEngine() {
			SpringTemplateEngine tempEngine = new SpringTemplateEngine();
			tempEngine.setTemplateResolver(templateResolver());
			tempEngine.setEnableSpringELCompiler(true);
			return tempEngine;
		}
		
		public void configureViewResolver(ViewResolverRegistry registry) {
			String[] excludedViews = new String[] {"/assets/**", "/plugins/**"};
			ThymeleafViewResolver resolver = new ThymeleafViewResolver();
			resolver.setTemplateEngine(templateEngine());
			resolver.setOrder(1);
			resolver.setExcludedViewNames(excludedViews);
			registry.viewResolver(resolver);
		}
		
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/assets/**", "/plugins/**").addResourceLocations("/WEB-INF/assets/","/WEB-INF/plugins/");
		}
}
