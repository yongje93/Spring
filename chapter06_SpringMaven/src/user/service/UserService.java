package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {
	public void write(UserDTO userDTO);
	public List<UserDTO> getList();
	public UserDTO getUser(String id);
	public void modify(UserDTO userDTO);
	public void delete(String id);
	public UserDTO checkId(String id);
	public List<UserDTO> search(Map<String, String> map);
}
