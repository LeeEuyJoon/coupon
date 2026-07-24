package luti.coupon.application.service;

import static luti.coupon.common.ErrorCode.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.common.BusinessException;
import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.model.CouponPolicy;
import luti.coupon.domain.port.CouponPolicyReader;
import luti.coupon.domain.port.CouponPolicyStore;

@Service
@Transactional(readOnly = true)
public class CouponPolicyService {

	private final CouponPolicyReader couponPolicyReader;
	private final CouponPolicyStore couponPolicyStore;

	public CouponPolicyService(CouponPolicyReader couponPolicyReader, CouponPolicyStore couponPolicyStore) {
		this.couponPolicyReader = couponPolicyReader;
		this.couponPolicyStore = couponPolicyStore;
	}

	@Transactional
	public CouponPolicy create(Campaign campaign, Long pointAmount, int quantity) {
		return couponPolicyStore.save(CouponPolicy.create(campaign, pointAmount, quantity));
	}

	public CouponPolicy getById(Long policyId) {
		return couponPolicyReader.findById(policyId)
			.orElseThrow(() -> new BusinessException(COUPON_POLICY_NOT_FOUND));
	}

	public List<CouponPolicy> getByCampaign(Long campaignId) {
		return couponPolicyReader.findByCampaignId(campaignId);
	}

}
