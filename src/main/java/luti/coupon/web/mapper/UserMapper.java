package luti.coupon.web.mapper;

import luti.coupon.application.result.UserPointResult;
import luti.coupon.web.response.UserPointResponse;

public class UserMapper {

	private UserMapper() {}

	public static UserPointResponse toResponse(UserPointResult result) {
		return new UserPointResponse(result.getUserId(), result.getPointBalance());
	}
}
