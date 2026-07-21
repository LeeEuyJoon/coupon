package luti.coupon.infrastructure.persistence;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.User;
import luti.coupon.domain.port.UserReader;
import luti.coupon.domain.port.UserStore;
import luti.coupon.infrastructure.repository.UserRepository;

@Repository
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

	private final UserRepository repository;

	@Override
	public User save(User user) {
		return repository.save(user);
	}
}
