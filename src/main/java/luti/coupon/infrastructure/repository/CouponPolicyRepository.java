package luti.coupon.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import luti.coupon.domain.model.CouponPolicy;

public interface CouponPolicyRepository extends JpaRepository<CouponPolicy, Long> {
	Optional<CouponPolicy> findById(Long id);
	List<CouponPolicy> findByCampaignId(Long campaignId);
}
