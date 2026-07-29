package luti.coupon.application.result;

import java.time.LocalDateTime;

import luti.coupon.domain.model.Campaign;

public class CampaignListResult {

	private final Long id;
	private final String name;
	private final LocalDateTime startAt;
	private final LocalDateTime endAt;
	private final String status;
	private final Long policyCount;

	private CampaignListResult(Long id, String name, LocalDateTime startAt, LocalDateTime endAt, String status,
							   Long policyCount) {
		this.id = id;
		this.name = name;
		this.startAt = startAt;
		this.endAt = endAt;
		this.status = status;
		this.policyCount = policyCount;
	}

	public static CampaignListResult of(Campaign campaign, Long policyCount) {
		return new CampaignListResult(
			campaign.getId(), campaign.getName(),
			campaign.getStartAt(), campaign.getEndAt(),
			campaign.getStatus().name(), policyCount
		);
	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public LocalDateTime getStartAt() { return startAt; }
	public LocalDateTime getEndAt() { return endAt; }
	public String getStatus() { return status; }
	public Long getPolicyCount() { return policyCount; }
}
