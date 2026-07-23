package luti.coupon.application.command;

import java.time.LocalDateTime;
import java.util.List;

public class CreateCampaignCommand {

	private final String name;
	private final String description;
	private final LocalDateTime startAt;
	private final LocalDateTime endAt;
	private final List<PolicyCommand> policies;

	private CreateCampaignCommand(String name, String description, LocalDateTime startAt, LocalDateTime endAt,
								 List<PolicyCommand> policies) {
		this.name = name;
		this.description = description;
		this.startAt = startAt;
		this.endAt = endAt;
		this.policies = policies;
	}

	public static CreateCampaignCommand of(String name, String description,
											 LocalDateTime startAt, LocalDateTime endAt,
											List<PolicyCommand> policies) {
		return new CreateCampaignCommand(name, description, startAt, endAt, policies);
	}

	public static class PolicyCommand {
		private final Long pointAmount;
		private final int quantity;

		private PolicyCommand(Long pointAmount, int quantity) {
			this.pointAmount = pointAmount;
			this.quantity = quantity;
		}

		public static PolicyCommand of(Long pointAmount, int quantity) {
			return new PolicyCommand(pointAmount, quantity);
		}

		public Long getPointAmount() {
			return pointAmount;
		}

		public int getQuantity() {
			return quantity;
		}
	}

	public String getName() { return name; }
	public String getDescription() { return description; }
	public LocalDateTime getStartAt() { return startAt; }
	public LocalDateTime getEndAt() { return endAt; }
	public List<PolicyCommand> getPolicies() { return policies; }

}
