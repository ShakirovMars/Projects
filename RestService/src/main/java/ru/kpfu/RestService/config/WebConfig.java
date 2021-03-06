package ru.kpfu.RestService.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackages = {"ru.kpfu.RestService.controllers"})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {



}
