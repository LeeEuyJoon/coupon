package luti.coupon.domain.port;

import java.util.Optional;

import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.model.CouponStatus;

public interface CouponReader {
	Optional<Coupon> findById(Long couponId);
	Optional<Coupon> findByCode(String code);
	Long countByCouponPolicyId(Long couponPolicyId);
	Long countByCouponPolicyIdAndStatus(Long couponPolicyId, CouponStatus status);
}
