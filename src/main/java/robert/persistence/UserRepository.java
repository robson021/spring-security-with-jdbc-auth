package robert.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import robert.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUsername(String username);
}
