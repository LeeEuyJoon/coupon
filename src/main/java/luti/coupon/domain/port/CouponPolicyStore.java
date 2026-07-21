package luti.coupon.domain.port;

import luti.coupon.domain.model.CouponPolicy;

public interface CouponPolicyStore {
	CouponPolicy save(CouponPolicy couponPolicy);
}
