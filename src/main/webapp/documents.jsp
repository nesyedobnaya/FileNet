<%@page
	import="ru.grusha.utils.FormatUtil,
	ru.grusha.model.staff.Person,
    ru.grusha.storage.DocumentStorage,  
    ru.grusha.utils.ReportUtil,
    java.util.TreeSet,
    java.util.List,
    java.util.ArrayList,
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
	<form method="post" action="GetDocumentById" id="myform">
		<INPUT type="hidden" id="documentInputId" name="documentId" value="">
	</form>
		<table id="tableDocuments">
			<tr>
				<th>ID</th>
				<th>Название</th>
				<th>Дата регистрации</th>
				<th>Регистрационный номер</th>
				<%
					String chosenAuthorId = (String) request.getAttribute("chosenAuthorId");
					//out.write(chosenAuthorId);
					int authorId = Integer.parseInt(chosenAuthorId);
					//out.write(authorId + "");
					List<Document> documentsOfAuthor = new ArrayList<Document>();
					for (Document documentFromStorage : DocumentStorage.data) {
						if (authorId == documentFromStorage.getAuthor().getId()) {
							documentsOfAuthor.add(documentFromStorage);
							//out.write(documentFromStorage.toString());
						}
					}
					for (Document document : documentsOfAuthor) {
				%>
			
			<tr onclick="setParameter(this)">
				<%
					out.write("<td>" + document.getId() + "</td><td>" + document.getName() + "</td><td>"
								+ FormatUtil.formatDate(document.getRegistrationDate()) + "</td><td>"
								+ document.getRegistrationNumber() + "</td>");
						out.write("</tr>");
					}
				%>
			
		</table>
		<a href="author.jsp">Назад</a>
</body>
<script type="text/javascript">
	function setParameter(x) {
		var table = document.getElementById('tableDocuments');
		document.getElementById('documentInputId').value = table.rows[x.rowIndex].cells[0].innerHTML;
		//alert(document.getElementById('documentInputId').value);
		var form = document.getElementById('myform');
		form.submit();
	}
</script>
</html>