package luti.coupon.common;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	/**
	 * 0000: Default Business Error
	 */

	DEFAULT_BUSINESS_ERROR("0000", HttpStatus.BAD_REQUEST, "Unexpected business error occurred.");

	private final String code;
	private final HttpStatus httpStatus;
	private final String message;

	ErrorCode(String code, HttpStatus httpStatus, String message) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public String getNumericCode() { return this.code;}
	public String getMessage() { return "[" + this.code + "] " + this.message; }
	public HttpStatus getHttpStatus() { return this.httpStatus; }
}
