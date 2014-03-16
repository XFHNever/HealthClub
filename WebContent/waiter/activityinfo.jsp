<%@page import="edu.nju.healthclub.model.Member"%>
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

<title>ActivityInfo</title>
</head>
<body>
  <div class="navbar navbar-fixed-top" >
	    <div class="navbar-inner">
	        <div class="container">
	            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	                <span class="i-bar"></span>
	                <span class="i-bar"></span>
	                <span class="i-bar"></span>
	            </a>
	            <a class="brand" href="#">Health Club Member </a>
	
	            <div class="nav-collapse">
	                <ul class="nav">
	                    <s:url var="memhome_url" action="/getactivity"/>
	                    <li><s:a href="#">Activity</s:a></li>
	                    <s:url var="pay_url" action="/getpayment"/>
	                    <li><s:a href="%{pay_url}">Pay</s:a></li>
	                    <s:url var="personal_url" action="/getpersonalinfo"/>
	                    <li><s:a href="%{personal_url}">Personal</s:a></li>
	                    
	                </ul>
	            </div>
	            <!--/.nav-collapse -->
	        </div>
	    </div>
	</div>	
	<div class="container-fluid">
	    <div class="row-fluid">
	        <div class="span3">
	        </div>
	        <div class="span9">
				<h1 style="margin-top: 100px;">Activity:<s:property value="activity.name"/></h1>
				<s:label value="%{activity.id}" label="活动ID："></s:label>
				<s:label value="%{activity.field}" label="场地："></s:label>
				<s:label value="%{activity.coachid}" label="教练ID："></s:label>
				
				<div style="height: 50px;margin-top: 10px;"></div>
				<s:text name="场次信息：" ></s:text>
				<table  class="table table-striped" >
					<tr>
						<th>SessionID</th>
						<th>ActivityId</th>
						<th>Date</th>
					</tr>
					<s:iterator value="sessions" id="s">
						<tr>
							<td><s:property value="sessionid"/></td>
							<td><s:property value="activityid"/></td>
							<td><s:property value="time"/></td>
						</tr>
					</s:iterator>
				</table>
	        </div>
	    </div>
	
	    <jsp:include page="/footer.jsp"/>

	</div>

</body>
</html>