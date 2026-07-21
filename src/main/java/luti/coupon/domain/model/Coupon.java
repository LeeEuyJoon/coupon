package luti.coupon.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "coupons")
@Getter
public class Coupon {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coupon_policy_id", nullable = false)
	private CouponPolicy couponPolicy;

	@Column(nullable = false, unique = true)
	private String code;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CouponStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "used_by")
	private User usedBy;

	@Column
	private LocalDateTime usedAt;

	protected Coupon() {}

	public static Coupon create(CouponPolicy couponPolicy, String code) {
		Coupon coupon = new Coupon();
		coupon.couponPolicy = couponPolicy;
		coupon.code = code;
		coupon.status = CouponStatus.AVAILABLE;
		return coupon;
	}

	public void use(User user) {
		this.status = CouponStatus.USED;
		this.usedBy = user;
		this.usedAt = LocalDateTime.now();
	}

	public boolean isAvailable() {
		return status == CouponStatus.AVAILABLE;
	}

}
