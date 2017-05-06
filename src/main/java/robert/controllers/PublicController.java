package robert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import robert.security.SecurityUtils;

@RestController
public class PublicController {

	@GetMapping("/")
	public String hello() {
		return "hello " + SecurityUtils.getUsername();
	}

	@GetMapping("/test")
	public String test() {
		return "test public resource for " + SecurityUtils.getUsername();
	}

}
