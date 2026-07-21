package luti.coupon.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.port.CouponReader;
import luti.coupon.infrastructure.repository.CouponRepository;

@Repository
@RequiredArgsConstructor
public class CouponReaderImpl implements CouponReader {

	private final CouponRepository repository;

	@Override
	public Optional<Coupon> findById(Long couponId) {
		return repository.findById(couponId);
	}

	@Override
	public Optional<Coupon> findByCode(String code) {
		return repository.findByCode(code);
	}
}
