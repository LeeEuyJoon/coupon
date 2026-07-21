package luti.coupon.domain.model;

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
@Table(name = "coupon_policies")
@Getter
public class CouponPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "campaign_id", nullable = false)
	private Campaign campaign;

	@Column(nullable = false)
	private Long pointAmount;

	@Column(nullable = false)
	private int quantity;

	protected CouponPolicy() {}

	public static CouponPolicy create(Campaign campaign, Long pointAmount, int quantity) {
		CouponPolicy couponPolicy = new CouponPolicy();
		couponPolicy.campaign = campaign;
		couponPolicy.pointAmount = pointAmount;
		couponPolicy.quantity = quantity;
		return couponPolicy;
	}

}
