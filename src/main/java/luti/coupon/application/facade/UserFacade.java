package luti.coupon.application.facade;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.application.result.UserPointResult;
import luti.coupon.application.service.PointService;

@Component
@Transactional(readOnly = true)
public class UserFacade {

	private final PointService pointService;

	public UserFacade(PointService pointService) {
		this.pointService = pointService;
	}

	public UserPointResult getPointBalance(Long userId) {
		return UserPointResult.of(userId, pointService.getBalance(userId));
	}
}
