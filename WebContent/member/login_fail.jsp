<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head/>
<sb:head/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">

<title>login fail</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3"></div>
		    <div class="span9">
		        <h1>Health Club</h1>
		        <p>Your fitness expert</p>
		        <%
					String message=null;
					if((message=(String)request.getAttribute("message"))!=null)
						out.println("<p style='color:red;'>" + message + "</p>");
				%>
	        </div>
			      
			<div style="margin-top: 30px;margin-left: 250px;margin-bottom: 100px;">
				   <p>唉。。还是回去<a href="member/Login.jsp" style="font-weight: bold;">登录</a>吧</p>
			</div>    
		</div>
		
	    <jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>