package luti.coupon.application.facade;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.application.command.CreateCampaignCommand;
import luti.coupon.application.result.CampaignResult;
import luti.coupon.application.service.CampaignService;
import luti.coupon.application.service.CouponPolicyService;
import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.model.CouponPolicy;

@Component
@Transactional(readOnly = true)
public class CampaignFacade {

	private final CampaignService campaignService;
	private final CouponPolicyService couponPolicyService;

	public CampaignFacade(CampaignService campaignService, CouponPolicyService couponPolicyService) {
		this.campaignService = campaignService;
		this.couponPolicyService = couponPolicyService;
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
		return CampaignResult.of(campaign, policies);
	}

}
