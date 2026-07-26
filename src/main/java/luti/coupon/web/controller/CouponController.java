package luti.coupon.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import luti.coupon.application.facade.CouponFacade;
import luti.coupon.web.mapper.CouponMapper;
import luti.coupon.web.request.CreateCouponRequest;
import luti.coupon.web.request.UseCouponRequest;
import luti.coupon.web.response.UseCouponResponse;

@RestController
public class CouponController {

	private final CouponFacade couponFacade;

	public CouponController(CouponFacade couponFacade) {
		this.couponFacade = couponFacade;
	}

	@PostMapping("/campaigns/{campaignId}/coupons")
	public ResponseEntity<Integer> createCoupons(
		@PathVariable Long campaignId,
		@RequestBody CreateCouponRequest request) {
		var command = CouponMapper.toCommand(campaignId, request);
		var createdCount = couponFacade.createCoupons(command);
		return ResponseEntity.ok(createdCount);
	}

	@PostMapping("/coupons/use")
	public ResponseEntity<UseCouponResponse> useCoupon(@RequestBody UseCouponRequest request) {
		var command = CouponMapper.toCommand(request);
		var result = couponFacade.useCoupon(command);
		return ResponseEntity.ok(CouponMapper.toResponse(result));

	}
}
