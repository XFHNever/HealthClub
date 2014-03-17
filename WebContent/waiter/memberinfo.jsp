<%@page import="edu.nju.healthclub.model.Member"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sb:head includeScripts="true" includeStyles="false" includeStylesResponsive="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-min.css">
<title>MemberInfo</title>
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
	                	   <s:url var="whome_url" action="/backwaiterhome"/>
	                    <li><s:a href="%{whome_url}">Activity</s:a></li>
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
	            <div style="margin-top: 100px;">
	            </div>
	            
	        </div>
	        <div class="span9">
		        <div class="tab-pane active" id="my-info">
		        	<h1 style="margin-top: 100px;">Member Info</h1>
					
					<s:actionerror theme="bootstrap"/>
		            <s:actionmessage theme="bootstrap"/>
		            <s:fielderror theme="bootstrap"/>
		            
				    <s:form id="validationForm" action="/register" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" label="Modify member Information" >
				        <s:textfield name="member.name" label="姓名" tooltip="Enter Member Name here" requiredLabel="true" value="%{member.name}"/>
				        <s:textfield name="member.password" label="密          码" tooltip="Enter Member password here" requiredLabel="true" value="%{member.password}"/>
				        <s:textfield name="member.balance" label="余额" tooltip="Enter Member balance here" requiredLabel="true" value="%{member.balance}"/>
				        <s:select list="{'Male','Female'}" name="member.sex" label="性别" tooltip="select your sex" requiredLabel="true" value="%{member.sex}"/>
				        <s:textfield name="member.address" label="地址" tooltip="Enter your address here" requiredLabel="true" value="%{member.address}"/>
				        <s:textfield name="member.age" label="年龄" tooltip="Enter your age here" requiredLabel="true" value="%{member.age}"/>
				      	<s:select list="{'USING','CANCEL','PAUSE','STOP','NOTACTIVE'}" label="状态" requiredLabel="true" value="%{member.state}"/>
				        <s:if test="member.type == '家庭'">
				        	<s:textfield name="member.childnum" label="子女数量" tooltip="Enter the number of your son or daughter here" requiredLabel="true" value="%{member.childnum}"/>
				        </s:if>
				        <h5>*以下信息不能修改*</h5>
				        <s:label label="卡号" value="%{member.memberid}"/>
				        <s:label label="类型" value="%{member.type}"/>

				        <div class="form-actions">
		                    <sj:submit cssClass="btn btn-primary"/>
		                </div>
				    </s:form>
				    
				    <h1 style="margin-top: 50px;">Participation Records</h1>
				    <table  class="table table-striped" >
						<tr>
							<th>SessionId</th>
							<th>Date</th>
							
						</tr>
						<s:iterator value="activities">
							<tr>
								
								<td><s:property value="sessionid"/></td>
								<td><s:property value="date"/></td>
							</tr>
						</s:iterator>
					</table>
					
					<h1 style="margin-top: 50px;">Payment Records</h1>
					<table  class="table table-striped" style="margin-bottom: 100px;">
						<tr>
							<th>PaymentId</th>
							<th>PayDate</th>
							<th>CardId</th>
							<th>Quantity</th>
							
						</tr>
						<s:iterator value="payments">
							<tr>
								<td><s:property value="paymentid"/></td>
								<td><s:property value="time"/></td>
								<td><s:property value="cardid"/></td>
								<td><s:property value="quantity"/></td>
							</tr>
						</s:iterator>
					</table>
		        </div>
		  
	        </div>
	    </div>
	
	    <jsp:include page="/footer.jsp"/>

	</div>
</body>
</html>