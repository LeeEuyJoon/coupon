package luti.coupon.web.mapper;

import java.util.List;

import luti.coupon.application.command.CreateCampaignCommand;
import luti.coupon.application.result.CampaignListResult;
import luti.coupon.application.result.CampaignResult;
import luti.coupon.web.request.CreateCampaignRequest;
import luti.coupon.web.response.CampaignListResponse;
import luti.coupon.web.response.CampaignResponse;

public class CampaignMapper {

	private CampaignMapper() {
	}

	public static CreateCampaignCommand toCommand(CreateCampaignRequest request) {
		List<CreateCampaignCommand.PolicyCommand> policies = request
			.policies()
			.stream()
			.map(p -> CreateCampaignCommand.PolicyCommand.of(p.pointAmount(), p.quantity()))
			.toList();
		return CreateCampaignCommand.of(request.name(), request.description(), request.startAt(), request.endAt(),
										policies);
	}

	public static CampaignResponse toResponse(CampaignResult result) {
		List<CampaignResponse.PolicyResponse> policies = result
			.getPolicies()
			.stream()
			.map(p -> new CampaignResponse.PolicyResponse(p.getId(), p.getPointAmount(), p.getQuantity(),
														  p.getGeneratedCount(), p.getUsedCount()))
			.toList();
		return new CampaignResponse(result.getId(), result.getName(), result.getDescription(), result.getStartAt(),
									result.getEndAt(), result.getStatus(), policies);
	}

	public static CampaignListResponse toListResponse(CampaignListResult result) {
		return new CampaignListResponse(result.getId(), result.getName(), result.getStartAt(), result.getEndAt(),
										result.getStatus(), result.getPolicyCount());
	}

}
