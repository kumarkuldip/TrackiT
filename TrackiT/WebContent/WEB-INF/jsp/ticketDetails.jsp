<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@page import="com.trackit.ec.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Details</title>
<c:url value="/resources/css" var="cssURL"/>
<c:url value="/resources/js" var="jsURL"/>
<link rel="stylesheet" href="${cssURL}/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="${cssURL}/bootstrap.css"/>
<script src="${jsURL}/jquery-1.12.0.min.js"></script>
<script src="${jsURL}/jquery.dataTables.min.js"></script>
<script src="${jsURL}/dataTables.bootstrap.min.js"></script>

<script>
$(document).ready(function(){
	 $('#myTable').DataTable({
		 scrollY: 500,
		 paging: false
	 });
})
</script>
<style>
body{
	font: normal 12px Tahoma;
}
.textAreaClass{
	font: normal 12px Tahoma;
	color : blue;
	width:250px;
}
.tableContainer{
height:500px;
overflow-y:scroll;
padding-top:10px;
}
.markDone{
background-color: #e6e6e6;
}
</style>
</head>
<body>

<div class="container-fluid theme-showcase">
<form:form method="post" action="saveTickets.html" modelAttribute="ticketCommand"> 
<div class="col-lg-12">
<table id="myTable" class="table table-bordered table-hover table-condensed">
	<thead class="sorting">
		<tr>
			<td class="tableHeader" style="width:50px">Done</td>
			<td class="tableHeader" style="width:50px">Number</td>
			<td class="tableHeader" style="width:250px">Summary</td>
			<td class="tableHeader" style="width:50px">Status</td>
			<td class="tableHeader" style="width:75px">Priority</td>
			<td class="tableHeader" style="width:75px">Area</td>
			<td class="tableHeader" style="width:75px">Group</td>
			<td class="tableHeader" style="width:50px">AssignedTo</td>
			<td class="tableHeader" style="width:250px">Comment</td>
			<!-- <td class="tableHeader" style="width:50px">FrstUpload</td>
			<td class="tableHeader"style="width:50px">LstUpload</td> -->
			<td class="tableHeader" style="width:85px">CreatedOn</td>
			<td class="tableHeader"style="width:85px">UpdatedOn</td>
		</tr>
	</thead>
	<tbody>
		 <c:forEach items="${tickets.tickets}" var="ticket" varStatus="status">
			<tr <c:if test="${ticket.done}">class="markDone"</c:if>>
				<td><input type="checkbox" name="tickets[${status.index}].done" <c:if test="${ticket.done}">checked</c:if>/></td>
				   <td><a href="https://hclmt.service-now.com/honda/textsearch.do?&sysparm_view=text_search&sysparm_search=<c:out value="${ticket.ticketId}"/>" target=_blank>
				   ${ticket.ticketId}</a> <input type="hidden" name="tickets[${status.index}].ticketId" value="${ticket.ticketId}"/></td>
				   <td>${ticket.summary}</td>
				   <td>${ticket.status}</td>
				   <td>${ticket.priority}</td>
				   <td>${ticket.area}</td>
				   <td>${ticket.assignmentGroup}</td>
				   <td>${ticket.assignedTo}</td>
				   <td><textarea name="tickets[${status.index}].remark" class="textAreaClass">${ticket.remark}</textarea></td>
				   	<!--<c:set var="fullDate" value="${ticket.frstUploadDate}"/>
					<c:set var="frstUploadDate" value="${fn:substring(fullDate, 0, 10)}" />
				   <td>${frstUploadDate}</td>
				   	<c:set var="fullDate" value="${ticket.lstUploadDate}"/>
					<c:set var="lstUploadDate" value="${fn:substring(fullDate, 0, 10)}" />
				   <td>${lstUploadDate}</td>-->
				   <c:set var="fullDate" value="${ticket.createdOn}"/>
					<c:set var="createdOn" value="${fn:substring(fullDate, 0, 10)}" />
				   <td>${createdOn}</td>
				   <c:set var="fullDate" value="${ticket.updateOn}"/>
					<c:set var="updateOn" value="${fn:substring(fullDate, 0, 10)}" />
				   <td>${updateOn}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<div style="width:98%;float:right; margin-right:20px;"></div><input type="submit" value="Save" /></div>
<div style="clear:both"></div>
</form:form>
<!-- </form> -->
</div>  
</body>
</html>