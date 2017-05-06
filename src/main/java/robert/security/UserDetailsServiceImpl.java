package robert.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import robert.persistence.UserRepository;
import robert.persistence.entities.User;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		return new UserDetailsImpl(user);
	}

	private class UserDetailsImpl implements UserDetails {

		private final User user;

		private final Collection<GrantedAuthority> authorities;

		private UserDetailsImpl(User user) {
			this.user = user;
			if (user.isAdmin()) {
				this.authorities = new HashSet<>(1);
				this.authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			} else {
				this.authorities = Collections.emptySet();
			}
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return this.authorities;
		}

		@Override
		public String getPassword() {
			return user.getPassword();
		}

		@Override
		public String getUsername() {
			return user.getUsername();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

	}
}
