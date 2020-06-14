<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<b>Students List</b>
<table border=1>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Address</th>
	</tr>
	<c:forEach items="${students}" var="student">
		<tr>
			<td>${student.id}</td>
			<td>${student.name}</td>
			<td>${student.address}</td>
		</tr>
	</c:forEach>
</table>
