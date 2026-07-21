package luti.coupon.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "campaigns")
@Getter
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

	@Column(nullable = false)
	private LocalDateTime startAt;

	@Column(nullable = false)
	private LocalDateTime endAt;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CampaignStatus status;

	protected Campaign() {}

	public static Campaign create(String name, String description,
								  LocalDateTime startAt, LocalDateTime endAt) {
		Campaign campaign = new Campaign();
		campaign.name = name;
		campaign.description = description;
		campaign.startAt = startAt;
		campaign.endAt = endAt;
		campaign.status = CampaignStatus.ACTIVE;
		return campaign;
	}

	public boolean isActive() {
		LocalDateTime now = LocalDateTime.now();
		return status == CampaignStatus.ACTIVE
			&& !now.isBefore(startAt)
			&& !now.isAfter(endAt);
	}
}
