package luti.coupon.common;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

	/**
	 * 0000: Default Business Error
	 * 1xxx: Campaign Errors
	 * 2xxx: Coupon Errors
	 * 3xxx: Coupon Policy Errors
	 * 4xxx: User Errors
	 */

	DEFAULT_BUSINESS_ERROR("0000", HttpStatus.BAD_REQUEST, "Unexpected business error occurred."),

	CAMPAIGN_NOT_FOUND("1001", HttpStatus.NOT_FOUND, "Campaign not found."),
	NOT_ACTIVE_CAMPAIGN("1002", HttpStatus.BAD_REQUEST, "Campaign is not active."),

	COUPON_NOT_FOUND("2001", HttpStatus.NOT_FOUND, "Coupon not found."),
	NOT_AVAILABLE_COUPON("2002", HttpStatus.BAD_REQUEST, "Coupon is not available for use."),

	COUPON_POLICY_NOT_FOUND("3001", HttpStatus.NOT_FOUND, "Coupon policy not found."),

	USER_NOT_FOUND("4001", HttpStatus.NOT_FOUND, "User not found.");


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
