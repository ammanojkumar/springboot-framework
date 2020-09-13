package io.mk.mbank.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MBankAccountFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String zuulHeader = request.getHeader("fromzuul");
		if ("fz".equals(zuulHeader)) {
			throw new RuntimeException("Unauthorized");
		}
		filterChain.doFilter(request, response);
	}

}
