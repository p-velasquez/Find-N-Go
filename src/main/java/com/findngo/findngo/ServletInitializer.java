package com.findngo.findngo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Inicia la app
 */
public class ServletInitializer extends SpringBootServletInitializer {
	/**
	 * Inicia la aplicacion
	 *
	 * @param application recibe el builder de la springapp
	 * @return el application source
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FindngoApplication.class);
	}

}
