package robert.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public String hello() {
		return "hello admin";
	}

	@GetMapping("test")
	public String test() {
		return "test admin resource";
	}
}
