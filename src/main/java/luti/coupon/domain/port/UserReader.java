package luti.coupon.domain.port;

import java.util.Optional;

import luti.coupon.domain.model.User;

public interface UserReader {
	Optional<User> findById(Long id);
}
