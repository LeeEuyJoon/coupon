package luti.coupon.domain.port;

import luti.coupon.domain.model.Campaign;

public interface CampaignStore {
	Campaign save(Campaign campaign);
}
