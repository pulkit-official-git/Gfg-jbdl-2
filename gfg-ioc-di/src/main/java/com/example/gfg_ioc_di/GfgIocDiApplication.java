package com.example.gfg_ioc_di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GfgIocDiApplication {

	Logger logger = LoggerFactory.getLogger(GfgIocDiApplication.class);
	int a=9;
	String b;

	public GfgIocDiApplication() {
		logger.info("inside GfgIocDiApplication condtructor, a = "+this.a+", b = "+this.b);
		this.b = "xyz";
	}
	public void test(){
		logger.info("inside GfgIocDiApplication test, a = "+this.a+", b = "+this.b);
	}

	public static void main(String[] args) {
		SpringApplication.run(GfgIocDiApplication.class, args);
//		GfgIocDiApplication g = new GfgIocDiApplication();
//		g.test();
	}

}
