package edu.nju.healthclub.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.nju.healthclub.dao.MemberDao;
import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.enuminfo.REGISTER_RESULT;
import edu.nju.healthclub.service.enuminfo.UPDATE_RESULT;
import edu.nju.healthclub.service.enuminfo.VALIDATE_RESULT;

public class MemberServiceImpl implements MemberService{

	private MemberDao memberDao;
	
	private MemberServiceImpl() {
		
	}
	
	@Override
	public MemberDao getMemberDao() {
		return memberDao;
	}
	@Override
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	
	@Override
	public Member validateMember(String memberid) {
		Member member = memberDao.find("memberid", memberid);
		return member;
	}

	@Override
	public REGISTER_RESULT registerMember(Member member) {
		if(validateUpdateMember(member) != null) {
			return REGISTER_RESULT.��Ϣδ��д��ȫ;
		} else {
			memberDao.save(member);
			return REGISTER_RESULT.ע��ɹ�;
		}
	}

	@Override
	public VALIDATE_RESULT validateUpdateMember(Member member) {
        if(member.getAddress().equals("") || member.getAge() <=0 || member.getName().equals("") ||
        		member.getPassword().equals("")) {
        	return VALIDATE_RESULT.��Ϣ��д������;
        } else {
        	return VALIDATE_RESULT.��֤�ɹ�;
        }
	}

	@Override
	public Integer validateNumber(String number) {
		Integer num=null;
		try{
			num=Integer.valueOf(number);
		}
		catch(Exception e){
			return null;
		}
		
		if(num.intValue()<=0){
			return null;
		}
		
		return num;
	}

	@Override
	public void sentErrorMessage(String message, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message", message);
	}

	@Override
	public void sentMessage(String message, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("message",message);
	}

	@Override
	public UPDATE_RESULT updateMember(Member member) {
        if(validateUpdateMember(member) == VALIDATE_RESULT.��Ϣ��д������) {
        	return UPDATE_RESULT.��Ϣ��д������;
        }
        
		return null;
	}



	@Override
	public void cancelQualification(Member member) {
		// TODO Auto-generated method stub
		
	}

}

