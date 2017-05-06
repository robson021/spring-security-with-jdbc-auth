package robert.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {
	public static String getUsername() {
		return ((UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal())
				.getUsername();
	}
}
