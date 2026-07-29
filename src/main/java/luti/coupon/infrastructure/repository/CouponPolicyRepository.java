package luti.coupon.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import luti.coupon.domain.model.CouponPolicy;

public interface CouponPolicyRepository extends JpaRepository<CouponPolicy, Long> {
	List<CouponPolicy> findByCampaignId(Long campaignId);
	Long countByCampaignId(Long campaignId);
}
