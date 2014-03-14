<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="false"/>
<sb:head includeScripts="true" includeStyles="false" includeStylesResponsive="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!--  -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">

<title>Register</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
		    <div class="span3"></div>
		    <div class="span9">
		        <h1>Health Club</h1>
		        <p>Your fitness expert,Welcome to join us!!</p>

		    
	            <s:actionerror theme="bootstrap"/>
	            <s:actionmessage theme="bootstrap"/>
	            <s:fielderror theme="bootstrap"/>
	            
			    <s:form id="validationForm" action="/register" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" label="Register" >
			        <s:textfield name="member.name" label="姓名" tooltip="Enter your Name here" requiredLabel="true"/>
			        <s:password name="passwordOne" label="密          码" tooltip="Enter your password here" requiredLabel="true" />
			        <s:password name="passwordTwo" label="确认密码" tooltip="Enter your confirm password here" requiredLabel="true" />
			        <s:select list="{'个人','家庭'}" label="类型" name="member.type" tooltip="select your acount type" value="个人" />
			        <s:select list="{'Male','Female'}" name="member.sex" label="性别" tooltip="select your sex" value="Male"/>
			        <s:textfield name="member.address" label="地址" tooltip="Enter your address here" requiredLabel="true"/>
			        <s:textfield name="member.age" label="年龄" tooltip="Enter your age here" requiredLabel="true"/>
			        <s:textfield name="member.childnum" label="子女数量" tooltip="Enter the number of your son or daughter here" requiredLabel="true" value="0"/>
			        
			        <div class="form-actions">
	                    <sj:submit cssClass="btn btn-primary" formIds="validationForm" validate="true" validateFunction="bootstrapValidation"/>
	                </div>
			    </s:form>
		    </div>
		    
		    <div style="margin-top: 30px;margin-left: 330px;margin-bottom: 100px;">
		    	<p>已有账号，马上去<a href="Login.jsp" style="font-weight: bold;">登录</a></p>
		    </div>
		    
		</div>
		
	    <jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>