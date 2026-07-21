package luti.coupon.domain.port;

import luti.coupon.domain.model.User;

public interface UserStore {
	User save(User user);
}
