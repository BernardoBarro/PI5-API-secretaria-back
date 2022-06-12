package br.com.rotaract.secretaria.exceptions.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rotaract.secretaria.exceptions.AssociadoJaExisteException;
import br.com.rotaract.secretaria.exceptions.ExceptionResponse;
import br.com.rotaract.secretaria.exceptions.NotFoundException;
import br.com.rotaract.secretaria.exceptions.SenhaInvalida;
import br.com.rotaract.secretaria.exceptions.UnauthorizedException;
import feign.FeignException;

@ControllerAdvice
public class ValidationErrorHandler{
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponse> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<String> errors = new ArrayList<>();
		fieldErrors.forEach(e -> {
			String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			String error = (e.getField() + " " + msg);
			errors.add(error);
		});
		String error = String.join(", ", errors);
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.BAD_REQUEST, error, ex.getMessage(), request);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ExceptionResponse> feignException(FeignException ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.BAD_REQUEST, "O cep não existe", ex.getMessage(), request);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> notFound(NotFoundException ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.NOT_FOUND, ex.getMsg(), ex.getMsg(), request);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(SenhaInvalida.class)
	public ResponseEntity<ExceptionResponse> senhaInvalida(SenhaInvalida ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.NOT_FOUND, ex.getMsg(), ex.getMsg(), request);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AssociadoJaExisteException.class)
	public ResponseEntity<ExceptionResponse> found(AssociadoJaExisteException ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMsg(), ex.getMsg(), request);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ExceptionResponse> unauthorized(UnauthorizedException ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.FORBIDDEN, ex.getMsg(), ex.getMsg(), request);
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ExceptionResponse> usernameNotFound(UsernameNotFoundException ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.FORBIDDEN, ex.getLocalizedMessage(), ex.getMessage(), request);
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> genericError(Exception ex, HttpServletRequest request) {
		
		ExceptionResponse erro = buildExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex.getMessage(), request);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}

	private static ExceptionResponse buildExceptionResponse(HttpStatus status, String error, String message,
			HttpServletRequest request) {
		ExceptionResponse erro = new ExceptionResponse();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setError(error);
		erro.setMessage(message);
		erro.setPath(request.getRequestURI());
		
		return erro;
	}
	
}
