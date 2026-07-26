package luti.coupon.infrastructure.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import luti.coupon.domain.model.User;
import luti.coupon.infrastructure.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationRunner {

	private final UserRepository userRepository;

	public DataInitializer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		if (userRepository.existsByName("admin")) {
			return;
		}

		User admin = User.create("admin");
		userRepository.save(admin);
	}
}
