<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="ru.grusha.exeption.DocumentExistsExeption, 
    ru.grusha.factory.Generator, 
    ru.grusha.utils.DocumentType, 
    ru.grusha.utils.FactoryUtil, 
    java.util.TreeSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Index</title>
</head>
<body>
	<%
				Generator generator = new Generator();
				FactoryUtil.loadStaff();

				for (DocumentType type : DocumentType.values()) {
					try {
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
						generator.createDocument(type);
					} catch (DocumentExistsExeption ex) {
						System.out.println(ex.getMessage());
					}
				}
				%>
	<a href="author.jsp">Aвторы документов</a>
</body>
</html>