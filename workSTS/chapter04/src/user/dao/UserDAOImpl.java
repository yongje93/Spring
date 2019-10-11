package user.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Setter;
import user.bean.UserDTO;

public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void userWrite(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}
}
