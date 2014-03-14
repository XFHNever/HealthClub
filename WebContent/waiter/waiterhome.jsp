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
<title>WaiterHome</title>
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
	                    <s:url var="home_url" action="home"/>
	                    <li class="active"><s:a href="%{home_url}">Activity</s:a></li>
	                    <s:url var="pay_url" action="pay"/>
	                    <li><s:a href="%{pay_url}">Record</s:a></li>
						<s:url var="personal_url" action="personal"/>
	                    <li><a href="%{personal_url}">Personal</a></li>
	                    
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
				<h1 style="margin-top: 100px;">Add A New Activity</h1>
				<s:actionerror theme="bootstrap"/>
	            <s:actionmessage theme="bootstrap"/>
	            <s:fielderror theme="bootstrap" />
	            
			    <s:form id="validationForm" action="/addnewactivity" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal" label="Fill in the information about activity" >
			        <s:textfield name="activity.name" label="活动名称" tooltip="Enter your Name here" requiredLabel="true"/>
			        <s:textfield name="activity.field" label="活动场地" tooltip="Enter your Field here" requiredLabel="true" />
			        <s:textfield name="activity.coachid" label="活动教练ID" tooltip="Enter your Coachid here" requiredLabel="true" />
			        <div class="form-actions">
	                    <sj:submit cssClass="btn btn-primary" formIds="validationForm" validate="true" validateFunction="bootstrapValidation"/>
	                </div>
			    </s:form>
				
				<h1 style="margin-top: 50px;">Existing Activities</h1>
				<table  class="table table-striped" >
					<tr>
						<th>ActivityNameId</th>
						<th>ActivityName</th>
						<th>ActivityField</th>
						<th>AvtivityCoach</th>
						<th>More</th>
					</tr>
					<s:iterator value="activities">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="name"/></td>
							<td><s:property value="field"/></td>
							<td><s:property value="coachid"/></td>
							<td><s:a href="">more</s:a>
						</tr>
					</s:iterator>
				</table>
	        </div>
	    </div>
	
	    <jsp:include page="/footer.jsp"/>

	</div>
</body>
</html>