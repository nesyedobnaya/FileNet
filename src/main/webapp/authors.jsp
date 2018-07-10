<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="ru.grusha.exeption.DocumentExistsExeption, 
    ru.grusha.factory.Generator, ru.grusha.model.staff.Person,
    ru.grusha.storage.DocumentStorage, 
    ru.grusha.utils.DocumentType, 
    ru.grusha.utils.FactoryUtil, 
    ru.grusha.utils.JsonFileWriter, 
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
	<table id="t01">
		<tr>
			<th>ID</th>
			<th>Фамилия</th>
			<th>Имя</th>
			<th>Отчество</th>
			<th>Должность</th>
			<tr><td>a</td><td>a</td><td>a</td><td>a</td><td>a</td></tr>
			<tr><td>b</td><td>b</td><td>b</td><td>b</td><td>b</td></tr>
			<%
				Generator generator = new Generator();
				FactoryUtil.loadStaff();

				for (DocumentType type : DocumentType.values()) {
					try {
						generator.createDocument(type);
					} catch (DocumentExistsExeption ex) {
						System.out.println(ex.getMessage());
					}
				}

				TreeSet<Person> setOfAuthors = ReportUtil.authorsToSet(DocumentStorage.data);
				for (Person authorFromSet : setOfAuthors) {
					out.write("<tr>");
					out.write("<td>" + authorFromSet.getId() + "</td><td>" + authorFromSet.getLastName() + "</td><td>"
							+ authorFromSet.getFirstName() + "</td><td>" + authorFromSet.getPatronymic() + "</td><td>"
							+ authorFromSet.getPosition() + "</td>");
					out.write("</tr>");
				}
			%>
		
	</table>
</body>
</html>