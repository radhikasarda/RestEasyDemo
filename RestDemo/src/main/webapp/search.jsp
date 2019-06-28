<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD OPERATIONS</title>
</head>
<body>
	<form method="post">
		<center>
			<table border="1" cellpadding="4">
				<caption>
					<h2>Employee Details</h2>
				</caption>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Address</th>

				</tr>
				<c:forEach items="${detailList}" var="employeeDetail">
					<tr>
						<td><c:out value="${employeeDetail.id}" /></td>
						<td><c:out value="${employeeDetail.name}" /></td>
						<td><c:forEach items="${employeeDetail.phone}" var="phone">
								<c:out value="${phone.phone_number}" /></td>
						<td><c:out value="${employeeDetail.address.city}" />
				</c:forEach>
				</td>
				</tr>
				</c:forEach>
			</table>
		</center>
	</form>
	
	<form><center><a href="<%=request.getContextPath()%>">Back</a></center></form>
</body>
</html>