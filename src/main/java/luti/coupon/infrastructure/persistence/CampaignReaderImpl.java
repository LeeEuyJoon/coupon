package luti.coupon.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.port.CampaignReader;
import luti.coupon.infrastructure.repository.CampaignRepository;

@Repository
@RequiredArgsConstructor
public class CampaignReaderImpl implements CampaignReader {

	private final CampaignRepository repository;

	@Override
	public Optional<Campaign> findById(Long id) {
		return repository.findById(id);
	}
}
