package luti.coupon.application.facade;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.application.command.CreateCampaignCommand;
import luti.coupon.application.result.CampaignListResult;
import luti.coupon.application.result.CampaignResult;
import luti.coupon.application.service.CampaignService;
import luti.coupon.application.service.CouponPolicyService;
import luti.coupon.application.service.CouponService;
import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.model.CouponPolicy;

@Component
@Transactional(readOnly = true)
public class CampaignFacade {

	private final CampaignService campaignService;
	private final CouponPolicyService couponPolicyService;
	private final CouponService couponService;

	public CampaignFacade(CampaignService campaignService, CouponPolicyService couponPolicyService,
						  CouponService couponService) {
		this.campaignService = campaignService;
		this.couponPolicyService = couponPolicyService;
		this.couponService = couponService;
	}

	@Transactional
	public Long createCampaign(CreateCampaignCommand command) {
		Campaign campaign = campaignService.create(
			command.getName(), command.getDescription(),
			command.getStartAt(), command.getEndAt()
		);

		for (CreateCampaignCommand.PolicyCommand p: command.getPolicies()) {
			couponPolicyService.create(campaign, p.getPointAmount(), p.getQuantity());
		}

		return campaign.getId();
	}

	public CampaignResult getCampaign(Long campaignId) {
		Campaign campaign = campaignService.getById(campaignId);
		List<CouponPolicy> policies = couponPolicyService.getByCampaign(campaignId);

		List<CampaignResult.PolicyResult> policyResults = policies.stream()
			.map(policy -> CampaignResult.PolicyResult.of(
				policy,
				couponService.countByCouponPolicyId(policy.getId()),
				couponService.countUsedByCouponPolicyId(policy.getId())
			))
			.toList();

		return CampaignResult.of(campaign, policyResults);
	}

	public List<CampaignListResult> getCampaigns() {
		return campaignService.getAll().stream()
			.map(campaign -> CampaignListResult.of(
				campaign, couponPolicyService.countByCampaignId(campaign.getId())
			)).toList();
	}

}
