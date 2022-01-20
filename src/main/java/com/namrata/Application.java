package com.namrata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NAMRATA
 *
 */
@RestController
@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private String message;
	
	@Loggable
	public String getMessage() {
		return message;
	}

	@Loggable
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	@Loggable
	@RequestMapping("/")
	public String home() {
		
		LOGGER.info("From home!");
		return "Hello World! " + getMessage();
	}
	
	/**
	 * @param name
	 * @return
	 */
	@Loggable
	@GetMapping("/howdy/{name}")
	public String hello(@PathVariable("name") String name) {
		
		LOGGER.info("From howdy!");
		return "Howdy " + name + " !";
	}
	
	/**
	 * @param args
	 */
	@Loggable
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
