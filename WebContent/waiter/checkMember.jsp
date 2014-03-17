<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sb:head includeScripts="true" includeStyles="false" includeStylesResponsive="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-min.css">
<title>CheckMember</title>
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
	            <a class="brand" href="#">Health Club--Waiter </a>
	
	            <div class="nav-collapse">
	                <ul class="nav">
	                     <s:url var="whome_url" action="/backwaiterhome"/>
	                    <li ><s:a href="%{whome_url}">Activity</s:a></li>
	                    <s:url var="member_url" action="/checkmember"/>
	                    <li class="active"><s:a href="%{member_url}">Member</s:a></li>
	                    <s:url var="logout_url" action="/logout"/>
	                    <li><s:a href="%{logout_url}">Logout</s:a></li>
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
				<h1 style="margin-top: 100px;">Members</h1>
				<table  class="table table-striped" >
					<tr>
						<th>MemberId</th>
						<th>Name</th>
						<th>Password</th>
						<th>Balance</th>
						<th>Age</th>
						<th>Sex</th>
						<th>Type</th>
						<th>Address</th>
						<th>State</th>
						<th>More</th>
					</tr>
					<s:iterator value="members" var="m">
						<tr>
							<td><s:property value="memberid"/></td>
							<td><s:property value="name"/></td>
							<td><s:property value="password"/></td>
							<td><s:property value="balance"/></td>
							<td><s:property value="age"/></td>
							<td><s:property value="sex"/></td>
							<td><s:property value="type"/></td>
							<td><s:property value="address"/></td>
							<td><s:property value="state"/></td>
							<td><a href="<s:url action="/memberinfo">
								<s:param name="memberid" value="#m.memberid"></s:param>
							</s:url>">More</a></td>
						</tr>
					</s:iterator>
				</table>
	        </div>
	    </div>
	
	    <jsp:include page="/footer.jsp"/>

	</div>
</body>
</html>