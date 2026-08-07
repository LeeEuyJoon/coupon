package luti.coupon.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.model.CouponStatus;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
	Optional<Coupon> findByCode(String code);
	Long countByCouponPolicyId(Long couponPolicyId);
	Long countByCouponPolicyIdAndStatus(Long couponPolicyId, CouponStatus status);
}
