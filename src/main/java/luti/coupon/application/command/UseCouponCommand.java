package luti.coupon.application.command;

public class UseCouponCommand {

	private final Long userId;
	private final String code;

	private UseCouponCommand(Long userId, String code) {
		this.userId = userId;
		this.code = code;
	}

	public static UseCouponCommand of(Long userId, String code) {
		return new UseCouponCommand(userId, code);
	}

	public Long getUserId() { return userId; }
	public String getCode() { return code; }
}
