package io.mk.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BankUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (java.util.Arrays.asList(new String[] { "aaa", "bbb", "ccc" }).contains(username)) {
			return new User(username, new BCryptPasswordEncoder().encode("password"), new ArrayList<>());
		}
		throw new UsernameNotFoundException("User not found with username: " + username);
	}
}
