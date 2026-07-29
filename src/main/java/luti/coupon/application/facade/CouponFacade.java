package luti.coupon.application.facade;

import static luti.coupon.common.ErrorCode.*;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.micrometer.core.instrument.MeterRegistry;
import luti.coupon.application.command.CreateCouponsCommand;
import luti.coupon.application.command.UseCouponCommand;
import luti.coupon.application.result.UseCouponResult;
import luti.coupon.application.service.CampaignService;
import luti.coupon.application.service.CouponPolicyService;
import luti.coupon.application.service.CouponService;
import luti.coupon.application.service.PointService;
import luti.coupon.common.BusinessException;
import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.model.CouponPolicy;
import luti.coupon.domain.model.User;

@Component
@Transactional(readOnly = true)
public class CouponFacade {

	private final CouponService couponService;
	private final CouponPolicyService couponPolicyService;
	private final CampaignService campaignService;
	private final PointService pointService;
	private final MeterRegistry meterRegistry;

	public CouponFacade(CouponService couponService, CouponPolicyService couponPolicyService,
						CampaignService campaignService, PointService pointService, MeterRegistry meterRegistry) {
		this.couponService = couponService;
		this.couponPolicyService = couponPolicyService;
		this.campaignService = campaignService;
		this.pointService = pointService;
		this.meterRegistry = meterRegistry;
	}

	@Transactional
	public int createCoupons(CreateCouponsCommand command) {
		return meterRegistry.timer("coupon.generation.duration").record(() -> {
			CouponPolicy policy = couponPolicyService.getById(command.getPolicyId());

			if (!policy.getCampaign().getId().equals(command.getCampaignId())) {
				throw new BusinessException(COUPON_POLICY_CAMPAIGN_MISMATCH);
			}

			couponService.createBatch(policy, policy.getQuantity());
			return policy.getQuantity();
		});
	}

	@Transactional
	public UseCouponResult useCoupon(UseCouponCommand command) {
		return meterRegistry.timer("coupon.use.duration").record(() -> {
			User user = pointService.getUser(command.getUserId());
			Coupon coupon = couponService.getAvailableByCode(command.getCode());

			campaignService.validateActive(coupon.getCouponPolicy().getCampaign());

			Long pointAmount = coupon.getCouponPolicy().getPointAmount();
			couponService.markAsUsed(coupon, user);
			pointService.charge(user, coupon, pointAmount);

			return UseCouponResult.of(pointAmount, user.getPointBalance());
		});
	}
}
