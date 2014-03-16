<%@page import="edu.nju.healthclub.model.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true"/>
<sb:head includeScripts="true" includeStyles="false" includeStylesResponsive="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">

<title>AddSessions</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
		    <div class="span3"></div>
		    <div class="span9">
		        <h1>New Activity:  <s:property value="activityid"/></h1>
		        <p>Add some Sessions</p>
			    
		    
	            <s:actionerror theme="bootstrap"/>
	            <s:actionmessage theme="bootstrap"/>
	            <s:fielderror theme="bootstrap" />
	            
			    <s:form id="validationForm" action="/addnewsession"  enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" label="New Session" >
			      	<s:textfield name="aid" label="activityid" value="%{activityid}" readonly="true" />
			      	<sj:datepicker name="time"  parentTheme="bootstrap" label="Date" tooltip="Tooltip for Datepicker"/>
			        <div class="form-actions">
	                    <sj:submit cssClass="btn btn-primary"  id="add" value="Add Session"/>
	                </div>
			    </s:form>
			    
			    <div style="margin-top: 30px;margin-left: 200px;margin-bottom: 100px;">
			    	<s:url action="/completeadd" var="backtoactivity"></s:url>
		    		<p>不再添加新的场次，<s:a href="%{backtoactivity}">返回活动页面</s:a></p>
		    	</div>
		    </div>
		    
		    
		</div>
		
	    <jsp:include page="../footer.jsp"/>
	</div>
</body>
</html>