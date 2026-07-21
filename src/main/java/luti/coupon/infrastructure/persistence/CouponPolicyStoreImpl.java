package luti.coupon.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.CouponPolicy;
import luti.coupon.domain.port.CouponPolicyStore;
import luti.coupon.infrastructure.repository.CouponPolicyRepository;

@Repository
@RequiredArgsConstructor
public class CouponPolicyStoreImpl implements CouponPolicyStore {

	private final CouponPolicyRepository repository;

	@Override
	public CouponPolicy save(CouponPolicy couponPolicy) {
		return repository.save(couponPolicy);
	}
}
