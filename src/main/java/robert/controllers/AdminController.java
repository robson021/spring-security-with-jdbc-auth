package robert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import robert.security.SecurityUtils;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public String hello() {
		return "hello admin " + SecurityUtils.getUsername();
	}

	@GetMapping("test")
	public String test() {
		return "test private resource for " + SecurityUtils.getUsername();
	}
}
