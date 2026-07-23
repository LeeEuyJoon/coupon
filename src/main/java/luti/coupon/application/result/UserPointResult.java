package luti.coupon.application.result;

public class UserPointResult {

	private final Long userId;
	private final Long pointBalance;

	private UserPointResult(Long userId, Long pointBalance) {
		this.userId = userId;
		this.pointBalance = pointBalance;
	}

	public static UserPointResult of(Long userId, Long pointBalance) {
		return new UserPointResult(userId, pointBalance);
	}

	public Long getUserId() { return userId; }
	public Long getPointBalance() { return pointBalance; }
}
