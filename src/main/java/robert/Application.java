package robert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import robert.persistence.UserRepository;
import robert.persistence.entities.User;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class Application {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	public Application(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() throws Exception {
		User user1 = new User();
		user1.setUsername("user1");
		user1.setPassword(passwordEncoder.encode("password"));

		User user2 = new User();
		user2.setUsername("user2");
		user2.setPassword(passwordEncoder.encode("password"));
		user2.setAdmin(true);

		userRepository.save(user1);
		userRepository.save(user2);
	}
}
