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

<form action="<%=request.getContextPath() %>/update?id=<c:out value='${employeeDetails.id}' />" method="post" >
<center>
      <table border="1" width="50%" cellpadding="5">
      <thead>
                    <tr>
                        <th colspan="2">Edit Employee Details Here</th>
                    </tr>
        </thead>
        <tbody>
        
        <tr>
          <td>Name</td>
          <td><input type="text" name="updatedName" value= "${employeeDetails.name}" maxlength="15" required/></td>
        </tr>
     	 
        <tr>
          <td>Contact No</td>
          <td><input type="text" name="updatedContact" value="${employeeDetails.phone[0].phone_number}" maxlength="10" required/></td>
        </tr>
      
        <tr>
          <td>City</td>
          <td><input type="text" name="updatedCity" value="${employeeDetails.address.city}" maxlength="15" required/></td>
        </tr>
          
        </tbody>
      </table> 
      <input type="submit" value="Submit" name="button" action="<%=request.getContextPath() %>"/> 

      
      
      
</center>
</form>

</body>
</html>
      