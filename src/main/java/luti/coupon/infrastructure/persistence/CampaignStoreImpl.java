package luti.coupon.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.port.CampaignStore;
import luti.coupon.infrastructure.repository.CampaignRepository;

@Repository
@RequiredArgsConstructor
public class CampaignStoreImpl implements CampaignStore {

	private final CampaignRepository repository;

	@Override
	public Campaign save(Campaign campaign) {
		return repository.save(campaign);
	}
}
