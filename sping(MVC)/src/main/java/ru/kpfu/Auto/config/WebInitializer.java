package ru.kpfu.Auto.config;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{RootConfig.class, SecurityConfig.class};
  }


  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{WebConfig.class,SecurityConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
  
  @Override
   protected Filter[] getServletFilters() {

     CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

  encodingFilter.setForceEncoding(true);

  encodingFilter.setEncoding("UTF-8");


     return new Filter[]{encodingFilter,

             new DelegatingFilterProxy("springSecurityFilterChain"),

             new OpenEntityManagerInViewFilter()};

  }
}
