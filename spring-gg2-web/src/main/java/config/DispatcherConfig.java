package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
// questa classe viene caricata autoimaticamente da un web container > 3.0 (JEE > 1.5)
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	
	// URL: http://nomeserver:porta/   => /nomeapplicazione/   => /risorse che ci sono nella nostra web app/   => /comandi mvc, contenuti, pagine, ecc.
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/mvc/" };
	}

}
