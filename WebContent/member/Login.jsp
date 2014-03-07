<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <br/>
    <s:form action="/login">
        <s:textfield 
        name="memberid" label="会员ID" />
        <s:textfield name="password" label="密码"/>
        
        <s:submit value="登陆"/>
    </s:form>
    
</body>
</html>