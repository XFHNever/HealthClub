<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sb:head/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--  
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
-->
<title>Login</title>
</head>
<body>
    <s:actionerror theme="bootstrap"/>
    <s:actionmessage theme="bootstrap"/>
    <s:fielderror theme="bootstrap"/>
    
    <br/>
    <s:form action="/login" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" >
        <s:textfield name="memberid" label="会员ID" tooltip="Enter your Id here"/>
        <s:textfield name="password" label="密          码" tooltip="Enter your password here" />
        
        <s:submit value="登陆" cssClass="btn"/>
    </s:form>
    
</body>
</html>