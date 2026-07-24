package luti.coupon.application.service;

import static luti.coupon.common.ErrorCode.*;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.common.BusinessException;
import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.port.CampaignReader;
import luti.coupon.domain.port.CampaignStore;

@Service
@Transactional(readOnly = true)
public class CampaignService {

	private final CampaignReader campaignReader;
	private final CampaignStore campaignStore;

	public CampaignService(CampaignReader campaignReader, CampaignStore campaignStore) {
		this.campaignReader = campaignReader;
		this.campaignStore = campaignStore;
	}

	@Transactional
	public Campaign create(String name, String description, LocalDateTime startAt, LocalDateTime endAt) {
		return campaignStore.save(Campaign.create(name, description, startAt, endAt));
	}

	public Campaign getById(Long campaignId) {
		return campaignReader.findById(campaignId)
			.orElseThrow(() -> new BusinessException(CAMPAIGN_NOT_FOUND));
	}

	public void validateActive(Campaign campaign) {
		if (!campaign.isActive()) {
			throw new BusinessException(NOT_ACTIVE_CAMPAIGN);
		}
	}
}
