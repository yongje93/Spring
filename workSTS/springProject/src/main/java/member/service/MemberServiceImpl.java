package member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

@Service(value="memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void write(MemberDTO memberDTO) {
		memberDAO.write(memberDTO);
	}

	@Override
	public void modify(MemberDTO memberDTO) {
		
	}

	@Override
	public MemberDTO login(Map<String, String> map) {		
		return memberDAO.login(map);
	}

	@Override
	public MemberDTO getMember(String id) {
		return null;
	}

	@Override
	public MemberDTO checkId(String id) {
		return memberDAO.checkId(id);
	}

	@Override
	public List<ZipcodeDTO> getZipcodeList(Map<String, String> map) {
		return memberDAO.getZipcodeList(map);
	}

	
	
}
