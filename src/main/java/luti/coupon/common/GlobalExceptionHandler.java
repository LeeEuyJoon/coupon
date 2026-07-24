package luti.coupon.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception ex, WebRequest request) {

		log.error("unexpected error occurred: uri={}, error={}",
				  request.getDescription(false), ex.getMessage(), ex);

		ErrorResponse response = ErrorResponse.of(ErrorCode.DEFAULT_BUSINESS_ERROR);

		return ResponseEntity
			.status(ErrorCode.DEFAULT_BUSINESS_ERROR.getHttpStatus())
			.body(response);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex, WebRequest request) {
		ErrorCode errorCode = ex.getErrorCode();

		log.error("business exception occurred: uri={}, errorCode={}, message={}",
				  request.getDescription(false), errorCode.name(), errorCode.getMessage());

		ErrorResponse response = ErrorResponse.of(errorCode);

		return ResponseEntity
			.status(errorCode.getHttpStatus())
			.body(response);
	}
}
