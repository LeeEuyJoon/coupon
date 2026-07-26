package luti.coupon.application.result;

import java.time.LocalDateTime;
import java.util.List;

import luti.coupon.domain.model.Campaign;
import luti.coupon.domain.model.CouponPolicy;

public class CampaignResult {

	private final Long id;
	private final String name;
	private final String description;
	private final LocalDateTime startAt;
	private final LocalDateTime endAt;
	private final String status;
	private final List<PolicyResult> policies;

	private CampaignResult(Long id, String name, String description, LocalDateTime startAt, LocalDateTime endAt,
						   String status, List<PolicyResult> policies) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startAt = startAt;
		this.endAt = endAt;
		this.status = status;
		this.policies = policies;
	}

	public static CampaignResult of(Campaign campaign, List<CouponPolicy> policies) {
		List<PolicyResult> policyResults = policies.stream()
			.map(PolicyResult::of)
			.toList();
		return new CampaignResult(
			campaign.getId(), campaign.getName(), campaign.getDescription(),
			campaign.getStartAt(), campaign.getEndAt(), campaign.getStatus().name(),
			policyResults
		);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getStartAt() {
		return startAt;
	}

	public LocalDateTime getEndAt() {
		return endAt;
	}

	public String getStatus() {
		return status;
	}

	public List<PolicyResult> getPolicies() {
		return policies;
	}

	public static class PolicyResult {
		private final Long id;
		private final Long pointAmount;
		private final int quantity;

		private PolicyResult(Long id, Long pointAmount, int quantity) {
			this.id = id;
			this.pointAmount = pointAmount;
			this.quantity = quantity;
		}

		public static PolicyResult of(CouponPolicy policy) {
			return new PolicyResult(policy.getId(), policy.getPointAmount(), policy.getQuantity());
		}

		public Long getId() {
			return id;
		}

		public Long getPointAmount() {
			return pointAmount;
		}

		public int getQuantity() {
			return quantity;
		}
	}

}
