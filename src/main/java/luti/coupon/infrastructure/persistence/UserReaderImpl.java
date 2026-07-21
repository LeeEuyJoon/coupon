package luti.coupon.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import luti.coupon.domain.model.User;
import luti.coupon.domain.port.UserReader;
import luti.coupon.infrastructure.repository.UserRepository;

@Repository
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

	private final UserRepository repository;

	@Override
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}
}
