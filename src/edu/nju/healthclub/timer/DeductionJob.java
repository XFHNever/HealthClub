package edu.nju.healthclub.timer;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import edu.nju.healthclub.model.Member;
import edu.nju.healthclub.service.MemberService;
import edu.nju.healthclub.service.enuminfo.MEMBER_STATE;


public class DeductionJob extends QuartzJobBean{
	private MemberService memberService;
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		List list = memberService.getAll();
		for(int i = 0; i < list.size(); i++) {
			Member member = (Member) list.get(i);
			if(member.getType().equals("Personal")) {
				if(member.getBalance() < 40) {
					if(member.getState().equals(MEMBER_STATE.USING)) {
						member.setState(MEMBER_STATE.PAUSE.toString());
					} else if(member.getState().equals(MEMBER_STATE.PAUSE)) {
						if(member.getBreaktime() < 6){
							member.setBreaktime(member.getBreaktime() + 1);
						} else {
							member.setState(MEMBER_STATE.STOP.toString());
						}
					} 
				} else {
					member.setBalance(member.getBalance() - 40);
				}
			} else {
				if(member.getBalance() < (55 + 10*member.getChildnum())) {
					if(member.getState().equals(MEMBER_STATE.USING)) {
						member.setState(MEMBER_STATE.PAUSE.toString());
					} else if(member.getState().equals(MEMBER_STATE.PAUSE)) {
						if(member.getBreaktime() < 6){
							member.setBreaktime(member.getBreaktime() + 1);
						} else {
							member.setState(MEMBER_STATE.STOP.toString());
						}
					} 
				} else {
					member.setBalance(member.getBalance() - 40 - member.getChildnum() * 10);
				}
			}
			
			memberService.updateMember(member);
		}
		System.out.println("Deduction.");
	}
	public MemberService getMemberService() {
		return memberService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

}
