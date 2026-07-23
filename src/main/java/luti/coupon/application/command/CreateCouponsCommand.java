package luti.coupon.application.command;

public class CreateCouponsCommand {

	private final Long campaignId;
	private final Long policyId;

	private CreateCouponsCommand(Long campaignId, Long policyId) {
		this.campaignId = campaignId;
		this.policyId = policyId;
	}

	public static CreateCouponsCommand of(Long campaignId, Long policyId) {
		return new CreateCouponsCommand(campaignId, policyId);
	}

	public Long getCampaignId() { return campaignId; }
	public Long getPolicyId() { return policyId; }

}
