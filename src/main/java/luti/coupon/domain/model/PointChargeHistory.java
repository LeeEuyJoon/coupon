package luti.coupon.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "point_charge_histories")
@Getter
public class PointChargeHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coupon_id", nullable = false)
	private Coupon coupon;

	@Column(nullable = false)
	private Long pointAmount;

	@Column(nullable = false, updatable = false)
	private LocalDateTime chargedAt;

	protected PointChargeHistory() {}

	public static PointChargeHistory create(User user, Coupon coupon, Long pointAmount) {
		PointChargeHistory history = new PointChargeHistory();
		history.user = user;
		history.coupon = coupon;
		history.pointAmount = pointAmount;
		history.chargedAt = LocalDateTime.now();
		return history;
	}
}
