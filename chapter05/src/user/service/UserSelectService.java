package user.service;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSelectService implements UserService {
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();

		System.out.println("\n이름\t아이디\t비밀번호");
		for (UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
	}

}
