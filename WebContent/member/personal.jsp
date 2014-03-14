<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sb:head includeScripts="true" includeStyles="false" includeStylesResponsive="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap-superhero.css">

<title>Head</title>
</head>
<body>
    <s:form action="/addnewactivity"></s:form>
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
	                    <li><s:a href="%{pay_url}">Pay</s:a></li>
	                    <s:url var="personal_url" action="/getpersonalinfo"/>
	                    <li class="active"><s:a href="#">Personal</s:a></li>
	                    
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
	            <ul class="nav nav-pills nav-stacked" id="myTab">
                          <li class="active"><a href="#my-info"  data-toggle="pill">personal information</a></li>
                          <li><a href="#my-activity" data-toggle="pill">activity record</a></li>
                          <li><a href="#my-pay" data-toggle="pill">payment record</a></li>
                </ul>
	        </div>
	        <div class="span9">
		        <div class="tab-pane active" id="my-info">
		        	<h1 style="margin-top: 100px;">Personal Info</h1>
					
					
		        </div>
		        <div class="tab-pane active" id="my-activity">
		        	<h1 style="margin-top: 100px;">Personal Center</h1>
		        </div>
		        <div class="tab-pane active" id="my-pay">
		        </div>
				
	        </div>
	    </div>
	
	    <jsp:include page="/footer.jsp"/>

	</div>
</body>
</html>