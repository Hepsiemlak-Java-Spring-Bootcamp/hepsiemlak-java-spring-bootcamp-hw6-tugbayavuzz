package emlakburada.entity;

import javax.persistence.*;

import emlakburada.entity.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserType userType;

}
