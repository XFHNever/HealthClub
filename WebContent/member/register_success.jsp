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

<title>Register Success</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3"></div>
		    <div class="span9">
		        <h1>Health Club</h1>
		        <p>Your fitness expert</p>
		        
	        </div>
			      
			<div style="margin-top: 200px;margin-left: 240px;margin-bottom: 100px;">
				<p>   啊哈哈！恭喜你<s:property  value="member.type" />号注册成功,ID是<s:property value="memberid"/>。快点去<a href="member/Login.jsp" style="font-weight: bold;">登录</a>吧</p>
			</div>    
		</div>
		
	    <jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>