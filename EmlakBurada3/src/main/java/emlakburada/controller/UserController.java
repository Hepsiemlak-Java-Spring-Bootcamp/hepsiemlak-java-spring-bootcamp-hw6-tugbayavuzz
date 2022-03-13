package emlakburada.controller;

import java.util.List;

import emlakburada.dto.response.AdvertResponse;
import emlakburada.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	//create user
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody UserRequest request) {
		userService.saveUser(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	//get by user id
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResponse> getUserByUserId(@PathVariable(required = false) int id) {
		return new ResponseEntity<>(userService.getUserByUserId(id), HttpStatus.OK);
	}
	//get all user
	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	//delete by user id
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable(value="id") int id) {
		userService.deleteUser(id);
		return new ResponseEntity<> (HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
		return new ResponseEntity<>(userService.updateUser(userRequest), HttpStatus.OK);
	}

}
