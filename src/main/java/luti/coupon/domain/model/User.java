package luti.coupon.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Long pointBalance;

	protected User() {}

	public static User create(String name) {
		User user = new User();
		user.name = name;
		user.pointBalance = 0L;
		return user;
	}

	public void chargePoint(Long amount) {
		this.pointBalance += amount;
	}
}
