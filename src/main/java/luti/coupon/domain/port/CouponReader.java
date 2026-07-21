package luti.coupon.domain.port;

import java.util.Optional;

import luti.coupon.domain.model.Coupon;

public interface CouponReader {
	Optional<Coupon> findById(Long couponId);
	Optional<Coupon> findByCode(String code);
}
