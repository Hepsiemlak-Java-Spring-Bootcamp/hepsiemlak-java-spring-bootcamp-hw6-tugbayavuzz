package emlakburada.service;

import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;

public class UserBaseService {

    protected UserResponse convertToUserEntity(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        return userResponse;
    }

	/*protected UserResponse convertToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setName(user.getName());
		userResponse.setEmail(user.getEmail());
		userResponse.setBio(user.getBio());
		userResponse.setUserType(user.getUserType());
		return userResponse;
	}

	 */

}
