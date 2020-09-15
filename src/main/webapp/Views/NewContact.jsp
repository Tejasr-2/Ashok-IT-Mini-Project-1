<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>PhoneBook - Add Contact</title>
<style>
.column {
    text-align: center;
    width: 70%;
    padding: 5px;
    text-decoration: underline;
}
.center {
  max-width: 350px;
  margin: auto;
  padding: 10px;
  text-align: center;
  
}
.content {
  max-width: 900px;
  margin: auto;
  background: white;
  padding: 30px;
  text-align: center;
  position: relative;
  zoom: 150%;
}



</style>
</head>

<body>
<div class="content">
<h1 align ="center" style="font-size: 50px;"> Add Contact</h1>
<hr>
<font color="green">${contactSaved}</font>
<font color="red">${contactSaveFail}</font>
<form:form   class = "center form-horizontal" action = "saveContact" method="POST" modelAttribute="contact" >
<form:input type = "hidden" path="contactId" />
<table>
<tr >
<td style="font-size: 20px; padding: 10px;">Name :</td>
<td><form:input type = "text" path="contactName" required="required"/></td>
</tr>
<tr>
<td style="font-size: 20px; padding: 10px;">Email:</td>
<td><form:input type = "text" path="contactEmail" required="required"/></td>
</tr>
<tr>
<td style="font-size: 20px; padding: 10px;">Phone Number:</td>
<td><form:input  path="contactNum" required="required"/></td>
</tr>
<tr>
<td></td>
<td><br><input class="btn btn-primary" type = "submit" value = "Save Contact"/></td>
</tr>
</table>

</form:form>

<br>
<a class="btn btn-primary" href="/ViewAllContacts" >  View All Contacts</a>
</div>
</body>
</html>