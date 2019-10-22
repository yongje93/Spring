package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {
	public void write(MemberDTO memberDTO);
	public void modify(MemberDTO memberDTO);
	public MemberDTO login(Map<String, String> map);
	public MemberDTO getMember(String id);
	public MemberDTO checkId(String id);
	public List<ZipcodeDTO> getZipcodeList(Map<String, String> map);
}
