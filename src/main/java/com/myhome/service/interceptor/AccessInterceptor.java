package com.myhome.service.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myhome.other.Constants;
import com.myhome.service.Validator;
import com.myhome.service.validation.IValidationService;
import com.myhome.util.Logger;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class AccessInterceptor implements HandlerInterceptor {

	private IValidationService validate;
	private ObjectMapper mapper;


	@Override //TODO improve to handle basic auth
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);

		String requestURI = request.getRequestURI();
		String requestMethod = request.getMethod();
		String email = request.getHeader("email");
		String token = request.getHeader("token");

		// Guard
		if (email == null || token == null) {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
			response.getWriter().write(mapper.writeValueAsString(Constants.API.RESPONSE.EMAIL_NOT_NULL));
			return false;
		}

		Logger.log("sas", "Interceptor triggered:   "  + email + " - "  + token);
		return allElementsPresent(email, token);
	}

	private boolean allElementsPresent(String...args) {
		return Arrays.stream(args).toList().stream().noneMatch(String::isEmpty);
	}
}
