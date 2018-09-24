package tech.kikutaro.azurespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@SpringBootApplication
@Controller
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/check")
	public String check(@RequestBody(required = false) String body, @RequestHeader(required = false) HttpHeaders headers, Model model) {
		model.addAttribute("return", "This is from server side.");
		if(body != null) {
			model.addAttribute("body", body);
		}
		if(headers != null) {
			model.addAttribute("headers", headers);
		}
		return "check";
	}
}
