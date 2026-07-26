package luti.coupon.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luti.coupon.application.facade.CampaignFacade;
import luti.coupon.web.mapper.CampaignMapper;
import luti.coupon.web.request.CreateCampaignRequest;
import luti.coupon.web.response.CampaignResponse;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

	private final CampaignFacade campaignFacade;

	public CampaignController(CampaignFacade campaignFacade) {
		this.campaignFacade = campaignFacade;
	}

	 @PostMapping
	public ResponseEntity<Long> createCampaign(@RequestBody CreateCampaignRequest request) {
		var command = CampaignMapper.toCommand(request);
		var campaignId = campaignFacade.createCampaign(command);
		return ResponseEntity.ok(campaignId);
	 }

	 @GetMapping("/{id}")
	public ResponseEntity<CampaignResponse> getCampaign(@PathVariable Long id) {
		return ResponseEntity.ok(CampaignMapper.toResponse(campaignFacade.getCampaign(id)));
	 }

}
