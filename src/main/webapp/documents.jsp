<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="ru.grusha.model.staff.Person,
    ru.grusha.storage.DocumentStorage,  
    ru.grusha.utils.ReportUtil,
    java.util.TreeSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Документы</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Фамилия</th>
				<th>Имя</th>
				<th>Отчество</th>
				<th>Должность</th>
			<tr onclick="location.href='link.com'">
				<td>a</td>
				<td>a</td>
				<td>a</td>
				<td>a</td>
				<td>a</td>
			</tr>
			<tr onclick="location.href='link.com'">
				<td>b</td>
				<td>b</td>
				<td>b</td>
				<td>b</td>
				<td>b</td>
			</tr>
			<%
				TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
				for (Person authorFromSet : setOfAuthors) {
			%>
			<tr onclick="location.href='link.com'">
				<%
					out.write("<td>" + authorFromSet.getId() + "</td><td>" + authorFromSet.getLastName() + "</td><td>"
								+ authorFromSet.getFirstName() + "</td><td>" + authorFromSet.getPatronymic() + "</td><td>"
								+ authorFromSet.getPosition() + "</td>");
						out.write("</tr>");
					}
				%>
			
		</table>
	</div>
</body>
</html>