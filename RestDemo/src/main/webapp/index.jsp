<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD OPERATIONS</title>
</head>
<body>


<form action="<%=request.getContextPath() %>/add" method="post" name="insertForm">
<center>
      <table border="1" width="50%" cellpadding="5">
      <thead>
                    <tr>
                        <th colspan="2">Enter Employee Details Here</th>
                    </tr>
        </thead>
        <tbody>
        <tr>
          <td>Name</td>
          <td><input type="text" name="name" maxlength="15" required/></td>
        </tr>
      
        <tr>
          <td>Contact No 1:</td>
          <td><input type="text" name="contact" maxlength="10" required/></td>
          
        </tr>
        <tr><td>Contact No 2:</td><td><input type="text" name="contact" maxlength="10" /></td></tr>
        <tr>
          <td>City</td>
          <td><input type="text" name="city" maxlength="15" required/></td>
        </tr>
        
        </tbody>
      </table> 
      <input type="submit" value="Submit" name="button" /> 

      
      
      <table border="1" cellpadding="4">
            <caption><h2>List of Employee</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Phone 1</th>
                
                <th>Address</th>
                
            </tr>
            <c:forEach items="${listEmployee}" var="employee" >
                <tr>
                    <td><c:out value="${employee.id}" /></td>
                    <td><c:out value="${employee.name}" /></td>
                    <td><c:forEach items="${employee.phone}" var="phone"><c:out value="${phone.phone_number}" /></td>
                    <td><c:out value="${employee.address.city}" /></c:forEach></td>
                    
                    <td>
                     <a href="<%=request.getContextPath() %>/edit?id=<c:out value='${employee.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="<%=request.getContextPath() %>/delete?id=<c:out value='${employee.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
      

      
      
      </center>
    </form>
          <form action="<%=request.getContextPath() %>/search" method="post" name="searchForm">
      <center>
      <table border="1" cellpadding="2">
      <caption><h2>Search Users</h2></caption>
      <tr>
                <td>Search By Name</td>
                <td><input type="text" name="searchedName" maxlength="15" required/></td>
                <td><input type="submit" value="Submit" name="button" /> </td>
      </tr>
      </table>
      </center>
      </form>
</body>
</html>