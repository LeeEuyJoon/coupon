package luti.coupon.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.CouponPolicy;
import luti.coupon.domain.port.CouponPolicyReader;
import luti.coupon.infrastructure.repository.CouponPolicyRepository;

@Repository
@RequiredArgsConstructor
public class CouponPolicyReaderImpl implements CouponPolicyReader {

	private final CouponPolicyRepository repository;

	@Override
	public Optional<CouponPolicy> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<CouponPolicy> findByCampaignId(Long campaignId) {
		return repository.findByCampaignId(campaignId);
	}
}
