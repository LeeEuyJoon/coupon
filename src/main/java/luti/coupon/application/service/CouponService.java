package luti.coupon.application.service;

import static luti.coupon.common.ErrorCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.common.BusinessException;
import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.model.CouponPolicy;
import luti.coupon.domain.model.User;
import luti.coupon.domain.port.CouponReader;
import luti.coupon.domain.port.CouponStore;
import luti.coupon.domain.service.CouponCodeGenerator;

@Service
@Transactional(readOnly = true)
public class CouponService {

	private final CouponReader couponReader;
	private final CouponStore couponStore;

	public CouponService(CouponReader couponReader, CouponStore couponStore) {
		this.couponReader = couponReader;
		this.couponStore = couponStore;
	}

	@Transactional
	public void createBatch(CouponPolicy policy, int quantity) {
		for (int i = 0; i < quantity; i++) {
			couponStore.save(Coupon.create(policy, CouponCodeGenerator.generate()));
		}
	}

	public Coupon getAvailableByCode(String code) {
		String normalizedCode = code.replace("-", "");
		Coupon coupon = couponReader
			.findByCode(normalizedCode)
			.orElseThrow(() -> new BusinessException(COUPON_NOT_FOUND));

		if (!coupon.isAvailable()) {
			throw new BusinessException(NOT_AVAILABLE_COUPON);
		}
		return coupon;
	}

	@Transactional
	public void markAsUsed(Coupon coupon, User user) {
		coupon.use(user);
	}
}
