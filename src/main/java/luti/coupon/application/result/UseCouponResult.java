package luti.coupon.application.result;

public class UseCouponResult {

	private final Long chargedPoint;
	private final Long currentBalance;

	private UseCouponResult(Long chargedPoint, Long currentBalance) {
		this.chargedPoint = chargedPoint;
		this.currentBalance = currentBalance;
	}

	public static UseCouponResult of(Long chargedPoint, Long currentBalance) {
		return new UseCouponResult(chargedPoint, currentBalance);
	}

	public Long getChargedPoint() { return chargedPoint; }
	public Long getCurrentBalance() { return currentBalance; }

}
