package luti.coupon.domain.port;

import java.util.List;
import java.util.Optional;

import luti.coupon.domain.model.Campaign;

public interface CampaignReader {
	Optional<Campaign> findById(Long id);
	List<Campaign> findAllOrderByIdDesc();
}
