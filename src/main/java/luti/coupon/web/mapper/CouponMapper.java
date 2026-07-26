package luti.coupon.web.mapper;

import luti.coupon.application.command.CreateCouponsCommand;
import luti.coupon.application.command.UseCouponCommand;
import luti.coupon.application.result.UseCouponResult;
import luti.coupon.web.request.CreateCouponRequest;
import luti.coupon.web.request.UseCouponRequest;
import luti.coupon.web.response.UseCouponResponse;

public class CouponMapper {

	private CouponMapper() {}

	public static CreateCouponsCommand toCommand(Long campaignId, CreateCouponRequest request) {
		return CreateCouponsCommand.of(campaignId, request.policyId());
	}

	public static UseCouponCommand toCommand(UseCouponRequest request) {
		return UseCouponCommand.of(request.userId(), request.code());
	}

	public static UseCouponResponse toResponse(UseCouponResult result) {
		return new UseCouponResponse(result.getChargedPoint(), result.getCurrentBalance());
	}

}
