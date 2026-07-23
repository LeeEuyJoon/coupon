package luti.coupon.application.result;

import java.time.LocalDateTime;
import java.util.List;

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

	public static CampaignResult of(Long id, String name, String description, LocalDateTime startAt,
									LocalDateTime endAt, String status, List<PolicyResult> policies) {
		return new CampaignResult(id, name, description, startAt, endAt, status, policies);
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

		public static PolicyResult of(Long id, Long pointAmount, int quantity) {
			return new PolicyResult(id, pointAmount, quantity);
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
