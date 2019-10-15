package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {
	public void userWrite(UserDTO userDTO);
	public List<UserDTO> getUserList();
	public UserDTO getUser(String id);
	public void userUpdate(Map<String, String> map);
	public void userDelete(String id);
	public List<UserDTO> userSearch(Map<String, String> map);
}
