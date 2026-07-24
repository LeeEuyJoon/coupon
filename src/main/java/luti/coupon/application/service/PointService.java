package luti.coupon.application.service;

import static luti.coupon.common.ErrorCode.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luti.coupon.common.BusinessException;
import luti.coupon.domain.model.Coupon;
import luti.coupon.domain.model.PointChargeHistory;
import luti.coupon.domain.model.User;
import luti.coupon.domain.port.PointChargeHistoryStore;
import luti.coupon.domain.port.UserReader;
import luti.coupon.domain.port.UserStore;

@Service
@Transactional(readOnly = true)
public class PointService {

	private final UserReader userReader;
	private final UserStore userStore;
	private final PointChargeHistoryStore pointChargeHistoryStore;

	public PointService(UserReader userReader, UserStore userStore, PointChargeHistoryStore pointChargeHistoryStore) {
		this.userReader = userReader;
		this.userStore = userStore;
		this.pointChargeHistoryStore = pointChargeHistoryStore;
	}

	public User getUser(Long userId) {
		return userReader.findById(userId)
			.orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
	}

	@Transactional
	public void charge(User user, Coupon coupon, Long pointAmount) {
		user.chargePoint(pointAmount);
		userStore.save(user);
		pointChargeHistoryStore.save(PointChargeHistory.create(user, coupon, pointAmount));
	}

	public Long getBalance(Long userId) {
		return getUser(userId).getPointBalance();
	}

}
