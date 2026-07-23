package luti.coupon.domain.service;

import java.security.SecureRandom;

public class CouponCodeGenerator {

	private static final String CHARACTERS = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
	private static final int CODE_LENGTH = 16;
	private static final SecureRandom RANDOM = new SecureRandom();

	private CouponCodeGenerator() {}

	public static String generate() {
		StringBuilder code = new StringBuilder(CODE_LENGTH);
		for (int i = 0; i < CODE_LENGTH; i++) {
			code.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
		}
		return code.toString();
	}

	public static String format(String code) {
		return code.replaceAll("(.{4})(?=.)", "$1-");
	}
}
