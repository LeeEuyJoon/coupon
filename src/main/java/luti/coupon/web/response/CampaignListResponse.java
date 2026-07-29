package luti.coupon.web.response;

import java.time.LocalDateTime;

public record CampaignListResponse(
	Long id,
	String name,
	LocalDateTime startAt,
	LocalDateTime endAt,
	String status,
	Long policyCount
) {}
