package luti.coupon.web.response;

import java.time.LocalDateTime;
import java.util.List;

public record CampaignResponse(
	Long id,
	String name,
	String description,
	LocalDateTime startAt,
	LocalDateTime endAt,
	String status,
	List<PolicyResponse> policies
) {
	public record PolicyResponse(Long id, Long pointAmount, int quantity) {}
}
