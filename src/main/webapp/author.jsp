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
<title>Авторы документов</title>
<script type="text/javascript">
function setParameter(x) {
	location.href='documents.jsp';
	var rowNumber=x.rowIndex();
	var table = document.getElementById("tableAuthors");
	var neededCell="1";
	neededCell=table.rows[rowNumber].cells[0];
	<%
/*
	String id = "2";
			try {
				id = request.getParameter("neededCell");
				out.print(id);
			
			session.setAttribute("authorId", id);
			String idp = (session.getAttribute("authorId").toString());
			out.write(idp);
			out.write(session.getAttribute("authorId").toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			*/
%>
}
</script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div>
		<table id="tableAuthors">
			<tr>
				<th>ID</th>
				<th>Фамилия</th>
				<th>Имя</th>
				<th>Отчество</th>
				<th>Должность</th>
			<%
				
				TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
				for (Person authorFromSet : setOfAuthors) {
			
					out.write("<tr onclick='setParameter(this)'>");
			
					//session.setAttribute("authorId", authorFromSet.getId());
						//int id = Integer.valueOf(session.getAttribute("authorId").toString());
						//out.write(id);
						//out.write(session.getAttribute("authorId").toString());
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