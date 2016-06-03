package ru.kpfu.Auto.config;

import java.util.Locale;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import ru.kpfu.Auto.models.AutoDealer;

import ru.kpfu.Auto.utils.StringToEntityConverter;




@Configuration
@ComponentScan(basePackages = {"ru.kpfu.Auto.controllers"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public UrlBasedViewResolver setupViewResolver() {
    UrlBasedViewResolver resolver = new UrlBasedViewResolver();
    resolver.setPrefix("/WEB-INF/jsp/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/assets/css/");
    registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/assets/fonts/");
    registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/assets/js/");
    registry.addResourceHandler("/ico/**").addResourceLocations("/WEB-INF/assets/ico/");
    registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/assets/images/");
  }
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/").setViewName("home/Home");
    registry.addViewController("/403").setViewName("error/403");
  }
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
    res.setBasenames("classpath:i18n/messages", "classpath:i18n/validation");
    res.setCacheSeconds(0);
    res.setDefaultEncoding("UTF-8");
    res.setUseCodeAsDefaultMessage(false);
    return res;
  }

  @Bean
  public LocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setCookieName("lang");
    localeResolver.setDefaultLocale(new Locale("ru", "RU"));
    return localeResolver;
  }
  
	
	 @Bean
	  public Validator validator(){
	    return new LocalValidatorFactoryBean();
	  }
	  @Override
	  public void addFormatters(FormatterRegistry formatterRegistry) {
	    formatterRegistry.addConverter(AutoDealetGenericConverter());
	 
	  }

	  @Bean
	  public StringToEntityConverter AutoDealetGenericConverter(){
	    return new StringToEntityConverter(AutoDealer.class);
	  }
	
}
