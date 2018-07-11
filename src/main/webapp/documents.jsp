<%@page
	import="ru.grusha.utils.FormatUtil,
	ru.grusha.model.staff.Person,
    ru.grusha.storage.DocumentStorage,  
    ru.grusha.utils.ReportUtil,
    java.util.TreeSet,
    java.util.List,
    ru.grusha.model.documents.Document,
	ru.grusha.model.staff.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Документы</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		/*
		int id = Integer.valueOf(session.getAttribute("authorId").toString());
		out.write(id);
		out.write(session.getAttribute("authorId").toString());
		*/
	%>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Название</th>
				<th>Дата регистрации</th>
				<th>Регистрационный номер</th>
			<%
				Person author = ReportUtil.authorsToSet(DocumentStorage.data).first();
				List<Document> documentsOfAuthor = ReportUtil.getDocumentsOfAuthor(DocumentStorage.data, author);
				for (Document document : documentsOfAuthor) {
			%>
			<tr onclick="location.href='documentContent.jsp'">
				<%
					out.write("<td>" + document.getId() + "</td><td>" + document.getName() + "</td><td>"
								+ FormatUtil.formatDate(document.getRegistrationDate()) + "</td><td>"
								+ document.getRegistrationNumber() + "</td>");
						out.write("</tr>");
					}
				%>
			
		</table>
	</div>
</body>
</html>