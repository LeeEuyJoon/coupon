package luti.coupon.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luti.coupon.application.facade.UserFacade;
import luti.coupon.web.mapper.UserMapper;
import luti.coupon.web.response.UserPointResponse;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserFacade userFacade;

	public UserController(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	@GetMapping("/{id}/points")
	public ResponseEntity<UserPointResponse> getPointBalance(@PathVariable Long id) {
		var result = userFacade.getPointBalance(id);
		return ResponseEntity.ok(UserMapper.toResponse(result));
	}

}
