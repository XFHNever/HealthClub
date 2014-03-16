<%@page import="edu.nju.healthclub.model.Member"%>
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
<% float balance = 0;
   Member member = (Member) request.getSession().getAttribute("user");
   if(member != null) {
	   balance = member.getBalance();
   }
%>
<title>Head</title>
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
	                    <li><s:a href="%{memhome_url}">Activity</s:a></li>
	                    <s:url var="pay_url" action="/getpayment"/>
	                    <li class="active"><s:a href="#">Pay</s:a></li>
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
				<h1 style="margin-top: 100px;">Pay</h1>
				<p style="margin-top: 25px;">您现在账户余额是￥<strong><%=balance %></strong>元，快点来充钱吧！！</p>

				
				<s:actionerror theme="bootstrap"/>
	            <s:actionmessage theme="bootstrap"/>
	            <s:fielderror theme="bootstrap" />
	            
	            <s:form id="validationForm" action="/pay" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" label="Fill in information here" >
	            	<s:textfield name="payment.cardid" label="银行卡号" tooltip="Enter your CardId here" requiredLabel="true"></s:textfield>
	            	<s:textfield name="payment.quantity" label="充值金额" tooltip="Enter your quantity here" requiredLabel="true"></s:textfield>
	            	
	            	<div class="form-actions">
	                    <sj:submit cssClass="btn btn-primary"/>
	                </div>
	            </s:form>
	            
	            <h1 style="margin-top: 50px;">Payment Records</h1>
				<table  class="table table-striped" style="margin-bottom: 100px;">
					<tr>
						<th>PaymentId</th>
						<th>PayDate</th>
						<th>CardId</th>
						<th>Quantity</th>
						
					</tr>
					<s:iterator value="m_payments">
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
	
	    <jsp:include page="/footer.jsp"/>

	</div>
</body>
</html>