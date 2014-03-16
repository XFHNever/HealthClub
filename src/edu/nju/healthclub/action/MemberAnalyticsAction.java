package edu.nju.healthclub.action;

import java.util.List;

import edu.nju.healthclub.model.MemberSex;
import edu.nju.healthclub.service.MemberService;

@SuppressWarnings("serial")
public class MemberAnalyticsAction extends BaseAction{
	private MemberService memberService;
	private double male;
	private double female;
	@Override
	public String execute() throws Exception {
		List list = memberService.getSex();
		male = 100 * ((MemberSex)list.get(0)).getCount()/(((MemberSex)list.get(0)).getCount() + ((MemberSex)list.get(1)).getCount());
		System.out.println("male" + male);
		female = 100 - male;
		if(((MemberSex)list.get(0)).getSex().equals("Female")) {
			female = male;
			male = 100- female;
			System.out.println("male" + male);
		}
		return "success";
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public double getMale() {
		return male;
	}
	public void setMale(double male) {
		this.male = male;
	}
	public double getFemale() {
		return female;
	}
	public void setFemale(double female) {
		this.female = female;
	}
	
	
}
