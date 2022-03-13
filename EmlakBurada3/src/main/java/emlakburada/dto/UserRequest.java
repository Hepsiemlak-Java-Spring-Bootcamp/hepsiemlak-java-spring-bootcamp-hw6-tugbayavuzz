package emlakburada.dto;

import emlakburada.model.User;
import emlakburada.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequest {

	private User user;
	private UserType userType; // bireysel & kurumsal & yeniTip
	private String name;
	private String email;

	public UserRequest(UserType userType, String name, String email) {
		this.userType = userType;
		this.name = name;
		this.email = email;
	}


}
