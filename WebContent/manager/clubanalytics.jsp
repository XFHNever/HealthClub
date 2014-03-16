<%@page import="java.util.List"%>
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


<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
        $('#daily').highcharts({
            title: {
                text: 'Daily Members',
                x: -20 //center
            },
            subtitle: {
                text: 'Source: by never',
                x: -20
            },
            xAxis: {
                categories:  [<s:property value="datelist"/>]
            },
            yAxis: {
                title: {
                    text: '人数 (人)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '人'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: 'Members',
                data: [<s:property value="numberlist"/>]
                	//[<s:iterator value="day_members" var="dm"><s:property value="#dm.count"/>,</s:iterator>,<s:property value="day_end.count"/>]
            }]
        });
    });
</script>
<title>ClubAnalytics</title>
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
	                	<s:url var="managerhome_url" action="/backmanagerhome"/>
	                    <li><s:a href="%{managerhome_url}">Home</s:a></li>
	                    <s:url var="club_url" action="/clubanalytics"/>
	                    <li  class="active"><s:a href="%{club_url}">Club Analytics</s:a></li>
	                    <s:url var="member_url" action="/memberanalytics"/>
	                    <li><s:a href="%{member_url}">Member Analytics</s:a></li>
	                    
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
		        <h1 style="margin-top: 100px;">Daily Member</h1>
				
				<script src="<%=request.getContextPath() %>/js/highcharts.js"></script>
				<script src="<%=request.getContextPath() %>/js/modules/exporting.js"></script>
				
				<div id="daily" style="min-width: 200px; height: 300px; margin-bottom50px; margin: 0 auto">
				</div>


	        </div>
	    </div>
	
	    <jsp:include page="/footer.jsp"/>

	</div>				
</body>
</html>