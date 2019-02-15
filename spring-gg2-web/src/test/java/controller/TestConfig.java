package controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import config.BusinessConfig;

@Configuration
@Import(BusinessConfig.class)
@ComponentScan(basePackages = { "controller" })
public class TestConfig {

}
