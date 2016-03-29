<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Ticket Data</title>
<c:url value="/resources/css" var="cssURL"/>
 <link rel="stylesheet" href="${cssURL}/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="${cssURL}/bootstrap.css"/>
</head>
<body>
	<div class="container theme-showcase">
		<div class="col-md-6">
           <form action="tickets.html" method="post">
           <button type="submit" class="btn btn-xs btn-primary">Show Tickets</button>
          </form>
          <h3> Choose File to Upload in Server </h3>
          <form:form action="uploadExcel.html" modelAttribute="excelCommand" method="post" enctype="multipart/form-data">
          <span class="col-md-8" style="padding-top:5px"> 
          	Select file<br/><br/>
        	<input name="fileData" type="file"/>
        	<input type="submit" class="btn btn-xs btn-primary" value="Upload"/>
          </span>
             <span class="col-md-8"> Project Name: <input type="text" value="" class="form-control"/>
              Date: <input type="text" value="" class="form-control"/></span>
          </form:form>
        </div><!--col-md-6-->
        
        <div class="col-md-6">
           <form:form action="myTickets.html" modelAttribute="ticket" method="post" >
           <input type="text" name="assignedTo" />
           <button type="submit" class="btn btn-xs btn-primary">Show My Tickets</button>
          </form:form>
        </div><!--col-md-6-->
        
        
      </div><!-- container theme-showcase -->
</body>
</html>