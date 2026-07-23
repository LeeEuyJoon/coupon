package luti.coupon.web.request;

import java.time.LocalDateTime;
import java.util.List;

public record CreateCampaignRequest(
	String name,
	String description,
	LocalDateTime startAt,
	LocalDateTime endAt,
	List<PolicyRequest> policies
) {
	public record PolicyRequest(Long pointAmount, int quantity) {}
}
