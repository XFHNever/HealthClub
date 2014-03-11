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

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">

<title>Login</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
		    <div class="span3"></div>
		    <div class="span9">
		        <h1>Health Club</h1>
		        <p>Your fitness expert</p>
			    
		    
	            <s:actionerror theme="bootstrap"/>
	            <s:actionmessage theme="bootstrap"/>
	            <s:fielderror theme="bootstrap" />
	            
			    <s:form id="validationForm" action="/login" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" label="Login" >
			        <s:textfield name="memberid" label="会员ID" tooltip="Enter your Id here" requiredLabel="true"/>
			        <s:password name="password" label="密          码" tooltip="Enter your password here" requiredLabel="true" />
			        
			        <div class="form-actions">
	                    <sj:submit cssClass="btn btn-primary" formIds="validationForm" validate="true" validateFunction="bootstrapValidation"/>
	                </div>
			    </s:form>
		    </div>
		    
		    <div style="margin-top: 30px;margin-left: 330px;margin-bottom: 100px;">
		    	<p>还没有账号，马上去<a href="register.jsp" style="font-weight: bold;">注册</a></p>
		    </div>
		</div>
		
	    <jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>