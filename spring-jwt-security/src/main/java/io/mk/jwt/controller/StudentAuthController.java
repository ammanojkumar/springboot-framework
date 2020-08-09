package io.mk.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mk.jwt.config.StudentTokenUtil;
import io.mk.jwt.model.StudentRequest;
import io.mk.jwt.model.StudentResponse;
import io.mk.jwt.service.StudentUserDetailsService;

@RestController
@CrossOrigin
public class StudentAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private StudentTokenUtil studentTokenUtil;

	@Autowired
	private StudentUserDetailsService userDetailsService;

	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody StudentRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = studentTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new StudentResponse(token));
	}
}
