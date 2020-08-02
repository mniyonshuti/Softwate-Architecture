package cs590.order.integration;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Logger {

	public void log(String message) {
		System.out.println("Logging --------- "+new Date()+ " "+message);
	}
}
