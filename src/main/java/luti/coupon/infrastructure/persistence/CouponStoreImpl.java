package luti.coupon.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.port.CouponStore;
import luti.coupon.infrastructure.repository.CouponRepository;

@Repository
@RequiredArgsConstructor
public class CouponStoreImpl implements CouponStore {

	private final CouponRepository repository;

	@Override
	public Coupon save(Coupon coupon) {
		return repository.save(coupon);
	}
}
