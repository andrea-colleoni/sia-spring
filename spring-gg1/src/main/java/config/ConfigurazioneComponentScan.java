package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springcontext.ClasseA;

@Configuration
// @ComponentScan(basePackageClasses = { ClasseA.class }) // scansione sul package che contiene ClasseA
@ComponentScan(basePackages = { "springcontext" }) // scansione del package indicato
public class ConfigurazioneComponentScan {

}
