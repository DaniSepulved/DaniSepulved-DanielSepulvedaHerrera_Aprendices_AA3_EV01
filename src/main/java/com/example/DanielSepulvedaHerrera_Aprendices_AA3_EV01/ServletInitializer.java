package com.example.DanielSepulvedaHerrera_Aprendices_AA3_EV01;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DanielSepulvedaHerreraAprendicesAa3Ev01Application.class);
	}

}
