package emlakburada.dto.response;

import emlakburada.model.User;
import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

	private User user;
	public UserResponse(UserType userType, String name, String email) {
		this.userType = userType;
		this.name = name;
		this.email = email;
	}

	private UserType userType; // bireysel & kurumsal & yeniTip
	private String name;
	private String email;


}
