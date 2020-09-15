<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone Book View All Contacts</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.column {
    text-align: right;
    width: 30%;
    padding: 5px;
    text-decoration: underline;
}
.center {
  margin: auto;
  width: 60%;
  text-align: center;
}

</style>
</head>
<body>


<div class="center">
<h1 align ="center">All Contacts</h1>
<hr>
<font color="green" style="text-align: center">${DeleteSuccessfull}</font>
<font color="red">${DeleteFailed}</font></div>
<div class="column" style ="font-size: 30px"><a href = "/addContact" >Add Contact +</a></div>


<table class="table table-bordered table-striped table-hover center">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Contact Id</th>
      <th scope="col">Contact Name</th>
      <th scope="col">Contact Email</th>
      <th scope="col">Phone Number</th>
      <th scope="col">Operations</th>
    </tr>
  </thead>
  <tbody> 
    <c:forEach items ="${allcontacts}" var="contact">
    	<tr>
    	<th>${contact.contactId}</th>
    	<td>${contact.contactName}</td>
    	<td>${contact.contactEmail}</td>
    	<td>${contact.contactNum}</td>
    	<td><a class="btn btn-primary" href="/editContact?cid=${contact.contactId}" role="button">Edit</a>
    	<a class="btn btn-danger" href="/deleteContact?cid=${contact.contactId}" role="button" onclick="return confirm('Are you sure? \nYou want to Delete ${contact.contactName}')">Delete</a> </td>
    	</tr>
    </c:forEach>
  </tbody>
</table>






</body>
</html>