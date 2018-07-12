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
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form method="post" action="GetAuthorById" id="myform">
		<INPUT type="hidden" id="authorInputId" name="authorId" value="">
	</form>
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
						out.write("<td>" + authorFromSet.getId() + "</td><td>" + authorFromSet.getLastName() + "</td><td>"
								+ authorFromSet.getFirstName() + "</td><td>" + authorFromSet.getPatronymic() + "</td><td>"
								+ authorFromSet.getPosition() + "</td>");
						out.write("</tr>");
					}
				%>
		
	</table>
</body>
<script type="text/javascript">
function setParameter(x) {
	    var table = document.getElementById('tableAuthors');
	    document.getElementById('authorInputId').value=table.rows[x.rowIndex].cells[0].innerHTML;
	    //alert(document.getElementById('authorInputId').value);
	    var form = document.getElementById('myform');
	    form.submit();
}
</script>
</html>