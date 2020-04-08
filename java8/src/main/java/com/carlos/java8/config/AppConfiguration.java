package com.carlos.java8.config;

import java.nio.charset.StandardCharsets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import com.carlos.java8.email.JavaMail;
import com.carlos.java8.email.JavaMailSpring;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
//@ComponentScan(basePackages = { "com.carlos.java8" })
public class AppConfiguration {

	@Bean(name = "email")
	public JavaMail email() {
		return new JavaMail();
	}

	@Bean(name = "emailSpring")
	public JavaMailSpring emailSpring() {
		return new JavaMailSpring();
	}

	@Bean(name = "springTemplateEngine")
	public SpringTemplateEngine springTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.addTemplateResolver(htmlTemplateResolver());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

	@Bean
	public SpringResourceTemplateResolver htmlTemplateResolver() {
		SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
		emailTemplateResolver.setPrefix("/templates/");
		emailTemplateResolver.setSuffix(".html");
		emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
		emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
		return emailTemplateResolver;
	}

}
