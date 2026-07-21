package luti.coupon.domain.port;

import luti.coupon.domain.model.Coupon;

public interface CouponStore {
	Coupon save(Coupon coupon);
}
