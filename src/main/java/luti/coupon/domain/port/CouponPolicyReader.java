package luti.coupon.domain.port;

import java.util.List;
import java.util.Optional;

import luti.coupon.domain.model.CouponPolicy;

public interface CouponPolicyReader {
	Optional<CouponPolicy> findById(Long id);
	List<CouponPolicy> findByCampaignId(Long campaignId);
}
