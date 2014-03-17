package edu.nju.healthclub.action;

public class LogoutAction extends BaseAction{
	@Override
	public String execute() throws Exception {
		this.request().getSession().setAttribute("user", null);
		System.out.println("logout");
		return "success";
	}
}
