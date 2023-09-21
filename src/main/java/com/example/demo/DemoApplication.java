package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "<ul>" +
				"<li><a href='/doctor/1'>Doctor 1</a></li>" +
				"<li><a href='/doctor/10'>Doctor 10</a></li>" +
				"<li><a href='/doctor/11'>Doctor 11</a></li>" +
				"<li><a href='/doctor/13'>Doctor 13</a></li>" +
				"</ul>";
	}

	@GetMapping("/doctor/{number}")
	@ResponseBody
	public String getDoctor(@PathVariable int number) {
		switch (number) {
			case 1:
				return "William Hartnell";
			case 10:
				return "David Tennant";
			case 11:
				return "Matt Smith";
			case 13:
				return "Jodie Whittaker";
			default:
				return "Unknown Doctor";
		}
	}
}

